$(function(){
    alert("!!!!")

    $("#testBt").click(function (){

        $.testBt_click();
    })

})

$.testBt_click = function (){
    console.log($("#testInput").val());
}