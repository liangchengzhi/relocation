//navigation submenu control
$(document).ready(function () {
    var subNav = {};
    $('[_t_nav]').hover(function () {
        var _nav = $(this).attr('_t_nav');
        clearTimeout(subNav[_nav + '_timer']);
        subNav[_nav + '_timer'] = setTimeout(function () {
            $('[_t_nav]').each(function () {
                $(this)[_nav == $(this).attr('_t_nav') ? 'addClass' : 'removeClass']('nav-up-selected');
            });
            $('#' + _nav).stop(true, true).slideDown(300);
        }, 150);
    }, function () {
        var _nav = $(this).attr('_t_nav');
        clearTimeout(subNav[_nav + '_timer']);
        subNav[_nav + '_timer'] = setTimeout(function () {
            $('[_t_nav]').removeClass('nav-up-selected');
            $('#' + _nav).stop(true, true).slideUp(300);
        }, 150);
    });
});//end of navigation submenu control


//scrolltotop control
var scrolltotop = {
    setting: { startline: 100, scrollto: 0, scrollduration: 500, fadeduration: [500, 100] },
    controlHTML: '<img src="/AAtravel/Images/Shared/go-top.png" />',
    controlattrs: { offsetx: 10, offsety: 200 },
    anchorkeyword: '#header',
    state: { isvisible: false, shouldvisible: false },

    scrollup: function () {
        if (!this.cssfixedsupport) {
            this.$control.css({ opacity: 0 })
        };
        var dest = isNaN(this.setting.scrollto) ? this.setting.scrollto : parseInt(this.setting.scrollto);
        if (typeof dest == "string" && jQuery('#' + dest).length == 1) {
            dest = jQuery('#' + dest).offset().top;
        } else {
            dest = this.setting.scrollto;
        };
        this.$body.animate({ scrollTop: dest }, this.setting.scrollduration);
    },

    keepfixed: function () {
        var $window = jQuery(window);
        var controlx = $window.scrollLeft() + $window.width() - this.$control.width() - this.controlattrs.offsetx;
        var controly = $window.scrollTop() + $window.height() - this.$control.height() - this.controlattrs.offsety;
        this.$control.css({ left: controlx + 'px', top: controly + 'px' });
    },

    togglecontrol: function () {

        var scrolltop = jQuery(window).scrollTop();
        if (!this.cssfixedsupport) {
            this.keepfixed();
        };
        this.state.shouldvisible = (scrolltop >= this.setting.startline) ? true : false;
        if (this.state.shouldvisible && !this.state.isvisible) {
            this.$control.stop().animate({ opacity: 1 }, this.setting.fadeduration[0]);
            this.state.isvisible = true;
        }
        else if (this.state.shouldvisible == false && this.state.isvisible) {
            this.$control.stop().animate({ opacity: 0 }, this.setting.fadeduration[1]);
            this.state.isvisible = false;
        }
    },

    init: function () {
        jQuery(document).ready(function ($) {
            var mainobj = scrolltotop;
            var iebrws = document.all;
            mainobj.cssfixedsupport = !iebrws || iebrws && document.compatMode == "CSS1Compat" && window.XMLHttpRequest; //not IE or IE7+ browsers in standards mode
            mainobj.$body = (window.opera) ? (document.compatMode == "CSS1Compat" ? $('html') : $('body')) : $('html,body');

            //contain #goTop div
            mainobj.$control = $('<div id="goTop">' + mainobj.controlHTML + '</div>')
				.css({ position: mainobj.cssfixedsupport ? 'fixed' : 'absolute', bottom: mainobj.controlattrs.offsety, right: mainobj.controlattrs.offsetx, opacity: 0, cursor: 'pointer',zIndex: 1000 })
				.click(function () { mainobj.scrollup(); return false; })
				.appendTo('body');

            if (document.all && !window.XMLHttpRequest && mainobj.$control.text() != '') {//loose check for IE6 and below, plus whether control contains any text
                mainobj.$control.css({ width: mainobj.$control.width() }); //IE6- seems to require an explicit width on a DIV containing text
            };

            mainobj.togglecontrol();

            //click control
            $('a[href="' + mainobj.anchorkeyword + '"]').click(function () {
                mainobj.scrollup();
                return false;
            });

            $(window).bind('scroll resize', function (e) {
                mainobj.togglecontrol();
            });
        });
    }
};

scrolltotop.init();
//end scrolltotop control 


//calendar
$(function () {
$('.date_has_event').each(function () {
    // options
    var distance = 10;
    var time = 250;
    var hideDelay = 500;

    var hideDelayTimer = null;

    // tracker
    var beingShown = false;
    var shown = false;

    var trigger = $(this);
    var popup = $('.events ul', this).css('opacity', 0);

    // set the mouseover and mouseout on both element
    $([trigger.get(0), popup.get(0)]).mouseover(function () {
        // stops the hide event if we move from the trigger to the popup element
        if (hideDelayTimer) clearTimeout(hideDelayTimer);

        // don't trigger the animation again if we're being shown, or already visible
        if (beingShown || shown) {
            return;
        } else {
            beingShown = true;

            // reset position of popup box
            popup.css({
                bottom: 20,
                left: -76,
                display: 'block' // brings the popup back in to view
            })

            // (we're using chaining on the popup) now animate it's opacity and position
            .animate({
                bottom: '+=' + distance + 'px',
                opacity: 1
            }, time, 'swing', function() {
                // once the animation is complete, set the tracker variables
                beingShown = false;
                shown = true;
            });
        }
    }).mouseout(function () {
        // reset the timer if we get fired again - avoids double animations
        if (hideDelayTimer) clearTimeout(hideDelayTimer);

        // store the timer so that it can be cleared in the mouseover if required
        hideDelayTimer = setTimeout(function () {
            hideDelayTimer = null;
            popup.animate({
                bottom: '-=' + distance + 'px',
                opacity: 0
            }, time, 'swing', function () {
                // once the animate is complete, set the tracker variables
                shown = false;
                // hide the popup entirely after the effect (opacity alone doesn't do the job)
                popup.css('display', 'none');
            });
        }, hideDelay);
    });
});
});
//end of calendar

//searchbar for places
$(document).ready(function () {
    $(".absoluteFormSearch").each(function () {
            $(this).css('opacity', '0.7');
        }).hover(function () {
            $(this).animate({ opacity: 1.0 });
        }, function () {
            $(this).animate({ opacity: 0.7 });
    });
});
//end of searchbar for places

//animationBox
$(document).ready(function () {
    $(".animationBox").each(function () {
        var time = 400;
        var hideDelay = 300;

        var hideDelayTimer = null;

        // tracker
        var beingShown = false;
        var shown = false;

        var trigger = $(this);

        //var mask = $('.mask', this);
        var showtext = $('.text', this);

        $([trigger.get(0), showtext.get(0)]).mouseover(function () {
            if (hideDelayTimer) clearTimeout(hideDelayTimer);

            if (beingShown || shown) {
                return;
            } else {
                beingShown = true;

                showtext.animate({
                    top: 80,
                }, time, 'swing', function () {
                    beingShown = false;
                    shown = true;
                });              

                //mask.css({
                //    display: 'block'
                //}).animate({
                //    opacity: 0.7
                //}, time, 'swing', function () {
                //    beingShown = false;
                //    shown = true;
                //});
            }
        }).mouseout(function () {
            if (hideDelayTimer) clearTimeout(hideDelayTimer);

            hideDelayTimer = setTimeout(function () {
                hideDelayTimer = null;
                showtext.animate({
                    top: 160,
                }, time, 'swing', function () {
                    shown = false;
                });               

                //mask.animate({
                //    opacity: 0
                //}, time, 'swing', function () {
                //    shown = false;
                //});
            }, hideDelay);
        });
    });
});
//end of animationBox

//banner animation
$(document).ready(function () {
    startTimer();

    //var mask = $('.mask', this);
    var showtext = $('.text', this);

    /** Main Slider **/
    var timer;
    var slideCount = $('#banner .bottomControl li').length;
    var currSlide = $('#banner .bottomControl li').filter('.curr').index();
    var nextSlide = currSlide + 1;
    var fadeSpeed = 1000;

    //Start slides timer functions
    function startTimer() {
        timer = setInterval(function () {
            $('#banner .bannerSlides .slideItem').eq(currSlide).fadeOut(fadeSpeed);
            $('#banner .bannerSlides .slideItem').removeClass('currItem');
            $('#banner .bottomControl li').removeClass('currBottom');
            $('#banner .bannerControl li').removeClass('curr');

            $('.slideItem').eq(nextSlide).addClass('currItem').fadeIn(fadeSpeed);
            $('#banner .bottomControl li').eq(nextSlide).addClass('currBottom');
            $('#banner .bannerControl li').eq(nextSlide).addClass('curr');
                
            currSlide = nextSlide;
            nextSlide = currSlide + 1 < slideCount ? currSlide + 1 : 0;
        }, 6000);
    }

    $('#banner .bannerControl li, #banner .bottomControl li').click(function () {
            clearInterval(timer);
            startTimer();
            currSlide = $(this).index();
            nextSlide = currSlide + 1 < slideCount ? currSlide + 1 : 0;

            $('#banner .bannerSlides .slideItem').fadeOut(fadeSpeed);
            $('#banner .bannerSlides .slideItem').removeClass('currItem');
            $('#banner .bottomControl li').removeClass('currBottom');
            $('#banner .bannerControl li').removeClass('curr');

            $('#banner .bannerSlides .slideItem').eq($(this).index()).addClass('currItem').fadeIn(fadeSpeed);
            $('#banner .bottomControl li').eq(currSlide).addClass('currBottom');
            $('#banner .bannerControl li').eq(currSlide).addClass('curr');
        });
        
    
});
//end of banner animation


//mall nav
$(document).ready(function () {
    $(".J_MenuItem").each(function (index) {
        $(this).mouseover(function () {

            var catTop,
				borderTop = $(this).offset().top - 85,
				viewHeight = $(window).height(),
				scrollTop = $(document).scrollTop(),
				relaxHeight = viewHeight - (borderTop - scrollTop);

            $(".border").css("top", borderTop).show();
            $(".cat-subcategory").show();
            $(".shadow div").hide().eq(index).show();

            var catHeight = $(".cat-subcategory").height();
            if (catHeight <= relaxHeight) {
                catTop = borderTop;
            } else if (catHeight > relaxHeight && catHeight < viewHeight) {
                catTop = scrollTop + viewHeight - catHeight - 10;
            } else {
                catTop = scrollTop + 5;
            }
            $(".cat-subcategory").css("top", catTop);

            $("span").show();
            $(this).find("span").hide();
        });

        $(".mallCategory").mouseleave(function () {
            $(".cat-subcategory").hide();
            $(".border").hide();
            $("span").show();
        });

    });
});
//end of mall nav


//mall-pro-detail-tab-control
$(document).ready(function($){	
    //左右滑动选项卡切换
    $("#pro-detail-tab-control").each(function(){
        $("#pro-detail-tab-control li").click(function () {
                var selectId = $(this).attr("id");
                
                $(this).parent().find('li.current').removeClass('current');
                $(this).addClass('current');
            //id-tab-feature-area -> id-pro-feature-area
                var targetId = selectId.replace("-tab-", "-pro-");
                $('#'+ targetId).parent().children().addClass('hide');
                $('#'+ targetId).removeClass('hide');
        })
    });
});

//end of mall-pro-detail-tab-control

