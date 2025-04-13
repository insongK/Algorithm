const readline = require("readline");

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

let input = [];

rl.on("line", (line) => {
    input.push(line.trim());
}).on("close", () => {
    const N = +input[0];
    const cards = new Set(input[1].split(" ").map(Number));

    const M = +input[2];
    const checks = input[3].split(" ").map(Number);

    const result = checks.map((num) => (cards.has(num) ? 1 : 0));
    console.log(result.join(" "));
});
