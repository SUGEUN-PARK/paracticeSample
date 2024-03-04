$(function(){

    $("#autoWrite").click(function (){
        $.autoWrite_click();
    })
    $("#dbInsert").click(function (){
        //let id = Math.random();
        var username = "";
        var age = "";
        username = $("#username").val();
        age = $("#age").val();
        $.dbInsert_click(username,age);
    })
})

$.autoWrite_click = function (){
   $("#age").val(31);
   $("#username").val("testUser");
}

$.dbInsert_click = function (username,age){
    console.log(username)
    console.log(age)
    var type = "GET";
    var url = "http://localhost:8080/dbInsert.do";
    var param = {
        "username" : username,
        "age" : age
    };
    ajaxCmm(type,url,param,function (data) {
       console.log(data)
    });
}