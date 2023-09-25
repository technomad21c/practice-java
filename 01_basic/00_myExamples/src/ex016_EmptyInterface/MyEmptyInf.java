package ex016_EmptyInterface;

public class MyEmptyInf {
    public void run() {
        DbSymbol.SymbolId id = new EdiSymbolId(Integer.parseInt("12345"));
        System.out.println("ID: " + id);

        DbSymbol.SymbolId id2 = new SymbolId(Integer.parseInt("12345"), Integer.parseInt("9876"));
        System.out.println("ID: " + id2);

        DbSymbol.SymbolId id3 = new TsxSymbolId("BB:CA", "TSX");
        System.out.println("ID: " + id3);

        DbSymbol.SymbolId id4 = new TsxSymbolId("BB:CA", "TSX");
        System.out.println("ID: " + id4);

        DbSymbol sym = new EdiSymbol(id3, "TSX");
        System.out.println("ID: " + sym.id());

        DbSymbol sym2 = new TsxSymbol(id4, "TSX");
        System.out.println("ID: " + sym2.id());

        SECHISTORY_OPERATION op = SECHISTORY_OPERATION.valueOf("DELETE");
        System.out.println("Operation: " + op.toString());

        DbSymbol.SymbolId id5 = new EdiSymbolId(Integer.parseInt("12345"));
        if (id5.equals(id)) {
            System.out.println("EdiSymbol ID is equal");
        }

        DbSymbol.SymbolId id6 = new SymbolId(Integer.parseInt("12345"), Integer.parseInt("3456"));
        if (id6.equals(id)) {
            System.out.println("Symbol ID is equal");
        }
    }

}


