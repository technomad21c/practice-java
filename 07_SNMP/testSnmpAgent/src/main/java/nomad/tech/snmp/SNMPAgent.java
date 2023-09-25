package nomad.tech.snmp;

import nomad.tech.snmp.mib.ShabodiMib;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.snmp4j.Snmp;
import org.snmp4j.agent.*;
import org.snmp4j.agent.mo.DefaultMOFactory;
import org.snmp4j.agent.mo.MOFactory;
import org.snmp4j.agent.mo.snmp.*;
import org.snmp4j.agent.security.MutableVACM;
import org.snmp4j.mp.MPv3;
import org.snmp4j.security.SecurityLevel;
import org.snmp4j.security.SecurityModel;
import org.snmp4j.security.USM;
import org.snmp4j.smi.Integer32;
import org.snmp4j.smi.OID;
import org.snmp4j.smi.OctetString;
import org.snmp4j.smi.Variable;
import org.snmp4j.transport.DefaultUdpTransportMapping;

import java.io.File;
import java.io.IOException;
import java.net.SocketException;

public class SNMPAgent extends BaseAgent {
    private static final Logger logger = LoggerFactory.getLogger(SNMPAgent.class);
    public ShabodiMib shabodiMib;
    private Snmp snmp;
    private String context = "public";

    public SNMPAgent(String address) throws SocketException {
        super(new File("conf.agent"), new File("bootCounter.agent"),
                new CommandProcessor
                        (new OctetString(MPv3.createLocalEngineID())));
        this.server = new DefaultMOServer();
        this.snmp = new Snmp(new DefaultUdpTransportMapping());
    }

    public MOFactory getFactory() {
        return DefaultMOFactory.getInstance();
    }

    @Override
    public void registerManagedObjects() {
        try {
            this.shabodiMib =  new ShabodiMib(getFactory());
            shabodiMib.registerMOs(this.server, new OctetString(context));
        } catch (DuplicateRegistrationException e) {
            throw new RuntimeException(e);
        }
    }

    public void registerManagedObject(ManagedObject mo){
        try{
        server.register(mo,null);
        }catch (DuplicateRegistrationException ex){
        throw new RuntimeException(ex);
        }
    }

    @Override
    protected void unregisterManagedObjects() {
        shabodiMib.unregisterMOs(this.server,new OctetString(context));
    }

    public void unregisterManagedObject(ManagedObject mo){
        server.unregister(mo,null);
    }

    @Override
    protected void registerSnmpMIBs() {
    }

    @Override
    protected void addUsmUser(USM usm) {
        // DO Nothing HERE
    }

    @Override
    protected void addNotificationTargets(SnmpTargetMIB snmpTargetMIB, SnmpNotificationMIB snmpNotificationMIB) {
        // DO NOTHING HERE
    }

    @Override
    protected void addViews(VacmMIB vacm) {

        vacm.addGroup(SecurityModel.SECURITY_MODEL_SNMPv2c, new OctetString(
                        "cpublic"), new OctetString("v1v2group"),
                StorageType.nonVolatile);

        vacm.addAccess(new OctetString("v1v2group"), new OctetString(context),
                SecurityModel.SECURITY_MODEL_ANY,
                SecurityLevel.NOAUTH_NOPRIV,
                MutableVACM.VACM_MATCH_EXACT,
                new OctetString("fullReadView"),
                new OctetString("fullWriteView"),
                new OctetString("fullNotifyView"),
                StorageType.nonVolatile);

        vacm.addViewTreeFamily(new OctetString("fullReadView"), new OID("1.3"),
                new OctetString(), VacmMIB.vacmViewIncluded,
                StorageType.nonVolatile);

        vacm.addViewTreeFamily(new OctetString("fullWriteView"), new OID("1.3"),
                new OctetString(), VacmMIB.vacmViewIncluded,
                StorageType.nonVolatile);
        vacm.addViewTreeFamily(new OctetString("fullNotifyView"), new OID("1.3"),
                new OctetString(), VacmMIB.vacmViewIncluded,
                StorageType.nonVolatile);
    }

    /**
     * Adds community to security name mappings needed for SNMPv1 and SNMPv2c.
     */
    @Override
    protected void addCommunities(SnmpCommunityMIB communityMIB) {
        Variable[] com2sec = new Variable[] {
                new OctetString(context),
                new OctetString("cpublic"), // security name
                getAgent().getContextEngineID(), // local engine ID
                new OctetString(context), // default context name
                new OctetString(), // transport tag
                new Integer32(StorageType.nonVolatile), // storage type
                new Integer32(RowStatus.active) // row status
        };
        SnmpCommunityMIB.SnmpCommunityEntryRow row = communityMIB.getSnmpCommunityEntry().createRow(
                new OctetString("public2public").toSubIndex(true), com2sec);
        communityMIB.getSnmpCommunityEntry().addRow(row);
    }


    /**
     * Start method invokes some initialization methods needed to start the
     * agent
     */
    public void start() throws IOException {
        init();
        registerManagedObjects();
        addShutdownHook();
        getServer().addContext(new OctetString(context));
        finishInit();
        run();
    }
}

