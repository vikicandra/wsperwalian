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
    
    private String id_admin;
    private String kata_sandi;
    
    public String getIdAdmin(){
        return id_admin;
    }
    
    public void setIdAdmin(String id_admin){
        this.id_admin = id_admin;
    }
    
    public String getKataSandi(){
        return kata_sandi;
    }
    
    public void setKataSandi(String kata_sandi){
        this.kata_sandi = kata_sandi;
    }
}
