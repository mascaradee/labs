function p(){
	let list = document.getElementsByTagName('li');		

	toString.call(list); // 타입 확인하는 방법 

	for(let value of list){ 
		if((value.textContent).includes('e')){
			console.log(value.textContent)
		}
	}
}


function print(){
	/*
		filter, includes, from을 사용해서 문자열 'e'가 포함된 노드로 구성된 배열을 만들어서 반환하기 
	*/
	let list = document.querySelectorAll('li');
	console.log(toString.call(list)); // 타입 확인하는 방법  -> list 는 NodeList
	let listArray = Array.from(list); // from() : 진짜 배열형식으로 변환 
	console.log(toString.call(list)); // listArray의 타입은 Array이고 filter()를 사용하게 위해 타입을 변경함.
	let eArray = listArray.filter(function(v){ // filter() : 주어진 함수에 따른 결과를 모아 새로운 배열로 반환
		return v.includes('e')
	})
	return eArray;

}
//console.log(print());// [li, li li]