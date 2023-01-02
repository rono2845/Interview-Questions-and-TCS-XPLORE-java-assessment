import java.util.Arrays;
import java.util.Scanner;

public class practical {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        Sim[] sim=new Sim[4];
        for(int i=0;i<4;i++){
            int id=sc.nextInt();
            sc.nextLine();
            String company=sc.nextLine();
            int balance=sc.nextInt();
            double ratePerSecond=sc.nextDouble();
            sc.nextLine();
            String circle=sc.nextLine();
            sim[i]=new Sim(id, company, balance, ratePerSecond, circle);
        }
        String search_circle=sc.nextLine();
        double search_rate=sc.nextDouble();
        sc.close();
        Sim[] result=matchAndSort(sim,search_circle,search_rate);
        for(int i=0;i<result.length;i++){
            System.out.println(result[i].getId());
        }
    }
    
    public static Sim[] matchAndSort(Sim[] sim, String search_circle, double search_rate){
        /*
            result is the new array that will be returned 
            We created a single instance of result because we dont know how much data will fit in it
            So we used Arrays.copyOf() https://www.geeksforgeeks.org/arrays-copyof-in-java-with-examples/ 
            method to increase the size of the result array as per the condition.
        */
        Sim[] result=new Sim[0];
        for(int i=0;i<sim.length;i++){
            if(sim[i].getCircle().equals(search_circle) && search_rate>sim[i].getRatePerSecond()){
                result=Arrays.copyOf(result, result.length+1);//increase size 
                result[result.length-1]=sim[i];//assigning the rightfull value that will be sorted
            }
        }
        for(int i=0;i<result.length-1;i++){
            for(int j=0;j<result.length-i-1;j++){
                if(result[j].getBalance()<result[j+1].getBalance()){
                    Sim temp=result[j];
                    result[j]=result[j+1];
                    result[j+1]=temp;
                }
            }
        }
    return result;
    }
}
/*Create class Sim with below attributes: id - int company - String balance - int ratePerSecond - double circle - String

Create class Solution and implement static method "matchAndSort" in the Solution class. 
This method will take array of Sim objects, search_circle String and search_rate double as parameters. 
And will return another Sim array where the search_circle matches with the circle parameter of the original Sim array and 
the search_rate double is greater than the original array of Sim object's ratePerSecond attribute 
which is also sorted by means of balance attribute in descending order.

Write necessary getters and setters.

Before calling "matchAndSort" method in the main method, read values for four Sim objects referring the attributes 
in above sequence along with a String search_circle and a double search_rate. Then call the "matchAndSort" method and 
write logic in main method to print the id's of the result obtained. */
class Sim{
    int id;
    String company;
    int balance;
    double ratePerSecond;
    String circle;

    public Sim(int id,String company,int balance,double ratePerSecond,String circle){
        this.id=id;
        this.company=company;
        this.balance=balance;
        this.ratePerSecond=ratePerSecond;
        this.circle=circle;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompany() {
        return this.company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public int getBalance() {
        return this.balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public double getRatePerSecond() {
        return this.ratePerSecond;
    }

    public void setRatePerSecond(double ratePerSecond) {
        this.ratePerSecond = ratePerSecond;
    }

    public String getCircle() {
        return this.circle;
    }

    public void setCircle(String circle) {
        this.circle = circle;
    }

}
