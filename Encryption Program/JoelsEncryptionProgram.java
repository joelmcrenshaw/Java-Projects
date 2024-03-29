import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class JoelsEncryptionProgram {

// Declaring the methods
	
	// Declaring the the global variables
	private Scanner scanner;   
	private Random random;
	private ArrayList<Character> list;
	private ArrayList<Character> shuffledList;
	private char character;
	private String line;
	private char[] letters;
	char[] secretLetters;
	
	
	
	// This is the constructor method
	JoelsEncryptionProgram() {
		scanner = new Scanner(System.in);
		random = new Random();
		list = new ArrayList();
		shuffledList = new ArrayList();
		character = ' ';
		
		newKey();
		askQuestion();
		
	}
	private void askQuestion() {
		while(true) {
			System.out.println("*******************************************");
			System.out.println("What do you want to do?");
			System.out.println("(N)ewKey,(G)etKey,(E)ncrypt,(D)ecrypt,(Q)uit");
			char response = Character.toUpperCase(scanner.nextLine().charAt(0));
			
			// Switch that reads response char
			switch(response) {
			case 'N' :
				newKey();
				break;
			case 'G':
				getKey();
				break;
			case 'E':
				encrypt();
				break;
			case 'D':
				decrypt();
				break;
			case 'Q':
				quit();
				break;
			default:
				System.out.println("Not a valid answer :(");
			
			}
		}
	}
	// This method resets the key each time
	private void newKey() {
		character = ' ';
		list.clear();
		shuffledList.clear();
		
		for(int i = 32; i<127; i++) { // Iterates through all the characters of the ASCI II table
			list.add(Character.valueOf(character));
			character++;
		}
		
		shuffledList = new ArrayList(list); // Took all the characters and shuffled them
		Collections.shuffle(shuffledList);
		System.out.println("*A new key has been generated*");
		
	}
	private void getKey() {
		System.out.println("Key: ");
		for(Character x : list) {
			System.out.print(x);
			
		}
		System.out.println();
		for(Character x : shuffledList) {
			System.out.print(x);
		}
		System.out.println();
	}
	private void encrypt() {
		System.out.println("Enter a message to be encrypted: ");
		String message = scanner.nextLine();
		
		letters = message.toCharArray();
		
		for(int i = 0; i < letters.length; i++) {
			for(int j = 0; j < list.size(); j++) {
				if(letters[i] == list.get(j)) {
					letters[i] = shuffledList.get(j);
					break;
				}
				
			}
		}
		System.out.println("Encrypted: ");
		for(char x : letters) {
			System.out.print(x);
		}
		System.out.println();
		
	}
	
	private void decrypt() { // Takes the encrypted message and deciphers it 
		System.out.println("Enter a message to be decrypted: ");
		String message = scanner.nextLine();
		
		letters = message.toCharArray();
		
		for(int i = 0; i < letters.length; i++) {
			for(int j = 0; j < shuffledList.size(); j++) {
				if(letters[i] == shuffledList.get(j)) {
					letters[i] = list.get(j);
					break;
				}
				
			}
		}
		System.out.println("Decrypted: ");
		for(char x : letters) {
			System.out.print(x);
		}
		System.out.println();
		
	}
		
	
	private void quit() { // Terminates the program
		System.out.println("May the force be with you...always");
		System.exit(0);
		
	}

	

} // End of class
