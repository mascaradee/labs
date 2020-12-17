// async & await
// clear style of using promise
// 프로미스 체이닝을 동기적으로 실행 되는 것처럼 보여질 수 있도록 쓰는 API (syntactic sugar)

// 1.async
/* 1) 동기방식
function fetchUser() {
    // do network request in 10 secs ...
    return 'macs';
}
const user = fetchUser();
console.log(user); 

이렇게 동기로 스크립트를 작성할 경우, 순차적인 실행을 하는 자바스크립트 특성상 10초동안 fetchUser의 실행이 모두 끝날때까지 이후 스크립트는 동작을 할 수가 없어 마냥 기다리게만 된다. 
만약 이후 스크립트가 화면을 구성하는 부분이라면 고객은 빈 화면을 10초동안 유지시키고 있어야 하는 불상사가...
*/

//2) 비동기 프로미스 
// function fetchUser() {
//     return new Promise((resolve, reject) => {
//         // do network request in 10 secs..
        
//         /*
//         // return 'macs'; 
        
//         Promise {<pending>}
//             __proto__: Promise
//             [[PromiseState]]: "pending"
//             [[PromiseResult]]: undefined

//         - resolve나 reject로 완료처리를 해 주지 않고 return 'macs'를 하면 계속 pending 상태로 남아 있게 된다. 
//         */
//         resolve('macs');

//     });

// }
// const user = fetchUser();
// user.then(console.log); // 프로미스 실행 결과가 완료된 후에 로그가 찍히므로 아래 로그보다 더 나중에 찍힘.
// console.log(user); 
// /*
// Promise {<fulfilled>: "macs"}
// __proto__: Promise
// [[PromiseState]]: "fulfilled"
// [[PromiseResult]]: "macs"
// */

// 3) aync
// 함수 선언 앞에 async 키워드만 붙이면 내부적으로 promise로 변경된다. 
//async function fetchUser() {
//    return 'macs';
//}
const user = fetchUser();
user.then(console.log);
console.log(user);

// 2. await
function delay(ms) {
    return new Promise(resolve => setTimeout(resolve, ms));
}

// await는 async 함수 안에서만 쓸수 있고 promise가 끝날때까지 기다리는 기능  
//async function getApple() {
//    await delay(2000);
//    // throw 'error'; // 에러를 처리한느 기능 필요 
//    return '🍎';
//}
//async function getBanana() {
//    await delay(1000);
//    return '🍌';
//}

/*
체이닝보다 아래 코드와 같이 쓰면 동일한 기능으로 동기적으로 코딩할 수 있다. 
체이닝을 많이 하다보명 역시 Promise도 콜백지옥을 못 벗어나므로...
function pickFruits() {
    return getApple().then(apple => {
        return getBanana().then(banana => `${apple} + ${banana}`);
    });
}
pickFruits().then(console.log);
*/


// async를 사용하면 동기적으로 코딩이 가능하다. 
// 하지만 또 문제가 있는데 그거슨 병렬적으로 처리가 되지 않아 시간을 많이 잡아먹는다는 점.
/*
async function pickFruits() {
    try {
        const apple = await getApple();
        const banana = await getBanana(); // await 덕분에 getApple()(1초) 이 다 실행 된 후 getBanan()(2초)가 실행되어 다 실행될따까지 총 2초가 걸린다. 
        return `${apple} + ${banana}`;
    } catch {
        // error handling
    }
}
pickFruits().then(console.log);
*/

// 병렬실행 해결 
// getApple()과 getBanana()는 연관있는 기능이 아닌데 순차적으로 실행되어 시간을 잡아먹고 있다. 비효율을 개선하기 위해 
// 아래와 같이 코딩
//async function pickFruits() {
//    const applePromise = getApple(); // promise는 생성되는 순간 실행 
//    const bananaPromise = getBanana(); // promise는 생성되는 순간 실행 
//    const apple = await applePromise; // 1초 
//    const banana = await bananaPromise; // 1초
//    return `${apple} + ${banana}`; // 1초면 수행 
//}
pickFruits().then(console.log);


// 3. useful Promise APIs
// 프로미스를 전달하면 모든 프로미스가 실행된 결과를 모아 배열로 리턴 
// 위 코드로 수동으로 병렬구조를 만들었던 것을 api를 이용해 손쉽게 해결 

//.all()
function pickAllFruits() {
    return Promise.all([getApple(), getBanana()]).then(fruits => fruits.join(' + '));
}
pickAllFruits().then(console.log);


//.race()
//프로미스를 전달하면 먼저 결과가 나온 것만 리턴한다. 

function pickOnlyOne() {
    return Promise.race([getApple(), getBanana()]);
}
pickOnlyOne().then(console.log);


// 숙제


