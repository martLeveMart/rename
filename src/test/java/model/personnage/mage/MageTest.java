package model.personnage.mage;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class MageTest {

    @ParameterizedTest
    @CsvSource({
            "50, 125, 150",
            "21, 110, 120",
            "-21, 110, 110",
            "20, -10, 10"
    })
    public void testSetIntell(int intell, int mana, int manaMax){
        //Given
        Mage mage = new Mage("Merlin", 100, mana);

        //When
        mage.setIntell(intell);

        //Then
        Assertions.assertEquals(manaMax, mage.getManaMax());

    }

    @ParameterizedTest
    @CsvSource({
            "150, 75, 25, 1, 90",
            "105, 53, 47, 1, 90",
            "-20, 0, 100, 1, 90",
            "40, 20, 0, 5, 50",
            "10, 5, 50, 11, 0"
    })
    public void testTraitMagiqueWithoutSurcharge(int pui, int dmg, int life, int nbrAtt, int mana){
        //Given
        Mage mageAtt = new Mage("Barnabeus", 100, 100);
        Mage mageDef = new Mage("Merlin", 100, 100);

        //When
        mageAtt.setActiveSurcharge(false);
        mageAtt.setPui(pui);
        for (int i = 0; i < nbrAtt; i++){
            mageAtt.traitMagique(mageDef);
        }

        //Then
        Assertions.assertEquals(mana + mageAtt.getIntell()/2, mageAtt.getMana());
        Assertions.assertEquals(dmg, mageAtt.calcMagDmg());
        Assertions.assertEquals(life, mageDef.getLife());
    }

    @ParameterizedTest
    @CsvSource({
            "100, 0, 107",
            "100, 2, 87",
            "94, 11, 0",
            "14, 15, 0"
    })
    public void testTraitMagiqueWithSurcharge(int lifeAtt, int nbrAtt, int mana){
        //Given
        Mage mageAtt = new Mage("Barnabeus", 100, 100);
        Mage mageDef = new Mage("Merlin", 100, 100);

        //When
        mageAtt.setPui(25);
        for (int i = 0; i < nbrAtt; i++){
            mageAtt.traitMagique(mageDef);
        }

        //Then
        Assertions.assertEquals(mana, mageAtt.getMana());
        Assertions.assertEquals(lifeAtt, mageAtt.getLife());
    }

    @Test
    public void testSetMana(){
        Mage mage = new Mage();

        mage.setManaMax(10);
        mage.setMana(20);

        Assertions.assertEquals(10, mage.getMana());
    }

    //Test pour le 100% de getter
    @Test
    public void testMageTestFin(){
        Mage mage = new Mage();

        Boolean isActiv = mage.isActiveSurcharge();
    }
}
