package utils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

public class SqlRuDateTimeParser implements DateTimeParser {

    private Map<String, Integer> months = new HashMap<>();

    {
        months.put("янв", 1);
        months.put("фев", 2);
        months.put("мар", 3);
        months.put("апр", 4);
        months.put("май", 5);
        months.put("июн", 6);
        months.put("июл", 7);
        months.put("авг", 8);
        months.put("сен", 9);
        months.put("окт", 10);
        months.put("ноя", 11);
        months.put("дек", 12);
    }

    @Override
    public LocalDateTime parse(String parse) {
        String[] str = parse.split(", ");
        int hour = Integer.parseInt(str[0]);
        int minute = Integer.parseInt(str[1]);
        if ("сегодня".equals(str[0])) {
            return LocalDateTime.of(LocalDate.now(), LocalTime.of(hour, minute));
        }
        if ("вчера".equals(str[0])) {
            return LocalDateTime.of(LocalDate.now().minusDays(1), LocalTime.of(hour, minute));
        }

        String[] par = parse.split(" ");
        int year = Integer.parseInt(str[0]);
        int month = months.get(str[1]);
        int day = Integer.parseInt(par[2]);

        return LocalDateTime.of(year, month, day, hour, minute);
    }

    public static void main(String[] args) throws IOException {
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
            SqlRuDateTimeParser sql = new SqlRuDateTimeParser();
            System.out.println(sql.parse(date.text()));
        }
    }
}
