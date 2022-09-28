'use strict';




function closeModal(){
    document.getElementById('selectInfoModal').classList.add('hidden')
}


//	$.ajax({
//			type:'GET',
//			url: cpath + '/board',
//			data : $("form[name=searchForm]").serialize(),
//			success : function(data){				
//				var html = "";
//				for(var i=0; i<data.length; i++){
//					var getData = data[i];
//					
//					html += "<tr data-idx='"+getData.idx+"'>";
//					html += 	"<td>"+getData.labelType+"</td>";
//					html += 	"<td onclick='openModal()'>" +getData.title +"</td>";
//					html += 	"<td>"+getData.startDt+"</td>";
//					html += 	"<td>"+getData.endDt+"</td>";
//					html += 	"<td>"+getData.regUser+"</td>";
//					html +=		"<td>"+getData.regDt+" " +getData.regTm +"</td>";
//					html += "</tr>";	
//				}
//				
//				$("#boardTB").find("tbody").html(html);
//				
//			}
//		})


function openModal(event){
	let target =event.target
	if(target.classList.contains('item') == false){
		target = target.parentNode
	}
    let idx = $(target).data('idx')
    const url = cpath + '/board/'+ idx
    const opt = {
        method : 'GET',
        headers:{
            'Content-Type' : 'application/json;charset=utf-8'
        }
    }
    fetch(url,opt)
    .then(resp=>resp.json())
    .then(json=>{
        const modal_content = document.querySelector('.modal_content')
        modal_content.innerHTML = ''
        modal_content.innerHTML += `<h3>Notice</h3>`
        modal_content.innerHTML += `<div class="modal_btn">
        							<button id="editBtn" onclick="openEditModal(${json.idx})" ">update</button>
        							<button id="deleteBtn" onclick="deleteHandler(${json.idx})"}">delete</button>
        							</div>`
       
        modal_content.innerHTML += `<table id="modal_tb">
        <tr>
	        <th>title</th>
	        <td>
	        		${json.title}
	        </td>
	        <th>Type</th>
	        <td>
	        	Internal
	        </td>
	        <th>valid date from</th>
	        <td>
	        	${json.startDt}
	        </td>
	        <th>Valid date to</th>
	        <td>${json.endDt}</td>
	    </tr>
        <tr><th>Registrator</th><td>${json.regUser}</td><th>Label</th>
        <td colspan="5">${json.labelType}</td>
        </tr>
        <tr><th>Content</th><td colspan="7">${json.contents}</td></table>
		`
    })
        document.getElementById('selectInfoModal').classList.remove('hidden')
        
}


function openEditModal(idx){
	closeModal()
	const editModal = document.getElementById('editModal')
	editModal.style.display = 'block'
    const url = cpath + '/board/' + idx
    
    const opt = {
	     method : 'GET',
        headers:{
            'Content-Type' : 'application/json;charset=utf-8'
        }
    }
    fetch(url,opt)
    .then(resp=>resp.json())
    .then(json=>{
	const editModalContent = document.getElementById('editModalContent')
	editModalContent.innerHTML = ''
	editModalContent.innerHTML += 
	`<h2>edit notice</h2>
			<div>
			<a href="${cpath }"><button>go to list</button></a>
			</div>
			<form>
				<input type="reset" value="clear">
			<input type="hidden" name="idx" value="${json.idx}">
			<table id="editTable">
			<tr>
					<th>title</th>
				<td colspan="5"><input type="text" name="title" value="${json.title}"></td>
				</tr>
				<tr>
					<th>Type</th>
					<td>
					<select>
					<option value="C">internal</option>
				</select>
				</td>
					<th>Valid date from</th>
					<td><input type="date" name="startDt"></td>
					<th>Valid date to</th>
					<td><input type="date" name="endDt"></td>
				</tr>
				<tr>
				<th>Registrator</th>
				<td><input type="text" name="reg_user" value="${json.regUser}"></td>
				<th>Label</th>
				<td colspan="3">
					<select name="labelType">
						<option value="A">All</option>
						<option value="C">Customer</option>
						<option value="B">Bank</option>
					</select>
				 </td>
				</tr>
				<tr>
					<th>content</th>
					<td colspan="5"><textarea id="edit_content" name="contents" rows="5" cols="33">${json.contents}</textarea></td>
			</tr>
			</table>
			<p><input type="submit" value="save"></p>
			</form>		
			</div>`
		const updateForm = document.forms[2]
		updateForm.addEventListener('submit',updateHandler) 
	})
	document.getElementById('editModal').classList.remove('hidden')
}

//검색기능
function getSearchList(){
	$.ajax({
			type:'GET',
			url: cpath + '/board',
			data : $("form[name=searchForm]").serialize(),
			success : function(data){				
				var html = "";
				for(var i=0; i<data.length; i++){
					var getData = data[i];
//					var startDt = JSON.stringify(getData.startDt);
//					var endDt =  JSON.stringify(getData.endDt);
					
					html += "<tr class='item' data-idx='"+getData.idx+ "'>";
					html += 	"<td class='labelType'>"+getData.labelType+"</td>";
					html += 	"<td onclick='openModal(event)' class='title'>" +getData.title +"</td>";
					html += 	"<td class='startDt'>"+getData.startDt+"</td>";
					html += 	"<td class='endDt'>"+getData.endDt+"</td>";
					html += 	"<td class='reg_user'>"+getData.regUser+"</td>";
					html +=		"<td class='regDt'>"+getData.regDt+" " +getData.regTm +"</td>";
					html += "</tr>";	
				}
				
				$("#boardTB").find("tbody").html(html);
				
			}
		})
}



function insertHandler(event){
	event.preventDefault()
	
	const ob ={}
	const formData = new FormData(event.target)
	for(let key of formData.keys()){
		ob[key] = formData.get(key)
	}
	const url = cpath +'/board/insert'
	const opt = {
		method:'POST',
		body:JSON.stringify(ob),
		headers:{
			'Content-Type' : 'application/json;charset=utf-8'
		}
	}
	fetch(url,opt)
	.then(resp=>resp.text())
	.then(text=>{
		if(text==1){
			location.href = cpath +'/board/home'
			}
		})
}

function updateHandler(event){
	
	event.preventDefault()
	const ob = {}
	const formData = new FormData(event.target)
	console.log(this.idx.value)
	for(let key of formData.keys()){
		ob[key] = formData.get(key)
		
	}
	const url = cpath +'/board/update/' + this.idx.value
	const opt = {
		method : 'POST',
		body:JSON.stringify(ob),
		headers:{
			'Content-Type' : 'application/json;charset=utf-8'
		}
	}
	fetch(url,opt)
	.then(resp=>resp.text())
	.then(text=>{
		if(text==1){
			location.href = cpath + '/board/home';
		}
	})
}

function deleteHandler(idx){
	const flag = confirm('정말 삭제하시겠습니까?')
	if(flag){
		
		console.log(idx)
		const url = cpath +'/board/delete/'+ idx
		const opt ={
			method : 'POST'
		}
		fetch(url,opt)
		.then(resp=>resp.text())
		.then(text=>{
			if(text == 1){
				alert('삭제 성공')
				location.href= cpath + '/board/home';
			}
		})
	}

}


//function searchListHandler(){
//	const searchForm = document.querySelector('#searchForm');
//	const data = new FormData(searchForm);
//	const serializedFormData = serialize(data);
//	console.log(JSON.stringify(serializedFormData));
//	
//	listLoadHandler();
//	
//}
//function serialize(rawData){
//	let rtnData = {};
//	for (let [key, value] of rawData) {
//		let sel = document.querySelectorAll("[name=" + key + "]");
//	
//		// Array Values
//		if (sel.length > 1) {
//			if (rtnData[key] === undefined) {
//				rtnData[key] = [];				
//			}
//			rtnData[key].push(value);
//		} 
//		// Other 
//		else {
//        	rtnData[key] = value;
//		}
//	}
//	
//	return rtnData;
//
//}



