package html;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import java.io.IOException;

public class ParseSql {
    public static void detail(String str) throws IOException {
        Document doc = Jsoup.connect(str).get();
        Elements row = doc.select(".msgBody");
        Elements row1 = doc.select(".msgFooter");
        Post post = new Post();
        post.setTopic(row.get(1).text());
        post.setAnswer(row1.get(0).text());
        System.out.println(post.getTopic());
        System.out.println(post.getAnswer());
    }

    public static void main(String[] args) throws IOException {
        String url = "https://www.sql.ru/forum/1325330"
                + "/lidy-be-fe-senior-cistemnye-analitiki-qa-i-devops-moskva-do-200t";
        detail(url);
    }
}
