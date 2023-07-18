let itemList = [];
const addBtn = document.querySelector("#add"); // 버튼의 id
addBtn.addEventListener("click", addList);

function ajax() {

	const thing = document.getElementById("item").value;
    var xhr = new XMLHttpRequest();
    xhr.open('GET', 'ExecAjax?thing='+thing, true);
    xhr.send();

    xhr.onload = ()=>{
        if(xhr.status == 200) {
            //console.log(xhr.response);
            console.log(xhr.responseText);
            res.innerHTML = xhr.responseText;
        }
    }

}

function addList() {
	
	ajax();
    let str = document.querySelector("#item");  // input의 id
    if (str.value != null && str.value != '') {
        itemList.push(str.value);
        str.value = '';
        str.focus();
    }
    showList();
}
function showList() {
    let list = "<ul>";
    for(let i=0; i < itemList.length; i++) {
        list += `<li>${itemList[i]}<span class='close' id='${i}'>X</span></li>`;
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