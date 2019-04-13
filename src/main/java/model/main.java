package model;

import model.personnage.mage.Mage;

import java.io.IOException;

public class main {
    public static void main(String args[]) throws IOException {
        Mage mage = new Mage();
        mage.surchargeMagique(10);
    }
}
