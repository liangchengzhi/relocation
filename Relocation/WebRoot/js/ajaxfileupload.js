// JavaScript Document
jQuery.extend({
  handleError: function( s, xhr, status, e )      {  
    // If a local callback was specified, fire it  
    if ( s.error ) {
      s.error.call( s.context || s, xhr, status, e ); 
    }  

    // Fire the global callback  
    if ( s.global ) {  
      (s.context ? jQuery(s.context) : jQuery.event).trigger( "ajaxError", [xhr, s, e] );  
    }  
  },  
  
  createUploadIframe: function(id, uri)
  {
    //create frame
    var frameId = 'jUploadFrame' + id;
    if(window.ActiveXObject) {
      var io = document.createElement('iframe');
      io.id = frameId;
      io.name = frameId;
      if(typeof uri== 'boolean'){
        io.src = 'javascript:false';
      }else if(typeof uri== 'string'){
        io.src = uri;
      }
    }else {
      var io = document.createElement('iframe');
      io.id = frameId;
      io.name = frameId;
    }
    io.style.position = 'absolute';
    io.style.top = '-1000px';
    io.style.left = '-1000px';
    document.body.appendChild(io);
    return io;   
  },

  createUploadForm: function(id, fileElement, fileElementName)
  {
    //create form 
    var formId = 'jUploadForm' + id;
    var fileId = 'jUploadFile' + id;
    var form = jQuery('<form  action="" method="POST" name="' + formId + '" id="' + formId + '" enctype="multipart/form-data"></form>'); 
    
    //复制， 新的替换到原来的，原来的用来提交
    var oldElement = jQuery(fileElement);
    var newElement = jQuery(oldElement).clone(true);
    jQuery(oldElement).attr('id', fileId);
    jQuery(oldElement).attr('name', fileElementName);
    jQuery(oldElement).before(newElement);
    jQuery(oldElement).appendTo(form);

    //set attributes
    jQuery(form).css('position', 'absolute');
    jQuery(form).css('top', '-1200px');
    jQuery(form).css('left', '-1200px');
    jQuery(form).appendTo('body');
    
    return form;
  },

  ajaxFileUpload: function(s) 
  {
    // TODO introduce global settings, allowing the client to modify them for all requests, not only timeout
    s = jQuery.extend({}, jQuery.ajaxSettings, s);
    var id = Math.ceil(Math.random()*9999)+1000;
    var form = jQuery.createUploadForm(id, s.fileElement, s.fileElementName);
    var io = jQuery.createUploadIframe(id, s.secureuri);
    var frameId = 'jUploadFrame' + id;
    var formId = 'jUploadForm' + id;  

    if(s.loadstart){
    	s.loadstart();
    }
    
    if( s.global && ! jQuery.active++ ){
      // Watch for a new set of requests
      jQuery.event.trigger( "ajaxStart" );
    }

    var requestDone = false;
    // Create the request object
    var xml = {}; 
    if( s.global ){
      jQuery.event.trigger("ajaxSend", [xml, s]);
    }

    var uploadCallback = function(isTimeout)
    { 
      // Wait for a response to come back 
      io = document.getElementById(frameId);
      try {    
        if(io.contentWindow){
          xml.responseText = io.contentWindow.document.body?io.contentWindow.document.body.innerHTML:null;
          xml.responseXML = io.contentWindow.document.XMLDocument?io.contentWindow.document.XMLDocument:io.contentWindow.document;
        }else if(io.contentDocument){
          xml.responseText = io.contentDocument.document.body?io.contentDocument.document.body.innerHTML:null;
          xml.responseXML = io.contentDocument.document.XMLDocument?io.contentDocument.document.XMLDocument:io.contentDocument.document;
        }
      }catch(e){
        jQuery.handleError(s, xml, null, e);
      }

      if( xml || isTimeout == "timeout"){    
        requestDone = true;
        var status;
        try {
          status = isTimeout != "timeout" ? "success" : "error";
          // Make sure that the request was successful or notmodified
          if( status != "error" ){
            // process the data (runs the xml through httpData regardless of callback)
            var data = jQuery.uploadHttpData( xml, s.dataType );
            if( s.success ){
              // ifa local callback was specified, fire it and pass it the data
              s.success( data, status );
            }; 
            if( s.global ){
              // Fire the global callback
              jQuery.event.trigger( "ajaxSuccess", [xml, s] );
            }; 
          } else{
            jQuery.handleError(s, xml, status);
          }
        } catch(e){
          status = "error";
          jQuery.handleError(s, xml, status, e);
        }; 
        if( s.global ){
          // The request was completed
          jQuery.event.trigger( "ajaxComplete", [xml, s] );
        };

        // Handle the global AJAX counter
        if(s.global && ! --jQuery.active){
          jQuery.event.trigger("ajaxStop");
        };

        if(s.complete){
          s.complete(xml, status);
        } ; 

        jQuery(io).unbind();

        setTimeout(function(){ 
          try {
            jQuery(io).remove();
            jQuery(form).remove();
          } catch(e){
            jQuery.handleError(s, xml, null, e);
          } 
        }, 100);

        xml = null;
      };
    }

    // Timeout checker
    if( s.timeout > 0 ) 
    {
      setTimeout(function(){
        if( !requestDone ){
          // Check to see ifthe request is still happening
          uploadCallback( "timeout" );
        }
      }, s.timeout);
    }
    try {
      var form = jQuery('#' + formId);
      jQuery(form).attr('action', s.url);
      jQuery(form).attr('method', 'POST');
      jQuery(form).attr('target', frameId);
      if(form.encoding){
        form.encoding = 'multipart/form-data'; 
      }else{
        form.enctype = 'multipart/form-data';
      }
      jQuery(form).submit();
    } catch(e) { 
      jQuery.handleError(s, xml, null, e);
    }
    if(window.attachEvent){
      document.getElementById(frameId).attachEvent('onload', uploadCallback);
    }
    else{
      document.getElementById(frameId).addEventListener('load', uploadCallback, false);
    } 
    return {abort: function () {}};
  },

  uploadHttpData: function( r, type ) {
    var data = !type;
    data = type == "xml" || data ? r.responseXML : r.responseText;
    // ifthe type is "script", eval it in global context
    if( type == "script" ){
      jQuery.globalEval( data );
    }
    // Get the JavaScript object, ifJSON is used.
    if( type == "json" ){
      eval( "data = " + data );
    }
    // evaluate scripts within html
    if( type == "html" ){
      jQuery("<div>").html(data).evalScripts();
    }
    return data;
  }
});

function ajaxUploadFile(url, element, allcomplete, loadstart){
	var $ = jQuery;
	var elementId = $(element).attr('id');
	var stting = {
        url: url, //用于文件上传的服务器端请求地址
        secureuri: false, //一般设置为false
        fileElement: $(element)[0],
        fileElementName: 'files[]',
        dataType: 'HTML', //返回值类型 一般设置为json
        success: function (data, status)  //服务器成功响应处理函数
        {
        	if(allcomplete){
        		allcomplete(data);
        	}else if(elementId){
        		data = data.split('|');
        		var img = $('img[for="'+elementId+'"]');
        		if(img.length>0){
        			img.attr('src', getContextPath()+data[0]);
              if (data.length > 1) {
                  img.attr('alt', data[1]);
                  img.attr('title', data[1]);
              }
        		}
        		var input = $('input[for="'+elementId+'"]');
        		if(input.length>0){
        			input.val(data[0]);
        		}
        		var span = $('span[for="'+elementId+'"');
        		if(span.length>0){
        			if(data.length>1){
        				span.text(data[1]);
        				var fn = $('input[for="'+elementId+'_filename"]');
                		if(fn.length>0){
                			fn.val(data[1]);
                		}
        			}
        			else span.text(data[0]);
        		}
        	}
        },
        error: function (data, status, e)//服务器响应失败处理函数
        {
            alert(e);
        }
    };
	if(loadstart){
		stting.loadstart = loadstart;
	}
	
	$.ajaxFileUpload(stting);
}

function getContextPath() { 
	if(typeof contentPath!='undefined') return contentPath+"/";
	if(typeof ContentPath!='undefined') return ContentPath+"/";
	if(typeof contentpath!='undefined') return contentpath+"/";
	return "./"; 
} 

function replacePhoto(url, obj,img){
	ajaxUploadFile(url, obj, function(resp){
		$(img).attr('src',resp);
	});
}

$(function(){
	$('input[type="file"][ajaxUpload]').each(function(){
		$(this).on('change',function(){
			ajaxUploadFile($(this).attr('ajaxUpload'), this);
		});
	});
});