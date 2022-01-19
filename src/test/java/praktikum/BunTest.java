package praktikum;
import org.junit.Test;
import static org.junit.Assert.*;

public class BunTest {

    @Test
    public void bunGetPriceTest(){
        Bun bun = new Bun("Флюоресцентная булка R2-D3", 988);
        int expectedPrice = 988;
        int actualPrice = (int) bun.getPrice();
        assertEquals(expectedPrice, actualPrice);
    }

    @Test
    public void bunGetNameTest(){
        Bun bun = new Bun("Краторная булка N-200i", 1255);
        String expectedName = "Краторная булка N-200i";
        String actualName = bun.getName();
        assertEquals(expectedName, actualName);
    }
}
