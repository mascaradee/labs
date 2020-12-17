/*
class Counter {
    constructor() {
        this.counter = 0;
    }

    increase() {
        this.counter++;
        console.log(this.counter);
    }
}

const coolCounter = new Counter();
coolCounter.increase();
coolCounter.increase();
coolCounter.increase();
*/ 

/* 
// 5의 배수마다 로그 찍기
class Counter {
    constructor() {
        this.counter = 0;
    }

    increase() {
        this.counter++;
        console.log(this.counter);
        if (this.counter % 5 === 0) {
            console.log('yo!');
        }
    }
}

const coolCounter = new Counter();
coolCounter.increase();
coolCounter.increase();
coolCounter.increase();
coolCounter.increase();
coolCounter.increase();
*/

/* 
// 근데 로그 내용을 바꾸고 싶거나 알럿으로 띄우고 싶다면?
class Counter {
    constructor() {
        this.counter = 0;
    }

    increase(runIf5Times) {
        this.counter++;
        console.log(this.counter);
        if (this.counter % 5 === 0) {
            runIf5Times(); // 호출하는 사람에게 수정할 수 있게 한다. 
        }
    }
}

function printSomething () {
    console.log('Wow');
}
const coolCounter = new Counter();
coolCounter.increase(printSomething); // 매개변수 명의 큰 의미가 없다 매개변수가 전달하는  ref가 중요
coolCounter.increase(printSomething);
coolCounter.increase(printSomething);
coolCounter.increase(printSomething);
coolCounter.increase(printSomething);
*/

/*
// 근데 어떤 숫자에 로그가 출력이 되는지도 알고 싶으면?
class Counter {
    constructor() {
        this.counter = 0;
    }

    increase(runIf5Times) {
        this.counter++;
        console.log(this.counter);
        if (this.counter % 5 === 0) {
            runIf5Times(this.counter); // 함수실행 시 this.counter를 전달한다. 
        }
    }
}

function printSomething (num) {
    console.log(`Wow + ${num}`);
}

function alertNum(num) {
    alert(`Wow + ${num}`);
}
const coolCounter = new Counter();
coolCounter.increase(printSomething); // 매개변수 명의 큰 의미가 없다 매개변수가 전달하는  ref가 중요
coolCounter.increase(printSomething);
coolCounter.increase(printSomething);
coolCounter.increase(printSomething);
coolCounter.increase(printSomething);
coolCounter.increase(printSomething);
coolCounter.increase(printSomething);
coolCounter.increase(printSomething);
coolCounter.increase(printSomething);
coolCounter.increase(alertNum);
*/


// increase를 호출할때마다 매개변수로 함수를 전달하는 건 넘 힘들어 
class Counter {
    constructor(runEveryFiveTimes) {
        this.counter = 0;
        this.callback = runEveryFiveTimes;
    }

    increase() {
        this.counter++;
        console.log(this.counter);
        if (this.counter % 5 === 0) {
            
            // 콜백함수가 없이 호출되는 경우 아래와 같은 오류로 시스템이 정지되므로 에러처리 로직이 필요 
            //Uncaught TypeError: this.callback is not a function
            /*
            if( this.callback ){
                this.callback(this.counter); 
            }
            */
           // 위 if문을 더 간결하게 아래와 같이
           this.callback && this.callback(this.counter);
        }
    }
}

function printSomething (num) {
    console.log(`Wow + ${num}`);
}

function alertNum(num) {
    alert(`Wow + ${num}`);
}
const printCounter = new Counter(printSomething); // 콜백함수가 없는 경우 오류 
const alertCounter = new Counter(alertNum); // 콜백함수가 없는 경우 오류 

printCounter.increase();
printCounter.increase();
printCounter.increase();
printCounter.increase();
printCounter.increase();
alertCounter.increase();
alertCounter.increase();
alertCounter.increase();
alertCounter.increase();
alertCounter.increase();

// 클래스에 우리가 원하는 기능을 모두 정의하면 사용자가 컨트롤 할수도 없고 재사용이 힘들다. 
// 이때 콜백함수를 사용하게 되면 사용자 입맛에 맞게 사용할 수 있다. 
// 하나의 클래스로 여러 인스턴스를 만들어서 사용할 수 있게 된다. 