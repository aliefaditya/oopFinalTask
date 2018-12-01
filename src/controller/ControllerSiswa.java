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
import java.util.List;
import model.Application;
import view.*;

/**
 *
 * @author aditya rachman
 */
public class ControllerSiswa extends MouseAdapter {
    private Application model;
    private List<Siswa> allSiswa = null;
    private Tampilan_regist_siswa view;
    private Tampilan_awal viewAwal;
    
    
    public ControllerSiswa(Application model){
        this.model = model;
        view = new Tampilan_regist_siswa();
        view.setVisible(true);
        
        view.getBtnCreate().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                System.out.println("clicked");
                btnCreate();
            }
        });
    }
    
    public void btnCreate(){
        String nama = view.getNama();
        int umur = view.getUmur();
        String alamat = view.getAlamat();
        String tgl_lahir = view.getTgllahir();
        String email = view.getEmail();
        String nis = view.getNis();
        String asal = view.getAsal();
        if (alamat.isEmpty() || nama.isEmpty() || tgl_lahir.isEmpty() || email.isEmpty() || nis.isEmpty() || asal.isEmpty() ){
            view.showMessage("Data Kosong, Isi Semua", "Error", 0);
        }else{
            System.out.println();
            if (Database.currentDB.cekDuplikatNIS(nis)){
                view.showMessage("NIS Sudah Ada", "Error", 0);
            }else{
                model.addSiswa(nama, umur, alamat, tgl_lahir, email, nis, asal);
                view.showMessage("Data Berhasil Ditambah", "Success", 1);
                view.dispose();
                new ControllerTampilanAwal(model);
            }
        }
    }  
}
