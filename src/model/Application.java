/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Database;
import model.*;
/**
 *
 * @author aditya rachman
 */
public class Application {
    private ArrayList<Soal> listLatso = new ArrayList<>();
    private ArrayList<Mata_Pelajaran> listMP = new ArrayList<>();
    private ArrayList<Penilaian> listPenilaian = new ArrayList<>();
    private ArrayList<Person> listPerson = new ArrayList<>();
    private ArrayList<Siswa> listSiswa = new ArrayList<>();
    private ArrayList<Tutor> listTutor = new ArrayList<>();
    private Database db;

    public Application(){
        db = new Database();
    }
    
    public double getScore(List<Soal> allSoal){
        int score = 0;
        for(Soal s : allSoal){
            if(s.isTrueAnswer()){
                score++;   
            }
            System.out.println(s.getSoal()+"\n"+s.getSolusi()+"\n"+s.getJawaban()+"\n"+s.isTrueAnswer()+"\n\n");
        }
        return score/(allSoal.size()*1.0d);
    }
    public void addSiswa(String nama, int umur, 
            String alamat, String tgl_lahir, 
            String email,String nis, String asal_sd){
       
        Siswa s = new Siswa(nama, umur, alamat, tgl_lahir, email, nis, asal_sd);
       
        //db.saveSiswa(s);
        Database.currentDB.saveSiswa(s);
    }
    public void addTutor(String nama, int umur, 
            String alamat, String tgl_lahir, 
            String email,String nik, String no_ijazah, String password){
        Tutor t = new Tutor(nama, umur, alamat, tgl_lahir, email, nik, no_ijazah, password);
        //db.saveTutor(t);
        Database.currentDB.saveTutor(t);
    }
//    public void addPenilaian(double nilai,List<Mata_Pelajaran> MP, 
//                List<Tutor> tutor,
//                List<Siswa> siswa){
//        Penilaian p = new Penilaian(nilai, MP, tutor, siswa);
//        db.savePenilaian(p);
//    }
//    public void addMata_Pelajaran(String kode_matpel, String nama,
//            String jenis_materi,
//            List<Soal> lat,
//            List<Test> test){
//        Mata_Pelajaran MP = new Mata_Pelajaran(kode_matpel, nama, jenis_materi, lat, test);
//        db.saveMata_Pelajaran(MP);
//    }
//    public void addLatihan_Soal(int ID_latihan_soal, int level, String soal){
//        Soal l = new Soal(ID_latihan_soal, level, soal);
//        db.saveLatihan_Soal(l);
//    }
//    public void addTest(String jenis_test, String soal, String solusi){
//        Test t = new Test(jenis_test, soal, solusi);
//        db.saveTest(t);
//    }
//    
//    
//    public void deleteSiswa(String nis){
//        Siswa s = db.loadSiswaByNis(nis);
//        db.deleteASiswa(s);
//    }
//    
//    public void deleteTutor(int nik){
//        Soal l = db.loadLatihanByID(nik);
//        db.deleteALatihan(l);
//    }
//    
//    public void deleteLatihan(int id_latihan){
//        Soal l = db.loadLatihanByID(id_latihan);
//        db.deleteALatihan(l);
//    }
//    
//    public void deleteTest(int id_test){
//        Test t = db.loadTestByID(id_test);
//        db.deleteATest(t);
//    }
//    
//    public void deleteMP(String kode_matpel){
//        Mata_Pelajaran MP = db.loadMPByKode_matpel(kode_matpel);
//        db.deleteAMata_Pelajaran(MP);
//    }
//    
//    
//    
//    public void loadSiswalist(){
//        listSiswa = db.loadAllSiswa();
//    }
//    public void loadTutorlist(){
//        listTutor = db.loadAllTutor();
//    }
//    public void loadLatihanlist(){
//        listLatso = db.loadAllLatihan();
//    }
//    public void loadTestlist(){
//        listTest = db.loadAllTest();
//    }
    
    public String getSiswaList(){
        String sSiswaList="";
        for(int i=0;i<listSiswa.size();i++){
            sSiswaList = sSiswaList+listSiswa.get(i).toString()+"\n\n";
        }
        return sSiswaList;
    }
    
    public String getTutorList(){
        String sTutorList="";
        for(int i=0;i<listTutor.size();i++){
            sTutorList = sTutorList+listTutor.get(i).toString()+"\n\n";
        }
        return sTutorList;
    }
    
    public String getMPList(){
        String sMPList="";
        for(int i=0;i<listMP.size();i++){
            sMPList = sMPList+listMP.get(i).toString()+"\n\n";
        }
        return sMPList;
    }
    
    public String getLatihanList(){
        String sLatihanList="";
        for(int i=0;i<listLatso.size();i++){
            sLatihanList = sLatihanList+listLatso.get(i).toString()+"\n\n";
        }
        return sLatihanList;
    }
    
//    public Database getDB(){
//    
//    }
            
    
//    public String getTestList(){
//        String sTestList="";
//        for(int i=0;i<listTest.size();i++){
//            sTestList = sTestList+listTest.get(i).toString()+"\n\n";
//        }
//        return sTestList;
//    }
//    
//    public int getNumOfTestList(){
//        return listTest.size();
//    }
    
    public String[] getSiswaListNis(){
        String[] listNis = new String[listSiswa.size()];
        for (int i = 0;i<listNis.length;i++){
            listNis[i] = listSiswa.get(i).getNis();
        }
        return listNis;
    }
    
    public String[] getTutorListNik(){
        String[] listNik = new String[listTutor.size()];
        for (int i = 0;i<listNik.length;i++){
            listNik[i] = listTutor.get(i).getNik();
        }
        return listNik;
    }
    
    public String[] getMPListKode_matpel(){
        String[] listKode_matpel = new String[listMP.size()];
        for (int i = 0;i<listKode_matpel.length;i++){
            listKode_matpel[i] = listMP.get(i).getKode_matpel();
        }
        return listKode_matpel;
    }
    
//    public String getASiswa(String nis){
//        Siswa s = db.loadSiswaByNis(nis);
//        return s.toString();
//    }
//    
//    public String getATutor(String nik){
//        Tutor t = db.loadTutorByNik(nik);
//        return t.toString();
//    }
//    
//    public String getAMP(String kode_matpel){
//        Mata_Pelajaran mp = db.loadMPByKode_matpel(kode_matpel);
//        return mp.toString();
//    }
}
