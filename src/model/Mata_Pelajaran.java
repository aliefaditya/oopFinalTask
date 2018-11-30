/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import model.Soal;
import model.Penilaian;

/**
 *
 * @author aditya rachman
 */
public class Mata_Pelajaran implements GettingDataAble{
    private String kode_matpel;
    private String nama;
    private String jenis_materi;
    private double score_kelulusan;
    
    public Mata_Pelajaran(String kode_matpel, String nama,
            String jenis_materi,
            double minScore){
        this.kode_matpel = kode_matpel;
        this.nama=nama;
        this.jenis_materi = jenis_materi;
        this.score_kelulusan = minScore;
    }

    
    public List<Soal> getLatihan(int level){
        return null;
    }
    
    /**
     * @return the kode_matpel
     */
    public String getKode_matpel() {
        return kode_matpel;
    }

    /**
     * @param kode_matpel the kode_matpel to set
     */
    public void setKode_matpel(String kode_matpel) {
        if(kode_matpel != "" ){
            Database.currentDB.RunQuery("UPDATE mata_pelajaran SET kode_matpel='"+kode_matpel+"' WHERE kode_matpel='"+this.kode_matpel+"';");
            this.kode_matpel = kode_matpel;
        }
    }

    /**
     * @return the nama
     */
    public String getNama() {
        return nama;
    }

    /**
     * @param nama the nama to set
     */
    public void setNama(String nama) {
        if(nama != null){
            Database.currentDB.RunQuery("UPDATE mata_pelajaran SET nama='"+nama+"' WHERE kode_matpel='"+this.kode_matpel +"';");
            this.nama = nama;
        }
    }

    /**
     * @return the jenis_materi
     */
    public String getJenis_materi() {
        return jenis_materi;
    }

    /**
     * @param jenis_materi the jenis_materi to set
     */
    public void setJenis_materi(String jenis_materi) {
        if(jenis_materi != null){
            Database.currentDB.RunQuery("UPDATE mata_pelajaran SET jenis_materi='"+jenis_materi+"' WHERE kode_matpel='"+this.kode_matpel+"';");
            this.jenis_materi = jenis_materi;
        }
    }

    
    /**
     * @return the lat
     */
    public double getScore_kelulusan() {
        return score_kelulusan;
    }

    /**
     * @param score_kelulusan the score_kelulusan to set
     */
    public void setScore_kelulusan(double score_kelulusan) {
        if((score_kelulusan <= 70)&&(score_kelulusan >=60))
        {
            this.score_kelulusan = score_kelulusan;
        }
    }

    public String toString(){
        return "kode mata pelajaran : "+getKode_matpel()+ "\n" +
                "nama mata pelajaran : "+getNama()+ "\n" +
                "score : "+getScore_kelulusan()+ "\n" +
                "jenis materi :  "+getJenis_materi()+ "\n";
    }

    @Override
    public double getRateScore() {
        return Database.currentDB.getValue("select avg(nilai) from penilaian where kode_matpel='"+kode_matpel+"'");
    }

    @Override
    public double getMaximumScore() {
        return Database.currentDB.getValue("select max(nilai) from penilaian where kode_matpel='"+kode_matpel+"'");
    }

    @Override
    public double getMinimumScore() {
        return Database.currentDB.getValue("select min(nilai) from penilaian where kode_matpel='"+kode_matpel+"'");
    }

    
}