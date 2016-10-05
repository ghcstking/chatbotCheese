package groupFiles;

import groupFiles.VickiMain;

public class FoodCombos implements Topic{
	private boolean inComboLoop;
	private String comboResponse;

	@Override
	public void talk() {
		inComboLoop = true;
		while(inComboLoop){
			VickiMain.print("Tell me 2 foods you want to combine and I'll come up for a new name for it.");
			comboResponse = VickiMain.getInput();
			if (comboResponse.indexOf("stop")>= 0){
				inComboLoop = false;
				VickiMain.talkForever();
				
			}
			
			
			VickiMain.print("That's my favorite part about school too.");
		}
		
	}

	@Override
	public boolean isTriggered(String userInput) {
		
		if(VickiMain.findKeyword(userInput, "combo", 0) >= 0){
			return true;
		}
		if(VickiMain.findKeyword(userInput, "mix", 0) >= 0){
			return true;
		}
		if(VickiMain.findKeyword(userInput, "together", 0) >= 0){
			return true;
		}
		return false;
	}

}
