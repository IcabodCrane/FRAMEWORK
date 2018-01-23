<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="js/jquery-1.8.2.js"></script>
<script type="text/javascript" src="js/json2.js"></script>

<script type="text/javascript">
$(function() {
    $("form").submit(function () {
        var obj = new Object();
        obj.userName = $("#user_name").val();
        obj.userPw = $("#user_pw").val();
        var data = JSON.stringify(obj);
        console.log(data);
        $.ajax({
            type:"POST",
            contentType:"application/json",
            url:"${pageContext.request.contextPath }/user/registerUser.do",
            data:data,
            success : function(data) {
                console.log(typeof data);
            }
        });
    });
});
</script>
<title>注册页面</title>
</head>
<body>
	<form method="post">
    	用户名：<input type="text" id="user_name" name="userName"><br>
    	密码：&nbsp;&nbsp;&nbsp;<input type="text" id="user_pw" name="userPw"><br>
    	<input type="submit" value="注册"> ||
    	<input type="reset" value="重置">
    </form>
</body>
</html>