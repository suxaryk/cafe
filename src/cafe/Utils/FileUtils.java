
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

    public static void fillIngredients(){     
        for (int i = 0; i <= 24; i++) {
            menu.get(7).getDishes().get(i).getRecipe().addAll(rollAdds);
        }
    }

    
}
