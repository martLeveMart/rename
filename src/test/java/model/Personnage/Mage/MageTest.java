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
        Assertions.assertEquals(dmg, mageAtt.calcPhyDmg());
        Assertions.assertEquals(life, mageDef.getLife());
    }

    @ParameterizedTest
    @CsvSource({
            "150, 75, 25, 1, 90",
            "105, 53, 47, 1, 90",
            "-20, 0, 100, 1, 90",
            "40, 20, 0, 5, 50",
            "10, 5, 50, 11, 0"
    })
    public void testTraitMagique(int pui, int dmg, int life, int nbrAtt, int mana){
        //Given
        Mage mageAtt = new Mage("Barnabeus", 100, 100);
        Mage mageDef = new Mage("Merlin", 100, 100);

        //When
        mageAtt.setPui(pui);
        for (int i = 0; i < nbrAtt; i++){
            mageAtt.traitMagique(mageDef);
        }

        //Then
        Assertions.assertEquals(mana + mageAtt.getIntell()/2, mageAtt.getMana());
        Assertions.assertEquals(dmg, mageAtt.calcMagDmg());
        Assertions.assertEquals(life, mageDef.getLife());
        Assertions.assertEquals(life, mageAtt.getLife());
    }
}
