import java.util.Scanner;

public class Solution {
    /*
        Before calling these static methods in main, use Scanner object to 
        read the values of four Player objects referring attributes in the above mentioned attribute sequence. 
        Next, read the value for skill and level.
        Please consider the skill value read above as skill parameter for both the static methods.
     */
    public static void main(String[] args){
        Player[] player=new Player[4];
        Scanner sc=new Scanner(System.in);
        for(int i=0;i<player.length;i++){
            int playerId=sc.nextInt();
            sc.nextLine();
            String skill=sc.nextLine();
            String level=sc.nextLine();
            int points=sc.nextInt();
            sc.nextLine();
            player[i]=new Player(playerId, skill, level, points);
        }
        String reqSkill=sc.nextLine();
        String reqLevel=sc.nextLine();
        sc.close();
        /*
            For findPointsForGivenSkill method - The main method should print the points as it is if the 
            returned price is greater than 0, or it should print "The given Skill is not available".

            For getPlayerBasedOnLevel method - The main method should print the playerId of the returned player object. 
            If the returned value is null then it should print 
            "No player is available with specified level, skill and eligibility points".

         */
        int output1=findPointsForGivenSkill(player, reqSkill);
        if(output1>0){
            System.out.println(output1);
        }
        else{
            System.out.println("The given Skill is not available");
        }

        Player playerObj=getPlayerBasedOnLevel(reqLevel, reqSkill, player);
        if(playerObj==null){
            System.out.println("No player is available with specified level, skill and eligibility points");
        }
        else{
            System.out.println(playerObj.playerId);
        }
    }
    /*
        findPointsForGivenSkill method:
        This method will take two input parameters - array of Player objects and string parameter skill. 
        The method will return the sum of the points attribute from player objects for the skill passed as parameter. 
        If no player with the given skill is present in the array of player objects, then the method should return 0. 

     */
    public static int findPointsForGivenSkill(Player[] player,String reqSkill){
        int sum=0;
        for(int i=0;i<player.length;i++){
            if(player[i].getSkill().equalsIgnoreCase(reqSkill)){
                sum+=player[i].points;
            }
        }
        return sum;
    }
    /*
        getPlayerBasedOnLevel method:
        This method will take two String parameters level and skill, along with the array of Player objects.
        The method will return the player object, if the input String parameters matches with the level and skill 
        attribute of the player object and its point attribute is greater than or equal to 20. 
        If any of the conditions are not met, then the method should return null.
     */
    public static Player getPlayerBasedOnLevel(String reqLevel,String reqSkill,Player[] player){
        for(int i=0;i<player.length;i++){
            if(player[i].getSkill().equalsIgnoreCase(reqSkill) && 
                player[i].getLevel().equalsIgnoreCase(reqLevel) && player[i].getPoints()>=20){
                return player[i];
            }
        }
        return null;
    }
}

class Player{
    int playerId;
    String skill;
    String level;
    int points;
    public Player(int playerId, String skill, String level, int points) {
        this.playerId = playerId;
        this.skill = skill;
        this.level = level;
        this.points = points;
    }

    public int getPlayerId() {
        return this.playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public String getSkill() {
        return this.skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getLevel() {
        return this.level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public int getPoints() {
        return this.points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
