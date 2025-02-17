class Artifact {
    //Instance variables
    private String name = "Unknown";
    private int rarity = 1;
    private boolean isCursed= false;
    private static int totalArtifacts = 0;



    //Constructor
    public Artifact(String name, int rarity, boolean isCursed){
        if (name == null || name == ""){
            System.out.println("Error: Artifact name cannot be null or empty");
        }
        else{
            this.name = name;

        }
        if (rarity>5 || rarity<1){
            System.out.println("Error: Rarity must be between 1 and 5");
        }
        else{
            this.rarity = rarity;

        }
        this.isCursed = isCursed;
        totalArtifacts++; //Increment total number of artifacts
    }
    //Getters
    public String getName(){  
        return name;
    }

    public int getRarity (){    
        return rarity;
    }

    public boolean isCursed(){
        return isCursed;
    }
    //Static method to get total number of artifacts
    public static int getTotalArtifacts(){
        return totalArtifacts;

    }

    //Method to use artifact
    public String useArtifact(){
        if(isCursed){
            return "The artifact is cursed! Beware!";
        }
        else{
            return "You have used the "+ name+ " artifact. It glows with magical powers!";
        }
    }

    //Static method to reset total number of artifacts
    public static void resetTotalArtifacts(){
        totalArtifacts =0 ;
    }

   
    public String toString(){
        return "Artifact{ "+ "name: "+ name+ ", rairity: "+ rarity+ ", isCursed: "+ isCursed+ "}";
    }
    

}
    

