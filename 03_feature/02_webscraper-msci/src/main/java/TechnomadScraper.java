// source: https://keepcodeclean.com/web-scraping-using-java-jsoup/

import org.apache.commons.io.FileUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TechnomadScraper {

    public static void main(String[] args) throws IOException {
        TechnomadScraper tnScraper = new TechnomadScraper();
        String urlMSCI = "https://www.msci.com";
        String urlMSCI_tickerCodes = urlMSCI + "/ticker-codes";
        List<String> tickerWords = Arrays.asList("/documents", "Tickers-for-MSCI-Indexes");
        Document doc;
        try {
            doc = Jsoup.connect(urlMSCI_tickerCodes).get();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
//        Elements pElements = doc.select("p:contains(\"Tickers for MSCI Indexes\")");
        Elements pElements = doc.select("p:contains(Tickers for MSCI Indexes)");
        for (Element e : pElements) {
            Elements links = e.select("a[href]");
            String strLink = links.attr("href");
            if (tickerWords.stream().allMatch(strLink::contains)) {
                System.out.println("LINK: " + urlMSCI + strLink);
                FileUtils.copyURLToFile(
                        new URL(urlMSCI + strLink),
                        new File("msci-indexes.xlsx"),
                        3000,
                        3000);
            }
        }


    }
}
