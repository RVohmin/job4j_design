package ru.job4j.design.lsp;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author RVohmin
 * @since 17.03.2020
 */
public class Trash implements Box {
    private List<Food> trashList = new ArrayList<>();

    public List<Food> getList() {
        return trashList;
    }

    @Override
    public void add(Food food) {
        trashList.add(food);
    }

    @Override
    public boolean check(Food food) {
        return percent(food) <= 0;
    }
}
