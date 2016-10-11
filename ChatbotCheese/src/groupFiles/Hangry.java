package groupFiles;

import groupFiles.VickiMain;

public class Hangry implements Topic{
	private boolean imHangryLoop;
	private String response;
	private int hungerlvl;
	private int foodpsn;
	@Override
	public void talk() {
		imHangryLoop = true;
		VickiMain.print("All this talking is making me hungry. You should feed me something!");
		String[] foodTypes = {"cake", "bread", "spaghetti", "ice cream", "pie", "cookie", "sandwich", "apple"};
		while(imHangryLoop){
			response = VickiMain.getInput();
			boolean fed = false;
			for (int i = 0; i < foodTypes.length; i++){
				if(VickiMain.findKeyword(response, foodTypes[i],0) >= 0){
					sizeCheck();
					fed = true;
				}
			}
			if(!fed){
				VickiMain.print("THAT AIN'T FOOD. FEED ME REAL FOOD YOU PLEB.");
			}
		}
	}
		
	
	public void sizeCheck(){
		String[] sizes = {"huge","enormous","big","tiny","small","petite"};
		for(int i = 0; i < sizes.length; i++){
			foodpsn = VickiMain.findKeyword(response, sizes[i], 0);
				if(foodpsn >= 0){
						if(i < 3 && i >= 0){
							hungerlvl += 5;
						}
						else{
							if(i > 2){
								hungerlvl += 2;
							}	
						}
				}
			}
		
			if(foodpsn < 0){
				hungerlvl += 4;
			}
			
			checkHunger();
			
		}
		
		

	
	public void checkHunger(){
		if(hungerlvl >= 25){
			VickiMain.print("Woah...I'm so full now. Okay, time to get back on topic :)");
			imHangryLoop = false;
			VickiMain.talkForever();
		}
		else{
			if(hungerlvl - 3 > 12){
				VickiMain.print("Just a little more and I'll be satisified...");
			}
			else{
				VickiMain.print("I'M STILL SO HUNGRYYYYYYY.");
			}
		}
	}


	@Override
	public boolean isTriggered(String userInput) {
		// TODO Auto-generated method stub
		return false;
	}
}

