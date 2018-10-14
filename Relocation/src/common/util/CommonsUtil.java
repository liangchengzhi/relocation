package common.util;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URISyntaxException;

public class CommonsUtil {
	/**
	 * 获取临时输出的操作文件
	 * @return
	 * @throws URISyntaxException
	 * @throws IOException
	 */
	public static File getTmpFile(String fname) throws URISyntaxException, IOException{
		String path = getProjectPath() + "tmpfile/";
		File f = new File(path);
		if(!f.exists()){
			f.mkdir();
		}
		if(fname == null || fname.trim().equals("")){
			fname = "out.xml";
		}
		
		path = path + fname;
		f = new File(path);
		if(!f.exists()){
			f.createNewFile();
		}
		return new File(path);
	}
	/**
	 * 获取过程的基本路径
	 * @return
	 * @throws URISyntaxException
	 */
	public static String getProjectPath() throws URISyntaxException{
		String path = CommonsUtil.class.getResource("/").toURI().getPath();
		path = path.substring(1, path.length());
		path = path.substring(0, path.length()-4);
		return path;
	}
	/**
	 * 打印异常堆栈信息
	 * @author liangcz
	 * @date 2017-04-11
	 * @param e
	 * @return
	 */
	public static String getStackTrace(Throwable e){
		StringWriter sw = null;
        PrintWriter pw = null;
        try {
            sw = new StringWriter();
            pw =  new PrintWriter(sw);
            //将出错的栈信息输出到printWriter中
            e.printStackTrace(pw);
            pw.flush();
            sw.flush();
        } finally {
            if (sw != null) {
                try {
                    sw.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            if (pw != null) {
                pw.close();
            }
        }
        return sw.toString();
	}
}
