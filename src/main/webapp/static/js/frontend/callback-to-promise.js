// Callback Hell example
class UserStorage {
    loginUser(id, password) {
        return new Promise((resolve, reject) => {
            setTimeout(() =>{ 
                console.log(id);
                if( 
                    (id === 'macs' && password === 'happy') ||
                    (id === 'hi' && password === 'world')
                ) {
                    resolve(id);
                } else {
                    reject(new Error('not found'));
                }
            }, 2000);
        });        
    }
    getRoles(user) {
        return new Promise((resolve, reject) => {
            setTimeout(()=>{
                if (user === 'macs') {
                    resolve({name:'macs', role: 'admin'});
                } else {
                    reject(new Error('no access'));
                }
            }, 1000);    
        })
    }
}

// // 프로미스로 콜백지옥 해결하기 
// const user = new UserStorage();
// const id = prompt('enter your id');
// const password = prompt('enter your password');
// user
//     .loginUser(id, password)
//     .then(user.getRoles)
//     .then(user => alert(`Hello ${user.name}, you have a ${user.role} role`))
//     .catch(console.log);


// async로 콜백지옥 해결하기
const user = new UserStorage();
const id = prompt('enter your id');
const password = prompt('enter your password');
//
//async function caller(id, password) {
//    const rId = await user.loginUser(id, password);
//    const roles = await user.getRoles(rId);
//    return `Hello ${roles.name}, you have a ${roles.role} role`;
//}
//caller(id, password)
//.then(console.log)
//.catch(console.log);

