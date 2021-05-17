package grabber;
import java.io.InputStream;
import java.sql.*;
import java.time.LocalDate;
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
            ps.setDate(4, java.sql.Date.valueOf(post.getCreated()));
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Post> getAll() {
        List<Post> list = new ArrayList<>();
        try (PreparedStatement ps = cnn.prepareStatement("select * from post")) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Post post = new Post(rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("link"),
                            rs.getString("text"),
                            LocalDate.parse(rs.getString("created"))
                    );
                    list.add(post);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
            return list;
        }

    @Override
    public Post findById(int id) {
        Post post = new Post();
        try (PreparedStatement ps = cnn.prepareStatement("select * from post id = ?")) {
            ps.setInt(1, id);
            try (ResultSet set = ps.executeQuery()) {
                while (set.next()) {
                    post.setHeading(set.getString("heading"));
                    post.setLink(set.getString("link"));
                    post.setText(set.getString("text"));
                    post.setCreated(LocalDate.parse(set.getString("created")));

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

    public static void main(String[] args) throws Exception {
        Properties config = new Properties();
        PsqlStore psqlStore = new PsqlStore(config);
        Post pp = new Post(1, "1http//00", "1dbf0", "1text_dbf0", LocalDate.parse("2020-02-02"));
        psqlStore.save(pp);
        pp = new Post(1, "2http//00", "2dbf0", "2text_dbf0", LocalDate.parse("2020-02-02"));
        psqlStore.save(pp);
        System.out.println(psqlStore.getAll().get(1).toString());
        System.out.println(psqlStore.findById(1).toString());
    }
    }






