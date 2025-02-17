import java.util.Random;

public class GameWorld {
    // Arrays to hold players, artifacts, and quests
    private Player[] players = new Player[100];
    private int numPlayers = 0;
    private Artifact[] artifacts = new Artifact[50];
    private int numArtifacts = 0;
    private Quest[] quests = new Quest[20];
    private int numQuests = 0;

    // Singleton instance of Gameworld
    private static GameWorld instance;

    // Method to get the singleton instance of Gameworld
    public static GameWorld getInstance() {
        if (instance == null) {
            instance = new GameWorld();
        }
        return instance;
    }

    // Method to reset the Gameworld instance
    public static GameWorld resetWorld() {
        instance = new GameWorld();
        return instance;
    }

    // Private constructor to prevent instantiation from outside
    private GameWorld() {
        // Default constructor
    }

    // Method to add a player to the Gameworld
    public boolean addPlayer(Player player) {
        if (numPlayers >= players.length) {
            System.out.println("Error: Cannot add more players to the Gameworld");
            return false;
        }
        players[numPlayers++] = player; // Add the player to the array
        return true;
    }

    // Method to add an artifact to the Gameworld
    public boolean addArtifact(Artifact artifact) {
        if (numArtifacts >= artifacts.length) {
            System.out.println("Error: Cannot add more artifacts to the Gameworld");
            return false;
        }
        artifacts[numArtifacts++] = artifact; // Add the artifact to the array
        return true;
    }

    // Method to add a quest to the Gameworld
    public boolean addQuest(Quest quest) {
        if (numQuests >= quests.length) {
            System.out.println("Error: Cannot add more quests to the Gameworld");
            return false;
        }
        quests[numQuests++] = quest;
        return true;
    }

    // Method to get a random artifact from the Gameworld
    public Artifact getRandomArtifact() {
        if (numArtifacts == 0) {
            System.out.println("Error: No artifacts available in the Gameworld");
            return null; // Return null if no artifacts are available
        }
        Random random = new Random(); // Create a new Random object
        int randomIndex = random.nextInt(numArtifacts); // Generate a random index
        return artifacts[randomIndex]; // Return a random artifact
    }

    // Method to get all players in the Gameworld
    public Player[] getPlayers() {
        Player[] availablePlayers = new Player[numPlayers];
        for (int i = 0; i < numPlayers; i++) {
            availablePlayers[i] = players[i]; // Copying the players array
        }
        return availablePlayers;
    }

    // Method to get all quests in the Gameworld
    public Quest[] getQuests() {
        Quest[] availableQuests = new Quest[numQuests];
        for (int i = 0; i < numQuests; i++) {
            availableQuests[i] = quests[i];// Copying the quests array
        }
        return availableQuests;
    }
}