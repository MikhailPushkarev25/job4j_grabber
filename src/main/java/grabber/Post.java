package grabber;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Post {
    private String id;
    private String text;
    private String link;
    private String heading;
    private String created;

    public Post(int id, String name, String link, String text, LocalDate created) {

    }

    public Post() {

    }

    public Post(String heading, String link, String text, LocalDate created) {
        this.text = text;
        this.link = link;
        this.heading = heading;
    }

    public Post(String id, String heading, String link, String text, String created) {
        this.id = id;
        this.text = text;
        this.link = link;
        this.heading = heading;
        this.created = created;
    }

    public Post(int idPost, String name, String text, String link, LocalDateTime date) {
        this.id = id;
        this.text = text;
        this.link = link;
        this.heading = heading;
        this.created = created;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    @Override
    public String toString() {
        return "Post{" + "id=" + id + ", text='" + text + '\''
                + ", link='" + link + '\'' + ", heading='" + heading + '\''
                 + ", created=" + created + '}';
    }
}
