package ru.job4j.design.lsp;

import java.util.Objects;

/**
 * @author RVohmin
 * @since 17.03.2020
 */
public class Food {
    private String name;
    private String expaireDate;
    private String createDate;
    private double price;
    private int disscount;

    public Food(String name, String createDate, String expaireDate, double price, int disscount) {
        this.name = name;
        this.expaireDate = expaireDate;
        this.createDate = createDate;
        this.price = price;
        this.disscount = disscount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExpaireDate() {
        return expaireDate;
    }

    public String getCreateDate() {
        return createDate;
    }

    public double getPrice() {
        return price;
    }

    public void setDisscount(int disscount) {
        this.disscount = disscount;
    }

    public int getDisscount() {
        return disscount;
    }

    @Override
    public String toString() {
        return "Food{"
                + "name='" + name + '\''
                + ", createDate='" + createDate + '\''
                + ", expaireDate='" + expaireDate + '\''
                + ", price=" + price
                + ", disscount=" + disscount + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Food)) {
            return false;
        }
        Food food = (Food) o;
        return disscount == food.disscount && Double.compare(food.getPrice(),
                getPrice()) == 0 && Objects.equals(getName(),
                food.getName()) && Objects.equals(getExpaireDate(),
                food.getExpaireDate()) && Objects.equals(getCreateDate(),
                food.getCreateDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getExpaireDate(), getCreateDate(), getPrice(), disscount);
    }
}
