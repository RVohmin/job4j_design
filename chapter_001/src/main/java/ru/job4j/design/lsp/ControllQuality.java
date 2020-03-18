package ru.job4j.design.lsp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author RVohmin
 * @since 17.03.2020
 */
public class ControllQuality {
    private Box storage;

    Shop shop = new Shop();
    Trash trash = new Trash();
    Warehouse warehouse = new Warehouse();

    private Box getStorage(Food food) {
        String createDate = food.getCreateDate();
        String expireDate = food.getExpaireDate();
        String nowDate = "18.03.2020";
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        Date dateBegin, dateEnd, dateNow;
        int percent = 0;
        try {
            dateBegin = format.parse(createDate);
            dateEnd = format.parse(expireDate);
            dateNow = format.parse(nowDate);
            int daysAll = (int) ((dateEnd.getTime() - dateBegin.getTime()) / (24 * 60 * 60 * 1000));
            int daysToNow = (int) ((dateNow.getTime() - dateBegin.getTime()) / (24 * 60 * 60 * 1000));
            percent = daysToNow * 100 / daysAll;
        } catch (Exception e) {
            System.out.println("Ошибка в преобразовании даты" + e.getMessage());
        }
        if (percent < 25) {
            storage = warehouse;
        } else if (percent < 75) {
            storage = shop;
        } else if (percent < 100) {
            food.setDisscount(50);
            storage = shop;
        } else {
            storage = trash;
        }
        return storage;
    }

    public void addFoodToStorage(Food food) {
        getStorage(food).add(food);
    }
}
