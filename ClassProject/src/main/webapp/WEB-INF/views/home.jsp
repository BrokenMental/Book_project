<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<script type="text/javascript"
	src="/js/egovframework/lcms/cmm/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script src="http://code.jquery.com/ui/1.11.2/jquery-ui.js"></script>

<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.11.2/themes/smoothness/jquery-ui.css">
<script>
function form_submit(){ //조회
	var form = document.f;
	
	form.submit();	
}

function form_save(){
	var form = document.f;
	
	form.action = "/js/insTest.do"
	
	form.submit();
}

$(function() {
	$( ".datepicker" ).datepicker( {
		dateFormat:"yy/mm/dd"
	});
});
</script>

<style>
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
	<center>
		<form action="/js/test.do" method="post" name="f">
			<h1>가계부</h1>

			<table width="1300" cellpadding="0" cellspacing="1" border="0"
				align="center" id="Table">
				<tr>
					<td colspan="1" align="center"><input type="text"
						class="datepicker" name="first_date" id="first_date"
						value="${first_date}" style="text-align: center;"></td>
					<td colspan="1" align="center"><input type="text"
						class="datepicker" name="last_date" id="last_date"
						value="${last_date}" style="text-align: center;"></td>
					<td colspan="1" align="center"><select name="classify">
							<option value="미분류" selected="selected">미분류</option>
							<option value="식비">식비</option>
							<option value="주거/통신">주거/통신</option>
							<option value="생활용품">생활용품</option>
							<option value="의복/미용">의복/미용</option>
							<option value="건강/문화">건강/문화</option>
							<option value="교육/문화">교육/문화</option>
							<option value="교통/차량">교통/차량</option>
							<option value="경조사/회비">경조사/회비</option>
							<option value="세금/이자">세금/이자</option>
							<option value="용돈/기타">용돈/기타</option>
							<option value="월급">월급</option>
					</select></td>
					<td colspan="1" align="center"><select name="spend_type">
							<option value="지불 종류" selected="selected">지불 종류</option>
							<option value="현금">현금</option>
							<option value="카드">카드</option>
					</select></td>
					<td colspan="1" align="center"><input type="button"
						onclick="form_submit()" value="조회"></td>
				</tr>
			</table>

			<HR width="900" color="white">

			<table width=1300 " cellpadding="0" cellspacing="1" border="0"
				align="center" id="Table">
				<tr>
					<td colspan="1" align="center">수입</td>
					<td colspan="1" align="center">지출</td>
					<td colspan="1" align="center"><select name="classify">
							<option value="미분류" selected="selected">미분류</option>
							<option value="식비">식비</option>
							<option value="주거/통신">주거/통신</option>
							<option value="생활용품">생활용품</option>
							<option value="의복/미용">의복/미용</option>
							<option value="건강/문화">건강/문화</option>
							<option value="교육/문화">교육/문화</option>
							<option value="교통/차량">교통/차량</option>
							<option value="경조사/회비">경조사/회비</option>
							<option value="세금/이자">세금/이자</option>
							<option value="용돈/기타">용돈/기타</option>
							<option value="월급">월급</option>
					</select></td>
					<td colspan="1" align="center"><select name="spend_type">
							<option value="지불 종류" selected="selected">지불 종류</option>
							<option value="현금">현금</option>
							<option value="카드">카드</option>
					</select></td>
					<td colspan="4" align="center">부가설명</td>
					<td colspan="1" align="center">저장</td>
				</tr>
				<tr>
					<td colspan="1" align="center"><input type="text"
						name="income"></td>
					<td colspan="1" align="center"><input type="text" name="spend"></td>
					<td colspan="1" align="center"><input type="text"
						name="classify"></td>
					<td colspan="1" align="center"><input type="text"
						name="spend_type"></td>
					<td colspan="4" align="center"><textarea name="other"></textarea></td>
					<td colspan="1" align="center"><input type="button"
						onclick="form.save()" value="저장"></td>
				</tr>
			</table>

			<HR width="900" color="white">

			<table width="1300" cellpadding="0" cellspacing="1" border="0"
				align="center" id="Table">
				<tr>
					<td colspan="1" align="center">순번</td>
					<td colspan="1" align="center">날짜</td>
					<td colspan="1" align="center">수입</td>
					<td colspan="1" align="center">지출</td>
					<td colspan="1" align="center">분류</td>
					<td colspan="1" align="center">지불종류</td>
					<td colspan="3" align="center">부가설명</td>
					<td colspan="1" align="center">삭제</td>
				</tr>

				<%-- <c:forEach items="${booklist}" val="al" varStatus="i">
					<tr>
						<td colspan="1" align="center">${al.no }</td>
						<td colspan="1" align="center">${al.enterdate }</td>
						<td colspan="1" align="center">${al.income }</td>
						<td colspan="1" align="center">${al.spend }</td>
						<td colspan="1" align="center">${al.classify }</td>
						<td colspan="1" align="center">${al.spend_type }</td>
						<td colspan="1" align="center"><textarea>${al.other }</textarea></td>
						<td colspan="1" align="center"><input type="checkbox"
							name="all" id="all_chk" onclick="check()"></td>
						<td colspan="1" align="center"><input type="checkbox"
							class="chkBox" name="chk_${i.index }" value="${al.idx }"></td>
						<td colspan="1" align="center"><input type="button"
							onclick="form_delete( ${al.idx})" value="삭제"></td>
					</tr>
				</c:forEach> --%>
			</table>
		</form>
	</center>
</body>
</html>
