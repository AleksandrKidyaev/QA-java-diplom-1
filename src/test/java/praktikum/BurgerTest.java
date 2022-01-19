package praktikum;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    Database database = new Database();

    private Burger burger;

    @Before
    public void setUp() {
        burger = new Burger();
    }

    @Mock
    Bun mockBun;

    @Test
    public void burgerSetBunTest(){
        burger.setBuns(mockBun);
        assertNotNull(burger.bun); //проверяем факт заполнения
    }

    @Test
    public void burgerAddIngredientTest(){
        for(int i = 0; i <= 4; i++) {
            burger.addIngredient(database.availableIngredients().get(i));
        }
        int actualSize = burger.ingredients.size();
        assertEquals(5, actualSize);
    }

    @Test
    public void burgerRemoveIngredientTest(){
        for(int i = 0; i <= 4; i++) {
            burger.addIngredient(database.availableIngredients().get(i));
        }
        int sizeBeforeDelete = burger.ingredients.size();
        burger.removeIngredient(0);
        assertEquals("Ингредиент не был удалён",sizeBeforeDelete - 1, burger.ingredients.size());
    }

    @Test
    public void burgerMoveIngredientTest(){
        for(int i = 0; i <= 4; i++) {
            burger.addIngredient(database.availableIngredients().get(i));
        }
        Ingredient ingredientBeforeMoving = burger.ingredients.get(4);
        burger.moveIngredient(4, 0);
        Ingredient ingredientAfterMoving = burger.ingredients.get(0);
        assertEquals("Перемещение не было произведено", ingredientAfterMoving, ingredientBeforeMoving);
    }

    @Test
    public void burgerGetPriceTest(){
        burger.setBuns(mockBun);
        Mockito.when(mockBun.getPrice()).thenReturn(100f);
        burger.addIngredient(database.availableIngredients().get(3)); //в Database - 100
        float actualPrice = burger.getPrice();
        assertEquals(300, actualPrice, 0.01);
    }

    @Test
    public void burgerGetReceiptTest(){
        burger.setBuns(mockBun);
        for(int i = 0; i <= 2; i++) {
            burger.addIngredient(database.availableIngredients().get(i));
        }
        String firstName = database.availableIngredients().get(0).getName();
        String secondName = database.availableIngredients().get(1).getName();
        String thirdName = database.availableIngredients().get(2).getName();
        Mockito.when(mockBun.getName()).thenReturn("Тестовая булка");
        assertTrue(burger.getReceipt().contains("Тестовая булка")
                &burger.getReceipt().contains(firstName)
                &burger.getReceipt().contains(secondName)
                &burger.getReceipt().contains(thirdName));
    }
}
