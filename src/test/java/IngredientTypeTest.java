import org.junit.Test;
import praktikum.IngredientType;
import static org.junit.Assert.assertNotNull;
import static praktikum.IngredientType.SAUCE;

public class IngredientTypeTest {
    @Test
    public void testSauceIsNotNull() {
        assertNotNull(IngredientType.valueOf("SAUCE"));
    }

    @Test
    public void testFillingIsNotNull() {
        assertNotNull(IngredientType.valueOf("FILLING"));
    }
}