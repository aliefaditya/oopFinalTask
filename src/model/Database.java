/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author aditya rachman
 */
public class Database {
    public static Database currentDB;
    private Connection conn = null;
    public Siswa s;
    
    public Database(){
        currentDB = this;
    }

   
    public void connect(){
        try {
            String url = "jdbc:mysql://localhost:3306/e_learning";
            String user = "root";
            String pass = "";
            
            conn = DriverManager.getConnection(url, user, pass);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    /// Khusus untuk Query yang tidak memiliki return
    public void RunQuery(String query){
        System.out.println(query);
        connect();
        try{
            Statement st = conn.createStatement();
            st.executeUpdate(query);
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        disconnect();
    }
    /// Khusus untuk Query yang memiliki return
    public ResultSet GetQueryResult(String query){
        //connect();
        ResultSet rs = null;
        try{
            Statement st = conn.createStatement();
            rs = st.executeQuery(query);
        }catch(SQLException e){
            System.out.println("ERROR : "+e.getMessage());
        }
        //disconnect();
        return rs;
    }
    
    public Mata_Pelajaran getMataPelajaran(String kodeMP){
        connect();
        ResultSet rs = GetQueryResult("select * from mata_pelajaran where kode_matpel='"+kodeMP+"'");
        Mata_Pelajaran MP = null;
        try{
            rs.next();
            MP = new Mata_Pelajaran(rs.getString("kode_matpel"), rs.getString("nama"), rs.getString("jenis_materi"), rs.getInt("score_kelulusan"));
        }catch(SQLException e){
            System.out.println("ERROR : "+e.getMessage());
        }
        disconnect();
        return MP;
        
    }
    
    public List<Siswa> getSiswa(int nis){
        connect();
        ResultSet rs = GetQueryResult("select * from siswa where nis='"+nis+"';");
        List<Siswa> s = new ArrayList<>();
        try{
            int i = 0;
            while(rs.next()){
                s.add(new Siswa(rs.getString("nama"), rs.getInt("umur"), rs.getString("alamat"),
                rs.getString("tgl_lahir"), rs.getString("email"), rs.getString("nis"), rs.getString("asal_sd")));
                i++;
            }
        }catch(SQLException e){
            System.out.println("ERROR : "+ e.getMessage());
        }
        return s ;
    }
    
    public List<Soal> getSoalTes(String kodeMP ,int level ,int countSoal){
        connect();
        ResultSet rs = GetQueryResult("select * from test where kode_matpel='"+kodeMP+"' AND level="+level+" ORDER BY RAND() LIMIT "+countSoal);
        List<Soal> s = new ArrayList<>();
        try{
            int i = 0;
            while(rs.next() && i <countSoal ){
                s.add(new Soal(rs.getString("soal"), rs.getString("solusi")));
                i++;
            }
            
        }catch(SQLException e){
            System.out.println("ERROR : "+e.getMessage());
        }
        disconnect();
        return s;
    }
    
    public double getValue(String query){
        connect();
        double val = 0;
        try {
            
            
            ResultSet rs = GetQueryResult(query);
            rs.next();
            val = rs.getInt(0);
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        disconnect();
        return val;
    }
   
    public void disconnect(){
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    
    
  
//    public void loadSiswa(){ 
//        try {
//        //Mindahin data buku dari MySQL
//        connect();
//        String query = "SELECT * FROM siswa";
//        rs = stmt.executeQuery(query);
//        while(rs.next()){ // selamat rs masih ada isinya
//            listSiswa.add(new Siswa(
//                  rs.getString("nama"),
//                  rs.getInt("umur"),
//                  rs.getString("alamat"),
//                  rs.getString("tgl_lahir"),
//                  rs.getString("enail"),
//                  rs.getString("nis"),
//                  rs.getString("asal_sd")
//            ));
//        }
//        } catch (SQLException ex) {
//            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        disconnect();
//    }
//    
//    
//    public void loadTutor(){
//        try {
//        //Mindahin data buku dari MySQL
//        connect();
//        String query = "SELECT * FROM tutor";
//        rs = stmt.executeQuery(query);
//        while(rs.next()){ // selamat rs masih ada isinya
//            listTutor.add(new Tutor(
//                  rs.getString("nama"),
//                  rs.getInt("umur"),
//                  rs.getString("alamat"),
//                  rs.getString("tgl_lahir"),
//                  rs.getString("enail"),
//                  rs.getString("nik"),
//                  rs.getString("no_ijazah"),
//                  rs.getString("password")
//            ));
//        }
//        } catch (SQLException ex) {
//            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        disconnect();
//    }
//    
//    public void loadMP(Soal listLatso, Test listTest){
//        try {
//        //Mindahin data buku dari MySQL
//        connect();
//        String query = "SELECT * FROM mata_pelajaran";
//        rs = stmt.executeQuery(query);
//        int i = 0;
//        while(rs.next()){ // selamat rs masih ada isinya
//            listMP.add(new Mata_Pelajaran(
//                    rs.getString("kode_matpel"),
//                    rs.getString("nama"),
//                    rs.getString("jenis_materi"),
//                    new Soal(rs.getInt("ID_latihan_soal"), rs.getInt("level"), rs.getString("soal")),
//                    new Test(rs.getString("jenis_test"), rs.getString("soal"), rs.getString("solusi"))
//            ));
//                    
//        }
//        } catch (SQLException ex) {
//            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        disconnect();
//    }
//    public void loadLatihanSoal(){
//        try {
//        //Mindahin data buku dari MySQL
//        connect();
//        String query = "SELECT * FROM latihan_soal";
//        rs = stmt.executeQuery(query);
//        while(rs.next()){ // selamat rs masih ada isinya
//            listLatso.add(new Soal(
//                  rs.getInt("ID_latihan_soal"),
//                  rs.getInt("level"),
//                  rs.getString("soal")
//            ));
//        }
//        } catch (SQLException ex) {
//            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        disconnect();
//    }
//    public void loadTest(){
//        try {
//        //Mindahin data buku dari MySQL
//        connect();
//        String query = "SELECT * FROM test";
//        rs = stmt.executeQuery(query);
//        while(rs.next()){ // selamat rs masih ada isinya
//            listTest.add(new Test(
//                  rs.getString("jenis_test"),
//                  rs.getString("soal"),
//                  rs.getString("solusi")
//            ));
//        }
//        } catch (SQLException ex) {
//            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        disconnect();
//    }
//    
//    
//    
//    public List<Penilaian> loadPenilaian(Siswa s){
//        List<Penilaian> list = new ArrayList<Penilaian>();
//        try {
//        //Mindahin data buku dari MySQL
//        connect();
//        
//        String query = "SELECT penilaian.nilai , penilaian.kode_matpel , penilaian.nik , mata_pelajaran.nama , mata_pelajaran.jenis_materi, Latihan_Soal.ID_latihan_soal, Latihan_Soal.level, Latihan_Soal.soal, Test.jenis_test"+
//                "Test.soal, Test.solusi, Tutor.nama, Tutor.umur, Tutor.alamat, Tutor.tgl_lahir, Tutor.email, Tutor.nik, Tutor.no_ijazah, Tutor.password"+
//                " FROM penilaian inner join mata_pelajaran on penilaian.kode_matpel=mata_pelajaran.kode_matpel inner join tutor on tutor.nik=penilaian.nik WHERE penilaian.nis="+s.getNis();
//        rs = stmt.executeQuery(query);
//        while(rs.next()){ // selamat rs masih ada isinya
//            list.add(new Penilaian(
//                  rs.getDouble("nilai"),
//                  new Mata_Pelajaran(rs.getString("kode_matpel"), rs.getString("nama"), rs.getString("jenis_materi"), new Soal(rs.getInt("ID_latihan_soal"), rs.getInt("level"), rs.getString("soal")), new Test(rs.getString("jenis_test"), rs.getString("soal"),rs.getString("solusi"))),
//                  new Tutor(rs.getString("nama"),rs.getInt("umur"),rs.getString("alamat"),rs.getString("tgl_lahir"), rs.getString("email"), rs.getString("nik"), rs.getString("no_ijazah"), rs.getString("password")),
//                  s)
//            );
//        }
//        } catch (SQLException ex) {
//            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        disconnect();
//        return list;
//    }
//    
//    
    public void saveSiswa(Siswa s){
        /* String nama, int umur,
        String alamat, String tgl_lahir,
        String email,String nis, String asal_sd */
        String query = "insert into siswa values('"+s.getNama()+"','"+s.getUmur()+"','"+s.getAlamat()+"','"+s.getTgl_lahir()+"','"+s.getEmail()+"','"+s.getNis()+"','"+s.getAsal_sd()+"');";
        RunQuery(query);
    }
    public void saveTutor(Tutor t){
        /*  
        String nama, int umur,
        String alamat, String tgl_lahir,
        String email,String nik, String no_ijazah, String password
        */
        String query = "insert into tutor values('"+t.getNama()+"','"+t.getUmur()+"','"+t.getAlamat()+"','"+t.getTgl_lahir()+"','"+t.getEmail()+"','"+t.getNik()+"','"+t.getNo_ijazah()+"','"+t.getPassword()+"');";
        RunQuery(query);
    }
//    public void savePenilaian(Penilaian p){
//            /* 
//                double nilai,List<Mata_Pelajaran> MP, 
//                List<Tutor> tutor,
//                List<Siswa> siswa
//            */
//            try{
//            String query = "insert into penilaian values('"+p.getNilai()+"','"+p.MP()+"','"+p.tutor()+"','"+p.siswa()+"');";
//            Statement stmt = conn.createStatement();
//            stmt.execute(query);
//        }   
//        catch(SQLException ex){
//            System.out.println("saving penilaian error");
//        }
//    }
//    public void saveMata_Pelajaran(Mata_Pelajaran MP){
//        /* 
//            String kode_matpel, String nama,
//            String jenis_materi,
//            List<Latihan_Soal> lat,
//            List<Test> test
//        */
//        try{
//            String query = "insert into mata_pelajaran values('"+MP.getKode_matpel()+"','"+MP.getNama()+"','"+MP.getJenis_materi()+"','"+MP.getTest()+"','"+MP.getLatihan()+"');";
//            Statement stmt = conn.createStatement();
//            stmt.execute(query);
//        }   
//        catch(SQLException ex){
//            System.out.println("saving siswa error");
//        }
//    }
//    public void saveLatihan_Soal(Soal latso){
//        /* 
//            int ID_latihan_soal, int level, String soal
//        */
//        try{
//            String query = "insert into latihan_soal values('"+latso.getID_latihan_soal()+"','"+latso.getLevel()+"','"+latso.getSoal()+"');";
//            Statement stmt = conn.createStatement();
//            stmt.execute(query);
//        }   
//        catch(SQLException ex){
//            System.out.println("saving siswa error");
//        }
//    }
//    public void saveTest(Test test){
//        /* 
//            int id test, String jenis_test, String soal, String solusi
//        */
//        try{
//            String query = "insert into test values('"+test.getId_test()+"','"+test.getJenis_test()+"','"+test.getSoal()+"','"+test.getSolusi()+"');";
//            Statement stmt = conn.createStatement();
//            stmt.execute(query);
//        }   
//        catch(SQLException ex){
//            System.out.println("saving siswa error");
//        }
//    }
//    
//    public void deleteASiswa(Siswa s){
//        try{
//            String query = "delete from siswa where nis = '"+s.getNis()+"'";
//            Statement stmt = conn.createStatement();
//            stmt.executeUpdate(query);
//        }
//        catch(SQLException ex){
//            System.out.println("siswa deletion error");
//            ex.printStackTrace();
//        }
//    }
//    
//    public void deleteATutor(Tutor t){
//        try{
//            String query = "delete from tutor where nik = '"+t.getNik()+"'";
//            Statement stmt = conn.createStatement();
//            stmt.executeUpdate(query);
//        }
//        catch(SQLException ex){
//            System.out.println("tutor deletion error");
//            ex.printStackTrace();
//        }
//    }
//    
//    public void deleteAMata_Pelajaran(Mata_Pelajaran MP){
//        try{
//            String query = "delete from test mata_pelajaran where kode_matpel = '"+MP.getKode_matpel()+"'";
//            Statement stmt = conn.createStatement();
//            stmt.executeUpdate(query);
//        }
//        catch(SQLException ex){
//            System.out.println("mata_pelajaran deletion error");
//            ex.printStackTrace();
//        }
//    }
//    
//    public void deleteALatihan(Soal l){
//        try{
//            String query = "delete from test latihan_soal where id_latihan = '"+l.getID_latihan_soal()+"'";
//            Statement stmt = conn.createStatement();
//            stmt.executeUpdate(query);
//        }
//        catch(SQLException ex){
//            System.out.println("latihan_soal deletion error");
//            ex.printStackTrace();
//        }
//    }
//    
//    public void deleteATest(Test t){
//        try{
//            String query = "delete from test where id_test = '"+t.getId_test()+"'";
//            Statement stmt = conn.createStatement();
//            stmt.executeUpdate(query);
//        }
//        catch(SQLException ex){
//            System.out.println("test deletion error");
//            ex.printStackTrace();
//        }
//    }
//    
//    public Siswa loadSiswaByNis(String nis){
//        connect();
//        /* String nama, int umur, 
//            String alamat, String tgl_lahir, 
//            String email,String nis, String asal_sd */
//        try{
//            Statement stmt = conn.createStatement();
//            String query = "select * from siswa where nis = '"+nis+"'";
//            ResultSet rs = stmt.executeQuery(query);
//            Siswa s = null;
//            while (rs.next()){
//                String nama = rs.getString("nama");
//                int umur = Integer.parseInt(rs.getString("umur"));
//                String alamat = rs.getString("alamat");
//                String tgl_lahir = rs.getString("tgl_lahir");
//                String email = rs.getString("email");
//                String asal_sd = rs.getString("asal_sd");
//                
//                s = new Siswa(nama, umur, alamat, tgl_lahir, email, nis, asal_sd);
//            }
//            disconnect();
//            return s;
//         }
//        catch(Exception e){
//            System.out.println("error loading a siswa");
//            return null;
//        }
//    }
//    
    public Siswa loadSiswaByEmail(String email){
        connect();
        /* String nama, int umur, 
            String alamat, String tgl_lahir, 
            String email,String nis, String asal_sd */
        try{
            Statement stmt = conn.createStatement();
            String query = "select * from siswa where email='"+email+"';";
            ResultSet rs = stmt.executeQuery(query);
            Siswa s = null;
            while (rs.next()){
                String nama = rs.getString("nama");
                int umur = Integer.parseInt(rs.getString("umur"));
                String alamat = rs.getString("alamat");
                String tgl_lahir = rs.getString("tgl_lahir");
                String nis = rs.getString("nis");
                String asal_sd = rs.getString("asal_sd");
                
                s = new Siswa(nama, umur, alamat, tgl_lahir, email, nis, asal_sd);
            }
            disconnect();
            return s;
         }
        catch(Exception e){
            System.out.println("error loading a siswa");
            return null;
        }
    }
    
    public Tutor loadTutorByEmail(String email){
        connect();
        /* String nama, int umur, 
            String alamat, String tgl_lahir, 
            String email,String nik, String no_ijazah, String password */
        try{
            Statement stmt = conn.createStatement();
            String query = "select * from tutor where email= '"+email+"'";
            ResultSet rs = stmt.executeQuery(query);
            Tutor t = null;
            while (rs.next()){
                String nama = rs.getString("nama");
                int umur = Integer.parseInt(rs.getString("umur"));
                String alamat = rs.getString("alamat");
                String tgl_lahir = rs.getString("tgl_lahir");
                String nik = rs.getString("nik");
                String no_ijazah = rs.getString("no_ijazah");
                String password = rs.getString("password");
                
                t = new Tutor(nama, umur, alamat, tgl_lahir, email, nik, no_ijazah, password);
            }
            disconnect();
            return t;
         }
        catch(Exception e){
            System.out.println("error loading a tutor");
            return null;
        }
    }
    
    public Tutor loadTutorByNik(String nik){
        connect();
        /* String nama, int umur, 
            String alamat, String tgl_lahir, 
            String email,String nik, String no_ijazah, String password */
        try{
            Statement stmt = conn.createStatement();
            String query = "select * from tutor where nik = '"+nik+"'";
            ResultSet rs = stmt.executeQuery(query);
            Tutor t = null;
            while (rs.next()){
                String nama = rs.getString("nama");
                int umur = Integer.parseInt(rs.getString("umur"));
                String alamat = rs.getString("alamat");
                String tgl_lahir = rs.getString("tgl_lahir");
                String email = rs.getString("email");
                String no_ijazah = rs.getString("no_ijazah");
                String password = rs.getString("password");
                
                t = new Tutor(nama, umur, alamat, tgl_lahir, email, nik, no_ijazah, password);
            }
            disconnect();
            return t;
         }
        catch(Exception e){
            System.out.println("error loading a tutor");
            return null;
        }
    }
//    
//    public Mata_Pelajaran loadMPByKode_matpel(String kode_matpel){
//        /*  String kode_matpel, String nama,
//            String jenis_materi,
//            List<Latihan_Soal> lat,
//            List<Test> test */
//        try{
//            Statement stmt = conn.createStatement();
//            String query = "select * from mata_pelajaran where kode_matpel = '"+kode_matpel+"'";
//            ResultSet rs = stmt.executeQuery(query);
//            Mata_Pelajaran MP = null;
//            while (rs.next()){
//                String nama = rs.getString("nama");
//                String jenis_materi = rs.getString("jenis_materi");
//                
//                MP = new Mata_Pelajaran(kode_matpel, nama, jenis_materi, getListLatihan(), getListTest());
//            }
//            return MP;
//         }
//        catch(Exception e){
//            System.out.println("error loading a course");
//            return null;
//        }
//    }
//    
//    public Test loadTestByID(int id_test){
//        /*  String jenis_test, String soal, String solusi */
//        try{
//            Statement stmt = conn.createStatement();
//            String query = "select * from test where id_test = '"+id_test+"'";
//            ResultSet rs = stmt.executeQuery(query);
//            Test t = null;
//            while (rs.next()){
//                String jenis_test = rs.getString("jenis_test");
//                String soal = rs.getString("soal");
//                String solusi = rs.getString("solusi");
//                t = new Test(jenis_test, soal, solusi);
//            }
//            return t;
//         }
//        catch(Exception e){
//            System.out.println("error loading a test");
//            return null;
//        }
//    }
//    
//    public Soal loadLatihanByID(int id_latihan){
//        /*  int ID_latihan_soal, int level, String soal */
//        try{
//            Statement stmt = conn.createStatement();
//            String query = "select * from test where id_latihan_soal = '"+id_latihan+"'";
//            ResultSet rs = stmt.executeQuery(query);
//            Soal l = null;
//            while (rs.next()){
//                int level = Integer.parseInt(rs.getString("level"));
//                String soal = rs.getString("soal");
//                l = new Soal(id_latihan, level, soal);
//            }
//            return l;
//         }
//        catch(Exception e){
//            System.out.println("error loading an exercise");
//            return null;
//        }
//    }
//    
//    public ArrayList<Soal> loadAllLatihan(){
//        try{
//            ArrayList<Soal> listLatso = new ArrayList();
//            Statement stmt = conn.createStatement();
//            String query = "select * from latihan_soal";
//            ResultSet rs = stmt.executeQuery(query);
//            Soal l = null;
//            while(rs.next()){
//                int id_latihan = Integer.parseInt(rs.getString("ID_latihan_soal"));
//                int level = Integer.parseInt(rs.getString("level"));
//                String soal = rs.getString("soal");
//                l = new Soal(id_latihan, level, soal);
//         
//                listLatso.add(l);
//            }
//            return listLatso;
//        }
//        catch(Exception e){
//            System.out.println("error loading list of exercise");
//        }   return null;
//    }
//    
//    public ArrayList<Test> loadAllTest(){
//        try{
//            ArrayList<Test> listTest = new ArrayList();
//            Statement stmt = conn.createStatement();
//            String query = "select * from test";
//            ResultSet rs = stmt.executeQuery(query);
//           
//            while(rs.next()){
//                String jenis_test = rs.getString("jenis_test");
//                String soal = rs.getString("soal");
//                String solusi = rs.getString("solusi");
//               
//                listTest.add(new Test(jenis_test, soal, solusi));
//            }
//            return listTest;
//        }
//        catch(Exception e){
//            System.out.println("error loading list of test");
//        }   return null;
//    }
//    
    public ArrayList<Siswa> loadAllSiswa(){
        try{
            ArrayList<Siswa> listSiswa = new ArrayList();
            Statement stmt = conn.createStatement();
            String query = "select * from siswa";
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                String nama = rs.getString("nama");
                int umur = Integer.parseInt(rs.getString("umur"));
                String alamat = rs.getString("alamat");
                String tgl_lahir = rs.getString("tgl_lahir");
                String email = rs.getString("email");
                String nis = rs.getString("nis");
                String asal_sd = rs.getString("asal_sd");
                
                s = new Siswa(nama, umur, alamat, tgl_lahir, email, nis, asal_sd);
         
                listSiswa.add(s);
            }
            return listSiswa;
        }
        catch(Exception e){
            System.out.println("error loading list of test");
            return null;
        }   
    }
    
    public ArrayList<Tutor> loadAllTutor(){
        try{
            ArrayList<Tutor> listTutor = new ArrayList();
            Statement stmt = conn.createStatement();
            String query = "select * from tutor";
            ResultSet rs = stmt.executeQuery(query);
            Tutor t = null;
            while(rs.next()){
                String nama = rs.getString("nama");
                int umur = Integer.parseInt(rs.getString("umur"));
                String alamat = rs.getString("alamat");
                String tgl_lahir = rs.getString("tgl_lahir");
                String email = rs.getString("email");
                String no_ijazah = rs.getString("no_ijazah");
                String nik = rs.getString("nik");
                String password = rs.getString("password");
                
                t = new Tutor(nama, umur, alamat, tgl_lahir, email, nik, no_ijazah, password);
         
                listTutor.add(t);
            }
            return listTutor;
        }
        catch(Exception e){
            System.out.println("error loading list of test");
            return null;
        }   
    }
    
    public boolean cekDuplikatNIK(String nik){
        boolean cek = false;
        List<Tutor> listTutor = new ArrayList<>();
        for (Tutor tutor : listTutor) {
            if (tutor.getNik().equals(nik)){
                cek = true;
                break;
            }
        }
        return cek;
    }
//    
    public boolean cekDuplikatNIS(String nis){
        boolean cek = false;
        List<Siswa> listSiswa = new ArrayList<>();
        for (Siswa s : listSiswa) {
            if (s.getNis().equals(nis)){
                cek = true;
                break;
            }
        }
        return cek;
    }
//    
//    public boolean cekDuplikatIDTest(int id){
//        boolean cek = false;
//        for (Test t : listTest) {
//            if (t.getId_test() == id){
//                cek = true;
//                break;
//            }
//        }
//        return cek;
//    }
//    
    public boolean cekTutor(String email, String password){
        boolean cek = false;
        List<Tutor> listTutor = new ArrayList<>();
        for (Tutor t : listTutor) {
            if ((t.getPassword().equals(password))&&(t.getEmail().equals(email))){
                cek = true;
                break;
            }
        }
        return cek;
    }
    
    public boolean cekSiswa(String email, String password){
        boolean cek = false;
        List<Siswa> listSiswa = new ArrayList<>();
        for (Siswa s : listSiswa) {
            if ((s.getEmail().equals(email))&&(s.getNis().equals(password))){
                cek = true;
                break;
            }
        }
        return cek;
    }
    
     public boolean cekLoginTutor(String email,String password){
        //mengecek data user (username dan password)
        connect();

        boolean b=false;

        try {
            String query="select * from tutor where email='"+email+"'";
            ResultSet rs = GetQueryResult(query);
            while(rs.next()){
            if(rs.getString("password").equals(password)){
                b = true;
            }
            }
        } catch (SQLException ex) {
            System.out.println("login error : "+ex.getMessage());   
        }

        disconnect();
        return b;
     }
     
     public boolean cekLoginSiswa(String email,String nis){
        //mengecek data user (username dan password)
        connect();

        boolean b=false;

        try {
            String query="select * from siswa where email='"+email+"'";
            ResultSet rs = GetQueryResult(query);
            while(rs.next()){
            if(rs.getString("nis").equals(nis)){
                b = true;
            }
            }
        } catch (SQLException ex) {
            System.out.println("login error : "+ex.getMessage());   
        }

        disconnect();
        return b;
     }
    
    
}

