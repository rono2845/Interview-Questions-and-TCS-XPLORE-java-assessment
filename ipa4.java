package PRA;
// Practice1_FA_SBQ_Java
import java.util.*;
public class ipa4 {
    public static void main(String args[]) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();sc.nextLine();
        Employee[] e=new Employee[num];
        for(int i=0;i<e.length;i++){
            int empId=sc.nextInt();sc.nextLine();
            String empName=sc.nextLine();
            double empSalary=sc.nextDouble();sc.nextLine();
            boolean empStatus=sc.nextBoolean();//sc.nextLine();
            e[i]=new Employee(empId,empName,empSalary,empStatus);
        }
        Employee res1=employeeWithMaxSalaryWithActive(e);
        sc.close();
        if(res1!=null){
            System.out.println("Emp ID: "+res1.getEmpId());
            System.out.println("Name: "+res1.getEmpName());
            System.out.println("Salary: "+res1.getEmpSalary());
            System.out.println("Status: "+res1.getEmpStatus());     
        }
        else{
            System.out.println("No Employee found with this condition.");
        }
    }
    // user defined method
    public static Employee employeeWithMaxSalaryWithActive(Employee[] e){
        Employee[] result=new Employee[0];
        for(int i=0;i<e.length;i++){
            if(e[i].getEmpStatus()){
                result=Arrays.copyOf(result,result.length+1);
                result[result.length-1]=e[i];
            }   
        }
        for(int i=0;i<result.length-1;i++){
            for(int j=0;j<result.length-1-i;j++){
                if(result[j].getEmpSalary()<result[j+1].getEmpSalary()){
                    Employee temp=result[j];
                    result[j]=result[j+1];
                    result[j+1]=temp;
                }
            }
        }
        return result.length>0 ? result[1]:null;
    }
}

class Employee{
    // private attributes
    int empId;
    String empName;
    double empSalary;
    boolean empStatus;
    
    // constructors
    public Employee(int empId,String empName,double empSalary,boolean empStatus){
        this.empId=empId;
        this.empName=empName;
        this.empSalary=empSalary;
        this.empStatus=empStatus;
    }
    
    //setter
    public void setEmpId(int empId){
        this.empId=empId;
    }
    public void setName(String empName){
        this.empName=empName;
    }
    public void setEmpSalary(double empSalary){
        this.empSalary=empSalary;
    }
    public void setEmpStatus(boolean empStatus){
        this.empStatus=empStatus;
    }
    
    //getter
    public int getEmpId(){return this.empId;}
    public String getEmpName(){return this.empName;}
    public double getEmpSalary(){return this.empSalary;}
    public boolean getEmpStatus(){return this.empStatus;}
    
}
