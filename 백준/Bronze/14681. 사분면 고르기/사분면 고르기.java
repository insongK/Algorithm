import java.util.Scanner;

class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();
        int Y = sc.nextInt();
        
        if(X > 0 && Y > 0){
            System.out.print(1);
        }
        else if(X < 0 && Y > 0){
            System.out.print(2);
        }
        else if(X < 0 && Y < 0){
            System.out.print(3);
        }
        else{
            System.out.print(4);
        }
    }
}