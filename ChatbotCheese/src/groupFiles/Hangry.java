package groupFiles;

import groupFiles.VickiMain;

public class Hangry implements Topic{
	private boolean imHangryLoop;
	private String feedMeResponse;

	@Override
	public void talk() {
		imHangryLoop = true;
		while(imHangryLoop){
			VickiMain.print("I'm hungry! Feed me!");
			feedMeResponse = VickiMain.getInput();
			if(feedMeResponse.indexOf("stop") >= 0 );{
				imHangryLoop =false;
				VickiMain.talkForever();
			}
			VickiMain.print("Not Enough! FEED ME MORE FOOD!!");
		}
	}

	@Override
	public boolean isTriggered(String userInput) {
		// TODO Auto-generated method stub
		return false;
		
	}
	
}

