package lsp.Menu;

import java.util.ArrayList;
import java.util.List;

public abstract class Show {

     List<Point> list = new ArrayList<>();
     String name;

    public Show(String name) {
        this.name = name;
    }

    public Show(String name, List<Point> list) {
        this.list = list;
        this.name = name;
    }
}
