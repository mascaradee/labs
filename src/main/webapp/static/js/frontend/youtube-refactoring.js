/* 자바스크립트 버전  */
var lis = document.querySelectorAll('.subscribeInfo .icons li');
var all = document.querySelectorAll('.subscribeInfo .icons i');

lis.forEach((ele, index, obj) => {
    ele.addEventListener('click', (evt)=>{
        var a = evt.target.tagName === 'I' ? evt.target : evt.target.firstChild; // i태그뿐 아니라 li태그를 클릭했을때도 같이 반영되도록 
        // var siblings = a.closest('ul').querySelectorAll('i');
        // siblings.forEach((ele) => {
        //     ele.classList.remove('pushed');
        // });
        var arr = [];
        all.forEach((ele) => {
            if(ele !== a) {
                arr.push(ele); // 클릭한 태그를 제외한 나머지 태그들을 리스트로 만든다. 클릭한 태그는 그대로 pushed로 있다가 토글로 파란색이 해제 되므로 제외한다. 
            }
        });
        arr.forEach((ele) => {
            ele.classList.remove('pushed'); // 다음 클릭을 대비해서 나머지 태그들에 pushed 클래스를 지운다. 다음 토글에 파란색이 선택 되도록
        });
        a.classList.toggle('pushed'); // 선택한 아이콘에 파란색 넣기  다시 클릭하면 파란색 해제
    });
// });

/* jQuery 버전 */

