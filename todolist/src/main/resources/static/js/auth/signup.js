const submitBtn = document.querySelector("button");
const inputs = document.querySelectorAll("input");

submitBtn.onclick = async () => {
	
	let result = await usernameCheck(inputs[0].value);
	
	if(result == true){
		const url = `/api/v1/auth/signup`;
		const bodyObj = {
			username: inputs[0].value,
			password: inputs[1].value,
			name: inputs[2].value,
			email: inputs[3].value			
		};
		
		const option = {
			method: "POST",
			headers: {
				"Content-Type" : "application/json"
			},
			body: JSON.stringify(bodyObj)
		}
		
		await request(url, option)
		.then(result => {
			return result.data;
		})
		.then(data => {
			if(data == true){
				alert("회원가입 성공");
			}else{
				alert(JSON.stringify(data));
			}
		})
		.catch(error => {
			console.log(error);
		});
	}else {
		alert(JSON.stringify(result));
	}
}

async function usernameCheck(username) {
	const url = `/api/v1/auth/signup/username?username=${username}`
	
	let responseData = false;
	
	await request(url)
	.then(result => {
		console.log("-> " + result);
		responseData = result.data;
	})
	.catch(error => {
		console.log(error);
	})
	
	return responseData;
}

async function request(url, option) {
	const response = await fetch(url, option);
	
	if(response.ok){
		return response.json();
	}else{
		throw new Error("response Error: " + response);
	}
}

