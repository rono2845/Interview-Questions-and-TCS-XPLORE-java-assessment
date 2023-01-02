import java.util.Scanner;
//Deloitte Question
public class Solution2 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        sc.close();
        int last=arr[0]+arr[1];
        rotate(arr, 1);
        for(int i=0;i<n-1;i++){
            arr[i]=arr[i]+arr[i+1];
        }
        arr[arr.length-1]=last;
        for(int i=0;i<n;i++){
            System.out.println(arr[i]+" ");
        }
    }

    public static void rotate(int arr[], int d){
        int p=1;
        while (p<=d) {
            int last=arr[0];
            for (int i=0;i<arr.length-1;i++) {
                arr[i]=arr[i+1];
            }
            arr[arr.length-1]=last;
            p++;
        }
    }
}
