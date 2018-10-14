/*********************************************************************/
/**管理员操作函数，需要Jquery、uikit支持	: 首页显示图片标题设置、发放金币
/*********************************************************************/

/**
 * 首页显示图片和标题更换
 */
function showSettingModel(type,sid,size){

	$("#settingM_lhq").remove();
	var popWinStr = '<div id="settingM_lhq" style="position:absolute;left:-1000px">';
	popWinStr+='<button class="uk-button" data-uk-modal="{target:\'#settingModal\'}"></button>';
	popWinStr+='<div id="settingModal" class="uk-modal" >';
	popWinStr+='<div class="uk-modal-dialog">';
	popWinStr+='    <a href="" class="uk-modal-close uk-close"></a>';
	popWinStr+='    <div class="" >';
	popWinStr+='        <div class="uk-form-row uk-grid" >';
	popWinStr+='        <div class="uk-width-1-5"><label class="uk-from-label">显示图片</label></div>';
	popWinStr+='        <div class="uk-width-4-5">';
	popWinStr+='            <div class="uk-width-4-5"><img width="100%" style="width:100%;height:200px;max-height:200px" alt="图片加载中......"/></div>';
	popWinStr+='            <div class="uk-width-4-5">';
	popWinStr+='                <div class="uk-placeholder upload-drop uk-text-center"> ';
	popWinStr+='                    <a class="uk-form-file">请选择图片 ';
	if(size)popWinStr+='<label> ('+size+')</label>';
	popWinStr+='										<input class="upload-select" type="file" formmethod="post" name="file"></a>';
	popWinStr+='										<div class="uk-progress progressbar uk-hidden aat-personal-edit-input" ><div class="uk-progress-bar" style="width: 0%;">...</div></div>';
	popWinStr+='        </div></div></div></div>';
	
	popWinStr+='        <div class="uk-form-row uk-grid uk-margin-large-bottom" >';
	popWinStr+='        <div class="uk-width-1-5"><label class="uk-from-label">显示标题</label></div>';
	popWinStr+='        <div class="uk-width-4-5">';
	popWinStr+='            <input lhq-validate="{required:true,minLen:5,maxLen:80}" class="uk-width-4-5 adtitle" placeholder="首页显示标题" type="text">';
	popWinStr+='        </div></div>';
	
	popWinStr+='    </div>';
	
	popWinStr+='    <div class="uk-grid-divider"></div>';
	popWinStr+='    <div class="uk-width-1-2 uk-container-center">';
	popWinStr+='        <button class="uk-button uk-button-large uk-button-primary okbtn noradius" style="width:100%;">确定修改</button>';
	popWinStr+='</div></div></div></div>';
	$(popWinStr).appendTo("body");
	$("#settingM_lhq").children("button").click();
	var popWin = $("#settingModal");
	
	$.post("GetObjectz?ajaxtag=1",{type:type,sid:sid},function(resp){
		if(checkResponse(resp,'AA对象')==false){
			setTimeout(function(){ popWin.find('.uk-close').click(); }, 250);
			return false;
		}
		var split=resp.split('^');
		popWin.find('img').attr('src',split[1]).attr('alt',split[0]);
		popWin.find('.adtitle').val(split[0]);
		
	});
	
	popWin.find('.adtitle').on('input',function(){
		validateInput(this);
	}).on('change',function(){
		validateInput(this);
	});
	var progressbar = popWin.find('.progressbar');
	var bar = progressbar.find('.uk-progress-bar');
	var settings = {
	    action: 'Upload?type=photo/ad',
	    allow : '*.(jpg|jpeg|gif|png)',
	    loadstart: function() {
	    	progressbar.removeClass('uk-hidden').find('.uk-progress-bar').css('width','0').text('0%');
	    },
	    progress: function(percent) {
	    	 percent = Math.ceil(percent);
	    	 bar.css("width", percent+"%").text(percent+"%");
	    },
	    allcomplete: function(response) {
	    	bar.css("width", "100%").text("100%");
	    	setTimeout(function(){ progressbar.addClass("uk-hidden"); }, 250);
	    	popWin.find('img').attr('src',response);
	    }
	};
	$.UIkit.uploadSelect(popWin.find('.upload-select'), settings),
	$.UIkit.uploadDrop(popWin.find('.upload-drop'), settings);
	popWin.find('.okbtn').on('click',function(){
		if(validateInput(popWin.find('.adtitle'),true)==false) return false;
		
		if(popWin.find('img').attr('src').indexOf('repository')==-1){
			$.UIkit.notify("<i class='uk-icon-times'></i> 请先上传活动封面图片!");
			return false;
		}
		
		$.post("SetObjectz?ajaxtag=1",{type:type,sid:sid,
			 	title:popWin.find('.adtitle').val(),image:popWin.find('img').attr('src')},function(resp){
		 		if(checkResponse(resp,'AA对象')==false) return false;
		 		
		 		location.href = "Homez";
		});
	});
}

/**
 * 发放金币
 * @param uid
 */
function 发放金币(uid){
	$("#goldM_lhq").remove();
	var div = '<div id="goldM_lhq" style="position:absolute;left:-1000px">';
	div+='<button class="uk-button" data-uk-modal="{target:\'#goldModal\'}"></button>';
	div+='<div id="goldModal" class="uk-modal" style="display: none; z-index:1022">';
	div+='<div class="uk-modal-dialog uk-alert">';
	div+='<a href="" class="uk-modal-close uk-close"></a>';
	div+='<h3 class="modalTitle uk-text-truncate">向用户发放金币</h3>';
	div+='<div class="uk-form-row uk-grid">';
	div+='	<div class="uk-width-1-4 aat-form-label-medium">金额来源</div>';
	div+='	<div class="uk-width-3-4"><select class="uk-width-3-4 type">';
	div+='  <option value="精彩活动">精彩活动</option>';
	div+='  <option value="优秀攻略">优秀攻略</option>';
	div+='  <option value="优秀论坛">优秀论坛</option>';
	div+='  <option value="精辟说说">精辟说说</option>';
	div+='  <option value="任性发放">任性，随意发放</option></select></div>';
	div+='</div><div class="uk-form-row uk-grid">';
	div+='	<div class="uk-width-1-4 aat-form-label-medium">金币数量</div>';
	div+='	<div class="uk-width-3-4"><input class="uk-width-3-4 num" type="number" value="1"/></div>';
	div+='</div><div class="uk-form-row uk-grid">';
	div+='	<div class="uk-width-1-4 aat-form-label-medium">发放理由</div>';
	div+='	<div class="uk-width-3-4"><textarea rows="5" class="uk-width-3-4 reason"></textarea></div>';
	div+='</div><div class="uk-form-row uk-grid">';
	div+='	<div class="uk-width-1-4">&nbsp;</div>';
	div+='	<div class="uk-width-3-4">';
	div+='	<button class="uk-button uk-button-primary uk-modal-close modalOK noradius">发放</button>&nbsp;';
	div+='	<button class="uk-button uk-modal-close noradius">取消</button>&nbsp;';
	div+='</div></div>';
	div+='</div></div></div>';
	var modal = $(div).appendTo("body");
	modal.find(".modalOK").on("click",function(){
		var num = modal.find('.num').val().trim();
		var type= modal.find('.type').val();
		var reason = modal.find(".reason").val().trim();
		if(isNaN(num) || num<=0){
			$.UIkit.notify("<i class='uk-icon-times'></i> 发放金额数量必须是大于0的整数!");return false;
		}
		$.post("SendGoldz?ajaxtag=1",{uid:uid,num:num,type:type,description:reason},function(resp){
			if(checkResponse(resp,'发放用户')==false) return false;
			
			$.UIkit.notify("<i class='uk-icon-check'></i> 给用户发放金币成功!",{timeout:1500});
		});
	});
	modal.children("button").click();
}

/**
 * 删除指定用户的言论
 * @param uid
 * @param uname
 */
function eraserUser(uid,uname){
	confirmModal2("警告","确定要删除用户 <em>"+uname+"</em> 发表的内容(包括活动、攻略、论坛、说说及其评论)吗？删除后不可恢复！","删除","取消",function(){
		$.post("EraserUserz?ajaxtag=1",{uid:uid},function(resp){
			if(checkResponse(resp,"用户")==false) return false;
			
			$.UIkit.notify("<i class='uk-icon-check'></i> 删除用户言论成功!",{timeout:1500});
		});
	});
}

/**
 * 删除平台用户
 * @param uid
 * @param uname
 */
function removeUser(uid, uname){
	confirmModal2("请三思！","删除用户后不可恢复，确定要删除用户 <em>"+uname+"</em> 吗？<br/><span class='red'><small>删除前别忘了清空该用户发表过的内容哦！</small></span>","确定","取消",function(){
		$.post("RemoveUserz?ajaxtag=1",{uid:uid, message:'',flag:true},function(resp){
			if(checkResponse(resp,"用户")==false) return false;
			
			$.UIkit.notify("<i class='uk-icon-check'></i> 删除用户成功!",{timeout:1500});
			
			$('#cuser_sid_'+uid).remove();
		});
	});
}

/**
 * 重置用户密码
 * @param uid
 * @param uname
 * @param value
 */
function resetPwd(uid, uname, value){
	confirmModal2("警告","确定要修改用户 <em>"+uname+"</em> 的登录密码为 <em>"+value+"</em> 吗？<br/><span class='red'><small>修改后别忘了通知该用户哦！</small></span>","确定","取消",function(){
		$.post("AdminProcess?ajaxtag=1",{type:4, uid:uid, password:value},function(resp){
			if(checkResponse(resp,"用户")==false) return false;
			
			$.UIkit.notify("<i class='uk-icon-check'></i> 重置密码成功!",{timeout:1500});
		});
	});
}

/**
 * 限制用户登录
 * @param uid
 * @param uname
 */
function banUser(uid,uname,flag){
	var IdTag = "banUser";
	$("#"+IdTag+"M_lhq").remove();
	var div = '<div id="'+IdTag+'M_lhq" style="position:absolute;left:-1000px">';
	div+='<button class="uk-button" data-uk-modal="{target:\'#'+IdTag+'Modal\'}"></button>';
	div+='<div id="'+IdTag+'Modal" class="uk-modal" style="display: none; z-index:1022">';
	div+='<div class="uk-modal-dialog uk-alert">';
	div+='<a href="" class="uk-modal-close uk-close"></a>';
	div+='<h3 class="modalTitle uk-text-truncate">'+(flag==false?'取消':'')+'限制用户登录确认</h3>';
	div+='<div class="uk-form-row uk-grid">';
	if(flag==true){
		div+='	<div class="uk-width-1-1">限制后，用户不可以登录系统，您确定要对用户 <em>'+uname+'</em> 进行登录限制吗？<br/>限制理由：<br/><textarea class="uk-width-1-1" rows="3" placeholder="限制理由(可选)"></textarea></div>';
	}else{
		div+='	<div class="uk-width-1-1">取消后用户可以登录系统，您确定要取消用户 <em>'+uname+'</em> 的登录限制吗？</div>';
	}
	div+='</div><div class="uk-form-row uk-grid">';
	div+='	<div class="uk-width-1-4">&nbsp;</div>';
	div+='	<div class="uk-width-3-4">';
	div+='	<button class="uk-button uk-button-primary uk-modal-close modalOK noradius">确定</button>&nbsp;';
	div+='	<button class="uk-button uk-modal-close noradius">取消</button>&nbsp;';
	div+='</div></div>';
	div+='</div></div></div>';
	var modal = $(div).appendTo("body");
	modal.find(".modalOK").on("click",function(){
		var message = "";
		if(flag==true){
			message = modal.find('textarea').val().trim();
		}
		$.post("BanUserz?ajaxtag=1",{uid:uid, message:message, flag:flag},function(resp){
			if(checkResponse(resp,'用户')==false) return false;
			
			$.UIkit.notify("<i class='uk-icon-check'></i> "+(flag==false?'取消':'')+"限制用户登录成功!",{timeout:1500});
			
			if(flag==true){
				$('#cuser_sid_'+uid).find('.isNotInvalid').addClass('uk-hidden');
				$('#cuser_sid_'+uid).find('.isInvalid').removeClass('uk-hidden');
			}else{
				$('#cuser_sid_'+uid).find('.isNotInvalid').removeClass('uk-hidden');
				$('#cuser_sid_'+uid).find('.isInvalid').addClass('uk-hidden');
			}
		});
	});
	modal.children("button").click();
}

/**
 * 修改浏览次数
 * @param type
 * @param times
 * @param sid
 */
function alterViewTimes(type,times, sid){
	var IdTag = "alterViewTimes";
	$("#"+IdTag+"M_lhq").remove();
	var div = '<div id="'+IdTag+'M_lhq" style="position:absolute;left:-1000px">';
	div+='<button class="uk-button" data-uk-modal="{target:\'#'+IdTag+'Modal\'}"></button>';
	div+='<div id="'+IdTag+'Modal" class="uk-modal" style="display: none; z-index:1022">';
	div+='<div class="uk-modal-dialog uk-alert">';
	div+='<a href="" class="uk-modal-close uk-close"></a>';
	div+='<h3 class="modalTitle uk-text-truncate">修改浏览次数</h3>';
	div+='<div class="uk-form-row uk-grid">';
	div+='	<div class="uk-width-1-4 aat-form-label-medium">浏览次数</div>';
	div+='	<div class="uk-width-3-4"><input class="uk-width-3-4 num" type="number" value="'+times+'"/></div>';
	div+='</div><div class="uk-form-row uk-grid">';
	div+='	<div class="uk-width-1-4">&nbsp;</div>';
	div+='	<div class="uk-width-3-4">';
	div+='	<button class="uk-button uk-button-primary uk-modal-close modalOK noradius">修改</button>&nbsp;';
	div+='	<button class="uk-button uk-modal-close noradius">取消</button>&nbsp;';
	div+='</div></div>';
	div+='</div></div></div>';
	var modal = $(div).appendTo("body");
	modal.find(".modalOK").on("click",function(){
		
		var num = modal.find('.num').val().trim();
		if(isNaN(num) || num<=0){
			$.UIkit.notify("<i class='uk-icon-times'></i> 浏览次数必须是大于0的整数!");return false;
		}
		$.post("AlterViewTimesz?ajaxtag=1",{sid:sid,num:num,type:type},function(resp){
			if(checkResponse(resp,'对象')==false) return false;
			
			$.UIkit.notify("<i class='uk-icon-check'></i> 修改浏览次数成功!",{timeout:1500});
			$('#sid_'+sid).find('.viewTimes').text(num);
		});
	});
	modal.children("button").click();
}