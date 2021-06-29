package lsp;

import java.util.ArrayList;
import java.util.List;

public class Trash implements Storage {

    List<Food> list = new ArrayList<>();

    public Trash() {

    }

    @Override
    public List<Food> get() {
        return list;
    }

    @Override
    public void add(Food food, long num) {
        if (num >= 75) {
            System.out.println("Скидка на данный товар");
        }
    }
}
