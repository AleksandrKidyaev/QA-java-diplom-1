package praktikum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientParameterizedTest {

    private final IngredientType expectedType;
    private final String expectedIngredient;
    private final float expectedPrice;

    public IngredientParameterizedTest(IngredientType expectedType, String expectedIngredient, float expectedPrice){
        this.expectedType = expectedType;
        this.expectedIngredient = expectedIngredient;
        this.expectedPrice = expectedPrice;
    }

    @Parameterized.Parameters
    public static Object[][] checkIngredient() {
        return new Object[][] {
                {IngredientType.SAUCE, "Sauce", 199},
                {IngredientType.FILLING, "Filling", 499},
        };
    }

    @Test
    public void ingredientGetPriceTest(){
        Ingredient testIngredient = new Ingredient(expectedType, expectedIngredient, expectedPrice);
        float actualPrice = testIngredient.getPrice();
        assertEquals(expectedPrice, actualPrice, 0.01);
    }

    @Test
    public void ingredientGetNameTest(){
        Ingredient testIngredient = new Ingredient(expectedType, expectedIngredient, expectedPrice);
        String actualIngredient = testIngredient.getName();
        assertEquals(expectedIngredient, actualIngredient);
    }

    @Test
    public void ingredientGetTypeTest(){
        Ingredient ingredient = new Ingredient(expectedType, expectedIngredient, expectedPrice);
        IngredientType actualType = ingredient.getType();
        assertEquals(expectedType, actualType);
    }
}

