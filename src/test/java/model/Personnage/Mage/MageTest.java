package model.Personnage.Mage;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MageTest {

    @Test
    public void testTakeDmg(){
        //Given
        Mage mage = new Mage("Merlin", 100);
        Mage mage2 = new Mage("Merlin", 100);

        //When
        mage.takeDmg(50);
        mage2.takeDmg(160);

        //Then
        Assertions.assertEquals(50, mage.getLife());
        Assertions.assertEquals(0, mage2.getLife());
    }

    @Test
    public void testTakeDmgNeg(){
        //Given
        Mage mage = new Mage("Merlin", 100);

        //When
        mage.takeDmg(-20);

        //Then
        Assertions.assertEquals(100, mage.getLife());

    }
}
