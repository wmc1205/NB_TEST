<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<script>
$(function(){
	
	getSearchList(1);
	
});

$("#listSize").change(function(){
	getSearchList(1);
})


</script>


<body>
	<div class="root">
		<form id="searchForm" name="searchForm" >
		<table id="upper">
			<tr>
				<th>Type</th>
				<td>Internal</td>
				<th>Title</th>
				<td><input type="search"  id="title" name="title" value="${param.title}"></td>
				<th>Label</th>
				<td><select name="type" id="type">
					<option	${param.type =='' ? 'selected' : ''} 	value="">---</option>
					<option ${param.type == 'A' ? 'selected':''} 	value="A">All</option>
					<option ${param.type == 'C' ? 'selected':''}	value="C">Customer</option>
					<option ${param.type == 'B' ? 'selected':''}	value="B">Bank</option>
				</select></td>
			</tr>
			<tr>
				<th>Valid</th>
				<td>
				<select name="validType" id="validType">
					<option value="0">valid</option>
					<option value="1">expired</option>
				</select>
				</td>
				<th>Registor</th>
				<td><input type="search" name="reg_user" id="reg_user" value="${param.regUser }" placeholder="registor"></td>
				
				<td colspan="2">
				<input type="button" onclick="getSearchList()" value="searchBtn">
				
				</td>
				

			</tr>
		</table>
		</form>
			<div class="buttons">
				<button id="addBtn">add</button>
			</div>
		</div>
			
		<br><br>
		
		<div id="TBroot">
			<table id="boardTB">
				<thead>
					<tr>
						<th>Type</th>
						<th>Title</th>
						<th>Valid date from</th>
						<th>Valid date to</th>
						<th>Registor</th>
						<th>Registrated date time</th>
					</tr>
				</thead>
				<tbody id="listInfo">
				</tbody>
			</table>
		
			
	<div id="paging">
		<ul id="paginationBox" class="pagination">
		</ul>
	</div>
	</div>
	<!-- 페이지 목록 갯수   -->
		<div class="form-group row justify-content-center">
			<p>게시판 목록 갯수</p>
			<div class="w100" style="padding-right: 10px">
				<select id="listSize" class="form-control form-control-sm">
					<option value="10">10 개</option>
					<option value="15">15 개</option>
					<option value="20">20 개</option>
				</select>
			</div>
		</div>

		<div id="addModal" class="hidden">
			<div class="addModalContent">
			<h2>add notice</h2>
			<div>
			<a href="${cpath }"><button>go to list</button></a>
			
			</div>
				<form>
				<input type="reset" value="clear">
			<table id="addTable">
				<tr>
					<th>title</th>
					<td colspan="5"><input type="text" name="title" placeholder="insert title"></td>
				</tr>
				<tr>
					<th>Type</th>
					<td>
					<select>
						<option value="internal">internal</option>
					</select>
					</td>
					<th>Valid date from</th>
					<td><input type="date" name="start_dt"></td>
					<th>Valid date to</th>
					<td><input type="date" name="end_dt"></td>
				</tr>
				<tr>
				<th>Registrator</th>
				<td><input type="text" name="reg_user"></td>
				<th>Label</th>
				<td colspan="3">
					<select name="type">
						<option value="A">all</option>
						<option value="C">customer</option>
						<option value="B">bank</option>
					</select>
				 </td>
				</tr>
				<tr>
					<th>content</th>
					<td colspan="5"><textarea id="add_content" name="contents" rows="5" cols="33"></textarea></td>
				</tr>
				
			</table>
			<p><input type="submit" value="save"></p>
			</form>		
			</div>
			<div class="modal_layer"></div>
			</div>

		
		<div id="editModal" class="hidden">
			<div id="editModalContent"></div>
			<div class="modal_layer"></div>
		
		</div>

	<div id="selectInfoModal" class="hidden">
	    <div class="modal_content"></div>
        <div class="modal_overlay"></div>
	</div>
	
	
	
	<script>
		//addModal open 
		document.getElementById('addBtn').onclick = function(){
		document.getElementById("addModal").style.display="block";
		}
		
		const insertForm = document.forms[1]
		
		const modal_content = document.querySelector('#selectInfoModal>.modal_content')
		const modal_overlay = document.querySelector('#selectInfoModal >.modal_overlay')
		
		
		insertForm.addEventListener('submit',insertHandler)
		
		
        modal_overlay.addEventListener('click',closeModal)

	
	</script>
	
</body>
</html>