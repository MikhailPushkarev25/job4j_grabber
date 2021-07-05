package lsp;

import java.util.ArrayList;
import java.util.List;

public class WareHouse implements Storage {

    private List<Food> list = new ArrayList<>();

    public WareHouse() {

    }

    @Override
    public List<Food> get() {
        List<Food> copy = new ArrayList<>(list);
        list.clear();
        return copy;
    }

    @Override
    public void add(Food food, long num) {
        if (num <= 25) {
            list.add(food);
        } else {
            System.out.println("Нет тот место для хранилища");
        }
    }

    @Override
    public void remove(Food food) {
        list.remove(food);
    }
}
