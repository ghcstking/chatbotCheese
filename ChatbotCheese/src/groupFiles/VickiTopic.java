package groupFiles;
public class VickiTopic implements Topic {
	private boolean inVickiLoop;
	private String vickiResponse;

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
					VickiMain.print(foods[i]);
					foodFound = true;
				}
			}
		}
		if (!foodFound) {
			VickiMain.print("I don't understand");
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
