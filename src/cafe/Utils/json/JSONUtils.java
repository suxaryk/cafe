/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cafe.Utils.json;

import cafe.Utils.FileUtils;
import cafe.Utils.db.RecepiesUtils;
import cafe.model.Dish;
import cafe.model.Ingredient;
import static cafe.view.MainForm.listofCat;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author suxarina
 */
public class JSONUtils {
    public static void writeAllIngredients(){
        System.out.println("catSize+ " + listofCat.get(7).size());
        FileUtils.fillIngredients();
        
        
        
        for (Dish dish : listofCat.get(7)) {  
            JSONArray recipes = new JSONArray();
            for (Ingredient ing : dish.getListOfIngredients()) { 
                JSONObject ingrObj = new JSONObject();
//                ingrObj.put(ing.getId(), ing.getCount());
                ingrObj.put("ingId", ing.getId());                
                ingrObj.put("count", ing.getCount());   
                recipes.add(ingrObj);              
            }
            
            
            System.out.println("json" + recipes.toJSONString());
            RecepiesUtils.updateRecipes(dish.getDbID(), recipes.toJSONString());
            //recipes.clear();
        }
    }

    public static String getJsonString() {       
        
        
        
        
        
        JSONObject recipes = new JSONObject();
        recipes.put(1, 0.069);
        recipes.put(2, 0.002);
        recipes.put(3, 0.012);
        recipes.put(4, 0.008);
        recipes.put(5, 0.001);
        recipes.put(6, 0.5);
        recipes.put(7, 0.020);
        recipes.put(16, 0.015);
        recipes.put(14, 0.015);
        recipes.put(11, 0.018);
        recipes.put(12, 0.010);
        
        
        System.out.println(recipes.toJSONString());             
        System.out.println("JSON size" + recipes.toJSONString().length());

        return recipes.toJSONString();
       
    }

}
