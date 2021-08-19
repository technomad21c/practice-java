package ex008_ObjectMemberNullChecking.ex008_ObjectMemberNullChecking;

import java.lang.reflect.Method;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class MyObjectNull {
    private Integer i;
    private Date d;
    public void run() {
        Map<String, Method> methodMap = new HashMap<String, Method>();
        Symbol s = new Symbol();

        try {
            methodMap.put("getSymbol", s.getClass().getDeclaredMethod("getSymbol"));
            methodMap.put("symbol", s.getClass().getDeclaredMethod("setSymbol", String.class));
            methodMap.put("name", s.getClass().getDeclaredMethod("setName", String.class));
            methodMap.get("symbol").invoke(s, "SYMBOL");
            methodMap.get("name").invoke(s, "NAME");
            System.out.println("Get Symbol: " + methodMap.get("getSymbol").invoke(s,null));

            String str = null;

            System.out.println(isNotNull(d) ? "Not NULL" : "NULL");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean isNotNull(Object obj) {
        if (obj != null) {
            return true;
        } else {
            return false;
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
