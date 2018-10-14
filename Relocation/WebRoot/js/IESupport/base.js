if(document.addEventListener){//非IE6~IE8
	
}


Function.prototype.method = function(name, func) {
	this.prototype[name] = func;
	return this;
};


if (!String.prototype.trim) { 
	String.method('trim', function() {
		return this.replace(/^s+|s+$/g, '');
	});
	String.method('ltrim', function() {
		return this.replace(/^s+/g, '');
	});
	String.method('rtrim', function() {
		return this.replace(/s+$/g, '');
	});
}


(function(){
	if(document.addEventListener){//非IE6~IE8
		return ;
	}

	if (!Object.create) {
		Object.create = function (o) {
			if (arguments.length > 1) {
				throw new Error('Object.create implementation only accepts the first parameter.');
			}
			function F() {}
			F.prototype = o;
			return new F();
		};
	}
	
	if (!Object.keys) {
		Object.keys = function(o) {
			if (o !== Object(o)) {
				throw new TypeError('Object.keys called on a non-object');
			}
			var k=[], p;
			for (p in o) {
				if (Object.prototype.hasOwnProperty.call(o,p)) {
					k.push(p);
				}
			}
			return k;
		};
	}
	
	if (!Function.prototype.bind) {
	  	Function.prototype.bind = function (oThis) {
			if (typeof this !== "function") {
		  		// closest thing possible to the ECMAScript 5 internal IsCallable function
		  		throw new TypeError("Function.prototype.bind - what is trying to be bound is not callable");
			}
	
			var aArgs = Array.prototype.slice.call(arguments, 1), 
				fToBind = this, 
				fNOP = function () {},
				fBound = function () {
			  		return fToBind.apply(this instanceof fNOP && oThis
									 ? this
									 : oThis || window,
								   aArgs.concat(Array.prototype.slice.call(arguments)));
				};
	
			fNOP.prototype = this.prototype;
			fBound.prototype = new fNOP();
	
			return fBound;
	  	};
	}
	
	if (typeof Array.prototype.forEach != "function") {
	  	Array.prototype.forEach = function (fn, scope) {
			var i, len;
			for (i = 0, len = this.length; i < len; ++i) {
				if (i in this) {
					fn.call(scope, this[i], i, this);
				}
			}
		};
	}

})();
