const submitBtn = document.querySelector("button");
const inputs = document.querySelectorAll("input");

submitBtn.onclick = () => {
	
	usernameCheck(username);
	
	const url = `/api/v1/auth/signup`;
	const option = {
		method : "POST",
		headers : {
			"ContentType" : "application/json"
		},
		body : JSON.stringify({
			"username" : inputs[0].value,
			"password" : inputs[1].value,
			"name" : inputs[2].value,
			"email" : inputs[3].value
		})
	}
/*	request(url, option);*/
}

//아이디 중복 체크
async function usernameCheck(username){
	const url = `/api/v1/auth/username`;
	const option = {
		method : "POST",
		headers : {
			"ContentType" : "application/json"
		},
		body : JSON.stringify({"username" : username})
	}
	await request(url, option)
	.then(result => {
		console.log(result);
	})
	.catch(error => {
		console.log(error);
	})

}





//공통으로 쓰는 메소드 만들어둔거
async function request(url){
	const response = await fetch(url);
	if(response.ok){
		return response.json();
	}else{
		throw new Error("response error : " + response);
	}
}


async function request(url, option){
	const response = await fetch(url, option);
	if(response.ok){
		return response.json();
	}else{
		throw new Error("response error : " + response);
	}
}