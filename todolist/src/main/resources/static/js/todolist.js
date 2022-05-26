const addBtn = document.querySelector(".add-btn");
const tbody = document.querySelector(".tbody");
let content = document.querySelector(".content");

const deleteBtn = document.querySelectorAll(".delete-btn");


load();


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

function pageLoding(result){
	
	let tbodyTr = tbody.querySelector("tr");
	tbodyTr = "";
	for(let i = 0; i < result.length; i++){
		tbodyTr += `<tr>
	                <td>
	                    <input type="text" class="content" value="${result[i].content}">
	                    <button class="modify-btn">수정</button>
	                    <button class="delete-btn">삭제</button>
	                </td>
	            </tr>
	            `;
	tbody.innerHTML = tbodyTr;
	}
	
}

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
		}else{
			throw new Error("비동기 처리 오류");
		}
	})
	.catch(error);
}
 
function modify(){
	let modifyBtn = document.querySelectorAll(".modify-btn");
	let id = 11;
	let ddd = document.querySelectorAll("input");
	
	for(let i = 0; i < modifyBtn.length; i++){
		modifyBtn[i].onclick = () => {
			console.log("content : "+ddd[i+1].value);
			if(!confirm("수정하시겠습니까?")){
				alert("취소 클릭");
			}else{
				
				url = `/api/v1/todo/${id}`;
				option = {
					method : "PUT",
					headers: {
			                "Content-Type": "application/json"
			            },
					body : JSON.stringify({content : ddd[i+1].value})
				};
				fetch(url, option)
				.then(response => {
					if(response.ok){
						alert("수정완료");
					}else{
						throw new Error("비동기 처리 오류");
					}
				})
				.catch(error);
			}
		}
	}
}
	


function remove(){
	let deleteBtn = document.querySelectorAll(".delete-btn");
	let id = 11;
	
	for(let i = 0; i < deleteBtn.length; i++){
		deleteBtn[i].onclick = () => {
			if(!confirm("삭제하시겠습니까?")){
				alert("취소 클릭");
			}else{
				url = `/api/v1/todo/${id}`;
				option = {
					method : "DELETE",
				};
				fetch(url, option)
				.then(response => {
					if(response.ok){
						alert("삭제완료");
					}else{
						throw new Error("비동기 처리 오류");
					}
				})
				.catch(error);
			}
		}
	}
}






