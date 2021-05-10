package grabber;

import java.time.LocalDateTime;

public class Post {

    private String text;
    private String link;
    private String heading;

    public Post() {

    }

    public Post(String heading, String link, String text) {
        this.text = text;
        this.link = link;
        this.heading = heading;
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
        return "Post{" +
                "text='" + text + '\'' +
                ", link='" + link + '\'' +
                ", heading='" + heading + '\'' +
                '}';
    }
}
