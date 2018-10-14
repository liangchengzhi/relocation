/*********************************************************************/
/**
 * 表达验证, 需要jQuery支持
 */
/*********************************************************************/
var validateErrCls = "validateErr";
if(String.prototype.str2JSON){}else{
	String.prototype.str2JSON = function() 
	{
			var str = this.replace(/^s+|s+$/g, '');
			if ($.isPlainObject(str)) return str;
			var start = (str ? str.indexOf("[") : -1), options = {};
			if(start != 0) start = (str ? str.indexOf("{") : -1);
			if (start != -1) {
			    try {
			    	if (typeof (JSON) == 'object' && JSON.parse){
			    		//var json = JSON.stringify(str.substr(start));
			    		return (new Function("", "var json = " + str.substr(start) + "; return JSON.parse(JSON.stringify(json));"))();//JSON.parse(json);
			    	}else{
			    		return eval("(" + str.substr(start) + ")");
			    	}
			        //options = (new Function("", "var json = " + str.substr(start) + "; return JSON.parse(JSON.stringify(json));"))();
			    } catch (e) {}
			}
			return options;
	};
}
/**
 * 验证指定输入标签，focus不为空时验证不通过则聚焦到错误处
 * @param obj
 * @param focus
 * @returns {Boolean}
 */
function validateInput(obj, focus){
	if($(obj).length == 0) return true;
	if($(obj).attr('lhq-validate') == undefined) return true;
	if($(obj).css('display')=='none' || $(obj).parents('.uk-hidden').length>0) return true;
	
	if($(obj).parent().children('.forMsg').length==0) {
		var target = $(obj);
		if($(obj).parent().children('.help-inline').length>0) target = $(obj).parent().children('.help-inline');
		target.after('<div class="forMsg" style="position:relative;color:red;height:0;display:none;white-space: nowrap;"></div>');
	}
	var validator = $(obj).attr('lhq-validate').str2JSON();
	if(validator instanceof Array){}else{validator = [validator];}
	for(var i=0;i<validator.length;i++){
		if(validator[i].msg != undefined) $(obj).parent().children('.forMsg').html(validator[i].msg);
		else $(obj).parent().children('.forMsg').text('');
		
		var valid = true;
		
		// 必填
		if(valid && validator[i].required != undefined){
			if(validator[i].required==true && $(obj).val().trim()=='') {
				valid = false;
				if(validator[i].msg == undefined)$(obj).parent().children('.forMsg').text('这是必填项，不能为空').show();
			}
		}
		// 电话号码
		if(valid && validator[i].phone != undefined && $(obj).val().trim()!=''){
			if(!/^([\+]?(\d{3,4}-)?\d{7,8})|(13[0-9](( |-|—|　|－|—)?[0-9]{4}){2})$/.test($(obj).val().trim())){
				valid = false;
				if(validator[i].msg == undefined)$(obj).parent().children('.forMsg').text('请输入有效的电话号码').show();
			}
		}
		// QQ
		if(valid && validator[i].qq != undefined && $(obj).val().trim()!=''){
			if(!/^[1-9][0-9]{4,11}$/.test($(obj).val().trim()) || $(obj).val()*1>23000000000){
				valid = false;
				if(validator[i].msg == undefined)$(obj).parent().children('.forMsg').text('请输入有效的QQ号').show();
			}
		}
		// 身份证
		if(valid && validator[i].idcard !=undefined && $(obj).val().trim()!=''){
			if(!/^(\d{15}|\d{18}|(\d{17}(\d|X|x)))$/.test($(obj).val().trim())){
				valid = false;
				if(validator[i].msg == undefined)$(obj).parent().children('.forMsg').text('请输入有效的身份证号').show();
			}
		}
		// 最小值
		if(valid && validator[i].min != undefined){
			if($(obj).val()*1<validator[i].min) {
				valid = false;
				if(validator[i].msg == undefined)$(obj).parent().children('.forMsg').text('不能小于最小值'+validator[i].min).show();
			}
		}
		// 最大值
		if(valid && validator[i].max != undefined){
			if($(obj).val()*1>validator[i].max) {
				valid = false;
				if(validator[i].msg == undefined)$(obj).parent().children('.forMsg').text('不能大于最大值'+validator[i].max).show();
			}
		}
		// 最小长度
		if(valid && validator[i].minLen != undefined){
			if($(obj).val().trim().replace(/[^\x00-\xff]/g, 'xx').length<validator[i].minLen) {
				valid = false;
				if(validator[i].msg == undefined)$(obj).parent().children('.forMsg').text('不能少于 '+validator[i].minLen+' 个字节(1个中文算2个)').show();
			}
		}
		// 最大长度
		if(valid && validator[i].maxLen != undefined){
			if($(obj).val().trim().replace(/[^\x00-\xff]/g, 'xx').length>validator[i].maxLen) {
				valid = false;
				if(validator[i].msg == undefined)$(obj).parent().children('.forMsg').text('不能多于'+validator[i].maxLen+' 个字节(1个中文算2个)').show();
			}
		}
		// 和指定输入相等
		if(valid && validator[i].eqTo != undefined){
			//validateInput($(validator[i].eqTo)[0]);
			if($(obj).val().trim()!=$(validator[i].eqTo).val().trim()) {
				valid = false;
			}
		}
		// 比指定输入小于或等于String
		if(valid && validator[i].strLeTo != undefined && $(validator[i].strLeTo).val().trim()!=''){
			//validateInput($(validator[i].leTo)[0]);
			if($(obj).val().trim()>$(validator[i].strLeTo).val().trim()) {
				valid = false;
			}
		}
		// 比指定输入大于或等于String
		if(valid && validator[i].strGeTo != undefined && $(validator[i].strGeTo).val().trim()!=''){
			validateInput($(validator[i].strGeTo)[0]);
			if($(obj).val().trim()<$(validator[i].strGeTo).val().trim()) {
				valid = false;
			}
		}
		// 比指定输入小于或等于
		if(valid && validator[i].leTo != undefined && $(validator[i].leTo).val().trim()!=''){
			//validateInput($(validator[i].leTo)[0]);
			if($(obj).val()*1>$(validator[i].leTo).val()*1) {
				valid = false;
			}
		}
		// 比指定输入大于或等于
		if(valid && validator[i].geTo != undefined && $(validator[i].geTo).val().trim()!=''){
			validateInput($(validator[i].geTo)[0]);
			if($(obj).val()*1<$(validator[i].geTo).val()*1) {
				valid = false;
			}
		}
		
		// 正则表达
		if(valid && validator[i].reg != undefined && $(obj).val().trim()!=''){
			if(!eval(validator[i].reg).test($(obj).val().replaceAll('\n',''))) {
				valid = false;
				if(validator[i].def != undefined){
					$(obj).val(validator[i].def);
				}
			}
		}
		
		if(valid==true){
			$(obj).removeClass(validateErrCls);
			$(obj).parent().children('.forMsg').hide();
		}else{
			$(obj).addClass(validateErrCls);
			$(obj).parent().children('.forMsg').show();
			$(obj).parent().children('.forMsg').css('height',$(obj).parent().children('.forMsg').find('br').length>0?'auto':'0px');
			
			if(focus) $(obj).focus();
			return false;
		}
	}
	return true;
}

/**
 * 验证表单
 */
function validateForm(form, flag){
	var inputs = $(form).find('[lhq-validate]');
	var valid = true;
	for(var i=inputs.length-1;i>=0;i--){
		valid = valid & validateInput(inputs[i], flag==undefined?true:flag);
		/*if(!valid){
			alert($(inputs[i]).attr("placeholder"))
		}*/
	}
	return valid;
}

$(function(){
	$("[lhq-validate]").each(function(){
		$(this).on('input',function(){
    		validateInput(this);
    	});
		$(this).on('change',function(){
    		validateInput(this);
    	});
		$(this).on('blur',function(){
    		validateInput(this);
    	});
    });
});
