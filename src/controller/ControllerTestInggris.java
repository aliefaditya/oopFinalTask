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
import model.Test;
import model.Tutor;
import model.Person;
import model.Database;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import model.Application;
import view.*;

/**
 *
 * @author aditya rachman
 */
public class ControllerTestInggris extends MouseAdapter implements ActionListener{
    private Application model;
    private Tampilan_test_inggris view;
    private Tampilan_test viewTest;
    private Database db;

    
    public ControllerTestInggris(Application model){
        this.model = model;
        view = new Tampilan_test_inggris();
        view.setVisible(true);
        view.addActionListener(this);
        view.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        
        if (source.equals(view.getBtnMulai())){
            btnMulai();
        }else if (source.equals(view.getBtnNext())){
            btnNext();
        }else if (source.equals(view.getBtnPrev())){
            btnPrev();
        }else if (source.equals(view.getBtnStop())){
            btnStop();
        }else if (source.equals(view.getBtnSubmit())){
            btnSubmit();
        }else if (source.equals(view.getBtnHome())){
            btnHome();
        }else if (source.equals(view.getBtnExit())){
            btnExit();
        }
    }
    public void btnMulai(){
    
    }
    public void btnNext(){
    
    }
    public void btnPrev(){
    
    }
    public void btnStop(){
    
    }
    public void btnSubmit(){
    
    }
    public void btnHome(){
        view.setVisible(false);
        viewTest.setVisible(true);
    }
    public void btnExit(){
        System.exit(0);
    }
}
