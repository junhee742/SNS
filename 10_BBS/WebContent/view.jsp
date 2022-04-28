<%@page import="com.mystudy.bbs.vo.CommentVO"%>
<%@page import="java.util.List"%>
<%@page import="com.mystudy.bbs.vo.BBSVO"%>
<%@page import="com.mystudy.bbs.dao.DAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- 전달받은 파라미터 값 b_idx
	1. 게시글 조회수 1 증가(실습)
	2. 게시글(b_idx) 데이터 조회 후 화면 표시
	3. 게시글(b_idx)에 딸린 댓글이 있으면 화면 표시
--%>
<%
//파라미터 값 추출(확인)
	String b_idx = request.getParameter("b_idx");
	String cPage = request.getParameter("cPage");
	
	//1. 게시글 조회수 1 증가(실습)
	
	//2. 게시글(b_idx) 데이터 조회 후 화면 표시
	int bIdx = Integer.parseInt(b_idx);
	BBSVO bvo =  DAO.selectOne(bIdx);
	System.out.println("> bvo : " + bvo);
	//3. 게시글(b_idx)에 딸린 댓글이 있으면 화면 표시
	List<CommentVO> list = DAO.getCommList(bIdx);
	System.out.println("> Comment list : " + list);
	//EL, JSTL 사용을 위한 scope 상에 속성 등록하기
	session.setAttribute("bvo", bvo); //게시글 데이터
	session.setAttribute("cPage", cPage); 
	
	pageContext.setAttribute("c_list", list); //댓글 목록
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글상세</title>
<script>
	function modify_go() {
		location.href = "modify.jsp";
		
	}
	function delete_go() {
		location.href = "delete.jsp";
	}
	function list_go() {
		location.href = "list.jsp?cPage=3";
	}
</script>
</head>
<body>
	
<div id="bbs">
	<%-- 게시글 내용 표시 --%>
	<table>
		<caption>상세보기</caption>
		<tbody>
			<tr>
				<th>제목</th>
				<td>${bvo.subject }</td>
			</tr>
			<tr>
				<th>작성자</th>
				<td>${bvo.writer }</td>
			</tr>
			<tr>
				<th>첨부파일</th>
				<td>
					<c:if test="${empty bvo.file_name }">
						첨부파일 없당
					</c:if>
					<c:if test="${not empty bvo.file_name }">
						<a href="download.jsp?f_name=${bvo.file_name }">${bvo.ori_name }</a>
					</c:if>
				</td>
			</tr>
			<tr>
				<th>내용</th>
				<td>${bvo.content }</td>
			</tr>
		</tbody>
		<tfoot>	
			<tr>
				<td colspan="2">
					<input type="button" value="수정(작성실습)" onclick="modify_go()">
					<input type="button" value="삭제(작성실습)" onclick="delete_go()">
					<input type="button" value="목록보기" onclick="list_go()">
				</td>
			</tr>
			
		</tfoot>
	</table>
	<hr>
	
	<%-- 게시글에 대한 댓글 작성 영역 --%>
	<form action="ans_write_ok.jsp" method="post">
		<p>
			작성자 : <input type="text" name="writer">
		 	비밀번호 : <input type="password" name="pwd">
		</p>
		<p>내용 : <textarea name="content" rows="4" cols="55"></textarea> </p>
		<input type="submit" value="댓글저장">
		<input type="hidden" name="b_idx" value="10-수정하자">
	</form>
	<hr>
	
	
	<%-- 게시글에 작성된 댓글 표시 영역 --%>
	<c:forEach var="commVO" items="${c_list }">
	<div class="comment">
		<form action="ans_del.jsp" method="post">
			<p>작성자 : ${commVO.writer } &nbsp;&nbsp; 작성일 : ${commVO.write_date }</p>
			<p>내용 : ${commVO.content }</p>
			<input type="submit" value="댓글삭제">
			<input type="hidden" name="c_idx" value="${commVO.c_idx }">
			<%-- 댓글 삭제 후 게시글 상세페이지로 이동시 사용 목적 --%>
			<input type="hidden" name="b_idx" value="${commVO.b_idx }">
		</form>
	</div>
		<hr>
	</c:forEach>
	
	
	
</div>
</body>
</html>
















