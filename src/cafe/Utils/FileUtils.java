
package cafe.Utils;

import cafe.model.Ingredient;
import static cafe.view.MainForm.listofCat;
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
//        for (int i = 0; i < listofCat.size(); i++) {
//            for (int j = 0; j < listofCat.get(i).size(); j++) {
//                listofCat.get(i).get(j).getListOfIngredients().add(new Ingredient(1, 0.002));                
//            }            
//        }
        
            
        
    }
    private static void fillIngredients(){
        //Sushi
        listofCat.get(6).get(0).getListOfIngredients().add(new Ingredient(1, 0.069)); //w kunrz z wugrem
        listofCat.get(6).get(0).getListOfIngredients().add(new Ingredient(2, 0.002));
        listofCat.get(6).get(0).getListOfIngredients().add(new Ingredient(3, 0.012));
        listofCat.get(6).get(0).getListOfIngredients().add(new Ingredient(4, 0.008));
        listofCat.get(6).get(0).getListOfIngredients().add(new Ingredient(5, 0.001));
        listofCat.get(6).get(0).getListOfIngredients().add(new Ingredient(6, 0.5));
        listofCat.get(6).get(0).getListOfIngredients().add(new Ingredient(7, 0.020));
        listofCat.get(6).get(0).getListOfIngredients().add(new Ingredient(16, 0.015));
        listofCat.get(6).get(0).getListOfIngredients().add(new Ingredient(14, 0.015)); //Wugor
        listofCat.get(6).get(0).getListOfIngredients().add(new Ingredient(11, 0.018));
        listofCat.get(6).get(0).getListOfIngredients().add(new Ingredient(12, 0.010));

        listofCat.get(6).get(1).getListOfIngredients().add(new Ingredient(1, 0.069)); //w kunrz z lososem
        listofCat.get(6).get(1).getListOfIngredients().add(new Ingredient(2, 0.002));
        listofCat.get(6).get(1).getListOfIngredients().add(new Ingredient(3, 0.012));
        listofCat.get(6).get(1).getListOfIngredients().add(new Ingredient(4, 0.008));
        listofCat.get(6).get(1).getListOfIngredients().add(new Ingredient(5, 0.001));
        listofCat.get(6).get(1).getListOfIngredients().add(new Ingredient(6, 0.5));
        listofCat.get(6).get(1).getListOfIngredients().add(new Ingredient(7, 0.020));
        listofCat.get(6).get(1).getListOfIngredients().add(new Ingredient(16, 0.015));
        listofCat.get(6).get(1).getListOfIngredients().add(new Ingredient(11, 0.017));
        listofCat.get(6).get(1).getListOfIngredients().add(new Ingredient(10, 0.015));

        listofCat.get(6).get(2).getListOfIngredients().add(new Ingredient(1, 0.069)); //w kunrz z tuncem
        listofCat.get(6).get(2).getListOfIngredients().add(new Ingredient(2, 0.002));
        listofCat.get(6).get(2).getListOfIngredients().add(new Ingredient(3, 0.012));
        listofCat.get(6).get(2).getListOfIngredients().add(new Ingredient(4, 0.008));
        listofCat.get(6).get(2).getListOfIngredients().add(new Ingredient(5, 0.001));
        listofCat.get(6).get(2).getListOfIngredients().add(new Ingredient(6, 0.5));
        listofCat.get(6).get(2).getListOfIngredients().add(new Ingredient(7, 0.020));
        listofCat.get(6).get(2).getListOfIngredients().add(new Ingredient(16, 0.015));
        listofCat.get(6).get(2).getListOfIngredients().add(new Ingredient(11, 0.017));
        listofCat.get(6).get(2).getListOfIngredients().add(new Ingredient(13, 0.015));

        listofCat.get(6).get(3).getListOfIngredients().add(new Ingredient(1, 0.069)); //z ikr z wugrem
        listofCat.get(6).get(3).getListOfIngredients().add(new Ingredient(2, 0.002));
        listofCat.get(6).get(3).getListOfIngredients().add(new Ingredient(3, 0.012));
        listofCat.get(6).get(3).getListOfIngredients().add(new Ingredient(4, 0.008));
        listofCat.get(6).get(3).getListOfIngredients().add(new Ingredient(5, 0.001));
        listofCat.get(6).get(3).getListOfIngredients().add(new Ingredient(6, 0.5));
        listofCat.get(6).get(3).getListOfIngredients().add(new Ingredient(7, 0.020));
        listofCat.get(6).get(3).getListOfIngredients().add(new Ingredient(16, 0.015));
        listofCat.get(6).get(3).getListOfIngredients().add(new Ingredient(9, 0.010));
        listofCat.get(6).get(3).getListOfIngredients().add(new Ingredient(14, 0.015));
        listofCat.get(6).get(3).getListOfIngredients().add(new Ingredient(12, 0.010));

        listofCat.get(6).get(4).getListOfIngredients().add(new Ingredient(1, 0.069)); //z ikr z losossem
        listofCat.get(6).get(4).getListOfIngredients().add(new Ingredient(2, 0.002));
        listofCat.get(6).get(4).getListOfIngredients().add(new Ingredient(3, 0.012));
        listofCat.get(6).get(4).getListOfIngredients().add(new Ingredient(4, 0.008));
        listofCat.get(6).get(4).getListOfIngredients().add(new Ingredient(5, 0.001));
        listofCat.get(6).get(4).getListOfIngredients().add(new Ingredient(6, 0.5));
        listofCat.get(6).get(4).getListOfIngredients().add(new Ingredient(7, 0.020));
        listofCat.get(6).get(4).getListOfIngredients().add(new Ingredient(16, 0.015));
        listofCat.get(6).get(4).getListOfIngredients().add(new Ingredient(9, 0.010));
        listofCat.get(6).get(4).getListOfIngredients().add(new Ingredient(10, 0.015));

        listofCat.get(6).get(5).getListOfIngredients().add(new Ingredient(1, 0.069)); //z ikr z tuncem
        listofCat.get(6).get(5).getListOfIngredients().add(new Ingredient(2, 0.002));
        listofCat.get(6).get(5).getListOfIngredients().add(new Ingredient(3, 0.012));
        listofCat.get(6).get(5).getListOfIngredients().add(new Ingredient(4, 0.008));
        listofCat.get(6).get(5).getListOfIngredients().add(new Ingredient(5, 0.001));
        listofCat.get(6).get(5).getListOfIngredients().add(new Ingredient(6, 0.5));
        listofCat.get(6).get(5).getListOfIngredients().add(new Ingredient(7, 0.020));
        listofCat.get(6).get(5).getListOfIngredients().add(new Ingredient(16, 0.015));
        listofCat.get(6).get(5).getListOfIngredients().add(new Ingredient(9, 0.010));
        listofCat.get(6).get(5).getListOfIngredients().add(new Ingredient(13, 0.015));

        listofCat.get(6).get(6).getListOfIngredients().add(new Ingredient(1, 0.069)); // Dragon
        listofCat.get(6).get(6).getListOfIngredients().add(new Ingredient(2, 0.002));
        listofCat.get(6).get(6).getListOfIngredients().add(new Ingredient(3, 0.012));
        listofCat.get(6).get(6).getListOfIngredients().add(new Ingredient(4, 0.008));
        listofCat.get(6).get(6).getListOfIngredients().add(new Ingredient(5, 0.001));
        listofCat.get(6).get(6).getListOfIngredients().add(new Ingredient(6, 0.5));
        listofCat.get(6).get(6).getListOfIngredients().add(new Ingredient(7, 0.025));
        listofCat.get(6).get(6).getListOfIngredients().add(new Ingredient(16, 0.035));
        listofCat.get(6).get(6).getListOfIngredients().add(new Ingredient(9, 0.005));//Ikra
        listofCat.get(6).get(6).getListOfIngredients().add(new Ingredient(14, 0.020));//Wugor
        listofCat.get(6).get(6).getListOfIngredients().add(new Ingredient(12, 0.010));//Unagi
        listofCat.get(6).get(6).getListOfIngredients().add(new Ingredient(11, 0.005));//Kunrz
        listofCat.get(6).get(6).getListOfIngredients().add(new Ingredient(8, 0.015)); //Syr Filad

        listofCat.get(6).get(7).getListOfIngredients().add(new Ingredient(1, 0.069)); // Black Dragon
        listofCat.get(6).get(7).getListOfIngredients().add(new Ingredient(2, 0.002));
        listofCat.get(6).get(7).getListOfIngredients().add(new Ingredient(3, 0.012));
        listofCat.get(6).get(7).getListOfIngredients().add(new Ingredient(4, 0.008));
        listofCat.get(6).get(7).getListOfIngredients().add(new Ingredient(5, 0.001));
        listofCat.get(6).get(7).getListOfIngredients().add(new Ingredient(6, 0.5));
        listofCat.get(6).get(7).getListOfIngredients().add(new Ingredient(7, 0.020));
        listofCat.get(6).get(7).getListOfIngredients().add(new Ingredient(16, 0.035));
        listofCat.get(6).get(7).getListOfIngredients().add(new Ingredient(9, 0.005)); //Ikra
        listofCat.get(6).get(7).getListOfIngredients().add(new Ingredient(10, 0.010)); //Losos`
        listofCat.get(6).get(7).getListOfIngredients().add(new Ingredient(12, 0.010));//Unagi
        listofCat.get(6).get(7).getListOfIngredients().add(new Ingredient(11, 0.005)); //Kunrz
        listofCat.get(6).get(7).getListOfIngredients().add(new Ingredient(8, 0.015)); //Syr Filad

        listofCat.get(6).get(8).getListOfIngredients().add(new Ingredient(1, 0.069)); // Filadelfia
        listofCat.get(6).get(8).getListOfIngredients().add(new Ingredient(2, 0.002));
        listofCat.get(6).get(8).getListOfIngredients().add(new Ingredient(3, 0.012));
        listofCat.get(6).get(8).getListOfIngredients().add(new Ingredient(4, 0.008));
        listofCat.get(6).get(8).getListOfIngredients().add(new Ingredient(5, 0.001));
        listofCat.get(6).get(8).getListOfIngredients().add(new Ingredient(6, 0.5));
        listofCat.get(6).get(8).getListOfIngredients().add(new Ingredient(7, 0.025));//Ogirok
        listofCat.get(6).get(8).getListOfIngredients().add(new Ingredient(16, 0.015));//Awokado
        listofCat.get(6).get(8).getListOfIngredients().add(new Ingredient(10, 0.030)); //Losos`
        listofCat.get(6).get(8).getListOfIngredients().add(new Ingredient(8, 0.020)); //Syr Filad

        listofCat.get(6).get(9).getListOfIngredients().add(new Ingredient(1, 0.087)); // Hot roll tunec
        listofCat.get(6).get(9).getListOfIngredients().add(new Ingredient(2, 0.002));
        listofCat.get(6).get(9).getListOfIngredients().add(new Ingredient(3, 0.014));
        listofCat.get(6).get(9).getListOfIngredients().add(new Ingredient(4, 0.011));
        listofCat.get(6).get(9).getListOfIngredients().add(new Ingredient(5, 0.002));
        listofCat.get(6).get(9).getListOfIngredients().add(new Ingredient(6, 1));
        listofCat.get(6).get(9).getListOfIngredients().add(new Ingredient(13, 0.020)); //Tunec`
        listofCat.get(6).get(9).getListOfIngredients().add(new Ingredient(8, 0.020)); //Syr Filad
        listofCat.get(6).get(9).getListOfIngredients().add(new Ingredient(9, 0.010)); //Ikra                                                                            
        listofCat.get(6).get(9).getListOfIngredients().add(new Ingredient(58, 0.200)); //Boroshno      //Kliar
        listofCat.get(6).get(9).getListOfIngredients().add(new Ingredient(63, 0.0125)); //Пиво
        listofCat.get(6).get(9).getListOfIngredients().add(new Ingredient(22, 0.030)); //Соєвий соус
        listofCat.get(6).get(9).getListOfIngredients().add(new Ingredient(5, 0.020)); //Сіль

        listofCat.get(6).get(10).getListOfIngredients().add(new Ingredient(1, 0.087)); // Hot roll losos
        listofCat.get(6).get(10).getListOfIngredients().add(new Ingredient(2, 0.002));
        listofCat.get(6).get(10).getListOfIngredients().add(new Ingredient(3, 0.014));
        listofCat.get(6).get(10).getListOfIngredients().add(new Ingredient(4, 0.011));
        listofCat.get(6).get(10).getListOfIngredients().add(new Ingredient(5, 0.002));
        listofCat.get(6).get(10).getListOfIngredients().add(new Ingredient(6, 1));
        listofCat.get(6).get(10).getListOfIngredients().add(new Ingredient(10, 0.020)); //Losos`
        listofCat.get(6).get(10).getListOfIngredients().add(new Ingredient(8, 0.020)); //Syr Filad
        listofCat.get(6).get(10).getListOfIngredients().add(new Ingredient(9, 0.010)); //Ikra                                                                            
        listofCat.get(6).get(10).getListOfIngredients().add(new Ingredient(58, 0.200)); //Boroshno      //Kliar
        listofCat.get(6).get(10).getListOfIngredients().add(new Ingredient(63, 0.0125)); //Пиво
        listofCat.get(6).get(10).getListOfIngredients().add(new Ingredient(23, 0.030)); //Соєвий соус
        listofCat.get(6).get(10).getListOfIngredients().add(new Ingredient(5, 0.020)); //Сіль

        listofCat.get(6).get(11).getListOfIngredients().add(new Ingredient(1, 0.087)); // Hot roll wugor
        listofCat.get(6).get(11).getListOfIngredients().add(new Ingredient(2, 0.002));
        listofCat.get(6).get(11).getListOfIngredients().add(new Ingredient(3, 0.014));
        listofCat.get(6).get(11).getListOfIngredients().add(new Ingredient(4, 0.011));
        listofCat.get(6).get(11).getListOfIngredients().add(new Ingredient(5, 0.002));
        listofCat.get(6).get(11).getListOfIngredients().add(new Ingredient(6, 1));
        listofCat.get(6).get(11).getListOfIngredients().add(new Ingredient(14, 0.020)); //Wugor
        listofCat.get(6).get(11).getListOfIngredients().add(new Ingredient(8, 0.020)); //Syr Filad
        listofCat.get(6).get(11).getListOfIngredients().add(new Ingredient(9, 0.010)); //Ikra                                                                            
        listofCat.get(6).get(11).getListOfIngredients().add(new Ingredient(58, 0.200)); //Boroshno      //Kliar
        listofCat.get(6).get(11).getListOfIngredients().add(new Ingredient(63, 0.0125)); //Пиво
        listofCat.get(6).get(11).getListOfIngredients().add(new Ingredient(23, 0.030)); //Соєвий соус
        listofCat.get(6).get(11).getListOfIngredients().add(new Ingredient(5, 0.020)); //Сіль
        listofCat.get(6).get(11).getListOfIngredients().add(new Ingredient(12, 0.010));//Unagi
        listofCat.get(6).get(11).getListOfIngredients().add(new Ingredient(11, 0.005));//Kunrz

        listofCat.get(6).get(12).getListOfIngredients().add(new Ingredient(1, 0.069)); // White dragon
        listofCat.get(6).get(12).getListOfIngredients().add(new Ingredient(2, 0.002));
        listofCat.get(6).get(12).getListOfIngredients().add(new Ingredient(3, 0.012));
        listofCat.get(6).get(12).getListOfIngredients().add(new Ingredient(4, 0.008));
        listofCat.get(6).get(12).getListOfIngredients().add(new Ingredient(5, 0.001));
        listofCat.get(6).get(12).getListOfIngredients().add(new Ingredient(6, 0.5));
        listofCat.get(6).get(12).getListOfIngredients().add(new Ingredient(7, 0.015));//Ogirok
        listofCat.get(6).get(12).getListOfIngredients().add(new Ingredient(16, 0.035));//Awokado
        listofCat.get(6).get(12).getListOfIngredients().add(new Ingredient(8, 0.015)); //Syr Filad
        listofCat.get(6).get(12).getListOfIngredients().add(new Ingredient(9, 0.010)); //Ikra       
        listofCat.get(6).get(12).getListOfIngredients().add(new Ingredient(23, 0.060)); //Krevetky                                                                     
        listofCat.get(6).get(12).getListOfIngredients().add(new Ingredient(12, 0.010));//Unagi
        listofCat.get(6).get(12).getListOfIngredients().add(new Ingredient(11, 0.005));//Kunrz

        listofCat.get(6).get(13).getListOfIngredients().add(new Ingredient(1, 0.069)); // Fitajger
        listofCat.get(6).get(13).getListOfIngredients().add(new Ingredient(2, 0.002));
        listofCat.get(6).get(13).getListOfIngredients().add(new Ingredient(3, 0.012));
        listofCat.get(6).get(13).getListOfIngredients().add(new Ingredient(4, 0.008));
        listofCat.get(6).get(13).getListOfIngredients().add(new Ingredient(5, 0.001));
        listofCat.get(6).get(13).getListOfIngredients().add(new Ingredient(6, 0.5));
        listofCat.get(6).get(13).getListOfIngredients().add(new Ingredient(16, 0.015));//Awokado
        listofCat.get(6).get(13).getListOfIngredients().add(new Ingredient(8, 0.015)); //Syr Filad
        listofCat.get(6).get(13).getListOfIngredients().add(new Ingredient(14, 0.012)); //Wugor
        listofCat.get(6).get(13).getListOfIngredients().add(new Ingredient(9, 0.005)); //Ikra       
        listofCat.get(6).get(13).getListOfIngredients().add(new Ingredient(23, 0.060)); //Krevetky                                                                     
        listofCat.get(6).get(13).getListOfIngredients().add(new Ingredient(12, 0.010));//Unagi
        listofCat.get(6).get(13).getListOfIngredients().add(new Ingredient(11, 0.005));//Kunrz

        listofCat.get(6).get(14).getListOfIngredients().add(new Ingredient(1, 0.069)); // Maguro
        listofCat.get(6).get(14).getListOfIngredients().add(new Ingredient(2, 0.002));
        listofCat.get(6).get(14).getListOfIngredients().add(new Ingredient(3, 0.012));
        listofCat.get(6).get(14).getListOfIngredients().add(new Ingredient(4, 0.008));
        listofCat.get(6).get(14).getListOfIngredients().add(new Ingredient(5, 0.001));
        listofCat.get(6).get(14).getListOfIngredients().add(new Ingredient(6, 0.5));
        listofCat.get(6).get(14).getListOfIngredients().add(new Ingredient(16, 0.020));//Awokado
        listofCat.get(6).get(14).getListOfIngredients().add(new Ingredient(18, 0.025)); //Czyka
        listofCat.get(6).get(14).getListOfIngredients().add(new Ingredient(13, 0.015)); //Tunec`
        listofCat.get(6).get(14).getListOfIngredients().add(new Ingredient(14, 0.040)); //Wugor                                                                       
        listofCat.get(6).get(14).getListOfIngredients().add(new Ingredient(12, 0.015));//Sous gorichowyj
        listofCat.get(6).get(14).getListOfIngredients().add(new Ingredient(11, 0.005));//Kunrz

        listofCat.get(6).get(15).getListOfIngredients().add(new Ingredient(1, 0.047)); // Czuka
        listofCat.get(6).get(15).getListOfIngredients().add(new Ingredient(2, 0.001));
        listofCat.get(6).get(15).getListOfIngredients().add(new Ingredient(3, 0.008));
        listofCat.get(6).get(15).getListOfIngredients().add(new Ingredient(4, 0.006));
        listofCat.get(6).get(15).getListOfIngredients().add(new Ingredient(5, 0.001));
        listofCat.get(6).get(15).getListOfIngredients().add(new Ingredient(18, 0.010)); //Czyka                                                                         
        listofCat.get(6).get(15).getListOfIngredients().add(new Ingredient(12, 0.015));//Sous gorichowyj

        listofCat.get(6).get(16).getListOfIngredients().add(new Ingredient(1, 0.047)); // Z ogirkom
        listofCat.get(6).get(16).getListOfIngredients().add(new Ingredient(2, 0.001));
        listofCat.get(6).get(16).getListOfIngredients().add(new Ingredient(3, 0.008));
        listofCat.get(6).get(16).getListOfIngredients().add(new Ingredient(4, 0.006));
        listofCat.get(6).get(16).getListOfIngredients().add(new Ingredient(5, 0.001));
        listofCat.get(6).get(16).getListOfIngredients().add(new Ingredient(6, 0.5));
        listofCat.get(6).get(16).getListOfIngredients().add(new Ingredient(7, 0.020));//Ogirok                                                                        
        listofCat.get(6).get(16).getListOfIngredients().add(new Ingredient(12, 0.010));//Unagi

        listofCat.get(6).get(17).getListOfIngredients().add(new Ingredient(1, 0.047)); // Z wosmyn i chukoju
        listofCat.get(6).get(17).getListOfIngredients().add(new Ingredient(2, 0.001));
        listofCat.get(6).get(17).getListOfIngredients().add(new Ingredient(3, 0.008));
        listofCat.get(6).get(17).getListOfIngredients().add(new Ingredient(4, 0.006));
        listofCat.get(6).get(17).getListOfIngredients().add(new Ingredient(5, 0.001));
        listofCat.get(6).get(17).getListOfIngredients().add(new Ingredient(6, 0.5));
        listofCat.get(6).get(17).getListOfIngredients().add(new Ingredient(24, 0.020)); //Wosmyn
        listofCat.get(6).get(17).getListOfIngredients().add(new Ingredient(18, 0.010)); //Czyka 
        listofCat.get(6).get(17).getListOfIngredients().add(new Ingredient(12, 0.010));//Sous gorichowyj
        listofCat.get(6).get(17).getListOfIngredients().add(new Ingredient(11, 0.005));//Kunrz

        listofCat.get(6).get(18).getListOfIngredients().add(new Ingredient(1, 0.081)); // Asorti
        listofCat.get(6).get(18).getListOfIngredients().add(new Ingredient(2, 0.002));
        listofCat.get(6).get(18).getListOfIngredients().add(new Ingredient(3, 0.014));
        listofCat.get(6).get(18).getListOfIngredients().add(new Ingredient(4, 0.007));
        listofCat.get(6).get(18).getListOfIngredients().add(new Ingredient(5, 0.001));
        listofCat.get(6).get(18).getListOfIngredients().add(new Ingredient(6, 1));
        listofCat.get(6).get(18).getListOfIngredients().add(new Ingredient(7, 0.020));//Ogirok  
        listofCat.get(6).get(18).getListOfIngredients().add(new Ingredient(9, 0.006)); //Ikra  
        listofCat.get(6).get(18).getListOfIngredients().add(new Ingredient(13, 0.006)); //Tunec`     
        listofCat.get(6).get(18).getListOfIngredients().add(new Ingredient(23, 0.020)); //Krevetky                                                                     
        listofCat.get(6).get(18).getListOfIngredients().add(new Ingredient(12, 0.010));//Unagi
        listofCat.get(6).get(18).getListOfIngredients().add(new Ingredient(11, 0.005));//Kunrz

        listofCat.get(6).get(19).getListOfIngredients().add(new Ingredient(1, 0.047)); // z tuncem
        listofCat.get(6).get(19).getListOfIngredients().add(new Ingredient(2, 0.001));
        listofCat.get(6).get(19).getListOfIngredients().add(new Ingredient(3, 0.008));
        listofCat.get(6).get(19).getListOfIngredients().add(new Ingredient(4, 0.006));
        listofCat.get(6).get(19).getListOfIngredients().add(new Ingredient(5, 0.001));
        listofCat.get(6).get(19).getListOfIngredients().add(new Ingredient(6, 0.5));
        listofCat.get(6).get(19).getListOfIngredients().add(new Ingredient(13, 0.015)); //tunec

        listofCat.get(6).get(20).getListOfIngredients().add(new Ingredient(1, 0.047)); // z wugrem
        listofCat.get(6).get(20).getListOfIngredients().add(new Ingredient(2, 0.001));
        listofCat.get(6).get(20).getListOfIngredients().add(new Ingredient(3, 0.008));
        listofCat.get(6).get(20).getListOfIngredients().add(new Ingredient(4, 0.006));
        listofCat.get(6).get(20).getListOfIngredients().add(new Ingredient(5, 0.001));
        listofCat.get(6).get(20).getListOfIngredients().add(new Ingredient(6, 0.5));
        listofCat.get(6).get(20).getListOfIngredients().add(new Ingredient(14, 0.015)); //Wugor      
        listofCat.get(6).get(20).getListOfIngredients().add(new Ingredient(12, 0.010));

        listofCat.get(6).get(21).getListOfIngredients().add(new Ingredient(1, 0.047)); // z lososem
        listofCat.get(6).get(21).getListOfIngredients().add(new Ingredient(2, 0.001));
        listofCat.get(6).get(21).getListOfIngredients().add(new Ingredient(3, 0.008));
        listofCat.get(6).get(21).getListOfIngredients().add(new Ingredient(4, 0.006));
        listofCat.get(6).get(21).getListOfIngredients().add(new Ingredient(5, 0.001));
        listofCat.get(6).get(21).getListOfIngredients().add(new Ingredient(6, 0.5));
        listofCat.get(6).get(21).getListOfIngredients().add(new Ingredient(10, 0.015)); //losos

        listofCat.get(6).get(22).getListOfIngredients().add(new Ingredient(1, 0.012)); // sushi z tuncem
        listofCat.get(6).get(22).getListOfIngredients().add(new Ingredient(2, 0.002));
        listofCat.get(6).get(22).getListOfIngredients().add(new Ingredient(3, 0.002));
        listofCat.get(6).get(22).getListOfIngredients().add(new Ingredient(4, 0.002));
        listofCat.get(6).get(22).getListOfIngredients().add(new Ingredient(5, 0.001));
        listofCat.get(6).get(22).getListOfIngredients().add(new Ingredient(13, 0.006)); //tunec

        listofCat.get(6).get(23).getListOfIngredients().add(new Ingredient(1, 0.012)); // sushi z wugrem
        listofCat.get(6).get(23).getListOfIngredients().add(new Ingredient(2, 0.001));
        listofCat.get(6).get(23).getListOfIngredients().add(new Ingredient(3, 0.008));
        listofCat.get(6).get(23).getListOfIngredients().add(new Ingredient(4, 0.006));
        listofCat.get(6).get(23).getListOfIngredients().add(new Ingredient(5, 0.001));
        listofCat.get(6).get(23).getListOfIngredients().add(new Ingredient(6, 0.5));
        listofCat.get(6).get(23).getListOfIngredients().add(new Ingredient(14, 0.015)); //Wugor      
        listofCat.get(6).get(23).getListOfIngredients().add(new Ingredient(12, 0.010));

        listofCat.get(6).get(24).getListOfIngredients().add(new Ingredient(1, 0.012)); // sushi z lososem
        listofCat.get(6).get(24).getListOfIngredients().add(new Ingredient(2, 0.002));
        listofCat.get(6).get(24).getListOfIngredients().add(new Ingredient(3, 0.002));
        listofCat.get(6).get(24).getListOfIngredients().add(new Ingredient(4, 0.002));
        listofCat.get(6).get(24).getListOfIngredients().add(new Ingredient(5, 0.001));
        listofCat.get(6).get(24).getListOfIngredients().add(new Ingredient(10, 0.006)); //losos

        listofCat.get(6).get(25).getListOfIngredients().add(new Ingredient(18, 0.050)); //Salat Czuka
        listofCat.get(6).get(25).getListOfIngredients().add(new Ingredient(17, 0.015));
        listofCat.get(6).get(25).getListOfIngredients().add(new Ingredient(15, 0.010));

        listofCat.get(6).get(26).getListOfIngredients().add(new Ingredient(19, 0.050)); //Rysowa wermishel
        listofCat.get(6).get(26).getListOfIngredients().add(new Ingredient(17, 0.015));

        listofCat.get(6).get(27).getListOfIngredients().add(new Ingredient(21, 0.010));
        listofCat.get(6).get(28).getListOfIngredients().add(new Ingredient(22, 0.010));
        listofCat.get(6).get(29).getListOfIngredients().add(new Ingredient(20, 0.010));
        listofCat.get(6).get(30).getListOfIngredients().add(new Ingredient(17, 0.020));

        for (int i = 0; i <= 21; i++) {
            listofCat.get(6).get(i).getListOfIngredients().addAll(rollAdds);
        }
        //SmallPizza
        listofCat.get(4).get(0).getListOfIngredients().add(new Ingredient(55, 0.159));
        listofCat.get(4).get(0).getListOfIngredients().add(new Ingredient(5, 0.002));
        listofCat.get(4).get(0).getListOfIngredients().add(new Ingredient(4, 0.002));
        listofCat.get(4).get(0).getListOfIngredients().add(new Ingredient(71, 0.002));
        listofCat.get(4).get(0).getListOfIngredients().add(new Ingredient(53, 0.014));
        listofCat.get(4).get(0).getListOfIngredients().add(new Ingredient(98, 0.085));
        listofCat.get(4).get(0).getListOfIngredients().add(new Ingredient(11, 0.005));
        listofCat.get(4).get(0).getListOfIngredients().add(new Ingredient(43, 0.100));
        
        listofCat.get(4).get(1).getListOfIngredients().add(new Ingredient(72, 0.030));
        listofCat.get(4).get(2).getListOfIngredients().add(new Ingredient(72, 0.030));
        listofCat.get(4).get(3).getListOfIngredients().add(new Ingredient(73, 0.030));
        listofCat.get(4).get(4).getListOfIngredients().add(new Ingredient(36, 0.030));
        listofCat.get(4).get(5).getListOfIngredients().add(new Ingredient(69, 0.030));
        listofCat.get(4).get(6).getListOfIngredients().add(new Ingredient(47, 0.030));
        listofCat.get(4).get(7).getListOfIngredients().add(new Ingredient(48, 0.030));
        listofCat.get(4).get(8).getListOfIngredients().add(new Ingredient(54, 0.040));
        listofCat.get(4).get(9).getListOfIngredients().add(new Ingredient(63, 0.040));
        listofCat.get(4).get(10).getListOfIngredients().add(new Ingredient(42, 0.040));
        listofCat.get(4).get(11).getListOfIngredients().add(new Ingredient(66, 0.030));
        listofCat.get(4).get(12).getListOfIngredients().add(new Ingredient(74, 0.010));
        listofCat.get(4).get(13).getListOfIngredients().add(new Ingredient(75, 0.100));
        listofCat.get(4).get(14).getListOfIngredients().add(new Ingredient(76, 0.030));
        listofCat.get(4).get(15).getListOfIngredients().add(new Ingredient(68, 0.200));
        
        //Big pizza
        listofCat.get(5).get(0).getListOfIngredients().add(new Ingredient(56, 0.177));
        listofCat.get(5).get(0).getListOfIngredients().add(new Ingredient(5, 0.003));
        listofCat.get(5).get(0).getListOfIngredients().add(new Ingredient(4, 0.003));
        listofCat.get(5).get(0).getListOfIngredients().add(new Ingredient(71, 0.003));
        listofCat.get(5).get(0).getListOfIngredients().add(new Ingredient(53, 0.016));
        listofCat.get(5).get(0).getListOfIngredients().add(new Ingredient(98, 0.135));
        listofCat.get(5).get(0).getListOfIngredients().add(new Ingredient(11, 0.005));
        listofCat.get(5).get(0).getListOfIngredients().add(new Ingredient(43, 0.150));
        
        listofCat.get(5).get(1).getListOfIngredients().add(new Ingredient(72, 0.050));
        listofCat.get(5).get(2).getListOfIngredients().add(new Ingredient(72, 0.050));
        listofCat.get(5).get(3).getListOfIngredients().add(new Ingredient(73, 0.050));
        listofCat.get(5).get(4).getListOfIngredients().add(new Ingredient(36, 0.050));
        listofCat.get(5).get(5).getListOfIngredients().add(new Ingredient(69, 0.050));
        listofCat.get(5).get(6).getListOfIngredients().add(new Ingredient(47, 0.050));
        listofCat.get(5).get(7).getListOfIngredients().add(new Ingredient(48, 0.050));
        listofCat.get(5).get(8).getListOfIngredients().add(new Ingredient(54, 0.060));
        listofCat.get(5).get(9).getListOfIngredients().add(new Ingredient(63, 0.060));
        listofCat.get(5).get(10).getListOfIngredients().add(new Ingredient(42, 0.060));
        listofCat.get(5).get(11).getListOfIngredients().add(new Ingredient(66, 0.050));
        listofCat.get(5).get(12).getListOfIngredients().add(new Ingredient(74, 0.015));
        listofCat.get(5).get(13).getListOfIngredients().add(new Ingredient(75, 0.150));
        listofCat.get(5).get(14).getListOfIngredients().add(new Ingredient(76, 0.050));
        listofCat.get(5).get(15).getListOfIngredients().add(new Ingredient(68, 0.300));


    }
    public static void writeFile(){
        



        
        
        
        
        
    
    }
        
        
  
        
        
    
    public static void rewriteFile(){
        
    }
    
}
