const readline = require("readline");

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

let input = new Set();

rl.question("", (line) => {
    for (let i = 1; i <= line.length; i++) {
        for (let j = 0; j <= line.length - i; j++) {
            input.add(line.substr(j, i));
        }
    }
    console.log(input.size)
    rl.close()
})