package ru.job4j.design.lsp;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author RVohmin
 * @since 17.03.2020
 */
public class Warehouse implements Box {
    private List<Food> wareHouseList = new ArrayList<>();

    public List<Food> getList() {
        return wareHouseList;
    }

    @Override
    public void add(Food food) {
        wareHouseList.add(food);
    }

    @Override
    public boolean check(Food food) {
        int percent = percent(food);
        return percent >= 75;
    }
}
