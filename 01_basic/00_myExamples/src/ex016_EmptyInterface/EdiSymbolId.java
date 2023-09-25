package ex016_EmptyInterface;

public class EdiSymbolId implements DbSymbol.SymbolId {
    private final int scexhId;

    public EdiSymbolId(int scexhId) {
        super();
        this.scexhId = scexhId;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(scexhId);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;

        if (getClass() != obj.getClass() && obj.getClass() != EdiSymbolId.class)
            return false;
        EdiSymbolId other = (EdiSymbolId) obj;
        if (scexhId != other.scexhId)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "SymbolId [scexhId=" + scexhId + "]";
    }

    protected int getScexhid() {
        return scexhId;
    }
}
