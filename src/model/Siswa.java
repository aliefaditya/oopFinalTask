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
public class Siswa extends Person {
    private String nis;
    private String asal_sd;
    
    public Siswa(String nama, int umur, 
            String alamat, String tgl_lahir, 
            String email,String nis, String asal_sd){
        super(nama, umur, alamat, tgl_lahir, email);
        setNis(nis);
        setAsal_sd(asal_sd);
    }
    
    public String getNama(){
        return super.getNama();
    }
    
    public String getAlamat(){
        return super.getAlamat();
    }
    
    public String getTgl_lahir(){
        return super.getTgl_lahir();
    }
    
    public String getEmail(){
        return super.getEmail();
    }
    
    public int getUmur(){
        return super.getUmur();
    }

    /**
     * @return the nis
     */
    public String getNis() {
        return nis;
    }

    /**
     * @param nis the nis to set
     */
    public void setNis(String nis) {
        if(nis.length() == 7){
            this.nis = nis;
        }
    }

    /**
     * @return the asal_sd
     */
    public String getAsal_sd() {
        return asal_sd;
    }

    /**
     * @param asal_sd the asal_sd to set
     */
    public void setAsal_sd(String asal_sd) {
        if(asal_sd != null){
            this.asal_sd = asal_sd;
        }
    }
    
    public String toString(){
        return "nama : "+getNama()+ "\n" +
                "alamat : "+getAlamat()+ "\n" +
                "tanggal lahir : "+getTgl_lahir()+ "\n" +
                "email : "+getEmail()+ "\n" +
                "umur : "+getUmur()+ "\n" +
                "nis : "+getNis()+ "\n" +
                "asal sd : "+getAsal_sd(); 
    }
}
