package model.Objet.Equipement;

import model.Personnage.Mage.Mage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class UtilitaireTest {

    @ParameterizedTest
    @CsvSource({
            "50, 70, 80",
            "50, 20, 100",
            "50, 170, 50",
            "-10, 70, 30"
    })
    void utiliser(int life, int degat, int lifeRestant) {
        Mage mage = new Mage("Barnabeus", 100);
        Utilitaire potion = new Utilitaire("potion de soin", life);

        mage.takeDmg(degat);
        potion.utiliser(mage);

        Assertions.assertEquals(lifeRestant, mage.getLife());
    }
}