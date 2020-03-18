package ru.job4j.design.lsp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author RVohmin
 * @since 17.03.2020
 */
public class ControllQuality {
    Shop shop = new Shop();
    Trash trash = new Trash();
    Warehouse warehouse = new Warehouse();
    List<Box> storage = Arrays.asList(shop, trash, warehouse);
    
    public void addFoodToStorage(Food food) {
        storage.forEach(x -> x.check(food));
    }
}
