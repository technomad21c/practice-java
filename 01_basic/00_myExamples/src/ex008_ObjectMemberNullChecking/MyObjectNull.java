package ex008_ObjectMemberNullChecking;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class MyObjectNull {
    public void run() {
        Map<String, Method> methodMap = new HashMap<String, Method>();
        Symbol s = new Symbol();

        try {
            methodMap.put("symbol", s.getClass().getDeclaredMethod("setSymbol", String.class));
            methodMap.put("name", s.getClass().getDeclaredMethod("setName", String.class));
            methodMap.get("symbol").invoke(s, "SYMBOL");
            methodMap.get("name").invoke(s, "NAME");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Symbol {
    private String symbol;
    private String name;
    private int eod;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
        System.out.println("Symbol: " + this.symbol);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        System.out.println("Name: " + this.name);
    }

    public int getEod() {
        return eod;
    }

    public void setEod(int eod) {
        this.eod = eod;
    }
}
