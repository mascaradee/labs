<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

### fmt:setLocale
<br/>
<%=response.getLocale()%> <!-- ko_KR -->
<br/>
<fmt:setLocale value="ko"/>
<%=response.getLocale()%> <!-- ko -->
<br/>
<fmt:setLocale value="ja"/>
<%=response.getLocale()%> <!-- ja -->
<br/>
<fmt:setLocale value="en"/>
<%=response.getLocale()%> <!-- en -->
<br/>

<br/>
### fmt:setTimeZone, fmt:timeZone
<br/>
<fmt:setLocale value="ko_KR"/>
<jsp:useBean id="now" class="java.util.Date"/>

<c:out value="${now}"/>
<!-- Wed Apr 22 17:29:36 KST 2015 -->
<br/>

Seoul KST: <fmt:formatDate value="${now}" type="both" dateStyle="full" timeStyle="full"/>
<!-- 2015년 4월 22일 수요일 오후 5시 30분 40초 KST -->
<br/>

<fmt:timeZone value="GMT">
London GMT: <fmt:formatDate value="${now}" type="both" dateStyle="full" timeStyle="full"/>
</fmt:timeZone>
<!-- 2015년 4월 22일 수요일 오전 8시 30분 40초 GMT -->
<br/>

<fmt:timeZone value="GMT-8">
NewYork GMT-8: <fmt:formatDate value="${now}" type="both" dateStyle="full" timeStyle="full"/>
</fmt:timeZone>
<br/>
<br/> 

### fmt:bundle, fmt:setBundle, fmt:message
<br/>
<%-- <fmt:setLocale value="en" />  영어로 보고싶을때 주석풀기--%> 
<fmt:bundle basename="bundle.TestBundle">
<%-- <fmt:bundle basename="labs.src.main.resources.messages.TestBundle"> 경로를 찾지 못함. --%>
<fmt:message key="TITLE" var="title"/>
<html> 
	<head> 
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
	</head> 
	<body>
		<p>${title}</p>  
		<fmt:message key="COUNTRY"/> 
		<br> 
		<fmt:message key="WELCOME">
 			<fmt:param value="${param.id}"/> <%--왜 안나오눈지 몰겠다 --%>
		</fmt:message> 
		<br/>로그: <c:out value="${param.id}"></c:out>
	</body> 
</html> 
</fmt:bundle>
<br/>

<br/>
### fmt:formatNumber
<br/>
<p>number  : <fmt:formatNumber value="1234567.89" type="number"/></p>
<p>currency : <fmt:formatNumber value="1234567.89" type="currency" currencySymbol="￦" /> </p>
<p>percent : <fmt:formatNumber type="percent">0.159</fmt:formatNumber></p>
<p>pattern=".000"    :<fmt:formatNumber value="1234567.1" pattern=".000" /></p>
<p>pattern="#,#00.0#":<fmt:formatNumber value="1234567.891" pattern="#,#00.0#"/></p>
<br/>

<br/>
### fmt:parseNumber
<br/>
<p>number  : <fmt:parseNumber value="1,234,567.89" type="number"/></p>
<p>currency : <fmt:parseNumber value="12345.1234abcdef" integerOnly="false" type="number" /></p>
<br/>

<br/>
### fmt:formatDate
<br/>
<c:set var="now" value="<%= new java.util.Date() %>" />
<p> date full : <fmt:formatDate value="${now}" type="date" dateStyle="full" /></p>
<p> date short : <fmt:formatDate value="${now}" type="date" dateStyle="short" /></p>
<p> time : <fmt:formatDate value="${now}" type="time" /></p>
<p> both full : <fmt:formatDate value="${now}" type="both" dateStyle="full" timeStyle="full" /></p>
<p> pattern 1 : <fmt:formatDate value="${now}" pattern="yyyy-MM-dd aa hh:mm:ss" /></p>
<p> pattern 2 : <fmt:formatDate value="${now}" pattern="yyyy-MM-dd  hh:mm:ss" /></p> 
<br/>

<br/>
### fmt:formatDate
<br/>
<fmt:parseDate value="2020-12-22 17:02:23" pattern="yyyy-MM-dd HH:mm:ss" var="date" /> ${ date }
<!-- Tue Dec 22 17:02:23 KST 2020 -->

</body>
</html>