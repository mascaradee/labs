<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<br/>
### fn:contains
<br/>
<c:set var="name" value="가 나다라 1234bcdABCD" />
<p>contains result : ${fn:contains(name, "a")};</p> 
<br/>

### fn:containsIgnoreCase
<br/>
<c:set var="name" value="BaNAnA" />
<p>containsIgnoreCase result : ${fn:containsIgnoreCase(name, "a")};</p>
<p>containsIgnoreCase result : ${fn:containsIgnoreCase(name, "A")};</p> <%-- true --%>
<br/>

### fn:endsWith
<br/>
<c:set var="name" value="jstl-function-test.jsp" />
<p>endsWith result : ${fn:containsIgnoreCase(name, ".jsp")};</p>
<br/>

### fn:escapeXml
<br/>
<p>escapeXml result :  1 < 2</p> 
<p>escapeXml result :  &ltbr/&gt</p> 
<p>escapeXml result : ${fn:escapeXml("<br/>")};</p>  
<!-- 실제 html은 오른쪽과 같이 해석한다.  <p>escapeXml result : &lt;br/&gt;;</p>   -->
<br/>

### fn:indexOf
<br/>
<p>indexOf result : ${fn:indexOf("안녕! 난, 김씨라고 해~~!!", "!")};</p>  
<br/>

### fn:join
<br/>
<%
int[] iArr = new int[]{1, 2, 3};
%>
<c:set var="iArr" value="<%=iArr%>"/>
<p>join result : ${fn:join(iArr, "%")};</p>  
<br/>

### fn:length
<br/>
<p>length result : ${fn:length("일이삼사오")};</p>  
<br/>

### fn:replace
<br/>
<p>replace result : ${fn:replace("일이삼일사오일", "일", "1")};</p>  
<!-- replace result : 1이삼1사오1; -->
<br/>

### fn:split
<br/>
<c:set var="texts" value="${fn:split('뷔,슈가,제이홉,정국,진,지민,RM', ',')}"/>
<c:out value="${fn:join(texts, '-')}" />
<br/>

<br/>
### fn:startsWith
<br/>
<p>startsWith result : ${fn:startsWith('상품명]땡땡상품', '상품')};</p> <%-- true --%>
<br/>

<br/>
### fn:substring
<br/>
<p>substring result : ${fn:substring('상품명] 맛있는 땡땡상품이 있습니다.', 5, 10)};</p> <%-- substring result : 맛있는 땡; --%>
<br/>

<br/>
### fn:substringAfter
<br/>
<p>substringAfter result : ${fn:substringAfter('사과-바나나-귤-포도-블루베리', '-')};</p> <%-- substringAfter result : 바나나-귤-포도-블루베리; --%>
<br/>

<br/>
### fn:substringBefore
<br/>
<p>substringBefore result : ${fn:substringBefore('사과-바나나-귤-포도-블루베리', '-')};</p> <%-- substringBefore result : 바나나-귤-포도-블루베리; --%>
<br/>

<br/>
### fn:toLowerCase
<br/>
<p>toLowerCase result : ${fn:toLowerCase('The Little Prince')};</p> <%-- toLowerCase result : the little prince; --%>
<br/>

<br/>
### fn:toUpperCase
<br/>
<p>toUpperCase result : ${fn:toUpperCase('The Little Prince')};</p> <%-- toUpperCase result : THE LITTLE PRINCE;--%>
<br/>

<br/>
### fn:trim
<br/>
<p>trim result : ${fn:trim(' The Little Prince ')};</p> <%-- trim result : The Little Prince;--%>
<br/>

</body>
</html>