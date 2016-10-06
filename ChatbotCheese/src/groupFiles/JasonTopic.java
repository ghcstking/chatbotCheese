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
		String[] info = {"wah", "bah", "japanese"};

		while(inJasonLoop){
			response = VickiMain.getInput().toLowerCase();
			for(int i = 0; i < cuisineTriggers.length; i++)
			{
				if(VickiMain.findKeyword(response, cuisineTriggers[i],0) >= 0){
					int infoReturn = VickiMain.findKeyword(response, cuisineTriggers[i],0);
					if(infoReturn >= 0){
						VickiMain.print(info[i]);
					}
				}
				
				else
				{
					VickiMain.print("Are you sure that's a cuisine");
				}
			}
			
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
