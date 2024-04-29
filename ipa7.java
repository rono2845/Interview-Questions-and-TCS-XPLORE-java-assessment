package PRA;
import java.util.*;

public class ipa7 {
    public static void main(String args[]) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner sc=new Scanner(System.in);
        TR[] t=new TR[4];
        for(int i=0;i<t.length;i++){
            int id=sc.nextInt();
            int sysCount=sc.nextInt();sc.nextLine();
            String bGroup=sc.nextLine();
            int activeSystems=sc.nextInt();
            int fSystems=sc.nextInt();sc.nextLine();
            String pStatus=sc.nextLine();
            int desktopCount=sc.nextInt();
            int clientCount=sc.nextInt();
            
            t[i]=new TR(id, sysCount, bGroup, activeSystems, fSystems, pStatus, desktopCount, clientCount);
        }
        sc.nextLine();
        String s1=sc.nextLine();//ip for f1
        String s2=sc.nextLine();//ip for f2
        sc.close();
        double res1=f1(t, s1);
        if(res1>0) System.out.println(res1);
        else System.out.println("TrainingRoom not allotted under specific BusinessGroup");
        
        TR res2=f2(t,s2);
        if(res2!=null){
            System.out.println(res2.getId());
            System.out.println(res2.getSysCount());
        }else System.out.println("No TrainingRooms present with the specific projector status");
        
    }
    
    public static double f1(TR[] t,String s1){
        double avg=0,sum=0;
        int count=0;
        for(int i=0;i<t.length;i++){
            if(s1.equalsIgnoreCase(t[i].getBGroup())){
                sum+=t[i].getSysCount();
                count++;
            }
        }
        avg=sum/count;
        return count>0?avg:-1;
    }
    
    public static TR f2(TR[] t,String s2){
        TR[] result=new TR[0];
        for(int i=0;i<t.length;i++){
            if(s2.equalsIgnoreCase(t[i].getPStatus())){
                result=Arrays.copyOf(result, result.length+1);
                result[result.length-1]=t[i];
            }
        }
        Arrays.sort(result,0,result.length,(a,b)->(b.getActiveSystems()-a.activeSystems));
        return result.length>0?result[0]:null;
    }
}
class TR{
    int id;
    int sysCount;
    String bGroup;
    int activeSystems;
    int fSystems;
    String pStatus;
    int desktopCount;
    int clientCount;
    
    public TR(int id,int sysCount,String bGroup,int activeSystems,int fSystems,String pStatus,int desktopCount,int clientCount){
        this.id=id;
        this.sysCount=sysCount;
        this.bGroup=bGroup;
        this.activeSystems=activeSystems;
        this.fSystems=fSystems;
        this.pStatus=pStatus;
        this.desktopCount=desktopCount;
        this.clientCount=clientCount;
    }
    
    public int getId(){return this.id;}
    public int getSysCount(){return this.sysCount;}
    public String getBGroup(){return this.bGroup;}
    public int getActiveSystems(){return this.activeSystems;}
    public int getFSystems(){return this.fSystems;}
    public String getPStatus(){return this.pStatus;}
    public int getDesktopCount(){return this.desktopCount;}
    public int getClientCount(){return this.clientCount;}
}
