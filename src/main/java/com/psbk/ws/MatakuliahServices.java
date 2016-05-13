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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

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
            
            result.put("message", "Gagal karena : "+e.getMessage());
        }
        return result;
    }
    
    
    
}
