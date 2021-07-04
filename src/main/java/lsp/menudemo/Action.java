package lsp.menudemo;

public class Action implements Actions {

    @Override
    public void act() {
        System.out.println("Actions " + this.toString());
    }
}
