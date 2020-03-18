package ru.job4j.design.lsp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author RVohmin
 * @since 17.03.2020
 */
public class ControllQuality {

    private List<Box> storage = Arrays.asList();

    public ControllQuality(Box shop, Box trash, Box warehouse) {
        storage.add(shop);
        storage.add(trash);
        storage.add(warehouse);
    }

    public void addFoodToStorage(Food food) {
        storage.stream().filter(x -> x.check(food)).forEach(x -> x.add(food));
    }
}
