// JSON
// JavaScript Object Notation
// {"키":"값"} 형태로  자바스크립트 객체와 비슷한 형태이나 JSON은 쌍따옴표만 허용한다.  

// 1. Object to JSON
// stringfy(obj)
let json = JSON.stringify(true);
console.log(json);

json = JSON.stringify(['apple','banana']);
console.log(json); // ["apple","banana"] - json은 쌍따옴표만 허용 

const rabbit = {
    name: 'tori',
    color: 'white',
    size: null,
    birthDate: new Date(),
    //symbol: Symbol('id'),
    jump: () => {
        console.log(`${name} can jump!`);
    }
};

json = JSON.stringify(rabbit);
console.log(json); 
/*
{"name":"tori","color":"white","size":null,"birthDate":"2020-12-11T04:28:49.265Z"}
-> Symbol()같은 자바스크립트에만 있는 데이터나 jump()와 같은 함수는 JSON으로 변환되지 않는다. 
*/

json = JSON.stringify(rabbit, ['name', 'color', 'size']);
console.log(json); 

json = JSON.stringify(rabbit, (key, value) => {
    console.log(`key: ${key}, value: ${value}`);
    return key === 'name' ? 'macs' : value;
});
console.log(json); 
/*
key: , value: [object Object] -> 전체 객체를 먼저 리턴
key: name, value: tori
key: color, value: white
key: size, value: null
key: birthDate, value: 2020-12-11T04:51:32.970Z
key: jump, value: () => {
        console.log(`${name} can jump!`);
    }

{"name":"macs","color":"white","size":null,"birthDate":"2020-12-11T04:53:19.688Z"}
-> name의 값이 변경된 것을 볼수 있다. 
*/

// 2. JSON to Object
// parse(json)
console.clear();
json = JSON.stringify(rabbit);
const obj = JSON.parse(json);
console.log(obj); // {name: "tori", color: "white", size: null, birthDate: "2020-12-11T05:06:57.153Z"}
rabbit.jump(); // 원래 rabbit 객체에는 jump()함수가 있었지만 
// obj.jump(); 
/*
 Uncaught TypeError: obj.jump is not a function 
 -> JSON 변환할때는 포함되지 않는다. JSON을 다시 자바스크립트 객체로 변환할 때는 당연히 포함되지 않은 함수도 들어 있지 않아 오류가 나게 된다. 
*/

console.log(rabbit.birthDate.getDate()); // 11
// console.log(obj.birthDate.getDate()); 
/* 
Uncaught TypeError: obj.birthDate.getDate is not a function
-> JSON은 기본적으로 문자열로 변환이 된다. rabbit 객체에서는 Date()함수를 통해 값을 구할수 있지만 JSON변환시에는 구한 값을 문자열로 변환했기 때문에 함수를 사용할 수 없다.
*/

// 대신 아래와 같이 JSON을 다시 객체로 변환시에 replacer()로 원하는대로 변경할 수 있다. 
const obj1 = JSON.parse(json, (key, value) => {
    console.log(`key: ${key}, value: ${value}`);
    return key === 'birthDate' ? new Date(value) : value;
})
console.log(obj1.birthDate.getDate()); // 이제 사용 가능 

