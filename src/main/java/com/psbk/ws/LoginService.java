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
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import org.codehaus.jettison.json.JSONException;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;

/**
 *
 * @author Eka Windo
 */
@Path("/login")
public class LoginService extends MasterConnection{
    
    @GET
    @Path("/getLogin")
    @Produces(MediaType.APPLICATION_JSON)
    public Map getLogin(){
        Map<String, Object> result = new HashMap<String, Object>();
        
        try{
            createConnection();
            String sql = "select * from admin";
            List<MyMap> login = jt.queryList(sql, new MyMap());
            closeConnection();
            if(login != null){
                result.put("code", "200");
                result.put("status", "ok");
                result.put("message", "INQUIRY BERHASIL");
                result.put("result", login);
            }
        }catch(Exception e){
            result.put("code", "404");
            result.put("status", "not found");
            result.put("message", "Gagal karena : "+e.getMessage());
        }
        
        return result;
    }
    
    @POST
    @Path("/postLogin")
    @Produces(MediaType.APPLICATION_JSON)
    public Map insertMatkul(@Context HttpServletRequest hsr) throws JSONException{
        Map response = new HashMap();
        DataInputStream in;
        String line = null;
        StringBuffer sb = new StringBuffer();
        
        try{
            createConnection();
            
            in = new DataInputStream(new BufferedInputStream(hsr.getInputStream()));
            
            while((line = in.readLine()) != null ){
                sb.append(line);
            }
            JSONObject json = new JSONObject(sb.toString());
            JSONObject request = (JSONObject) json.get("request");
            
            if(request == null){
                response.put("status", "null");
            }else{
                response.put("status", "ada");
            }
        }catch(Exception e){
            response.put("status", e.getMessage());
        }
        
        return response;
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Object coba(@Context HttpServletRequest hsr){
        JSONObject jsonArray = null;
        JSONObject result;
        StringBuffer sb = new StringBuffer();
        DataInputStream in;
        Map respon = new HashMap();
        MyMap data = new MyMap();
        String line;
        
        try{
            createConnection();
            in = new DataInputStream(new BufferedInputStream(hsr.getInputStream()));
            
            while((line = in.readLine()) != null)
                sb.append(line);
            
            JSONObject json = new JSONObject(sb.toString());
            json = (JSONObject) json.get("request");
            
            String sql ;
            sql = "select * from admin where username = ? and password = ?" ;
            MyMap admin = (MyMap) jt.queryObject(sql, new Object[] {json.getString("username"), json.get("password")}, new MyMap());
            
            
            
            if(admin != null){
                String id = admin.getString("username");
                if(id.substring(0, 1).equals("0")){
                    sql = "select * from mahasiswa where nrp = '"+id+"'";
                }else if(id.substring(0,1).equals("d")){
                     sql = "select * from dosen where id_dosen = '"+id+"'";
                }else {
                     sql = "select * from ksbap where id_ksbap = '"+id+"'";
                }
                
                MyMap hasil = (MyMap) jt.queryObject(sql, new MyMap());
                
                respon.put("result", hasil);
            }else{
                respon.put("code", "404");
                respon.put("status", "not found");
                respon.put("message", "Data tidak cocok ");
            }
            
           
            
        }catch(Exception e){
            respon.put("gagal : ", e.getMessage());
        }
        
        return respon;
    }

}
