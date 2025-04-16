const readline = require("readline");

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout
});

const input = [];

rl.on("line", (line) => {
  input.push(line.trim());
}).on("close", () => {
  const T = Number(input[0]);
  let idx = 1;

  for (let t = 0; t < T; t++) {
    const p = input[idx++];
    const n = Number(input[idx++]);
    let arr = input[idx++];

    arr = arr === "[]" ? [] : arr.slice(1, -1).split(",").map(Number);

    let isReversed = false;
    let front = 0;
    let back = arr.length;
    let isError = false;

    for (const cmd of p) {
      if (cmd === 'R') {
        isReversed = !isReversed;
      } else if (cmd === 'D') {
        if (front >= back) {
          isError = true;
          break;
        }
        isReversed ? back-- : front++;
      }
    }

    if (isError) {
      console.log("error");
    } else {
      const result = arr.slice(front, back);
      if (isReversed) result.reverse();
      console.log("[" + result.join(",") + "]");
    }
  }
});
