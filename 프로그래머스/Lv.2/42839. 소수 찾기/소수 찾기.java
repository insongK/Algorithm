            }
        }
    }
    
    public void check(char[] num){
        StringBuilder sb = new StringBuilder();
        for(char c : num) sb.append(c);
        int n = Integer.parseInt(sb.toString());
        // System.out.println(n);
        
        if(set.contains(n)) return;
        if(n < 2) return;
        
        for(int i = 2; i <= Math.sqrt(n); i++){
            if(n % i == 0) return;
        }
        
        set.add(n);
    }
    
    public int solution(String numbers) {
        arr = numbers.toCharArray();
        
        for(int i = 1; i <= arr.length; i++){
            num = new char[i];
            permnum = new char[i];
            visit = new boolean[i];
            comb(0, 0, i);
        }
        // System.out.println(set);
        return set.size();
    }
}

/*

7
String.toCharArray()
subset()

123456

combination

123

nPn permutaion

소수 찾기

*/