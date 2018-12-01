/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aditya rachman
 */
public class Penilaian {
    private double nilai;
    private String kodeMP;
    private String nik;
    private String nis;
    /*============HEAD=============*/
    private List<Siswa> siswa = new ArrayList<>();
    
    public Penilaian(double nilai,String kodeMP , String nik , String nis){
        setNilai(nilai);
        this.kodeMP = kodeMP;
        this.nik = nik;
        this.nis = nis;
    }
    
    /**
     * @param nilai the nilai to set
     */
    public void setNilai(double nilai) {
        if((nilai >= 0)&&(nilai <= 100)){
            this.nilai = nilai;
            Database.currentDB.RunQuery("UPDATE 'penilaian' SET 'nilai'= "+nilai +" where 'nis'="+ getNis() );
        }
    }

    /**
     * @return the nilai
     */
    public double getNilai() {
        return nilai;
    }

    /**
     * @return the kodeMP
     */
    public String getKodeMP() {
        return kodeMP;
    }
    
    //return Objek Mata Pelajaran yang di get dari DB
    public Mata_Pelajaran getMataPelajaran(){
        return null;
    }

    /**
     * @return the nik
     */
    public String getNik() {
        return nik;
    }
    
    /*=============HEAD===========*/
    
//    public void addSiswa(Siswa s){
//        if(siswa.size() < 1000){
//            siswa.add(s);
//        }
//        else{
//            System.out.println("penuh");
//        }
//    }
//    
//    public List<Siswa> getSiswa(){
//        int i = 1;
//        Siswa s = null;
//        for (Siswa stdnt : siswa){
//            System.out.println("Nama : "+stdnt.get);stdnt.getNama()
//        }
//        return 
//    }
    
    /*=============END=============*/
    
    //return Objek Tutor yang di get dari DB
    public Tutor getTutor(){
        return null;
    }

    /**
     * @return the nis
     */
    public String getNis() {
        return nis;
    }
    
    //return Objek Siswa yang di get dari DB
    public Siswa getSiswa(){
        return null;
    }
    
}
