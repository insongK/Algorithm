import sys

input = sys.stdin.readline

a, b = map(int, input().split())

low = min(a, b)
high = max(a, b)

print((low + high) * (high - low + 1) // 2)
