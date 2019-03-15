package model.Personnage.Mage;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MageTest {

    @Test
    public void testTakeDmg(){
        //Given
        Mage mage = new Mage("Merlin", 100);

        //When
        mage.takeDmg(20);

        //Then
        Assertions.assertEquals(80, mage.getLife());
        mage.presentation(); //tes
    }
}
