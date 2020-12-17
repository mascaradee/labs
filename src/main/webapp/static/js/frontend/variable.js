const sb1 = Symbol('id');
const sb2 = Symbol('id');
console.log(sb1 === sb2); // false : 같은 문자열 'id'로 심볼을 만들었으나 고유한 다른 식별자로 인식됨

const gSb1 = Symbol.for('id');
const gSb2 = Symbol.for('id');
console.log(gSb1 === gSb2); // true
console.log(`value: ${sb1.description}, type: ${typeof sb1}`); // variable.js:8 value: id, type: symbol