import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientTest {
    public IngredientType type;
    public String name;
    public float price;
    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }
    @Parameterized.Parameters(name = "Тип: {0}, Название: {1}, Цена: {3}")
    public static Object[][]getIngredientData(){
        return new Object[][]{
                {SAUCE, "hot sauce", 100},
                {SAUCE, "sour cream", 0.0f},
                {SAUCE, "chili sauce", 300},
                {FILLING, "cutlet", 100},
                {FILLING, null, 200},
                {null, "sausage", 300},
                {FILLING, "sausage", 300},
        };
    }
    @Test
    public void checkGetType(){
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals(type, ingredient.getType());
    }
    @Test
    public void checkGetName(){
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals(name, ingredient.getName());
    }
    @Test
    public void checkGetPrice(){
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals(price, ingredient.getPrice(), 0.01);
    }
}
