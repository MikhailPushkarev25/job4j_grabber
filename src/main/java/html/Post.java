package html;

import java.time.LocalDate;
import java.util.Objects;

public class Post {

    private String topic;
    private String author;
    private String answer;
    private String viewing;
    private LocalDate data;

    public Post(String topic, String author, String answer, String viewing, LocalDate data) {
        this.topic = topic;
        this.author = author;
        this.answer = answer;
        this.viewing = viewing;
        this.data = data;
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

    public LocalDate getData() {
        return data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return Objects.equals(topic, post.topic) && Objects.equals(author, post.author) && Objects.equals(answer, post.answer) && Objects.equals(viewing, post.viewing) && Objects.equals(data, post.data);
    }

    @Override
    public String toString() {
        return "Post{" +
                "topic='" + topic + '\'' +
                ", author='" + author + '\'' +
                ", answer='" + answer + '\'' +
                ", viewing='" + viewing + '\'' +
                ", data=" + data +
                '}';
    }
}
