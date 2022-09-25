'use strict';

function closeModal(event){
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

    })
        document.getElementById('selectInfoModal').classList.remove('hidden')

}


function listConvert(dto){
	const item=document.createElement('tr')
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
			location.href = cpath +'/home'
			}
		})
}

