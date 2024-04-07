package PRA;

import java.util.Arrays;
import java.util.Scanner;

public class ipa1 {
    public static void main(String[] args){
        Associate[] as=new Associate[5];
        Scanner sc=new Scanner(System.in);
        for(int i=0;i<as.length;i++){
            int id=sc.nextInt();sc.nextLine();
            String name=sc.nextLine();
            String technology=sc.nextLine();
            int experienceInYears=sc.nextInt();sc.nextLine();
            
            as[i]=new Associate(id, name, technology, experienceInYears);
        }
        String search=sc.nextLine();
        sc.close();
        Associate[] res1=associatesForGivenTechnology(as, search);
        if(res1!=null){
            for(int i=0;i<res1.length;i++){
                System.out.println(res1[i].getId());
            }
        }
        else{
            System.out.println("No match found");
        }

    }
    public static Associate[] associatesForGivenTechnology(Associate[] as, String search){
        Associate[] res=new Associate[0];
        for(int i=0;i<as.length;i++){
            if(search.equalsIgnoreCase(as[i].getTechnology()) && as[i].getExperienceInYears()%5==0){
                res=Arrays.copyOf(res, res.length+1);
                res[res.length-1]=as[i];
            }
        }
        if(res.length>0){return res;}
        else{return null;}
    }

}

class Associate{
    int id;
    String name;
    String technology;
    int experienceInYears;

    public Associate(int id,String name,String technology,int experienceInYears){
        this.id=id;
        this.name=name;
        this.technology=technology;
        this.experienceInYears=experienceInYears;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTechnology() {
        return this.technology;
    }

    public void setTechnology(String technology) {
        this.technology = technology;
    }

    public int getExperienceInYears() {
        return this.experienceInYears;
    }

    public void setExperienceInYears(int experienceInYears) {
        this.experienceInYears = experienceInYears;
    }

}