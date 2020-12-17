'use strict';

// ## 자료구조
// 비슷한 타입의 객체들을 묶어 놓은 것 
// 자바스크립트는 동적언어로 타입에 덜 구애 받아 동일하지 않은 타입의 객체라도 묶어 놓을 수 있으나 이것은 추천하지 않음
// 자바의 경우는 같은 타입이 아니면 묶일 수 없음 

// 추가 공부 - 자료구조와 알고리즘


// ## Array

// 인덱스로 지정되어 있는 자료구조

// 1. 배열 선언
const arr1 = new Array();
const arr2 = [1, 2];

// 2. 인덱스 접근
const fruits = ['🍎', '🍌'];
console.log(fruits); // ['🍎', '🍌']
console.log(fruits.length); // 2
console.log(fruits[0]); // 🍎 : 배열의 첫번째 인덱스 
console.log(fruits[fruits.length - 1]); // 🍌 : 배열의 마지막 인덱스
console.log(fruits[2]); // undefined
console.clear();

// 3. 반복

// for loop
for (let i = 0; i < fruits.length; i++) {
   console.log(fruits[i]); 
}

// for(값 of 배열)
for (let fruit of fruits) {
    console.log(fruit);
}

console.clear();

// forEach
/*
fruits.forEach(function(value, index, array){
    console.log(value);
    console.log(index);
    console.log(array);
});
*/
fruits.forEach((fruit) => console.log(fruit)); // 화살표함수표현식


// 4. 배열추가, 삭제, 복사
console.clear();
// push: add an item to the end
// 배열의 맨 뒤에 추가하고 추가 항목을 포함한 길이를 리턴한다. 
// fruits.push('🍓', '🍒');
let arrayLength = fruits.push('🍓', '🍒');
console.log(arrayLength); // 4 : 추가 포한한 길이 리턴
console.log(fruits); // (4) ["🍎", "🍌", "🍓", "🍒"]

// pop: remove an item from the end
// 배열의 마지막 항목을 삭제하고 삭제한 그 항목을 리턴한다. 
// fruits.pop(); 
let removeItem = fruits.pop();
console.log(removeItem); // 🍒 : 삭제한 마지막 항목 리턴
console.log(fruits); //  ["🍎", "🍌", "🍓"]


// unshift: add an item to the beginning
// 배열의 맨 앞에 추가하고 추가 항목을 포함한 길이를 리턴한다. 
let length = fruits.unshift('🍑','🍇');
console.log(length); // 5
console.log(fruits); // ["🍑", "🍇", "🍎", "🍌", "🍓"]

// shift: remove an item from the beginning
// 배열의 첫번째 항목을 삭제하고 삭제한 그 항목을 리턴한다. 
let removeItem1 = fruits.shift();
console.log(removeItem1); // 🍑
console.log(fruits); // ["🍇", "🍎", "🍌", "🍓"]

//shift(), unshift()는 pop(), push()보다 엄청 느리다

// splice : remove an item by index position
// 지정한 인덱스부터 지정된 삭제개수만큼  데이터를 삭제할 수 있다. 
// console.clear();
console.log(fruits); // ["🍇", "🍎", "🍌", "🍓"]
let removeItem2 = fruits.splice(1, 1); // 사과 한개만 삭제 
console.log(removeItem2); // ["🍎"]  배열에서 지정한 익덱스를 삭제하고 그 삭제 항목을 배열로 리턴한다. 
// fruits.splice(1); // 사과부터 모두 삭제

fruits.splice(1, 1, '🥝','🍉'); // 세번째 인자로 삭제항목의 자리를 대신해 다른 항목을 추가할 수 있다. 
console.log(fruits); // ["🍇", "🥝", "🍉", "🍓"]


// combine two arrays
const fruits2 = ['🥑','🍅'];
const newFruits =  fruits.concat(fruits2); // array + array
const newFruits1 = newFruits.concat('🍍'); // arrya + 문자열
console.log(newFruits); // ["🍇", "🥝", "🍉", "🍓", "🥑", "🍅"]
console.log(newFruits1);

// 5. 검색
console.clear();
console.log(fruits);
console.log(fruits.indexOf('🍇')); // 0
console.log(fruits.includes('🥑')); // false
fruits.push('🍇');
console.log(fruits);
console.log(fruits.indexOf('🍇', 1)); // 4 : 두번째 인자로 지정된 인덱스부터 끝까지 검색 
console.log(fruits.lastIndexOf('🍇')); // 4
console.log(fruits.lastIndexOf('🍇', 3)); // 0 : 두번째 인자로 지정된 인덱스부터 거꾸로 검색


console.clear();
