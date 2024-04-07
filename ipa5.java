package PRA;

import java.util.Scanner;
import java.util.Arrays;
public class ipa5 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        Engine[] e=new Engine[4];
        for(int i=0;i<e.length;i++){
            int engineId=sc.nextInt();sc.nextLine();
            String engineName=sc.nextLine();
            String engineType=sc.nextLine();
            double enginePrice=sc.nextDouble();sc.nextLine();

            e[i]=new Engine(engineId, engineName, engineType, enginePrice);
        }
        String search1=sc.nextLine();
        String search2=sc.nextLine();
        sc.close();
        
        int res1=findAvgEnginePriceByType(e, search1);
        if(res1!=0){System.out.println(res1);}
        else{System.out.println("There are no engine with given type");}
        
        Engine[] res2=searchEngineByName(e, search2);
        if(res2!=null){
            for(int i=0;i<res2.length;i++){
                System.out.println(res2[i].getEngineId());
            }
        }
        else{System.out.println("There are no engine with the given name");}

    }
    public static int findAvgEnginePriceByType(Engine[] e,String search1){
        int avg=0;
        int count=0;
        for(int i=0;i<e.length;i++){
            if(search1.equalsIgnoreCase(e[i].getEngineType())){
                avg+=e[i].getEnginePrice();
                count++;
            }
        }
        avg=avg/count;
        return avg;
    }

    public static Engine[] searchEngineByName(Engine[] e,String search2){
        Engine[] result=new Engine[0];
        for(int i=0;i<e.length;i++){
            if(search2.equalsIgnoreCase(e[i].getEngineName())){
                result=Arrays.copyOf(result,result.length+1);
                result[result.length-1]=e[i];
            }
        }
        Arrays.sort(result,0,result.length,(a,b)->a.getEngineId()-b.getEngineId());
        return result.length>0 ? result:null;
    }
}
class Engine{
    int engineId;
    String engineName;
    String engineType;
    double enginePrice;

    public Engine(int engineId,String engineName,String engineType,double enginePrice){
        this.engineId=engineId;
        this.engineName=engineName;
        this.engineType=engineType;
        this.enginePrice=enginePrice;
    }

    public int getEngineId() {
        return this.engineId;
    }

    public void setEngineId(int engineId) {
        this.engineId = engineId;
    }

    public String getEngineName() {
        return this.engineName;
    }

    public void setEngineName(String engineName) {
        this.engineName = engineName;
    }

    public String getEngineType() {
        return this.engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    public double getEnginePrice() {
        return this.enginePrice;
    }

    public void setEnginePrice(double enginePrice) {
        this.enginePrice = enginePrice;
    }

}
