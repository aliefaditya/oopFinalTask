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
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Application;
import view.*;

/**
 *
 * @author aditya rachman
 */
public class ControllerTampilanAwal extends MouseAdapter implements ActionListener{
    private Application model;
    private Tampilan_awal viewAwal;
    private Home_siswa viewSiswa;
    private Home_tutor viewTutor;
    private Tampilan_regist_tutor viewTutorRegist;
    private Tampilan_regist_siswa viewSiswaRegist;
    private Database db;
    
    public ControllerTampilanAwal(Application model){
        viewAwal = new Tampilan_awal();
        db = new Database();
        viewAwal.addActionListener(this);
        viewAwal.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (source.equals(viewAwal.getBtnLogin())){
            btnLogin();
        }else if (source.equals(viewAwal.getBtnRegistTutor())){
            btnRegistTutor();
        }else if (source.equals(viewAwal.getBtnRegistSiswa())){
            btnRegistSiswa();
        }
    }
    
    
    public void btnLogin(){
        
        String email = viewAwal.getEmail();
        char[] password = viewAwal.getPassword();
        String peran = viewAwal.getPeran();
        if((peran == "Siswa")||(peran == "siswa")){
           if (email.isEmpty()){
                viewAwal.showMessage("Input Username/Password Anda Kosong", "Error", 0);
           }
           else{
                if (db.cekSiswa(email, password)){
                    viewAwal.setVisible(false);
                    viewSiswa.setVisible(true);
                }
            } 
        }
        else if((peran == "Tutor")||(peran == "tutor")){
           if ((email.isEmpty())||(password.toString() == " ")){
                viewAwal.showMessage("Input Username/Password Anda Kosong", "Error", 0);
           }
           else{
                if (db.cekTutor(email, password)){
                    viewAwal.setVisible(false);
                    viewTutor.setVisible(true);
                }
            }           
        }
    }
    
    public void btnRegistTutor(){
        Tampilan_regist_tutor t = new Tampilan_regist_tutor();
        t.setVisible(true);
        viewAwal.dispose();
    }
    public void btnRegistSiswa(){
        Tampilan_regist_siswa s = new Tampilan_regist_siswa();
        s.setVisible(true);
        viewAwal.dispose(); 
    }
    /*
    public void mousePressed(MouseEvent e){
        Object source = e.getSource();
        if(source.equals(viewAwal.getPeran())){
        
        }
    }*/

    
    
}
