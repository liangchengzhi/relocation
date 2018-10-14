/*********************************************************************/
/**公共函数，需要Jquery、uikit支持
/*********************************************************************/

var web_site_domain = "http://www.jimao12.com/";
var web_app_root = "";

$(function(){
	if($.fn.datepicker && $.fn.datepicker.dates){
		$.fn.datepicker.dates['en'] = {
		    days: ["星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六", "星期日"],
		    daysShort: ["Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"],
		    monthsShort: ['一月','二月','三月','四月','五月','六月','七月','八月','九月','十月','十一月','十二月'],
		    today: "今天",
	    	months: ['一月','二月','三月','四月','五月','六月','七月','八月','九月','十月','十一月','十二月'],
	    	daysMin: ['日','一','二','三','四','五','六']
		};
	}
	$('.goBackBtn').click(function(){
		var referer = $('input[name="referer"]');
		if(referer.length>0&&referer.val()!='')	window.location.href = referer.val();
		else history.back(-1);
    });
	
	//全选
    $('.checkAll').click(function(){
        if($(this).is(':checked') || !$(this).hasClass('HasChecked')){
        	$(this).addClass('HasChecked');
            $('input[type="checkbox"][name="checkAll"]:not(:disabled)').prop('checked',true).parent('span').addClass('checked');
        }else{
        	$(this).removeClass('HasChecked');
            $('input[type="checkbox"][name="checkAll"]:not(:disabled)').prop('checked',false).parent('span').removeClass('checked');
        }
    });
    
    //工具提示
    $('[tooltip-title]').tooltip({title:function(){return $(this).attr('tooltip-title')},placement:'top'});
    
    //后台导航菜单展开
    if($('[nav-menu]').length>0){
    	$('ul.page-sidebar-menu>li').removeClass('start').removeClass('open').removeClass('active')
    		.find('li,.arrow').removeClass('active').removeClass('open');
    	$('.'+$('[nav-menu]:last').attr('nav-menu')).addClass('active')
    		.parent('ul.sub-menu').parent('li').addClass('active').addClass('open')
    		.children('a:first').find('.arrow').addClass('open');
    }
    
    //前台导航
    if($('[home-nav]').length>0){
    	$('.navbar ul.nav>li').removeClass('active');
    	$('.navbar ul.nav>li.'+$('[home-nav]').attr('home-nav')).addClass('active');
    }
    //关键字高亮
    highlight('input[name="keyword"]','.hlight');
    $('input[name="keyword"]').bind('keyup change', function(ev) {
    	highlight(this,'.hlight');
    }).focus();
    
    //加载广告图片
    $('img[load-img]').each(function(){
		var _this = $(this);
		var attr = _this.attr('load-img').toJSON();
		$.post("./getSysConfig?ajaxtag=1",{id:attr['key']},function(d){
			_this.attr('src',d.data);
		});
		
	});
});

/**
 * 加载区县代码
 */
var citycodeList = {};
function citycode(pcode, obj, defaultSelect,callback){
	if(citycodeList[pcode]){
		$(obj).html(citycodeList[pcode]);
		if(defaultSelect){
			$(obj).find('option').removeAttr('selected');
			$(obj).find('option[value="'+defaultSelect+'"]').attr('selected','selected');
		}
		if(callback){
			callback.call();
		}
	}else{
		$.get("./Citycode?ajaxtag=1",{parent:pcode},function(resp){
			var s = "";
			resp.data.forEach(function(d){
				s += '<option value="'+d.qxdm+'">'+d.qxmc+'</option>';
			});
			citycodeList[pcode] = s;
			$(obj).html(citycodeList[pcode]);
			if(defaultSelect){
				$(obj).find('option').removeAttr('selected');
				$(obj).find('option[value="'+defaultSelect+'"]').attr('selected','selected');
			}
			if(callback){
				callback.call();
			}
		});
	}
}


/**
 * 操作Cookie
 */
function setCookie(name,value,minutes){
    var exp = new Date();
    exp.setTime(exp.getTime() + minutes*60*1000);
    document.cookie = name + "="+ escape (value) + ";expires=" + exp.toGMTString();
}
function getCookie(name){
    var arr,reg=new RegExp("(^| )"+name+"=([^;]*)(;|$)");
    if(arr=document.cookie.match(reg)) return (arr[2]);
    
    else return null;
}
function delCookie(name){
    var exp = new Date();
    exp.setTime(exp.getTime() - 1);
    var cval=getCookie(name);
    document.cookie= name + "=;expires="+exp.toGMTString();
}

/**
 * 遍历对象属性
 */
function whatInObj(obj){
	var s="";for(i in obj)s+=i+":"+obj[i]+"\n";alert(s);
}

/**
 * 检测ajax成功请求后返回信息
 * @param resp
 * @param object
 * @returns {Boolean}
 */
var _responseMessages = {
		"-1"	: "请求无效！",
		"1"		: "手机号已存在！",
		"2"		: "手机号不存在！",
		"3"		: "邮箱已存在！",
		"4"		: "邮箱不存在！",
		"5"		: "用户名已存在！",
		"6"		: "用户名不存在！",
		"7"		: "手机验证码错误！",
		"8"		: "未发送手机验证码！",
		"9"		: "已添加过！",
		"10"	: "表单信息不完整！",
		"11"	: "评论太频繁！",
		"110"	: "用户名或密码错误！",
		"119"	: "用户名注册未激活！",
		"120"	: "用户名被限制登录！",
		"400"	: "访问信息已存在！",
		"401"	: "未登录！",
		"402"	: "访问对象无效！",
		"403"	: "无权访问！",
		"404"	: "对象不存在！",
		"405"	: "数据未改变！",
		"406"	: "初始密码不安全，请重设密码！",
		"407"	: "用户信息不完善，请补充！",
		"800"	: "库存不足！",
		"801"	: "购物车为空！"
};
function checkResponse(resp){
	if(resp.status==0) return true;
	var message = "";
	if(resp.message){
		message = resp.message;
	}else if(_responseMessages[resp.status+""]){
		message = _responseMessages[resp.status+""];
	}
	if(message!=""){
		shakeMsg(message);
	}
	return false;
}
/**
-110 同一手机号每日发送已达到5条
-120 同一IP地址每日发送已达到10条
-1	没有该用户账户
-2	接口密钥不正确 [查看密钥] 不是账户登陆密码
-21	MD5接口密钥加密不正确
-3	短信数量不足
-11	该用户被禁用
-14	短信内容出现非法字符
-4	手机号格式不正确
-41	手机号码为空
-42	短信内容为空
-51	短信签名格式不正确 接口签名格式为：【签名内容】
-6	IP限制 
>0	短信发送数量
 * 
 * 检测手机短信发送结果
 * @param resp
 * @returns {Boolean}
 */
var _responseSmsMessages = {
		"-110"	: "同一手机号每日发送已达到5条！",
		"-120"	: "同一IP地址每日发送已达到10条！",
		"-1"	: "没有该用户账户！",
		"-11"	: "该用户被禁用！",
		"-4"	: "手机号格式不正确！",
		"-6"	: "IP地址被限制！"
};
function checkSmsResult(resp){
	if(checkResponse(resp)==false) return false;
	
	if(resp.data * 1 < 0){
		shakeMsg(_responseSmsMessages[""+resp.data]);
		return false;
	}else{
		return true;
	}
}

/**
 * 显示提示消息
 * @param msg
 * @param title
 */
function showMsg(msg,title, callback){
	var t = '提示：';
	if(title){t = title;}
	var notice = $.gritter.add({
        title: t,
        text: msg,
        image: 'images/notice.png',
        sticky: true,
        time: ''
    });
	
	if(callback){
		setTimeout(function(){
			$.gritter.remove(notice, {
	            fade: true,
	            speed: 'slow'
	        });
			callback();
		},1500);
	}else{
		setTimeout(function(){
			$.gritter.remove(notice, {
	            fade: true,
	            speed: 'slow'
	        });
		},5000);
	}
}
function shakeMsg(msg, title){
	var t = '提示：';
	if(title){t = title;}
	var notice = $.gritter.add({
        title: t,
        text: msg,
        image: 'images/notice.png',
        sticky: true,
        class_name: 'gritter-error' + ($('#gritter-light') && $('#gritter-light').get(0) && !$('#gritter-light').get(0).checked ? ' gritter-light' : ''),
        //fade_in_speed:'fast',
        time: '2000'
    });
	shake($('#gritter-notice-wrapper>div:last'));
	setTimeout(function(){
		$.gritter.remove(notice, {
            fade: true,
            speed: 'slow'
        });
	},5000);
}

/**
 * 获取当前连接中的参数
 * @param name
 * @returns
 */
function getQueryString(name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
	var r = window.location.search.substr(1).match(reg);
	if (r != null) return unescape(r[2]); return null;
}

String.prototype.replaceAll = function(reallyDo, replaceWith, ignoreCase) {  
    if (!RegExp.prototype.isPrototypeOf(reallyDo)) {  
        return this.replace(new RegExp(reallyDo, (ignoreCase ? "gi": "g")), replaceWith);  
    } else {  
        return this.replace(reallyDo, replaceWith);  
    }  
}

/**
 * 日期格式化
 */
Date.prototype.format = function(format){ 
	var o = { 
		"M+" : this.getMonth()+1, //month 
		"d+" : this.getDate(), //day 
		"h+" : this.getHours(), //hour 
		"m+" : this.getMinutes(), //minute 
		"s+" : this.getSeconds(), //second 
		"q+" : Math.floor((this.getMonth()+3)/3), //quarter 
		"S" : this.getMilliseconds() //millisecond 
	} 
	if(/(y+)/.test(format)) { 
	format = format.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length)); 
	} 
	for(var k in o) { 
		if(new RegExp("("+ k +")").test(format)) { 
		format = format.replace(RegExp.$1, RegExp.$1.length==1 ? o[k] : ("00"+ o[k]).substr((""+ o[k]).length)); 
		} 
	} 
	return format; 
} 

/** 
 * 将数值四舍五入(保留2位小数)后格式化成金额形式 
 * @param num 数值(Number或者String) 
 * @return 金额格式的字符串,如'1,234,567.45' 
 * @type String 
 */  
function formatCurrency(num) {  
    num = num.toString().replace(/\$|\,/g,'');  
    if(isNaN(num))num = "0";  
    sign = (num == (num = Math.abs(num)));  
    num = Math.floor(num*100+0.50000000001);  
    cents = num%100;  
    num = Math.floor(num/100).toString();  
    if(cents<10)  
    cents = "0" + cents;  
    for (var i = 0; i < Math.floor((num.length-(1+i))/3); i++)  
    num = num.substring(0,num.length-(4*i+3))+','+  
    num.substring(num.length-(4*i+3));  
    return (((sign)?'':'-') + num + '.' + cents);  
} 

/**
 * 兼容 事件阻止
 * @param event
 */
function preventDefault(event){
    if(document.all){
      window.event.returnValue = false;
    }else{
      event.preventDefault();
    }
}

function addAds(){
	//1）获取参数
	var sc=document.getElementsByTagName('script');  
	var paramsArr=sc[sc.length-1].src.split('?')[1].split('&');
	var args={},param,name,value;  
	for(var ii=0,len=paramsArr.length;ii<len;ii++){
	  param=paramsArr[ii].split('=');  
	  name=param[0],value=unescape(param[1]);  
	  if(typeof args[name]=="undefined"){
	      args[name]=value;
	  }else if(typeof args[name]=="string"){
	      args[name]=[args[name]];
	      args[name].push(value);
	  }else{ 
	      args[name].push(value);
	  }
	}

	var adkey = args["adkey"],
		classname=args["classname"],
		popid=args["popid"],
		adsize = args['size'],
		funname = args['fun'];

	//2）生产页面元素，包括显示标签和修改弹出窗标签
	var adid = '_ad_'+sc.length;
	document.write('<a id="ad_'+adid+'"></a>');
	if(typeof popid!='undefined'){
		var popWinStr = '';
		popWinStr+='<div id="'+popid+'" class="uk-modal" >';
		popWinStr+='<div class="uk-modal-dialog">';
		popWinStr+='    <a href="" class="uk-modal-close uk-close"></a>';
		popWinStr+='    <div class="" >';
		popWinStr+='        <div class="uk-form-row uk-grid" >';
		popWinStr+='        <div class="uk-width-1-5"><label class="uk-from-label">图片</label></div>';
		popWinStr+='        <div class="uk-width-4-5">';
		popWinStr+='            <div class="uk-width-4-5"><img width="100%" style="width:100%;height:200px;max-height:200px"/></div>';
		popWinStr+='            <div class="uk-width-4-5">';
		popWinStr+='                <div class="uk-placeholder upload-drop"> ';
		popWinStr+='                    <a class="uk-form-file">请选择图片';
		if(adsize)popWinStr+='<label>图片比例('+adsize+')</label>';
		popWinStr+='					<input class="upload-select" type="file" formmethod="post" name="file"></a>';
		popWinStr+='        </div></div></div></div>';
		
		popWinStr+='        <div class="uk-form-row uk-grid uk-margin-small-top" >';
		popWinStr+='        <div class="uk-width-1-5"><label class="uk-from-label">链接</label></div>';
		popWinStr+='        <div class="uk-width-4-5">';
		popWinStr+='            <input class="uk-width-4-5 adlink" type="text">';
		popWinStr+='        </div></div>';
		
		popWinStr+='        <div class="uk-form-row uk-grid" >';
		popWinStr+='        <div class="uk-width-1-5"><label class="uk-from-label">标题</label></div>';
		popWinStr+='        <div class="uk-width-4-5">';
		popWinStr+='            <input class="uk-width-4-5 adtitle" type="text">';
		popWinStr+='        </div></div>';
		
		popWinStr+='        <div class="uk-form-row uk-grid" >';
		popWinStr+='        <div class="uk-width-1-5"><label class="uk-from-label">显示时间</label></div>';
		popWinStr+='        <div class="uk-width-4-5">';
		popWinStr+='            <input class="adstarttime" readonly data-uk-datepicker="{format:\'YYYY-MM-DD\'}" type="text"> 到 <input class="adendtime" readonly data-uk-datepicker="{format:\'YYYY-MM-DD\'}" type="text">';
		popWinStr+='        </div></div>';
		
		popWinStr+='        <div class="uk-form-row uk-grid" >';
		popWinStr+='        <div class="uk-width-1-5"><label class="uk-from-label">是否显示</label></div>';
		popWinStr+='        <div class="uk-width-4-5">';
		popWinStr+='            <input type="radio" name="radiobtn'+popid+'" value="yes">是';
		popWinStr+='            <input type="radio" name="radiobtn'+popid+'" value="no" checked>否';
		popWinStr+='    </div></div></div>';
		
		popWinStr+='    <div class="uk-grid-divider"></div>';
		popWinStr+='    <div class="uk-width-1-2 uk-container-center">';
		popWinStr+='        <button class="uk-button uk-button-large uk-button-primary okbtn" style="width:100%;">确定修改</button>';
		popWinStr+='</div></div></div>';
		document.write(popWinStr);
	}

	//3）Ajax请求信息并填充页面相关元素
	$.post("GetAdz?ajaxtag=1",{key:adkey},function(resp){
		// img^title^url^isshow^starttime^endtime^
		if(resp=='noright'||resp=='notexist'||resp=='') resp="xx^xx^xx^no^2014-12-30^2014-12-30";
		
		var split=resp.split('^');
		var ad = $('#ad_'+adid).attr('href',split[2]).attr('title',split[1]).css('background-image','url('+split[0]+')');
		if(split[0].length<5) ad.text(split[1]);
		
		if(typeof classname!='undefined'){
			ad.attr('class',classname);
		}
		ad.addClass('adCommon');
		if(typeof split[4]=='undefined') split[4]="2014-12-30";
		if(typeof split[5]=='undefined') split[5]="2015-12-30";
		var now = new Date().format("yyyy-MM-dd");
		if(split[3]=='no' || now<=split[4] || now>split[5]){
			ad.hide();
		}
		
		if(typeof popid!='undefined'){
			var popW=$('#'+popid);
			var img=popW.find('img');
			popW.find('.adlink').val(split[2]);
			popW.find('.adtitle').val(split[1]);
			img.attr('src',split[0]);
			popW.find('.adstarttime').val(split[4]);
			popW.find('.adendtime').val(split[5]);
			if(split[3]=='no'){
				popW.find('input[name="radiobtn'+popid+'"][value="no"]')[0].checked = true;
			}
			else {
				popW.find('input[name="radiobtn'+popid+'"][value="yes"]')[0].checked = true;
			}
			popW.find('input[name="radiobtn'+popid+'"]').on('change',function(){
				if(popW.find('input[name="radiobtn'+popid+'"]:checked').val()=='yes') ad.show();
				else ad.hide();
			});
			var settings = {
			    action: 'Upload?type=photo/ad',
			    allow : '*.(jpg|jpeg|gif|png)',
			    loadstart: function() {},
			    progress: function(percent) {},
			    allcomplete: function(response) {
			        img.attr('src',response);
			    }
			};
			$.UIkit.uploadSelect(popW.find('.upload-select'), settings),
			$.UIkit.uploadDrop(popW.find('.upload-drop'), settings);
			popW.find('.okbtn').on('click',function(){
				var valuestr = img.attr('src')+'^'+popW.find('.adtitle').val()+'^'+popW.find('.adlink').val()+'^'+popW.find('input[name="radiobtn'+popid+'"]:checked').val()+'^'+popW.find('.adstarttime').val()+'^'+popW.find('.adendtime').val();
				$.post("EditAdz?ajaxtag=1",{key:adkey,value:valuestr},function(resp2){
					//提示信息
					
					ad.attr('href',popW.find('.adlink').val());
					ad.css('background-image','url('+img.attr('src')+')');
					ad.text(popW.find('.adtitle').val());
					popW.find('.uk-close').click();
				});
			});
		}
		
		if(typeof funname!='undefined'){
			eval('('+funname+')');
		}
	});
}

/**
 * 转换成UTF-8
 * @param str
 * @returns {String}
 */
function utf16to8(str) {
	var out, i, len, c;
    out = "";
    len = str.length;
    for(i = 0; i < len; i++) {
    	c = str.charCodeAt(i);
    	if ((c >= 0x0001) && (c <= 0x007F)) {
    		out += str.charAt(i); 
    	} else if (c > 0x07FF) { 
    		out += String.fromCharCode(0xE0 | ((c >> 12) & 0x0F));
    		out += String.fromCharCode(0x80 | ((c >>  6) & 0x3F)); 
    		out += String.fromCharCode(0x80 | ((c >>  0) & 0x3F));
    	} else {
    		out += String.fromCharCode(0xC0 | ((c >>  6) & 0x1F));
    		out += String.fromCharCode(0x80 | ((c >>  0) & 0x3F));
    	}
    }
    return out;   
}

/**
 * div抖动
 * @param o
 */
function shake(o){
	var element = $(o);
	element.css('position', 'relative');
	for(var i=1; 4>=i; i++){
		element.animate({left:-(20-5*i)},50);
		element.animate({left:2*(20-5*i)},50);
    }
}
/**
 * div闪烁
 * @param o
 */
function flash(o){
	var element = $(o);
	element.addClass('backgroundRed');
	setTimeout(function () {
	    element.removeClass('backgroundRed');
	    setTimeout(function () {
	        element.addClass('backgroundRed');
	        setTimeout(function () {
	            element.removeClass('backgroundRed');
	        }, 100);
	    }, 100);
	}, 100);
}

/**
 * "加载中"提示
 * @param txt
 * @returns
 */
var progress_step = 0;
function loadingModal(txt, time){
	if($('#loadingModal').length<1){
		$('<div id="loadingModal" style="z-index:9997;display:none"><div style="position:fixed;width:100%;height:100%;left:0;top:0;z-index:9998;background:#ccc;opacity:0.5;"></div><div style="position:fixed;width:100%;height:100%;line-height:100%;top:0;z-index:9999;font-size:30px;text-align:center;"><div class="progressBar" style="border:2px solid blue;width:0"></div><span class="forText" style="color:#fff">加载中……</span></div></div>').appendTo('body');
	}
	var m = $('#loadingModal');
	if(m.is(':hidden')){
		m.toggle();
	}else{
		if(txt){}else{
			m.toggle();
		}
	}
	
	if(!m.is(':hidden')){
		var step = 500;
		if(time) step = time*1/4;
		var bar = m.find('.progressBar').css('width',0);
		progress_step = 1;
		bar.animate({width:'50%'},step,function(){
			progress_step = 2;
			bar.animate({width:'75%'},step,function(){
				if(progress_step<2) return false;
				progress_step = 3;
				bar.animate({width:'95%'},step,function(){
					if(progress_step<3) return false;
					progress_step = 4;
					bar.animate({width:'98%'},step*6,function(){ });
				});
			});
		});
	}
	if(txt){
		m.find('.forText').text(txt);
	}
	return m;
}

/**
 * 表单进行序列化
 **/
$.fn.serializeObject = function()    
{    
   var o = {};    
   var a = this.serializeArray();
   $.each(a, function() {    
       if (o[this.name]) {    
           if (!o[this.name].push) {    
               o[this.name] = [o[this.name]];    
           }    
           o[this.name].push(this.value || '');    
       } else {    
           o[this.name] = this.value || '';    
       }    
   });    
   return o;    
};

/**
 * para_name 参数名称 para_value 参数值 url所要更改参数的网址
 * @param para_name
 * @param para_value
 */
function setUrlParam(para_name, para_value) {
    var strNewUrl = new String();
    var strUrl = new String();
    var url = new String();
    url= window.location.href;
    strUrl = window.location.href;
    if (strUrl.indexOf("?") != -1) {
        strUrl = strUrl.substr(strUrl.indexOf("?") + 1);
        if (strUrl.toLowerCase().indexOf(para_name.toLowerCase()) == -1) {
            strNewUrl = url + "&" + para_name + "=" + para_value;
            window.location = strNewUrl;
        } else {
            var aParam = strUrl.split("&");
            for (var i = 0; i < aParam.length; i++) {
                if (aParam[i].substr(0, aParam[i].indexOf("=")).toLowerCase() == para_name.toLowerCase()) {
                    aParam[i] = aParam[i].substr(0, aParam[i].indexOf("=")) + "=" + para_value;
                }
            }
            strNewUrl = url.substr(0, url.indexOf("?") + 1) + aParam.join("&");
            window.location = strNewUrl;
        }
    } else {
        strUrl += "?" + para_name + "=" + para_value;
        window.location=strUrl;
    }
}

if(String.prototype.toJSON){}else{
	String.prototype.toJSON = function() 
	{
			var str = this.replace(/^s+|s+$/g, '');
			if ($.isPlainObject(str)) return str;
			var start = (str ? str.indexOf("[") : -1), options = {};
			if(start != 0) start = (str ? str.indexOf("{") : -1);
			if (start != -1) {
			    try {
			        options = (new Function("", "var json = " + str.substr(start) + "; return JSON.parse(JSON.stringify(json));"))();
			    } catch (e) {}
			}
			return options;
	};
}