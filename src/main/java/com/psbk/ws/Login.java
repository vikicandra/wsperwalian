/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.psbk.ws;

/**
 *
 * @author Eka Windo
 */
public class Login {
    
    private String id_dosen;
    private String kata_sandi;
    
    public String getIdDosen(){
        return id_dosen;
    }
    
    public void setIdDeosen(String id_dosen){
        this.id_dosen = id_dosen;
    }
    
    public String getKataSandi(){
        return kata_sandi;
    }
    
    public void setKataSandi(String kata_sandi){
        this.kata_sandi = kata_sandi;
    }
}
