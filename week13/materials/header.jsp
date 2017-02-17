<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>${title}</title>
		
		<style type="text/css">
			ul {
				font-size:20px;
			}
			
			a.navigation-link {
				border:1px solid silver;
				padding:10px;
				border-radius: 10px;
				text-decoration: none;
				color: #000000;
			    float: left;
			    border-bottom-left-radius: 0;
			    border-bottom-right-radius: 0;
			}
			a.navigation-link:hover {
				color: #cccccc;
			}
			.page-content {
				margin-top:-1px;
				border:1px solid silver;
				padding:10px;
			}
			.float-container {
				clear:both;
			}
			.navigation-link.selected {
				border-bottom:1px solid white;
				color: #aa2222;
			}
			#clock {
				background-color:#000;
				color:#fff;
				font-size:20px;
				font-weight:bold;
				padding:5px;
				border-radius:10px;
				border-bottom-left-radius:0px;
				border-bottom-right-radius:0px;
				display:inline-block;
				position:fixed;
				bottom:0px;
				right:30px;
			}
		</style>
		
		<script type="text/javascript">
			function getTime() {
				var d = new Date();
				var hours = d.getHours();
				var minutes = d.getMinutes();
				var seconds = d.getSeconds();
				
				if(hours<10) hours = "0" + hours;
				if(minutes<10) minutes = "0" + minutes;
				if(seconds<10) seconds = "0" + seconds;
				
				return hours + ":" + minutes + ":" + seconds;
			}
			
			function updateTime() {
				document.getElementById("clock").innerHTML = getTime();
			}
			
			function init() {
				setInterval(function() {
					updateTime();
				}, 1000);
			}
		</script>
	
	</head>
<body onload="init()">
	<% String servlet = (String)session.getAttribute("servletName"); %>
	<a href="/TodooList/Index" class="navigation-link <% if(servlet == "index") { %>selected<% } %>">Home</a>
	<a href="/TodooList/AboutUs" class="navigation-link <% if(servlet == "aboutUs") { %>selected<% } %>">About us</a>
	<a href="/TodooList/Index" class="navigation-link">Home</a>
	<a href="/TodooList/AboutUs" class="navigation-link">About us</a>
	<a href="/TodooList/Index" class="navigation-link">Home</a>
	<a href="/TodooList/AboutUs" class="navigation-link">About us</a>
	
	<div class="float-container" ></div>
	<div id="clock"></div>
	<div class="page-content">
	
	
	
	
	
	