'use strict';

// class : template
// object : instance of a class
// class는 ES6에 추가 

// 1. Class declarations
class Person {
    // constructor
    constructor(name, age) {
        // fields
        this.name = name; // this = object 즉, 새로 생성할 인스턴스를 뜻함
        this.age = age;
    }

    // methods
    speak() {
        console.log(`${this.name}: hello!`);
    }
}

const ellie = new Person('ellie', 20);
console.log(ellie.name); // ellie
console.log(ellie.age); // 20
ellie.speak(); // ellie: hellio!

// 2. Getter and Setter
class User {
    constructor(firstName, lastName, age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    get age() { // getter를 정의하는 순간 constructor의 this.age는 메모리를 읽는 것이 아닌 이 getter를 호출하게 된다.
        return this._age;
    }
    set age(value) { // setter를 정의하는 순간 constructor의 `= age`는 바로 메모리에 값을 할당하는 것이 아닌 setter를 호출하게 된다. 
    
        /*
        // 사용자가 이상한 값을 넣는것을 걸러낼 수 있는 방법 1
        if (value < 0) { 
            throw Error('age can not be negative');
        }

        // 사용자가 이상한 값을 넣는것을 걸러낼 수 있는 방법 2
        this._age = value < 0 ? 0 : value;    
        */
        this._age = value;       
    }
     // 그런데 문제는 `= value`로 인해 또 다시 setter가 무한반복 호출되면 아래와 같은 에러가 발생
     // Uncaught RangeError: Maximum call stack size exceeded
     // 이를 방지하기위해 getter, setter 내의 변수명은 constructor와는 다르게 설정한다. 
     // 보통은 변수명 앞에 '_'을 붙여둔다.
     }

const user1 = new User('Steve', 'Jobs', -1);
console.log(user1.age);

// 3. Fields (pulic, private)
// 최근 추가된 부분이라 지원되는 브라우제가 적음 

//class Example {
//    publicField = 1; // constructor 없이 정의 가능
//    #privateField = 9; // private 변수 선언은 앞에 `#`을 추가하면 된다. 
//}
const e1 = new Example();
console.log(e1.publicField); // 1 : 외부에서 접근 가능한 변수
console.log(e1.privateField); // undefined : 외부에서 접근 불가능한 변수 

// 4. Static properties and methods
// 최근 추가된 부분이라 지원되는 브라우제가 적음 

//class Article {
//    static publisher = 'Always usable';
//
//    constructor(articleNumber) {
//        this.articleNumber = articleNumber;
//    }
//
//    static printPublisher() {
//        console.log(Article.publisher);
//    }
//}

const a1 = new Article(1);
const a2 = new Article(2);
console.log(a1.publisher); // undeifned : static에 접근하는 방법은 클래스명을 통해 직접 접근해야함.
console.log(Article.publisher); // Always usable
Article.printPublisher();

// 5. Inheritance
class Shape { // 모든 도형에 공통되는 부분을 클래스로 만들어 놓는다.
    constructor(width, height, color) {
        this.width = width;
        this.height = height;
        this.color = color;
    }
    draw() {
        console.log(`drawing ${this.color} color of`); // 여기를 수정하면 모든 상속 받은 부분이 수정됨.
    }
    getArea() {
        return this.width * this.height;
    }
}

class Rectangle extends Shape {} // 각 도형 클래스를 만들 때 Shape 클래스를 상속하면 해당 클래스의 필드, 메소드를 사용할 수 있다. 
const rectangle = new Rectangle(20, 20, 'blue'); // rectangle 인스턴스 생성
rectangle.draw(); // rectangle 인스턴스는 Rectangle 클래스로 만들어졌지만 Rectangle이 Shape로부터 상속받은 필드, 메소드를 모두 사용할 수 있다. 

class Triangle extends Shape {
    // overriding
    getArea() {
        return (this.width * this.height) / 2; 
    }
    draw() {
        console.log('▲'); // 오버라이딩 되어 기존 부모에 있던 내용이 사라짐 
        super.draw(); // 부모의 내용도 그대로 사용하고 싶을 때 
    }
}
const triangle = new Triangle (20, 20, 'red');
console.log(triangle.getArea());
triangle.draw();


// 6. Class checking: instanceof
console.log(rectangle instanceof Rectangle); // true
console.log(triangle instanceof Rectangle); // false
console.log(triangle instanceof Triangle); // true
console.log(rectangle instanceof Shape);  // true
console.log(rectangle instanceof Object); // true