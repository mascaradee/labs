//Q1. iterate from 0 to 10 and print only even umbers(use continue)

for (let i = 0; i < 11; i++) {
    if (i % 2 != 0) {
        continue;
    }
    console.log(i);
}

// Q2. iterate from 0 to 10 and print numbers until reaching 8 (use break)

for (let i = 0; i < 11; i++) {
    
    if (i > 8) {
        break;
    }
    console.log(i);
}