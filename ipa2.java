// Arijit Ipa17
//https://github.com/Arijit-SE/Java-Solutions-TCS-IPA-Questions/blob/main/IPA17/IPA17.txt
// Implementing this will clear doubts

package PRA;
import java.util.Scanner;
import java.util.Arrays;

public class ipa2 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        Student st[] =new Student[4];
        for(int i=0;i<st.length;i++){
            int rollNo=sc.nextInt();sc.nextLine();
            String name=sc.nextLine();
            String subject=sc.nextLine();
            char grade=sc.next().charAt(0);sc.nextLine();
            String date=sc.nextLine();
            String exMon="";
            exMon+=date.charAt(3);
            exMon+=date.charAt(4);

            st[i]=new Student(rollNo, name, subject, grade, date, exMon);
        }
        char search=sc.next().charAt(0);sc.nextLine();
        int searchIntMonth=sc.nextInt();sc.nextLine();
        sc.close();
        Student[] res1= findStudentByGradeAndMonth(st, search, searchIntMonth);
        if(res1!=null){
            for(int i=0;i<res1.length;i++){
                System.out.println(res1[i].getName()+" "+res1[i].getSubject());
            }
            System.out.println(res1.length);
        }
        else{
            System.out.println("No student found");
        }
    }
    
    public static Student[] findStudentByGradeAndMonth(Student st[], char search,int searchIntMonth){
        Student[] result= new Student[0];
        for(int i=0;i<st.length;i++){
            if(searchIntMonth==Integer.parseInt(st[i].getMonth()) &&  search==st[i].getGrade()){
                result=Arrays.copyOf(result, result.length+1);
                result[result.length-1]=st[i];
            }
        }
        Arrays.sort(result,0,result.length,(a,b)->a.getRollNo()-b.getRollNo()); 
        //Obj sorting ASC wise as per rollno.
        // DSC wise would be Arrays.sort(result,0,result.length,(a,b)->b.getRollNo()-a.getRollNo());
        return result.length>0 ? result : null;
    }
}

class Student{
    int rollNo;
    String name;
    String subject;
    char grade;
    String date;
    String month;

    public Student(int rollNo,String name,String subject, char grade, String date, String month){
        this.rollNo=rollNo;
        this.name=name;
        this.subject=subject;
        this.grade=grade;
        this.date=date;
        this.month=month;
    }


    public int getRollNo() {
        return this.rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return this.subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public char getGrade() {
        return this.grade;
    }

    public void setGrade(char grade) {
        this.grade = grade;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMonth() {
        return this.month;
    }
}