/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import koneksi.KoneksiDB;

/**
 *
 * @author wisanggenib
 */
public class PelangganModel {

    private KoneksiDB koneksi;
    private ResultSet rsLogin, rsPelanggan;
    private String query;
    private boolean status;
    private List<PelangganModel> listPelanggan;

    public PelangganModel() {
        koneksi = new KoneksiDB();
        koneksi.getConn();
    }

    private String nama;
    private String id;
    private String telp;
    private String gender;
    private String alamat;
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    
    
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getTelp() {
        return telp;
    }

    public void setTelp(String telp) {
        this.telp = telp;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    private static String namaPelanggan;
    private static String telpPelanggan;
    private static String genderPelanggan;
    private static String alamatPelanggan;

    public static String getNamaPelanggan() {
        return namaPelanggan;
    }

    public static void setNamaPelanggan(String namaPelanggan) {
        PelangganModel.namaPelanggan = namaPelanggan;
    }

    public static String getTelpPelanggan() {
        return telpPelanggan;
    }

    public static void setTelpPelanggan(String telpPelanggan) {
        PelangganModel.telpPelanggan = telpPelanggan;
    }

    public static String getGenderPelanggan() {
        return genderPelanggan;
    }

    public static void setGenderPelanggan(String genderPelanggan) {
        PelangganModel.genderPelanggan = genderPelanggan;
    }

    public static String getAlamatPelanggan() {
        return alamatPelanggan;
    }

    public static void setAlamatPelanggan(String alamatPelanggan) {
        PelangganModel.alamatPelanggan = alamatPelanggan;
    }

    //menampilkan List Pelanggan
    
    
    public List selectPelanggan(String nama) {
        query = "SELECT *"
                + " FROM tb_pelanggan"
                + " WHERE nama LIKE '%" + nama + "%'";
        status = koneksi.eksekusiQuery(query, true);
        if (status) {
            rsPelanggan = koneksi.getRs();
            listPelanggan = new ArrayList<PelangganModel>();
            try {
                while (rsPelanggan.next()) {
                    PelangganModel model = new PelangganModel();
                    model.setNama(rsPelanggan.getString(2));
                    model.setTelp(rsPelanggan.getString(3));
                    model.setGender(rsPelanggan.getString(4));
                    model.setAlamat(rsPelanggan.getString(5));
                    listPelanggan.add(model);
                }
                rsPelanggan.close();
                return listPelanggan;
            } catch (SQLException se) {
                return null;
            }
        }
        return null;
    }

    //menambahkan pelanggan baru
    public boolean insertPelanggan() {
        query = "INSERT INTO tb_pelanggan (nama,telp,gender,alamat)"
                + " VALUES ('" + nama + "','" + telp + "','" + gender + "','" + alamat + "')";
        
        status = koneksi.eksekusiQuery(query, false);
        return status;
    }
}
