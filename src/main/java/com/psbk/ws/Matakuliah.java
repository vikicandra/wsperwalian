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
public class Matakuliah {
    
    private String kode_mk;
    private String nama_mk;
    private int sks;
    
    public String getKodeMk(){
        return kode_mk;
    }
    
    public void setKodeMk(String kode_mk){
        this.kode_mk = kode_mk;
    }
    
    public String getNamaMk(){
        return nama_mk;
    }
    
    public void setNamaMk(String nama_mk){
        this.nama_mk = nama_mk;
    }
    
    public int getSks(){
        return sks;
    }
    
    public void setSks(int sks){
        this.sks = sks;
    }
}
