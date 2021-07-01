package lsp.Menu;

public class Men implements In {

    private Point point;

    public Men(Point point) {
        this.point = point;
    }

    @Override
    public void input() {
        System.out.println("Menu");
        String str = "---";
        for (Point s : point.getList()) {
            System.out.println(str + " " + s.getList());
            in(s, str);
        }
    }

    public void in(Point point, String str) {
        str += str;
        for (Point s : point.getList()) {
            System.out.println(str + " " + s.getName());
            in(s, str);
        }
    }
}
