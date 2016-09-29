package groupFiles;

import java.util.Scanner;

public class CheeseMain {
	static String user;
	static Scanner input;
	static boolean inLoop;
	static String response;
//	static Topic school;
//	static Topic like;
//	declare group's classes
	public static void main(String[] args) {
		createTopics();
		promptName();
		talkForever();
	}
	private static void promptName() {
		print("Hello, human. I am a board covered with semiconductors and other such components"
				+ ". What is your name?");
		user = input.nextLine();
		print("Awesome! I will call you user " + user + " until you terminate me.");
	}
	public static void talkForever() {
		inLoop = true;
		print("Greetings, " + user + ". How are you?");
		while(inLoop) {
			response = getInput();
			if (findKeyword(response, "good", 0) >= 0) {
				print("I'm so happy you're good.");
				print("Greetings, " + user + ". How are you?");
			}
			else {
				print("I'm sorry, I don't understand you.");		
			}
		}
	}
	public static int findKeyword(String searchString, String key, int startIndex) {
		String phrase = searchString.trim();
		// trim cuts off spaces at the beginning and end
		phrase = phrase.toLowerCase();
		key = key.toLowerCase();
		// print("The phrase is '" + phrase + "'");
		// print("The key is '" + key + "'");
		int psn = phrase.indexOf(key);
		// print("The position found is " + psn);
		// searches for the first time the keyword occurs
		while (psn >= 0) {
			String before = " ";
			String after = " ";
			if (psn + key.length() < phrase.length()) {
				after = phrase.substring(psn + key.length(), psn + key.length() + 1).toLowerCase();
				// print("The character after " + key + " is " + after);
			}
			if (psn > 0) {
				before = phrase.substring(psn - 1, psn).toLowerCase();
				// print("The character before " + key + " is " + before);
			}
			if (before.compareTo("a") < 0 && after.compareTo("a") < 0) {
				// print(key + " was found at " + psn);
				if(noNegations(phrase, psn)) {
					return psn;		
				}
			}
			psn = phrase.indexOf(key, psn+1);
			// print(key + " was not found. Checking " + psn);
		}
		return -1;
	}
	private static boolean noNegations(String phrase, int index) {
		// helper method - method that contributes functionality to another method 
		// helpful if you need to do something repeatedly
		// also makes code more readable
		// private because it is only used by the method it is helping
		
		// check for words NO, NOT, NEVER, N'T
		if (index - 3 >= 0 && phrase.substring(index - 3, index).equals("no ")) {
			return false;
		}
		if (index - 4 >= 0 && phrase.substring(index - 4, index).equals("not ")) {
			return false;
		}
		if (index - 4 >= 0 && phrase.substring(index - 4, index).equals("n't ")) {
			return false;
		}
		if (index - 6 >= 0 && phrase.substring(index - 6, index).equals("never ")) {
			return false;
		}
		return true;
	}
	public static String getInput() {
		return input.nextLine();
	}
	public static void print(String s) {
		String printString = "";
		int cutoff = 35;
		while (s.length() > 0) {
			String currentLine = "";
			String nextWord = "";
			while (currentLine.length() + nextWord.length() <= cutoff && s.length() > 0) {
				currentLine += nextWord;
				s = s.substring(nextWord.length());
				int endOfWord = s.indexOf(" ");
				if (endOfWord == -1) {
					endOfWord = s.length() - 1;
				}
				nextWord = s.substring(0, endOfWord + 1);
			}
			printString += currentLine + "\n";
		}
		System.out.println(printString);
	}
	public static void promptInput() {
		print(user + ", try inputing a string");
		String userInput = input.nextLine();
		print("You typed: " + userInput);
	}
	public static void createTopics() {
		input = new Scanner(System.in);
		// initialize group classes
	}
}
