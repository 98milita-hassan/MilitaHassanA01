public class Companion {
    // Instance variables
    private String name = "Unknown";
    private String role = "Unknown role type";
    private String ability;
    private int power = 1;
    private Player owner = new Player("Default Player", 100);

    // Constructor
    public Companion(String name, String role, int power, Player owner){
        boolean invalidInput = false; // Flag to check for invalid inputs
        if (name == null || name == ""){
            System.out.println("Error: Companion name cannot be null or empty");
            invalidInput=true; // Set flag to true if input is invalid
            
        }
        else{
            this.name = name;
        }
        // Set role and ability based on input
        switch (role) {
            case "Mage":
                this.role = "Mage";
                this.ability = "casts a fireball!";
                break;
            case "Warrior":
                this.role = "Warrior";
                this.ability = "swings a mighty sword!";
                break;
            case "Healer":
                this.role = "Healer";
                this.ability = "heals the party!";
                break;
            default:
                System.out.println("Error: Companion role should be a Mage, Warrior, or Healer");
                this.role = "Unknown Role Type";
                this.ability = "rolls around on the ground...";
                invalidInput = true;
                break;
        }
        if(power<0 || power>100){
            System.out.println("Error: Power must be between 1 and 100");
            invalidInput = true;
            
        } 
        else{
            this.power =power;
        }
        if(owner == null){
            System.out.println("Error: Companion must be assigned to a valid player");
            invalidInput= true;
           
        }
        else{
            this.owner = owner;
        }
        if (invalidInput) {
            System.out.println("Warning: Default values assigned for invalid inputs.");
        }

    
    }
    // Getters
    public String getName(){
        return name;
    }
    public String getRole(){
        return role;
    }
    public int getPower(){
        return power;
    }
    public Player getOwner(){
        return owner;
    }
    // Method to use companion ability
    public String useAbility(){
        return name + " " + ability;
    }

    public String toString(){
        return "Companion{name='" + name + "', role='" + role + "', power=" + power + ", owner=" + owner.getName() + "}";
    }
}
