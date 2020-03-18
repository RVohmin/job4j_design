package ru.job4j.design.lsp;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author RVohmin
 * @since 17.03.2020
 */
public class Shop implements Box {
    private List<Food> shopList = new ArrayList<>();

    public List<Food> getList() {
        return shopList;
    }

    @Override
    public void add(Food food) {
        shopList.add(food);
    }

    @Override
    public boolean check(Food food) {
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
        if (percent >= 25 && percent < 75) {
            add(food);
            return true;
        } else if (percent > 75) {
            food.setDisscount(50);
            add(food);
            return true;
        }
        return false;
    }
}
