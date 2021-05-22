package grabber;
import html.SqlRuParse;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class PsqlStore implements Store, AutoCloseable {

    private final Connection cnn;

    public PsqlStore(Properties cfg) {
        ClassLoader cl = PsqlStore.class.getClassLoader();
        try (InputStream in = cl.getResourceAsStream("postsql.properties")) {
            cfg.load(in);
            Class.forName(cfg.getProperty("jdbc.driver"));
            String url = cfg.getProperty("url");
            String login = cfg.getProperty("login");
            String password = cfg.getProperty("password");
            cnn = DriverManager.getConnection(url, login, password);
    } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void save(Post post) {

        try (PreparedStatement ps = cnn.
                prepareStatement("insert into post (name, text, link, created)"
                        + "values (?, ?, ?, ?)")) {
            ps.setString(1, post.getHeading());
            ps.setString(2, post.getLink());
            ps.setString(3, post.getText());
            ps.setTimestamp(4, Timestamp.valueOf(post.getCreated()));
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Post> getAll() {
        List<Post> list = new ArrayList<>();
        try (PreparedStatement ps = cnn.prepareStatement("select * from post")) {
            try (ResultSet set = ps.executeQuery()) {
                while (set.next()) {
                    int id = set.getInt("id");
                    String name = set.getString("name");
                    String text = set.getString("text");
                    String link = set.getString("link");
                    LocalDateTime date = set.getTimestamp("created").toLocalDateTime();
                    list.add(new Post(id, name, text, link, date));
                  ps.executeUpdate();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
            return list;
        }

    @Override
    public Post findById(String id) {
        Post post = new Post();
        try (PreparedStatement ps = cnn.prepareStatement("select * from post id = ?")) {
            ps.setInt(1, Integer.parseInt(id));
            try (ResultSet set = ps.executeQuery()) {
                while (set.next()) {
                   int idPost = set.getInt("id");
                   String name = set.getString("name");
                   String text = set.getString("text");
                   String link = set.getString("link");
                    LocalDateTime date = set.getTimestamp("created").toLocalDateTime();
                    post = new Post(idPost, name, text, link, date);

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
       return post;
    }

    @Override
    public void close() throws Exception {
        if (cnn != null) {
            cnn.close();
        }
    }

    @SuppressWarnings("checkstyle:EmptyLineSeparator")
    public static void main(String[] args) throws IOException, SQLException {
        PsqlStore ps = new PsqlStore(new Properties());
        ConnectionRol.create(ps.cnn);
        SqlRuParse parse = new SqlRuParse();
        parse.list("https://www.sql.ru/forum/job-offers");
        ps.getAll().forEach(System.out::println);
        System.out.println(ps.findById("160"));
    }
}






