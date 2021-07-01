package lsp.Menu;

import java.util.List;

public class ShowDemo {
    public static void main(String[] args) {
        In i = new Men(
                new Point("Menu", List.of(
                        new Point("1.", List.of(
                                new Point("1.1", List.of(
                                        new Point("1.1.1"),
                                        new Point("1.1.2")
                                ))

                        ) )
                ))
        );
        i.input();
    }
}
