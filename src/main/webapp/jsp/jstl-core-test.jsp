<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<br/>
## c:catch 테스트
<br/>
<c:catch var="myException">
  <%= 1/0 %>
</c:catch>
Error Msg: ${myException} <br/> <%-- java.lang.ArithmeticException: / by zero --%>

<br/>
## c:choose 테스트
<br/>
<c:set var="month" value="${13}"/>
<c:choose>
  <c:when test="${month == 1}"> 이번달은 ${month}월 입니다. </c:when>
  <c:when test="${month == 12}"> 이번달은 ${month}월 입니다. </c:when>
  <c:otherwise> 잘못 넣은듯 </c:otherwise>
</c:choose>
<br/>

<br/>
## c:if 테스트
<br/>
<c:set var="applePrice" value="10000"/>
<c:if test="${applePrice > 5000}" var="apple" scope="page"> 사과는 비싸네 </c:if>
<br/>
사과는 비싸나? 
<c:if test="${apple}">응 겁나 비싸</c:if>
<br/>

<br/>
## c:import 테스트
<br/>
<br/>
<br/>
<!-- 절대경로 -->
<!-- <div> -->
<%-- 	<c:import url="https://www.daum.net"></c:import> --%>
<!-- </div> -->
<!-- 상대경로 -->
<c:import url="../jsp/jstl-core-import-test.jsp"></c:import>
<br/>

<br/>
## c:forEach 테스트
<br/>
<%
java.util.List list = new java.util.ArrayList();
java.util.Map map = new java.util.HashMap();
map.put("name","apple");
list.add(map);
map = new java.util.HashMap();
map.put("name","banana");
list.add(map);
map = new java.util.HashMap();
map.put("name","orange");
list.add(map);
request.setAttribute("fruits", list);
%>
<c:forEach var="fruit" items="${fruits}" varStatus="status">
	<p>${status.count}번 째 과일은  ${fruit.name} 이다.</p>
	<p>현재 아이템: ${status.current}</p>
	<p>현재 인덱스: ${status.index}
	<p>첫번째 아이템인지? ${status.first}</p>
	<p>마지막번째 아이템인지? ${status.last}</p>
	<p>---</p>
</c:forEach>


<c:forEach var="i" begin="1" end="10" step="2" varStatus="status">
	<p>시작인덱스: ${status.begin}</p>
	<p>종료인덱스: ${status.end}</p>
	<p>증가값: ${status.step}</p>
	<p>1부터 10까지 숫자 중 ${status.count}번 째 홀수는 무엇? ${i}</p>
	<p>---</p>
</c:forEach>
<br/>

<br/>
## c:forTokens 테스트
<br/>
<c:forTokens items="도*레*미*파*솔!라!시" delims="*!" varStatus="status">
<p>${status.current}</p>
</c:forTokens>
<br/>

<br/>
## c:out 테스트
<br/>
<c:out value="${value}" default="값 없음"/><br/>
<c:set var="outValue" value="Hello, World"></c:set>
<c:out value="${outValue}" default="값 없음"/><br/>
<c:out value="&lt; &gt;" escapeXml="true"/><br/> <!-- &amp;lt;&amp;gt; -->
<c:out value="&lt; &gt;" escapeXml="false"/><br/> <!-- &lt;&gt; -->


<br/>
## c:param 테스트
<br/>
<c:import url="../jsp/jstl-core-import-test.jsp">
	<c:param name="name" value="macs"></c:param>
	<c:param name="age" value="5"></c:param>
</c:import>


<br/>
## c:redirect 테스트
<br/>
<%-- <c:redirect url="../jsp/jstl-core-import-test.jsp"/> --%>
<br/>

<br/>
## c:remove 테스트
<br/>
<c:set var="country" value="Korea" />
set :
<c:out value="${country}"/>
<br/>
<c:remove var="country" />
remove :  
<c:out value="${country}"/>
<br/>

<br/>
## c:set 테스트
<br/>
<jsp:useBean id="map1" class="java.util.HashMap"/>
<c:set target="${map1}" property="hi" value="hello world!"/> 
<c:out value="${map1.hi}"/>

<a href="<c:url value='../jsp/jstl-core-import-test.jsp' />">
   View Test
</a>


 
</body>
</html>