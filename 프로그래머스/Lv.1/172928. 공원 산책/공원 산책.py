def solution(parks, routes):
    start = []
    x_list = []
    for i, park in enumerate(parks):
        for j, p in enumerate(park):
            if p == "S":
                start = [i,j]
            if p == "X":
                x_list.append([i,j])
    direction = {"E":[0,1],"W":[0,-1],"N":[-1,0],"S":[1,0]}
    for route in routes:
        x, y = start
        op,n = route.split(" ")
        dx,dy = direction[op]
        cnt = 0
        for i in range(1,int(n) + 1):
            if 0 <= x + i*dx < len(parks) and 0 <= y + i*dy < len(parks[0]):
                if [x + i*dx, y + i*dy] in x_list: 
                    break
                cnt += 1
        if cnt == int(n):
            x += cnt * dx
            y += cnt * dy
            start = [x,y]
            
    return start