import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunTest {
    private final String name;
    private final float price;
    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }
    @Parameterized.Parameters(name = "Цвет: {0}, Цена: {1}")
    public static Object[][] getBunData() {
        return new Object[][]{
                {"black bun", 100},
                {"white bun", 200},
                {"red bun", 300},
                {null, 0},
                {"reallyLongNameOfBun1reallyLongNameOfBun1reallyLongNameOfBun1reallyLongNameOfBun1reallyLongNameOfBun1reallyLongNameOfBun1reallyLongNameOfBun1reallyLongNameOfBun1reallyLongNameOfBun1reallyLongNameOfBun1reallyLongNameOfBun1reallyLongNameOfBun1reallyLongNameOfBun1reallyLongNameOfBun1reallyLongNameOfBun1", 1},
                {"", -1000},
                {"brown bun", 1000000000},
                {"cool bun", 0.0000000000000001f},
                {"pink bun", -9.1119f}
        };
    }

    @Test
    public void checkGetName(){
        Bun bun = new Bun(name, price);
        assertEquals(name, bun.getName());
    }

    @Test
    public void checkGetPrice(){
        Bun bun = new Bun(name, price);
        assertEquals(price, bun.getPrice(), 0.0f);
    }
}
