package ex016_EmptyInterface;

public class TsxSymbol implements DbSymbol {

    private DbSymbol.SymbolId id;
    private String symbol;

    public TsxSymbol(DbSymbol.SymbolId id, String symbol) {
        this.id = id;
        this.symbol = symbol;
    }

    @Override
    public SymbolId id() {
        return id;
    }

    @Override
    public String getSymbol() {
        return symbol;
    }
}
