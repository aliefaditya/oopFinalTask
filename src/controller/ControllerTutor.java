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
import model.Application;
import view.*;

/**
 *
 * @author aditya rachman
 */
public class ControllerTutor extends MouseAdapter implements ActionListener{
    private Application model;
    private Tampilan_regist_tutor view;
    private Tampilan_awal viewAwal;
    private Database db;

    
    public ControllerTutor(Application model){
        this.model = model;
        view = new Tampilan_regist_tutor();
        view.setVisible(true);
        view.addActionListener(this);
        view.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        /* String nama, int umur, 
            String alamat, String tgl_lahir, 
            String email,String nik, String no_ijazah, String password */
        if (source.equals(view.getBtnCreate())){
            btnCreate();
        }
    }
    
    public void btnCreate(){
        db.connect();
        int umur = view.getUmur();
        String nama = view.getNama();
        String alamat = view.getAlamat();
        String tgl_lahir = view.getTgllahir();
        String email = view.getEmail();
        String nik = view.getNik();
        String ijazah = view.getNoijazah();
        String password = view.getPassword();
        if (alamat.isEmpty() || nama.isEmpty() || tgl_lahir.isEmpty() || email.isEmpty() || nik.isEmpty() ||ijazah.isEmpty() || password.isEmpty()){
            view.showMessage("Data Kosong, Isi Semua", "Error", 0);
        }else{
//            if (db.cekDuplikatNIK(nik)){
//                view.showMessage("NIK Sudah Ada", "Error", 0);
//            }else{
//                model.addTutor(nama, umur, alamat, tgl_lahir, email, nik, ijazah, password);
//                view.showMessage("Data Berhasil Ditambah", "Success", 1);
//                view.setVisible(false);
//                viewAwal.setVisible(true);
//            }
        }
        db.disconnect();
    }
}

