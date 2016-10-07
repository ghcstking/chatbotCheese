package groupFiles;

public class VickiTopic implements Topic {
	private boolean inVickiLoop;
	private String vickiResponse;

	@Override
	public void talk() {
		VickiMain.print("I know how to cook a thing or two. "
				+ "What kind of food do you want to make? Breakfast, lunch, dinner, or dessert?");
		inVickiLoop = true;
		while(inVickiLoop) {
			findFood();
		}
	}
	public void findFood() {
		vickiResponse = VickiMain.getInput();
		String[] foods = {"breakfast", "lunch", "dinner", "dessert"};
		boolean foodFound = false;
		for (int i = 0; i < foods.length; i++) {
			if (VickiMain.findKeyword(vickiResponse, foods[i], 0) >= 0) {
				foodFound = true;
				pickFood();
			}
		}
		if (!foodFound) {
			VickiMain.print("Sorry? Breakfast, lunch, dinner, or dessert?");
		}
	}
	public void pickFood() {
		String[] pancakes = {"1 1/2 cups of flour", "1 teaspoon salt", "1 egg", 
				"1 1/4 cups of milk", "3 tablespoons butter", "1 tablespoon sugar"};
		String[] frenchToast = {"6 slices of bread", "2 eggs", "2/3 cups of milk", 
				"1 teaspoon vanilla extract"};
		String[] macCheese = {"10 oz macaroni", "2 tablespoons butter", "2 tablespoons flour",
				"2 1/2 cups milk", "2 1/4 cup of cheese"};
		String[] cheeseburger = {"2 meat patties", "1 teaspoon salt", "1 teaspoon pepper",
				"2 slices of American cheese", "4 buns"};
		String[] steak = {"2 1/2 pound steak", "salt and pepper to taste", "olive oil"};
		String[] salmon = {"4 salmon fillets", "1/2 cup panko", "2 tablespoon olive oil",
				"6 oz baby spinach"};
		String[] iceCream = {"14 oz sweetened condensed milk", "2/3 cup chocolate syrup",
				"2 cups heavy cream"};
		String[] parfait = {"3 cups vanilla yogurt", "1 cup strawberries", "1 cup granola"};
		
		boolean found = false;
		if (VickiMain.findKeyword(vickiResponse, "breakfast", 0) >= 0) {
			VickiMain.print("Would you like pancakes or french toast?");
			vickiResponse = VickiMain.getInput();
			if (VickiMain.findKeyword(vickiResponse, "pancakes", 0) >= 0) {
				VickiMain.print("You will need: ");
				for (int i = 0; i < pancakes.length; i++) {
					VickiMain.print(pancakes[i]);
				}
				found = true;
			}
			if (VickiMain.findKeyword(vickiResponse, "french toast", 0) >= 0) {
				VickiMain.print("You will need: ");
				for (int i = 0; i < frenchToast.length; i++) {
					VickiMain.print(frenchToast[i]);
				}
				found = true;
			}
		}
		
		if (VickiMain.findKeyword(vickiResponse, "lunch", 0) >= 0) {
			VickiMain.print("Would you like mac and cheese or a cheeseburger?");
			vickiResponse = VickiMain.getInput();
			if (VickiMain.findKeyword(vickiResponse, "mac and cheese", 0) >= 0) {
				VickiMain.print("You will need: ");
				for (int i = 0; i < macCheese.length; i++) {
					VickiMain.print(macCheese[i]);
				}
				found = true;
			}
			if (VickiMain.findKeyword(vickiResponse, "cheeseburger", 0) >= 0) {
				VickiMain.print("You will need: ");
				for (int i = 0; i < cheeseburger.length; i++) {
					VickiMain.print(cheeseburger[i]);
				}
				found = true;
			}
		}
		
		if (VickiMain.findKeyword(vickiResponse, "dinner", 0) >= 0) {
			VickiMain.print("Would you like steak or salmon?");
			vickiResponse = VickiMain.getInput();
			if (VickiMain.findKeyword(vickiResponse, "steak", 0) >= 0) {
				VickiMain.print("You will need: ");
				for (int i = 0; i < steak.length; i++) {
					VickiMain.print(steak[i]);
				}
				found = true;
			}
			if (VickiMain.findKeyword(vickiResponse, "salmon", 0) >= 0) {
				VickiMain.print("You will need: ");
				for (int i = 0; i < salmon.length; i++) {
					VickiMain.print(salmon[i]);
				}
				found = true;
			}
		}
		
		if (VickiMain.findKeyword(vickiResponse, "dessert", 0) >= 0) {
			VickiMain.print("Would you like ice cream or parfait?");
			vickiResponse = VickiMain.getInput();
			if (VickiMain.findKeyword(vickiResponse, "ice cream", 0) >= 0) {
				VickiMain.print("You will need: ");
				for (int i = 0; i < iceCream.length; i++) {
					VickiMain.print(iceCream[i]);
				}
				found = true;
			}
			if (VickiMain.findKeyword(vickiResponse, "parfait", 0) >= 0) {
				VickiMain.print("You will need: ");
				for (int i = 0; i < parfait.length; i++) {
					VickiMain.print(parfait[i]);
				}
				found = true;
			}
		}
		if (found) {
			VickiMain.print("I hope you enjoy your food!");
			inVickiLoop = false;
			VickiMain.talkForever();
		}
		if(!found) {
			VickiMain.print("You just ruined the flow! Would you like breakfast, lunch, dinner, or dessert?");
		}
	}

	public boolean isTriggered(String userInput) {
		String[] triggers = {"make", "cook", "recipe"};
		for (int i = 0; i < triggers.length; i++) {
			if(VickiMain.findKeyword(userInput, triggers[i], 0) >= 0) {
				return true;
			}
		}
		return false;
	}

}
