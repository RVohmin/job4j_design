package ru.job4j.design.lsp;

import java.util.ArrayList;
import java.util.List;

/**
 * @author RVohmin
 * @since 17.03.2020
 */
public class Shop implements Box {
    private List<Food> shopList = new ArrayList<>();

    public List<Food> getShopList() {
        return shopList;
    }

    @Override
    public void add(Food food) {
        shopList.add(food);
    }
}
