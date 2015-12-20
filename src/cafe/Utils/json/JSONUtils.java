package cafe.Utils.json;

import cafe.Utils.db.RecepiesUtils;
import cafe.model.Dish;
import cafe.model.Ingredient;
import cafe.model.OrderItem;
import static cafe.view.MainForm.menu;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author suxarina
 */
public class JSONUtils {

    //data to JSON
    public static void updateDishIngredients(List<Ingredient> recipes,
            int activeCat, int activeDish) {
        JSONArray jsonArr = new JSONArray();
        for (Ingredient ing : recipes) {
            JSONObject ingrObj = new JSONObject();
            ingrObj.put("id", ing.getId());
            ingrObj.put("c", ing.getCount());
            jsonArr.add(ingrObj);
        }
        RecepiesUtils.updateRecipes(activeCat, menu.get(activeCat).getDishes()
                .get(activeDish)
                .getDbID(), jsonArr.toJSONString());

    }

    public static List<Ingredient> getRecipeFromJSON(String jsonRecipes) {
        if (!"".equals(jsonRecipes)) {
            try {
                JSONParser parser = new JSONParser();
                Object obj = parser.parse(jsonRecipes);
                JSONArray jsonArr = (JSONArray) obj;
                List<Ingredient> recipe = new ArrayList<>();
                for (Object jsonArr1 : jsonArr) {
                    JSONObject jsonObj = (JSONObject) jsonArr1;
                    int Id = Integer.parseInt(jsonObj.get("id").toString());
                    double count = Double.parseDouble(jsonObj.
                            get("c").toString());
                    recipe.add(new Ingredient(Id, count));
                }
                return recipe;
            } catch (ParseException ex) {
                System.out.println("Error parse =" + Dish.class.getName());
            }
        }
        {
            return null;
        }

    }

    public static String convertOrderToJSON(ArrayList<OrderItem> items) {
        JSONArray jsonArr = new JSONArray();
        for (OrderItem item : items) {
            JSONObject itemObj = new JSONObject();
            itemObj.put("tit", item.getDish().getTitle());
            itemObj.put("price", item.getDish().getPrice());
            itemObj.put("count", item.getCount());
            itemObj.put("cook", item.isCook());
            jsonArr.add(itemObj);
        }
        return jsonArr.toJSONString();

    }

    public static ArrayList<OrderItem> convertJSONToOrder(String jsonOrder) {
        if (!"[]".equals(jsonOrder)) {
            ArrayList<OrderItem> list = new ArrayList<>();
            try {
                JSONParser parser = new JSONParser();
                Object obj = parser.parse(jsonOrder);
                JSONArray jsonArr = (JSONArray) obj;
                for (Object jsonArr1 : jsonArr) {
                    JSONObject jsonObj = (JSONObject) jsonArr1;
                    String title = jsonObj.get("tit").toString();
                    int price = Integer.parseInt(jsonObj.get("price").toString());
                    int count = Integer.parseInt(jsonObj.
                            get("count").toString());
                    Boolean isCook = Boolean.parseBoolean(jsonObj.get("cook").toString());

                    list.add(new OrderItem(new Dish(title, price), count, isCook));
                }
            } catch (ParseException ex) {
                System.out.println("Error parse =" + Dish.class.getName() + " or it`s inkass order");
            }
            return list;
        }
        return new ArrayList<>();
    }

    public static String convertRemovedIngToJSON(List<Ingredient> removedList) {
        JSONArray jsonArr = new JSONArray();
        for (Ingredient ing : removedList) {
            JSONObject itemObj = new JSONObject();
            itemObj.put("id", ing.getId());
            itemObj.put("count", ing.getCount());
            jsonArr.add(itemObj);
        }
        return jsonArr.toJSONString();

    }

    public static List<Ingredient> convertJSONToRemovedIng(String json) {
        if (!"[]".equals(json)) {
            List<Ingredient> list = new LinkedList<>();
            try {
                JSONParser parser = new JSONParser();
                Object obj = parser.parse(json);
                JSONArray jsonArr = (JSONArray) obj;
                for (Object jsonArr1 : jsonArr) {
                    JSONObject jsonObj = (JSONObject) jsonArr1;
                    int id = Integer.parseInt(jsonObj.get("id").toString());
                    double count = Double.parseDouble(jsonObj.
                            get("count").toString());
                    list.add(new Ingredient(id, count));
                }
            } catch (ParseException ex) {
                System.out.println("Error parse convertJSONToRemovedIng");
            }
            return list;
        }
        return new ArrayList<>();
    }

}
