//             while(!waitQ.isEmpty()){
//                 int[] task = waitQ.peek();
//                 if(task[1] <= time) pq.offer(waitQ.poll());
//                 else break;
//             }
//             break;
            while(!waitQ.isEmpty()){
                int[] task = waitQ.peek();
                if(task[1] <= time) pq.offer(waitQ.poll());
                else break;
            }
            if(!pq.isEmpty()){
                int[] task = pq.poll();
                time += task[2];
                answer += (time - task[1]);
            }
            else time++;
            
            // System.out.println(time + " " + answer);
 
            // System.out.println(Arrays.toString(task));
        }
        
        
        return answer / jobs.length;
    }
}

/*

[작업 번호, 작업 요청 시간, 작업의 소요 시간] queue
if disk controller가 작업X and queue is not empty:
    가장 우선순위가 높은 작업을 poll
    우선순위가 높은 것은 소요시간 짧은 것, 작업의 요청시간이 빠른 것, 작업의 번호가 작은 것 순
    하드디스크는 한 번에 하나의 작업만 수행.

*/