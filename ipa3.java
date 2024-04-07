package PRA;

import java.util.Arrays;
import java.util.Scanner;

public class ipa3 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        Employee[] e=new Employee[4];
        for(int i=0;i<e.length;i++){
            int empId=sc.nextInt();sc.nextLine();
            String name=sc.nextLine();
            String branch=sc.nextLine();
            double rating=sc.nextDouble();sc.nextLine();
            boolean compTrans=sc.nextBoolean();sc.nextLine();

            e[i]=new Employee(empId,name,branch,rating,compTrans);
        }
        String search=sc.nextLine();
        sc.close();
        int res1=findCountOfEmployeesUsingCompTransport(e, search);
        if(res1!=0){System.out.println(res1);}
        else{System.out.println("No such employees");}

        Employee res2=findEmployeeWithSecondHighestRating(e);
        if(res2!=null){System.out.println(res2.getEmpId()+" "+res2.getName());}
        else{System.out.println("All Employees using company transport");} 

    }

    public static int findCountOfEmployeesUsingCompTransport(Employee[] e,String search){
        int count=0;
        for(int i=0;i<e.length;i++){
            if(e[i].getCompTrans() && search.equalsIgnoreCase(e[i].getBranch())){
                count+=1;
            }
        }
        return count;
    }
    public static Employee findEmployeeWithSecondHighestRating(Employee[] e){
        Employee[] result=new Employee[0];
        for(int i=0;i<e.length;i++){
            if(!e[i].getCompTrans()){
                result=Arrays.copyOf(result, result.length+1);
                result[result.length-1]=e[i];    
            }
        }
        for(int i=0;i<result.length-1;i++){
            for(int j=0;j<result.length-1-i;j++){
                if(result[j].getRating()<result[j+1].getRating()){
                    Employee temp=result[j];
                    result[j]=result[j+1];
                    result[j+1]=temp;
                }
            }
        }
        return result.length>0 ? result[1] : null;
    }
        
}
class Employee{
    int empId;
    String name;
    String branch;
    double rating;
    boolean compTrans;
   
    public Employee(int empId, String name, String branch, double rating, boolean compTrans){
        this.empId=empId;
        this.name=name;
        this.branch=branch;
        this.rating=rating;
        this.compTrans=compTrans;
    }

    public int getEmpId() {
        return this.empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBranch() {
        return this.branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public double getRating() {
        return this.rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public boolean isCompTrans() {
        return this.compTrans;
    }

    public boolean getCompTrans() {
        return this.compTrans;
    }

    public void setCompTrans(boolean compTrans) {
        this.compTrans = compTrans;
    }

}
