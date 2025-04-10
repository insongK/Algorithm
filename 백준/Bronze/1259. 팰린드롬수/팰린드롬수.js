const readline = require("readline");

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

const input = [];

rl.on("line", (line) => {
  if (line === "0") {
    rl.close();
    return;
  }
  input.push(line);
});

rl.on("close", () => {
  input.forEach((num) => {
    const reversed = num.split("").reverse().join("");
    console.log(num === reversed ? "yes" : "no");
  });
});
