import java.util.Arrays;
import java.util.Scanner;

public class Solution3 {
    /*
    Create class Sim with below attributes: 
    simId - int customerName - String balance - double ratePerSecond - double circle - String

    Create class Solution and implement static method "transferCircle" in the Solution class. 
    This method will take array of Sim objects, circle1 String and circle2 string as parameters. 
    And will return another Sim array where the circle1 matches with the circle parameter of the 
    original Sim array and the circle parameter of the new array is set to circle2 and is also sorted 
    by means of ratePerSecond attribute in desending order.
    
    Write necessary getters and setters.

    Before calling "transferCircle" method in the main method, 
    read values for five Sim objects referring the attributes in above sequence along with a String circlee1 and circle2. 
    Then call the "transferCircle" method and write logic in main method to print all the attributes of the result obtained.
    */
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        Sim[] sim= new Sim[5];
        for(int i=0;i<5;i++){
            int simId = sc.nextInt();
            sc.nextLine();
            String customerName = sc.nextLine();
            double balance = sc.nextDouble();
            double ratePerSecond = sc.nextDouble();
            sc.nextLine();
            String circle = sc.nextLine();
            sim[i] = new Sim(simId,customerName,balance,ratePerSecond,circle);        
        }
        String circle1=sc.nextLine();
        String circle2=sc.nextLine();
        sc.close();
        Sim[] result=transferCircle(sim,circle1,circle2);
        for(int i=0;i<result.length;i++){
            System.out.println(result[i].getSimId()+" "+result[i].getCustomerName()+" "+result[i].getCircle()+" "+result[i].ratePerSecond);
        }
    }

    public static Sim[] transferCircle(Sim[] sim,String circle1,String circle2){
        Sim[] result=new Sim[0];
        for(int i=0;i<sim.length;i++){
            if(circle1.equals(sim[i].getCircle())){
                sim[i].setCircle(circle2);
                result=Arrays.copyOf(result, result.length+1);
                result[result.length-1]=sim[i];            
            }
        }
        for(int i=0;i<result.length-1;i++){
            for(int j=0;j<result.length-i-1;j++){
                if(result[j].getRatePerSecond()<result[j+1].getRatePerSecond()){
                    Sim temp=result[j];
                    result[j]=result[j+1];
                    result[j+1]=temp;
                }
            }
        }
        return result;
    }
}

class Sim{
    int simId;
    String customerName;
    double balance;
    double ratePerSecond;
    String circle;

    public Sim(int simId,String customerName,double balance,double ratePerSecond,String circle){
        this.simId=simId;
        this.customerName=customerName;
        this.balance=balance;
        this.ratePerSecond=ratePerSecond;
        this.circle=circle;
    }

    public int getSimId() {
        return this.simId;
    }

    public void setSimId(int simId){
        this.simId=simId;
    }

    public String getCustomerName() {
        return this.customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public double getBalance() {
        return this.balance;
    }

    public void setBalance(double balance) {
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
