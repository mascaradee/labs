// Promise
// 비동기를 간편하게 수행하기 위해 자바스크립트가 제공하는 오브젝트
// Promise is a JavaScript object for asynchronous operation.
// state : 수행중 pending 종료 fulfilled or rejected
// producer (정보 제공) vs consumer (정보 소비)

// 1. Producer
// Promise()는 생성이 되자마자 executor가 실행이 되므로 주의해야 한다. 
// 사용자가 직접 입력할 때 동작하는 기능이라면 생성 시에도 불필요하게 동작을 하므로 유의해야 한다. 
// when new Promise is created, the executor runs automatically.
const promise = new Promise((resolve, reject) => {
    // doing some heavy work (network, read files)
    console.log('doing something...');
    setTimeout(() => {
        //resolve('macs');
        reject(new Error('no network'));
    }, 2000);
});

// 2. Consumers: then, catch, finally
promise
.then(value => { // value는 promise가 제대로 작동해서 resolve 콜백함수를 통해서 전달한 값이다.즉, macs
    console.log(value);
}) // then()은 promise를 다시 리턴하므로 아래 catch에 전달할수 있다. = 체이닝
// catch가 없는 경우 //  Uncaught (in promise) Error: no networ
.catch(error => { 
    console.log(error);
})
.finally(() => {
    console.log('finally');
}); 

// 3.Promise chaining 연결하기
const fetchNumber = new Promise((resolve, reject) => {
    setTimeout(() => resolve(1), 1000);
});

fetchNumber
.then(num => num * 2) // 1 => 1 * 2
.then(num => num * 3) // 2 => 2 * 3
.then(num => { // 6
    return new Promise((resolve, reject) => {
        setTimeout(() => resolve(num - 1), 1000); // 6 - 1 = 5
    });
})
.then(num => console.log(num));


// 4. Error Handling
const getHen = () =>
    new Promise((resolve, reject) => {
        setTimeout(() => resolve('🐓'), 1000);
    });
const getEgg = hen =>
    new Promise((resolve, reject) => {
        setTimeout(() => 
            //resolve(`${hen} => 🥚`), 1000); // 작동 성공 
            reject(new Error(`${hen} => 🥚`)), 1000) // 작동 실패 -> Uncaught (in promise) Error: 🐓 => 🥚 at promise.js:58 오류처리는 아래 catch()
    });
const cook = egg =>
    new Promise((resolve, reject) => {
        setTimeout(() => resolve(`${egg} => 🍳`), 1000);
    });

/*    
getHen()
.then(hen => getEgg(hen))
.then(egg => cook(egg))
.then(meal => console.log(meal));
*/
getHen()
.then(getEgg) // 콜백함수결과값이 하나이고 다른 함수의 매개변수 그대로 전달할때는 왼쪽과 같이 생략 가능 
.catch(error => {
    return '🍞'; // 에러 발생 시 원하는 핸들링을 할수 있다. 적절한 핸들링이 있어야 promise가 원활하게 끝까지 진행할 수 있다. 
})
.then(cook)
.then(console.log)
.catch(console.log) // 에러 처리
;
// getHen().then(getEgg).then(cook).then(console.log); 이렇게 한줄로 쓸 수도 있지만 가독성이 좋지 않다. 
