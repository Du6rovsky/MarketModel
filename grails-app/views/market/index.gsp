<!DOCTYPE html>
<%@page import="marketmodel.Market"%>
<%@page contentType="text/html;charset=UTF-8" %>
<html>
	<head>
		<title>Market Model Web App (powered by Grails)</title>
		<asset:stylesheet src="application.css"/>
		<asset:javascript src="jquery.js"/>
		<asset:javascript src="percented.js"/>		
        <asset:link rel="shortcut icon" href="favicon.png" type="image/x-icon"/>
	</head>
	<body>
		<h2><g:message code="label.header"/></h2>
		<g:render template="/market/inform"/>
		<div id="subtraction"></div>
	</body>
</html>
