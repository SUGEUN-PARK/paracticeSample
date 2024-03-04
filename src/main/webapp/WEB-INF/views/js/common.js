function ajaxCmm(type, url, param, callback) {
    console.log("param: " + JSON.stringify(param))
    $.ajax({
     //   contentType :'application/x-www-form-urlencoded',
      //  processData : false,
        type: type,     //타입 (get, post, put 등등)
        url: url,       //요청할 서버url
        async: true,    // 비동기화 여부 (default : true)
       /* headers : {              // Http header
            "Content-Type" : "application/json",
            "X-HTTP-Method-Override" : "POST"
        },*/
       // dataType : 'json',  //데이터 타입 (html, xml, json, text 등등)
        data : param,
      /*  data : JSON.stringify({  // 보낼 데이터 (Object , String, Array)
            "username" : "iiii",
            "age" : "12"
        }),*/
        success: function(result) {
            return callback(result);
        },
        error: function(request, status, error) {
            alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
        }
    });
}