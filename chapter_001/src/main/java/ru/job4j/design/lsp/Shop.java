package ru.job4j.design.lsp;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @author RVohmin
 * @since 17.03.2020
 */
public class Shop implements Box {
    private List<Food> shopList = new ArrayList<>();

    public List<Food> getList() {
        return shopList;
    }

    @Override
    public void add(Food food) {
        shopList.add(food);
    }

    @Override
    public boolean check(Food food) {
        int percent = percent(food);
        if (percent >= 25 && percent < 75) {
            return true;
        } else if (percent > 75) {
            food.setDisscount(50);
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Shop)) {
            return false;
        }
        Shop shop = (Shop) o;
        return Objects.equals(shopList, shop.shopList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(shopList);
    }
}
