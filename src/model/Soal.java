/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author aditya rachman
 */
public class Soal {
    //private int ID_latihan_soal = 0;
    private String soal; //soalnya
    private String jawaban; // jawaban user
    private String[] solusi; // kunci jawabannya
    
    public Soal( String soal , String solusi){
        
        this.solusi = solusi.split("-");
        jawaban = "";
        setSoal(soal);
    }

    /**
     * @return the soal
     */
    public String getSoal(){
        return soal;
    }

    /**
     * @param soal the soal to set
     */
    public void setSoal(String s) {
        this.soal = s;
    }
    
    /**
     * @param soal the jawaban to set
     */
    public void setJawaban(String s) {
        this.jawaban = s;
    }
    
    public String getSolusi(){
        return solusi[0];
    }
    
    public String getJawaban(){
        return jawaban;
    }
    
    public boolean isTrueAnswer(){
        for(String sol : solusi){
            if(sol.toLowerCase().equals(jawaban.toLowerCase())){
                return true;
            }
        }
        return false;
    }

}
