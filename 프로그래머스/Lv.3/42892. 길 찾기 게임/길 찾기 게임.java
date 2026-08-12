import java.util.*;

class Node{
    int value;
    int x;
    Node left, right;
    
    Node (int value, int x){
        this.value = value;
        this.x = x;
        left = right = null;
    }
}

class BT{
    Node root;
    List<Integer> al = new ArrayList<>();
    
    public void add(int value, int x) {
        root = addRecursive(root, value, x);
    }

    private Node addRecursive(Node current, int value, int x) {
        if (current == null) {
            return new Node(value, x);
        }
        if (x < current.x) {
            current.left = addRecursive(current.left, value, x);
        } else {
            current.right = addRecursive(current.right, value, x);
        }
        return current;
    }
    
    public void inOrder(Node node) {
        
        if (node != null) {
            al.add(node.value);
            inOrder(node.left);
            inOrder(node.right);
        }
    }
    public void preOrder(Node node) {
        if (node != null) {
            preOrder(node.left);
            preOrder(node.right);
            al.add(node.value);
        }
    }
}

class Solution {
    public int[][] solution(int[][] nodeinfo) {
        int[][] answer = {};
        BT bt = new BT();
        for(int i = 0; i < nodeinfo.length; i++){
            int max = 0;
            int idx = -1;
           for(int j = 0; j < nodeinfo.length; j++){
               if(max <= nodeinfo[j][1]){
                   max = nodeinfo[j][1];
                   idx = j;
               }
           }
            bt.add(idx + 1, nodeinfo[idx][0]);
            nodeinfo[idx][1] = -1;
       }
        answer = new int[2][nodeinfo.length];
        bt.inOrder(bt.root);
        answer[0] = bt.al.stream().mapToInt(Integer::intValue).toArray();
        bt.al.clear();
        bt.preOrder(bt.root);
        answer[1] = bt.al.stream().mapToInt(Integer::intValue).toArray();
        
        return answer;
    }
}