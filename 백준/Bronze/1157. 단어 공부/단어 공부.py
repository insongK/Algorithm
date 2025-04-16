S = input()
S = S.upper()

Al = dict()
for i in 'ABCDEFGHIJKLMNOPQRSTUVWXYZ':
    Al[i] = 0
       
for i in S:
    Al[i] += 1
    
Al = sorted(Al.items(), key = lambda item: item[1], reverse = True)

if Al[0][1] == Al[1][1]:
    print('?')
else:
    print(Al[0][0])
    