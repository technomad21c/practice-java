package nomad.tech.snmp.mib;

import org.snmp4j.agent.DuplicateRegistrationException;
import org.snmp4j.agent.MOGroup;
import org.snmp4j.agent.MOServer;
import org.snmp4j.agent.mo.*;
import org.snmp4j.smi.*;

public class ShabodiMib implements MOGroup {


    private static final OID oidshabodiMIB = new OID(new int[]{1, 3, 6, 1, 4, 1, 59522,1,0});
    private static final OID oidshabodiSystem = new OID(new int[]{1, 3, 6, 1, 4, 1, 59522,2,0});
    private static final OID oidshabodiSystemVersion = new OID(new int[]{1, 3, 6, 1, 4, 1, 59522,3,0});
    private static final OID oidshabodiSystemReleaseDate = new OID(new int[]{1, 3, 6, 1, 4, 1, 59522,4,0});
    private static final OID oidshabodiEvents = new OID(new int[]{1, 3, 6, 1, 4, 1, 59522,5,0});
    private MOScalar<OctetString> shabodi;
    private MOScalar<OctetString> shabodiMIB;
    private MOScalar<OctetString> shabodiSystem;
    private MOScalar<OctetString> shabodiSystemVersion;
    private MOScalar<OctetString> shabodiSystemReleaseDate;
    private MOScalar<OctetString> shabodiEvents;

    //Tables
    //private static final OID oidshabodiServices = new OID(new int[]{1, 3, 6, 1, 4, 1, 59522,1,1,3,0});
    //private static final OID oidshabodiServiceTable = new OID(new int[]{1, 3, 6, 1, 4, 1, 59522,1,1,3,1});
    private static final OID oidshabodiServiceEntry = new OID(new int[]{1, 3, 6, 1, 4, 1, 59522,6,0});
    private static final OID oidshabodiServiceIndex = new OID(new int[]{1, 3, 6, 1, 4, 1, 59522,6,1});


    // Column sub-identifier definitions for ShabodiServiceEntry
    public static final int COLSHABODISERVICEINDEX = 1;
    public static final int COLSHABODISERVICENAME = 2;
    public static final int COLSHABODISERVICEDESCRIPTION = 3;
    public static final int COLSHABODISERVICE_ADDRESSTYPE = 4;
    public static final int COL_SHABODISERVICE_ADDRESS = 5;
    public static final int COLSHABODISERVICEPORT = 6;
    public static final int COL_SHABODISERVICE_VERSION = 7;

    // Column index definitions for ShabodiServiceEntry
    public static final int IDXSHABODISERVICE_INDEX = 0;
    public static final int IDXSHABODISERVICE_NAME = 1;
    public static final int IDXSHABODISERVICE_DESCRIPTION = 2;
    public static final int IDXSHABODISERVICEADDRESSTYPE = 3;
    public static final int IDXSHABODISERVICE_ADDRESS = 4;
    public static final int IDXSHABODISERVICE_PORT = 5;
    public static final int IDXSHABODISERVICE_VERSION = 6;

    private MOTable<ShabodiServiceEntryRow, MOColumn, MOTableModel<ShabodiServiceEntryRow>> shabodiServiceEntry;

    public ShabodiMib(MOFactory moFactory) {
        createMOs(moFactory);
    }

    public void createMOs(MOFactory moFactory) {

        this.shabodiMIB = new MOScalar<>(oidshabodiMIB, MOAccessImpl.ACCESS_READ_WRITE,null){
            @Override
            public OctetString getValue () {
                return new OctetString("Shabodi");
            }

            @Override
            public int setValue (OctetString newValue) {
                return super.setValue(newValue);
            }
        };
        this.shabodiSystem = new MOScalar<>(oidshabodiSystem, MOAccessImpl.ACCESS_READ_WRITE,null){
            @Override
            public OctetString getValue () {
                return new OctetString("Shabodi System");
            }

            @Override
            public int setValue (OctetString newValue) {
                return super.setValue(newValue);
            }

        };
        this.shabodiEvents = new MOScalar<>(oidshabodiEvents, MOAccessImpl.ACCESS_READ_WRITE,null){
            @Override
            public OctetString getValue () {
                return new OctetString("System Events");
            }

            @Override
            public int setValue (OctetString newValue) {
                return super.setValue(newValue);
            }
        };

        this.shabodiSystemVersion = new MOScalar<>(oidshabodiSystemVersion, MOAccessImpl.ACCESS_READ_WRITE, null) {
            @Override
            public OctetString getValue () {
                return new OctetString("System Version 1");
            }

            @Override
            public int setValue (OctetString newValue) {
                return super.setValue(newValue);
            }
        };
        this.shabodiSystemReleaseDate = new MOScalar<>(oidshabodiSystemReleaseDate, MOAccessImpl.ACCESS_READ_WRITE, null) {
            @Override
            public OctetString getValue () {
                return new OctetString("2022-10-06");
            }

            @Override
            public int setValue (OctetString newValue) {
                return super.setValue(newValue); }
        };
        createShabodiServiceEntry(moFactory);
    }


    public MOTable<ShabodiServiceEntryRow, MOColumn, MOTableModel<ShabodiServiceEntryRow>> getShabodiServiceEntry(){
        return shabodiServiceEntry;
    }
    private void createShabodiServiceEntry(MOFactory moFactory) {
        // Index definition
        MOTableSubIndex[] shabodiServiceEntryIndexes = new MOTableSubIndex[]{
                moFactory.createSubIndex(oidshabodiServiceIndex, SMIConstants.SYNTAX_INTEGER, 1, 1)};

        MOTableIndex shabodiServiceEntryIndex = moFactory.createIndex(shabodiServiceEntryIndexes, false, index -> true);

        //columns
        MOColumn[] shabodiServiceEntryColumns = new MOColumn[7];

        shabodiServiceEntryColumns[IDXSHABODISERVICE_INDEX] = moFactory
                .createColumn(COLSHABODISERVICEINDEX,
                        SMIConstants.SYNTAX_INTEGER32,
                        MOAccessImpl.ACCESS_READ_ONLY);
        shabodiServiceEntryColumns[IDXSHABODISERVICE_NAME] = moFactory
                .createColumn(COLSHABODISERVICENAME,
                        SMIConstants.SYNTAX_OCTET_STRING,
                        MOAccessImpl.ACCESS_READ_ONLY);
        shabodiServiceEntryColumns[IDXSHABODISERVICE_DESCRIPTION] = moFactory
                .createColumn(COLSHABODISERVICEDESCRIPTION,
                        SMIConstants.SYNTAX_OCTET_STRING,
                        MOAccessImpl.ACCESS_READ_ONLY);
        shabodiServiceEntryColumns[IDXSHABODISERVICEADDRESSTYPE] = moFactory
                .createColumn(COLSHABODISERVICE_ADDRESSTYPE,
                        SMIConstants.SYNTAX_COUNTER64,
                        MOAccessImpl.ACCESS_READ_ONLY);
        shabodiServiceEntryColumns[IDXSHABODISERVICE_ADDRESS] = moFactory
                .createColumn(COL_SHABODISERVICE_ADDRESS,
                        SMIConstants.SYNTAX_COUNTER64,
                        MOAccessImpl.ACCESS_READ_ONLY);
        shabodiServiceEntryColumns[IDXSHABODISERVICE_PORT] = moFactory
                .createColumn(COLSHABODISERVICEPORT,
                        SMIConstants.SYNTAX_COUNTER64,
                        MOAccessImpl.ACCESS_READ_ONLY);
        shabodiServiceEntryColumns[IDXSHABODISERVICE_VERSION] = moFactory
                .createColumn(COL_SHABODISERVICE_VERSION,
                        SMIConstants.SYNTAX_COUNTER64,
                        MOAccessImpl.ACCESS_READ_ONLY);

        // Table model
        MOMutableTableModel<ShabodiServiceEntryRow> shabodiServiceEntryModel = moFactory.createTableModel(oidshabodiServiceEntry, shabodiServiceEntryIndex, shabodiServiceEntryColumns);
        shabodiServiceEntryModel.setRowFactory(new ShabodiServiceEntryRowFactory());
        this.shabodiServiceEntry = moFactory.createTable(oidshabodiServiceEntry, shabodiServiceEntryIndex, shabodiServiceEntryColumns, shabodiServiceEntryModel);

    }

    @Override
    public void registerMOs(MOServer moServer, OctetString context) throws DuplicateRegistrationException {
        moServer.register(this.shabodiMIB, context);
        moServer.register(this.shabodiSystem,context);
        moServer.register(this.shabodiEvents,context);
        moServer.register(this.shabodiSystemVersion, context);
        moServer.register(this.shabodiSystemReleaseDate, context);
        moServer.register(this.shabodiServiceEntry,context);

    }

    @Override
    public void unregisterMOs(MOServer moServer, OctetString context) {

        moServer.unregister(this.shabodiMIB, context);
        moServer.unregister(this.shabodiSystem,context);
        moServer.unregister(this.shabodiEvents,context);
        moServer.unregister(this.shabodiSystemVersion, context);
        moServer.unregister(this.shabodiSystemReleaseDate, context);
        moServer.unregister(this.shabodiServiceEntry,context);

    }

    // Rows and Factories

    public static class ShabodiServiceEntryRow extends DefaultMOMutableRow2PC {
        public ShabodiServiceEntryRow(OID index, Variable[] values) {
            super(index, values);
        }

        public Integer32 getShabodiServiceIndex() {
            return (Integer32) super.getValue(IDXSHABODISERVICE_INDEX);
        }

        public void setShabodiServiceIndex(Integer32 newValue) {
            super.setValue(IDXSHABODISERVICE_INDEX, newValue);
        }

        public OctetString getShabodiServiceName() {
            return (OctetString) super.getValue(IDXSHABODISERVICE_NAME);
        }

        public void setShabodiServiceName(OctetString newValue) {
            super.setValue(IDXSHABODISERVICE_NAME, newValue);
        }

        public OctetString getShabodiServiceDescription() {
            return (OctetString) super.getValue(IDXSHABODISERVICE_DESCRIPTION);
        }

        public void setShabodiServiceDescription(OctetString newValue) {
            super.setValue(IDXSHABODISERVICE_DESCRIPTION, newValue);
        }

        public OctetString getShabodiServiceAddressType() {
            return (OctetString) super.getValue(IDXSHABODISERVICEADDRESSTYPE);
        }

        public void setShabodiServiceAddressType(OctetString newValue) {
            super.setValue(IDXSHABODISERVICEADDRESSTYPE, newValue);
        }

        public OctetString getShabodiServiceAddress() {
            return (OctetString) super.getValue(IDXSHABODISERVICE_ADDRESS);
        }

        public void setShabodiServiceAddress(OctetString newValue) {
            super.setValue(IDXSHABODISERVICE_ADDRESS, newValue);
        }

        public Integer32 getShabodiServicePort() {
            return (Integer32) super.getValue(IDXSHABODISERVICE_PORT);
        }

        public void setShabodiServicePort(Integer32 newValue) {
            super.setValue(IDXSHABODISERVICE_PORT, newValue);
        }

        public OctetString getShabodiServiceVersion() {
            return (OctetString) super.getValue(IDXSHABODISERVICE_VERSION);
        }

        public void setShabodiServiceVersion(OctetString newValue) {
            super.setValue(IDXSHABODISERVICE_VERSION, newValue);
        }

        @Override
        public Variable getValue(int column) {
            return switch (column) {
                case IDXSHABODISERVICE_INDEX -> getShabodiServiceIndex();
                case IDXSHABODISERVICE_NAME -> getShabodiServiceName();
                case IDXSHABODISERVICE_DESCRIPTION -> getShabodiServiceDescription();
                case IDXSHABODISERVICEADDRESSTYPE -> getShabodiServiceAddressType();
                case IDXSHABODISERVICE_ADDRESS -> getShabodiServiceAddress();
                case IDXSHABODISERVICE_PORT -> getShabodiServicePort();
                case IDXSHABODISERVICE_VERSION -> getShabodiServiceVersion();
                default -> super.getValue(column);
            };
        }

        @Override
        public void setValue(int column, Variable value) {
            //--AgentGen BEGIN=hrStorageEntry::RowSetValue
            //--AgentGen END
            switch (column) {
                case IDXSHABODISERVICE_INDEX -> setShabodiServiceIndex((Integer32) value);
                case IDXSHABODISERVICE_NAME -> setShabodiServiceName((OctetString) value);
                case IDXSHABODISERVICE_DESCRIPTION -> setShabodiServiceDescription((OctetString) value);
                case IDXSHABODISERVICEADDRESSTYPE -> setShabodiServiceAddressType((OctetString) value);
                case IDXSHABODISERVICE_ADDRESS -> setShabodiServiceAddress((OctetString) value);
                case IDXSHABODISERVICE_PORT -> setShabodiServicePort((Integer32) value);
                case IDXSHABODISERVICE_VERSION -> setShabodiServiceVersion((OctetString) value);
                default -> super.setValue(column, value);
            }
        }

    }

    public static class ShabodiServiceEntryRowFactory implements MOTableRowFactory<ShabodiServiceEntryRow> {
        public synchronized ShabodiServiceEntryRow createRow(OID index, Variable[] values) throws UnsupportedOperationException
        {
            return new ShabodiServiceEntryRow(index, values);
        }

        public synchronized void freeRow(ShabodiServiceEntryRow row) {
        }

    }

    public MOScalar<OctetString> getShabodi(){
        return this.shabodi;
    }
    public MOScalar<OctetString> getShabodiMIB(){
        return this.shabodiMIB;
    }
    public MOScalar<OctetString> getShabodiSystem(){
        return this.shabodiSystem;
    }
    public MOScalar<OctetString> getShabodiSystemVersion() {
        return this.shabodiSystemVersion;
    }

    public MOScalar<OctetString> getShabodiSystemReleaseDate() {
        return this.shabodiSystemReleaseDate;
    }
}
