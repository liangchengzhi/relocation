package common.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;



public class JsonUtil {

	public static String toJson(Object obj){
		try {
			return JSON.toJSONString(obj,SerializerFeature.WriteDateUseDateFormat) ;						
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static Object fromJson(String reader, Class<?> type){
		try {											
			return JSON.parseObject(reader, type)	;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
}
