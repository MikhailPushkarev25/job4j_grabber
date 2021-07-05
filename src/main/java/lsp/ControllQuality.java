package lsp;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ControllQuality {
    private List<Storage> storages = new ArrayList<>();

    public long res(Food food) {
        long one = food.getExpiredDate().toEpochDay() - food.getCreateDate().toEpochDay();
        long two = LocalDate.now().toEpochDay() - food.getCreateDate().toEpochDay();
        return two * 100 / one;
    }

   public void distribute(Food food) {
        for (Storage dist : storages) {
            dist.add(food, res(food));
        }
   }

   public void resort(Food food) {
        List<Food> list = new ArrayList<>();
        for (Storage st : storages) {
          list.addAll(st.get());
          st.get();
        }
        distribute(food);
   }
}
