package ex016_EmptyInterface;

public class EdiSymbol implements DbSymbol {

    private DbSymbol.SymbolId symbolId;
    private String symbol;

    public EdiSymbol(DbSymbol.SymbolId symbolId, String symbol) {
        this.symbolId = symbolId;
        this.symbol = symbol;
    }

    @Override
    public SymbolId id() {
        return symbolId;
    }

    @Override
    public String getSymbol() {
        return symbol;
    }
}
