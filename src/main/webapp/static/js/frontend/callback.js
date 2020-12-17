'use strict'
// 자바스크립트는 동기적인 언어이다. hoisting 이후로 순서대로 코드가 실행이 된다. 
//hoisting : var, function 선언이 제일 위로 올라가서 먼저 실행되는 것 
/*
console.log('1');
setTimeout(() => console.log('2'), 1000); // callback 함수 / setTimeout() 브라우저 API : 브라우저에 1초후에 실행하도록 요청
console.log('3');

// 동기 콜백함수 
function printImmediately(print) {
    print();
} // hoisting
printImmediately(() => console.log('hello'));
 
// 비동기 콜백함수 
function printWithDelay(print, timeout) {
    setTimeout(print, timeout);
} // hoisting
printWithDelay(() => console.log('async callback'), 2000);
*/

// 원래대로라면 코딩된 순서대로 실행이 되어야 하지만 자바스크립트 엔진 위 코드를 읽으면 
// (1) console.log('1') 실행 (동기)
// (2) setTimeout()으로 브라우저에 1초 후 콜백함수 호출 요청 (비동기)
// (3) console.log('3') 실행 (동기)
// (4) printImmediately() 실행 (동기)
// (5) printWithDelay()내 setTimeout()으로 브라우저에 2초 후 콜백함수 호출 요청 (비동기)
// (6) 1초후에 브라우저에서 콜백함수 ()=> console.log('2')를 실행하게 된다. 
// (7) 2초후에 브라우저에서 콜백함수 ()=> console.log('async callback')를 실행하게 된다.
/*
1
3
hello
2
async callback
*/


// Callback Hell example
class UserStorage {
    loginUser(id, password, onSuccess, onError) {
        setTimeout(() =>{
            if( 
                (id === 'macs' && password === 'happy') ||
                (id === 'hi' && password === 'world')
            ) {
                onSuccess(id);
            } else {
                onError(new Error('not found'));
            }
        }, 2000);
    }
    getRoles(user, onSuccess, onError) {
        setTimeout(()=>{
            if (user === 'macs') {
                onSuccess({name:'macs', role: 'admin'});
            } else {
                onError(new Error('no access'));
            }
        }, 1000);
    }
}

// id/ pw 받아오기 
const user = new UserStorage();
const id = prompt('enter your id');
const password = prompt('enter your password');

// 로그인 호출 
const rId = user.loginUser(
    id, 
    password, 
    rId => {
        user.getRoles(
            rId,
            userWithRole => {
                alert(`Hello ${userWithRole.name}, you have a ${userWithRole.role} role`);
            },
            error => {
                console.log(error);
            }
        );
    }, 
    error => {
        console.log(error);
});

// 가독성이 떨어진다. 
// 유지보수 및 디버깅이 힘들어진다. 
