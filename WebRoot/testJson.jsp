<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'testJson.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.4.4.min.js"></script>
	<script type="text/javascript">
		function requestJson(){
					$.ajax({
				type:'post',
				url:'${pageContext.request.contextPath }/requestJson.action',
				
				//下面的格式是说明输入的是json 
				contentType:'application/json;charset=utf-8',
				//数据格式是json串，商品信息
				data:'{"name":"手机","price":999}',
				success:function(data){//返回json结果
					alert(data.name+data.price);
				}
				
			});
		}
		function responseJson(){
			$.ajax({
				type:'post',
				url:'${pageContext.request.contextPath }/responseJson.action',
				//数据格式是json串，商品信息
				data:'name=电脑&price=555',
				//回调函数
				success:function(data){//返回json结果
					alert(data.name);
				}
				
			});
		}
		
		
	</script>
	
	
	
  </head>
  
  <body>
    <input type="button" onclick="requestJson()" value="吧json转化为 json"/>
    <input type="button" onclick="responseJson()" value="吧key/value转化为 json"/>
  </body>
</html>
