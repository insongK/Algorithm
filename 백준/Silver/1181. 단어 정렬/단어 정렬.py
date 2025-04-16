import sys

input = sys.stdin.readlines()
words = [line.strip() for line in input]
words.pop(0)

words = list(set(words))

words.sort(key = lambda x : (len(x), x))

for word in words:
    print(word)