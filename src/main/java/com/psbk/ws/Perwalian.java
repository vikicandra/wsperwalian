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
public class Perwalian {
    
    private int id_perwalian;
    private String nrp;
    private String id_dosen;
    private int semester;
    private int masa;
    private String status;
    private String id_berita_acara;

    public int getId_perwalian() {
        return id_perwalian;
    }

    public void setId_perwalian(int id_perwalian) {
        this.id_perwalian = id_perwalian;
    }

    public String getNrp() {
        return nrp;
    }

    public void setNrp(String nrp) {
        this.nrp = nrp;
    }

    public String getId_dosen() {
        return id_dosen;
    }

    public void setId_dosen(String id_dosen) {
        this.id_dosen = id_dosen;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public int getMasa() {
        return masa;
    }

    public void setMasa(int masa) {
        this.masa = masa;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getId_berita_acara() {
        return id_berita_acara;
    }

    public void setId_berita_acara(String id_berita_acara) {
        this.id_berita_acara = id_berita_acara;
    }
    
}