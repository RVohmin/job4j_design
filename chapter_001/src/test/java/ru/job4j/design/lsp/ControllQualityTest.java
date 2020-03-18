package ru.job4j.design.lsp;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

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
        ControllQuality meth = new ControllQuality();
        meth.addFoodToStorage(milk);
        meth.addFoodToStorage(milk2);
        meth.addFoodToStorage(milk3);
        Food result = meth.shop.getList().get(0);
        assertThat(milk, is(result));
    }

    @Test
    public void addFoodToStorageShopAndSetDiscount() {
        Food milk = new Food("milk", "10.03.2020",
                "20.03.2020",
                100.0,
                0);
        ControllQuality meth = new ControllQuality();
        meth.addFoodToStorage(milk);
        int expected = milk.getDisscount();
        assertThat(expected, is(meth.shop.getShopList().get(0).getDisscount()));
    }

    @Test
    public void whenDateExpairadThenAddFoodToStorageTrash() {
        Food milk2 = new Food("milk2", "10.03.2020",
                "12.03.2020",
                100.0,
                0);
        ControllQuality meth = new ControllQuality();
        meth.addFoodToStorage(milk2);
        assertThat(milk2, is(meth.trash.getTrashList().get(0)));
    }
    @Test
    public void addFoodToStorageWarehouse() {
        Food milk3 = new Food("milk3", "10.03.2020",
                "12.05.2020",
                100.0,
                0);
        ControllQuality meth = new ControllQuality();
        meth.addFoodToStorage(milk3);
        assertThat(milk3, is(meth.warehouse.getWareHouseList().get(0)));
    }
}