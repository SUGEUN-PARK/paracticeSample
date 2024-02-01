$(function(){

    $("#autoWrite").click(function (){

        $.autoWrite_click();
    })

})

$.autoWrite_click = function (){
   $("#age").val(31);
   $("#username").val("testUser");

}