/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cafe.Utils.json;

import cafe.Utils.FileUtils;
import cafe.Utils.db.Dish.RecepiesUtils;
import cafe.model.Dish;
import cafe.model.Ingredient;
import static cafe.view.MainForm.listofCat;
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
//    public static void writeAllIngredients(){
//        int Cat = 7;
//        System.out.println("catSize+ " + listofCat.get(Cat).size());
//        FileUtils.fillIngredients();
//        
//        
//        
//        for (Dish dish : listofCat.get(Cat)) {  
//            JSONArray jsonArr = new JSONArray();
//            for (Ingredient ing : dish.getListOfIngredients()) { 
//                JSONObject ingrObj = new JSONObject();
////                ingrObj.put(ing.getId(), ing.getCount());
//                ingrObj.put("id", ing.getId());                
//                ingrObj.put("c", ing.getCount());   
//                jsonArr.add(ingrObj);              
//            }
//            
//            
//            System.out.println("json" + jsonArr.toJSONString());
//            RecepiesUtils.updateRecipes(Cat, dish.getDbID(), jsonArr.toJSONString());
//            //recipes.clear();
//        }
//    }
    //data to JSON
    public static void updateDishIngredients(List<Ingredient> recipes, 
                                                int activeCat, int activeDish){
        JSONArray jsonArr = new JSONArray();
        for (Ingredient ing : recipes) {
            JSONObject ingrObj = new JSONObject();
            ingrObj.put("id", ing.getId());
            ingrObj.put("c", ing.getCount());
            jsonArr.add(ingrObj);            
        }
        RecepiesUtils.updateRecipes(activeCat, listofCat.get(activeCat)
                                             .get(activeDish)
                                             .getDbID(), jsonArr.toJSONString());
        
        
    }
    //JSON String to data
    public static void JSONToRecipes(String jsonRecipes, int activeCat, 
                                                       int activeDish){
        if (!"".equals(jsonRecipes)) {
            try {
                JSONParser parser = new JSONParser();
                Object obj = parser.parse(jsonRecipes);
                JSONArray jsonArr = (JSONArray) obj;
                listofCat.get(activeCat).get(activeDish)
                        .getListOfIngredients().clear();
                for (int i = 0; i < jsonArr.size(); i++) {
                    JSONObject jsonObj = (JSONObject) jsonArr.get(i);
                    int Id = Integer.parseInt(jsonObj.get("id").toString());                    
                    double count = Double.parseDouble(jsonObj.
                                                        get("c").toString());                  
                    listofCat.get(activeCat).get(activeDish)
                            .getListOfIngredients().add(new Ingredient(Id, count));                                    
                }
            } catch (ParseException ex) {

                System.out.println("Error parse =" + Dish.class.getName());
            }
        }
    }


}
