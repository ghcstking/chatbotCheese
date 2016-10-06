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
			VickiMain.print("Give me a one word food and any other food you'd like me to combine and I'll try to come up with a new name for it");
			comboResponse = VickiMain.getInput();
			if (comboResponse.indexOf("stop")>= 0 || comboResponse.indexOf("didn't like")>= 0 || comboResponse.indexOf("no")>= 0 ){
				VickiMain.print("Sorry for displeasing you ... master");
				inComboLoop = false;
				VickiMain.talkForever();
				
			}else{
				if (comboResponse.trim().indexOf(" ") > 0){
					String wordA = comboResponse.substring(0,comboResponse.indexOf(" "));
					String wordB = comboResponse.substring(comboResponse.indexOf(" ")+1);
//					char[] vowels = {'a','e','i','o','u'};
//					String wordATrimed;
//					String termBTrimmed;
//					for (int i = 0; i < wordA.length(); i++){
//						for(int x = 0; x < vowels.length; i++){ if(char wordA.substring(0,1) == vowels[x]){
//								
//							}else{
//							
//							}
//						}
//					}
//					
					VickiMain.print(wordA.substring(0,1) + wordB.substring(1) + " so... what do you think?");
				}else{
					VickiMain.print("Seems as if you can't follow instructions, you should be replaced by a computer");	
				}
			}
		
		}
		
	}



	@Override
	public boolean isTriggered(String userInput) {
		
		if(VickiMain.findKeyword(userInput, "combine", 0) >= 0){
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
