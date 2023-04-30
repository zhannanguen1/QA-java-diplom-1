import org.junit.Test;
import praktikum.IngredientType;
import static org.junit.Assert.assertNotNull;

public class IngredientTypeTest {
    @Test
    public void testSauceIsNotNull() {
        assertNotNull(IngredientType.valueOf("SAUСE"));
    }

    @Test
    public void testFillingIsNotNull() {
        assertNotNull(IngredientType.valueOf("FILLING"));
    }
}