package groupFiles;

public class VickiTopic implements Topic {
	private boolean inVickiLoop;
	private String vickiResponse;
	private String conversation;
	private String choice;

	@Override
	public void talk() {
		VickiMain.print("What kind of food do you want to make? Breakfast, lunch, dinner, or dessert?");
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
				int foodPsn = VickiMain.findKeyword(vickiResponse, foods[i], 0);
				if (foodPsn >= 0) {
					choice = foods[i];
					pickFood(choice);
					foodFound = true;
				}
			}
		}
		if (!foodFound) {
			VickiMain.print("I don't understand");
		}
	}
	public void pickFood(String food) {
		if (food.equals("breakfast")) {
			VickiMain.print("Would you like pancakes or french toast?");
			vickiResponse = VickiMain.getInput();
			if (vickiResponse.toLowerCase().equals("pancakes")) {
				VickiMain.print("You will need: \n 1.5 cups of flour \n 3.5 teaspoon baking powder \n 1 teaspoon salt \n 1 egg" + "\n 1.25 cups of milk \n 3 tablespoons butter \n 1 tablespoon sugar");
			}
			if (vickiResponse.toLowerCase().equals("french toast")) {
				VickiMain.print("You will need: \n bread \n 2 eggs \n 2/3 cups of milk \n .25 teaspoon cinnamon");
			}
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
