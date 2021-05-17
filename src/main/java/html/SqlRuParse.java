package html;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import utils.SqlRuDateTimeParser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SqlRuParse implements Parse {

    private final SqlRuDateTimeParser sql = new SqlRuDateTimeParser();

    public static void main(String[] args) throws Exception {
        SqlRuParse sq = new SqlRuParse();
       for (Post el : sq.list("https://www.sql.ru/forum/job-offers")) {
           System.out.println(el);
       }

       System.out.println(sq.detail("https://www.sql.ru/forum/1325330/"
               + "lidy-be-fe-senior-cistemnye-analitiki-qa-i-devops-moskva-do-200t"));
    }

    @Override
    public List<Post> list(String link) throws IOException {
        List<Post> posts = new ArrayList<>();
        Document doc = Jsoup.connect(link).get();
        Elements row = doc.select(".postslisttopic");
        Elements data = doc.select(".altCol");
        int index = 1;
        for (Element dt : row) {
            Element href = dt.child(0);
            posts.add(new Post(href.text(), detail(href.attr(".href")).
                    getTopic(), href.attr(".href"), sql.parse(data.get(index).text())));
            index += 2;
        }
        return posts;
    }

    @Override
    public html.Post detail(String link) throws IOException {
        Document doc = Jsoup.connect(link).get();
        Elements row = doc.select(".msgBody");
        Elements row1 = doc.select(".msgFooter");
        return new Post(row.get(1).text(), this.sql.parse(row1.get(0).text()));
    }
}
