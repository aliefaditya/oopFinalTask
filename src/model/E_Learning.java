/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.ControllerTampilanAwal;
import controller.ControllerTest;
import controller.ControllerTutor;

/**
 *
 * @author aditya rachman
 */
public class E_Learning {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Application app = new Application();
        ControllerTampilanAwal c = new ControllerTampilanAwal(app);
        //ControllerTest c = new ControllerTest(app , Database.currentDB.getMataPelajaran("A100"));
    }
    
}
