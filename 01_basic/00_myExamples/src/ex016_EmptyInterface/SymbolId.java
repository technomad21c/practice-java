package ex016_EmptyInterface;

public class SymbolId extends EdiSymbolId implements DbSymbol.SymbolId {
    private final int sedolId;

    public SymbolId(int scexhId, int sedolId) {
        super(scexhId);
        this.sedolId = sedolId;
    }

}
