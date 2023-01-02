import java.util.ArrayList;
import java.util.Scanner;

public class palindrome {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String word=sc.nextLine();
        sc.close();
        boolean result=isPalindrome(word);
        if(result){
            System.out.println("YES: "+word+" is palindrome");
        }
        else{
            System.out.println("NO: "+word+" is not palindrome");
        }
    }
    //logic is simple that if we found a pair of element we delete it and checks the following conditons in line 29 and 30.
    // After rearrangement the order it is plaindrome
    public static boolean isPalindrome(String word){
        ArrayList<Character> list=new ArrayList<Character>();
        for(int i=0;i<word.length();i++){
            if(list.contains(word.charAt(i))){
                list.remove((Character)word.charAt(i));
            }
            else{
                list.add(word.charAt(i));
            }
        }
        // if string is even then list is empty
        // if string is odd then list has 1 element left
        if(word.length()%2==0 && list.isEmpty() || word.length()%2==1 && list.size()==1){
            return true;
        }
        else{
            return false;
        }
    }
}
