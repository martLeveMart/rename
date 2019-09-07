package model.personnage;

import model.personnage.mage.Mage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mockito;

public class PersonnageTest {

    private Personnage perso = Mockito.mock(
            Personnage.class,
            Mockito.CALLS_REAL_METHODS);

    @BeforeEach
    private void setup(){
        perso.setLifeMax(100);
        perso.setLife(100);
    }

    @ParameterizedTest
    @CsvSource({
            "50, 50",
            "150, 0",
            "-20, 100"
    })
    public void testTakeDmg(int dmg, int life){

        //When
        perso.takeDmg(dmg);

        //Then
        Assertions.assertEquals(life, perso.getLife());

    }

    @ParameterizedTest
    @CsvSource({
            "40, 90",
            "150, 100",
            "-20, 50"
    })
    public void testSoigner(int heal, int life){

        //When
        perso.takeDmg(50);
        perso.soigner(heal);

        //Then
        Assertions.assertEquals(life, perso.getLife());

    }

    @ParameterizedTest
    @CsvSource({
            "150, 15, 85",
            "105, 11, 89",
            "-20, 0, 100"
    })
    public void testCoup(int force, int dmg, int life){
        //Given
        Personnage persoSecondaire = Mockito.mock(
                Personnage.class,
                Mockito.CALLS_REAL_METHODS);
        persoSecondaire.setLifeMax(100);
        persoSecondaire.setLife(100);

        Mockito.when(perso.calcPhyDmg())
                .thenReturn(dmg);

        //When
        perso.setStreng(force);
        perso.coup(persoSecondaire);

        //Then
        Assertions.assertEquals(force, perso.getStreng());
        Assertions.assertEquals(life, persoSecondaire.getLife());
    }

    @Test
    public void testSetterGetter(){

        //on a initialiser la vie du personnage à 100
        perso.setLife(120);
        Assertions.assertEquals(100, perso.getLife());

        perso.setLifeMax(150);
        perso.setLife(140);
        perso.setPui(20);
        perso.setName("Merlin");

        Assertions.assertEquals("Merlin", perso.getName());
        Assertions.assertEquals(140, perso.getLife());
        Assertions.assertEquals(150, perso.getLifeMax());
        Assertions.assertEquals(20, perso.getPui());
    }
}
