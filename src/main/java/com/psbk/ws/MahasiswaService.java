/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psbk.ws;

import com.psbk.ws.common.MasterConnection;
import com.psbk.ws.common.MyMap;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static javafx.scene.input.KeyCode.T;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import static jdk.nashorn.internal.runtime.Debug.id;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author VIKI
 */
@Path("/mahasiswa")
public class MahasiswaService extends MasterConnection{
    
    @GET
    @Path("/mhsAll")
    @Produces(MediaType.APPLICATION_JSON)
    public Map getMhsAll(){
        Map<String, Object> result = new HashMap<String, Object>();
        
        
        try{
           
            createConnection();
            String sql = "select * from mahasiswa";
            List<MyMap> mhs = jt.queryList(sql, new MyMap());
            closeConnection();
            if(mhs != null){
                result.put("code", "200");
                result.put("status", "ok");
                result.put("message", "INQUIRY BERHASIL");
                result.put("result", mhs);
            }
        }catch(Exception e){
            result.put("code", "404");
            result.put("status", "not found");
            result.put("message", "Gagal karena : "+e.getMessage());
        }
        
        return result;
    }
    
    @GET
    @Path("/mhsByNrp/{nrp}")
    @Produces(MediaType.APPLICATION_JSON)
    public Map getMhsById(@PathParam("nrp") String nrp){
        Map<String, Object> result = new HashMap<String, Object>();
        
        result.put("message", "INQUIRY BERHASIL");
        
        try{
            
            createConnection();
            String sql = "select * from mahasiswa where nrp = ?";
            MyMap mhs = (MyMap) jt.queryObject(sql, new Object[] {nrp},new MyMap());
            closeConnection();
            if(mhs != null){
                result.put("code", "200");
                result.put("status", "ok");
                result.put("result", mhs);
            }
        }catch(Exception e){
            result.put("code", "404");
            result.put("status", "not found");
            result.put("message", "Gagal karena : "+e.getMessage());
        }
        
        return result;
    }
    
    
       
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/listMhsPerwalian")
    public Object getListMhsPerwalian(@Context HttpServletRequest hsr){
        StringBuffer sb = new StringBuffer();
        String line = null;
        JSONObject request = null;
        Map respon = new HashMap();
        DataInputStream in;          

        try{
            createConnection();
            in = new DataInputStream(new BufferedInputStream(hsr.getInputStream()));

            while((line = in.readLine()) != null)
                sb.append(line);
            JSONObject json = new JSONObject(sb.toString());
            request = (JSONObject) json.get("request");

            if(request == null){
                respon.put("message", "Data yang dikirim tidak ditemukan");
                respon.put("rCode", "404");
                respon.put("statusId", "not found");
                return respon;
            }
            String sql = "select M.nrp, M.nama from mahasiswa as M inner join perwalian as P "
                       + "on M.nrp = P.nrp where id_dosen = ?";
            String id = request.getString("id_dosen");
            System.out.println(id);
            List<Map> mhs = jt.queryList(sql, new Object[] {id},new MyMap());
            closeConnection();

            if(mhs != null){
                respon.put("message", "Berhasi");
                respon.put("rCode", "200");
                respon.put("statusId", "ok");
                respon.put("result", mhs);
            }
//                 
        }catch(Exception e){
               e.printStackTrace();
               respon.put("message", e.getMessage());
               respon.put("rCode", "99");
               respon.put("statusId", "0");
           }
        return respon;
    }
    
    @GET
    @Path("/mkAll")
    @Produces(MediaType.APPLICATION_JSON)
    public Map getMkAll(){
        Map<String, Object> result = new HashMap<String, Object>();
        try{
            createConnection();
            String sql = "select * from matakuliah";
            List<MyMap> matkul = jt.queryList(sql, new MyMap());
            
            if(matkul != null){
                result.put("code", "200");
                result.put("status", "ok");
                result.put("message", "INQUIRY BERHASIL");
                result.put("result", matkul);
                
            }
        }catch(Exception e){
            result.put("code", "404");
            result.put("status", "not found");
            result.put("message", "Gagal karena : "+e.getMessage());
        }
        return result;
    }
    
    @POST
    @Path("/detailMkMhs")
    @Produces(MediaType.APPLICATION_JSON)
    public Object getMkByNrp(@Context HttpServletRequest hsr){
        StringBuffer sb = new StringBuffer();
        String line = null;
        JSONObject request = null;
        Map respon = new HashMap();
        DataInputStream in;          

        try{
            createConnection();
            in = new DataInputStream(new BufferedInputStream(hsr.getInputStream()));

            while((line = in.readLine()) != null)
                sb.append(line);
            JSONObject json = new JSONObject(sb.toString());
            request = (JSONObject) json.get("request");

            if(request == null){
                respon.put("message", "Data yang dikirim tidak ditemukan");
                respon.put("rCode", "404");
                respon.put("statusId", "not found");
                return respon;
            }
            String sql = "SELECT * FROM " +
                        "matakuliah as M LEFT JOIN (detail_perwalian as DP join perwalian as P " +
                        "ON DP.id_perwalian = P.id_perwalian and DP.id_perwalian = " +
                        "(SELECT id_perwalian from perwalian where nrp = ?) )ON M.kode_mk = DP.kode_mk";
            String nrp = request.getString("nrp");
            System.out.println(nrp);
            List<Map> mhs = jt.queryList(sql, new Object[] {nrp},new MyMap());
            closeConnection();

            if(mhs != null){
                respon.put("message", "Berhasi");
                respon.put("rCode", "200");
                respon.put("statusId", "ok");
                respon.put("result", mhs);
            }
//                 
        }catch(Exception e){
               e.printStackTrace();
               respon.put("message", e.getMessage());
               respon.put("rCode", "99");
               respon.put("statusId", "0");
           }
        return respon;
    }
    
    
}
