let itemList = [];
const addBtn = document.querySelector("#add"); // 버튼의 id
addBtn.addEventListener("click", addList);
function addList() {
    let str = document.querySelector("#item");  // input의 id
    
    if (str.value != null && str.value != '') {
		
		let num;
		console.log(str.value);
		const xhr = new XMLHttpRequest();
		xhr.open('GET', 'ExecAjax?thing='+str.value, true);
		xhr.send();
		
		xhr.onload = ()=>{
            if(xhr.status == 200) {
				console.log("성공");
                //console.log(xhr.response);
                num = xhr.responseText;
            } else {
				console.log("실패");
			}
        }
        itemList.push({idx:num, thing:str.value});
        str.value = '';
        str.focus();
    }
    showList();
}
function showList() {
    let list = "<ul>";
    for(let i=0; i < itemList.length; i++) {
        list += `<li>${itemList[i].thing}<span class='close' id='${i}'>X</span></li>`;
    }
    
    list += "</ul>";
    document.querySelector("#itemList").innerHTML = list; // div의 id

    let remove = document.querySelectorAll(".close");
    //console.log(remove);
    for(let i = 0; i < remove.length; i++) {
        remove[i].addEventListener("click", removeList);
    }
}

function removeList() {
    let id = this.getAttribute("id");
    console.log(id);
    itemList.splice(id, 1);
    showList();
}