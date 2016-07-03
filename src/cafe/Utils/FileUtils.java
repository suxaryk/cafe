
package cafe.Utils;

import cafe.model.Ingredient;
import static cafe.view.MainForm.menu;
import java.util.ArrayList;

/**
 *
 * @author suxarina
 */
public class FileUtils {
    private static final ArrayList<Ingredient> rollAdds = new ArrayList<>();
    
    
     static{
        rollAdds.add(new Ingredient(15, 0.010));
        rollAdds.add(new Ingredient(20, 0.005));
        rollAdds.add(new Ingredient(21, 0.015));
        rollAdds.add(new Ingredient(22, 0.025)); 
        
     }
        
      
    public static void readFile(){
//        for (int i = 0; i < menu.size(); i++) {
//            for (int j = 0; j < menu.get(i).size(); j++) {
//                menu.get(i).get(j).getRecipe().add(new Ingredient(1, 0.002));                
//            }            
//        }
        
            
        
    }
    public static void fillIngredients(){
        //Sushi
//        menu.get(7).getDishes().get(0).getRecipe().add(new Ingredient(1, 0.069)); //w kunrz z wugrem
//        menu.get(7).getDishes().get(0).getRecipe().add(new Ingredient(2, 0.002));
//        menu.get(7).getDishes().get(0).getRecipe().add(new Ingredient(3, 0.012));
//        menu.get(7).getDishes().get(0).getRecipe().add(new Ingredient(4, 0.008));
//        menu.get(7).getDishes().get(0).getRecipe().add(new Ingredient(5, 0.001));
//        menu.get(7).getDishes().get(0).getRecipe().add(new Ingredient(6, 0.5));
//        menu.get(7).getDishes().get(0).getRecipe().add(new Ingredient(7, 0.020));
//        menu.get(7).getDishes().get(0).getRecipe().add(new Ingredient(16, 0.015));
//        menu.get(7).getDishes().get(0).getRecipe().add(new Ingredient(14, 0.015)); //Wugor
//        menu.get(7).getDishes().get(0).getRecipe().add(new Ingredient(11, 0.018));
//        menu.get(7).getDishes().get(0).getRecipe().add(new Ingredient(12, 0.010));
//
//        menu.get(7).getDishes().get(1).getRecipe().add(new Ingredient(1, 0.069)); //w kunrz z lososem
//        menu.get(7).getDishes().get(1).getRecipe().add(new Ingredient(2, 0.002));
//        menu.get(7).getDishes().get(1).getRecipe().add(new Ingredient(3, 0.012));
//        menu.get(7).getDishes().get(1).getRecipe().add(new Ingredient(4, 0.008));
//        menu.get(7).getDishes().get(1).getRecipe().add(new Ingredient(5, 0.001));
//        menu.get(7).getDishes().get(1).getRecipe().add(new Ingredient(6, 0.5));
//        menu.get(7).getDishes().get(1).getRecipe().add(new Ingredient(7, 0.020));
//        menu.get(7).getDishes().get(1).getRecipe().add(new Ingredient(16, 0.015));
//        menu.get(7).getDishes().get(1).getRecipe().add(new Ingredient(11, 0.017));
//        menu.get(7).getDishes().get(1).getRecipe().add(new Ingredient(10, 0.015));
//
//        menu.get(7).getDishes().get(2).getRecipe().add(new Ingredient(1, 0.069)); //w kunrz z tuncem
//        menu.get(7).getDishes().get(2).getRecipe().add(new Ingredient(2, 0.002));
//        menu.get(7).getDishes().get(2).getRecipe().add(new Ingredient(3, 0.012));
//        menu.get(7).getDishes().get(2).getRecipe().add(new Ingredient(4, 0.008));
//        menu.get(7).getDishes().get(2).getRecipe().add(new Ingredient(5, 0.001));
//        menu.get(7).getDishes().get(2).getRecipe().add(new Ingredient(6, 0.5));
//        menu.get(7).getDishes().get(2).getRecipe().add(new Ingredient(7, 0.020));
//        menu.get(7).getDishes().get(2).getRecipe().add(new Ingredient(16, 0.015));
//        menu.get(7).getDishes().get(2).getRecipe().add(new Ingredient(11, 0.017));
//        menu.get(7).getDishes().get(2).getRecipe().add(new Ingredient(13, 0.015));
//        
//        menu.get(7).getDishes().get(3).getRecipe().add(new Ingredient(1, 0.069)); //z ikr z wugrem
//        menu.get(7).getDishes().get(3).getRecipe().add(new Ingredient(2, 0.002));
//        menu.get(7).getDishes().get(3).getRecipe().add(new Ingredient(3, 0.012));
//        menu.get(7).getDishes().get(3).getRecipe().add(new Ingredient(4, 0.008));
//        menu.get(7).getDishes().get(3).getRecipe().add(new Ingredient(5, 0.001));
//        menu.get(7).getDishes().get(3).getRecipe().add(new Ingredient(6, 0.5));
//        menu.get(7).getDishes().get(3).getRecipe().add(new Ingredient(7, 0.020));
//        menu.get(7).getDishes().get(3).getRecipe().add(new Ingredient(16, 0.015));
//        menu.get(7).getDishes().get(3).getRecipe().add(new Ingredient(9, 0.010));
//        menu.get(7).getDishes().get(3).getRecipe().add(new Ingredient(14, 0.015));
//        menu.get(7).getDishes().get(3).getRecipe().add(new Ingredient(12, 0.010));
//        
//        menu.get(7).getDishes().get(4).getRecipe().add(new Ingredient(1, 0.069)); //z ikr z losossem
//        menu.get(7).getDishes().get(4).getRecipe().add(new Ingredient(2, 0.002));
//        menu.get(7).getDishes().get(4).getRecipe().add(new Ingredient(3, 0.012));
//        menu.get(7).getDishes().get(4).getRecipe().add(new Ingredient(4, 0.008));
//        menu.get(7).getDishes().get(4).getRecipe().add(new Ingredient(5, 0.001));
//        menu.get(7).getDishes().get(4).getRecipe().add(new Ingredient(6, 0.5));
//        menu.get(7).getDishes().get(4).getRecipe().add(new Ingredient(7, 0.020));
//        menu.get(7).getDishes().get(4).getRecipe().add(new Ingredient(16, 0.015));
//        menu.get(7).getDishes().get(4).getRecipe().add(new Ingredient(9, 0.010));
//        menu.get(7).getDishes().get(4).getRecipe().add(new Ingredient(10, 0.015));
//        
//        menu.get(7).getDishes().get(5).getRecipe().add(new Ingredient(1, 0.069)); //z ikr z tuncem
//        menu.get(7).getDishes().get(5).getRecipe().add(new Ingredient(2, 0.002));
//        menu.get(7).getDishes().get(5).getRecipe().add(new Ingredient(3, 0.012));
//        menu.get(7).getDishes().get(5).getRecipe().add(new Ingredient(4, 0.008));
//        menu.get(7).getDishes().get(5).getRecipe().add(new Ingredient(5, 0.001));
//        menu.get(7).getDishes().get(5).getRecipe().add(new Ingredient(6, 0.5));
//        menu.get(7).getDishes().get(5).getRecipe().add(new Ingredient(7, 0.020));
//        menu.get(7).getDishes().get(5).getRecipe().add(new Ingredient(16, 0.015));
//        menu.get(7).getDishes().get(5).getRecipe().add(new Ingredient(9, 0.010));
//        menu.get(7).getDishes().get(5).getRecipe().add(new Ingredient(13, 0.015));
//        
//        menu.get(7).getDishes().get(6).getRecipe().add(new Ingredient(1, 0.069)); // Dragon
//        menu.get(7).getDishes().get(6).getRecipe().add(new Ingredient(2, 0.002));
//        menu.get(7).getDishes().get(6).getRecipe().add(new Ingredient(3, 0.012));
//        menu.get(7).getDishes().get(6).getRecipe().add(new Ingredient(4, 0.008));
//        menu.get(7).getDishes().get(6).getRecipe().add(new Ingredient(5, 0.001));
//        menu.get(7).getDishes().get(6).getRecipe().add(new Ingredient(6, 0.5));
//        menu.get(7).getDishes().get(6).getRecipe().add(new Ingredient(7, 0.025));
//        menu.get(7).getDishes().get(6).getRecipe().add(new Ingredient(16, 0.035));
//        menu.get(7).getDishes().get(6).getRecipe().add(new Ingredient(9, 0.005));//Ikra
//        menu.get(7).getDishes().get(6).getRecipe().add(new Ingredient(14, 0.020));//Wugor
//        menu.get(7).getDishes().get(6).getRecipe().add(new Ingredient(12, 0.010));//Unagi
//        menu.get(7).getDishes().get(6).getRecipe().add(new Ingredient(11, 0.005));//Kunrz
//        menu.get(7).getDishes().get(6).getRecipe().add(new Ingredient(8, 0.015)); //Syr Filad
//        
//        menu.get(7).getDishes().get(7).getRecipe().add(new Ingredient(1, 0.069)); // Black Dragon
//        menu.get(7).getDishes().get(7).getRecipe().add(new Ingredient(2, 0.002));
//        menu.get(7).getDishes().get(7).getRecipe().add(new Ingredient(3, 0.012));
//        menu.get(7).getDishes().get(7).getRecipe().add(new Ingredient(4, 0.008));
//        menu.get(7).getDishes().get(7).getRecipe().add(new Ingredient(5, 0.001));
//        menu.get(7).getDishes().get(7).getRecipe().add(new Ingredient(6, 0.5));
//        menu.get(7).getDishes().get(7).getRecipe().add(new Ingredient(7, 0.020));
//        menu.get(7).getDishes().get(7).getRecipe().add(new Ingredient(16, 0.035));
//        menu.get(7).getDishes().get(7).getRecipe().add(new Ingredient(9, 0.005)); //Ikra
//        menu.get(7).getDishes().get(7).getRecipe().add(new Ingredient(10, 0.010)); //Losos`
//        menu.get(7).getDishes().get(7).getRecipe().add(new Ingredient(12, 0.010));//Unagi
//        menu.get(7).getDishes().get(7).getRecipe().add(new Ingredient(11, 0.005)); //Kunrz
//        menu.get(7).getDishes().get(7).getRecipe().add(new Ingredient(8, 0.015)); //Syr Filad
//        
//        menu.get(7).getDishes().get(8).getRecipe().add(new Ingredient(1, 0.069)); // Filadelfia
//        menu.get(7).getDishes().get(8).getRecipe().add(new Ingredient(2, 0.002));
//        menu.get(7).getDishes().get(8).getRecipe().add(new Ingredient(3, 0.012));
//        menu.get(7).getDishes().get(8).getRecipe().add(new Ingredient(4, 0.008));
//        menu.get(7).getDishes().get(8).getRecipe().add(new Ingredient(5, 0.001));
//        menu.get(7).getDishes().get(8).getRecipe().add(new Ingredient(6, 0.5));
//        menu.get(7).getDishes().get(8).getRecipe().add(new Ingredient(7, 0.025));//Ogirok
//        menu.get(7).getDishes().get(8).getRecipe().add(new Ingredient(16, 0.015));//Awokado
//        menu.get(7).getDishes().get(8).getRecipe().add(new Ingredient(10, 0.030)); //Losos`
//        menu.get(7).getDishes().get(8).getRecipe().add(new Ingredient(8, 0.020)); //Syr Filad
//        
//        menu.get(7).getDishes().get(9).getRecipe().add(new Ingredient(1, 0.087)); // Hot roll tunec
//        menu.get(7).getDishes().get(9).getRecipe().add(new Ingredient(2, 0.002));
//        menu.get(7).getDishes().get(9).getRecipe().add(new Ingredient(3, 0.014));
//        menu.get(7).getDishes().get(9).getRecipe().add(new Ingredient(4, 0.011));
//        menu.get(7).getDishes().get(9).getRecipe().add(new Ingredient(5, 0.002));
//        menu.get(7).getDishes().get(9).getRecipe().add(new Ingredient(6, 1));
//        menu.get(7).getDishes().get(9).getRecipe().add(new Ingredient(13, 0.020)); //Tunec`
//        menu.get(7).getDishes().get(9).getRecipe().add(new Ingredient(8, 0.020)); //Syr Filad
//        menu.get(7).getDishes().get(9).getRecipe().add(new Ingredient(9, 0.010)); //Ikra                                                                            
//        menu.get(7).getDishes().get(9).getRecipe().add(new Ingredient(54, 0.200)); //Boroshno      //Kliar
//        menu.get(7).getDishes().get(9).getRecipe().add(new Ingredient(57, 0.0125)); //Пиво
//        menu.get(7).getDishes().get(9).getRecipe().add(new Ingredient(22, 0.030)); //Соєвий соус
//        menu.get(7).getDishes().get(9).getRecipe().add(new Ingredient(5, 0.020)); //Сіль
//        
//        menu.get(7).getDishes().get(10).getRecipe().add(new Ingredient(1, 0.087)); // Hot roll losos
//        menu.get(7).getDishes().get(10).getRecipe().add(new Ingredient(2, 0.002));
//        menu.get(7).getDishes().get(10).getRecipe().add(new Ingredient(3, 0.014));
//        menu.get(7).getDishes().get(10).getRecipe().add(new Ingredient(4, 0.011));
//        menu.get(7).getDishes().get(10).getRecipe().add(new Ingredient(5, 0.002));
//        menu.get(7).getDishes().get(10).getRecipe().add(new Ingredient(6, 1));
//        menu.get(7).getDishes().get(10).getRecipe().add(new Ingredient(10, 0.020)); //Losos`
//        menu.get(7).getDishes().get(10).getRecipe().add(new Ingredient(8, 0.020)); //Syr Filad
//        menu.get(7).getDishes().get(10).getRecipe().add(new Ingredient(9, 0.010)); //Ikra                                                                            
//        menu.get(7).getDishes().get(10).getRecipe().add(new Ingredient(54, 0.200)); //Boroshno      //Kliar
//        menu.get(7).getDishes().get(10).getRecipe().add(new Ingredient(57, 0.0125)); //Пиво
//        menu.get(7).getDishes().get(10).getRecipe().add(new Ingredient(23, 0.030)); //Соєвий соус
//        menu.get(7).getDishes().get(10).getRecipe().add(new Ingredient(5, 0.020)); //Сіль
//        
//        menu.get(7).getDishes().get(11).getRecipe().add(new Ingredient(1, 0.087)); // Hot roll wugor
//        menu.get(7).getDishes().get(11).getRecipe().add(new Ingredient(2, 0.002));
//        menu.get(7).getDishes().get(11).getRecipe().add(new Ingredient(3, 0.014));
//        menu.get(7).getDishes().get(11).getRecipe().add(new Ingredient(4, 0.011));
//        menu.get(7).getDishes().get(11).getRecipe().add(new Ingredient(5, 0.002));
//        menu.get(7).getDishes().get(11).getRecipe().add(new Ingredient(6, 1));
//        menu.get(7).getDishes().get(11).getRecipe().add(new Ingredient(14, 0.020)); //Wugor
//        menu.get(7).getDishes().get(11).getRecipe().add(new Ingredient(8, 0.020)); //Syr Filad
//        menu.get(7).getDishes().get(11).getRecipe().add(new Ingredient(9, 0.010)); //Ikra                                                                            
//        menu.get(7).getDishes().get(11).getRecipe().add(new Ingredient(54, 0.200)); //Boroshno      //Kliar
//        menu.get(7).getDishes().get(11).getRecipe().add(new Ingredient(57, 0.0125)); //Пиво
//        menu.get(7).getDishes().get(11).getRecipe().add(new Ingredient(23, 0.030)); //Соєвий соус
//        menu.get(7).getDishes().get(11).getRecipe().add(new Ingredient(5, 0.020)); //Сіль
//        menu.get(7).getDishes().get(11).getRecipe().add(new Ingredient(12, 0.010));//Unagi
//        menu.get(7).getDishes().get(11).getRecipe().add(new Ingredient(11, 0.005));//Kunrz
//        
//        menu.get(7).getDishes().get(12).getRecipe().add(new Ingredient(1, 0.069)); // White dragon
//        menu.get(7).getDishes().get(12).getRecipe().add(new Ingredient(2, 0.002));
//        menu.get(7).getDishes().get(12).getRecipe().add(new Ingredient(3, 0.012));
//        menu.get(7).getDishes().get(12).getRecipe().add(new Ingredient(4, 0.008));
//        menu.get(7).getDishes().get(12).getRecipe().add(new Ingredient(5, 0.001));
//        menu.get(7).getDishes().get(12).getRecipe().add(new Ingredient(6, 0.5));
//        menu.get(7).getDishes().get(12).getRecipe().add(new Ingredient(7, 0.015));//Ogirok
//        menu.get(7).getDishes().get(12).getRecipe().add(new Ingredient(16, 0.035));//Awokado
//        menu.get(7).getDishes().get(12).getRecipe().add(new Ingredient(8, 0.015)); //Syr Filad
//        menu.get(7).getDishes().get(12).getRecipe().add(new Ingredient(9, 0.010)); //Ikra       
//        menu.get(7).getDishes().get(12).getRecipe().add(new Ingredient(23, 0.060)); //Krevetky                                                                     
//        menu.get(7).getDishes().get(12).getRecipe().add(new Ingredient(12, 0.010));//Unagi
//        menu.get(7).getDishes().get(12).getRecipe().add(new Ingredient(11, 0.005));//Kunrz
//        
//        menu.get(7).getDishes().get(13).getRecipe().add(new Ingredient(1, 0.069)); // Fitajger
//        menu.get(7).getDishes().get(13).getRecipe().add(new Ingredient(2, 0.002));
//        menu.get(7).getDishes().get(13).getRecipe().add(new Ingredient(3, 0.012));
//        menu.get(7).getDishes().get(13).getRecipe().add(new Ingredient(4, 0.008));
//        menu.get(7).getDishes().get(13).getRecipe().add(new Ingredient(5, 0.001));
//        menu.get(7).getDishes().get(13).getRecipe().add(new Ingredient(6, 0.5));
//        menu.get(7).getDishes().get(13).getRecipe().add(new Ingredient(16, 0.015));//Awokado
//        menu.get(7).getDishes().get(13).getRecipe().add(new Ingredient(8, 0.015)); //Syr Filad
//        menu.get(7).getDishes().get(13).getRecipe().add(new Ingredient(14, 0.012)); //Wugor
//        menu.get(7).getDishes().get(13).getRecipe().add(new Ingredient(9, 0.005)); //Ikra       
//        menu.get(7).getDishes().get(13).getRecipe().add(new Ingredient(23, 0.060)); //Krevetky                                                                     
//        menu.get(7).getDishes().get(13).getRecipe().add(new Ingredient(12, 0.010));//Unagi
//        menu.get(7).getDishes().get(13).getRecipe().add(new Ingredient(11, 0.005));//Kunrz
//        
//        menu.get(7).getDishes().get(14).getRecipe().add(new Ingredient(1, 0.069)); // Maguro
//        menu.get(7).getDishes().get(14).getRecipe().add(new Ingredient(2, 0.002));
//        menu.get(7).getDishes().get(14).getRecipe().add(new Ingredient(3, 0.012));
//        menu.get(7).getDishes().get(14).getRecipe().add(new Ingredient(4, 0.008));
//        menu.get(7).getDishes().get(14).getRecipe().add(new Ingredient(5, 0.001));
//        menu.get(7).getDishes().get(14).getRecipe().add(new Ingredient(6, 0.5));
//        menu.get(7).getDishes().get(14).getRecipe().add(new Ingredient(16, 0.020));//Awokado
//        menu.get(7).getDishes().get(14).getRecipe().add(new Ingredient(18, 0.025)); //Czyka
//        menu.get(7).getDishes().get(14).getRecipe().add(new Ingredient(13, 0.015)); //Tunec`
//        menu.get(7).getDishes().get(14).getRecipe().add(new Ingredient(14, 0.040)); //Wugor                                                                       
//        menu.get(7).getDishes().get(14).getRecipe().add(new Ingredient(12, 0.015));//Sous gorichowyj
//        menu.get(7).getDishes().get(14).getRecipe().add(new Ingredient(11, 0.005));//Kunrz
//        
//        menu.get(7).getDishes().get(15).getRecipe().add(new Ingredient(1, 0.047)); // Czuka
//        menu.get(7).getDishes().get(15).getRecipe().add(new Ingredient(2, 0.001));
//        menu.get(7).getDishes().get(15).getRecipe().add(new Ingredient(3, 0.008));
//        menu.get(7).getDishes().get(15).getRecipe().add(new Ingredient(4, 0.006));
//        menu.get(7).getDishes().get(15).getRecipe().add(new Ingredient(5, 0.001));
//        menu.get(7).getDishes().get(15).getRecipe().add(new Ingredient(18, 0.010)); //Czyka                                                                         
//        menu.get(7).getDishes().get(15).getRecipe().add(new Ingredient(12, 0.015));//Sous gorichowyj
//        
//        menu.get(7).getDishes().get(16).getRecipe().add(new Ingredient(1, 0.047)); // Z ogirkom
//        menu.get(7).getDishes().get(16).getRecipe().add(new Ingredient(2, 0.001));
//        menu.get(7).getDishes().get(16).getRecipe().add(new Ingredient(3, 0.008));
//        menu.get(7).getDishes().get(16).getRecipe().add(new Ingredient(4, 0.006));
//        menu.get(7).getDishes().get(16).getRecipe().add(new Ingredient(5, 0.001));
//        menu.get(7).getDishes().get(16).getRecipe().add(new Ingredient(6, 0.5));
//        menu.get(7).getDishes().get(16).getRecipe().add(new Ingredient(7, 0.020));//Ogirok                                                                        
//        menu.get(7).getDishes().get(16).getRecipe().add(new Ingredient(12, 0.010));//Unagi
//        
//        menu.get(7).getDishes().get(17).getRecipe().add(new Ingredient(1, 0.047)); // Z wosmyn i chukoju
//        menu.get(7).getDishes().get(17).getRecipe().add(new Ingredient(2, 0.001));
//        menu.get(7).getDishes().get(17).getRecipe().add(new Ingredient(3, 0.008));
//        menu.get(7).getDishes().get(17).getRecipe().add(new Ingredient(4, 0.006));
//        menu.get(7).getDishes().get(17).getRecipe().add(new Ingredient(5, 0.001));
//        menu.get(7).getDishes().get(17).getRecipe().add(new Ingredient(6, 0.5));
//        menu.get(7).getDishes().get(17).getRecipe().add(new Ingredient(24, 0.020)); //Wosmyn
//        menu.get(7).getDishes().get(17).getRecipe().add(new Ingredient(18, 0.010)); //Czyka 
//        menu.get(7).getDishes().get(17).getRecipe().add(new Ingredient(12, 0.010));//Sous gorichowyj
//        menu.get(7).getDishes().get(17).getRecipe().add(new Ingredient(11, 0.005));//Kunrz
//        
//        menu.get(7).getDishes().get(18).getRecipe().add(new Ingredient(1, 0.081)); // Asorti
//        menu.get(7).getDishes().get(18).getRecipe().add(new Ingredient(2, 0.002));
//        menu.get(7).getDishes().get(18).getRecipe().add(new Ingredient(3, 0.014));
//        menu.get(7).getDishes().get(18).getRecipe().add(new Ingredient(4, 0.007));
//        menu.get(7).getDishes().get(18).getRecipe().add(new Ingredient(5, 0.001));
//        menu.get(7).getDishes().get(18).getRecipe().add(new Ingredient(6, 1));
//        menu.get(7).getDishes().get(18).getRecipe().add(new Ingredient(7, 0.020));//Ogirok  
//        menu.get(7).getDishes().get(18).getRecipe().add(new Ingredient(9, 0.006)); //Ikra  
//        menu.get(7).getDishes().get(18).getRecipe().add(new Ingredient(13, 0.006)); //Tunec`     
//        menu.get(7).getDishes().get(18).getRecipe().add(new Ingredient(23, 0.020)); //Krevetky                                                                     
//        menu.get(7).getDishes().get(18).getRecipe().add(new Ingredient(12, 0.010));//Unagi
//        menu.get(7).getDishes().get(18).getRecipe().add(new Ingredient(11, 0.005));//Kunrz
//        
//        menu.get(7).getDishes().get(19).getRecipe().add(new Ingredient(1, 0.047)); // z tuncem
//        menu.get(7).getDishes().get(19).getRecipe().add(new Ingredient(2, 0.001));
//        menu.get(7).getDishes().get(19).getRecipe().add(new Ingredient(3, 0.008));
//        menu.get(7).getDishes().get(19).getRecipe().add(new Ingredient(4, 0.006));
//        menu.get(7).getDishes().get(19).getRecipe().add(new Ingredient(5, 0.001));
//        menu.get(7).getDishes().get(19).getRecipe().add(new Ingredient(6, 0.5));
//        menu.get(7).getDishes().get(19).getRecipe().add(new Ingredient(13, 0.015)); //tunec
//        
//        menu.get(7).getDishes().get(20).getRecipe().add(new Ingredient(1, 0.047)); // z wugrem
//        menu.get(7).getDishes().get(20).getRecipe().add(new Ingredient(2, 0.001));
//        menu.get(7).getDishes().get(20).getRecipe().add(new Ingredient(3, 0.008));
//        menu.get(7).getDishes().get(20).getRecipe().add(new Ingredient(4, 0.006));
//        menu.get(7).getDishes().get(20).getRecipe().add(new Ingredient(5, 0.001));
//        menu.get(7).getDishes().get(20).getRecipe().add(new Ingredient(6, 0.5));
//        menu.get(7).getDishes().get(20).getRecipe().add(new Ingredient(14, 0.015)); //Wugor      
//        menu.get(7).getDishes().get(20).getRecipe().add(new Ingredient(12, 0.010));
//        
//        menu.get(7).getDishes().get(21).getRecipe().add(new Ingredient(1, 0.047)); // z lososem
//        menu.get(7).getDishes().get(21).getRecipe().add(new Ingredient(2, 0.001));
//        menu.get(7).getDishes().get(21).getRecipe().add(new Ingredient(3, 0.008));
//        menu.get(7).getDishes().get(21).getRecipe().add(new Ingredient(4, 0.006));
//        menu.get(7).getDishes().get(21).getRecipe().add(new Ingredient(5, 0.001));
//        menu.get(7).getDishes().get(21).getRecipe().add(new Ingredient(6, 0.5));
//        menu.get(7).getDishes().get(21).getRecipe().add(new Ingredient(10, 0.015)); //losos
//        
//        menu.get(7).getDishes().get(22).getRecipe().add(new Ingredient(1, 0.012)); // sushi z tuncem
//        menu.get(7).getDishes().get(22).getRecipe().add(new Ingredient(2, 0.002));
//        menu.get(7).getDishes().get(22).getRecipe().add(new Ingredient(3, 0.002));
//        menu.get(7).getDishes().get(22).getRecipe().add(new Ingredient(4, 0.002));
//        menu.get(7).getDishes().get(22).getRecipe().add(new Ingredient(5, 0.001));
//        menu.get(7).getDishes().get(22).getRecipe().add(new Ingredient(13, 0.006)); //tunec
//        
//        menu.get(7).getDishes().get(23).getRecipe().add(new Ingredient(1, 0.012)); // sushi z wugrem
//        menu.get(7).getDishes().get(23).getRecipe().add(new Ingredient(2, 0.001));
//        menu.get(7).getDishes().get(23).getRecipe().add(new Ingredient(3, 0.008));
//        menu.get(7).getDishes().get(23).getRecipe().add(new Ingredient(4, 0.006));
//        menu.get(7).getDishes().get(23).getRecipe().add(new Ingredient(5, 0.001));
//        menu.get(7).getDishes().get(23).getRecipe().add(new Ingredient(6, 0.5));
//        menu.get(7).getDishes().get(23).getRecipe().add(new Ingredient(14, 0.015)); //Wugor      
//        menu.get(7).getDishes().get(23).getRecipe().add(new Ingredient(12, 0.010));
//        
//        menu.get(7).getDishes().get(24).getRecipe().add(new Ingredient(1, 0.012)); // sushi z lososem
//        menu.get(7).getDishes().get(24).getRecipe().add(new Ingredient(2, 0.002));
//        menu.get(7).getDishes().get(24).getRecipe().add(new Ingredient(3, 0.002));
//        menu.get(7).getDishes().get(24).getRecipe().add(new Ingredient(4, 0.002));
//        menu.get(7).getDishes().get(24).getRecipe().add(new Ingredient(5, 0.001));
//        menu.get(7).getDishes().get(24).getRecipe().add(new Ingredient(10, 0.006)); //losos
//        
//        menu.get(7).getDishes().get(25).getRecipe().add(new Ingredient(18, 0.050)); //Salat Czuka
//        menu.get(7).getDishes().get(25).getRecipe().add(new Ingredient(17, 0.015));
//        menu.get(7).getDishes().get(25).getRecipe().add(new Ingredient(15, 0.010));
//        
//        menu.get(7).getDishes().get(26).getRecipe().add(new Ingredient(19, 0.050)); //Rysowa wermishel
//        menu.get(7).getDishes().get(26).getRecipe().add(new Ingredient(17, 0.015));
//        menu.get(7).getDishes().get(27).getRecipe().add(new Ingredient(21, 0.010));
//        menu.get(7).getDishes().get(28).getRecipe().add(new Ingredient(22, 0.010));
//        menu.get(7).getDishes().get(29).getRecipe().add(new Ingredient(20, 0.010));
//        menu.get(7).getDishes().get(30).getRecipe().add(new Ingredient(17, 0.020));

//        for (int i = 0; i <= 24; i++) {
//            menu.get(7).getDishes().get(i).getRecipe().addAll(rollAdds);
//        }
//        //SmallPizza
        //menu.get(5).getDishes().get(0).getRecipe().add(new Ingredient(52, 0.159));
//        menu.get(5).getDishes().get(0).getRecipe().add(new Ingredient(5, 0.002));
//        menu.get(5).getDishes().get(0).getRecipe().add(new Ingredient(4, 0.002));
//        menu.get(5).getDishes().get(0).getRecipe().add(new Ingredient(68, 0.002));
//        menu.get(5).getDishes().get(0).getRecipe().add(new Ingredient(51, 0.014));
//        menu.get(5).getDishes().get(0).getRecipe().add(new Ingredient(96, 0.085));
//        menu.get(5).getDishes().get(0).getRecipe().add(new Ingredient(11, 0.005));
//        menu.get(5).getDishes().get(0).getRecipe().add(new Ingredient(41, 0.100));
//
//        menu.get(5).getDishes().get(1).getRecipe().add(new Ingredient(45, 0.030));
//        menu.get(5).getDishes().get(2).getRecipe().add(new Ingredient(72, 0.030));
//        menu.get(5).getDishes().get(3).getRecipe().add(new Ingredient(73, 0.030));
//        menu.get(5).getDishes().get(4).getRecipe().add(new Ingredient(36, 0.030));
//        
//        menu.get(5).getDishes().get(5).getRecipe().add(new Ingredient(69, 0.030));
//        menu.get(5).getDishes().get(6).getRecipe().add(new Ingredient(47, 0.030));
//        menu.get(5).getDishes().get(7).getRecipe().add(new Ingredient(48, 0.030));
//        menu.get(5).getDishes().get(8).getRecipe().add(new Ingredient(54, 0.040));
//        menu.get(5).getDishes().get(9).getRecipe().add(new Ingredient(63, 0.040));
//        menu.get(5).getDishes().get(10).getRecipe().add(new Ingredient(42, 0.040));
//        menu.get(5).getDishes().get(11).getRecipe().add(new Ingredient(66, 0.030));
//        menu.get(5).getDishes().get(12).getRecipe().add(new Ingredient(74, 0.010));
//        menu.get(5).getDishes().get(13).getRecipe().add(new Ingredient(75, 0.100));
//        menu.get(5).getDishes().get(14).getRecipe().add(new Ingredient(76, 0.030));
//        menu.get(5).getDishes().get(15).getRecipe().add(new Ingredient(68, 0.200));
//        
//        menu.get(6).getDishes().get(0).getRecipe().add(new Ingredient(52, 0.177));  //Big pizza
//        menu.get(6).getDishes().get(0).getRecipe().add(new Ingredient(5, 0.003));
//        menu.get(6).getDishes().get(0).getRecipe().add(new Ingredient(4, 0.003));
//        menu.get(6).getDishes().get(0).getRecipe().add(new Ingredient(68, 0.003));
//        menu.get(6).getDishes().get(0).getRecipe().add(new Ingredient(51, 0.016));
//        menu.get(6).getDishes().get(0).getRecipe().add(new Ingredient(96, 0.135));
//        menu.get(6).getDishes().get(0).getRecipe().add(new Ingredient(11, 0.005));
//        menu.get(6).getDishes().get(0).getRecipe().add(new Ingredient(41, 0.150));
//
//        menu.get(6).getDishes().get(1).getRecipe().add(new Ingredient(72, 0.050));
//        menu.get(6).getDishes().get(2).getRecipe().add(new Ingredient(72, 0.050));
//        menu.get(6).getDishes().get(3).getRecipe().add(new Ingredient(73, 0.050));
//        menu.get(6).getDishes().get(4).getRecipe().add(new Ingredient(36, 0.050));
//        menu.get(6).getDishes().get(5).getRecipe().add(new Ingredient(69, 0.050));
//        menu.get(6).getDishes().get(6).getRecipe().add(new Ingredient(47, 0.050));
//        menu.get(6).getDishes().get(7).getRecipe().add(new Ingredient(48, 0.050));
//        menu.get(6).getDishes().get(8).getRecipe().add(new Ingredient(54, 0.060));
//        menu.get(6).getDishes().get(9).getRecipe().add(new Ingredient(63, 0.060));
//        menu.get(6).getDishes().get(10).getRecipe().add(new Ingredient(42, 0.060));
//        menu.get(6).getDishes().get(11).getRecipe().add(new Ingredient(66, 0.050));
//        menu.get(6).getDishes().get(12).getRecipe().add(new Ingredient(74, 0.015));
//        menu.get(6).getDishes().get(13).getRecipe().add(new Ingredient(75, 0.150));
//        menu.get(6).getDishes().get(14).getRecipe().add(new Ingredient(76, 0.050));
        
        
//   


    }
    public static void writeFile(){
        



        
        
        
        
        
    
    }
        
        
  
        
        
    
    public static void rewriteFile(){
        
    }
    
}
