import java.util.*;
public class fibonacciApproachComaprison{
    public static int fibonacciRecursive(int n){
        if(n<=1){
            return n;
        }
        else{
            return fibonacciRecursive(n-1)+fibonacciRecursive(n-2);
        }
    }
    public static int fibonacciIterative(int n){
        int a=0,b=1,sum;
        for(int i=2;i<=n;i++){
            sum=a+b;
            a=b;
            b=sum;
        }
        return b;
    }
    public static void measurefibonacciTimes(int N) {
        long start = System.nanoTime();
        fibonacciRecursive(N);
        long fibonacciRecursiveTime = System.nanoTime() - start;

        start = System.nanoTime();
        fibonacciIterative(N);
        long fibonacciIterativeTime = System.nanoTime() - start;
        System.out.println("Dataset Size: " + N);
        System.out.println("Fibonacci Recursive Time: " + fibonacciRecursiveTime + " ns");
        System.out.println("fibonacci Iterative Time: " + fibonacciIterativeTime + " ns");
        System.out.println();
    }
    public static void main(String[] args) {
        int[] datasetSizes = {10, 30, 50};
        for (int size : datasetSizes) measurefibonacciTimes(size);
    }  
}
