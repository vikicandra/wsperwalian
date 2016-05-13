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
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;

/**
 *
 * @author VIKI
 */

@Path("/dosen")
public class DosenService extends MasterConnection{
    
    @GET
    @Path("/getDosen/{id_dosen}")
    @Produces(MediaType.APPLICATION_JSON)
    public Map getDataDosen(@PathParam("id_dosen") String id_dosen){
        Map<String, Object> result = new HashMap<String, Object>();
        
        result.put("message", "INQUIRY BERHASIL");
        
        try{
            
            createConnection();
            String sql = "select * from dosen where id_dosen = ?";
            MyMap mhs = (MyMap) jt.queryObject(sql, new Object[] {id_dosen},new MyMap());
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
    
    @GET
    @Path("/getMhsWali/{id_dosen}")
    @Produces(MediaType.APPLICATION_JSON)
    public Map getMhsWali(@PathParam("id_dosen") String id_dosen){
        Map<String, Object> result = new HashMap<String, Object>();
        
        result.put("message", "INQUIRY BERHASIL");
        
        try{
            
            createConnection();
            String sql = "select M.nrp, M.nama, P.status from mahasiswa as M inner join perwalian as P "
                       + "on M.nrp = P.nrp where id_dosen = ?";
            List<MyMap> mhs = jt.queryList(sql, new Object[] {id_dosen},new MyMap());
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
    @Path("/apa")
    @Produces(MediaType.APPLICATION_JSON)
    public Map getDataDosen(@Context HttpServletRequest hsr){
        Map respon = new HashMap();
        DataInputStream in;
        String line = null;
        StringBuffer sb = new StringBuffer();
        JSONObject request = null;
        
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
            String sql = "SELECT * FROM dosen where id_dosen = ?";
                        
            String nrp = request.getString("id_dosen");
            MyMap mhs = (MyMap) jt.queryObject(sql, new Object[] {nrp},new MyMap());
            closeConnection();

            if(mhs != null){
                respon.put("message", "Berhasi");
                respon.put("rCode", "200");
                respon.put("statusId", "ok");
                respon.put("result", mhs);
            }
//                 
        }catch(Exception e){
               respon.put("message", e.getMessage());
               respon.put("rCode", "99");
               respon.put("statusId", "0");
           }
        return respon;
    }
    
    @POST
    @Path("/setujuiKontrak")
    @Produces(MediaType.APPLICATION_JSON)
    public Object setujuiKontrak(@Context HttpServletRequest hsr){
        Map respon = new HashMap();
        DataInputStream in;
        String line = null;
        StringBuffer sb = new StringBuffer();
        JSONObject request = null;
        
        try{
            createConnection();
            in = new DataInputStream(new BufferedInputStream(hsr.getInputStream()));
            
            while((line = in.readLine()) != null)
                sb.append(line);
            JSONObject json = new JSONObject(sb.toString());
            request = (JSONObject) json.get("request");
            
//            String sql = " "
//            MyMap mhs = (MyMap) jt.queryObject(sql, new Object[] {nrp},new MyMap());
//            jt.up
            closeConnection();
            
            
            
            
        }catch(Exception e){
            respon.put("message", e.getMessage());
            respon.put("rCode", "99");
            respon.put("statusId", "0");
        }
        
        return respon;
        
    }
    
    @DELETE
    @Path("/dropMkMhs")
    @Produces(MediaType.APPLICATION_JSON)
    public Object dropMkMhs(@Context HttpServletRequest hsr){
        StringBuffer sb = new StringBuffer();
        DataInputStream in;
        String line = null;
        JSONArray jsonArray;
        MyMap respon = new MyMap();
        
        try{
            createConnection();
            in = new DataInputStream(new BufferedInputStream(hsr.getInputStream()));
            
            while((line = in.readLine()) != null)
                sb.append(sb);
            
            JSONObject json = new JSONObject(sb.toString());
            jsonArray = (JSONArray) json.get("request");
             System.out.println("AAAAAAAAA");
             for (int i = 0; i < jsonArray.length() ; i++) {
                JSONObject jsonObject = (JSONObject) jsonArray.get(i);
                json = (JSONObject) jsonObject.get("map");
                
                String sql = "delete from detail_perwalian where id_perwalian = ? and kode_mk = ?";
                MyMap mkDrop = jt.query(sql, new Object[] {json.getInt("id_perwalian"), json.getString("kode_mk")});
               
            }
              System.out.println("BBBBBB");
             respon.put("hasil", "yes");
            
            
        }
        catch(Exception e){
            respon.put("hasil", "ah");
            
        }
        return respon;
    }
    
}
