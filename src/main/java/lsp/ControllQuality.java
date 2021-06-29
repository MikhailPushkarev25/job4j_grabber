package lsp;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ControllQuality {

    private List<Food> list = new ArrayList<>();

    public long res(Food food) {
        long one = food.getExpiredDate().toEpochDay() - food.getCreateDate().toEpochDay();
        long two = LocalDate.now().toEpochDay() - food.getCreateDate().toEpochDay();
        return two * 100 / one;
    }

    public void sum(List<Storage> storages) {
       List<Food> foods = storages.stream()
                .flatMap(storage -> storage.get().stream())
                .collect(Collectors.toList());

        for (Food food : foods) {
            for (Storage storage : storages) {
                storage.add(food, res(food));
            }
        }
    }
}
