package groupFiles;

import groupFiles.VickiMain;

public class FoodCombos implements Topic{
	private boolean inComboLoop;
	private String comboResponse;
	
	// split by vowels

	@Override
	public void talk() {
		inComboLoop = true;
		VickiMain.print("Give me a one word food and any other food you'd like me to combine and I'll try to come up with a new name for it");
		while(inComboLoop){
			comboResponse = VickiMain.getInput();
			if (comboResponse.indexOf("stop")>= 0 || comboResponse.indexOf("didn't like")>= 0 || comboResponse.indexOf("no")>= 0 ){
				VickiMain.print("Sorry for displeasing you ... master");
				inComboLoop = false;
				VickiMain.talkForever();
			}else{
			if (comboResponse.indexOf("good")>= 0 || comboResponse.indexOf("like")>= 0 || comboResponse.indexOf("love")>= 0){
				VickiMain.print("Glad you liked it ^_^");
				VickiMain.print("Give me a another one word food and any other food you'd like me to combine and I'll try to come up with a new name for it");
			}else{
				if (comboResponse.trim().indexOf(" ") > 0){
					String wordA = comboResponse.substring(0,comboResponse.indexOf(" "));
					String wordB = comboResponse.substring(comboResponse.indexOf(" ")+2);
					if (wordA.contains(wordB)){
						VickiMain.print("Seems as if you can't follow instructions, you should be replaced by a computer");	
					}else{	
						if(checkspace(wordB)){
						wordB = checkVowel(wordB, true);
						VickiMain.print(wordA + " " + wordB + " so... what do you think?");
						}else{
						wordB = checkVowel(wordB, false);
						VickiMain.print(wordA.substring(0,1) + wordB + " so... what do you think?");
						}
					}
					
					}else{
					VickiMain.print("Seems as if you can't follow instructions, you should be replaced by a computer");	
					}
				}
		
			}
		}
		
	}



	public boolean checkspace(String wordB) {
		if (wordB.contains(" ")){
			return true;
		}
		return false;
	}



	public String checkVowel(String wordB, boolean b) {
		if (b == true){
			return wordB.substring(wordB.indexOf(" ")+1);
		}else{
		for (int i = 0; i < wordB.length(); i++){
				if(wordB.substring(i,i+1).contains("a") || (wordB.substring(i,i+1).contains("e") || (wordB.substring(i,i+1).contains("i") || (wordB.substring(i,i+1).contains("o") || wordB.substring(i,i+1).contains("u"))))){
					return wordB.substring(i);
				}
			}
		}
		return wordB;
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
