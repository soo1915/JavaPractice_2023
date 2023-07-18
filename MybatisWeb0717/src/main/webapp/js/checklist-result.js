// let nums = ['가방', '칫솔', '면도기'];
// nums.push('우산');
// nums.splice(2,1);
//let itemList = [];
//
//const addBtn = document.querySelector('#add');
//addBtn.addEventListener("click", addList, false);
//
//function addList() {
//    let str = document.querySelector('#item');
//    if(str.value != null && str.value != '') {
//        itemList.push(str.value);
//        str.value = '';
//        str.focus();
//    }
//    showList();
//}
//
//function showList() {
//    let list = "<ul>";
//    for(let i = 0; i < itemList.length; i++) {
//        list += `<li>${itemList[i]}<span class="close" id='${i}'>X</span></li>`; // span 태그에 id 값을 지정
//    }
//    list += "</ul>";
//    document.querySelector('#itemList').innerHTML = list; // div의 id
//
//    let remove = document.querySelectorAll(".close"); // span 태그 전체 불러오기(배열처럼 사용)
//    // console.log(remove);
//    for(let i = 0; i < remove.length; i++) {
//        remove[i].addEventListener("click", removeList); //  모든 태그에 이벤트를 붙이기
//    }
//}
//
//function removeList() { //해당 이벤트 진행 시 실행
//    let id = this.getAttribute("id");// 현재 객체(span)의 id값 가져오기
//    // console.log(id);
//    itemList.splice(id, 1); // 현재 객체의 id 값을 1개 삭제하기
//    showList(); // 삭제 이후에도 리스트를 보여줘야 함
//}
	

	

