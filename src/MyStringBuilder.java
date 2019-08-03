public class MyStringBuilder {

    public static void main(String[] args) {
        String str = "abcdefg";
        StringBuilder sb = new StringBuilder(str);

        System.out.println(sb.toString());
        System.out.println(sb.append("hijklmn"));
        System.out.println(sb.length());
        System.out.println(sb.reverse());
    }
}
