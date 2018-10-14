/*********************************************************************/
/**登录页面js
/*********************************************************************/
$(function(){
	checkTnc();
	var logintoken = getCookie('logintoken');
	var u = getCookie('loginusername');
	if(u!=null&&u!=''){
			$('.login-form input[name="username"]').val(decodeURI(u));
	}
	if(logintoken!=null&&logintoken!=''){
			$('.login-form input[name="password"]').val('000000');
			$('.login-form input[name="remember"]').removeAttr('checked').click();
	}
	
	$('#forget-password').click(function () {
        $('form').hide();
        $('.forget-form').show();
    });
	$('#register-btn').click(function () {
        $('form').hide();
        $('.register-form').show();
    });
	$('#back-btn').click(function () {
        $('form').hide();
        $('.login-form').show();
    });
	$('#back-btn2').click(function () {
        $('form').hide();
        $('.forget-form').show();
    });
	$('input[name="tnc"]').on('change',function(){
		checkTnc();
	});
	
    $('#register-back-btn').click(function () {
        $('.login-form').show();
        $('.register-form').hide();
    });
	
	$('#loginBtn').click(function(){
		preventDefault(arguments[0]);
		if(validateForm('.login-form')==false){
			shake('.content'); return false;
		}
		var username = $('.login-form input[name="username"]').val().trim();
		var password = $('.login-form input[name="password"]').val().trim();
		
		var remenber = $('.login-form input[name="remember"]:checked');
		var params = {username:username, password:password};
		if(remenber.length>0){
			params['remenberMe'] = 'yes';
		}
		
		loadingModal('正在登录……');
		$.post("checkLogin?ajaxtag=1",params,function(resp){
			loadingModal();
			if(checkResponse(resp)==false) return ;
			
			if($('#referer').val()!='') location.href = $('#referer').val();
			else if(resp.data.usertype>1){
				location.href = web_app_root+"/Admin";
			}else{
				location.href = web_app_root+"/";
			}
		});
	});
	
	$('#findPwdBtn').click(function(){
		preventDefault(arguments[0]);
		if(validateForm('.forget-form')==false){
			shake('.content'); return false;
		}
		var param = $('.forget-form').serializeObject();
		loadingModal('请求处理中……');
		$.post("findPwdByMobileStep1?ajaxtag=1",param,function(resp){
			loadingModal();
			if(checkResponse(resp)==false) return ;
			showMsg('验证成功，请设置新密码。');
			$('.forget-form2 input[name="phone"]').val(resp.data)
			$('form').hide();
            $('.forget-form2').show();
		});
	});
	
	$('#resetPwdBtn').click(function(){
		preventDefault(arguments[0]);
		
		if(validateForm('.forget-form2')==false){
			shake('.content'); return false;
		}
		var param = $('.forget-form2').serializeObject();
		loadingModal('请求处理中……');
		$.post("findPwdByMobileStep2?ajaxtag=1",param,function(resp){
			loadingModal();
			if(checkResponse(resp)==false) return ;
			showMsg('设置新密码成功，请重新登录。');
			$('.login-form input[name="username"]').val(resp.data)
            $('form').hide();
			$('.login-form').show();
		});
	});
	
    
    $('#registerBtn').click(function(){
    	if(typeof $(this).attr('disabled') != 'undefined') return;
    	preventDefault(arguments[0]);
		if(validateForm('.register-form')==false){
			shake('.content'); return false;
		}
    	var param = $('.register-form').serializeObject();
    	loadingModal('请求处理中……');
		$.post("register?ajaxtag=1",param,function(resp){
			loadingModal();
			if(checkResponse(resp)==false) return ;
			showMsg('注册成功，请登录。');
			$('.login-form input[name="username"]').val(resp.data.username)
            $('.register-form').hide();
			$('.login-form').show();
		});
    });
    
    $('.register-form input[name="username"]').on('blur',function(){
		var _this = this;
		if($(_this).hasClass(validateErrCls)==false && validateInput(_this)==true){
			$.post("checkUsername?ajaxtag=1",{username:$(_this).val()},function(resp){
				if(checkResponse(resp)==false) return ;
				if(resp.data==true){
					$(_this).parent().children('.forMsg').html('被人抢先一步，你可以换一个更酷的。').show();
					$(_this).addClass(validateErrCls);
				}else{
					$(_this).parent().children('.forMsg').hide();
				}
			});
		}
	});
    $('.register-form input[name="phone"]').on('blur',function(){
		var _this = this;
		if($(_this).hasClass(validateErrCls)==false && validateInput(_this)==true){
			$.post("checkPhone?ajaxtag=1",{phone:$(_this).val()},function(resp){
				if(checkResponse(resp)==false) return ;
				if(resp.data==true){
					$(_this).parent().children('.forMsg').html('不好意思，该手机号已被绑定。').show();
					$(_this).addClass(validateErrCls);
				}else{
					$(_this).parent().children('.forMsg').hide();
				}
			});
		}
	});
    $('#randcodeBtn4Register').click(function(){
    	var _this = $(this);
    	var phone = $('.register-form input[name="phone"]');
    	if(phone.hasClass(validateErrCls)==false && validateInput(phone)==true){
    		_this.text('请求已发送').attr('disabled','');
    		$.post("phoneRandcode?ajaxtag=1",{phone:phone.val(),type:'register'},function(resp){
    			if(checkSmsResult(resp)==false){
    				timeToResend(2, _this);
    			}else{
    				showMsg('验证码已发送，请在20分内进行验证。')
    				timeToResend(59, _this);
    			}
    		});
    	}else{
    		shake(phone.parents('.control-group')); return false;
    	}
    });
    
    $('#randcodeBtn4FindPwd').click(function(){
    	var _this = $(this);
    	var phone = $('.forget-form input[name="phone"]');
    	if(phone.hasClass(validateErrCls)==false && validateInput(phone)==true){
    		_this.text('请求已发送').attr('disabled','');
    		$.post("phoneRandcode?ajaxtag=1",{phone:phone.val(),type:'findpwd'},function(resp){
    			if(checkSmsResult(resp)==false){
    				timeToResend(2, _this);
    			}else{
    				showMsg('验证码已发送，请在20分内进行验证。')
    				timeToResend(59, _this);
    			}
    		});
    	}else{
    		shake(phone.parents('.control-group')); return false;
    	}
    });
    
});
function checkTnc(){
	if($('input[name="tnc"]:checked').length>0){
		$('#registerBtn').removeAttr('disabled');
	}else{
		$('#registerBtn').attr('disabled','disabled');
	}
}
function timeToResend(m,obj){
	if(m==0){
		$(obj).html('重新获取短信验证码').removeAttr('disabled');
	}else{
		$(obj).html(m+'秒后可重新获取');
		setTimeout(function(){
			timeToResend(m-1, obj);
		},1000);
	}
}