package lsp.menudemo;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Element {

    private Actions actions;
    private String name;
    private List<Element> el;

    public Element(String name, Actions actions) {
        this.actions = actions;
        this.name = name;
        el = new ArrayList<>();
    }

    public Element(String name) {
        this.name = name;
    }

    public Actions getActions() {
        return actions;
    }

    public String getName() {
        return name;
    }

    public List<Element> getEl() {
        return el;
    }

    public void act() {
        actions.act();
    }

    public Element byName(String name) {
        Stack<Element> stack = new Stack<>();
        Element element = null;
        stack.push(this);
        while (!stack.isEmpty()) {
            Element element1 = stack.pop();
            String first = element1.getName();
            if (first.equals(name)) {
                element = element1;
                break;
            }
            if (element1.getEl() != null) {
                for (Element select : element1.getEl()) {
                    stack.push(select);
                }
            }
        }
        return element;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("--Menu--");
        sb.append(name);
        sb.append("\n");
        if (el != null) {
            for (Element element : el) {
                sb.append(element.toString());
            }
        }
        return sb.toString();
    }
}
