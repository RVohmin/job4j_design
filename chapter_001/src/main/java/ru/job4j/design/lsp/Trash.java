package ru.job4j.design.lsp;

import java.util.ArrayList;
import java.util.List;

/**
 * @author RVohmin
 * @since 17.03.2020
 */
public class Trash implements Box {
    private List<Food> trashList = new ArrayList<>();

    public List<Food> getTrashList() {
        return trashList;
    }

    @Override
    public void add(Food food) {
        trashList.add(food);
    }
}
