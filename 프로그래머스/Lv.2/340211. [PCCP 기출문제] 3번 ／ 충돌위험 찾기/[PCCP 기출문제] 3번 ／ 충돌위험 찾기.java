            for(int j = 1; j < routes[i].length; j++){
                    for(int d = 0; d < 4; d++){
                        int nr = sr + dr[d], nc = sc + dc[d];
                        int temp = Math.abs(er - nr) + Math.abs(ec - nc);
                        if(temp < gap){
                            // System.out.println(nr + " " + nc);
                            gap = temp;
                            sr = nr;
                            sc = nc;
                            q[i].offer(new int[]{nr, nc});
                            break;
                        }
                    }
                }
            }
            // System.out.println();
        }
        
        
        
        while(isArrived(q)){
            int[][] grid = new int[100][100];
            for(int i = 0; i < q.length; i++){
                if(!q[i].isEmpty()){
                    int[] p = q[i].poll();
                    // System.out.println(p[0] + " " + p[1]);
                    if(grid[p[0]][p[1]] == 1) answer++;
                    grid[p[0]][p[1]]++;
                }
            }
            System.out.println();
        } 
        
        return answer;
    }
}

/*

문류센터 r,c 2차원 
r좌표 먼저, 그리고 c 좌표 먼저인 최단 거리 구해야됨.
포인트와 포인트의 이동 할 수 있는 경로는 1가지 길 밖에 없음.
