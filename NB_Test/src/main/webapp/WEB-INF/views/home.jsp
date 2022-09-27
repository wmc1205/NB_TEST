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
	function getSearchList(){
		$.ajax({
			type:'GET',
			url:"/getSearchList",
			data : $("form[#searchForm]").serialize(),
			success : function(result){
				console.log(result)
				$('#boardTB > #listInfo').empty();
				if(result.length>=1){
					result.forEach(function(item){
						str='<tr>'
							str += "<td>"+item.labelType+"</td>";
							str+="<td>"+item.title+"</td>";
							str+="<td>"+item.startDt+"</td>";
							str+="<td>"+item.regUser+"</td>";
							str+="<td>"+item.endDt+"</td>";
							str+="</tr>"
							$('#boardTB').append(str);
					})
				}
			}
		})
	}

</script>


<body>
	<div class="root">
		<form id="searchForm" >
		<table id="upper">
			<tr>
				<th>Type</th>
				<td>Internal</td>
				<th>Title</th>
				<td><input type="text"  id="title" name="titleSH"></td>
				<th>Label</th>
				<td><select name="labelTypeSH">
					<option selected value="A">All</option>
					<option value="C">Customer</option>
					<option value="B">Bank</option>
				</select></td>
			</tr>
			<tr>
				<th>Valid</th>
				<td>
				<select name="validType">
					<option value="valid">valid</option>
					<option value="expired">expired</option>
				</select>
				</td>
				<th>Registor</th>
				<td><input type="text" name="regUserSH" placeholder="registor"></td>
				<td></td>
				<td><input type="button" onclick="getSearchList()" value="searchBtn"></td>
			</tr>
		</table>
		</form>
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
					<td><input type="date" name="startDt"></td>
					<th>Valid date to</th>
					<td><input type="date" name="endDt"></td>
				</tr>
				<tr>
				<th>Registrator</th>
				<td><input type="text" name="reg_user"></td>
				<th>Label</th>
				<td colspan="3">
					<select name="labelType">
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
		
		window.addEventListener('load',listLoadHandler)
		

        modal_overlay.addEventListener('click',closeModal)

	
	</script>
</body>
</html>