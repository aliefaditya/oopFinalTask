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
public class ControllerHomeTutor extends MouseAdapter implements ActionListener{
    private Application model;
    private Home_tutor viewHomeTutor;
    private Home_siswa viewHomeSiswa;
    private Tampilan_awal viewAwal;
    private Tampilan_penilaian viewPenilaian;
    private Database db;

    public ControllerHomeTutor(Application model) throws SQLException{
        viewHomeTutor = new Home_tutor();
        db = new Database();
        viewHomeTutor.addActionListener(this);
        viewHomeTutor.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (source.equals(viewHomeTutor.getBtnLogout())){
            btnLogout();
        }else if (source.equals(viewHomeTutor.getBtnExit())){
            btnExit();
        }else if (source.equals(viewHomeTutor.getBtnPenilaian())){
            btnPenilaian();
        }
    }
        
    public void btnLogout(){
        viewHomeTutor.setVisible(false);
        viewAwal.setVisible(true);
    }
    public void btnExit(){
        System.exit(0);
    }
    public void btnPenilaian(){
        viewHomeTutor.setVisible(false);
        viewPenilaian.setVisible(true);
    }
}
