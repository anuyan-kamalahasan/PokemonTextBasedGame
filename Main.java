//Anuyan Kamalahasan
//Computer Science
//May 24, 2022 
//Pokemon Platinum  Game (Battle, Catching, Hatching, Evolving, and Trading)

import java.util.*;
import java.io.*;
class Main {
	public static final String RESET = "\033[0m"; // USED TO RESET COLOR
	public static final String RED = "\033[0;31m"; // RED
	public static final String GREEN = "\033[0;32m"; // GREEN
	public static final String BLUE = "\033[0;34m"; // BLUE
	public static final String YELLOW = "\033[0;33m"; // YELLOW
	public static final String PURPLE = "\033[0;35m"; // PURPLE
	public static final String CYAN = "\033[0;36m"; // CYAN
	public static void main(String[] args) throws IOException { 
		Scanner input = new Scanner(System.in);
		String rivalMove = ""; // Rival attacks
		String attack = ""; // User attacks
		String name = ""; // User name
		String rivalName = ""; // Computer name
		String question2; // Yes or no question for the user to answer (If the user wants to evolve evee)
		String pokemon1 = ""; // First pokemon you have
		String pokemon2 = ""; // Second pokemon you catch
		String pokemon3 = ""; // Third pokemon (The pokemon that was hatched or traded)
		String pick3 = ""; // pokemon3 stored in pick3
		String pick2 = "";// pokemon2 stored in pick2
		String fight; // The pokemon you choose to fight
		int health = 250; // Health point for user's pokemon
		int health2 = 250; // The rival's pokemon health
		String question3; // yes or no question
		String location; // Location for user to choose and catch a certain pokemon
		int catching = 0; // randomized number if user caught the pokemon or not.
		int maxRound = 0; // A variable used to keep track of the amount of rounds during the battle. Max is 20 rounds.
		System.out.println(""); 
		System.out.println("");
		String[] rules = new String[10]; // Rules from the text file will be stored into this array
		Scanner in = new Scanner(new File("rules.txt")); // Text file
		for (int i = 0; i < 10; i++) {
			String line = in.nextLine();
			rules[i] = line;
			System.out.println(rules[i]); // Outputs the rule
		}
		in.close();
		System.out.println("");
		System.out.println("");
		String pick = choose(pokemon1); // Method call
		System.out.println("");
		names(name, rivalName); // Method call
		System.out.println("");
		System.out.println("The professor gave you 3 pokeballs and an Evee egg.");
		System.out.println("The Evee egg can only be hatched once you complete a certain task.");
		System.out.println("");
		System.out.println("");
		// User picks a location and depending on what they pick a certain type of pokemon will appear for them to catch.
		System.out.println("Pick a location to catch certain pokemons. For example if you pick Veilstone city then fighting type pokemons will appear.");
		System.out.println("");
		System.out.println("Option 1: " + YELLOW + "Electricpoint" + RESET);
		System.out.println("Option 2: " + CYAN + "Oreburgh" + RESET);
		System.out.println("Option 3: " + PURPLE + "Veilstone" + RESET);
		System.out.println("");
		do { // Using do while to check if the input is valid
			System.out.print("Location: ");
			location = input.next();
		} while (!location.equalsIgnoreCase("Electricpoint") && !location.equalsIgnoreCase("Oreburgh") 
				&& !location.equalsIgnoreCase("Veilstone"));
		if (location.equalsIgnoreCase("Electricpoint")) { // Electric type pokemon will appear and user catches it
			System.out.println("");
			pick2 = electric(pokemon2); // Method call
			System.out.println("");
			determine(catching); // Method call
		}
		if (location.equalsIgnoreCase("Oreburgh")) { // Rock type pokemon will appear and user catches it
			System.out.println("");
			pick2 = rock(pokemon2); // Method call
			System.out.println("");
			determine(catching); // Method call
		}
		if (location.equalsIgnoreCase("Veilstone")) { // Fighting type pokemon will appear and user catches it
			System.out.println("");
			pick2 = fighting(pokemon2); // Method call
			System.out.println("");
			determine(catching); // Method call
		}
		System.out.println("");
		System.out.println("");
		System.out.println("Your egg hatched to and Evee!!!");
		do {  // Using do while to check if the input is valid
			System.out.println("Would you like to evolve Evee using stones. " + YELLOW + "(Yes/No)" + RESET); // Ask if user wants to evolve Evee
			question2 = input.next();
		} while (!question2.equalsIgnoreCase("Yes") && !question2.equalsIgnoreCase("No"));
		{
			if (question2.equalsIgnoreCase("Yes")) {
				pick3 = evolving(pokemon3); // Chooses the third pokemon if he wants to evolve evee
			} else if (question2.equalsIgnoreCase("No")) {
				System.out.println("Pokedex: The normal type pokemon");
				pick3 = "Evee";
			}
		}
		do {  // Using do while to check if the input is valid
			System.out.println("The professor would like to trade your hatched pokemon do you accept? " + YELLOW + "(Yes/No)" + RESET);
			question3 = input.next();
		} while (!question3.equalsIgnoreCase("Yes") && !question3.equalsIgnoreCase("No"));
		{
			if (question3.equalsIgnoreCase("Yes")) {
				do {  // Using do while to check if the input is valid
					System.out.println("What would you like to have? (Trade your pokemon Evee)"); //Pick which pokemon you would like
					System.out.println("Option 1: " + RED + "Charizard" + RESET);
					System.out.println("Option 2: " + BLUE + "Blastoise" + RESET);
					System.out.println("Option 3: " + GREEN + "Venusaur" + RESET);
					System.out.print("You picked: ");
					pokemon3 = input.next();
					System.out.println("");
				} while (!pokemon3.equalsIgnoreCase("Charizard") && !pokemon3.equalsIgnoreCase("Blastoise")
						&& !pokemon3.equalsIgnoreCase("Venusaur"));
				{
					if (pokemon3.equalsIgnoreCase("Charizard")) { // Replaces original pokemon with Charizard
						System.out.println("Pokedex: Charizard the fire type pokemon ");
						pick3 = "Charizard";

					} else if (pokemon3.equalsIgnoreCase("Blastoise")) { // Replaces original pokemon with Blastoise
						System.out.println("Pokedex: Blastoise the water type pokemon");
						pick3 = "Blastoise";
					}

					else if (pokemon3.equalsIgnoreCase("Venusaur")) { // Replaces original pokemon with Venusaur
						System.out.println("Pokedex: Venusaur the grass type pokemon");
						pick3 = "Venusaur";
					}
				}
			} else if (question3.equalsIgnoreCase("No")) {
			}
		}
		System.out.println("");
		System.out.println("");
		System.out.println("Your rival challenges you to a 1v1 pokemon battle! ");
		do {  // Using do while to check if the input is valid
			System.out.println("Which pokemon do you choose to battle! "); // User picks which pokemon they want to use against their rival
			System.out.println("Option 1: " + RED + pick + RESET);
			System.out.println("Option 2: " + BLUE + pick3 + RESET);
			System.out.println("Option 3: " + GREEN + pick2 + RESET);
			fight = input.next();
		} while (!fight.equalsIgnoreCase(pick) && !fight.equalsIgnoreCase(pick2) && !fight.equalsIgnoreCase(pick3)); //String comparison
		{
			System.out.println("You sent out " + fight); // User uses the pokemon they picked
			String []userMoves = moves(fight,pick,pick2,pick3);	
			System.out.println("Your opponent sent out " + CYAN + "Garchomp" + RESET);
			for (maxRound = 0; maxRound <= 20; maxRound++) { // For loop for the both user and rival to fight each other. (Ends when one of the user has 0 HP)
				String[] garchomp = { "Earthquake", "Dragonrush", "Slash", "Crunch" }; // Rival's move options
				System.out.println("What will " + fight + " do? " + Arrays.toString(userMoves)); // User picks what move to use
				attack = input.next();
				if (attack.equalsIgnoreCase(userMoves[0])) { // Picks one of the four moves and deals a certain amount of damage
					System.out.println(CYAN + "Garchomp" + RESET + " is hit for 25 damage!");
					health2 = health2 - 25;
					System.out.println(CYAN + "Garchomp  " + RESET + " has " + health2 + " HP left!");
				}
				if (attack.equalsIgnoreCase(userMoves[1])) {  // Picks one of the four moves and deals a certain amount of damage
					int damage = (int) (Math.random()* (50-10+1) +10);	 //Special attack high risk high reward
					System.out.println(CYAN + "Garchomp" + RESET + " is hit for " + damage +  " damage!");
					health2 = health2 - damage;
					System.out.println(CYAN + "Garchomp" + RESET + " has " + health2 + " HP left!");
				}
				if (attack.equalsIgnoreCase(userMoves[2])) {  // Picks one of the four moves and deals a certain amount of damage
					System.out.println(CYAN + "Garchomp" + RESET + " is hit for 20 damage!");
					health2 = health2 - 20;
					System.out.println(CYAN + "Garchomp " + RESET + " has " + health2 + " HP left!");
				}
				if (attack.equalsIgnoreCase(userMoves[3])) {  // Picks one of the four moves and deals a certain amount of damage
					System.out.println(CYAN + "Garchomp" + RESET + " is hit for 10 damage!");
					health2 = health2 - 10;
					System.out.println(CYAN + "Garchomp " + RESET + " has " + health2 + " HP left!");
				}
				healthpoints(health2); // Method call
				System.out.println("");
				System.out.println("");
			
				int number = (int) (Math.random() * 3); // Randomize one of the four moves
				rivalMove = garchomp[number]; // Used to store the random move that was generated 
				System.out.println(CYAN + "Garchomp " + RESET + "used " + rivalMove);
				if (rivalMove.equals("Earthquake")) { // Randomized move and deals a certain amount of damage
					System.out.println(PURPLE + fight + RESET + " is hit for 25 damage!");
					health = health - 25;
					System.out.println(PURPLE + fight + RESET + " has " + health + " HP left!");

				}
				if (rivalMove.equals("Dragonrush")) { // Randomized move and deals a certain amount of damage
					System.out.println(PURPLE + fight + RESET + " is hit for 50 damage!");
					health = health - 50;
					System.out.println(PURPLE + fight + RESET + " has " + health + " HP left!");

				}
				if (rivalMove.equals("Slash")) { // Randomized move and deals a certain amount of damage
					System.out.println(PURPLE + fight + RESET + " is hit for 20 damage!");
					health = health - 20;
					System.out.println(PURPLE + fight + RESET + " has " + health + " HP left!");

				}
				if (rivalMove.equals("Crunch")) { // Randomized move and deals a certain amount of damage
					System.out.println(PURPLE + fight + RESET + " is hit for 10 damage!");
					health = health - 10;
					System.out.println(PURPLE + fight + RESET + " has " + health + " HP left!");
				}
				healthpointsUser(health, fight); // Method call
				System.out.println("");
				System.out.println("");
				if (health <= 0) { // If user's pokemon has 0 HP they lost
					System.out.println(PURPLE + fight + RESET + " fainted and is unable to battle!");
					lost();
					System.out.println("The battle took " + maxRound + " rounds!");
					break;
				} if (health2 <= 0) { // If the rival's pokemon has 0 HP the user wins
					System.out.println(CYAN + "Garchomp " + RESET + "fainted and is unable to battle!");
					won();
					System.out.println("The battle took " + maxRound + " rounds!");
					break;
				
				} if (health2 <= 0 && health <= 0) { // If the rival's pokemon has 0 HP and the user's pokemon has 0 HP 
				// (NOTE: They have one more chance to rebuttal against the oppenent for the win)
					System.out.println(YELLOW + "Both pokemon fainted and is unable to battle!" + RESET);
					System.out.println("A draw between you and the rival");
					System.out.println("The battle took " + maxRound + " rounds!");
					break;
				}
			}
		}
	}
	/**
	Purpose: Asks the user for their name and name the their rival (computer)
	Pre: Two parameters String name and String rivalName
	Post: N/A
	 **/	
	public static void names(String name, String rivalName) {
		Scanner input = new Scanner(System.in);
		System.out.println("What is the name you go by trainer?");
		name = input.next();
		System.out.println(name + " is it? Great to have you here hope your going to enjoy playing this game!! ");
		System.out.println("What would you like to name your rival?");
		rivalName = input.next();
		System.out.println("Great your rival name is " + rivalName);
	}

	/**
	Purpose: Randomizes which pokemon will appear using an array and outputs the pokemon
	Pre: Two parameters String pokemon2 and int catching
	Post: N/A
	 **/
	public static void determine(int catching) {
		Scanner input = new Scanner(System.in);
		int pokeballs = 3;
		String y;
		String throwing = "x"; // String comparison
		for (int x = 0; x < 3; x++) {
		System.out.println("You have " +  pokeballs + " pokeballs throw them.");
			do {
				System.out.print("Type X to throw a pokeball: ");
				y = input.next();
					System.out.println("");
				catching = (int) (Math.random() * (101) + 0);
			} while (!y.equalsIgnoreCase(throwing));
			{
				if (catching % 2 == 0) {
					System.out.println("Congratulations you caught the pokemon");
					break;
				} else
					System.out.println("Failed throw again!");
					pokeballs--;
					System.out.println("");
			}
		}
	}

	/**
	Purpose: Randomizes which pokemon will appear using an array and outputs the pokemon (Electric type)
	Pre: One parameter String pokemon2
	Post: Returns pokemon2
	 **/
	public static String electric(String pokemon2) {
			String[] names = { "Electivire", "Pikachu", "Raikou", "Rotom", "Zapdos", "Voltorb" };
			String[] types = { "Gorilla", "Mouse", "Tiger", "Futuristic", "Bird", "Ball" };
			int number = (int) (Math.random() * 6); //Generates random number and is stored into the array
			pokemon2 = names[number]; // Store the name into pokemon2
			String fact = types[number]; // Store the fun fact in fact
			System.out.println("A " + PURPLE + pokemon2 + RESET + " appeared!");
			System.out.println("The " + fact + " type pokemon!"); //Note using parallel arrays
		
		return pokemon2;
	}

	/**
	Purpose: Randomizes which pokemon will appear using an array and outputs the pokemon (Rock type)
	Pre: One parameter String pokemon2
	Post: Returns pokemon2
	 **/
	public static String rock(String pokemon2) {
			String[] names = { "Steelix", "Golem", "Rhydon", "Regirock", "Tyranitar", "Aerodactyl" };
			String[] types = { "Snake", "Dual", "Rhino", "Ancient", "Pseudo", "Fossil" };
			int number = (int) (Math.random() * 6); //Generates random number and is stored into the array
			pokemon2 = names[number]; // Store the name into pokemon2
			String fact = types[number]; // Store the fun fact in fact
			System.out.println("A " + PURPLE + pokemon2 + RESET + " appeared!");
			System.out.println("The " + fact + " type pokemon!"); //Note using parallel arrays
			
		return pokemon2;
	}

	/**
	Purpose: Randomizes which pokemon will appear using an array and outputs the pokemon (Fighting type)
	Pre: One parameter String pokemon2
	Post: Returns pokemon2
	 **/
	public static String fighting(String pokemon2) {
			String[] names = { "Lucario", "Machamp", "Heracross", "Hariyama", "Sawk", "Conkeldurr" };
			String[] types = { "Aura", "Strength", "Bug", "Sumo", "Karate", "Bipedal" };
			int number = (int) (Math.random() * 6); //Generates random number and is stored into the array
			pokemon2 = names[number]; // Store the name into pokemon2
			String fact = types[number]; // Store the fun fact in fact
			System.out.println("A " + PURPLE + pokemon2 + RESET + " appeared!");
			System.out.println("The " + fact + " type pokemon!"); //Note used parallel arrays
		
		return pokemon2;
	}

	/**
	Purpose: Asks the user which type of pokemon they would like Evee to evolve into
	Pre: One parameter String pokemon3 
	Post: Returns pokemon3
	 **/
	public static String evolving(String pokemon3) {
		Scanner input = new Scanner(System.in);
		String evolve;
		do {
			System.out.println("Which type of evee do you want have?");
			System.out.println("Option 1: " + RED + "Espeon" + RESET);
			System.out.println("Option 2: " + BLUE + "Glaceon" + RESET);
			System.out.println("Option 3: " + GREEN + "Umbreon" + RESET);
			System.out.print("Your pokemon will evolve into: ");
			evolve = input.next();
		} while (!evolve.equalsIgnoreCase("Espeon") && !evolve.equalsIgnoreCase("Glaceon")
				&& !evolve.equalsIgnoreCase("Umbreon"));
		if (evolve.equalsIgnoreCase("Espeon")) {
			System.out.println("");
			System.out.println("Pokedex: The psychic type pokemon");
			pokemon3 = "Espeon";

		}
		if (evolve.equalsIgnoreCase("Glaceon")) {
			System.out.println("");
			System.out.println("Pokedex: The ice type pokemon");
			pokemon3 = "Glaceon";

		}
		if (evolve.equalsIgnoreCase("Umbreon")) {
			System.out.println("");
			System.out.println("Pokedex: The dark type pokemon");
			pokemon3 = "Umbreon";
		}
		return pokemon3;
	}

	/**
	Purpose: Asks the user what pokemon they would like to start with for their journey
	Pre: One parameter String pokemon1
	Post: Returns pokemon1
	 **/
	public static String choose(String pokemon1) {
		Scanner input = new Scanner(System.in); // NOTE: Couldn't make this shorter because depending on the pokemon they a specifc output will be given.
		String[] starter = { "Piplup", "Chimchar", "Turtwig" };
		String[] rivalStarter = { "Turtwig", "Piplup", "Chimchar" };
		String question;
		System.out.println("Which pokemon would you like to choose and start off with?");
		System.out.println("");
		System.out.println(BLUE + "Piplup  " + RESET + RED + " Chimchar" + RESET + GREEN + "   Turtwig" + RESET);
		System.out.println("");
		do {
			System.out.print("Choose your pokemon: ");
			pokemon1 = input.next();
		} while (!pokemon1.equalsIgnoreCase("Piplup") && !pokemon1.equalsIgnoreCase("Chimchar")
				&& !pokemon1.equalsIgnoreCase("Turtwig"));
		{
			System.out.println("");
			System.out.println("You chose " + pokemon1);
			System.out.println(pokemon1 + " has been registered to the pokedex.");
			if (pokemon1.equalsIgnoreCase("Piplup")) {
				System.out.println("Pokedex: " + starter[0] + " the water type pokemon Piplup is known as the penguin pokemon.");
				System.out.println("");
				System.out.println("Your rival decided to choose " + rivalStarter[0] + " to gain the advantage");
				pokemon1 = "Piplup";

			} else if (pokemon1.equalsIgnoreCase("Chimchar")) {
				System.out.println("Pokedex: " + starter[1] + " the fire type pokemon Chimcar is known as the monkey pokemon.");
				System.out.println("");
				System.out.println("Your rival decided to choose " + rivalStarter[1] + " to gain the advantage");
				pokemon1 = "Chimchar";
			}

			else if (pokemon1.equalsIgnoreCase("Turtwig")) {
				System.out.println("Pokedex: " + starter[2] + " the grass type pokemon turtwig is known as the turtle pokemon.");
				System.out.println("");
				System.out.println("Your rival decided to choose " + rivalStarter[2] + " to gain the advantage");
				pokemon1 = "Turtwig";
			}
			System.out.println("");
			System.out.println("");

			do {
				System.out.println("Would you like to give it a nickname? " + YELLOW + "(Yes/No)" + RESET);
				question = input.next();
			} while (!question.equalsIgnoreCase("Yes") && !question.equalsIgnoreCase("No"));
			if (question.equalsIgnoreCase("Yes")) {
				System.out.println("What would you like to name your pokemon?");
				String nickname = input.next();
				pokemon1 = nickname;
				System.out.println("Your pokemon is now named " + pokemon1);
			} else if (question.equalsIgnoreCase("No")) {
			}
		}
		return pokemon1;
	}

	/**
	Purpose: Prints the rival's pokemon healthbar and is used as an indicator.
	Pre: One parameter int health2 
	Post: N/A
	**/
	public static void healthpoints(int health2) {
		if (health2 >= 200) {
			System.out.println(CYAN + "Garchomp's HP: " + RESET + GREEN + "[██████████████████]" + RESET);
		} else if ((health2 >= 150)) {
			System.out.println(CYAN + "Garchomp's HP: " + RESET + YELLOW + "[████████████     ]" + RESET);
		} else if ((health2 >= 100)) {
			System.out.println(CYAN + "Garchomp's HP: " + RESET + YELLOW + "[███████          ]" + RESET);
		} else if ((health2 <= 99)) {
			System.out.println(CYAN + "Garchomp's HP: " + RESET + RED + "[████             ]" + RESET);
		}
	}
	/**
	Purpose: Prints the user's pokemon healthbar and is used as an indicator.
	Pre: Two parameters one int health and one String fight 
	Post: N/A
	**/
	public static void healthpointsUser(int health, String fight) {
		if (health >= 200) {
			System.out.println(PURPLE + fight + "'s HP: " + RESET + GREEN + "[██████████████████]" + RESET);
		} else if ((health >= 150)) {
			System.out.println(PURPLE + fight + "'s HP: " + RESET + YELLOW + "[████████████     ]" + RESET);
		} else if ((health >= 100)) {
			System.out.println(PURPLE + fight + "'s HP: " + RESET + YELLOW + "[███████          ]" + RESET);
		} else if ((health <= 99)) {
			System.out.println(PURPLE + fight + "'s HP: " + RESET + RED + "[████             ]" + RESET);
		}
	}
		
	/**
	Purpose: Prints random comments if user won the game
	Pre: No parameters
	Post: N/A
	**/
	public static void won() {
	int a = (int) (Math.random() * 3 + 1);
	switch (a) {
		case 1:
			System.out.println("Congratulations you have won the battle!");
			break;
		case 2:
			System.out.println("You defeated your rival!");
			break;
		case 3:
			System.out.println("You've won against you rival!");
			break;
		}
	}

	/**
	Purpose: Prints random comments if user lost the game
	Pre: No parameters
	Post: N/A
	**/
	public static void lost() {
	int a = (int) (Math.random() * 3 + 1);
	switch (a) {
		case 1:
			System.out.println("Your rival won against you!");
			break;
		case 2:
			System.out.println("You were defeated by your rival!");
			break;
		case 3:
			System.out.println("Your rival takes the win!");
			break;
		}
	}

	/**
	Purpose: Prints the user's pokemon move depending on the pokemon they chose to battle
	Pre: 4 parameters String fight, String pick, String pick2, String pick3.
	Post: Return userPokemon (An array)
	**/
	public static String [] moves(String fight,String pick,String pick2,String pick3) {
		String move = "";
		if (fight.equalsIgnoreCase(pick)) {
			if (!fight.equalsIgnoreCase("Turtwig") || !fight.equalsIgnoreCase("Chimchar")|| !fight.equalsIgnoreCase("Piplup") ) { // Depending on the move they are given certain names 
				move  = "Tackle,Slash,Glare,Irontail"; 
			}
			if (pick.equalsIgnoreCase("Piplup")) {
				move  = "Pound,Hydropump,Bubble,Peck"; 
			}
			if (pick.equalsIgnoreCase("Chimchar")) {
				move  = "Scratch,Flareblitz,Ember,Dig"; 			
			}
			if (pick.equalsIgnoreCase("Turtwig")) {
				move  = "Tackle,Leafstorm,Drain,Bite"; 		
			}
		}
		if (fight.equalsIgnoreCase(pick3)) { // Depending on the name they are given certain moves
			if (pick3.equalsIgnoreCase("Espeon")) {
				move  = "Takedown,Psychic,Bubble,Dig"; 
			}
			if (pick3.equalsIgnoreCase("Umbreon")) {
				move  = "Scratch,Darkpulse,Crunch,Dig"; 			
			}
			if (pick3.equalsIgnoreCase("Glaceon")) {
				move  = "Tackle,Blizzard,Drain,Dig"; 		
			}
			if (pick3.equalsIgnoreCase("Venusaur")) {
				move  = "Pound,Leafstorm,Frenzyplant,Seed"; 
			}
			if (pick3.equalsIgnoreCase("Charizard")) {
				move  = "Scratch,Fireblast,Blastburn,Wing"; 			
			}
			if (pick3.equalsIgnoreCase("Blastoise")) {
				move  = "Tackle,Hydropump,Hydrocannon,Shell"; 		
			} 		
		}
		if (fight.equalsIgnoreCase(pick2)) {
			move  = "Takedown,Brickbreak,Avalanche,Thunder"; 		
		}
		String [] userPokemon = move.split(","); //To split the commas and use the moves(using index) in the main program
		return userPokemon;
	}
}