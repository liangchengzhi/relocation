package common.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dom4j.tree.BaseElement;

import common.entity.basic.IFSException;


public class FileTools {
	private static String encoding = Constant.encoding;
	private static Log log = LogFactory.getLog(FileTools.class);
	
	public static void writeBuf2File(File file,byte[] buf,String encoding) throws IOException{
		if(file == null || !file.exists() || buf == null){
			log.error("文件不存在");
			return;
		}
		if(encoding == null){
			encoding = FileTools.encoding;
		}
		OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(file), encoding);
		writer.write(new String(buf, encoding));
		writer.flush();
		writer.close();
	}
	
	/**
	 * 删除目录下所有文件
	 * @param file
	 */
	public static void deleteAll(File file){
		if(!file.exists()){
			log.error("目录不存在",new IFSException(Constant.BASE_ERROR_CODE,"目录不存在"));
			return;
		}
		File[] files = file.listFiles();
		if(file.isFile()){
			file.delete();
		}else{
			for (File f : files) {
				deleteAll(f);
				f.delete();	
			}
		}
	}
	
	/**
	 * 把文件一行一行读取
	 * @param f
	 * @param encoding
	 * @return
	 * @throws IOException
	 */
	public static byte[] readFileByLines(File f,String encoding) throws IOException{
		if(!f.exists() || !f.isFile()){
			return null;
		}
		if(encoding == null){
			encoding = FileTools.encoding;
		}
		 
		FileInputStream fis = new FileInputStream(f);
		BufferedReader in = new BufferedReader(new InputStreamReader(fis,encoding));
		String content = "";
		String line = in.readLine();
		while(line != null){
			if(!line.trim().startsWith("#")){
				content += (line + "\n");
			}
			line = in.readLine();
		}
		// log.info("��ȡ���ļ� " + f.getName() + " ����Ϊ��\n" + content);
		return content.getBytes(encoding);
	}
	/**
	 * 从控制台读取
	 * @param encoding
	 * @return
	 * @throws IOException
	 */
	public static String readSystemInLine(String encoding) throws IOException{
		if(encoding == null){
			encoding = FileTools.encoding;
		}
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in, encoding));
		String input = br.readLine().trim();
		System.out.println("========read system in======:\n" + input);
		return input;
	}
	
	/**
	 * @desc  把文件读取成一块,$$表示结束
	 * @param encoding
	 * @return
	 * @throws IOException 
	 */
	public static byte[] readSystemContent(String encoding) throws IOException{
		if(encoding == null){
			encoding = FileTools.encoding;
		}
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in, encoding));
		String content = "";
		String line = "";
		while(true){
			line = br.readLine();
			if(line.indexOf("$$") != -1){
				content += line.substring(0,line.indexOf("$$"));
				System.out.println("��ȡ�����Ϊ:[\n" + content + "\n]");
				return content.getBytes(encoding);
			}else{
				content += line + "\n";
			}
		}
	}
	
	/**
	 * @desc 读取文件
	 * @param f
	 * @param containEnter containEnter=true
	 * @param encoding
	 * @return
	 * @throws IOException
	 */
	public static byte[] readFile(File f,boolean containEnter,String encoding) throws IOException{
		if(encoding == null){
			encoding = FileTools.encoding;
		}
		if(!f.exists() || !f.isFile()){
			return null;
		}
		
		StringBuffer sb = new StringBuffer();
		BufferedReader in = new BufferedReader(new InputStreamReader(
				new FileInputStream(f)));
		String line = in.readLine();
		while (line != null) {
			sb.append(line);
			if(containEnter){
				sb.append("\n");
			}
			line = in.readLine();
		}
		return sb.toString().getBytes(encoding);
	}
	
	 public static Set<String> getFileRecordSet(File f) throws IOException, URISyntaxException{
		FileInputStream fis = new FileInputStream(f);
		BufferedReader in = new BufferedReader(new InputStreamReader(fis,Constant.encoding));
		String line = in.readLine();
		Set<String> set = new HashSet<String>();		
		while(line != null){
			if(!line.trim().startsWith("#")){
				set.add(line.trim());
			}
			line = in.readLine();
		}
		in.close();
		return set;
	 }
	 /**
	  * 把list 写进文件中
	  * @param list
	  * @param file
	  * @throws IOException
	  */
	 public static void writeFile(List<String> list,File file) throws IOException{
		 OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(file), encoding);
		 for (String str : list) {
			 writer.write(str + "\n");
		 }
		 writer.flush();
		 writer.close();
	 }
	
	public static void main(String[] args) throws IOException, URISyntaxException {
//		byte[] cdbuf = FileTools.readSystemContent(null);
//		byte[] xmlbuf = ThkCommons.CDBuf2Xmlbuf(cdbuf, null);
//		System.out.println("xmlstr:\n" + new String(xmlbuf));
//		CompositeData cd = ThkCommons.xmlbuf2CD(xmlbuf);
//		System.out.println("cd:" + cd);
		//CompositeData cd = ThkCommons.CDbuf2CD(cdbuf, null);
		
		
	}
	
}
