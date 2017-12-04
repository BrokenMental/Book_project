<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script src="http://code.jquery.com/ui/1.11.2/jquery-ui.js"></script>

<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.11.2/themes/smoothness/jquery-ui.css">
<script>

	function check() {
				
		if( $("#all_Chk").is(':checked') ) {
	    	$(".chkBox").prop("checked",true);
	    } else {
	    	$(".chkBox").prop("checked",false);
	    }
	}

	function form_submit() { //조회
		var form = document.f;

		form.submit();
	}
	
	function form_save() { //저장
		var form = document.s;

		form.submit();
	}
	
	function form_delete(idx) {
		var idx = idx;
		console.log(idx);

		$.ajax({
			type:'delete',
			url:'/delete/' + idx,
			headers: {
				"Content-Type": "application/json",
				"X-HTTP-Method-Override": "DELETE" },
			dataType: 'text',
			success:function(result){
				console.log("result: " + result);
				if(result == 'SUCCESS'){
					alert('삭제성공');
					location.reload();
				}
			}
		});
	}
	
	function form_alldelete() {
		var form = document.d;
		
		var checkRow = "";
		$(".chkBox:checked").each (function (){
			checkRow = checkRow + $(this).val()+","; 
		});
		checkRow = checkRow.substring(0,checkRow.lastIndexOf( ","));
		form.action="/deleteall?checkRow="+checkRow;
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

#number {
	width: 20px;
	border: 0px;
}
</style>
<title>Book</title>
</head>
<body>
	<div class="center">
		<form action="select" method="post" name="f">
			<h1 align="center">가계부</h1>

			<table width="1300" cellpadding="0" cellspacing="1" border="0"
				align="center" id="Table">
				<tr>
					<td colspan="1" align="center"><input type="text"
						class="datepicker" name="first_date" id="first_date"
						value="${first_date}" style="text-align: center;"> ~ <input
						type="text" class="datepicker" name="last_date" id="last_date"
						value="${last_date}" style="text-align: center;"></td>

					<td colspan="1" align="center"><c:if test="${!empty typebox }">
							<select name="in_out" id="typelist" style="width: 80px;"
								onchange="">
								<c:forEach var="cd" items="${typebox }" varStatus="i">
									<option value="${cd.in_out }"
										<c:if test="${cd.in_out eq in_out }">selected</c:if>>${cd.in_out}</option>
								</c:forEach>
							</select>
						</c:if></td>

					<td colspan="1" align="center"><c:if
							test="${!empty classifybox }">
							<select name="classify" id="classifylist" style="width: 80px;"
								onchange="">
								<c:forEach var="cd" items="${classifybox }" varStatus="i">
									<option value="${cd.classify }"
										<c:if test="${cd.classify eq classify }">selected</c:if>>${cd.classify}</option>
								</c:forEach>
							</select>
						</c:if></td>
					<td colspan="1" align="center"><c:if
							test="${!empty stypebox }">
							<select name="spend_type" id="stypelist" style="width: 80px;"
								onchange="">
								<c:forEach var="cd" items="${stypebox }" varStatus="i">
									<option value="${cd.spend_type }"
										<c:if test="${cd.spend_type eq spend_type }">selected</c:if>>${cd.spend_type}</option>
								</c:forEach>
							</select>
						</c:if></td>
					<td colspan="1" align="center"><input type="button"
						onclick="form_submit()" value="조회"></td>
				</tr>
			</table>
		</form>

		<HR width="900" color="white">

		<form action="save" method="post" name="s">
			<table width=1300 " cellpadding="0" cellspacing="1" border="0"
				align="center" id="Table">
				<tr>
					<td colspan="1" align="center">수입/지출</td>
					<td colspan="1" align="center">금액</td>
					<td colspan="2" align="center">분류</td>
					<td colspan="1" align="center">지불종류</td>
					<td colspan="4" align="center">부가설명</td>
					<td colspan="1" align="center">저장</td>
				</tr>
				<tr>
					<td colspan="1" align="center"><c:if test="${!empty typebox }">
							<select name="in_out" id="selectInOut" style="width: 80px;"
								onchange="">
								<c:forEach var="cd" items="${typebox }" varStatus="i">
									<option value="${cd.in_out }"
										<c:if test="${cd.in_out eq in_out }">selected</c:if>>${cd.in_out}</option>
								</c:forEach>
							</select>
						</c:if></td>
					<td colspan="1" align="center"><input type="text" name="sum"></td>
					<td colspan="2" align="center"><c:if
							test="${!empty classifybox }">
							<select name="classify" id="selectClassify" style="width: 80px;"
								onchange="">
								<c:forEach var="cd" items="${classifybox }" varStatus="i">
									<option value="${cd.classify }"
										<c:if test="${cd.classify eq classify }">selected</c:if>>${cd.classify}</option>
								</c:forEach>
							</select>
						</c:if></td>
					<td colspan="1" align="center"><c:if
							test="${!empty stypebox }">
							<select name="spend_type" id="selectSpendType"
								style="width: 80px;" onchange="">
								<c:forEach var="cd" items="${stypebox }" varStatus="i">
									<option value="${cd.spend_type }"
										<c:if test="${cd.spend_type eq spend_type }">selected</c:if>>${cd.spend_type}</option>
								</c:forEach>
							</select>
						</c:if></td>
					<td colspan="4" align="center"><textarea name="other"></textarea></td>
					<td colspan="1" align="center"><input type="button"
						onclick="form_save()" value="저장"></td>
				</tr>
			</table>
		</form>

		<HR width="900" color="white">

		<form method="post" name="d" id="d">

			<table width="1300" cellpadding="0" cellspacing="1" border="0"
				align="center" name="tbl_classify" id="Table">
				<tr>
					<td colspan="1" align="center">순번</td>
					<td colspan="1" align="center">날짜</td>
					<td colspan="1" align="center">수입/지출</td>
					<td colspan="1" align="center">금액</td>
					<td colspan="1" align="center">분류</td>
					<td colspan="1" align="center">지불종류</td>
					<td colspan="1" align="center">부가설명</td>
					<td colspan="1" align="center"><input type="checkbox"
						name="all" id="all_Chk" onclick="check()"></td>
					<td colspan="1" align="center">수정</td>
					<td colspan="1" align="center"><input type="button"
						onclick="form_alldelete()" value="삭제"></td>
				</tr>

				<c:forEach items="${bookList }" var="list" varStatus="i">
					<tr>
						<td colspan="1" align="center">${i.count }(<input type="text"
							readonly=readonly value="${list.no }" name="number" id="number">)
						</td>
						<td colspan="1" align="center"><fmt:formatDate
								pattern="yyyy-MM-dd HH:mm" value="${list.enterdate }" /></td>
						<td colspan="1" align="center">${list.in_out }</td>
						<td colspan="1" align="center"><input type="text"
							value="${list.sum }" id="sum_${list.no }"></td>
						<td colspan="1" align="center"><c:if
								test="${!empty classifybox }">
								<select name="classify" id="classify_${list.no }" style="width: 80px;"
									onchange="">
									<c:forEach var="cd" items="${classifybox }" varStatus="i">
										<option id="u_classify_${list.no }" value="${cd.classify }"
											<c:if test="${cd.classify eq list.classify }">selected</c:if>>${cd.classify}
										</option>
									</c:forEach>
								</select>
							</c:if></td>
						<td colspan="1" align="center">${list.spend_type }</td>
						<td colspan="1" align="center"><input type="text"
							value="${list.other }" id="other_${list.no }"></td>
						<td colspan="1" align="center"><input type="checkbox"
							class="chkBox" name="chk_${i.index }" value="${list.no }"></td>
						<td colspan="1" align="center"><input type="button"
							onclick="form_update(${list.no })" id="btnupd" value="수정"></td>
						<td colspan="1" align="center"><input type="button"
							onCLick="form_delete(${list.no })" id="btndel" value="삭제"></td>
					</tr>
					<input type="hidden" name="idx_${i.index }" value="${list.no }">
					<input type="hidden" name="in_out_${i.index }"
						value="${list.in_out }">
					<input type="hidden" name="sum_${i.index }" value="${list.sum }">
					<input type="hidden" name="classify_${i.index }"
						value="${list.classify }">
					<input type="hidden" name="spend_type_${i.index }"
						value="${list.spend_type }">
					<input type="hidden" name="other_${i.index }"
						value="${list.other }">
				</c:forEach>
			</table>
		</form>
	</div>
<script>

function form_update(idx) {
	var idx = idx; 
	var sum = document.getElementById("sum_"+idx).value;
	var classify = document.getElementById("classify_"+idx);
	var u_classify = classify.options[classify.selectedIndex].value;
	var other = document.getElementById("other_"+idx).value;
	console.log(idx);
	console.log(sum);
	console.log(u_classify);
	console.log(other);
	
	$.ajax({
		type:'put',
		url:'/update/' + idx,
		headers: {
			"Content-Type": "application/json",
			"X-HTTP-Method-Override": "PUT" },
		data:JSON.stringify({idx:idx, sum:sum, classify:u_classify, other:other}),
		dataType: 'text',
		success:function(result){
			console.log("result: " + result);
			if(result == 'SUCCESS'){
				alert('수정성공');
				location.reload();
			}
		}
	});
}
</script>
</body>
</html>
