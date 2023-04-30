import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    Burger burger;
    @Mock
    private Bun bun;
    @Mock
    private Ingredient ingredient;
    @Before
    public void before() {
        burger = new Burger();
    }
    @Test
    public void setBunsTest(){
        burger.setBuns(bun);
        Assert.assertEquals(bun, burger.bun);
    }
    @Test
    public void addIngredientTest(){
        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(ingredient);
        burger.addIngredient(ingredient);
        Assert.assertEquals(ingredients, burger.ingredients);
    }
    @Test
    public void removeIngredientTest(){
        List<Ingredient> ingredients = new ArrayList<>();
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        Assert.assertEquals(ingredients, burger.ingredients);
    }
    @Test
    public void moveIngredientTest(){
        Ingredient ingredient0 = new Ingredient(IngredientType.SAUCE, "Лук", (float) 20.0);
        Ingredient ingredient1 = new Ingredient(IngredientType.FILLING, "Помидор", (float) 50.0);
        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(ingredient1);
        ingredients.add(ingredient0);
        burger.addIngredient(ingredient0);
        burger.addIngredient(ingredient1);
        burger.moveIngredient(0,1);
        Assert.assertEquals(ingredients, burger.ingredients);
    }
}
