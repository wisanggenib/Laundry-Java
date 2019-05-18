/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import koneksi.KoneksiDB;

/**
 *
 * @author wisanggenib
 */
public class KaryawanModel {

    private KoneksiDB koneksi;
    private ResultSet rsLogin, rsKaryawan;
    private String query;
    private boolean status;
    private List<KaryawanModel> ListKaryawan;

    public KaryawanModel() {
        koneksi = new KoneksiDB();
        koneksi.getConn();
    }
    
    //pembuatan variabel
    private String id_karyawan;
    private String nama_karyawan;
    private String password;

    public String getId_karyawan() {
        return id_karyawan;
    }

    public void setId_karyawan(String id_karyawan) {
        this.id_karyawan = id_karyawan;
    }

    public String getNama_karyawan() {
        return nama_karyawan;
    }

    public void setNama_karyawan(String nama_karyawan) {
        this.nama_karyawan = nama_karyawan;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    //penyimpanan data sementara
    private static String idKaryawan;
    private static String namaKaryawan;

    
    public static String getNamaKaryawan() {
        return namaKaryawan;
    }

    public static void setNamaKaryawan(String namaKaryawan) {
        KaryawanModel.namaKaryawan = namaKaryawan;
    }

    public static String getIdKaryawan() {
        return idKaryawan;
    }

    public static void setIdKaryawan(String idKaryawan) {
        KaryawanModel.idKaryawan = idKaryawan;
    }
    
//query login
        public boolean login(){
        query = "SELECT * "
                + "FROM tb_karyawan "
                + "WHERE id_karyawan = '"+ id_karyawan +"' AND password = '"+password+"'";
        status = koneksi.eksekusiQuery(query, true);

        if(status){
            rsLogin = koneksi.getRs();
            try {
                rsLogin.next();
                idKaryawan = rsLogin.getString(1);
                namaKaryawan = rsLogin.getString(2);
                if(namaKaryawan == null){
                    status = false;
                }else{
                    status = true;
                }
            } catch (SQLException se) {
                status = false;
            }
        }
        return status;
    }
    
}
