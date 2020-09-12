/* global $ */
/* eslint-env jquery */
    
/* For sticky navigation*/

$('document').ready(function(){
    $('.js--section-features').waypoint(function(direction){
    if(direction == "down"){
        $("nav").addClass("sticky");
    } else {
        $("nav").removeClass("sticky");
    }
    }, { offset: '60px;'})

/*Scroll on buttons*/

    $(".js--scroll-to-plans").click(function(){
        $("html,body").animate({scrollTop : $(".js--section-plans").offset().top},500);
    });     
    
    $(".js--scroll-to-start").click(function(){
        $("html,body").animate({scrollTop : $(".js--section-features").offset().top},500);
    });
    
    /*Animations on scroll*/
    
    $('.js--wp-1').waypoint(function(direction){
        $('.js--wp-1').addClass('animate__animated animate__fadeIn')
    }, {offset: '50%;'});
    
    $('.js--wp-2').waypoint(function(direction){
        $('.js--wp-2').addClass('animate__animated animate__fadeInUp')
    }, {offset: '50%;'});
    
    $('.js--wp-3').waypoint(function(direction){
        $('.js--wp-3').addClass('animate__animated animate__fadeIn')
    }, {offset: '50%;'});
    
    $('.js--wp-4').waypoint(function(direction){
        $('.js--wp-4').addClass('animate__animated animate__pulse')
    }, {offset: '50%;'})
    
    
    /*Mobile Navigation*/
    
    $('.js--nav-icon').click(function(){
        var nav = $('.js--main-nav');        
        var icon = $('.js--nav-icon i');
        if(icon.hasClass('ion-navicon-round')){
            icon.removeClass('ion-navicon-round');    
            icon.addClass('ion-close-round');
        } else{
            icon.removeClass('ion-close-round');    
            icon.addClass('ion-navicon-round');
        }
        
        
        nav.slideToggle(200);

    })

});

