
// parameters
function changeAge(obj) {
    obj.age = 10;
}
const age = { age: 20 };
changeAge(age);
console.log(age);

// default parameters (added in ES6)
function showMessage(message, from) {
    console.log(`${message} by ${from}`);
}
showMessage('Hi!'); // 2번째 인자가 없으므로 자바스크립트가 자동으로 'undefined'로 리턴해줌


function showMessage1(message, from ='모르는 사람') { // 2번째 인자의 기본 값을 설정할수 있다.
    console.log(`${message} by ${from}`);
}
showMessage1('Hi!');

// rest parameters (added in ES6)
function printAll(...a) {
    for (let i = 0; i < a.length; i++) {
        console.log(a[i]);
    }
    /* for... of
    for (const arg of args) {
        console.log(arg);
    }
    */
    /* forEach()
    args.forEach((arg) => console.log(arg));
    */
}

printAll('apple', 'banana','mange');


// fucntion expression
const fn = function () {
    console.log('I am function');
};
fn(); // I am function
const fn2 = fn; // 또 다른 변수에 할당
fn2(); // I am function
  

fn3();
function fn3() {
  console.log('I am hoisting');
};
fn3(); // I am function : 정상 출력

// 함수표현식의 콜백함수 이용
function createPicture(command, drawLine, drawCircle) {
    if (command === 'line') {
        drawLine();
    } else {
        drawCircle();
    }
}

const drawLine = function () {
    console.log('this is a line');
};
const drawCircle = function () {
    console.log('this is a circle');
};

createPicture('line', drawLine, drawCircle);
createPicture('circle', drawLine, drawCircle);

// Arrow function
// always anonymous
const sayHello = function () {
    console.log('hello');
};

const sayHello1 = () => console.log('hello');
// function () : ()
// {} : =>
sayHello1();

const saySomething = (something) => console.log(`${something}`);
saySomething('안녕');


// Q1. function calculate(command, a, b)
// command: add, substract, divide, multiply, remainder, etc

function calculate(command, a, b) {
    let result = 0;
    switch (command) {
        case ('add') :
            return a + b;
            break;
        case ('substract') :
            return a - b;
            break;
        case ('divide') :
            return a / b;
            break;            
        case ('multiply') :
            return a * b;
            break;
        case ('remainder') :
            return a % b;
            break;
        default : 
            throw Error('unknown command');
            // return 'we can\'t do it';
            break;
    } 
}
console.log(`calculate: ${calculate('add', 1, 3)}`);

