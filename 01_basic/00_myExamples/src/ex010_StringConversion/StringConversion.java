package ex010_StringConversion;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StringConversion {
    public void run() throws ParseException {
            // Optional ArrayList
        Optional<List<String>> optStr = Optional.ofNullable(new ArrayList<>(
            List.of("A", "B")) );
        optStr = Optional.empty();
        if (optStr.isEmpty()) System.out.println("Optional empty");
        else System.out.println("1st element: " + optStr.get().get(0));

        // null check
        LocalDate lastSuccess = null;

        LocalDate now = LocalDate.now();
        if (now != lastSuccess) {
            System.out.println("null checked");
            lastSuccess = now;
        }

        if (now != lastSuccess) {
            System.out.println("null checked 2");
        } else {
            System.out.println("date same: " + now);
        }

        // csv parser
        String csvStr = "symbol,shortname,longname,shareclassloadtype,shareclasstypeid,shareclasstype,sedarissuerno,categoryid,cik,country,currency,exLgName,exShName,excode,fundfamilyid,fundfamilyname,fundgroup,glcatassetclassid,glcatassetclassname,glcatid,glcatname,inceptiondate,instrumenttype,investmentstyle,moneymarketfundcategory,primaryfundbenchmarkname,prospobjid,prospobjname,secondfundbenchmarkname";
        csvStr = "symbol,shortname,longname,shareclassloadtype,shareclasstypeid,shareclasstype,sedarissuerno,categoryid,cik,country,currency,exLgName,exShName,excode,fundfamilyid,fundfamilyname,fundgroup,glcatassetclassid,glcatassetclassname,glcatid,glcatname,inceptiondate,instrumenttype,investmentstyle,moneymarketfundcategory,primaryfundbenchmarkname,prospobjid,prospobjname,secondfundbenchmarkname";

        String[] titles = csvStr.split(",");
        int count = 0;
        System.out.println("title length: " + titles.length);
        for (String s : titles) {
            System.out.println("No: " + count++ +  ", title: " + s);
        }

        csvStr = "TNLRX,1290 Retirement 2035 Fund,1290 Retirement 2035 Fund Class R,,714.0,Retirement,,670.0,1605941.0,United States,US Dollar,Nasdaq Mutual Funds,NMF,QMUF,944.0,1290 Funds,1290 Retirement 2035 Fund,$GLAC$AL,Allocation/Balanced,GLCAT$US$TGT,United States Target Date Fund,,Mutual Fund,Target Date,,Bloomberg Barclays US Aggregate Bond Index,AA,Asset Allocation,S&P Target Date 2035 Index";
        csvStr = "FAP:CA,Aberdeen Asia-Pacific Income,Aberdeen Asia-Pacific Income Fund,,630.0,,,17.0,,Canada,US Dollar,Toronto Stock Exchange,TSX,TSX,952,Aberdeen Asset Management,Aberdeen Asia-Pacific Income Investment Company Limited,$GLAC$FI,Fixed Income,GLCAT$AP$FI,ASIA-PACIFIC Fixed Income,1986-04-24,ETF,Intermediate Term High Quality,,,,,S&P/TSX Composite Index";
        csvStr = "CIG11156:CA,Black Creek Global Leaders,Black Creek Global Leaders Fund A,Deferred Sales Charge,2,Commission Based Advice,13656.0,427.0,,Canada,Canadian Dollar,Canadian Mutual Funds/Money Market,CMF,QMCF,1125,CI Investments,Black Creek Global Leaders Fund,$GLAC$EQ,Equity,GLCAT$GL$MC$BL$EQ,Global Mid Cap Blend Equity,2005-02-01,Mutual Fund,Mid Cap Blend,,MSCI WORLD Net Total Return CAD,WW,World Stock,MSCI WORLD Net Total Return CAD";
        String[] fieldNames = csvStr.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
        count = 0;
        for (String s : fieldNames) {
            System.out.println("No: " + count +  ", title: " + titles[count++] + " - " + s);
        }
        System.out.println(" length: " + titles.length);
        System.out.println(" length: " + ETF.class.getDeclaredFields().length);
        System.out.println(" length: " + fieldNames.length);
        System.out.println(" length: " + ETF.getFieldsNumber());

        /*
        // string to LocalDate
        String dateStr = null;
//        LocalDate localDate = LocalDate.parse(dateStr);
        LocalDate localDate = null;
        System.out.println("Local Date: " + localDate);

        // null to long
        String longStr = null;
        Long a = longStr != null ? Long.valueOf(longStr) : null;
        System.out.println("String null to long: " + a);

        // qmci id checking
        System.out.println("QMCI ID: " + getQmciId("US74348T4094"));
        System.out.println("QMCI ID: " + getQmciId("US74019P1084"));
        // Date Converstion
        String dateString = "2000/12/21";
        Date date = DateUtils.parseDate(dateString, "yyyy/MM/dd");
        System.out.println("Date: " + (date.getYear() + 1900)+ ", " + date.getMonth());

        Calendar c = Calendar.getInstance();
        c.setTime(date);

        int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
        switch (dayOfWeek) {
            case Calendar.MONDAY:
                c.add(Calendar.DATE, -3);
                break;
            default:
                c.add(Calendar.DATE, -1);
        }
        System.out.println("Date2: " + c.getTime());

        Integer i = 600;
        DecimalFormat  df = new DecimalFormat("0000");
        String str = df.format(610);
        System.out.println("Integer: " + i + " - String: " + str);

        String issuerId = "issuer001";
        String country = "CA";
        Integer sic = 600;
        Long sicId = 1663L;
        System.out.println(String.format("Batching insertion of issuer-SIC linkage: %s, %s%04d (%d)", issuerId, country, sic, sicId));

        if (check()) {
            System.out.println("can maintain it");
        } else {
            System.out.println("can not");
        }

        char ch = '7';
        char res = (char)(ch - 1);
        System.out.println("----------");
        System.out.println(res);
        res = (char)65;
        System.out.println("----------");
        System.out.println(res);
        res = (char)(('7' + '5' + 'Z' + '3' + '4' + '6' + '3' + '7' + '4' + '4') % 26 + 65);
        System.out.println("----------");
        System.out.println(res);

//        String l = "";
//        Long temp = Long.parseLong(l);
//        System.out.println(temp);

        int[] grades = {1, 2, 3, 4};
        System.out.println(Arrays.toString(grades));
        for (int j=0; j < 4; j++) {
            System.out.println(j);
        }

        Scanner in = new Scanner(System.in);
        System.out.println("Enter your option: ");
        String opt = in.next();
        switch (opt) {
            case "a":
                System.out.println("aaa");
            case "b":
                System.out.println("bbb");
            default:
                System.out.println("default");

        }

         */
    }

    public String isinToQmci(String isin) {
        try {
            StringBuilder s = new StringBuilder();
            s.append(isin.substring(0, 2));
            s.append('I');
            int sum = 0;
            for (int i = isin.length() -1; i >= 2; i--) {
                char c = permut(isin, i);
                s.append(c);
                sum += c;
            }
            s.append("A");
            s.append((char) ((sum %26)+65));
            return s.toString();
        } catch(NumberFormatException e) {
            throw new IllegalArgumentException(isin);
        }
    }

    private char permut(String isin, int i) {
        assert isin != null;
        char res;
        char c = isin.charAt(i);
        if (i%2 == 0) {
            if (c == '9') {
                res = 'A';
            } else if (c == 'Z'){
                res = '0';
            } else {
                res = (char)(c + 1);
            }
        } else {
            if (c == '0') {
                res = 'Z';
            } else if (c == 'A'){
                res = '9';
            } else {
                res = (char)(c - 1);
            }
        }
        return res;
    }

    public String getQmciId(String isin) {
        if (isin == null) {
            return null;
        } else {
            return isinToQmci(isin);
        }
    }
    public boolean check() {
        Long i =  1l;
        return i != null && false;
    }
}
