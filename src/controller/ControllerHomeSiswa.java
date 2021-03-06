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
import static jdk.nashorn.internal.objects.NativeRegExp.source;
import model.Application;
import view.*;

/**
 *
 * @author aditya rachman
 */
public class ControllerHomeSiswa  extends MouseAdapter implements ActionListener{
    private Application model;
    private Tampilan_materi viewMateri;
    private Tampilan_test viewTest;
    private Home_siswa viewHomeSiswa;
    private Tampilan_awal viewAwal;
    private Tampilan_penilaian viewPenilaian;
    private Database db;

    public ControllerHomeSiswa(Application model){
        viewHomeSiswa = new Home_siswa();
        db = new Database();
        viewHomeSiswa.addActionListener(this);
        viewHomeSiswa.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (source.equals(viewHomeSiswa.getBtnLogout())){
            btnLogout();
        }else if (source.equals(viewHomeSiswa.getBtnExit())){
            btnExit();
        }else if (source.equals(viewHomeSiswa.getBtnNilai())){
            btnPenilaian();
        }else if (source.equals(viewHomeSiswa.getBtnMateri())){
            btnMateri();
        }else if (source.equals(viewHomeSiswa.getBtnTest())){
            btnTest();
        }
    }
        
    public void btnLogout(){
        viewHomeSiswa.dispose();
        new ControllerTampilanAwal(model);
    }
    public void btnExit(){
        System.exit(0);
    }
    public void btnMateri(){
        new ControllerMateri(model);
    }
    public void btnTest(){
        new ControllerTestGabungan(model);
    }
    public void btnPenilaian(){
        new ControllerPenilaian(model);
    }
}
