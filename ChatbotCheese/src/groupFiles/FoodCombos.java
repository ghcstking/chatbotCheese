package groupFiles;

import groupFiles.VickiMain;

public class FoodCombos implements Topic{
	private boolean inComboLoop;
	private String comboResponse;
	// split by vowels

	@Override
	public void talk() {
		inComboLoop = true;
		while(inComboLoop){
			VickiMain.print("Tell me 2 one word foods you want to combine and I'll come up for a new name for it.");
			comboResponse = VickiMain.getInput();
			if (comboResponse.indexOf("stop")>= 0){
				inComboLoop = false;
				VickiMain.talkForever();
				
			}else{
				if (comboResponse.trim().indexOf(" ") > 0){
					String wordA = comboResponse.substring(0,comboResponse.indexOf(" "));
					String wordB = comboResponse.substring(comboResponse.indexOf(" ")+1);
					
					VickiMain.print(wordA.substring(0,1) + wordB.substring(1));
				}else{
					VickiMain.print("Seems as if you can't follow instructions, you should be replaced by a computer");	
				}
			}
		
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
