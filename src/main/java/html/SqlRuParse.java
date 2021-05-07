package html;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;


public class SqlRuParse {
    public static void parseUrl(String str) throws IOException {
        Document doc = Jsoup.connect(str).get();
        Elements row = doc.select(".postslisttopic");
        Elements data = doc.select(".altCol");
        int index = 1;
        for (Element td :row) {
            Element href = td.child(0);
            Element date = data.get(index);
            System.out.println(href.attr("href"));
            System.out.println(href.text());
            System.out.println(date.text());
            index += 2;
        }
    }
    public static void main(String[] args) throws Exception {
       String str = "https://www.sql.ru/forum/job-offers";

       for (int i = 0; i <= 5; i++) {
          parseUrl(str + "//" + i);
       }
    }
}
