const readline = require("readline");

const rl = readline.createInterface({
  input: process.stdin,
  ouput: process.stdou,
});

rl.question("", (nums) => {
  const num = nums.split(" ");
  console.log(num[0] / num[1]);
  rl.close();
});
