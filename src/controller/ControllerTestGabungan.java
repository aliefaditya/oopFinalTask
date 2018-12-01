/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import model.Soal;
import model.Mata_Pelajaran;
import model.Penilaian;
import model.Siswa;
import model.Tutor;
import model.Person;
import model.Database;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.List;
import model.Application;
import view.*;

/**
 *
 * @author aditya rachman
 */
public class ControllerTestGabungan extends MouseAdapter implements ActionListener{
    private Application model;
    private Tampilan_test viewTest;
    private Home_siswa viewHomeSiswa;
    private Tampilan_test_Matematika viewMtk;
    private Tampilan_test_indo viewIndo;
    private Tampilan_test_inggris viewInggris;
    private Mata_Pelajaran mp;
    
    private Database db;

    public ControllerTestGabungan(Application model) {
        viewTest = new Tampilan_test();
        db = new Database();
        viewTest.addActionListener(this);
        viewTest.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (source.equals(viewTest.getBtnHome())){
            btnHome();
        }else if (source.equals(viewTest.getBtnExit())){
            btnExit();
        }else if (source.equals(viewTest.getBtnIndo())){
            btnIndo();
        }else if (source.equals(viewTest.getBtnInggris())){
            btnInggris();
        }else if (source.equals(viewTest.getBtnMtk())){
            btnMtk();
        }
    }
           
    public void btnHome(){
        viewTest.dispose();
        new ControllerHomeSiswa(model);
    }
    public void btnExit(){
        System.exit(0);
    }
    public void btnIndo(){
        System.out.println("here");
        new ControllerTest(model, Database.currentDB.getMataPelajaran("A100"));
        System.out.println("yes");
    }
    public void btnInggris(){
        System.out.println("here");
        new ControllerTestMtk(model, Database.currentDB.getMataPelajaran("A200"));
        System.out.println("yes");
    }
    public void btnMtk(){
        System.out.println("here");
        new ControllerTestInggris(model,Database.currentDB.getMataPelajaran("A300"));
        System.out.println("yes");
    }
}