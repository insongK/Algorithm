const readline = require("readline");

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

rl.question("", (length) => {
  rl.question("", (number) => {
    const sum = number
      .split("")
      .reduce((acc, cur) => acc + Number(cur), 0);
    console.log(sum);
    rl.close();
  });
});
