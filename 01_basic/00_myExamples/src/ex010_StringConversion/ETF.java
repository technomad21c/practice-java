package ex010_StringConversion;

import java.lang.reflect.Field;

public class ETF {

    public final static int SYMBOL = 0;
    public final static int SHORTNAME = 1;
    public final static int LONGNAME = 2;
    public final static int SHARECLASSLOADTYPE = 3;
    public final static int SHARECLASSTYPEID = 4;
    public final static int SHARECLASSTYPE = 5;
    public final static int SEDARISSUERNO = 6;
    public final static int CATEGORYID = 7;
    public final static int CIK = 8;
    public final static int COUNTRY = 9;
    public final static int CURRENCY = 10;
    public final static int EXLGNAME = 11;
    public final static int EXSHNAME = 12;
    public final static int EXCODE = 13;
    public final static int FUNDFAMILYID = 14;
    public final static int FUNDFAMILYNAME = 15;
    public final static int FUNDGROUP = 16;
    public final static int GLCATASSETCLASSID = 17;
    public final static int GLCATASSETCLASSNAME = 18;
    public final static int GLCATID = 19;
    public final static int GLCATNAME = 20;
    public final static int INCEPTIONDATE = 21;
    public final static int INSTRUMENTTYPE = 22;
    public final static int INVESTMENTSTYLE = 23;
    public final static int MONEYMARKETFUNDCATEGORY = 24;
    public final static int PRIMARYFUNDBENCHMARKNAME = 25;
    public final static int PROSPOBJID = 26;
    public final static int PROSPOBJNAME = 27;
    public final static int SECONDFUNDBENCHMARKNAME = 28;

    public static int getFieldsNumber() {
        Field[] fields = ETF.class.getDeclaredFields();
        int num = 0;
        for (Field field : fields) {
            if (!field.isSynthetic()) {
                num++;
            }
        }

        return num;
    }
}
