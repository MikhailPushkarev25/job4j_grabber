package html;

import java.time.LocalDateTime;
import java.util.Objects;

public class Post {

    private String topic;
    private String author;
    private String answer;
    private String viewing;
    private LocalDateTime data;

    public Post() {

    }

    public Post(String topic, LocalDateTime data) {
        this.topic = topic;
        this.data = data;
    }

    public Post(String topic, String author, String answer, String viewing, LocalDateTime data) {
        this.topic = topic;
        this.author = author;
        this.answer = answer;
        this.viewing = viewing;
        this.data = data;
    }

    public Post(String text, String answer, String attr, LocalDateTime parse) {
    }

    public String getTopic() {
        return topic;
    }

    public String getAuthor() {
        return author;
    }

    public String getAnswer() {
        return answer;
    }

    public String getViewing() {
        return viewing;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public void setViewing(String viewing) {
        this.viewing = viewing;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

}
