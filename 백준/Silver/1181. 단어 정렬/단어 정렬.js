const readline = require("readline");

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout,
});

const input = new Set();

rl.question("", (count) => {
    count = parseInt(count);

    rl.on("line", (line) => {
        input.add(line)
        count--;
        if (count === 0) rl.close();
    });
});

rl.on("close", () => {
    const entryarray = [...input]

    const sortedSet = entryarray.sort((a, b) => {
        if (a.length !== b.length) return a.length - b.length
        else return a.localeCompare(b)
    });
    for (const word of sortedSet) {
        console.log(word);
    }
});
