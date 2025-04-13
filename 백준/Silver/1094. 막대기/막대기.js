const readline = require("readline");

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

let input = [];

rl.question("", (line) => {
    console.log(Number(line).toString(2).split("1").length - 1)
    rl.close()
})
