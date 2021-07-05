package lsp;

import java.util.ArrayList;
import java.util.List;

public class Shop implements Storage {

    private List<Food> list = new ArrayList<>();

    public Shop() {

    }

    @Override
    public List<Food> get() {
        List<Food> copy = new ArrayList<>(list);
        list.clear();
        return copy;
    }

    @Override
    public void add(Food food, long num) {
        if (num >= 25 && num <= 75) {
            list.add(food);
        } else {
            System.out.println("Не то место для продуктов");
        }
    }

    @Override
    public void remove(Food food) {
        list.remove(food);
    }
}
