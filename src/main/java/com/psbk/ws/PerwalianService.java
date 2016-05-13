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
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import org.codehaus.jettison.json.JSONObject;

/**
 *
 * @author Eka Windo
 */
@Path("/statusPerwalian")
public class PerwalianService extends MasterConnection{
    
    @PUT
//    @Path("/update/id_perwalian={id_perwalian}/nrp={nrp}/id_dosen={id_dosen}/semester={semester}/masa={masa}/status={status}/id_berita_acara={id_berita_acara}")
    @Path("/update")
    @Produces(MediaType.APPLICATION_JSON)
    public Object updatePerwalian(@Context HttpServletRequest hsr){

        StringBuffer sb=new StringBuffer();
	String line=null;
	JSONObject request=null;
	MyMap respon=new MyMap();
	MyMap data=new MyMap();
	DataInputStream in;
	
        try {
            createConnection();
            in=new DataInputStream(new BufferedInputStream(hsr.getInputStream()));
            while((line=in.readLine()) != null)
            sb.append(line);
		JSONObject json=new JSONObject(sb.toString());
                request=(JSONObject)json.getJSONObject("request");
				
            if(request==null){
                respon.put("message", "Data yang dikirim tidak ditemukan");
		respon.put("rCode", "99");
		respon.put("statusId", "0");
		return respon;
            }		
		jt.update("UPDATE perwalian SET status=? WHERE id_perwalian=?",new Object[] {
                    request.getString("status"), request.getInt("id_perwalian")});
                respon.put("message", "Data berhasil diubah");
		respon.put("rCode","00");
		respon.put("statusId", "1");
            } catch (Exception e) {
                e.printStackTrace();
		respon.put("message", e.getMessage());
		respon.put("rCode", "99");
		respon.put("statusId", "0");
            }
        return respon;
    }
}
