package lsp.menudemo;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Menu implements MenuStorage {

    private final List<Element> elements;

    public Menu() {
        elements = new ArrayList<>();
    }

    @Override
    public void add(Element main, Element child) {
        if (main == null) {
            elements.add(child);
        } else {
            this.get(main.getName()).getEl().add(child);
        }
    }

    @Override
    public Element get(String name) {
        Element element = null;
        for (Element e : elements) {
            element = e.byName(name);
        }
        if (element == null) {
            throw new NoSuchElementException("Not element exception");
        }
        return element;
    }

    @Override
    public String outPut() {
        StringBuilder sb = new StringBuilder();
        for (Element el : elements) {
            sb.append(el.toString());
        }
        return sb.toString();
    }
}
