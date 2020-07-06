<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>您好Springboot</title>
<!--1.引入js  -->
<script type="text/javascript" src="/js/jquery-3.5.1.min.js"></script>
<script type="text/javascript">

	/*
		2.发起ajax请求
			1. $.get()  负责查询  		    返回数据任意  人工解析
			2. $.post() 表单数据提交等           返回值类型任意 人工解析
			3. $.getJSON() 查询获取json数据
			4. $.getScript()  获取js代码片段
			5. $.ajax({.....})  万能用法
	*/
	
	/*发起ajax请求  */
	$(function(){

		//alert("页面加载完成,开始调用js");
		$.get("/findAjax",function(data){
			//目的 在table中展现数据  准备<tr>标签,之后将标签追加到table中即可.
			for(var i=0;i<data.length;i++){
				var user = data[i];
				var name = user.name;
				alert(name);
				//未完待续
			}
			//console.log(data);
		})

	})
</script>

</head>
<body>
	<table border="1px" width="65%" align="center">
		<tr>
			<td colspan="6" align="center"><h3>学生信息</h3></td>
		</tr>
		<tr>
			<th>编号</th>
			<th>姓名</th>
			<th>年龄</th>
			<th>性别</th>
		</tr>
	</table>
</body>
</html>