import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
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
    @Test
    public void getPriceTest(){
        Mockito.when(bun.getPrice()).thenReturn((float) 100.11);
        burger.setBuns(bun);
        Mockito.when(ingredient.getPrice()).thenReturn((float) 45.18);
        burger.addIngredient(ingredient);
        Assert.assertEquals((float) 245.4, burger.getPrice(), 0.01);
    }
    @Test
    public void getReceiptTest(){
        Mockito.when(bun.getPrice()).thenReturn((float) 88.4);
        Mockito.when(bun.getName()).thenReturn("СпейсХлеб");
        burger.setBuns(bun);
        Mockito.when(ingredient.getPrice()).thenReturn((float) 12.12);
        Mockito.when(ingredient.getName()).thenReturn("Котлета");
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(ingredient);
        burger.addIngredient(ingredient);
        StringBuilder receipt = new StringBuilder(String.format("(==== %s ====)%n", bun.getName()));
        for (Ingredient i : ingredients) {
            receipt.append(String.format("= %s %s =%n", i.getType().toString().toLowerCase(),
                    i.getName()));
        }
        receipt.append(String.format("(==== %s ====)%n", bun.getName()));
        receipt.append(String.format("%nPrice: %f%n", (float) 188.92));
        Assert.assertEquals(receipt.toString(), burger.getReceipt());
    }
}
