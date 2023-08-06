package com.product.user.util;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;

public class Util {
	
	
	
	public static ResponseEntity<?> getCustomeResponse(int reponseCode,String message,Object object){
		
		Map<String,Object> map = new HashMap<String,Object>();
		
		map.put("responseCode", map);
		map.put("message", message);
		map.put("data", object);
		
		return ResponseEntity.ok(map);
		
	}

}
