/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import model.PelangganModel;
import view.FrmLogin;
import view.FrmUser;


/**
 *
 * @author wisanggenib
 */
public class PelangganController {

    private FrmLogin view;
    private PelangganModel model;
    private FrmUser view2;

    public PelangganController(FrmLogin view) {
        this.view = view;
        model = new PelangganModel();
    }

    public PelangganController(FrmUser view2) {
        this.view2 = view2;
        model = new PelangganModel();
    }

    public void inputPelanggan(String nama, String telp, String gender, String alamat) {

        model.setNama(nama);
        model.setTelp(telp);
        model.setGender(gender);
        model.setAlamat(alamat);
    }

    public static String getNama() {
        return PelangganModel.getNamaPelanggan();
    }

    public static String getTelp() {
        return PelangganModel.getTelpPelanggan();
    }

    public static String getGender() {
        return PelangganModel.getGenderPelanggan();
    }

    public static String getAlamat() {
        return PelangganModel.getAlamatPelanggan();
    }

    public void inputUser(String nama, String telp, String gender, String alamat) {
        PelangganModel.setNamaPelanggan(nama);
        PelangganModel.setTelpPelanggan(telp);
        PelangganModel.setGenderPelanggan(gender);
        PelangganModel.setNamaPelanggan(alamat);
    }

    public List selectPelanggan(String nama) {
        return model.selectPelanggan(nama);
    }

    public boolean insertPelanggan() {
        return model.insertPelanggan();
    }
}
