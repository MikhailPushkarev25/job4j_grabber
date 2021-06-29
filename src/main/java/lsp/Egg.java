package lsp;

import java.time.LocalDate;

public class Egg extends Food {

    public Egg(String name, LocalDate expiredDate, LocalDate createDate, int price, int discount) {
        super(name, expiredDate, createDate, price, discount);
    }
}
