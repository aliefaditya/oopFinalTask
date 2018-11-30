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
public class Tutor extends Person{
    private String nik;
    private String no_ijazah;
    private String password;
    
    public Tutor(String nama, int umur, 
            String alamat, String tgl_lahir, 
            String email,String nik, String no_ijazah, String password){
        super(nama, umur, alamat, tgl_lahir, email);
        setNik(nik);
        setNo_ijazah(no_ijazah);
        setPassword(password);
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
     * @return the nik
     */
    public String getNik() {
        return nik;
    }

    /**
     * @param nik the nik to set
     */
    public void setNik(String nik) {
        if(nik.length() == 5){
            this.nik = nik;
        }
    }

    /**
     * @return the no_ijazah
     */
    public String getNo_ijazah() {
        return no_ijazah;
    }

    /**
     * @param no_ijazah the no_ijazah to set
     */
    public void setNo_ijazah(String no_ijazah) {
        if(no_ijazah.length() == 4){
            this.no_ijazah = no_ijazah;
        }
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String toString(){
        return "nama : "+getNama()+ "\n" +
                "alamat : "+getAlamat()+ "\n" +
                "tanggal lahir : "+getTgl_lahir()+ "\n" +
                "email : "+getEmail()+ "\n" +
                "umur : "+getUmur()+ "\n" +
                "nik : "+getNik()+ "\n" +
                "no ijazah : "+getNo_ijazah()+ "\n" +
                "password : "+getPassword(); 
    }
    
    
}
