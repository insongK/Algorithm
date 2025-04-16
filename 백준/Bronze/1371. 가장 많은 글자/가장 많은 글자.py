import sys

string = sys.stdin.readlines()
input = [line.strip() for line in string]

d = {}

for i in range(len(input)):
    for ch in input[i].strip().lower():
        if ch.isalpha():
            d[ch] = d.get(ch, 0) + 1

max_count = max(d.values())

answer = []

for k, v in d.items():
    if v == max_count:
        answer.append(k)

answer.sort()

for ans in answer:
    print(ans, end='')