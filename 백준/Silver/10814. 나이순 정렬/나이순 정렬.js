const readline = require("readline");

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

const input = [];

rl.question("", (count) => {
  count = parseInt(count);

  rl.on("line", (line) => {
    const [age, name] = line.split(" ");
    input.push({ age: Number(age), name });
    
    count--;
    if (count === 0) rl.close();
  });
});

rl.on("close", () => {
  input.sort((a, b) => a.age - b.age);
  for (const user of input) {
    console.log(`${user.age} ${user.name}`);
  }
});
