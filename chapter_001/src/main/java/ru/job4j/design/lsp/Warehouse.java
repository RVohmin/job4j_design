package ru.job4j.design.lsp;

import java.util.ArrayList;
import java.util.List;

/**
 * @author RVohmin
 * @since 17.03.2020
 */
public class Warehouse implements Box {
    private List<Food> wareHouseList = new ArrayList<>();

    public List<Food> getWareHouseList() {
        return wareHouseList;
    }

    @Override
    public void add(Food food) {
        wareHouseList.add(food);
    }
}
