package ex006_Pattern;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyPattern {
    private String re = "^([A-Z]{2})_([A-Z]{4})_(((IX|FI|MF|UF|UC|UX)([0-9]{6}))|([0-9]{8})).zip$";

    public void run() {
        Pattern pattern = Pattern.compile(re);

        String fileName = "FI_XHEL_IX210302.zip";
        Matcher m = pattern.matcher(fileName);

        if (m.find()) {
            System.out.println("pattern found!");

            System.out.println(("group 0: " + m.group(0)));
            System.out.println(("group 1: " + m.group(1)));
            System.out.println(("group 2: " + m.group(2)));
            System.out.println(("group 3: " + m.group(3)));
            System.out.println(("group 4: " + m.group(4)));
            System.out.println(("group 5: " + m.group(5)));
            System.out.println(("group 6: " + m.group(6)));
            System.out.println(("group 7: " + m.group(7)));
//            System.out.println(("group 8: " + m.group(8)));
        }

        Map<String, String> map = Map.of("key1", "value1", "key2", "value2");
        System.out.println("key1 value: " + map.get("key1") + ", null value: " + map.get("key3"));
        Symbol s = new Symbol();
        s.setSymbol("BB:CA");
        System.out.println(s.getSymbol() + ", primary: " + s.isPrimary());

    }

    private class Symbol {
        private String symbol;

        public String getSymbol() {
            return symbol;
        }

        public void setSymbol(String symbol) {
            this.symbol = symbol;
        }

        public boolean isPrimary() {
            return primary;
        }

        public void setPrimary(boolean primary) {
            this.primary = primary;
        }

        private boolean primary;


    }
}


