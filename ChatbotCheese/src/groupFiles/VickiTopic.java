package groupFiles;

public class VickiTopic implements Topic {

	@Override
	public void talk() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isTriggered(String userInput) {
		String[] triggers = {"yes", "yeah", "absolutely"};
		for (int i = 0; i < triggers.length; i++) {
			if(VickiMain.findKeyword(userInput, triggers[i], 0) >= 0) {
				return true;
			}
		}
		return false;
	}

}
