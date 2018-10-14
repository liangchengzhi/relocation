package common.util;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import common.entity.basic.ErrorCode;
import common.entity.basic.IFSException;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * poi 读取excel 支持2003 --2007 及以上文件
 * 
 * @author TuJun
 * @version V 2.0
 * @CreatTime 2013-11-19 @
 */
public class ExcelUtils {


	/**
	 * 合并方法，读取excel文件
	 * 根据文件名自动识别读取方式
	 * 支持97-2013格式的excel文档
	 * 
	 * @param fileName
	 *            上传文件名
	 * @param file
	 *            上传的文件
	 * @return 返回列表内容格式：
	 *  每一行数据都是以对应列的表头为key 内容为value 比如 excel表格为：
	 * ===============
	 *  A | B | C | D
	 * ===|===|===|===
	 *  1 | 2 | 3 | 4
	 * ---|---|---|--- 
	 *  a | b | c | d
	 * ---------------
	 * 返回值 map：
	 *   map1:   A:1 B:2 C:3 D:4
	 *   map2:   A:a B:b C:d D:d
	 * @throws java.io.IOException
	 * @author TuJun
	 */
	@SuppressWarnings("rawtypes")
	public static List<Map> readExcel(String path) throws Exception{
		List<Map> valueList=new ArrayList<Map>();
        String ExtensionName=getExtensionName(path);
		if(ExtensionName.equalsIgnoreCase("xls")){
			valueList=readExcel2003(path);
		}else if(ExtensionName.equalsIgnoreCase("xlsx")) {
			valueList=readExcel2007(path);
		}
        return valueList;
	 			
	}
	
	/**
	 * 读取97-2003格式
	 * @param filePath 文件路径
	 * @throws java.io.IOException
	 */
	@SuppressWarnings({ "rawtypes", "resource" })
	public static List<Map> readExcel2003(String filePath) throws IOException{
		//返回结果集
		List<Map> valueList=new ArrayList<Map>();
        FileInputStream fis=null;
		try {
            fis=new FileInputStream(filePath);
			HSSFWorkbook wookbook = new HSSFWorkbook(fis);	// 创建对Excel工作簿文件的引用
			HSSFSheet sheet = wookbook.getSheetAt(0);	// 在Excel文档中，第一张工作表的缺省索引是0
			int rows = sheet.getPhysicalNumberOfRows();	// 获取到Excel文件中的所有行数­
			Map<Integer,String> keys=new HashMap<Integer, String>();
			int cells=0;
			// 遍历行­（第1行  表头） 准备Map里的key
			HSSFRow firstRow = sheet.getRow(0);
			if (firstRow != null) {
				// 获取到Excel文件中的所有的列
				cells = firstRow.getPhysicalNumberOfCells();
				// 遍历列
				for (int j = 0; j < cells; j++) {
					// 获取到列的值­
					try {
						HSSFCell cell = firstRow.getCell(j);
						String cellValue = getCellValue(cell);
						keys.put(j,cellValue);						
					} catch (Exception e) {
						e.printStackTrace();	
					}
				}
			}
			// 遍历行­（从第二行开始）
			for (int i = 1; i < rows; i++) {
				// 读取左上端单元格(从第二行开始)
				HSSFRow row = sheet.getRow(i);
				// 行不为空
				if (row != null) {
					//准备当前行 所储存值的map
					Map<String, Object> val=new HashMap<String, Object>();
					
					boolean isValidRow = false;
					
					// 遍历列
					for (int j = 0; j < cells; j++) {
						// 获取到列的值­
						try {
							HSSFCell cell = row.getCell(j);
							String cellValue = getCellValue(cell);
							val.put(keys.get(j),cellValue);	
							if(!isValidRow && cellValue!=null && cellValue.trim().length()>0){
								isValidRow = true;
							}
						} catch (Exception e) {
							e.printStackTrace();		
						}
					}
					//第I行所有的列数据读取完毕，放入valuelist
					if(isValidRow){
						valueList.add(val);
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
            fis.close();
        }
        return valueList;
	}
	/**
	 * 读取2007-2013格式
	 * @param filePath 文件路径
	 * @return
	 * @throws java.io.IOException
	 */
	@SuppressWarnings({ "rawtypes", "resource" })
	public static List<Map> readExcel2007(String filePath) throws IOException{
		List<Map> valueList=new ArrayList<Map>();
        FileInputStream fis =null;
        try {
            fis =new FileInputStream(filePath);
            XSSFWorkbook xwb = new XSSFWorkbook(fis);	// 构造 XSSFWorkbook 对象，strPath 传入文件路径
            XSSFSheet sheet = xwb.getSheetAt(0);			// 读取第一章表格内容
            // 定义 row、cell
            XSSFRow row;
            // 循环输出表格中的第一行内容   表头
            Map<Integer, String> keys=new HashMap<Integer, String>();
            row = sheet.getRow(0);
            if(row !=null){
                //System.out.println("j = row.getFirstCellNum()::"+row.getFirstCellNum());
                //System.out.println("row.getPhysicalNumberOfCells()::"+row.getPhysicalNumberOfCells());
                for (int j = row.getFirstCellNum(); j <=row.getPhysicalNumberOfCells(); j++) {
                    // 通过 row.getCell(j).toString() 获取单元格内容，
                    if(row.getCell(j)!=null){
                        if(!row.getCell(j).toString().isEmpty()){
                            keys.put(j, row.getCell(j).toString());
                        }
                    }else{
                        keys.put(j, "K-R1C"+j+"E");
                    }
                }
            }
            // 循环输出表格中的从第二行开始内容
            for (int i = sheet.getFirstRowNum() + 1; i <= sheet.getPhysicalNumberOfRows(); i++) {
                row = sheet.getRow(i);
                if (row != null) {
                    boolean isValidRow = false;
                    Map<String, Object> val = new HashMap<String, Object>();
                    for (int j = row.getFirstCellNum(); j <= row.getPhysicalNumberOfCells(); j++) {
                        XSSFCell cell = row.getCell(j);
                        if (cell != null) {
                            String cellValue = null;
                            if(cell.getCellType()==XSSFCell.CELL_TYPE_NUMERIC){
                                if(DateUtil.isCellDateFormatted(cell)){
                                    cellValue = new DataFormatter().formatRawCellContents(cell.getNumericCellValue(), 0, "yyyy-MM-dd HH:mm:ss");
                                }
                                else{
                                    cellValue = String.valueOf(cell.getNumericCellValue());
                                }
                            }
                            else{
                                cellValue = cell.toString();
                            }
                            if(cellValue!=null&&cellValue.trim().length()<=0){
                                cellValue=null;
                            }
                            val.put(keys.get(j), cellValue);
                            if(!isValidRow && cellValue!= null && cellValue.trim().length()>0){
                                isValidRow = true;
                            }
                        }
                    }

                    // 第I行所有的列数据读取完毕，放入valuelist
                    if (isValidRow) {
                        valueList.add(val);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            fis.close();
        }

        return valueList;
	}
	
	/**
	 * 文件操作 获取文件扩展名
	 * 
	 * @param filename
	 *            文件名称包含扩展名
	 * @return
	 */
	public static String getExtensionName(String filename) {
		if ((filename != null) && (filename.length() > 0)) {
			int dot = filename.lastIndexOf('.');
			if ((dot > -1) && (dot < (filename.length() - 1))) {
				return filename.substring(dot + 1);
			}
		}
		return filename;
	}
	
	public static String getCellValue(HSSFCell cell) {
		String cellValue=null;
		if (cell == null)
			return null;
		switch (cell.getCellType()) {
			case HSSFCell.CELL_TYPE_NUMERIC:
				if(HSSFDateUtil.isCellDateFormatted(cell)){
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					cellValue=sdf.format(HSSFDateUtil.getJavaDate(cell.getNumericCellValue()));
					break;
				}
				cellValue=String.valueOf(cell.getNumericCellValue());
				cellValue = subZeroAndDot(cellValue);
				break;
			case HSSFCell.CELL_TYPE_STRING:			
				cellValue=String.valueOf(cell.getStringCellValue()).trim();
				break;
			case HSSFCell.CELL_TYPE_FORMULA:
				cellValue=String.valueOf(cell.getCellFormula());
				break;
			case HSSFCell.CELL_TYPE_BLANK:
				cellValue=null;
				break;
			case HSSFCell.CELL_TYPE_BOOLEAN:
				cellValue=String.valueOf(cell.getBooleanCellValue());
				break;
			case HSSFCell.CELL_TYPE_ERROR:
				cellValue=String.valueOf(cell.getErrorCellValue());
				break;
		}
		if(cellValue!=null&&cellValue.trim().length()<=0){
			cellValue=null;
		}
		return cellValue;
	}
	
	/**  
     * 使用java正则表达式去掉多余的.与0  
     * @param s  
     * @return   
     */
    public static String subZeroAndDot(String s){    
        if(s.indexOf(".") > 0){    
            s = s.replaceAll("0+?$", "");//去掉多余的0    
            s = s.replaceAll("[.]$", "");//如最后一位是.则去掉    
        }    
        return s;    
    }
	
	/**
	 * 校验日期格式
	 * @author TuJun
	 * @param dateTime
	 */
	public static boolean checkDate(String dateTime){
		boolean isDate = false;// 用来标志是否是符合要求的日期
		String date[] = dateTime.split("-");// 按"-"拆分日期字符串
		if (date.length == 3) {// 判断是否拆分为3个字符串,如果不是,肯定不是你要的结果
			if (date[0].length() == 4 && date[1].length() == 2 && date[2].length() == 2) {// 年月日的长度是否符合
				try {
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			    	sdf.parse(dateTime);
					isDate = true;
				} catch (Exception e) {
					isDate = false;
				}
			}
		}
		return isDate;
	 }
	
	/**
	 * 校验金额数字类型，大于0
	 * @param numstr 字符串
	 * @param length 长度
	 * @param decimallength 小数位长度
	 * @return
	 */
	public static boolean checkAmount(String numstr, int length, int decimallength) {
		try {
			if(StringUtils.isBlank(numstr)){
				return false;
			}
			Double amount = Double.parseDouble(numstr);
			if (amount <= 0) {
				return false;
			}
			if (numstr.length() > length) {
				return false;
			}
			int index = numstr.lastIndexOf(".");//寻找小数点的索引位置，若不是小数，则为-1
			if(index > -1) {
				int len = numstr.substring(index + 1).length();//取得小数点后的数值，不包括小数点
				if(len> decimallength){
					return false;
				}
			}
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
	
	/**
	 * 校验上传文件表头是否与Excel2003表头一致
	 * @param HSSFRow row 需要对比的表头行
	 * @param String path 模板路径
	 * @author TuJun
	 */
	public static boolean checkExcel2003TabHead(HSSFRow row, String path) throws IFSException {
		try {
			if(null == row){
				return false;
			}
			// 创建对Excel工作簿文件的引用
			HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(path));
			//获取第一个Sheet表
			HSSFSheet sheet = workbook.getSheetAt(0);
			HSSFRow row_template = sheet.getRow(0);
			workbook.close();
			if(row_template.getPhysicalNumberOfCells() != row.getPhysicalNumberOfCells()){
				return false;
			}
			for (int i = 0; i < row_template.getPhysicalNumberOfCells(); i++) {
				String celli = getCellValue(row_template.getCell(i));
				String cellj = getCellValue(row.getCell(i));
				if(!celli.equals(cellj)){
					return false;
				}
			}
			return true;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new IFSException("模板文件没有找到！",ErrorCode.BaseErrorCode);
		} catch (IOException e) {
			e.printStackTrace();
			throw new IFSException("模板文件创建EXCEL对象IO异常！",ErrorCode.BaseErrorCode);
		}
		
	}
	
	/**
	 * 字符串转带单引号字符串
	 * @param str
	 * @return
	 * @author TuJun
	 */
	public static String stringTransQuotes(String str) {
		String result = "";
		if(str == null || str == ""){
			return result;
		}
		String[] arr = str.split(",");
        for(int i = 0; i < arr.length; i++){ 
        	if(i == arr.length - 1){ 
                result += "'" + arr[i] + "'"; 
            }else{ 
                result += "'" + arr[i] + "',"; 
            } 
        }
		return result;
	}
	
}

