'use strict';


function listConvert(dto){
	const item=document.createElement('tr')
	item.classList.add('item')
//	item.setAttribute('idx',dto.idx)
//	item.addEventListener('click',openModal)
	
	for(let key in dto){
		switch(key){
			case 'idx':
			case 'regTm':
			continue;
			case 'title':
				const title = document.createElement('td')
				title.className = key
				td.innerText = dto[key]
//				title.href= cpath + "/select/${idx}"
				item.appendChild(title)
				break;			
		}
			const td = document.createElement('td')
			td.className = key
			td.innerText = dto[key]
			item.appendChild(td)
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
			location.href = cpath +'/home'
			}
		})
}

