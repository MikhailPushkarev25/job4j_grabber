package lsp;

import java.util.List;

public interface Storage {

    List<Food> get();

    void add(Food food, long num);
}
