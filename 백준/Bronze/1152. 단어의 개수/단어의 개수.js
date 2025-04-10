const readline = require("readline");

const rl = readline.createInterface({
  input: process.stdin,
  ouput: process.stdou,
});

rl.question("", (words) => {
  const word = words.split(" ");
  let count = 0;
  for (const element of word) {
    if ("" === element) continue;
    count++;
  }
  console.log(count);
  rl.close();
});
