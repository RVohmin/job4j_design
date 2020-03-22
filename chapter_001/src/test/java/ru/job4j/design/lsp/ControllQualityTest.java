package ru.job4j.design.lsp;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class ControllQualityTest {

    @Test
    public void addFoodToStorageShop() {
        Food milk = new Food("milk", "10.03.2020",
                "20.03.2020",
                100.0,
                0);
        Food milk2 = new Food("milk2", "10.03.2020",
                "12.03.2020",
                100.0,
                0);
        Food milk3 = new Food("milk3", "10.03.2020",
                "12.05.2020",
                100.0,
                0);
        Shop shop = new Shop();
        Trash trash = new Trash();
        Warehouse warehouse = new Warehouse();
        ControllQuality meth = new ControllQuality(List.of(shop, trash, warehouse));
        meth.addFoodToStorage(milk);
        meth.addFoodToStorage(milk2);
        meth.addFoodToStorage(milk3);
        Box result = meth.getStorage().stream().filter(x -> x.equals(shop)).findFirst().orElseGet(null);
        assertEquals(shop, result);
    }

    @Test
    public void addFoodToStorageShopAndSetDiscount() {
        Food milk = new Food("milk", "10.03.2020",
                "20.03.2020",
                100.0,
                0);
        Shop shop = new Shop();
        ControllQuality meth = new ControllQuality(List.of(shop));
        meth.addFoodToStorage(milk);
        Shop expected = new Shop();
        expected.add(milk);
        assertEquals(shop, expected);
    }

    @Test
    public void whenDateExpairadThenAddFoodToStorageTrash() {
        Food milk2 = new Food("milk2", "10.03.2020",
                "12.03.2020",
                100.0,
                0);
        Shop shop = new Shop();
        Trash trash = new Trash();
        Warehouse warehouse = new Warehouse();
        ControllQuality meth = new ControllQuality(List.of(shop, trash, warehouse));
        meth.addFoodToStorage(milk2);
        Box result = meth.getStorage().stream().filter(x -> x.equals(warehouse)).findFirst().orElseGet(null);
        assertEquals(warehouse, result);
    }
    @Test
    public void addFoodToStorageWarehouse() {
        Food milk3 = new Food("milk3", "10.03.2020",
                "12.05.2020",
                100.0,
                0);
        Shop shop = new Shop();
        Trash trash = new Trash();
        Warehouse warehouse = new Warehouse();
        ControllQuality meth = new ControllQuality(List.of(shop, trash, warehouse));
        meth.addFoodToStorage(milk3);
        Box result = meth.getStorage().stream().filter(x -> x.equals(warehouse)).findFirst().orElseGet(null);
        assertEquals(warehouse, result);
    }
}