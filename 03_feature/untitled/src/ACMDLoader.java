import java.io.File;
import java.util.regex.Pattern;

public class ACMDLoader {
    public static void main(String[] argv) {
//        ^ACMD.*\.PIP\.(\d{4}-\d{2}-\d{2}).*|^CCD.*\.CDL.*(\d{4}-\d{2}-\d{2}).*
        Pattern FILE_PATTERN = Pattern.compile("(^ACMD.*\\.PIP\\.(\\d{4}-\\d{2}-\\d{2}).*)|(^CCD.*\\.CDL.*(\\d{4}-\\d{2}-\\d{2}).*)");
        File dir = new File("./src");

        File[] files = dir.listFiles((file, filename) -> FILE_PATTERN.matcher(filename).matches());
        for (File file : files) {
            System.out.println("***");
            System.out.println(file.getName());
        }
    }
}