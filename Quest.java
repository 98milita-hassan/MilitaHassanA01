public class Quest {
    private String description = "Unnamed Quest";
    private int difficulty = 1;
    private Companion[] companions = new Companion[5];
    private int numCompanions = 0;;
    
    public Quest(String description, int difficulty){
        if(description == null || description.isEmpty()){
            System.out.println("Error: Quest description cannot be null or empty.");

        }
        else{
            this.description = description;
        }
        if(difficulty<1 || difficulty>10){
            System.out.println("Error: Difficulty must be between 1 and 10");
        }
        else{
            this.difficulty= difficulty;
        }

      
    }

    public String getDescription(){
        return description;
    }
    public int getDifficulty(){
        return difficulty;
    }
    public int getNumCompanions(){
        return numCompanions;
    }

    public boolean addRequiredCompanion(Companion companion){
        if(numCompanions>5){
            System.out.println("Error: Cannot add more companions to this quest");
            return false;
        }
        else{
            for(int i= 0; i<companions.length; i++){
                if(companions[i] ==null){
                    companions[i]= companion;
                }
            }
            numCompanions++;
            return true;
        }
        
    }

    public boolean canComplete(Player player){
        boolean validPlayer = true; //flag to check if player can complete the quest
        int powerSum=0;
        if(numCompanions< difficulty/2){ //if the number of companions is less than half the difficulty
            validPlayer = false;
        }
        for(int i =0; i<companions.length ; i++){ //sum the power of all companions
            powerSum += companions[i].getPower();

        }
        if(powerSum< 10*difficulty){ //if the sum of the power of all companions is less than 10 times the difficulty
            validPlayer =false;//the player cannot complete the quest
        }
        if(player.getNumArtifacts() < numCompanions){
            validPlayer =false;
        }
        return validPlayer; //return true if the player can complete the quest

    }

    public String attemptQuest(Player player){
        if(canComplete(player)){
            return "Quest completed successfully! "+ description;
        }
        else{
            player.takeDamage(difficulty *10);
            return "Quest failed! The player has taken damage";
        }
    }

    public String toString(){
        return "Quest: "+ description+", difficulty: "+difficulty+", numCompanions: "+ numCompanions; 
    }

    
}
