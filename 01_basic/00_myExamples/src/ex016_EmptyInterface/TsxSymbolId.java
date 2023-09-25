package ex016_EmptyInterface;

public class TsxSymbolId implements DbSymbol.SymbolId {
    private String symbol;
    private String excode;

    public TsxSymbolId(String symbol, String excode) {
        super();
        this.symbol = symbol;
        this.excode = excode;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getExcode() {
        return excode;
    }
}
