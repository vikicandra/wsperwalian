/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psbk.ws;

import com.psbk.ws.common.MasterConnection;
import com.psbk.ws.common.MyMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
<<<<<<< HEAD
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.springframework.jdbc.core.JdbcTemplate;
=======
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
>>>>>>> e4e0b4bb8f562c62fbe77c4399fe2e9425f834a1

/**
 *
 * @author VIKI
 */
@Path("/matakuliah")
public class MatakuliahServices extends MasterConnection{
    
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
                
<<<<<<< HEAD
            }
        }catch(Exception e){
            result.put("code", "404");
            result.put("status", "not found");
=======
            }else{
                result.put("code", "404");
                result.put("status", "not found");
            }
        }catch(Exception e){            
            result.put("message", "Gagal karena : "+e.getMessage());
        }
        return result;
    }
    
    @GET
    @Path("/getMkSmt/{smt}")
    @Produces(MediaType.APPLICATION_JSON)
    public Object getMkSmt(@PathParam("smt") String smt){
        Map<String, Object> result = new HashMap<String, Object>();
        
        try{
            createConnection();
            String sql = "select * from matakuliah where kode_mk like '"+smt+"%'";
            List<MyMap> matkul = jt.queryList(sql, new MyMap());
            
            if(matkul != null){
                result.put("code", "200");
                result.put("status", "ok");
                result.put("message", "INQUIRY BERHASIL");
                result.put("result", matkul);
            }else{
                result.put("code", "404");
                result.put("status", "not found");
            }
            
        }catch(Exception e){
            
>>>>>>> e4e0b4bb8f562c62fbe77c4399fe2e9425f834a1
            result.put("message", "Gagal karena : "+e.getMessage());
        }
        return result;
    }
    
<<<<<<< HEAD
//    @PUT
//    @Path("/ubahStatus")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Map putUbahStatus(){
//        JdbcTemplate tem = new JdbcTemplate();
//        Map<String, Object> result = new HashMap<String, Object>();
//        try{
//            createConnection();
//            String sql = "select * from matakuliah";
//            List<MyMap> matkul = jt.queryList(sql, new MyMap());
//            
//            if(matkul.){
//                result.put("code", "200");
//                result.put("status", "ok");
//                result.put("message", "INQUIRY BERHASIL");
//                result.put("result", matkul);
//                
//            }
//            if(tem.update(sql, args))
//            
//        }catch(Exception e){
//            result.put("code", "404");
//            result.put("status", "not found");
//            result.put("message", "Gagal karena : "+e.getMessage());
//        }
//        return result;
//    }
=======
    
>>>>>>> e4e0b4bb8f562c62fbe77c4399fe2e9425f834a1
    
}
