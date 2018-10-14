package common.util;


public class Constant {
	/**
	 * 允许上传的图片格式
	 */
	public static final String allowFileTypes = ".JPG.JPEG.GIF.PNG.XLS.XLSX.";
	/**
	 * 允许上传的图片大小
	 */
	public static final long allowFileSize = 50 * 1024 * 1024 ;
	
	/**
	 * 超级管理员类型号
	 */
	public static final int ADMIN_USERTYPE = 10;
	
	/**
	 *  导入模板文件
	 */
	public static final String importModelFile = "model/import-models.xml";
	
	/**
	 *  系统编码
	 */
	public static final String encoding = "utf-8";
	
	/**
	 *  系统错误码
	 */
	public static final String BASE_ERROR_CODE = "999999";
	
	/**
	 *  relocation配置文件
	 */
	public static final String RELOCATION_PROPERTIES_FILE = "relocation.properties";
	
	/*@GeneratedValue(strategy = GenerationType.IDENTITY)*/
}
