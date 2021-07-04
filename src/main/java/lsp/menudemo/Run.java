package lsp.menudemo;

public class Run {
    public static void main(String[] args) {
        Actions actions = new Action();
        Element element = new Element("1.", actions);
        Element element1 = new Element("1.1", actions);
        Element element2 = new Element("1.1.1", actions);
        Element element3 = new Element("1.1.2", actions);
        Element element4 = new Element("1.2", actions);
        MenuStorage menu = new Menu();
        menu.add(null, element1);
        menu.add(element1, element2);
        menu.add(element2, element3);
        menu.add(element3, element4);
        System.out.println(menu.outPut());
    }
}
