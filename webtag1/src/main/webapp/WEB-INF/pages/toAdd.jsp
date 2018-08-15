<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript"src="js/jquery-1.7.2.min.js"></script>
<script type="text/javascript">
    $(function(){
    	 $("#addButton").bind("click",function(){
    		$.ajax({
    			type:"POST",
    			url:"favorite_doAdd.action",
    			data:$("#addForm").serialize(),
    			dataType:"JSON",
    			success:function(data){
    				window.returnValue=data;//将结果的json存到window.returnValue
    				window.close();
    			}
    		}) ;
    	 });
    });
</script>

</head>
<body> 
    <form id="addForm" method="post">
         链接名：<input type="text" name="flabel" id="flabel"/><br/>
         地址：<input type="text" name="furl" id="furl" /><br/>
         类别：<input type="text" name="ftags" id="ftags"/><br/>
         描述：<textarea rows="5" cols="40" name="fdesc" id="fdesc"></textarea>
         <br/>
         <input id="addButton" type="button" value="添加"/>
    </form>
</body>
</html>