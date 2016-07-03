package cafe.model;

import static cafe.view.MainForm.activeCat;
import static cafe.view.MainForm.activeDishes;
import static cafe.view.MainForm.menu;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OrderItem {

    private Dish dish;
    private int count;
    private int itemSum;
    private boolean printed;
    private boolean cook;
    private boolean realized;

    public OrderItem() {
    }

    public OrderItem(Dish dish, int count, boolean cook) {
        this.dish = dish;
        this.count = count;
        itemSum = dish.getPrice() * count;
        this.cook = cook;
    }

    public OrderItem(Dish dish, int count) {
        this.dish = dish;
        this.count = count;
        itemSum = dish.getPrice() * count;
    }

    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
        this.itemSum = this.count * dish.getPrice();
    }

    public int getCookCount() {
        if (dish.isCook()) {
            return count;
        } else {
            return 0;
        }
    }

    public void addCount(int count) {
        this.count += count;
        this.itemSum = this.count * dish.getPrice();
    }

    public void reverseCount() {
        this.count = this.count * (-1);
    }

    public int getSum() {
        return itemSum;
    }

    public void setSum(int sum) {
        this.itemSum = sum;
    }

    public boolean isPrinted() {
        return printed;
    }

    public void setPrinted(boolean printed) {
        this.printed = printed;
    }

    public boolean isCook() {
        return cook;
    }

    public void setCook(boolean cook) {
        this.cook = cook;
    }

    public boolean isRealized() {
        return realized;
    }

    public void setRealized(boolean realized) {
        this.realized = realized;
    }

    public List<Ingredient> getOrderItemRecipe() {
        List<Ingredient> itemRecipe = new ArrayList<>();
        Map<Integer, Ingredient> recipe = menu.get(activeCat).getDishes().get(activeDishes).getRecipe();
        for (Map.Entry<Integer, Ingredient> dish_ing : recipe.entrySet()) {
            itemRecipe.add(new Ingredient(dish_ing.getValue().getId(), dish_ing.getValue().getCount() * count));
        }       
        return itemRecipe;
    }

    @Override
    public boolean equals(Object obj) {
        try {
            return this.getDish().getTitle().equals(((OrderItem) obj).getDish().getTitle());
        } catch (Exception e) {
            return false;
        }
    }

}
