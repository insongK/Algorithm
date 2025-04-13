const readline = require("readline");

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout,
});

const input = [];

rl.question("", (count) => {
    count = parseInt(count);

    rl.on("line", (line) => {
        const [x, y] = line.split(" ");
        input.push({ x: Number(x), y: Number(y) });

        count--;
        if (count === 0) rl.close();
    });
});

rl.on("close", () => {
    input.sort((a, b) => {
        if (a.x - b.x === 0) {
            return a.y - b.y
        }
        else return a.x - b.x
    });
    for (const pos of input) {
        console.log(`${pos.x} ${pos.y}`);
    }
});
