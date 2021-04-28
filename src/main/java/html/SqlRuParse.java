package html;

import org.jsoup.Jsoup;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class SqlRuParse {
    public static void main(String[] args) throws Exception {
        Document doc = Jsoup.connect("https://www.sql.ru/forum/job-offers").get();
        Elements row = doc.select(".postslisttopic");
        Elements data = doc.select(".altCol");
        int index = 1;
        for (Element td : row) {
            Element href = td.child(0);
            Element date = data.get(index);
            System.out.println(href.attr("href"));
            System.out.println(href.text());
            System.out.println(date.text());
            index += 2;
        }
    }
}
