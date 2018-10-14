package com.vis.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.vis.service.MyRecordService;
import com.vis.service.MyService;

import common.dao.AuthorityDAO;
import common.dao.CuserDAO;
import common.dao.ProjectDAO;
import common.dao.QxdmkDAO;
import common.dao.RecordDAO;
import common.dao.RecordReturnDAO;
import common.dao.RecordTransitionfeeDAO;
import common.dao.SysconfigDAO;
import common.domain.Authority;
import common.domain.Cuser;
import common.domain.Project;
import common.domain.Qxdmk;
import common.domain.Record;
import common.domain.RecordReturn;
import common.domain.RecordTransitionfee;
import common.domain.RemovalRecord;
import common.domain.Sysconfig;
import common.entity.service.CalcRecordTransitionfeeRequestDTO;
import common.service.AdminService;
import common.service.TransitionfeeService;
import common.service.UserOperateLogService;
import common.service.util.MyCuserService;
import common.util.CommonsUtil;
import common.util.Constant;
import common.util.JsonObj;
import common.util.JsonObjHelper;
import common.util.Pager;
import common.util.PropertiesUtil;
import common.util.Toolkit;
import common.web.util.CurrentUser;

/**
 * 没有完不成的需求，只有付不起的钱
 * 
 * @author HanqingLiu
 *
 */
@Controller("AdminController")
public class AdminController {
	@Autowired
	CurrentUser currentUser;
	@Autowired
	QxdmkDAO qxdmkDAO;
	@Autowired
	CuserDAO cuserDAO;
	@Autowired
	RecordDAO recordDAO;
	@Autowired
	SysconfigDAO sysconfigDAO;
	@Autowired
	RecordReturnDAO returnDAO;
	@Autowired
	MyCuserService cuserService;
	@Autowired
	MyRecordService recordService;
	@Autowired
	ProjectDAO projectDAO;
	@Autowired
	RecordTransitionfeeDAO transitionfeeDAO;
	@Autowired
	MyService service;
	@Autowired
	AuthorityDAO authorityDAO;
	
	@Autowired
	UserOperateLogService userOperateLogService;
	
	@Autowired
	TransitionfeeService transitionfeeService;
	@Autowired
	AdminService adminService;
	private Logger log = Logger.getLogger(AdminController.class);

	@RequestMapping("/Admin")
	public ModelAndView Admin(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		Cuser cuser = currentUser.getCuser(request, response);
		if (cuser == null) {
			try {
				response.sendRedirect("Login?referer=Admin");
			} catch (IOException e) {
				log.error(CommonsUtil.getStackTrace(e));
			}
			return null;
		}
		mav.addObject("cuser", cuser);

		String page = request.getParameter("page");
		if (page == null) {
			if (cuser.getUsertype() < 5) {
				mav.setViewName("_index/profile.jsp");
			} else {
				if (Toolkit.checkUser(cuser, null, mav) == false)
					return mav;
				mav.setViewName("_index/admin.jsp");
			}
		} else if (page.equals("pwd")) {
			mav.setViewName("_index/changePwd.jsp");
		} else if (page.equals("profile")) {
			mav.setViewName("_index/profile.jsp");
		} else {
			if (cuser.getUsertype() < 5) {
				mav.setViewName("_index/profile.jsp");
			} else {
				if (Toolkit.checkUser(cuser, null, mav) == false)
					return mav;
				mav.setViewName("_index/admin.jsp");
			}
		}
		return mav;
	}

	/**
	 * 修改个人资料
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/changeProfile")
	@ResponseBody
	public JsonObj changeProfile(@ModelAttribute Cuser entity, HttpServletRequest request,
			HttpServletResponse response) {
		Cuser cuser = currentUser.getCuser(request, response);
		String username = (cuser == null) ? "" : cuser.getUsername();
		String tranName = "修改个人资料";
		JsonObj result = new JsonObj();
		try {
			if (cuser == null) {
				result.setStatus(401);
				return result;// 未登录
			}

			cuser.setGender(entity.getGender());
			if (entity.getNickname() != null && !entity.getNickname().equals("")) {
				cuser.setNickname(entity.getNickname());
			}
			if (entity.getQxdm() != null) {
				Qxdmk qxdmk = qxdmkDAO.findQxdmkByQxdm(entity.getQxdm());
				if (qxdmk != null) {
					cuser.setQxdm(qxdmk.getQxdm());
					cuser.setQxmc(qxdmk.getQxmc());
				}
			}
			if (entity.getAddress() != null) {
				cuser.setAddress(entity.getAddress());
			}
			if (entity.getPhoto() != null) {
				cuser.setPhoto(entity.getPhoto());
			}

			cuser = cuserDAO.store(cuser);
			result.setData("success");
			
			userOperateLogService.saveUserOperateLog(username, tranName, true, "交易成功");
			return result;
		} catch (Exception e) {
			userOperateLogService.saveUserOperateLog(username, tranName, false, "交易异常失败",e.toString());
			result.setMessage("交易失败" + e);
			throw e;
		}
	}

	
	
	/**
	 * 编辑 用户
	 * 
	 * @param id
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/EditUser")
	public ModelAndView editProvider(@RequestParam(value = "id", required = false) Integer id,
			@RequestParam(value = "type", required = false) Integer type, HttpServletRequest request,
			HttpServletResponse response) {
		Cuser cuser = currentUser.getCuser(request, response);
		String username = (cuser == null) ? "" : cuser.getUsername();
		String tranName = "编辑 用户";
		try {
			ModelAndView mav = new ModelAndView();
			String tmp = null;
			if (Toolkit.checkUser(cuser, null, mav) == false){
				userOperateLogService.saveUserOperateLog(username, tranName, false, "交易失败");
				return mav;
			}

			if (cuser.getUsertype() != Constant.ADMIN_USERTYPE) {
				userOperateLogService.saveUserOperateLog(username, tranName, false, "无权访问！");
				mav.addObject("message", "无权访问！");
				mav.setViewName("_common/goback.jsp");
				return mav;
			}
			Cuser entity = null;
			if (id != null)
				entity = cuserDAO.findCuserById(id);
			if (entity == null) {
				entity = new Cuser();
				entity.setUsertype(8);
			}
			mav.addObject("authList", service.listAuthority());
			mav.addObject("type", type);
			mav.addObject("cuser", cuser);
			mav.addObject("entity", entity);
			mav.setViewName("_index/editUser.jsp");
			userOperateLogService.saveUserOperateLog(username, tranName, true, "交易成功");
			return mav;
		} catch (Exception e) {
			userOperateLogService.saveUserOperateLog(username, tranName, false, "交易异常失败",e.toString());
			throw e;
		}
		
		
		
	}

	/**
	 * 系统参数配置页面
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/RecordConfig")
	public ModelAndView sysconfig(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		String tmp = null;
		Cuser cuser = currentUser.getCuser(request, response);
		if (Toolkit.checkUser(cuser, null, mav) == false)
			return mav;

		if (cuser.getUsertype() != Constant.ADMIN_USERTYPE) {
			mav.addObject("message", "无权访问！");
			mav.setViewName("_common/goback.jsp");
			return mav;
		}
		
		mav.addObject("cuser", cuser);
		mav.setViewName("_index/sysconfig.jsp");
		return mav;
	}

	/**
	 * 保存用户
	 * 
	 * @param entity
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/saveUser")
	@ResponseBody
	public JsonObj saveUser(@ModelAttribute Cuser entity, @RequestParam(value = "auths", required = false) String auths,
			HttpServletRequest request, HttpServletResponse response) {
		Cuser cuser = currentUser.getCuser(request, response);
		String username = (cuser == null) ? "" : cuser.getUsername();
		String tranName = "保存用户";
		JsonObj result = new JsonObj();
		try {
			
			if (Toolkit.checkUser(cuser, result, null) == false)
				return result;

			Cuser findById = null;
			if (entity.getId() != null) {
				findById = cuserDAO.findCuserById(entity.getId());
			}

			if (findById == null) {// 新增
				if (cuser.getUsertype() != Constant.ADMIN_USERTYPE) {
					result.setStatus(403);
					userOperateLogService.saveUserOperateLog(username, tranName, false, "无权限");
					return result; // 无权限
				}
				if (entity.getEmail() != null && cuserService.isExist(entity.getEmail(), "email")) {
					result.setStatus(3);
					userOperateLogService.saveUserOperateLog(username, tranName, false, "邮箱已存在");
					return result;// 邮箱已存在
				} else if (cuserService.isExist(entity.getUsername(), "username")) {
					result.setStatus(5);
					userOperateLogService.saveUserOperateLog(username, tranName, false, "用户名已存在");
					return result;// 用户名已存在
				} else if (cuserService.isExist(entity.getPhone(), "phone")) {
					result.setStatus(1);
					userOperateLogService.saveUserOperateLog(username, tranName, false, "手机号已被绑定");
					return result;// 手机号已被绑定
				} else if (entity.getUsertype() == Constant.ADMIN_USERTYPE) {
					result.setStatus(-1); // 不能添加超级管理员
					userOperateLogService.saveUserOperateLog(username, tranName, false, "不能添加超级管理员!");
					result.setMessage("不能添加超级管理员!");
					return result;
				}
				findById = cuserService.createPwd(entity, "init", entity.getPassword());
				findById.setCheckStatus(true);
				findById.setCreatedtime(Calendar.getInstance());
				findById.setIsDeleted(false);
				findById = cuserDAO.store(findById);
			} else {// 修改
				if (cuser.getUsertype() != Constant.ADMIN_USERTYPE && cuser != findById) {
					result.setStatus(403);
					userOperateLogService.saveUserOperateLog(username, tranName, false, "无权限");
					return result;// 无权限
				}
				if (entity.getEmail() != null && !entity.getEmail().equals(findById.getEmail())
						&& cuserService.isExist(entity.getEmail(), "email")) {
					result.setStatus(3);
					userOperateLogService.saveUserOperateLog(username, tranName, false, "邮箱已存在");
					return result;// 邮箱已存在
				} else if (entity.getPhone() == null || entity.getPhone().length() != 11) {
					result.setStatus(-1);
					userOperateLogService.saveUserOperateLog(username, tranName, false, "手机号无效");
					result.setMessage("手机号无效!");// 手机号无效
					return result;
				} else if (!entity.getPhone().equals(findById.getPhone())
						&& cuserService.isExist(entity.getPhone(), "phone")) {
					result.setStatus(1);
					userOperateLogService.saveUserOperateLog(username, tranName, false, "手机号已被绑定");
					return result;// 手机号已被绑定
				}
				findById.setPhone(entity.getPhone());
				findById.setEmail(entity.getEmail());
				findById.setNickname(entity.getNickname());
				findById = cuserDAO.store(findById);
			}

			String authority = ",";
			String authorityGroup = ",";
			if (auths == null)
				auths = "";
			String[] split = auths.split(",");
			for (String id : split) {
				Authority auth = authorityDAO.findAuthorityById(Integer.parseInt(id));
				if (auth == null)
					continue;

				authority += auth.getMethod() + ",";
				authorityGroup += auth.getName() + ",";
			}
			findById.setAuthority(authority);
			findById.setAuthorityGroup(authorityGroup);
			findById = cuserDAO.store(findById);

			result.setData(JsonObjHelper.cuser(cuser, findById));
			userOperateLogService.saveUserOperateLog(username, tranName, true, "交易成功");
			return result;
		} catch (Exception e) {
			userOperateLogService.saveUserOperateLog(username, tranName, false, "交易异常失败",e.toString());
			result.setMessage("交易失败: " + e);
			throw e;
		}
		
	}

	/**
	 * 用户列表
	 * 
	 * @param keyword
	 * @param type
	 *            用户类型
	 * @param request
	 * @param response
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping("/ListUser")
	public ModelAndView listUser(@RequestParam(value = "keyword", required = false) String keyword,
			@RequestParam(value = "type", required = false) Integer type, HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException {
		ModelAndView mav = new ModelAndView();
		Cuser cuser = currentUser.getCuser(request, response);
		if (Toolkit.checkUser(cuser, null, mav) == false)
			return mav;

		if (cuser.getUsertype() != Constant.ADMIN_USERTYPE || type != null && type == Constant.ADMIN_USERTYPE) {
			mav.addObject("message", "无权访问！");
			mav.setViewName("_common/goback.jsp");
			return mav;
		}

		if (type == null)
			type = 8;
		if (keyword == null)
			keyword = "";
		int totalcount = cuserService.countCuser(keyword, type);
		Pager pager = new Pager(request, totalcount);
		List<Cuser> list = cuserService.listCuser(keyword, type, pager.offset, pager.ps);

		pager.url = "ListUser?pS=" + pager.ps;
		if (keyword != null && !keyword.equals(""))
			pager.url += "&keyword=" + java.net.URLEncoder.encode(keyword, "UTF-8");
		if (type != 8)
			pager.url += "&type=" + type;
		mav.addObject("cuser", cuser);
		mav.addObject("keyword", keyword);
		mav.addObject("type", type);
		mav.addObject("list", list);
		mav.addObject("pager", pager);
		mav.setViewName("_index/listUser.jsp");
		return mav;
	}

	/**
	 * 拆迁信息录入
	 * 
	 * @param id
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/EditRecord")
	public ModelAndView editRecord(@RequestParam(value = "id", required = false) Integer id, HttpServletRequest request,
			HttpServletResponse response) {
		Cuser cuser = currentUser.getCuser(request, response);
		String username = (cuser == null) ? "" : cuser.getUsername();
		String tranName = "拆迁信息录入";
		
		try {
			ModelAndView mav = new ModelAndView();
			String tmp = null;
			if (Toolkit.checkUser(cuser, null, mav) == false)
				return mav;

			if (cuser.getUsertype() < 8) {
				userOperateLogService.saveUserOperateLog(username, tranName, false, "无权操作！");
				mav.addObject("message", "无权操作！");
				mav.setViewName("_common/goback.jsp");
				return mav;
			}
			Record entity = null;
			Record last = null;
			if (id != null)
				entity = recordDAO.findRecordById(id);
			if (entity == null) {
				entity = new Record();
				entity.setCuser(cuser);
				entity.setStartDealTime(Calendar.getInstance());

				last = recordService.lastRecord();
			}

			if (cuser.getUsertype() < 8 && cuser.getId() * 1 != entity.getCuser().getId()) {
				userOperateLogService.saveUserOperateLog(username, tranName, false, "无权操作！");
				mav.addObject("message", "无权操作！"); // 他人添加的，无权修改
				mav.setViewName("_common/goback.jsp");
				return mav;
			}

			mav.addObject("last", last);
			mav.addObject("cuser", cuser);
			mav.addObject("entity", entity);
			mav.setViewName("_index/editRecord.jsp");
			
			userOperateLogService.saveUserOperateLog(username, tranName, true, "交易成功");
			return mav;
		} catch (Exception e) {
			userOperateLogService.saveUserOperateLog(username, tranName, false, "交易异常失败",e.toString()); 
			throw e;
		}
		
	}

	/**
	 * 检测合同编号是否已存在
	 * 
	 * @param number
	 * @param type
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/checkContractNumber")
	@ResponseBody
	public JsonObj checkContractNumber(@RequestParam String number,
			@RequestParam(value = "id", required = false) Integer id, HttpServletRequest request,
			HttpServletResponse response) {
		JsonObj result = new JsonObj();
		boolean check = recordService.checkContractNumber(number, id);
		result.setData(check);
		return result;
	}

	/**
	 * 保存拆迁记录
	 * 
	 * @param entity
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/saveRecord2")
	@ResponseBody
	public JsonObj saveRecord(@ModelAttribute Record entity, HttpServletRequest request, HttpServletResponse response) {
		Cuser cuser = currentUser.getCuser(request, response);
		String username = (cuser == null) ? "" : cuser.getUsername();
		String tranName = "保存拆迁记录";
		
		JsonObj result = new JsonObj();
		try {
			if (Toolkit.checkUser(cuser, result, null) == false)
				return result;
			result = adminService.saveRecord(entity, cuser);
			userOperateLogService.saveUserOperateLog(username, tranName, true, "交易成功");
			return result;			
		} catch (Exception e) {
			userOperateLogService.saveUserOperateLog(username, tranName, false, "交易异常失败",e.toString()); 
			result.setMessage("交易失败: " + e);
			throw e;
		}
	}

	/**
	 * 过渡费登记页面
	 * 
	 * @param id
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/EditTransitionfee")
	public ModelAndView editTransitionfee(@RequestParam Integer id, HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		String tmp = null;
		Cuser cuser = currentUser.getCuser(request, response);
		if (Toolkit.checkUser(cuser, null, mav) == false)
			return mav;

		if (cuser.getUsertype() < 8) {
			mav.addObject("message", "无权操作！");
			mav.setViewName("_common/goback.jsp");
			return mav;
		}
		Record entity = null;
		if (id != null)
			entity = recordDAO.findRecordById(id);
		if (entity == null) {
			mav.addObject("message", "拆迁记录不存在,请先添加拆迁信息！");
			mav.setViewName("_common/goback.jsp");
			return mav;
		}

		if (cuser.getUsertype() < 8 && cuser.getId() * 1 != entity.getCuser().getId()) {
			mav.addObject("message", "无权操作！"); // 他人添加的，无权修改
			mav.setViewName("_common/goback.jsp");
			return mav;
		}

		mav.addObject("cuser", cuser);
		mav.addObject("entity", entity);
		mav.setViewName("_index/editTransitionfee.jsp");
		return mav;
	}

	/**
	 * 保存过渡费
	 * 
	 * @param entity
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/saveTransitionfee2")
	@ResponseBody
	public JsonObj saveTransitionfee(@ModelAttribute Record entity, HttpServletRequest request,
			HttpServletResponse response) {
		
		Cuser cuser = currentUser.getCuser(request, response);
		String username = (cuser == null) ? "" : cuser.getUsername();
		String tranName = "保存过渡费";
		
		JsonObj result = new JsonObj();
		try {
			if (Toolkit.checkUser(cuser, result, null) == false)
				return result;

			Record findById = null;
			if (entity.getId() != null) {
				findById = recordDAO.findRecordById(entity.getId());
			}
			if (findById == null) {
				result.setStatus(404);
				result.setMessage("拆迁记录不存在,请先添加拆迁信息！");
				userOperateLogService.saveUserOperateLog(username, tranName, false, "拆迁记录不存在,请先添加拆迁信息！");
				return result;
			}

			try {
				/*long diff = (entity.getEndTime().getTime().getTime() - entity.getStartTime().getTime().getTime()) / 1000;
				int range = (int) (diff / 3600 / 24);
				entity.setPerFee(
						new BigDecimal(entity.getTotal() == null ? 0.0 : entity.getTotal().doubleValue() * 1.0 / range));*/
			} catch (Exception e) {
			}

			/*if (cuser.getUsertype() < 8 && cuser.getId() * 1 != findById.getCuser().getId()) {
				result.setStatus(403);
				return result;// 无权限
			}*/

			findById.setTotal(entity.getTotal());
			findById.setRecordNumber(entity.getRecordNumber());
			findById.setProjectName(entity.getProjectName());
			findById.setProject(recordService.findOrSaveProjectByName(entity.getProjectName()));
			findById.setUsername(entity.getUsername());
			findById.setUsercontact(entity.getUsercontact());
			findById.setUseraddress(entity.getUseraddress());
			findById.setFirstStartTime(entity.getFirstStartTime());
			findById.setFirstEndTime(entity.getFirstEndTime());
			findById.setFacilityFee(entity.getFacilityFee());
			findById.setTransportFee(entity.getTransportFee());
			findById.setTransitionFee(entity.getTransitionFee());
			findById.setMovingFee(entity.getMovingFee());
			findById.setAwardFee(entity.getAwardFee());
			findById.setDiscontinuedFee(entity.getDiscontinuedFee());
			findById.setSelfdemolitionFee(entity.getSelfdemolitionFee());
			findById.setOtherFee(entity.getOtherFee());
			findById.setRemark(entity.getRemark());
			
			recordDAO.store(findById);
			userOperateLogService.saveUserOperateLog(username, tranName, true, "交易成功");
			return result;
		} catch (Exception e) {
			userOperateLogService.saveUserOperateLog(username, tranName, false, "交易异常失败",e.toString()); 
			result.setMessage("交易失败: " + e);
			return result;
		}
		
		
	}

	/**
	 * 根据合同号查询
	 * 
	 * @param keyword
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/searchRecord")
	@ResponseBody
	public JsonObj searchRecord(@RequestParam String keyword, HttpServletRequest request,
			HttpServletResponse response) {
		JsonObj result = new JsonObj();
		Cuser cuser = currentUser.getCuser(request, response);
		if (Toolkit.checkUser(cuser, result, null) == false)
			return result;
		Record record = recordService.findByContractNumber(keyword);
		result.setData(JsonObjHelper.mapBasicProperty(record));
		return result;
	}

	/**
	 * 根据pid查询
	 * 
	 * @param pid
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/searchRecordByPid")
	@ResponseBody
	public JsonObj searchRecordByPid(@RequestParam Integer keyword, HttpServletRequest request,
			HttpServletResponse response) {
		JsonObj result = new JsonObj();
//		Cuser cuser = currentUser.getCuser(request, response);
//		if (Toolkit.checkUser(cuser, result, null) == false)
//			return result;
		Record record = recordService.findByPid(keyword);
		if(record == null){
			return result;
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("contractNumber", record.getContractNumber());
		map.put("recordNumber", record.getRecordNumber());
		map.put("projectName", record.getProjectName());
		map.put("useraddress", record.getUseraddress());
		//map.put("remark", record.getRemark());
		result.setData(map);
		return result;
		/*
		try {
			String json = net.sf.json.JSONObject.fromObject(result).toString();
			log.info("json:" + json);
			// response.getWriter().write(json.getBytes("utf-8"));
		} catch (IOException e) {
			log.error(CommonsUtil.getStackTrace(e));
		}
		*/
		
		
	}

	/**
	 * 拆迁记录列表
	 * 
	 * @param keyword
	 * @param uid
	 * @param request
	 * @param response
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping("/ListRecord")
	public ModelAndView listRecord(@RequestParam(value = "status", required = false) Integer status,
			@RequestParam(value = "started", required = false) Boolean started,
			@RequestParam(value = "ended", required = false) Boolean ended,
			@RequestParam(value = "keyword", required = false) String keyword,
			@RequestParam(value = "uid", required = false) Integer uid,
			@RequestParam(value = "pid", required = false) Integer pid,
			@RequestParam(value = "replaceFlag", required = false) Integer replaceFlag,
			@RequestParam(value = "pauseCalculateFee", required = false) Boolean pauseCalculateFee,
			@RequestParam(value = "pendingState", required = false) Integer pendingState,HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException {
		ModelAndView mav = new ModelAndView();
		Cuser cuser = currentUser.getCuser(request, response);
		if (Toolkit.checkUser(cuser, null, mav) == false)
			return mav;

		if (cuser.getUsertype() < 8) {
			uid = cuser.getId();
		}
		int totalcount = recordService.countRecord(uid, pid, keyword, status, replaceFlag, started, ended,pauseCalculateFee);
		Pager pager = new Pager(request, totalcount);
		List<Record> list = recordService.listRecord(uid, pid, keyword, status, replaceFlag, started, ended,pauseCalculateFee,
				pager.offset, pager.ps, pendingState);

		pager.url = "ListRecord?pS=" + pager.ps;
		if (keyword != null)
			pager.url += "&keyword=" + java.net.URLEncoder.encode(keyword, "UTF-8");
		if (uid != null && cuser.getUsertype() > 8)
			pager.url += "&uid=" + uid;
		if (pid != null)
			pager.url += "&pid=" + pid;
		if (replaceFlag != null)
			pager.url += "&replaceFlag=" + replaceFlag;
		if (started != null)
			pager.url += "&started=" + started;
		if (ended != null)
			pager.url += "&ended=" + ended;
		if (pauseCalculateFee != null)
			pager.url += "&pauseCalculateFee=" + pauseCalculateFee;
		if (status != null)
			pager.url += "&status=" + status;

		mav.addObject("cuser", cuser);
		mav.addObject("keyword", keyword);
		mav.addObject("userid", uid);
		mav.addObject("pid", pid);
		mav.addObject("replaceFlag", replaceFlag);
		mav.addObject("started", started);
		mav.addObject("ended", ended);
		mav.addObject("status", status);
		mav.addObject("list", list);
		mav.addObject("pager", pager);
		mav.addObject("projectList", recordService.search("", 0, 10000));
		mav.addObject("today", Calendar.getInstance().getTime().getTime());
		mav.addObject("now", Calendar.getInstance().getTime());
		mav.setViewName("_index/listRecord.jsp");
		return mav;
	}

	/**
	 * 列出过渡费
	 * 
	 * @param keyword
	 * @param uid
	 * @param pname
	 * @param request
	 * @param response
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	/*
	 * @RequestMapping("/ListRecordTransitionfee") public ModelAndView
	 * listRecordTransitionfee(@RequestParam(value="keyword",required=false)
	 * String keyword, @RequestParam(value="uid",required=false) Integer
	 * uid, @RequestParam(value="pname",required=false) String pname,
	 * HttpServletRequest request, HttpServletResponse response) throws
	 * UnsupportedEncodingException { ModelAndView mav = new ModelAndView();
	 * Cuser cuser = currentUser.getCuser(request, response);
	 * if(Toolkit.checkUser(cuser, null, mav)==false) return mav;
	 * 
	 * if(cuser.getUsertype()<9){ uid = cuser.getId(); } int totalcount =
	 * recordService.countRecordTransitionfee(uid, pname, keyword); Pager pager
	 * = new Pager(request, totalcount); List<RecordTransitionfee> list =
	 * recordService.listRecordTransitionfee(uid, pname, keyword, pager.offset,
	 * pager.ps);
	 * 
	 * pager.url = "ListRecord?pS="+pager.ps; if(keyword!=null) pager.url +=
	 * "&keyword="+java.net.URLEncoder.encode(keyword,"UTF-8"); if(uid!=null &&
	 * cuser.getUsertype()>8) pager.url += "&uid="+uid; if(pname!=null)
	 * pager.url += "&pid="+java.net.URLEncoder.encode(pname,"UTF-8");
	 * 
	 * mav.addObject("cuser", cuser); mav.addObject("keyword", keyword);
	 * mav.addObject("userid", uid); mav.addObject("pname", pname);
	 * mav.addObject("list", list); mav.addObject("pager", pager);
	 * mav.addObject("projectList", recordService.search("",0,60));
	 * mav.addObject("today", Calendar.getInstance().getTime().getTime());
	 * mav.setViewName("_index/listRecordTransitionfee.jsp"); return mav; }
	 */
	@RequestMapping({ "/pendingRecordCount" })
	public void pendingRecordCount(@ModelAttribute Record entity, HttpServletRequest request,
			HttpServletResponse response) {
		String num = "";
		JsonObj result = new JsonObj();
		Cuser cuser = this.currentUser.getCuser(request, response);
		if (Toolkit.checkUser(cuser, result, null)) {
			if (cuser.getUsertype().intValue() != 10) {
				String authorityGroup = cuser.getAuthorityGroup();
				if (StringUtils.isNotBlank(authorityGroup)) {
					List list = Arrays.asList(authorityGroup.split(","));
					if (list.contains("过渡费管理"))
						num = this.recordService.pendingRecordCount("1").toString();
					else if (list.contains("账号信息"))
						num = this.recordService.pendingRecordCount("2").toString();
				}
			} else {
				Long admin2 = this.recordService.pendingRecordCount("1");
				Long admin4 = this.recordService.pendingRecordCount("2");
				num = admin2.longValue() + admin4.longValue() + "";
			}
		}

		try {
			response.getWriter().write(num);
		} catch (IOException e) {
			log.error(CommonsUtil.getStackTrace(e));
		}
	}

	@RequestMapping({ "/initRemovalRecord" })
	public void initRemovalRecord(HttpServletRequest request, HttpServletResponse response) {
		Cuser cuser = this.currentUser.getCuser(request, response);
		JsonObj result = new JsonObj();
		try {
			if (!(Toolkit.checkUser(cuser, result, null))) {
				response.getWriter().write("");

				return;
			}
			if (cuser.getUsertype().intValue() == 10) {
				RemovalRecord removalRecord = recordService.initRemovalRecord();
				if (removalRecord == null) {
					response.getWriter().write("error");
					return;
				}
				String json = net.sf.json.JSONObject.fromObject(removalRecord).toString();
				System.out.println(json);
				response.getWriter().write(json);

				return;
			}
			response.getWriter().write("");
		} catch (Exception e) {
			log.error(CommonsUtil.getStackTrace(e));
			try {
				response.getWriter().write("error");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

	/**
	 * 更改记录状态
	 * 
	 * @param id
	 * @param status
	 * @param start
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/changeStatusRecord")
	@ResponseBody
	public JsonObj changeStatusRecord(@RequestParam Integer id, @RequestParam(required=false) Boolean status,
			@RequestParam(required=false) Boolean start, 
			@RequestParam(required=false) Boolean pauseCalculateFee,
			HttpServletRequest request, HttpServletResponse response) {
		Cuser cuser = currentUser.getCuser(request, response);
		String username = (cuser == null) ? "" : cuser.getUsername();
		String tranName = "更改拆迁记录状态";
		JsonObj result = new JsonObj();
		try {
			
			if (Toolkit.checkUser(cuser, result, null) == false)
				return result;
			
			Record findById = recordDAO.findRecordById(id);
			if (findById == null) {
				result.setStatus(404);// 不存在
				userOperateLogService.saveUserOperateLog(username, tranName, false, "不存在");
				return result;
			}

			if (cuser.getUsertype() < 8 && cuser.getId() * 1 != findById.getCuser().getId()) {
				userOperateLogService.saveUserOperateLog(username, tranName, false, "无权限");
				result.setStatus(403);
				return result;
			}
			if(status != null){
				if (start != null && start == true) {
					findById.setIsStart(status);
				} else {
					findById.setIsEnd(status);
				}
			}
			if (pauseCalculateFee != null) {
				findById.setPauseCalculateFee(pauseCalculateFee);
			}
			
			recordDAO.store(findById);

			result.setData(true);
			userOperateLogService.saveUserOperateLog(username, tranName, true, "交易成功");
			return result;

		} catch (Exception e) {
			userOperateLogService.saveUserOperateLog(username, tranName, false, "交易异常失败",e.toString()); 
			result.setMessage("删除失败：" + e.toString());
			return result;
		}
		
		
	}

	@RequestMapping("/changeStatusRecord3")
	@ResponseBody
	public JsonObj changeStatusRecord3(@RequestParam String ids, @RequestParam(required=false) Boolean status,
			@RequestParam(required=false) Boolean start, 
			@RequestParam(required=false) Boolean pauseCalculateFee,
		HttpServletRequest request, HttpServletResponse response) {
		

		Cuser cuser = currentUser.getCuser(request, response);
		String username = (cuser == null) ? "" : cuser.getUsername();
		String tranName = "更新拆迁记录状态";
		
		JsonObj result = new JsonObj();
		try {
			if (Toolkit.checkUser(cuser, result, null) == false)
				return result;

			String[] split = ids.split(",");
			for (String id : split) {
				if (id.equals(""))
					continue;

				Record findById = recordDAO.findRecordById(Integer.parseInt(id));
				if (findById == null)
					continue;

				if (cuser.getUsertype() < 8 && cuser.getId() * 1 != findById.getCuser().getId()) {
					continue;
				}
				
				if(status != null){
					if (start != null && start == true) {
						findById.setIsStart(status);
					} else {
						findById.setIsEnd(status);
					}
				}
				if (pauseCalculateFee != null) {
					findById.setPauseCalculateFee(pauseCalculateFee);
				}
				
				recordDAO.store(findById);
			}

			result.setData(true);
			userOperateLogService.saveUserOperateLog(username, tranName, true, "交易成功");
			return result;
		} catch (Exception e) {
			userOperateLogService.saveUserOperateLog(username, tranName, false, "交易异常失败",e.toString()); 
			result.setMessage("交易失败: " + e);
			return result;
		}

	}

	/**
	 * 删除拆迁记录
	 * 
	 * @param id
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/deleteRecord2")
	@ResponseBody
	public JsonObj deleteRecord(@RequestParam Integer id, HttpServletRequest request, HttpServletResponse response) {
		Cuser cuser = currentUser.getCuser(request, response);
		String username = (cuser == null) ? "" : cuser.getUsername();
		String tranName = "删除拆迁记录";
		
		JsonObj result = new JsonObj();
		try {
			if (Toolkit.checkUser(cuser, result, null) == false)
				return result;

			Record findById = recordDAO.findRecordById(id);
			if (findById == null) {
				result.setStatus(404);// 不存在
				userOperateLogService.saveUserOperateLog(username, tranName, false, "不存在");
				return result;
			}

			if (cuser.getUsertype() < 8 && cuser.getId() * 1 != findById.getCuser().getId()) {
				userOperateLogService.saveUserOperateLog(username, tranName, false, "没权限");
				result.setStatus(403);
				return result;
			}

			findById.setIsDeleted(true);
			findById.setDeletedTime(Calendar.getInstance());
			recordDAO.store(findById);

			result.setData(true);
			userOperateLogService.saveUserOperateLog(username, tranName, true, "交易成功");
			return result;
		
		} catch (Exception e) {
			userOperateLogService.saveUserOperateLog(username, tranName, false, "交易异常失败",e.toString()); 
			result.setMessage("交易失败: " + e);
			return result;
		}
		
	}

	@RequestMapping("/deleteRecord3")
	@ResponseBody
	public JsonObj deleteRecord3(@RequestParam String ids, HttpServletRequest request, HttpServletResponse response) {
		
		Cuser cuser = currentUser.getCuser(request, response);
		String username = (cuser == null) ? "" : cuser.getUsername();
		String tranName = "删除过渡费";
		JsonObj result = new JsonObj();
		try {
			
			if (Toolkit.checkUser(cuser, result, null) == false)
				return result;

			int successCount = 0;
			int errorCount = 0;
			String[] split = ids.split(",");
			for (String id : split) {
				if (id.equals(""))
					continue;

				Record findById = recordDAO.findRecordById(Integer.parseInt(id));
				
				if (findById == null)
					continue;

				if (cuser.getUsertype() < 8 && cuser.getId() * 1 != findById.getCuser().getId()) {
					errorCount++;
					continue;
				}
				
//				Set<RecordTransitionfee> recordTransitionfees = findById.getRecordTransitionfees();
//				for (RecordTransitionfee recordTransitionfee : recordTransitionfees) {
//					transitionfeeDAO.remove(recordTransitionfee);
//				}
				Set<RecordReturn> recordReturns = returnDAO.findRecordReturnBySid(Integer.parseInt(id));
				for (RecordReturn recordReturn : recordReturns) {
					returnDAO.remove(recordReturn);
				}
				recordDAO.remove(findById);
				successCount++;
			}

			String msg = "操作完成，删除记录成功 " + successCount + " 条";
			if (errorCount > 0)
				msg += "，失败 " + errorCount + " 条";
			msg += "。";

			result.setMessage(msg);
			userOperateLogService.saveUserOperateLog(username, tranName, true, msg);
			return result;
		
		} catch (Exception e) {
			userOperateLogService.saveUserOperateLog(username, tranName, false, "交易异常失败",e.toString()); 
			result.setMessage("删除失败：" + e.toString());
			return result;
		}
		
		
	}

	/**
	 * 删除过渡费
	 * 
	 * @param id
	 * @param request
	 * @param response
	 * @return
	 */
	/*
	 * @RequestMapping("/deleteRecordTransitionfee2")
	 * 
	 * @ResponseBody public JsonObj deleteRecordTransitionfee(@RequestParam
	 * Integer id, HttpServletRequest request, HttpServletResponse response) {
	 * JsonObj result = new JsonObj(); Cuser cuser =
	 * currentUser.getCuser(request, response); if(Toolkit.checkUser(cuser,
	 * result, null)==false) return result;
	 * 
	 * RecordTransitionfee findById =
	 * recordTransitionfeeDAO.findRecordTransitionfeeById(id);
	 * if(findById==null){ result.setStatus(404);//不存在 return result; }
	 * 
	 * if(cuser.getUsertype()<9 &&
	 * cuser.getId()*1!=findById.getCuser().getId()){ result.setStatus(403);
	 * return result; }
	 * 
	 * findById.setIsDeleted(true);
	 * findById.setDeletedTime(Calendar.getInstance());
	 * findById.setDeletedUser(cuser.getUsername());
	 * recordTransitionfeeDAO.store(findById);
	 * 
	 * result.setData(true); return result; }
	 */

	/*
	 * @RequestMapping("/deleteRecordTransitionfee3")
	 * 
	 * @ResponseBody public JsonObj deleteRecordTransitionfee3(@RequestParam
	 * String ids, HttpServletRequest request, HttpServletResponse response) {
	 * JsonObj result = new JsonObj(); Cuser cuser =
	 * currentUser.getCuser(request, response); if(Toolkit.checkUser(cuser,
	 * result, null)==false) return result;
	 * 
	 * int successCount = 0; int errorCount = 0; String[] split =
	 * ids.split(","); for (String id : split) { if(id.equals("")) continue;
	 * 
	 * RecordTransitionfee findById =
	 * recordTransitionfeeDAO.findRecordTransitionfeeById(Integer.parseInt(id));
	 * if(findById == null) continue;
	 * 
	 * if(cuser.getUsertype()<9 &&
	 * cuser.getId()*1!=findById.getCuser().getId()){ errorCount++; continue; }
	 * 
	 * findById.setIsDeleted(true);
	 * findById.setDeletedTime(Calendar.getInstance());
	 * findById.setDeletedUser(cuser.getUsername());
	 * recordTransitionfeeDAO.store(findById); successCount++; }
	 * 
	 * String msg = "操作完成，删除记录成功 "+successCount+" 条"; if(errorCount>0) msg +=
	 * "，失败 "+errorCount+" 条"; msg += "。";
	 * 
	 * result.setMessage(msg); return result; }
	 */

	/**
	 * 过渡费列表
	 * 
	 * @param keyword
	 * @param uid
	 * @param year
	 * @param quarter
	 * @param pname
	 * @param dealed
	 * @param request
	 * @param response
	 * @param serviceDepartment 办事处
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping("/ListTransitionfee")
	public ModelAndView listTransitionfee(@RequestParam(value = "type", required = false) String type,
			@RequestParam(value = "keyword", required = false) String keyword,
			@RequestParam(value = "uid", required = false) Integer uid,
			@RequestParam(value = "year", required = false) Integer year,
			@RequestParam(value = "quarter", required = false) Integer quarter,
			@RequestParam(value = "pname", required = false) String pname,
			@RequestParam(value = "serviceDepartment", required = false) String serviceDepartment,
			@RequestParam(value = "dealed", required = false) Boolean dealed, HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException {
		ModelAndView mav = new ModelAndView();
		Cuser cuser = currentUser.getCuser(request, response);
		if (Toolkit.checkUser(cuser, null, mav) == false)
			return mav;

		Calendar now = Calendar.getInstance();
		if (cuser.getUsertype() < 8) {
			uid = cuser.getId();
		}

		int totalcount = recordService.countTransitionfee(keyword, uid, null, pname, type, dealed, year, quarter,serviceDepartment);
		Pager pager = new Pager(request, totalcount);
		List<RecordTransitionfee> list = recordService.listTransitionfee(keyword, uid, null, pname, type, dealed, year,
				quarter, serviceDepartment,pager.offset, pager.ps);

		pager.url = "ListTransitionfee?pS=" + pager.ps;
		if (keyword != null)
			pager.url += "&keyword=" + java.net.URLEncoder.encode(keyword, "UTF-8");
		if (uid != null && cuser.getUsertype() > 8)
			pager.url += "&uid=" + uid;
		if (pname != null)
			pager.url += "&pname=" + java.net.URLEncoder.encode(pname, "UTF-8");
		if (dealed != null)
			pager.url += "&dealed=" + dealed;
		if (type != null)
			pager.url += "&type=" + type;
		if (year != null)
			pager.url += "&year=" + year;
		if (quarter != null)
			pager.url += "&quarter=" + quarter;
		if (org.apache.commons.lang3.StringUtils.isBlank(serviceDepartment))
			pager.url += "&serviceDepartment=" + serviceDepartment;

		mav.addObject("cuser", cuser);
		mav.addObject("keyword", keyword);
		mav.addObject("userid", uid);
		mav.addObject("pname", pname);
		mav.addObject("dealed", dealed);
		mav.addObject("year", year);
		mav.addObject("quarter", quarter);
		mav.addObject("serviceDepartment", serviceDepartment);
		mav.addObject("type", type);
		mav.addObject("list", list);
		mav.addObject("pager", pager);
		mav.addObject("projectList", recordService.search("", 0, 10000));
		mav.addObject("thisyear", Calendar.getInstance().get(Calendar.YEAR));

		mav.setViewName("_index/listTransitionfee.jsp");
		return mav;
	}

	/**
	 * 删除过渡费记录
	 * 
	 * @param id
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/deleteTransitionfee2")
	@ResponseBody
	public JsonObj deleteTransitionfee(@RequestParam Integer id, HttpServletRequest request,
			HttpServletResponse response) {
		Cuser cuser = currentUser.getCuser(request, response);
		String username = (cuser == null) ? "" : cuser.getUsername();
		String tranName = "删除过渡费记录";
		
		JsonObj result = new JsonObj();
		try {
			if (Toolkit.checkUser(cuser, result, null) == false)
				return result;

			RecordTransitionfee findById = transitionfeeDAO.findRecordTransitionfeeById(id);
			if (findById == null) {
				userOperateLogService.saveUserOperateLog(username, tranName, false, "不存在");
				result.setStatus(404);// 不存在
				return result;
			}

			if (cuser.getUsertype() < 8 && cuser.getId() * 1 != findById.getRecord().getCuser().getId()) {
				result.setStatus(403);
				userOperateLogService.saveUserOperateLog(username, tranName, false, "没权限");
				return result;
			}

			findById.setIsDeleted(true);
			findById.setDeletedTime(Calendar.getInstance());
			transitionfeeDAO.store(findById);

			result.setData(true);
			userOperateLogService.saveUserOperateLog(username, tranName, true, "交易成功");
			return result;
		
		} catch (Exception e) {
			userOperateLogService.saveUserOperateLog(username, tranName, false, "交易异常失败",e.toString()); 
			result.setMessage("交易失败: " + e);
			return result;
		}
		
	}

	/**
	 * 标记过渡费已处理
	 * 
	 * @param id
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/dealTransitionfee")
	@ResponseBody
	public JsonObj dealTransitionfee(@RequestParam Integer id, HttpServletRequest request,
			HttpServletResponse response) {
		
		Cuser cuser = currentUser.getCuser(request, response);
		String username = (cuser == null) ? "" : cuser.getUsername();
		String tranName = "标记过渡费已处理";
		
		JsonObj result = new JsonObj();
		try {
			if (Toolkit.checkUser(cuser, result, null) == false)
				return result;

			RecordTransitionfee findById = transitionfeeDAO.findRecordTransitionfeeById(id);
			if (findById == null) {
				result.setStatus(404);// 不存在
				userOperateLogService.saveUserOperateLog(username, tranName, false, "不存在");
				return result;
			}

			if (cuser.getUsertype() < 8 && cuser.getId() * 1 != findById.getRecord().getCuser().getId()) {
				result.setStatus(403);
				userOperateLogService.saveUserOperateLog(username, tranName, false, "没权限");
				return result;
			}

			findById.setIsDealed(true);
			findById.setDealedTime(Calendar.getInstance());
			transitionfeeDAO.store(findById);

			result.setData(true);
			userOperateLogService.saveUserOperateLog(username, tranName, true, "交易成功");
			return result;
		
		} catch (Exception e) {
			userOperateLogService.saveUserOperateLog(username, tranName, false, "交易异常失败",e.toString()); 
			result.setMessage("交易失败: " + e);
			return result;
		}
		
		
		
	}
	
	/**
	 * 标记拆迁记录为已付款
	 * @param ids
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/dealTransitionfee2")
	@ResponseBody
	public JsonObj dealTransitionfee2(@RequestParam String ids, HttpServletRequest request,
			HttpServletResponse response) {
		Cuser cuser = currentUser.getCuser(request, response);
		String username = (cuser == null) ? "" : cuser.getUsername();
		String tranName = "标记拆迁记录为已付款";
		
		JsonObj result = new JsonObj();
		try {

			if (Toolkit.checkUser(cuser, result, null) == false)
				return result;

			int successCount = 0;
			int errorCount = 0;
			String[] split = ids.split(",");
			for (String id : split) {
				if (id.equals(""))
					continue;

				RecordTransitionfee findById = transitionfeeDAO.findRecordTransitionfeeById(Integer.parseInt(id));
				if (findById == null)
					continue;

				if (cuser.getUsertype() < 8 && cuser.getId() * 1 != findById.getCuser().getId()) {
					errorCount++;
					continue;
				}

				findById.setIsDealed(true);
				findById.setDealedTime(Calendar.getInstance());
				transitionfeeDAO.store(findById);

				successCount++;
			}

			String msg = "操作完成，设置记录为付款，成功 " + successCount + " 条";
			if (errorCount > 0)
				msg += "，失败 " + errorCount + " 条";
			msg += "。";

			result.setMessage(msg);
			userOperateLogService.saveUserOperateLog(username, tranName, true, msg);
			return result;
		} catch (Exception e) {
			userOperateLogService.saveUserOperateLog(username, tranName, false, "交易异常失败",e.toString()); 
			result.setMessage("交易失败: " + e);
			return result;
		}
		
		
	}

	/**
	 * 搜索项目名称
	 * 
	 * @param pname
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/searchProject")
	@ResponseBody
	public JsonObj searchProject(@RequestParam String pname, HttpServletRequest request, HttpServletResponse response) {
		JsonObj result = new JsonObj();
		List<Map> rs = new ArrayList<>();
		List<Project> list = recordService.search(pname, 0, 20);
		for (Project project : list) {
			rs.add(JsonObjHelper.project(null, project));
		}

		result.setData(rs);
		return result;
	}

	/**
	 * 拆迁记录详情
	 * 
	 * @param id
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/RecordDetails")
	public ModelAndView viewRecord(Integer id, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		Cuser cuser = currentUser.getCuser(request, response);
		if (Toolkit.checkUser(cuser, null, mav) == false)
			return mav;

		if (cuser.getUsertype() < 8) {
			mav.addObject("message", "无权操作！");
			mav.setViewName("_common/goback.jsp");
			return mav;
		}
		Record entity = recordDAO.findRecordById(id);
		if (entity == null) {
			mav.addObject("message", "查询不存在！");
			mav.setViewName("_common/goback.jsp");
			return mav;
		}

		if (cuser.getUsertype() < 8 && cuser.getId() * 1 != entity.getCuser().getId()) {
			mav.addObject("message", "无权查看！"); // 他人添加的，无权查看
			mav.setViewName("_common/goback.jsp");
			return mav;
		}

		mav.addObject("cuser", cuser);
		mav.addObject("entity", entity);
		mav.addObject("transitionfeeList",
				recordService.listTransitionfee(null, null, id, null, null, null, null, null,null, 0, 1000));
		mav.addObject("returnList", recordService.listReturn(entity.getId()));

		mav.setViewName("_index/viewRecord.jsp");
		return mav;
	}

	@RequestMapping("/recordJson")
	@ResponseBody
	public JsonObj recordJson(Integer id, HttpServletRequest request, HttpServletResponse response) {
		JsonObj result = new JsonObj();
		Cuser cuser = currentUser.getCuser(request, response);
		if (Toolkit.checkUser(cuser, result, null) == false)
			return result;

		Record entity = recordDAO.findRecordById(id);
		if (entity == null) {
			result.setStatus(404);
			return result;
		}

		result.setData(JsonObjHelper.mapBasicProperty(entity));
		return result;
	}

	/**
	 * 增加还房信息
	 * 
	 * @param entity
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/saveRecordReturn2")
	@ResponseBody
	public JsonObj saveRecordReturn(@ModelAttribute RecordReturn entity, HttpServletRequest request,
			HttpServletResponse response) {
		Cuser cuser = currentUser.getCuser(request, response);
		String username = (cuser == null) ? "" : cuser.getUsername();
		String tranName = "增加还房信息";
		
		JsonObj result = new JsonObj();
		try {

			if (Toolkit.checkUser(cuser, result, null) == false)
				return result;

			Record record = recordDAO.findRecordById(entity.getSid());
			if (record == null) {
				result.setStatus(404);
				return result;
			}
			
			/* 
			 * 如果 拟还住宅房面积和拟还营业房面积都没空，提示先设置拟还房，返回错误。
			 * 如果本次还住宅房面积 + 已还住宅房面积 > 拟还住宅房面积，那么提示面积超出。 
			 * 如果本次还营业房面积 + 已还营业面积 > 拟还营业房面积，那么提示面积超出。
			 * 否则，已还房面积=原面积+本次面积。
			 * 
			 * 更新还房记录和原拆迁记录。
			 * 计算未来三个月还房补贴
			 * */
			double thisHouseArea = entity.getHouseArea() == null ? 0 : entity.getHouseArea().doubleValue(); // 本次还住宅房面积 
			double thisBusinessArea = entity.getBusinessArea() == null ? 0 : entity.getBusinessArea().doubleValue(); // 本次还营业房面积 
					
			double houseAreaBack = record.getHouseAreaBack() == null ? 0 : record.getHouseAreaBack().doubleValue(); // 拟已还住宅房总面积
			double businessAreaBack = record.getBusinessAreaBack() == null ? 0 : record.getBusinessAreaBack().doubleValue(); // 拟还商品房总面积
			
			double actualBackHouseArea = record.getActualBackHouseArea() == null ? 0 : record.getActualBackHouseArea().doubleValue(); // 已还住宅房总面积 
			double actualBackBusinessArea = record.getActualBackBusinessArea() == null ? 0 : record.getActualBackBusinessArea().doubleValue(); // 已还商品房总面积
			
			
			if(houseAreaBack == 0 && businessAreaBack == 0){
				result.setStatus(1);
				result.setMessage("请设置拟还房面积");
				userOperateLogService.saveUserOperateLog(username, tranName, false, "请设置拟还房面积"); 
				return result;
			}
			
			if(actualBackHouseArea + thisHouseArea > houseAreaBack){
				result.setStatus(2);
				result.setMessage("还住宅房面积超出拟还住宅房面积");
				userOperateLogService.saveUserOperateLog(username, tranName, false, "还住宅房面积超出拟还住宅房面积");
				return result;
			}
			
			if(actualBackBusinessArea + thisBusinessArea > businessAreaBack){
				result.setStatus(3);
				result.setMessage("还营业房面积超出拟营业房面积");
				userOperateLogService.saveUserOperateLog(username, tranName, false, "还营业房面积超出拟营业房面积");
				return result;
			}
			
			Calendar lastCalTime = recordDAO.inquiryLastCalTime(record.getId());
			if(lastCalTime != null && lastCalTime.compareTo(entity.getReturnTime()) > 0){
				result.setStatus(4);
				result.setMessage("还房时间不能小于上一次过渡费计算时间");
				userOperateLogService.saveUserOperateLog(username, tranName, false, "还房时间不能小于上一次过渡费计算时间"); 
				return result;
			}
			
			if(actualBackHouseArea + thisHouseArea == houseAreaBack && actualBackBusinessArea + thisBusinessArea == businessAreaBack){
				// record.setIsEnd(true);
				result.setData(true);
			}else{
				result.setData(false);
			}
			
			record.setActualBackHouseArea(new BigDecimal(actualBackHouseArea + thisHouseArea));
			record.setActualBackBusinessArea(new BigDecimal(actualBackBusinessArea + thisBusinessArea));
			
			// record.setHouseArea(new BigDecimal(houseAreaBack - (actualBackHouseArea + thisHouseArea)));
			// record.setBusinessArea(new BigDecimal(businessAreaBack - (actualBackBusinessArea + thisBusinessArea)));
			
			entity.setCreatedTime(Calendar.getInstance());
			
			entity.setRemainHouseArea(new BigDecimal(houseAreaBack - (actualBackHouseArea + thisHouseArea)));
			entity.setRemainBusinessArea(new BigDecimal(businessAreaBack - (actualBackBusinessArea + thisBusinessArea)));
			entity.setChannel(0);
			
			returnDAO.store(entity);
			recordDAO.store(record);
			
			userOperateLogService.saveUserOperateLog(username, tranName, true, "还房成功");
			return result;
		} catch (Exception e) {
			userOperateLogService.saveUserOperateLog(username, tranName, false, "交易异常失败",e.toString()); 
			result.setMessage("交易失败: " + e);
			return result;
		}
		
	}

	/**
	 * 过渡费详情
	 * 
	 * @param id
	 * @param request
	 * @param response
	 * @return
	 */
	/*
	 * @RequestMapping("/RecordTransitionfeeDetails") public ModelAndView
	 * viewRecordTransitionfee(Integer id, HttpServletRequest request,
	 * HttpServletResponse response) { ModelAndView mav = new ModelAndView();
	 * Cuser cuser = currentUser.getCuser(request, response);
	 * if(Toolkit.checkUser(cuser, null, mav)==false) return mav;
	 * 
	 * if(cuser.getUsertype()<8){ mav.addObject("message", "无权操作！");
	 * mav.setViewName("_common/goback.jsp"); return mav; } RecordTransitionfee
	 * entity = recordTransitionfeeDAO.findRecordTransitionfeeById(id);
	 * if(entity==null) { mav.addObject("message", "查询不存在！");
	 * mav.setViewName("_common/goback.jsp"); return mav; }
	 * 
	 * if(cuser.getUsertype()<9 && cuser.getId()*1 !=
	 * entity.getCuser().getId()){ mav.addObject("message", "无权查看！");
	 * //他人添加的，无权查看 mav.setViewName("_common/goback.jsp"); return mav; }
	 * 
	 * Record record = null; List<Transitionfee> list = new ArrayList<>();
	 * if(entity.getSid()!=null) { record =
	 * recordDAO.findRecordById(entity.getSid()); list =
	 * recordService.listTransitionfee(null, null, id, null,null, null,null,
	 * null, 0, 1000); }
	 * 
	 * mav.addObject("cuser", cuser); mav.addObject("entity", entity);
	 * mav.addObject("list", list); mav.addObject("record", record);
	 * 
	 * mav.setViewName("_index/viewRecordTransitionfee.jsp"); return mav; }
	 */

	/**
	 * 计算本季度过渡费
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/computeTransitionfee")
	@ResponseBody
	public JsonObj computeTransitionfee(HttpServletRequest request, HttpServletResponse response) {
		Cuser cuser = currentUser.getCuser(request, response);
		String username = (cuser == null) ? "" : cuser.getUsername();
		String tranName = "计算本季度过渡费";
		
		JsonObj result = new JsonObj();
		try {
			if (Toolkit.checkUser(cuser, result, null) == false)
				return result;
			if (cuser.getUsertype() < 8) {
				result.setStatus(403);
				userOperateLogService.saveUserOperateLog(username, tranName, false, "无权限");
				return result;
			}
			Sysconfig config1 = sysconfigDAO.findSysconfigById("admin_record_config");
			if (config1 == null) {
				result.setStatus(-1);
				result.setMessage("请先设置相关参数.");
				userOperateLogService.saveUserOperateLog(username, tranName, false, "请先设置相关参数");
				return result;
			}

			String[] quarter = new String[4];
			JSONObject config = new JSONObject(config1.getValue());
			quarter[0] = ((String) config.get("quarter1")).substring(5);
			quarter[1] = ((String) config.get("quarter2")).substring(5);
			quarter[2] = ((String) config.get("quarter3")).substring(5);
			quarter[3] = ((String) config.get("quarter4")).substring(5);

			String preQuarter = null;
			Calendar now = Calendar.getInstance();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String today = sdf.format(now.getTime());
			
			for (int i = 0; i < 4; i++) {
				if (today.compareTo(quarter[i]) > 0)
					preQuarter = quarter[i];
			}
			if (preQuarter == null)
				preQuarter = quarter[3];
			
//			String lastQuarter = config2.getValue();
//			if (lastQuarter.equals(preQuarter)) {
//				result.setStatus(-1);
//				result.setMessage("本季度的过渡费已经计算过，请到下季度再计算.");
//				userOperateLogService.saveUserOperateLog(username, tranName, false, "本季度的过渡费已经计算过，请到下季度再计算");
//				return result;
//			}
			
			CalcRecordTransitionfeeRequestDTO requestDTO = new CalcRecordTransitionfeeRequestDTO();
			requestDTO.setSysconfig(config1);
			requestDTO.setPreQuarter(preQuarter);
			requestDTO.setCuser(cuser);
			userOperateLogService.saveUserOperateLog(username, tranName, true, result.getMessage());
			
			result = transitionfeeService.calcRecordTransitionfee(requestDTO);
			
			Sysconfig config2 = sysconfigDAO.findSysconfigById("admin_compute_transitionfee_time");
			if (config2 == null || config2.getValue()==null) {
				config2 = new Sysconfig();
				config2.setId("admin_compute_transitionfee_time");
				config2.setDescription("上次计算本季度过渡费时间");
			}
			config2.setValue(today);
			sysconfigDAO.store(config2);
			
			return result;
		} catch (Throwable e) {
			log.error("计算过渡费发生错误:" + CommonsUtil.getStackTrace(e));
			userOperateLogService.saveUserOperateLog(username, tranName, false, "交易异常失败",e.toString()); 
			result.setMessage("交易失败: " + e);
			return result;
		}
		
	}
	
	
	@RequestMapping("/threeMonthFee")
	@ResponseBody
	public JsonObj threeMonthFee(@RequestParam Integer sid, HttpServletRequest request, HttpServletResponse response) {
		Record r = recordDAO.findRecordById(sid);
		JsonObj result = new JsonObj();
		Cuser cuser = currentUser.getCuser(request, response);
		if (Toolkit.checkUser(cuser, result, null) == false)
			return result;

		if (cuser.getUsertype() < 8) {
			result.setStatus(403);
			return result;
		}

		Sysconfig findById = sysconfigDAO.findSysconfigById("admin_record_config");
		if (findById == null) {
			result.setStatus(-1);
			result.setMessage("请先设置相关参数.");
			return result;
		}
		JSONObject config = new JSONObject(findById.getValue());

		Calendar now = Calendar.getInstance();

		double per_house = Double.parseDouble((String) config.get("per_house"));
		double per_business = Double.parseDouble((String) config.get("per_business"));
		int year = now.get(Calendar.YEAR);
		
		
		String[] quarter = new String[4];
		quarter[0] = ((String) config.get("quarter1")).substring(5);
		quarter[1] = ((String) config.get("quarter2")).substring(5);
		quarter[2] = ((String) config.get("quarter3")).substring(5);
		quarter[3] = ((String) config.get("quarter4")).substring(5);

		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
		String today = sdf.format(now.getTime());
		String preQuarter = null;

		for (int i = 0; i < 4; i++) {
			if (today.compareTo(quarter[i]) > 0)
				preQuarter = quarter[i];
		}
		if (preQuarter == null)
			preQuarter = quarter[3];

		int month = Integer.parseInt(preQuarter.split("-")[0]);
		month = (int) ((month - 1) / 3) + 1;
		long nowTime = now.getTime().getTime();
		
		int allDay = (int) ((r.getEndTime().getTime().getTime() - r.getStartTime().getTime().getTime()) / 3600 / 24 / 1000);
		double f = per_house * 1.0 / (per_business == 0 ? 1 : per_business);
		double perHouse = r.getTotal().doubleValue() / allDay / (1 + f);
		double perBusiness = perHouse * f;
		
		long start = r.getLastComputeTime() == null ? r.getStartTime().getTime().getTime()
				: r.getLastComputeTime().getTime().getTime();
		int overDay = (int) ((nowTime - start) * 1.0 / 3600 / 24 / 1000);
		double fee = (perHouse + perBusiness) * 1 * 90;
		double threeMonthFee = 365/4 * ( perHouse * 4 + perBusiness * 12);
		double firstFee = 365/2 * ( perHouse * 4 + perBusiness * 12);
		
		RecordTransitionfee t = new RecordTransitionfee();
		t.setRecord(r);
		t.setCuser(cuser);
		if (r.getLastComputeTime() == null) {
			t.setStartTime(r.getStartTime());
			t.setFirstStartTime(r.getStartTime());
		} else {
			t.setStartTime(r.getLastComputeTime());
			t.setFirstStartTime(r.getLastComputeTime());
		}
		t.setType("补发3个月");
		Calendar c = Calendar.getInstance();
		c.set(Calendar.YEAR, t.getFirstStartTime().get(Calendar.YEAR));
		c.set(Calendar.MONTH, t.getFirstStartTime().get(Calendar.MONTH) + 6);
		c.set(Calendar.DAY_OF_MONTH, t.getFirstStartTime().get(Calendar.DAY_OF_MONTH));
		t.setFirstEndTime(c);
		t.setEndTime(now);
		t.setYear(year);
		t.setQuarter(month);
		t.setFirstFee(r.getTransitionFee());
		t.setFee(new BigDecimal(fee+threeMonthFee));
		t.setThreeMonthFee(new BigDecimal(threeMonthFee));
		t.setQuarterFee(new BigDecimal(fee));
		t.setCreatedTime(now);
		t.setIsDealed(false);
		t.setIsDeleted(false);
		transitionfeeDAO.store(t);
		return result;
	}
	/**
	 * 导入拆迁数据
	 * 
	 * @param path
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/importFile")
	@ResponseBody
	public JsonObj importFile(@RequestParam String path, HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		Cuser cuser = currentUser.getCuser(request, response);
		String cusername = (cuser == null) ? "" : cuser.getUsername();
		String tranName = "导入拆迁数据";
		
		JsonObj result = new JsonObj();
		try {

			if (Toolkit.checkUser(cuser, result, null) == false)
				return result;

			if (cuser.getUsertype() < 8) {
				result.setStatus(403);
				return result;
			}
			String source = request.getSession().getServletContext().getRealPath(path);
			result = adminService.importRecord(path, source, cuser);
			userOperateLogService.saveUserOperateLog(cusername, tranName, true,"交易成功");
			return result;
		} catch (Exception e) {
			userOperateLogService.saveUserOperateLog(cusername, tranName, false, "交易异常失败",e.toString()); 
			result.setMessage("交易失败: " + e);
			return result;
		}
	}
	
	
	/**
	 * 导入还房数据
	 * 
	 * @param path
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/importReturnArea")
	@ResponseBody
	public JsonObj importReturnArea(@RequestParam String path, HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		Cuser cuser = currentUser.getCuser(request, response);
		String cusername = (cuser == null) ? "" : cuser.getUsername();
		String tranName = "导入还房数据";
		
		JsonObj result = new JsonObj();
		try {

			if (Toolkit.checkUser(cuser, result, null) == false)
				return result;

			if (cuser.getUsertype() < 8) {
				result.setStatus(403);
				return result;
			}
			String source = request.getSession().getServletContext().getRealPath(path);
			result = adminService.importReturnArea(path, source, cuser);
			userOperateLogService.saveUserOperateLog(cusername, tranName, true, "交易成功");
			return result;
		
		} catch (Exception e) {
			userOperateLogService.saveUserOperateLog(cusername, tranName, false, "交易异常失败",e.toString()); 
			result.setMessage("交易失败: " + e);
			return result;
		}
		
	}
	
	

	/**
	 * 导入过渡费记录数据
	 * 
	 * @param path
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/importFile2")
	@ResponseBody
	public JsonObj importFile2(@RequestParam String path, HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		Cuser cuser = currentUser.getCuser(request, response);
		String cusername = (cuser == null) ? "" : cuser.getUsername();
		String tranName = "导入过渡费记录";
		
		JsonObj result = new JsonObj();
		try {

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
			if (Toolkit.checkUser(cuser, result, null) == false)
				return result;

			if (cuser.getUsertype() < 8) {
				result.setStatus(403);
				return result;
			}

			String source = request.getSession().getServletContext().getRealPath(path);

			FileInputStream fileIn = new FileInputStream(source);
			//
			// 根据指定的文件输入流导入Excel从而产生Workbook对象
			Workbook wb0 = null;
			if (path.endsWith(".xlsx")) {
				wb0 = new XSSFWorkbook(fileIn);
			} else {
				wb0 = new HSSFWorkbook(fileIn);
			}

			// 获取Excel文档中的第一个表单
			Sheet sht0 = wb0.getSheetAt(0);
			// 对Sheet中的每一行进行迭代

			int ignoreCount = 0;
			int successCount = 0;
			int errorCount = 0;
			for (Row r : sht0) {
				// 如果当前行的行号（从0开始）未达到2（第三行）则从新循环
				if (r.getCell(0) == null || r.getCell(1) == null || r.getCell(3) == null || r.getCell(4) == null
						|| r.getCell(2) == null)
					continue;

				String username = null; // 1
				String address = null; // 18
				String contractNumber = null; // 3
				String recordNumber = null; // 4
				String projectName = null; // 2
				Double facilityFee = 0.0; // 5
				Double transportFee = 0.0; // 6
				Double transitionFee = 0.0; // 7
				Double movingFee = 0.0; // 8
				Double awardFee = 0.0; // 9 | 10
				Double otherFee = 0.0; // 11
				Double selfdemolitionFee = 0.0; // 12
				Double discontinuedFee = 0.0; // 13
				Double total = 0.0; // 14
				String timeRange = null; // 15
				String contact = null; // 16
				String remark = null; // 17

				try {
					double rownum = Double.parseDouble(r.getCell(0).toString());
					username = r.getCell(1).toString().trim();
					contractNumber = r.getCell(3).toString().trim();//
					recordNumber = r.getCell(4).toString().trim();
					projectName = r.getCell(2).toString().trim();
				} catch (Exception e) {
					continue;
				}
				try {
					try {
						address = r.getCell(18).toString();
					} catch (Exception e) {
					}
					try {
						facilityFee = Double.parseDouble(r.getCell(5).toString());
					} catch (Exception e) {
					}
					try {
						transportFee = Double.parseDouble(r.getCell(6).toString());
					} catch (Exception e) {
					}
					try {
						transitionFee = Double.parseDouble(r.getCell(7).toString());
					} catch (Exception e) {
					}
					try {
						movingFee = Double.parseDouble(r.getCell(8).toString());
					} catch (Exception e) {
					}
					try {
						awardFee = Double.parseDouble(r.getCell(9).toString());
					} catch (Exception e) {
					}
					try {
						otherFee = Double.parseDouble(r.getCell(11).toString());
					} catch (Exception e) {
					}
					try {
						selfdemolitionFee = Double.parseDouble(r.getCell(12).toString());
					} catch (Exception e) {
					}
					try {
						discontinuedFee = Double.parseDouble(r.getCell(13).toString());
					} catch (Exception e) {
					}
					try {
						timeRange = r.getCell(15).toString();
					} catch (Exception e) {
					}
					try {
						contact = r.getCell(16).toString();
					} catch (Exception e) {
					}
					try {
						remark = r.getCell(17).toString();
					} catch (Exception e) {
					}

					total = facilityFee * 1 + transportFee + transitionFee + movingFee + awardFee + otherFee
							+ selfdemolitionFee + discontinuedFee;

					Record t = recordService.findByContractNumber(contractNumber);
					if (t == null) {
						ignoreCount++;
						continue;
					}
					Project project = recordService.findOrSaveProjectByName(projectName);

					t.setProject(project);
					t.setUseraddress(address);
					t.setAwardFee(awardFee == null ? null : new BigDecimal(awardFee));
					t.setUsercontact(contact);
					t.setDiscontinuedFee(discontinuedFee == null ? null : new BigDecimal(discontinuedFee));
					t.setFacilityFee(facilityFee == null ? null : new BigDecimal(facilityFee));
					t.setMovingFee(movingFee == null ? null : new BigDecimal(movingFee));
					t.setOtherFee(otherFee == null ? null : new BigDecimal(otherFee));
					t.setRemark(remark + (t.getRemark() == null ? "" : t.getRemark()));
					t.setSelfdemolitionFee(selfdemolitionFee == null ? null : new BigDecimal(selfdemolitionFee));
					t.setTotal(new BigDecimal(total == null ? 0 : total));
					t.setTransitionFee(transitionFee == null ? null : new BigDecimal(transitionFee));
					t.setTransportFee(transportFee == null ? null : new BigDecimal(transportFee));

					Calendar startTime = null;
					Calendar endTime = null;
					if (timeRange != null) {
						String[] split = timeRange.split("-");
						try {
							startTime = Calendar.getInstance();
							startTime.setTime(sdf.parse(split[0]));
						} catch (Exception e) {
						}
						try {
							endTime = Calendar.getInstance();
							endTime.setTime(sdf.parse(split[1]));
						} catch (Exception e) {
						}
						try {
							long diff = (endTime.getTime().getTime() - startTime.getTime().getTime()) / 1000;
							int range = (int) (diff / 3600 / 24);
							t.setPerFee(new BigDecimal(total == null ? 0.0 : total * 1.0 / range));
						} catch (Exception e) {
						}
					}
					t.setStartTime(startTime);
					t.setEndTime(endTime);

					t.setIsDeleted(false);
					t = recordDAO.store(t);

					successCount++;
				} catch (Exception e) {
					log.error(CommonsUtil.getStackTrace(e));
					errorCount++;
				}
			}
			wb0.close();
			fileIn.close();

			String msg = "导入完成，成功导入 " + successCount + " 条";
			if (ignoreCount > 0) {
				msg += "，由于拆迁记录不存在或过渡费重复录入，跳过了 " + ignoreCount + " 条";
			}
			if (errorCount > 0) {
				msg += "，由于格式不正确，出错 " + errorCount + " 条";
			}
			msg += "。";
			result.setMessage(msg);

			userOperateLogService.saveUserOperateLog(cusername, tranName, true, msg);
			return result;
		
		} catch (Exception e) {
			userOperateLogService.saveUserOperateLog(cusername, tranName, false, "交易异常失败",e.toString()); 
			result.setMessage("交易失败: " + e);
			return result;
		}
		
	}

	/**
	 * 导出基本拆迁信息
	 * 
	 * @param keyword
	 * @param uid
	 * @param pid
	 * @param type
	 * @param ids
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/Export1")
	public void exportFile1(@RequestParam(value = "status", required = false) Integer status,
			@RequestParam(value = "started", required = false) Boolean started,
			@RequestParam(value = "ended", required = false) Boolean ended,
			@RequestParam(value = "keyword", required = false) String keyword,
			@RequestParam(value = "uid", required = false) Integer uid,
			@RequestParam(value = "pid", required = false) Integer pid,
			@RequestParam(value = "pauseCalculateFee", required = false) Boolean pauseCalculateFee,
			@RequestParam(value = "replaceFlag", required = false) Integer replaceFlag, @RequestParam Integer type,
			@RequestParam(value = "ids", required = false) String ids, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		
		Cuser cuser = currentUser.getCuser(request, response);
		String username = (cuser == null) ? "" : cuser.getUsername();
		String tranName = "导出基本拆迁信息";
		
		JsonObj result = new JsonObj();
		try {
			if (Toolkit.checkUser(cuser, result, null) == false)
				return;

			if (cuser.getUsertype() < 8) {
				uid = cuser.getId();
			}

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日HH时mm分");
			List<Record> list = new ArrayList<>();
			if (type == 1) {
				String[] split = ids.split(",");
				for (String id : split) {
					Record fbi = recordDAO.findRecordById(Integer.parseInt(id));
					if (fbi != null && (fbi.getIsDeleted() == null || fbi.getIsDeleted() == false)) {
						list.add(fbi);
					}
				}
			} else if (type == 2) {
				int totalcount = recordService.countRecord(uid, pid, keyword, status, replaceFlag, started, ended,pauseCalculateFee);
				Pager pager = new Pager(request, totalcount);
				list = recordService.listRecord(uid, pid, keyword, status, replaceFlag, started, ended, pauseCalculateFee,pager.offset,
						pager.ps, null);
			} else if (type == 3) {
				list = recordService.listRecord(uid, pid, keyword, status, replaceFlag, started, ended,pauseCalculateFee, 0, Integer.MAX_VALUE, null);// 65536
			}

			String source = request.getSession().getServletContext().getRealPath("/source/tpl1.xls");
			FileInputStream fileIn = new FileInputStream(source);
			HSSFWorkbook workbook = new HSSFWorkbook(fileIn);

			HSSFSheet sheet = workbook.getSheetAt(0);
			// sheet.createFreezePane(0, 3);
			HSSFRow tpl = sheet.getRow(5);
			sheet.removeRow(tpl);
			int rowIndex = 5;

			for (Record record : list) {
				HSSFRow row = sheet.createRow(rowIndex);

				double houseArea = record.getHouseArea() == null ? 0 : record.getHouseArea().doubleValue();
				double houseAreaBack = record.getHouseAreaBack() == null ? 0 : record.getHouseAreaBack().doubleValue();
				double businessArea = record.getBusinessArea() == null ? 0 : record.getBusinessArea().doubleValue();
				double businessAreaBack = record.getBusinessAreaBack() == null ? 0
						: record.getBusinessAreaBack().doubleValue();
				double replaceHouseArea = record.getReplaceHouseArea() == null ? 0
						: record.getReplaceHouseArea().doubleValue();
				double replaceBusinessArea = record.getReplaceBusinessArea() == null ? 0
						: record.getReplaceBusinessArea().doubleValue();
				double replaceAreaTotal = record.getReplaceAreaTotal() == null ? 0
						: record.getReplaceAreaTotal().doubleValue();

				row.createCell(0).setCellValue(rowIndex - 4);
				row.createCell(1).setCellValue(record.getUsername());
				row.createCell(2).setCellValue(record.getUseraddress());
				row.createCell(3).setCellValue(record.getContractNumber());
				row.createCell(4).setCellValue(record.getRecordNumber());
				row.createCell(5).setCellValue(record.getProjectName());
				row.createCell(6).setCellValue(
						record.getCoveredArea() == null ? houseArea + businessArea : record.getCoveredArea().doubleValue());
				row.createCell(7).setCellValue(houseArea > 0 ? houseArea + "" : "");
				row.createCell(8).setCellValue(businessArea > 0 ? businessArea + "" : "");
				row.createCell(9).setCellValue(record.getProductionArea());
				row.createCell(10).setCellValue(replaceHouseArea > 0 ? replaceHouseArea + "" : "");
				row.createCell(11).setCellValue(replaceBusinessArea > 0 ? replaceBusinessArea + "" : "");
				row.createCell(12).setCellValue(replaceAreaTotal > 0 ? replaceAreaTotal + "" : "");

				row.createCell(13).setCellValue(houseAreaBack > 0 ? houseAreaBack + "" : "");
				row.createCell(14).setCellValue(record.getHouseAreaBackRoom());
				row.createCell(15).setCellValue(houseAreaBack - houseArea);
				row.createCell(16).setCellValue("");
				row.createCell(17).setCellValue(businessAreaBack > 0 ? businessAreaBack + "" : "");
				row.createCell(18).setCellValue(record.getBusinessAreaBackRoom());
				row.createCell(19).setCellValue(businessAreaBack - businessArea);
				row.createCell(20).setCellValue("");
				row.createCell(21)
						.setCellValue(record.getBalance1() == null ? "" : record.getBalance1().doubleValue() + "");
				row.createCell(22)
						.setCellValue(record.getBalance2() == null ? "" : record.getBalance2().doubleValue() + "");
				row.createCell(23).setCellValue(record.getRemark());
				row.createCell(24).setCellValue(record.getSelfRemoveArea());
				row.createCell(25).setCellValue(record.getSelfSimplyArea());
				row.createCell(26).setCellValue(record.getSelfRemoveAmount());

				for (int i = 0; i < 26; i++)
					row.getCell(i).setCellStyle(tpl.getCell(i).getCellStyle());
				if (tpl.getRowStyle() != null)
					row.setRowStyle(tpl.getRowStyle());
				row.setHeight(tpl.getHeight());
				rowIndex++;
			}
			HSSFRow row = sheet.getRow(0);
			String header = "房屋拆迁补偿安置情况统计汇总表";
			if (started != null) {
				if (started == true)
					header += "(已交房)";
				else
					header += "(未交房)";
			}
			if (ended != null) {
				if (ended == true)
					header += "(已还房)";
				else
					header += "(未还房)";
			}
			if (status != null) {
				if (status == 1)
					header += "(合同未开始)";
				else if (status == 2)
					header += "(合同进行中)";
				else if (status == 3)
					header += "(合同已到期)";
			}
			String pname = "******";
			if (pid != null) {
				Project project = projectDAO.findProjectById(pid);
				if (project != null)
					pname = project.getName();
			}
			row.getCell(0).setCellValue(pname + header);

			String title = java.net.URLEncoder.encode("拆迁数据导出_" + sdf.format(Calendar.getInstance().getTime()), "UTF-8");
			OutputStream out = response.getOutputStream();
			response.setHeader("Content-disposition", "attachment;filename=" + title + ".xls");
			workbook.write(out);
			out.flush();
			out.close();
			workbook.close();
			userOperateLogService.saveUserOperateLog(username, tranName, true, "交易成功");		
		} catch (Exception e) {
			userOperateLogService.saveUserOperateLog(username, tranName, false, "交易异常失败",e.toString()); 
			throw e;
		}
		
	}

	/**
	 * 导出过渡费申请记录
	 * 
	 * @param keyword
	 * @param uid
	 * @param pname
	 * @param type
	 * @param ids
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/Export2")
	public void exportFile2(@RequestParam(value = "keyword", required = false) String keyword,
			@RequestParam(value = "uid", required = false) Integer uid,
			@RequestParam(value = "pid", required = false) Integer pid,
			@RequestParam(value = "pauseCalculateFee", required = false) Boolean pauseCalculateFee,
			@RequestParam(value = "replaceFlag", required = false) Integer replaceFlag, @RequestParam Integer type,
			@RequestParam(value = "ids", required = false) String ids, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		
		Cuser cuser = currentUser.getCuser(request, response);
		String username = (cuser == null) ? "" : cuser.getUsername();
		String tranName = "导出过渡费申请记录";
		
		JsonObj result = new JsonObj();
		try {
			if (Toolkit.checkUser(cuser, result, null) == false)
				return;

			String nickname = "******";
			if (cuser.getUsertype() < 8) {
				uid = cuser.getId();
			}
			if (uid != null) {
				nickname = cuser.getNickname();
			}

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日HH时mm分");
			SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy.MM.dd");
			List<Record> list = new ArrayList<>();
			if (type == 1) {
				String[] split = ids.split(",");
				for (String id : split) {
					Record fbi = recordDAO.findRecordById(Integer.parseInt(id));
					if (fbi != null && (fbi.getIsDeleted() == null || fbi.getIsDeleted() == false)) {
						list.add(fbi);
					}
				}
			} else if (type == 2) {
				int totalcount = recordService.countRecord(uid, pid, keyword, null, replaceFlag, null, null,pauseCalculateFee);
				Pager pager = new Pager(request, totalcount);
				list = recordService.listRecord(uid, pid, keyword, null, replaceFlag, null, null,pauseCalculateFee, pager.offset, pager.ps, null);
			} else if (type == 3) {
				list = recordService.listRecord(uid, pid, keyword, null, replaceFlag, null, null,pauseCalculateFee, 0, Integer.MAX_VALUE, null);// 65536
			}

			String source = request.getSession().getServletContext().getRealPath("/source/tpl2.xls");
			FileInputStream fileIn = new FileInputStream(source);
			HSSFWorkbook workbook = new HSSFWorkbook(fileIn);

			HSSFSheet sheet = workbook.getSheetAt(0);
			// sheet.createFreezePane(0, 3);

			HSSFRow tpl = sheet.getRow(4);
			sheet.removeRow(tpl);
			int rowIndex = 4;

			for (Record record : list) {
				HSSFRow row = sheet.createRow(rowIndex);

				double otherFee = record.getOtherFee() == null ? 0 : record.getOtherFee().doubleValue();
				double sefFee = record.getSelfdemolitionFee() == null ? 0 : record.getSelfdemolitionFee().doubleValue();
				double disFee = record.getDiscontinuedFee() == null ? 0 : record.getDiscontinuedFee().doubleValue();
				double total0 = otherFee + sefFee + disFee;

				row.createCell(0).setCellValue(rowIndex - 3);
				row.createCell(1).setCellValue(record.getUsername());
				row.createCell(2).setCellValue(record.getProjectName());
				row.createCell(3).setCellValue(record.getContractNumber());
				row.createCell(4).setCellValue(record.getRecordNumber());

				row.createCell(5).setCellType(HSSFCell.CELL_TYPE_NUMERIC);
				if (record.getFacilityFee() != null)
					row.getCell(5).setCellValue(record.getFacilityFee().doubleValue());

				row.createCell(6).setCellType(HSSFCell.CELL_TYPE_NUMERIC);
				if (record.getTransportFee() != null)
					row.getCell(6).setCellValue(record.getTransportFee().doubleValue());

				row.createCell(7).setCellType(HSSFCell.CELL_TYPE_NUMERIC);
				if (record.getTransitionFee() != null)
					row.getCell(7).setCellValue(record.getTransitionFee().doubleValue());

				row.createCell(8).setCellType(HSSFCell.CELL_TYPE_NUMERIC);
				if (record.getMovingFee() != null)
					row.getCell(8).setCellValue(record.getMovingFee().doubleValue());

				row.createCell(9).setCellType(HSSFCell.CELL_TYPE_NUMERIC);
				if (record.getAwardFee() != null)
					row.getCell(9).setCellValue(record.getAwardFee().doubleValue());

				row.createCell(10).setCellType(HSSFCell.CELL_TYPE_NUMERIC);
				if (total0 > 0)
					row.getCell(10).setCellValue(total0);

				row.createCell(11).setCellType(HSSFCell.CELL_TYPE_NUMERIC);
				if (otherFee > 0)
					row.getCell(11).setCellValue(otherFee);

				row.createCell(12).setCellType(HSSFCell.CELL_TYPE_NUMERIC);
				if (sefFee > 0)
					row.getCell(12).setCellValue(sefFee);

				row.createCell(13).setCellType(HSSFCell.CELL_TYPE_NUMERIC);
				if (disFee > 0)
					row.getCell(13).setCellValue(disFee);

				row.createCell(14).setCellType(HSSFCell.CELL_TYPE_NUMERIC);
				if (record.getTotal() != null)
					row.getCell(14).setCellValue(record.getTotal().doubleValue());

				row.createCell(15)
						.setCellValue((record.getStartTime() == null ? "" : sdf2.format(record.getStartTime().getTime()))
								+ "-" + (record.getEndTime() == null ? "" : sdf2.format(record.getEndTime().getTime())));
				row.createCell(16).setCellValue(record.getUsercontact());
				row.createCell(17).setCellValue(record.getRemark());
				row.createCell(18).setCellValue(record.getUseraddress());

				for (int i = 0; i < 19; i++)
					row.getCell(i).setCellStyle(tpl.getCell(i).getCellStyle());
				if (tpl.getRowStyle() != null)
					row.setRowStyle(tpl.getRowStyle());
				row.setHeight(tpl.getHeight());
				rowIndex++;
			}

			HSSFRow row0 = sheet.createRow(rowIndex);
			row0.createCell(0).setCellValue("合计");
			for (int i = 1; i < 5; i++)
				row0.createCell(i).setCellValue("");
			String rowmap = "FGHIJKLMNO";
			for (int i = 0; i < 10; i++) {
				row0.createCell(i + 5).setCellType(XSSFCell.CELL_TYPE_FORMULA);
				if (rowIndex > 4)
					row0.getCell(i + 5)
							.setCellFormula("SUM(" + rowmap.charAt(i) + "5:" + rowmap.charAt(i) + (rowIndex) + ")");
			}
			for (int i = 15; i < 19; i++)
				row0.createCell(i).setCellValue("");
			for (int i = 0; i < 19; i++)
				row0.getCell(i).setCellStyle(tpl.getCell(14).getCellStyle());
			row0.setHeight((short) 400);

			for (int i = 4; i < rowIndex; i++) {
				HSSFRow row = sheet.getRow(i);
				for (int j = 5; j < 15; j++) {
					HSSFCell cell = row.getCell(j);
					if (cell.getNumericCellValue() == 0)
						cell.setCellValue("");
				}
			}

			sheet.addMergedRegion(new CellRangeAddress(rowIndex, rowIndex, 0, 4));

			Calendar now = Calendar.getInstance();
			HSSFRow row2 = sheet.getRow(1);
			row2.getCell(0).setCellValue("填报单位：" + nickname);
			row2.getCell(11).setCellValue("制表时间： " + sdf.format(now.getTime()));

			String header = "房屋征收安置补偿、过渡费领取申请表";
			HSSFRow row = sheet.getRow(0);
			if (pid != null) {
				Project project = projectDAO.findProjectById(pid);
				row.getCell(0).setCellValue((project == null ? "******" : project.getName()) + header);
			} else {
				row.getCell(0).setCellValue("******" + header);
			}
			String title = java.net.URLEncoder.encode("安置补偿过渡费记录导出_" + sdf.format(now.getTime()), "UTF-8");
			OutputStream out = response.getOutputStream();
			response.setHeader("Content-disposition", "attachment;filename=" + title + ".xls");
			workbook.write(out);
			out.flush();
			out.close();
			workbook.close();
			userOperateLogService.saveUserOperateLog(username, tranName, true, "交易成功");		
		} catch (Exception e) {
			userOperateLogService.saveUserOperateLog(username, tranName, false, "交易异常失败",e.toString()); 
			result.setMessage("交易失败: " + e);
			throw e;
		}
		
		
		
	}

	/**
	 * 导出本季度过渡费
	 * 
	 * @param keyword
	 * @param uid
	 * @param year
	 * @param quarter
	 * @param pname
	 * @param dealed
	 * @param type
	 * @param ids
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/Export3")
	@ResponseBody
	public JsonObj exportFile3(@RequestParam(value = "feetype", required = false) String feetype,
			@RequestParam(value = "keyword", required = false) String keyword,
			@RequestParam(value = "uid", required = false) Integer uid,
			@RequestParam(value = "year", required = false) Integer year,
			@RequestParam(value = "quarter", required = false) Integer quarter,
			@RequestParam(value = "serviceDepartment", required = false) String serviceDepartment,
			@RequestParam(value = "pname", required = false) String pname,
			@RequestParam(value = "dealed", required = false) Boolean dealed, @RequestParam Integer type,
			@RequestParam(value = "ids", required = false) String ids,
			@RequestParam(value = "is_export_async_and_group_by_project", required = false) Boolean isExportAsyncAndGroupByProject,
			HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		
		Cuser cuser = currentUser.getCuser(request, response);
		String username = (cuser == null) ? "" : cuser.getUsername();
		String tranName = "导出本季度过渡费";
		
		JsonObj result = new JsonObj();
		try {
			if (Toolkit.checkUser(cuser, result, null) == false){
				result.setData(false);
				result.setStatus(-1);
				result.setMessage("请先登录");
				return result;
			}

			String nickname = "******";
			Calendar now = Calendar.getInstance();
			if (cuser.getUsertype() < 8) {
				uid = cuser.getId();
			}
			if (uid != null) {
				nickname = cuser.getNickname();
			}
			if (quarter == null) {
				// quarter = (now.get(Calendar.MONTH) / 3 + 1);
			}
			if (year == null) {
				// year = now.get(Calendar.YEAR);
			}

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日HH时mm分");
			SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
			List<RecordTransitionfee> list = new ArrayList<>();
			if (type == 1) {
				list = recordService.findTransitionfeeByIds(ids);
				/*String[] split = ids.split(",");
				for (String id : split) {
					RecordTransitionfee fbi = transitionfeeDAO.findRecordTransitionfeeById(Integer.parseInt(id));
					if (fbi != null && (fbi.getIsDeleted() == null || fbi.getIsDeleted() == false)) {
						list.add(fbi);
					}
				}*/
			} else if (type == 2) {
				int totalcount = recordService.countTransitionfee(keyword, uid, null, pname, feetype, dealed, year,
						quarter,serviceDepartment);
				Pager pager = new Pager(request, totalcount);
				list = recordService.listTransitionfee(keyword, uid, null, pname, feetype, dealed, year, quarter,serviceDepartment,
						pager.offset, pager.ps);
			} else if (type == 3) {
				list = recordService.listTransitionfee(keyword, uid, null, pname, feetype, dealed, year, quarter,serviceDepartment, 0,
						Integer.MAX_VALUE);// 65536
			}
			String source = request.getSession().getServletContext().getRealPath("/source/tpl3.xls");
			/**
			 *   如果isExportAsyncAndGroupByProject=false，则还是走以前的模式。直接导完，然后返回
			 *   如果isExportAsyncAndGroupByProject=true，则直接返回。然后生成过渡费文件，按组分类，然后返回成功
			 */
			if(isExportAsyncAndGroupByProject == null || isExportAsyncAndGroupByProject == false){
				HSSFWorkbook workbook = adminService.createTransitionfeeExportExcel(list, source, nickname, year, quarter, pname, feetype, dealed);
				String title = java.net.URLEncoder.encode("季度过渡费记录导出_" + sdf.format(now.getTime()), "UTF-8");
				OutputStream out = response.getOutputStream();
				response.setHeader("Content-disposition", "attachment; filename=" + title + ".xls");
				// response.setHeader("Content-disposition", "attachment; filename=details.xls");  
				 response.setContentType("application/msexcel");  
				workbook.write(out);
				out.flush();
				out.close();
				workbook.close();
				userOperateLogService.saveUserOperateLog(username, tranName, true, "交易成功");
				result.setStatus(0);
				result.setData(true);
				result.setMessage("导出成功");
				return result;
			}else{
				List<RecordTransitionfee> exportList = new ArrayList<RecordTransitionfee>();
				String lastProjectName = list.get(0).getRecord().getProjectName();
				exportList.add(list.get(0));
				String relocationTransitionFeeExportDir = PropertiesUtil.getProperty("relocationLogDir",null) + File.separator + "季度过渡费记录导出" + File.separator + DateFormatUtils.format(now, "yyyyMMddHHmmss");
				File projectDir = new File(relocationTransitionFeeExportDir);
				projectDir.mkdirs();
				int c = 0;
				for (RecordTransitionfee recordTransitionfee : list) {
					c++;
					if(!lastProjectName.equals(recordTransitionfee.getRecord().getProjectName())){
						CreateTransitionfeeExportExcelThread createTransitionfeeExportExcelThread = new CreateTransitionfeeExportExcelThread(exportList,relocationTransitionFeeExportDir,
								source,nickname,year,quarter, 
								feetype,dealed,lastProjectName);
						Thread t = new Thread(createTransitionfeeExportExcelThread);
						t.start();
						exportList = new ArrayList<RecordTransitionfee>();
					}
					if(c != 1){
						exportList.add(recordTransitionfee);
						lastProjectName = recordTransitionfee.getRecord().getProjectName();
					}
				}
				if(exportList.size() != 0){
					CreateTransitionfeeExportExcelThread createTransitionfeeExportExcelThread = new CreateTransitionfeeExportExcelThread(exportList,relocationTransitionFeeExportDir,
							source,nickname,year,quarter, 
							feetype,dealed,lastProjectName);
					Thread t = new Thread(createTransitionfeeExportExcelThread);
					t.start();
				}
				result.setStatus(0);
				result.setData(true);
				result.setMessage("文件导出已经提交，请稍后到"+ relocationTransitionFeeExportDir + "目录查看过渡费文件");
				return result;
			}
			
		} catch (Exception e) {
			userOperateLogService.saveUserOperateLog(username, tranName, false, "交易异常失败",e.toString()); 
			throw e;
		}
		
		
	}
	/**
	 * 创建过渡费线程
	 * @date 2017-04-16
	 * @author liangcz
	 *
	 */
	class CreateTransitionfeeExportExcelThread implements Runnable{
		String relocationTransitionFeeExportDir;
		List<RecordTransitionfee> exportList;
		String nickname;
		Integer year;
		Integer quarter;
		String feetype;
		Boolean dealed;
		String projectName;
		String source;
		public CreateTransitionfeeExportExcelThread(List<RecordTransitionfee> exportList,String relocationTransitionFeeExportDir,
				String source,String nickname, Integer year, Integer quarter,
				String feetype, Boolean dealed,String projectName){
			this.exportList = exportList;
			this.relocationTransitionFeeExportDir = relocationTransitionFeeExportDir;
			this.source = source;
			this.nickname = nickname;
			this.year = year;
			this.quarter = quarter;
			this.projectName = projectName;
		}
		@Override
		public void run() {
			try {
				/* 生成过渡费文件，并放到指定目录 */
				HSSFWorkbook workbook = adminService.createTransitionfeeExportExcel(exportList, source, nickname, year, quarter, projectName, feetype, dealed);
				String fileName = relocationTransitionFeeExportDir + File.separator + (year + "年" + quarter + "季度" + projectName + "过渡费" +".xls");
				File file = new File(fileName);
				OutputStream out = new FileOutputStream(file);
				workbook.write(out);
				out.close();
				workbook.close();
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
		
	}
	/**
	 * BigDecimal 转成double
	 * @param bigDecimal
	 * @return
	 */
	private double getDoubleValue(BigDecimal bigDecimal){
		if(bigDecimal == null){
			return 0;
		}
		return bigDecimal.doubleValue();
	}

	@RequestMapping({ "/getCurrentUser" })
	@ResponseBody
	public String getCurrentUser(@ModelAttribute Record entity, HttpServletRequest request,
			HttpServletResponse response) {
		JsonObj result = new JsonObj();
		Cuser cuser = this.currentUser.getCuser(request, response);
		if (!(Toolkit.checkUser(cuser, result, null))) {
			return "nologin";
		}

		String authorityGroup = cuser.getAuthorityGroup();
		System.out.println(authorityGroup + "\t*****************");
	/*	if (StringUtils.isNotBlank(authorityGroup)) {
			List list = Arrays.asList(authorityGroup.split(","));
			if (list.contains("基础信息"))
				return "admin";
			if (list.contains("过渡费管理"))
				return "admin2";
			if (list.contains("账号信息")) {
				return "admin3";
			}
			return "";
		}*/

		return "";
	}
	
	/**
	 * 检查用户是否享受过100平米优惠
	 * @param request
	 * @param response
	 * @param useridcard  身份证号码
	 * @return
	 */
	@RequestMapping({ "/checkIfHadAreaBenefit100" })
	@ResponseBody
	public JsonObj checkIfHadAreaBenefit100(HttpServletRequest request,
			HttpServletResponse response,@RequestParam(value = "useridcard", required = true) String useridcard) {
		Cuser cuser = this.currentUser.getCuser(request, response);
		JsonObj result = new JsonObj();
		if (Toolkit.checkUser(cuser, result, null) == false)
			return result;
		Set<Record> set = recordDAO.checkIfHadAreaBenefit100(useridcard);
		result.setData(set.size());
		return result;
	}

	@InitBinder
	public void initBinder(WebDataBinder binder, HttpServletRequest request) { // Register
																				// static
																				// property
																				// editors.
		binder.registerCustomEditor(java.util.Calendar.class,
				new org.skyway.spring.util.databinding.CustomCalendarEditor("yyyy-MM-dd"));
		binder.registerCustomEditor(byte[].class,
				new org.springframework.web.multipart.support.ByteArrayMultipartFileEditor());
		binder.registerCustomEditor(boolean.class, new org.skyway.spring.util.databinding.EnhancedBooleanEditor(false));
		binder.registerCustomEditor(Boolean.class, new org.skyway.spring.util.databinding.EnhancedBooleanEditor(true));
		binder.registerCustomEditor(java.math.BigDecimal.class,
				new org.skyway.spring.util.databinding.NaNHandlingNumberEditor(java.math.BigDecimal.class, true));
		binder.registerCustomEditor(Integer.class,
				new org.skyway.spring.util.databinding.NaNHandlingNumberEditor(Integer.class, true));
		binder.registerCustomEditor(java.util.Date.class, new org.skyway.spring.util.databinding.CustomDateEditor());
		binder.registerCustomEditor(String.class, new org.skyway.spring.util.databinding.StringEditor());
		binder.registerCustomEditor(Long.class,
				new org.skyway.spring.util.databinding.NaNHandlingNumberEditor(Long.class, true));
		binder.registerCustomEditor(Double.class,
				new org.skyway.spring.util.databinding.NaNHandlingNumberEditor(Double.class, true));
	}
	
}
