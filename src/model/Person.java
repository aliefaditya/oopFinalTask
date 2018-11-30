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
public class Person {
    private String nama;
    private String email;
    private int umur;
    private String tgl_lahir;
    private String alamat;
    
    public Person(String nama, int umur, String alamat, String tgl_lahir, String email){
        setNama(nama);
        setUmur(umur);
        setAlamat(alamat);
        setEmail(email);
        setTgl_lahir(tgl_lahir);
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
            this.nama = nama;
        }
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        if(email != null){
            this.email = email;
        }
    }

    /**
     * @return the umur
     */
    public int getUmur() {
        return umur;
    }

    /**
     * @param umur the umur to set
     */
    public void setUmur(int umur) {
        if((umur >= 6)&&(umur <= 10)){
            this.umur = umur;
        }
    }

    /**
     * @return the tgl_lahir
     */
    public String getTgl_lahir() {
        return tgl_lahir;
    }

    /**
     * @param tgl_lahir the tgl_lahir to set
     */
    public void setTgl_lahir(String tgl_lahir) {
        if(tgl_lahir != null){
            this.tgl_lahir = tgl_lahir;
        }
    }

    /**
     * @return the alamat
     */
    public String getAlamat() {
        return alamat;
    }

    /**
     * @param alamat the alamat to set
     */
    public void setAlamat(String alamat) {
        if(alamat != null){
            this.alamat = alamat;
        }
    }
    
}
