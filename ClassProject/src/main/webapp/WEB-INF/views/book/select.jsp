<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script src="http://code.jquery.com/ui/1.11.2/jquery-ui.js"></script>

<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.11.2/themes/smoothness/jquery-ui.css">
<script>
	function form_submit() { //조회
		var form = document.f;

		form.submit();
	}
	
	$(function() {
		$(".datepicker").datepicker({
			dateFormat : "yy-mm-dd"
		});
	});
</script>

<style>
.center {
    margin: auto;
}

#Table {
	background-color: #cccccc;
	pading: 5px;
}

#Table td {
	background-color: #dddddd;
}

#Table tr {
	background-color: #ffffff;
}
</style>
<title>Book</title>
</head>
<body>
	<div class ="center">
		<form method="post" name="f">
			<h1 align="center">가계부</h1>

			<table width="1300" cellpadding="0" cellspacing="1" border="0" align="center" id="Table">
				<tr>
					<td colspan="1" align="center"><input type="text" class="datepicker" name="first_date" id="first_date" value="${first_date}" style="text-align: center;"> ~ <input type="text" class="datepicker" name="last_date" id="last_date" value="${last_date}" style="text-align: center;"></td>
					<td colspan="1" align="center">
						<c:if test="${!empty typebox }">
							<select name="in_out"  id="typelist" style="width:80px;" onchange="">
								<c:forEach var="cd" items="${typebox }" varStatus="i">
									<option value="${cd.in_out }" <c:if test="${cd.in_out eq in_out }">selected</c:if>>${cd.in_out}</option>
								</c:forEach>
							</select>
						</c:if>
					</td>
					<td colspan="1" align="center">
						<c:if test="${!empty classifybox }">
							<select name="classify" id="classifylist" style="width:80px;" onchange="">
								<c:forEach var="cd" items="${classifybox }" varStatus="i">
									<option value="${cd.classify }" <c:if test="${cd.classify eq classify }">selected</c:if>>${cd.classify}</option>
								</c:forEach>
							</select>
						</c:if>
					</td>
					<td colspan="1" align="center">
					<c:if test="${!empty stypebox }">
							<select name="spend_type" id="stypelist" style="width:80px;" onchange="">
								<c:forEach var="cd" items="${stypebox }" varStatus="i">
									<option value="${cd.spend_type }" <c:if test="${cd.spend_type eq spend_type }">selected</c:if>>${cd.spend_type}</option>
								</c:forEach>
							</select>
						</c:if>
					</td>
					<td colspan="1" align="center"><input type="button" onclick="form_submit()" value="조회"></td>
				</tr>
			</table>
		</form>
			<HR width="900" color="white">

			<table width=1300 " cellpadding="0" cellspacing="1" border="0" align="center" id="Table">
				<tr>
					<td colspan="1" align="center">수입/지출</td>
					<td colspan="1" align="center">금액</td>
					<td colspan="2" align="center">분류</td>
					<td colspan="1" align="center">지불종류</td>
					<td colspan="4" align="center">부가설명</td>
					<td colspan="1" align="center">저장</td>
				</tr>
				<tr>
					<td colspan="1" align="center">
						<c:if test="${!empty typebox }">
							<select name="in_out"  id="selectInOut" style="width:80px;" onchange="">
								<c:forEach var="cd" items="${typebox }" varStatus="i">
									<option value="${cd.in_out }" <c:if test="${cd.in_out eq in_out }">selected</c:if>>${cd.in_out}</option>
								</c:forEach>
							</select>
						</c:if>
					</td>
					<td colspan="1" align="center"><input type="text" name="sum"></td>
					<td colspan="2" align="center">
						<c:if test="${!empty classifybox }">
							<select name="classify" id="selectClassify" style="width:80px;" onchange="">
								<c:forEach var="cd" items="${classifybox }" varStatus="i">
									<option value="${cd.classify }" <c:if test="${cd.classify eq classify }">selected</c:if>>${cd.classify}</option>
								</c:forEach>
							</select>
						</c:if>
					</td>
					<td colspan="1" align="center">
					<c:if test="${!empty stypebox }">
							<select name="spend_type" id="selectSpendType" style="width:80px;" onchange="">
								<c:forEach var="cd" items="${stypebox }" varStatus="i">
									<option value="${cd.spend_type }" <c:if test="${cd.spend_type eq spend_type }">selected</c:if>>${cd.spend_type}</option>
								</c:forEach>
							</select>
						</c:if>
					</td>
					<td colspan="4" align="center"><textarea name="other"></textarea></td>
					<td colspan="1" align="center"><input type="button" value="저장"></td>
				</tr>
			</table>

			<HR width="900" color="white">

			<table width="1300" cellpadding="0" cellspacing="1" border="0" align="center" id="Table">
				<tr>
					<td colspan="1" align="center">순번</td>
					<td colspan="1" align="center">날짜</td>
					<td colspan="1" align="center">수입/지출</td>
					<td colspan="1" align="center">금액</td>
					<td colspan="1" align="center">분류</td>
					<td colspan="1" align="center">지불종류</td>
					<td colspan="1" align="center">부가설명</td>
					<td colspan="1" align="center"><input type="checkbox"></td>
					<td colspan="1" align="center">삭제</td>
				</tr>

				<c:forEach items="${bookList }" var="list">
				<tr>
					<td colspan="1" align="center" onMouseOver="this.style.background='#98FB98'" onMouseOut="this.style.background='#dddddd'">${list.no }</td>
					<td colspan="1" align="center"><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${list.enterdate }" /></td>
					<td colspan="1" align="center">${list.in_out }</td>
					<td colspan="1" align="center">${list.sum }</td>
					<td colspan="1" align="center">${list.classify }</td>
					<td colspan="1" align="center">${list.spend_type }</td>
					<td colspan="1" align="center"><textarea>${list.other }</textarea></td>
					<td colspan="1" align="center"><input type="checkbox"></td>
					<td colspan="1" align="center"><input type="button" value="삭제"></td>
					</tr>
				</c:forEach>
			</table>
	</div>
</body>
</html>
