
// https://www.youtube.com/watch?v=3CUjtKJ7PJg&list=PLv2d7VI9OotTVOL4QmPfvJWPJvkmv6h-2&index=9

// // Q1. make a string out of an array
// {
//     const fruits = ['apple', 'banana', 'orange'];
//     // A.
//     console.log(fruits.toString());

//     // E.
//     console.log(fruits.join('^'));

// }
// // Q2. make an array out of a string
// {
//     const fruits = '🍎, 🥝, 🍌, 🍒';
//     // A.
//     console.log(fruits.split(',', 3));
//     // E.
//     // 동일
// }


// // Q3. make this array look like this: [5, 4, 3, 2, 1]
// {
//     const array = [1, 2, 3, 4, 5];
//     // A.
//     console.log(array.reverse());
//     // E.
//     // 동일
//     console.log(array); // 배열 자체가 reverse 된다. 
// }

// // Q4. make new array without the first two elements
// {
//     const array = [1, 2, 3, 4, 5];
//     // A.
//     console.log(array.slice(3,4));
//     console.log(array); // 배열자체 수정은 없다  cf.splice
//     // E.
//     // 동일

// }

class Student {
  constructor(name, age, enrolled, score) {
    this.name = name;
    this.age = age;
    this.enrolled = enrolled;
    this.score = score;
  }
}
const students = [
  new Student('A', 29, true, 45),
  new Student('B', 28, false, 80),
  new Student('C', 30, true, 90),
  new Student('D', 40, false, 66),
  new Student('E', 18, true, 88),
];

// // Q5. find a student with the score 90
// {
//     // A.
//     // console.clear();
//     let array = students.filter((value) => value.score === 90);
//     let name = array[0].name;
//     console.log(name);

//     // E.
//     // find : 조건이 true인 순간의 그 데이터를 리턴한다. 
//     const result = students.find(student => student.score === 90);
//     console.log(result);

// }

// // Q6. make an array of enrolled students
// {
//     // A.
//     console.clear();
//     let array = students.filter((value) => value.enrolled === true);
//     console.log(array);

//     // E.
//     // filter : 조건에 해당되는 데이터들을 배열로 반환한다. 
//     const result = students.filter((student) => student.enrolled );
//     console.log(result);
// }


// // Q7. make an array containing only the students' scores
// // result should be: [45, 80, 90, 66, 88]
// {
//     // A.
//     console.clear();
//     let array = [];    
//     // for (let i = 0; i < students.length; i++) {
//     //     array.push(students[i].score);
//     // }
//     // console.log(array);

//     for(let student of students){
//         array.push(student.score);
//     }
//     console.log(array);

//     // E.
//     // map: 배열을 다른 값으로 변환해서 그 값들을 배열로 리턴
//     const result = students.map((student) => student.score);
//     console.log(result);
// }

// // Q8. check if there is a student with the score lower than 50
// {
//     // A.
//     console.clear();
//     console.log(students.some((value) => value.score < 50));

//     // E.
//     // some : 조건에 맞는 것이 하나라도 있으면 true
//     const result = students.some((student) => student.score < 50);
//     console.log();
// }

// // Q9. compute students' average score
// {
//     // A.
//     // console.clear();
//     // const result = (students.map((student) => student.score).reduce((student, next) => student + next)) / students.length;
//     // console.log(result);


//    // E.
//    // reduce : 콜백함수를 실행해서 얻읕 값이 계속 누적되러 리턴됨.
//    const result = students.reduce((prev, curr) => {
//       console.log('---');
//       console.log(prev); // 누적된 값이 리턴
//       console.log(curr); // 주어진 배열의 현재 데이터 (인덱스 0 ~ 끝)
//        return prev + curr.score;
//    }, 0); // prev에 0부터 시작
// //    const result1 = students.reduce((prev, curr) => prev + curr.score, 0);
// //    console.log(result1 / students.length);

//     // let scoreSum = 0;
//     // for (let i = 0; i < students.length; i++) {
//     //     scoreSum += students[i].score;
//     // }
//     // let avg = scoreSum / students.length;
//     // console.log(avg);
// }


// // let scores = [];
// // Q10. make a string containing all the scores
// // result should be: '45, 80, 90, 66, 88'
// {
//     // A.
//     const result = students
//     .map((student) => student.score)
//     .join();
//     console.log(result);

//     // E.
//     //동일 
//     // console.clear();
//     // for (let student of students) {
//     //     scores.push(student.score);
//     // }
//     // console.log(scores.join());

// }
// Bonus! do Q10 sorted in ascending order
// result should be: '45, 66, 80, 88, 90'
{
    // A.
    const result = students
    .map((student) => student.score)
    .sort((a,b) => a - b)
    .join();
    console.log(result);

    // E.
    // 동일 
    // console.log(scores.sort((a,b) => a - b));
}