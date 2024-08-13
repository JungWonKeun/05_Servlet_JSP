<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Yukpoyum 서버</title>
  <link rel="stylesheet" href="/resources/css/main.css">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>회원 관리 프로그램</title>
  <link rel="stylesheet" href="/resources/css/main.css">
</head>
<body>
  <h1>Membership</h1>
  <div class="container">
  	<div class="center">
        <button class="button button-first" data-type="square">
          <a href="/signUp">Join(add)</a>
        </button>
        <button class="button button-second" data-type="circle">
          <a href="/selectList">Lookup</a>
        </button>
  	</div>
 </div>
 
  <c:if test="${not empty sessionScope.message}" >
    <script>
      alert( "${message}" );    
    </script>
    <c:remove var="message" scope="session" />
  </c:if>
  <script src="/resources/js/selectList.js"></script>
</body>
</html>
