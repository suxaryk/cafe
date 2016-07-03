package cafe.model;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Dish {

    private int dbId;
    private String title;
    private int price;
    private boolean cook;
    private Map<Integer, Ingredient> recipe = new TreeMap<>();

    public Dish() {
    }

    public Dish(int dbId, String title, int price, boolean cook, Map<Integer, Ingredient> recipe) {
        this.dbId = dbId;
        this.title = title;
        this.price = price;
        this.cook = cook;
        if (recipe != null) {
            this.recipe = recipe;
        }

    }

    public Dish(String title, int price, boolean cook) {
        this.title = title;
        this.price = price;
        this.cook = cook;
    }

    public Dish(String title, int price) {
        this.title = title;
        this.price = price;
    }

    public Dish(String title) {
        this.title = title;
    }

    public int getDbID() {
        return dbId;
    }

    public void setDbID(int dbId) {
        this.dbId = dbId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void addTitle(String title) {
        this.title = title + this.title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Map<Integer, Ingredient> getRecipe() {
        return recipe;
    }

    public void setRecipe(Map<Integer, Ingredient> list) {
        this.recipe = list;
    }

    public boolean isCook() {
        return this.cook;
    }

    public void setCook(boolean cook) {
        this.cook = cook;
    }

    @Override
    public String toString() {
        return title;
    }

}
