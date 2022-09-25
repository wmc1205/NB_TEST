<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="root">
		<table id="upper">
			<tr>
				<th>Type</th>
				<td>a</td>
				<th>Title</th>
				<td>b</td>
				<th>Label</th>
				<td></td>
			</tr>
			<tr>
				<th>Valid</th>
				<td>c</td>
				<th>Registor</th>
				<td>d</td>
				<td></td>
				<td><button>search</button></td>
			</tr>
		</table>
			<div class="buttons">
				<button id="addBtn">add</button>
			</div>
		</div>
			
		<br><br>
		
		<div>
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
				<tr>
					<td>
					<select>
						<option value="A">all</option>
						<option value="C">customer</option>
						<option value="B">bank</option>
					</select>
					</td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				</thead>
				<tbody id="listInfo">
				</tbody>
			</table>
		</div>

		<div id="addModal" class="hidden">
			<div class="addModalContent">
			<h2>add notice</h2>
			<div>
			<a href="${cpath }"><button>go to list</button></a>
			<button>clear</button>
			</div>
				<form>
			<table id="addTable">
				<tr>
					<th>title</th>
					<td><input type="text" name="title" value="insert title"></td>
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
				<td>${reg_user }</td>
				<th>Label</th>
				<td>
					<select>
						<option value="A">all</option>
						<option value="C">customer</option>
						<option value="B">bank</option>
					</select>
				 </td>
				</tr>
				<tr>
					<th>content</th>
					<td><textarea id="add_content" name="contents" rows="5" cols="33"></textarea></td>
				</tr>
				
			</table>
			<p><input type="submit" value="save"></p>
			</form>		
			</div>
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

		const insertForm = document.forms[0]
		const modal_content = document.querySelector('#selectInfoModal>.modal_content')
		const modal_overlay = document.querySelector('#selectInfoModal >.modal_overlay')

		insertForm.addEventListener('submit',insertHandler)
		window.addEventListener('load',listLoadHandler)


        modal_overlay.addEventListener('click',closeModal)

	
	</script>
</body>
</html>