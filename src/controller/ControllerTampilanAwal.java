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
    private List<Siswa> siswa;
    private Home_siswa viewSiswa;
    private Home_tutor viewTutor;
    private Tampilan_regist_tutor viewTutorRegist;
    private Tampilan_regist_siswa viewSiswaRegist;
    private Database db;
    
    public ControllerTampilanAwal(Application model){
        this.model = model;
        viewAwal = new Tampilan_awal();
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
    
    
    public void btnLogin() throws SQLException{
        
        String email = viewAwal.getEmail();
        char[] password = viewAwal.getPassword();
        String peran = viewAwal.getPeran().toLowerCase();
        if(peran == "siswa"){
           if (email.isEmpty()){
                viewAwal.showMessage("Input Username/Password Anda Kosong", "Error", 0);
           }
           else{
                if (Database.currentDB.cekSiswa(email, password)){
                    new ControllerHomeSiswa(model);
                }
            } 
        }
        else if (peran == "tutor"){
           if ((email.isEmpty())||(password.toString() == " ")){
                viewAwal.showMessage("Input Username/Password Anda Kosong", "Error", 0);
           }
           else{
                if (Database.currentDB.cekTutor(email, password)){
                    new ControllerHomeTutor(model);
                }
            }           
        }
    }
    
    public void btnRegistTutor(){
        new ControllerTutor(model);
    }
    public void btnRegistSiswa(){
        new ControllerSiswa(model);
    }
    /*
    public void mousePressed(MouseEvent e){
        Object source = e.getSource();
        if(source.equals(viewAwal.getPeran())){
        
        }
    }*/

    
    
}
