package lsp.menudemo;

public interface MenuStorage {

    void add(Element main, Element child);

    Element get(String name);

    String outPut();
}
