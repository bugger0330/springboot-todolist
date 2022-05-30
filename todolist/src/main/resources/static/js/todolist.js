const addBtn = document.querySelector(".add-btn");
const tbody = document.querySelector(".tbody");
let content = document.querySelector(".content");

const deleteBtn = document.querySelectorAll(".delete-btn");

load();

//조회
function load(){
	let url = "/api/v1/todo/list";
	fetch(url)
	.then(response => {
		if(response.ok){
			return response.json();
		}else{
			throw new Error("비동기 처리 오류");
		}
	})
	.then(result =>{
		pageLoding(result);
		
		modify();
		remove();
		
		
	})
	.catch(error => {alert("에러 : "+error);});
	
}	
//조회 함수
function pageLoding(result){
	
	let tbodyTr = tbody.querySelector("tr");
	tbodyTr = "";
	for(let i = 0; i < result.length; i++){
		tbodyTr += `<tr>
	                <td>
	                    <input type="text" class="content" value="${result[i].content}" id="${result[i].id}">
	                    <button class="modify-btn">수정</button>
	                    <button class="delete-btn">삭제</button>
	                    <button class="yes-btn">예</button>
	                    <button class="no-btn">아니오</button>
	                </td>
	            </tr>
	            `;
	tbody.innerHTML = tbodyTr;
	}
	
}
//등록버튼 클릭
addBtn.onclick = () => {
	let url = "/api/v1/todo";
	let option = {
		method : "POST",
		headers: {
                "Content-Type": "application/json"
            },
		body : JSON.stringify({"content" : content.value})
	}
	fetch(url, option)
	.then(response => {
		if(response.ok){
			alert("등록 완료");
			content.value = "";
			load();
		}else{
			throw new Error("비동기 처리 오류");
		}
	})
	.catch(error);
}

 
//수정
function modify(){
	let modifyBtn = document.querySelectorAll(".modify-btn");
	let deleteBtn = document.querySelectorAll(".delete-btn");
	let yesBtn = document.querySelectorAll(".yes-btn");
	let noBtn = document.querySelectorAll(".no-btn");
	let inputValue = document.querySelectorAll("input");
	

	
	for(let i = 0; i < modifyBtn.length; i++){
		modifyBtn[i].onclick = () => {
			let id = inputValue[(i+1)].id;
			console.log("content : "+inputValue[i+1].value);
			console.log("id : "+inputValue[i+1].id);
			modifyBtn[i].className = 'change1';
			deleteBtn[i].className = 'change2';
			yesBtn[i].className = 'change3';
			noBtn[i].className = 'change4';
			
			yesBtn[i].onclick = () => {
				url = `/api/v1/todo/${id}`;
				option = {
					method : "PUT",
					headers: {
			                "Content-Type": "application/json"
			            },
					body : JSON.stringify({
						content : inputValue[i+1].value,
						id : id
						})
				};
				fetch(url, option)
				.then(response => {
					if(response.ok){
						alert("수정완료");
						load();
					}else{
						throw new Error("비동기 처리 오류");
					}
				})
				.catch(error);
			
			}
				
		}
	}
}


//삭제
function remove(){
	let modifyBtn = document.querySelectorAll(".modify-btn");
	let deleteBtn = document.querySelectorAll(".delete-btn");
	let yesBtn = document.querySelectorAll(".yes-btn");
	let noBtn = document.querySelectorAll(".no-btn");
	let inputValue = document.querySelectorAll("input");
	
	
	for(let i = 0; i < deleteBtn.length; i++){
		deleteBtn[i].onclick = () => {
			let id = inputValue[(i+1)].id;
			modifyBtn[i].className = 'change1';
			deleteBtn[i].className = 'change2';
			yesBtn[i].className = 'change3';
			noBtn[i].className = 'change4';
			
			yesBtn[i].onclick = () => {
				url = `/api/v1/todo/${id}`;
				option = {
					method : "DELETE",
				};
				fetch(url, option)
				.then(response => {
					if(response.ok){
						alert("삭제완료");
						load();
					}else{
						throw new Error("비동기 처리 오류");
					}
				})
				.catch(error);
			}
		}
	}
}





