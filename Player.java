public class Player {

    //Initializing variables
    private String name = "Unknown";
    private int health= 100;
    private Artifact[] inventory = new Artifact[10];
    private int numArtifacts=0;

    //Constructor
    public Player(String name, int health){
        if (name == null || name==""){
            System.out.println("Error: Player name cannot be null of empty");
            System.out.println("Warning: Default values assigned for invalid inputs");
        }
        else{
            this.name = name;
        }
        if(health<0 || health>100){
            System.out.println("Error: Health must be between 0 and 100");
            System.out.println("Warning: Default values assigned for invalid inputs");
        }
        else{
            this.health = health;
        }
    }
    //Getters
    public String getName(){
        return name;
    }
    public int getHealth(){
        return health;
    }

    public int getNumArtifacts(){
        return numArtifacts;
    }

    //Methods to validate if artifact can be added to inventory
    public boolean collectArtifact(Artifact artifact){
        if(numArtifacts>10){
            System.out.print("Error: Inventory is full, cannot add more artifacts.");
            return false;
        }
        else{
            for(int i =0; i<inventory.length; i++){
                if( inventory[i]== null){
                    inventory[i]= artifact;
                }
            }
            numArtifacts++;
            return true;
        }
    }
    //Method to change health of player
    public void takeDamage(int amount){
        if(amount>0 && health>0){
            health-= amount;
            if(health<0){
                health =0;
            }
        
        }
        else{

            System.out.println("Error: Damage amount cannot be negative");
        }
    }
   
    public String toString(){
        return "Player {name= ["+ name+ "] , health= [" + health+"], numArtifacts = ["+ numArtifacts+ "]}";
    }
}
