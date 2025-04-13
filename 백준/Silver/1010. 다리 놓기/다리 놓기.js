const readline = require("readline");

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

let input = [];

rl.on("line", (line) => {
    input.push(line.trim());
}).on("close", () => {
    const total = Number(input[0])
    const answer = []

    for (let i = 1; i <= total; i++) {
        const [N, M] = input[i].split(" ").map(Number);

        let comb = 1;

        for (let j = 1; j <= N; j++) {
            comb *= (M - j + 1);
            comb /= j;
        }

        answer.push(Math.round(comb));
    }

    for (const e of answer) {
        console.log(e)
    }
});
