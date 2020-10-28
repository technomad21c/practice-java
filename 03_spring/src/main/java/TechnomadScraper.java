import org.jsoup.nodes.Document;

import java.util.List;

public class TechnomadScaper {
    private static final String EBAY_GLOBAL_DEALS_URL = "https://www.ebay.com/globaldeals";

    private static final String PRODUCT_CARD_CLASS = "dne-itemtile-detail";
    private static final String PRODUCT_TITLE_CLASS = "dne-itemtile-title";
    private static final String PRODUCT_LINK_SELECTOR = ".dne-itemtile-title a";
    private static final String PRODUCT_PRICE_SELECTOR = ".dne-itemtile-price .first";

    class Product {
        private String name;
        private String link;
        private String formattedPrice;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }

        public String getFormattedPrice() {
            return formattedPrice;
        }

        public void setFormattedPrice(String formattedPrice) {
            this.formattedPrice = formattedPrice;
        }
    }

    public List<Product> extractProducts() {
        List<Product> products = new ArrayList<>();

        Document doc;
        try {

        }
    }
}
