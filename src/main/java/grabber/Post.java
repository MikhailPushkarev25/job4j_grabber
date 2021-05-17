package grabber;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Post {
    private int id;
    private String text;
    private String link;
    private String heading;
    private LocalDate created;

    public Post() {

    }

    public Post(String heading, String link, String text, LocalDate created) {
        this.text = text;
        this.link = link;
        this.heading = heading;
        this.created = created;
    }

    public Post(int id, String heading, String link, String text, LocalDate created) {
        this.id = id;
        this.text = text;
        this.link = link;
        this.heading = heading;
        this.created = created;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
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
