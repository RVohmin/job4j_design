package ru.job4j.design.lsp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author RVohmin
 * @since 17.03.2020
 */
public class ControllQuality {

    private List<Box> storage;

    public List<Box> getStorage() {
        return storage;
    }

    public ControllQuality(List<Box> box) {
        storage = box;
    }

    public void addFoodToStorage(Food food) {
        storage.stream().filter(x -> x.check(food)).forEach(x -> x.add(food));
    }
}
