package common.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import common.domain.Cuser;
import common.domain.Project;

public class JsonObjHelper {
	public static Set<String> basicPropertyTypes = new HashSet<>();
	static {
		basicPropertyTypes.add("java.lang.String");
		basicPropertyTypes.add("java.util.Calendar");
		basicPropertyTypes.add("java.lang.Boolean");
		basicPropertyTypes.add("java.lang.Integer");
		basicPropertyTypes.add("java.lang.Double");
		basicPropertyTypes.add("java.math.BigDecimal");
	}
	public static Map mapBasicProperty(Object obj){
		Map<String, Object> m = new HashMap<>();
		if(obj==null) return m;
		
		Class<? extends Object> class1 = obj.getClass();
		Field[] declaredFields = class1.getDeclaredFields();
		for (Field field : declaredFields) {
			
			String name = field.getName();
			String type = field.getType().getName();
			if(!basicPropertyTypes.contains(type)) continue;
			try {
				Method method = class1.getMethod("get"+(name.charAt(0)+"").toUpperCase()+name.substring(1));
				Object invoke = method.invoke(obj);
				m.put(name, invoke);
			} catch (Exception e) {}
		}
		return m;
	}
	public static Map cuser(Cuser cuser, Cuser obj){
		Map<String, Object> m = new HashMap<>();
		if(obj==null) return m;
		
		m.put("id", obj.getId());
		m.put("usertype", obj.getUsertype());
		m.put("username", obj.getUsername());
		m.put("nickname", obj.getNickname());
		
		return m;
	}
	
	public static Map project(Cuser cuser, Project obj){
		Map<String, Object> m = new HashMap<>();
		if(obj==null) return m;

		m.put("id", obj.getId());
		m.put("name", obj.getName());
		m.put("isDeleted", obj.getIsDeleted());
		
		return m;
	}
	
	public static Map obj(Cuser cuser, Object obj){
		Map<String, Object> m = new HashMap<>();
		if(obj==null) return m;
		
		//TODO
		return m;
	}
}
