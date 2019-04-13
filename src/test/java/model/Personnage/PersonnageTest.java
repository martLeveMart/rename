package model.personnage;

import model.personnage.mage.Mage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class PersonnageTest {

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

    @ParameterizedTest
    @CsvSource({
            "40, 90",
            "150, 100",
            "-20, 50"
    })
    public void testSoigner(int heal, int life){
        //Given
        Mage mage = new Mage("Merlin", 100);

        //When
        mage.takeDmg(50);
        mage.soigner(heal);

        //Then
        Assertions.assertEquals(life, mage.getLife());

    }

    @ParameterizedTest
    @CsvSource({
            "150, 15, 85",
            "105, 11, 89",
            "-20, 0, 100"
    })
    public void testCoup(int force, int dmg, int life){
        //Given
        Mage mageAtt = new Mage("Barnabeus", 100);
        Mage mageDef = new Mage("Merlin", 100);

        //When
        mageAtt.setStreng(force);
        mageAtt.coup(mageDef);

        //Then
        Assertions.assertEquals(force, mageAtt.getStreng());
        Assertions.assertEquals(dmg, mageAtt.calcPhyDmg());
        Assertions.assertEquals(life, mageDef.getLife());
    }

    @Test
    public void testSetterGetter(){
        Mage mage = new Mage();

        mage.setName("Merlin");

        //par défault la vie max d'un personnage est de 100
        mage.setLife(120);
        Assertions.assertEquals(100, mage.getLife());

        mage.setLifeMax(150);
        mage.setLife(140);
        mage.setPui(20);

        Assertions.assertEquals("Merlin", mage.getName());
        Assertions.assertEquals(140, mage.getLife());
        Assertions.assertEquals(150, mage.getLifeMax());
        Assertions.assertEquals(20, mage.getPui());
    }
}
