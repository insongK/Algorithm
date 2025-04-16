import sys

input = sys.stdin.readline().replace('\n','')

print(len(input.replace("dz=",'!').replace("z=", '!').replace("lj", '!').replace("nj", '!').replace("c=", '!').replace("c-", '!').replace("d-", '!').replace("s=", '!')))