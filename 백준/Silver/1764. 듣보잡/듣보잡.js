const readline = require("readline");

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

let input = [];
const set = new Set();

rl.on("line", (line) => {
    input.push(line.trim());
}).on("close", () => {
    const [N, M] = input[0].split(" ").map(Number);

    for (let i = 1; i <= N; i++) {
        set.add(input[i]);
    }

    let count = 0;
    const answer = [];

    for (let i = N + 1; i <= N + M; i++) {
        if (set.has(input[i])) {
            count++;
            answer.push(input[i]);
        }
    }

    answer.sort();
    console.log(count);
    for (const name of answer) {
        console.log(name);
    }
});
