package model.Personnage.Mage;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class MageTest {

    @ParameterizedTest
    @CsvSource({
            "50, 50",
            "150, 0",
            "-20, 100"
    })
    public void testTakeDmg(int dmg, int life){
        //Given
        Mage mage = new Mage("Merlin", 100);

        //When
        mage.takeDmg(dmg);

        //Then
        Assertions.assertEquals(life, mage.getLife());

    }
}
