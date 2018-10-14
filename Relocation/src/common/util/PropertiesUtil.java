package common.util;

import java.io.IOException;
import java.util.Properties;

import org.springframework.core.io.support.PropertiesLoaderUtils;
/**
 * properties 加载工具
 * 配置文件relocation.properties
 * @author liangcz
 *
 */
public class PropertiesUtil {
	public static Properties properties;
	public static String propertiesFile = Constant.RELOCATION_PROPERTIES_FILE;
	/**
	 *  通过key 找到值
	 * @param key
	 * @return
	 */
	public static String getProperty(String key,String defaultValue){
		try {
			if(properties == null){
				properties = PropertiesLoaderUtils.loadAllProperties(Constant.RELOCATION_PROPERTIES_FILE);
			}
		} catch (IOException e) {
			
		}
		if(properties != null && properties.size() != 0){
			return properties.getProperty(key,defaultValue);
		}else{
			return null;
		}
	}
	/**
	 *  通过key 找到值
	 * @param key
	 * @return
	 */
	public static String getProperty(String key){
		return getProperty(key, null);
	}
}
