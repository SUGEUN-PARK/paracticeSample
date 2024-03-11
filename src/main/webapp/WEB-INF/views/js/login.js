$(function(){


    $("#ajaxLogin").click(function (){
        //let id = Math.random();
        var id = "";
        var password = "";
        id = $("#id").val();
        password = $("password").val();
        $.ajaxLogin_click(id,password);
    })
})


$.ajaxLogin_click = function (id,password){
    console.log(id)
    console.log(password)
    var type = "GET";
    var url = "http://localhost:8080/login.do";
    var param = {
        "id" : id,
        "password" : password
    };
    ajaxCmm(type,url,param,function (data) {
       console.log(data)
    });
}