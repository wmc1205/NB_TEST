'use strict';




function closeModal(){
    document.getElementById('selectInfoModal').classList.add('hidden')
}




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
        <td colspan="5">${json.type}</td>
        </tr>
        <tr><th>Content</th><td colspan="7">${json.contents}</td></table>
		`
    })
        document.getElementById('selectInfoModal').classList.remove('hidden')
        
}

//update 시, 지정된 value값을 넣어주기 위해 String -> Date 변환
//function formatting(date){
//	var yyyy = date.slice(0,4)
//	var mm = date.slice(4,6)
//	var dd = date.slice(6,8)
//	
//	const res = yyyy + "-" + mm + "-" + dd
//	var res = 
//	return res;
//}

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
	var startDt = json.startDt
	var endDt = json.endDt
	var start_dt = new Date(startDt)
	var end_dt = new Date(endDt)

	
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
					<td><input type="date" value="${json.startDt}" name="start_dt"></td>
					<th>Valid date to</th>
					<td><input type="date" value="${json.endDt}" name="end_dt"></td>
				</tr>
				<tr>
				<th>Registrator</th>
				<td><input type="text" name="reg_user" value="${json.regUser}"></td>
				<th>Label</th>
				<td colspan="3">
					<select name="type">
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
function getSearchList(page){
	
	var pageSize = 10;
	var totalPages = 0;
	var curPage = page;
	$("input[name='currentPage']").val(curPage);
	
	var params = $('form[name=searchForm]').serialize()
	$.ajax({
			
			type:'GET',
			url: cpath + '/board' ,
			data : 
				params,
				"listSize" : listSize,
				"page" : page,
			success : function(data){	
				
				var html = ''
				var block = ''
				const pagination = data['pagination'];
//				var page = data.pagination.page
//				var begin = data.pagination.begin
//				var end = data.pagination.end
//				var prev = data.pagination.prev
//				var next = data.pagination.next
					//console.log(pagination);
				
					console.log(data.list)
					
				
				for(var i=0; i<data.list.length; i++){
					var getData = data.list[i];
					
					html += "<tr class='item' data-idx='"+getData.idx+ "'>";
					html += 	"<td class='type'>"+getData.type+"</td>";
					html += 	"<td onclick='openModal(event)' class='title'>" +getData.title +"</td>";
					html += 	"<td class='start_dt'>"+getData.startDt+"</td>";
					html += 	"<td class='end_dt'>"+getData.endDt+"</td>";
					html += 	"<td class='reg_user'>"+getData.regUser+"</td>";
					html +=		"<td class='reg_dt'>"+getData.regDt+" " +getData.regTm +"</td>";
					html += "</tr>";	
				}
				//이전 버튼 활성화 여부 결정
				if(pagination['begin'] === 1
					&&  pagination['end'] === 1){
						html += "<td colspan='6'>게시글이 존재하지 않습니다.</td>";
					}
				//번호 표시 부분
				
				
				if (pagination['prev'] == false) {
							block += "<li class='page-item'><a class='page-link' href='javascript:getSearchList("
									+ (pagination['begin'] )
									+ ")'> < </a></li>";
						} else {
							block += "<li class='page-item disabled'><a class='page-link'> < </a></li>";
						}
					for (var i = pagination['begin']; i < pagination['end']; i++) {
							if (page !== i) {
								block += "<li class='page-item'><a class='page-link' href='javascript:getSearchList("
										+ i+1 + ")'>" + (i+1) + "</a></li>";
							} else {
								block += "<li class='page-item disabled'><a class='page-link'>"
										+ (i) + "</a></li>";
							}
						}
						if (pagination['next'] == false) {
							block += "<li class='page-item'><a class='page-link' href='javascript:getSearchList("
									+ (pagination['end'])
									+ ")'> > </a></li>";
						} else {
							block += "<li class='page-item disabled'><a class='page-link'> > </a></li>";
						}
			
				
				$("#boardTB").find("#listInfo").html(html);
				$("#paging").find('#paginationBox').html(block);
				window.scrollTo(0,0);
			}
			
		});
	}

function dateFormat(date){
	var da = new Date(date);
	var dd = da.getDate();
			var mm = da.getMonth()+1; //January is 0!
		
			var yyyy = da.getFullYear();
			if(dd<10){dd='0'+dd} if(mm<10){mm='0'+mm}
			
			yyyy = yyyy.toString();
			mm = mm.toString();
			dd = dd.toString();
			
			var s1 = yyyy+mm+dd;
			return s1;
}



function insertHandler(event){
	event.preventDefault()
	
	const ob ={}
	const formData = new FormData(event.target)
	for(let key of formData.keys()){
		if(key === 'start_dt'){
			var date =formData.get(key)
			var startDt = dateFormat(date)
			ob[key] = startDt
		}
		else if(key === 'end_dt'){
			var date =formData.get(key)
			var endDt = dateFormat(date)
			ob[key] = endDt
		}
		else{ob[key] = formData.get(key)
			}
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
		if(key === 'start_dt'){
			var date =formData.get(key)
			var startDt = dateFormat(date)
			ob[key] = startDt
		}
		else if(key === 'end_dt'){
			var date =formData.get(key)
			var endDt = dateFormat(date)
			ob[key] = endDt
		}
		else{ob[key] = formData.get(key)
			}
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




