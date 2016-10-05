package groupFiles;

public class JasonTopic implements Topic{

	private boolean inJasonLoop;
	
	static String response;
	
	public void talk() {
		VickiMain.print("I can tell you about many types of cusines, such as Japanese or Italian."
				+ " Which cuisine would you like to know about?");
		inJasonLoop = true;
		String[] cuisineTriggers = {"japanese","korean","chinese","indian","greek","italian",
				"french"};

		while(inJasonLoop){
			response = VickiMain.getInput().toLowerCase();
			
			
		}
	}

	@Override
	public boolean isTriggered(String userInput) {
		String[] triggers = {"cuisine","style","type"};
		for(int i = 0; i < triggers.length; i++){
			if(VickiMain.findKeyword(userInput, triggers[i], 0) >= 0){
				VickiMain.print("i like");
				return true;
			}
		}
		return false;
	}

}
