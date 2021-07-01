package lsp.Menu;

import java.util.List;

public class Point extends Show {

    public Point(String name) {
        super(name);
    }

    public Point(String name, List<Point> list) {
        super(name, list);
    }

    public String getName() {
        return name;
    }

    public List<Point> getList() {
        return list;
    }

}
