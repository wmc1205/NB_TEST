'use strict';

function closeModal(){
    document.getElementById('selectInfoModal').classList.add('hidden')
}

function openModal(event){
    let target = event.target
    while(target.classList.contains('item') == false){
        target = target.parentNode
    }
    const idx = target.getAttribute('idx')
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
	        	<select><option value="C">Internal</option></select>
	        </td>
	        <th>valid date from</th>
	        <td>
	        	${json.startDt}
	        </td>
	        <th>Valid date to</th>
	        <td>${json.endDt}</td>
	    </tr>
        <tr><th>Registrator</th><td>${json.reg_user}</td><th>Label</th>
        <td colspan="5"><select><option value="H">All</option></td>
        </tr>
        <tr><th>Content</th><td colspan="7">${json.content}</td></table>
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
					<td><input type="date" name="start_dt"></td>
					<th>Valid date to</th>
					<td><input type="date" name="end_dt"></td>
				</tr>
				<tr>
				<th>Registrator</th>
				<td><input type="text" name="reg_user" value="${json.reg_user}"></td>
				<th>Label</th>
				<td colspan="3">
					<select >
						<option value="A">all</option>
						<option value="C">customer</option>
						<option value="B">bank</option>
					</select>
				 </td>
				</tr>
				<tr>
					<th>content</th>
					<td colspan="5"><textarea id="edit_content" name="contents" rows="5" cols="33">${json.content}</textarea></td>
			</tr>
			</table>
			<p><input type="submit" value="save"></p>
			</form>		
			</div>`
		const updateForm = document.forms[1]
		updateForm.addEventListener('submit',updateHandler) 
	})
	document.getElementById('editModal').classList.remove('hidden')
}

//function editModalForm(){
//	const editModalContent = document.getElementById('editModalContent')
//	editModalContent.innerHTML = ''
//	editModalContent.innerHTML += 
//	`<h2>edit notice</h2>
//			<div>
//			<a href="${cpath }"><button>go to list</button></a>
//			</div>
//			<form>
//				<input type="reset" value="clear">
//			<input type="hidden" name="idx" ">
//			<table id="editTable">
//			<tr>
//					<th>title</th>
//				<td colspan="5"><input type="text" name="title"></td>
//				</tr>
//				<tr>
//					<th>Type</th>
//					<td>
//					<select>
//					<option value="C">internal</option>
//				</select>
//				</td>
//					<th>Valid date from</th>
//					<td><input type="date" name="start_dt"></td>
//					<th>Valid date to</th>
//					<td><input type="date" name="end_dt"></td>
//				</tr>
//				<tr>
//				<th>Registrator</th>
//				<td><input type="text" name="reg_user"></td>
//				<th>Label</th>
//				<td colspan="3">
//					<select>
//						<option value="A">all</option>
//						<option value="C">customer</option>
//						<option value="B">bank</option>
//					</select>
//				 </td>
//				</tr>
//				<tr>
//					<th>content</th>
//					<td colspan="5"><textarea id="edit_content" name="contents" rows="5" cols="33"></textarea></td>
//			</tr>
//			</table>
//			<p><input type="submit" value="save"></p>
//			</form>		
//			</div>`
//		const updateForm = document.forms[1]
//		updateForm.addEventListener('submit',updateHandler) 
//}
//


function listConvert(dto){
	const item = document.createElement('tr')
	item.classList.add('item')
	item.setAttribute('idx',dto.idx)



//	item.setAttribute('idx',dto.idx)
//	item.addEventListener('click',openModal)
	for(let key in dto){
		switch(key){
			case 'idx':
			case 'regTm':
			continue;
		}
			const td = document.createElement('td')
			td.className = key
			td.innerText = dto[key]
			item.appendChild(td)
			if(td.className == 'title'){
			    td.addEventListener('click',openModal)
			}

}
return item
}


function listLoadHandler(event){
	
	const listInfo = document.getElementById('listInfo')
	const url = cpath + '/board'
	listInfo.innerHTML = ''
	fetch(url)
	.then(resp => resp.json())
	.then(json=>{
		json.forEach(dto=>listInfo.appendChild(listConvert(dto)))
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
			location.href = cpath + 'board/home';
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
