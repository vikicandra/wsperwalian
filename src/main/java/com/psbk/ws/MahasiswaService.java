/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psbk.ws;

import com.psbk.ws.common.MasterConnection;
import com.psbk.ws.common.MyMap;
import java.util.HashMap;
import java.util.Map;
import static javafx.scene.input.KeyCode.T;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import static jdk.nashorn.internal.runtime.Debug.id;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author VIKI
 */
@Path("/mahasiswa")
public class MahasiswaService extends MasterConnection{
    
    @GET
    @Path("/getAll")
    @Produces(MediaType.APPLICATION_JSON)
    public Map getAllMhs(){
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("statusID", "1");
        result.put("message", "INQUIRY BERHAISL");
        try{
            createConnection();
            MyMap mhs = (MyMap) jt.queryObject("select * from mahasiswa", new MyMap());
            closeConnection();
            if(mhs != null){
                result.put("result", mhs);
            }
        }catch(Exception e){
            result.put("message", "Gagal karena : "+e.getMessage());
        }
        
        return result;
    }
    
    @GET
	@Path("/getMessage")
	public Response getMessage(@QueryParam("msg") String msg1){
		
		String respon = "Hello World, Welcome "+msg1+" !!!!";
		
		return Response.status(200).entity(respon).build();
	}
}
