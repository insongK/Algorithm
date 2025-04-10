const readline = require("readline");

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

const frequancy_ch = (str) => {
  let alpha = new Map();
  for (const ch of str.toUpperCase().split("")) {
    alpha.set(ch, (alpha.get(ch) ?? 0) + 1);
  }
  const sorted = [...alpha.entries()].sort((a, b) => b[1] - a[1]);
  const sortedMap = new Map(sorted);

  let max_val = -1,
    max_key;

  sortedMap.forEach((val, key) => {
    if (max_val === -1) {
      max_key = key;
      max_val = val;
    } else {
      if (val < max_val) sortedMap.delete(key);
    }
  });

  if (sortedMap.size != 1) return "?";
  else return max_key;
};

rl.question("", (str) => {
  console.log(frequancy_ch(str));
  rl.close();
});
