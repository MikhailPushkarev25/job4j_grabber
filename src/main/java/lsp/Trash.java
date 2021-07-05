package lsp;

import java.util.ArrayList;
import java.util.List;

public class Trash implements Storage {

    List<Food> list = new ArrayList<>();

    public Trash() {

    }

    @Override
    public List<Food> get() {
        List<Food> copy = new ArrayList<>(list);
        list.clear();
        return copy;
    }

    @Override
    public void add(Food food, long num) {
        if (num >= 75) {
            System.out.println("Скидка на данный товар");
        }
    }

    @Override
    public void remove(Food food) {
        list.remove(food);
    }
}
