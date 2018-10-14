package common.web.util;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import common.dao.QxdmkDAO;
import common.dao.SysconfigDAO;
import common.domain.Cuser;
import common.domain.Qxdmk;
import common.domain.Sysconfig;
import common.service.util.CommonService;
import common.service.util.MyCuserService;
import common.util.Constant;
import common.util.JsonObj;

@Controller("CommonController")
@Transactional
public class CommonController {
	@Autowired
	MyCuserService cuserService;
	@Autowired
	CurrentUser currentUser;
	@Autowired
	CommonService commonService;
	@Autowired
	SysconfigDAO sysconfigDAO;
	@Autowired
	QxdmkDAO qxdmkDAO;
	public static void main(String[] args) throws IOException {
		URL url = new URL("http://www.yeren86.com/AppBanner?type=message");
    	Object content = url.openConnection().getContent();
    	System.out.println(content.toString());
		JSONObject jsonObject = new JSONObject(content);
		System.out.println(jsonObject.get("data"));
	}
	
	/**
	 * 文件上传
	 * @param image
	 * @param request
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value ="/upload",method=RequestMethod.POST,  produces="text/html;charset=UTF-8")  
	@ResponseBody
    public String fileUploadOne(@RequestParam("files[]") MultipartFile[] images,MultipartHttpServletRequest request) throws IOException {  
		String result = "";
		for (MultipartFile image : images) {
			if(!result.equals("")) result += ";";
			
			String fileName= "上传失败";
			if(!image.isEmpty()) {
	        	String img=image.getOriginalFilename();
	        	fileName = img;
	    	    img=img.substring(img.lastIndexOf('.')).toLowerCase();
	    	    if(Constant.allowFileTypes.indexOf(img.toUpperCase()+".")==-1){
	    	    	result += "images/allow_file_type.png";
	    	    }else if(image.getSize() == 0){
	    	    	result += "images/invalid_image.png";
	    	    }else if(image.getSize()>Constant.allowFileSize){
	    	    	result += "images/allow_file_size.png";
	    	    }else{
	    	    	String source = request.getSession().getServletContext().getRealPath("/");
	    	    	String type=request.getParameter("type");
	    	    	if(type==null) type = "default";
	    	    	String subfoldername=type+"/";
	    	    	
	    	    	
	    	    	String name=new Date().getTime()+new Random().nextInt(10000)+img;
	    	    	File file=new File( source+"/repository/"+subfoldername+name);
	    	    	
	    	    	File parentFile = file.getParentFile();
	    	    	if(!parentFile.exists()){
	    	    		parentFile.mkdirs();
	    	    	}
	    	    	
	    	    	FileUtils.writeByteArrayToFile(file, image.getBytes());
	    	    	result += "repository/"+subfoldername+name;
	    	    }
	        }else{
	        	result += "images/invalid_image.png";
	        }
			
			String withname = request.getParameter("withname");
			if(withname!=null&&!withname.equals("")){
				result += "|"+fileName;
			}
		}
        return result;
	}
	
	/**
	 * 获取系统配置
	 * @param id		系统配置 key, 如果以“admin_”开头，需要超级管理员权限
	 * @param request
	 * @param response
	 * @return
	 * @throws ParseException 
	 */
	@RequestMapping("/getSysConfig")
	@ResponseBody
	public JsonObj getSysConfig(@RequestParam String id, HttpServletRequest request, HttpServletResponse response) throws ParseException {
		JsonObj result = new JsonObj();
		if(id==null){
			result.setStatus(-1); return result;
		}
//		if(id.startsWith("admin_")){
//			Cuser cuser = currentUser.getCuser(request, response);
//			if(cuser==null || cuser.getUsertype()<9){
//				result.setStatus(401); return result;
//			}
//		}
		
		Sysconfig findById = sysconfigDAO.findSysconfigById(id);
		if(findById==null){
			result.setStatus(404); return result;
		}
		/* 如果下一个计算日期为空或者已经小于当前日期，重设该日期为下一次过渡费计算日期*/
		/*
		JSONObject config = new JSONObject(findById.getValue());
		String next_quarter_fee_calc_due_date = null;
		if(config.has("next_quarter_fee_calc_due_date")){
			next_quarter_fee_calc_due_date = (String) config.get("next_quarter_fee_calc_due_date");
		}
		if(StringUtils.isNotBlank(next_quarter_fee_calc_due_date)){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			int dayOfEndQuarter = Integer.parseInt(((String) config.get("quarter1")).substring(8));
			Date date = sdf.parse(next_quarter_fee_calc_due_date);
			if(date.compareTo(getNoneTimeDate(new Date())) < 0){
				Date nextQuarter = this.getNextQuarter(dayOfEndQuarter);
				config.put("next_quarter_fee_calc_due_date", sdf.format(nextQuarter));
			}
		}*/
		result.setData(findById.getValue());
		// result.setData(config.toString());
		return result;
	}
	
	
	/**
	 * 设置系统配置 ，超级管理员可操作
	 * @param id		键
	 * @param value		值
	 * @param description
	 * @param request
	 * @param response
	 * @return
	 * @throws ParseException 
	 */
	@RequestMapping("/setSysConfig")
	@ResponseBody
	public JsonObj setSysConfig(@RequestParam String id, @RequestParam String value, @RequestParam(value="description", required=false) String description, HttpServletRequest request, HttpServletResponse response) throws ParseException {
		JsonObj result = new JsonObj();
		if(id==null){
			result.setStatus(-1); return result;
		}
		Cuser cuser = currentUser.getCuser(request, response);
		
		if(cuser==null){
			result.setStatus(401); return result;
		}
		
		if(cuser.getUsertype()>8 || id.startsWith("shop_recommend_")&&cuser.getUsertype()<9&&cuser.getUsertype()>4){}else{
			result.setStatus(403); return result;
		}
		
		Sysconfig findById = sysconfigDAO.findSysconfigById(id);
		/* 如果下一个计算日期为空或者已经小于当前日期，重设该日期为下一次过渡费计算日期*/
		JSONObject config = new JSONObject(value);
		String next_quarter_fee_calc_due_date = null;
		if(config.has("next_quarter_fee_calc_due_date")){
			next_quarter_fee_calc_due_date = (String) config.get("next_quarter_fee_calc_due_date");
		}
		if(StringUtils.isNotBlank(next_quarter_fee_calc_due_date)){
			
			String quarterEndDay1 = ((String) config.get("quarter1")).substring(5);
			String quarterEndDay2 = ((String) config.get("quarter2")).substring(5);
			String quarterEndDay3 = ((String) config.get("quarter3")).substring(5);
			String quarterEndDay4 = ((String) config.get("quarter4")).substring(5);
			Set<String> set = new HashSet<String>();
			set.add(quarterEndDay1);
			set.add(quarterEndDay2);
			set.add(quarterEndDay3);
			set.add(quarterEndDay4);
			String dueDate = next_quarter_fee_calc_due_date.substring(5);
			if(!set.contains(dueDate)){
				result.setStatus(-1);
				result.setMessage("下一个过渡费计算截止日只能是过渡费截止日");
				return result;
			}
			Sysconfig config2 = sysconfigDAO.findSysconfigById("admin_compute_transitionfee_time");
			String lastComputerTimeStr = config2.getValue();
			if(StringUtils.isNotBlank(lastComputerTimeStr)){
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				Date nextComputerTime = sdf.parse(next_quarter_fee_calc_due_date);
				Date lastComputerTime = sdf.parse(lastComputerTimeStr);
				if(nextComputerTime.compareTo(lastComputerTime) <= 0){
					result.setStatus(-1);
					result.setMessage("下一个过渡费计算截止日要大于上一次过渡费计算截止日" + lastComputerTimeStr);
					return result;
				}
			}
			
		}
		if(findById==null){
			findById = new Sysconfig();
			findById.setId(id);
			findById.setValue(value);
			findById.setDescription(description);
			sysconfigDAO.store(findById);
		}else{
			if(description!=null) findById.setDescription(description);
			findById.setValue(value);
			sysconfigDAO.store(findById);
		}
		
		result.setData("success");
		return result;
	}
	
	/**
	 * 获取地区码表
	 * @param parent	父级地区编码，获取省列表是为“000000”
	 * @param request
	 * @return
	 */
	@RequestMapping("Citycode")
	@ResponseBody
	public JsonObj getCityCode(@RequestParam String parent, HttpServletRequest request){
		JsonObj result = new JsonObj();
		List<Qxdmk> listQxdmk = commonService.listQxdmk(parent);
		Qxdmk p = qxdmkDAO.findQxdmkByQxdm(parent);
		if(p!=null){
			String qxmc = p.getQxmc();
			for (Qxdmk qxdmk : listQxdmk) {
				if(qxdmk.getQxmc().equals(qxmc)) continue;
				qxdmk.setQxmc(qxdmk.getQxmc().replace(qxmc, ""));
			}
		}
		result.setData(listQxdmk);
		return result;
	}
	
	/**
	 * 获取下一个季度过渡费截止日
	 * @param dayOfQuarterEnd 过渡费季度计算截止日
	 * @return
	 */
	private Date getNextQuarter(int dayOfQuarterEnd){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(getNoneTimeDate(new Date()));

		// 第一季度
		Calendar quartz1 = Calendar.getInstance();
		quartz1.setTime(calendar.getTime());
		quartz1.set(Calendar.MONTH, 2);
		quartz1.set(Calendar.DAY_OF_MONTH, dayOfQuarterEnd);
		
		// 第二季度
		Calendar quartz2 = Calendar.getInstance();
		quartz2.setTime(calendar.getTime());
		quartz2.set(Calendar.MONTH, 5);
		quartz2.set(Calendar.DAY_OF_MONTH, dayOfQuarterEnd);
		
		// 第三季度
		Calendar quartz3 = Calendar.getInstance();
		quartz3.setTime(calendar.getTime());
		quartz3.set(Calendar.MONTH, 8);
		quartz3.set(Calendar.DAY_OF_MONTH, dayOfQuarterEnd);	
		
		// 第四季度
		Calendar quartz4 = Calendar.getInstance();
		quartz4.setTime(calendar.getTime());
		quartz4.set(Calendar.MONTH, 11);
		quartz4.set(Calendar.DAY_OF_MONTH, dayOfQuarterEnd);
		
		Date ndate = null;
		if(calendar.compareTo(quartz1) < 0){
			ndate = quartz1.getTime();
		}else if(calendar.compareTo(quartz1) >= 0 && calendar.compareTo(quartz2) <0 ){
			ndate = quartz2.getTime();
		}else if(calendar.compareTo(quartz2) >= 0 && calendar.compareTo(quartz3) <0 ){
			ndate = quartz3.getTime();
		}else if(calendar.compareTo(quartz3) >= 0 && calendar.compareTo(quartz4) <0 ){
			ndate = quartz4.getTime();
		}else{
			calendar.add(Calendar.YEAR, 1);
			calendar.set(Calendar.MONTH, 2);
			calendar.set(Calendar.DAY_OF_MONTH, dayOfQuarterEnd);
			ndate = calendar.getTime();
		}
		
		return ndate;
	}
	
	/**
	 * 获取年月日日期
	 * @param date
	 * @return
	 */
	private Date getNoneTimeDate(Date date){
		Calendar calendar = Calendar.getInstance();
		//calendar.setTime(date);
		calendar.setTimeInMillis(date.getTime());
		// 忽略时间，日期计算只计算日期
		calendar.set(Calendar.HOUR, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		return calendar.getTime();
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder, HttpServletRequest request) { // Register static property editors.
	    binder.registerCustomEditor(java.util.Calendar.class, new org.skyway.spring.util.databinding.CustomCalendarEditor("yyyy.MM.dd"));
		binder.registerCustomEditor(byte[].class, new org.springframework.web.multipart.support.ByteArrayMultipartFileEditor());
		binder.registerCustomEditor(boolean.class, new org.skyway.spring.util.databinding.EnhancedBooleanEditor(false));
		binder.registerCustomEditor(Boolean.class, new org.skyway.spring.util.databinding.EnhancedBooleanEditor(true));
		binder.registerCustomEditor(java.math.BigDecimal.class, new org.skyway.spring.util.databinding.NaNHandlingNumberEditor(java.math.BigDecimal.class, true));
		binder.registerCustomEditor(Integer.class, new org.skyway.spring.util.databinding.NaNHandlingNumberEditor(Integer.class, true));
		binder.registerCustomEditor(java.util.Date.class, new org.skyway.spring.util.databinding.CustomDateEditor());
		binder.registerCustomEditor(String.class, new org.skyway.spring.util.databinding.StringEditor());
		binder.registerCustomEditor(Long.class, new org.skyway.spring.util.databinding.NaNHandlingNumberEditor(Long.class, true));
		binder.registerCustomEditor(Double.class, new org.skyway.spring.util.databinding.NaNHandlingNumberEditor(Double.class, true));
	}
	
}
