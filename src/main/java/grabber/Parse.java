package grabber;

import html.Post;

import java.io.IOException;
import java.util.List;

public interface Parse {

    List<grabber.Post> list(String link) throws IOException;

    Post detail(String link) throws IOException;
}
