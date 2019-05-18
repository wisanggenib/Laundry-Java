/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import java.util.List;
import model.KaryawanModel;
import view.FrmLogin;
import view.FrmMain;
import view.FrmUser;
/**
 *
 * @author wisanggenib
 */
public class KaryawanController {
    private FrmLogin view;
    private FrmMain view2;
    private FrmUser view3;
    private KaryawanModel model;

    public KaryawanController(FrmLogin view) {
        this.view =  view;
         model = new KaryawanModel();
    }
    public KaryawanController(FrmMain view2) {
        this.view2 =  view2;
         model = new KaryawanModel();
    }
    
    public KaryawanController(FrmUser view3) {
        this.view3 =  view3;
         model = new KaryawanModel();
    }
    
    public void inputStaff(String id_karyawan, String nama_karyawan,String password){
        model.setId_karyawan(id_karyawan);
        model.setNama_karyawan(nama_karyawan);
        model.setPassword(password);
    }
    
        public boolean login(String id_karyawan, String password){
        model.setId_karyawan(id_karyawan);
        model.setPassword(password);
        return model.login();
    }
        
            //5. output
    public static String getIdKaryawan(){
        return KaryawanModel.getIdKaryawan();
    }

    public static String getNamaKaryawan(){
        return KaryawanModel.getNamaKaryawan();
    }

        public void inputUser(String id_karyawan, String nama_karyawan, String password){
        KaryawanModel.setIdKaryawan(id_karyawan);
        KaryawanModel.setNamaKaryawan(nama_karyawan);
    }
}
