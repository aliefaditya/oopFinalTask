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
<<<<<<< HEAD
=======

>>>>>>> 1a5a6b941d99054424e4b8a90db9f653ab068d07
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
public class ControllerTest extends MouseAdapter implements ActionListener {
    private Application model;
    private Tampilan_test_indo view;
    private List<Soal> allSoal = null;
    private Mata_Pelajaran mp = null;
    private Database db;
    private int currentSoal = 0;
    
    private void setCurrentSoal(int i){
        currentSoal = i;
        if(i == 0){
            view.getBtnPrev().setEnabled(false);
        }else{
            view.getBtnPrev().setEnabled(true);
        }
        if(i >= allSoal.size()-1){
            view.getBtnNext().setEnabled(false);
        }else{
            view.getBtnNext().setEnabled(true);
        }
    }

    
    public ControllerTest(Application model , Mata_Pelajaran mp){
        this.model = model;
        view = new Tampilan_test_indo();
        view.setVisible(true);
        view.addActionListener(this);
        view.getJudul().setText(mp.getNama());
        this.mp = mp;
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
     
            //btnSubmit();
        }else if (source.equals(view.getBtnHome())){
            btnHome();
        }else if (source.equals(view.getBtnExit())){
            btnExit();
        }
    }
//    public int getI(){
//        return i;
//    }
    public void btnMulai(){

        allSoal = Database.currentDB.getSoalTes(mp.getKode_matpel(),1 , 10);
        
        setCurrentSoal(0);
        
        view.getBtnSubmit().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                submit();
            }
        });
        
        showSoal(allSoal.get(currentSoal));
        
    }
    
    public void btnStop(){
        
    }
    
    public void showSoal(Soal soal){
        String q = soal.getSoal();
        
        
        view.getSoal().setText(q);
        view.getJawab().setText(soal.getJawaban());
    }
    
    public void saveJawaban(){
        allSoal.get(currentSoal).setJawaban(view.getJawab().getText());
    }
    public void submit(){
        saveJawaban();
        setCurrentSoal(currentSoal+1);
        
        if(currentSoal < allSoal.size()){
            
            showSoal(allSoal.get(currentSoal));
        }else{
            view.getBtnSubmit().setEnabled(false);
            finishTes();
        }
    }
    
    public void finishTes(){
        System.out.println("Hasil = "+model.getScore(allSoal));
    }
    
    public void btnNext(){  
        if(allSoal == null)
            return;
        
        saveJawaban();
        setCurrentSoal(currentSoal+1);
        showSoal(allSoal.get(currentSoal));
    }
    public void btnPrev(){
        if(allSoal == null)
            return;
        
        saveJawaban();
        setCurrentSoal(currentSoal-1);
        showSoal(allSoal.get(currentSoal));
    }
//    public void btnStop(){
//        db.connect();
//        
//        db.disconnect();
//    }
    public void btnSubmit(){
        submit();
    }
    public void btnHome(){
//        view.setVisible(false);
//        viewTest.setVisible(true);
    }
    public void btnExit(){
        System.exit(0);
    }
}
