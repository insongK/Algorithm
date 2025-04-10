const readline = require("readline");

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

const input = [];

rl.on("line", (line) => {
  if (line === "#") {
    rl.close();
    return;
  }
  input.push(line);
});

rl.on("close", () => {
  input.forEach((string) => {
    const split_string = string.toLowerCase().split("");
    let count = 0;
    for (const element of split_string) {
      switch (element) {
        case "a":
          count++;
          break;

        case "e":
          count++;
          break;

        case "i":
          count++;
          break;

        case "o":
          count++;
          break;

        case "u":
          count++;
          break;
      }
    }
    console.log(count);
  });
});
