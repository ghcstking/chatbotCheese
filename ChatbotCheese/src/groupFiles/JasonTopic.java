package groupFiles;

public class JasonTopic implements Topic{

	private boolean inJasonLoop;
	
	
	static String response;
	
	public void talk() {
		VickiMain.print("I can tell you about many types of cusines, such as Japanese or Italian."
				+ " Which cuisine would you like to know about?");
		inJasonLoop = true;
		String[] cuisineTriggers = {"japanese","korean","chinese","indian","french","italian",
				};
		String[] info = {"Japanese food usually includes noodles like soba or rice. However, the most well-known component of their unique cuisine is fish. The Japanese usually serve fish grilled for meals, but serving fish raw in sushi has been popularized worldwidely."
				+ " Did you know about a certain type of Japanese dining called omakase? Omakase is where you place trust into the sushi chef "
				+ "to serve you fresh and amazingly made sushi straight from the sushi bar. Its a good experience, and you should try it.",
				"Korean food uses components from the land to the sea. Most dishes are made with rice,noodles, or meat. Stews and soups are also common."
				+ " South Korea is famous for their abundance of delicious street food, and should you visit, you would have great days trying everything out.",
				"Chinese cuisine is very diverse in style and ingredients; so much that it can be subdivided into eight main styles. The Eight Culinary Cuisines of China are Anhui, Cantonese, Fujian, Hunan, Jiangsu, Shandong, Sichuan, and Zhejiang cuisines."
				+ " Staples in Chinese cuisine include noodles, rice, soybean, and intricate seasoning. Common foods include chao fan(fried rice) or steamed buns. ",
				"Indian cuisine is known for its usage and blending of a wide variety of flavors - mainly spicy, sweet, and sour. There are a basic 20 to 30 spices that are used in many dishes—cumin, coriander, turmeric, and ginger, to name a few—and there are an infinite number of ways of using them. "
				+ "It's also a vegetarian-friendly cuisine as many dishes only utilize vegetables.", 
				"French cuisine was heavily influenced by Italian cuisine in the past. Cheese and wine are the most prominenet figureheads of French cuisine."
				+ " French dishes tend to include wild game meat,seafood,fungi, or locally grown legumes. Breakfast is mostly traditional, and both lunch and dinner are served according to Frecnh principles.", 
				"The Italian cuisine most of the world knows today was developed after ingredients like potatoes, maize, bell peppers, and tomatoes were introduced in the 16th century. These would become key ingredients to forming a cuisine unique to Italians along with olive oil. "
				+ "Like French cuisine, cheese and wine are a staple in Italian food. Foods like pizza and pasta that are world famous originated from Italy. Italian dining also has strict principles that are followed for mostly every meal."
				+ " It is undeniable Italian cuisine is interesting and impressive."};

		while(inJasonLoop){
			response = VickiMain.getInput().toLowerCase();
			boolean triggered = false;
			for(int i = 0; i < cuisineTriggers.length; i++)
			{
				if(VickiMain.findKeyword(response, cuisineTriggers[i],0) >= 0){
					int infoReturn = VickiMain.findKeyword(response, cuisineTriggers[i],0);
					if(infoReturn >= 0){
						VickiMain.print(info[i]);
						triggered = true;
						continueConversation();
					}
				}
				
				
			}
			
			if(!triggered)
			{
				VickiMain.print("You sure that's a cuisine? You should try another one.");
			}
		}
	}


	public boolean isTriggered(String userInput) {
		String[] triggers = {"cuisine","style","type"};
		for(int i = 0; i < triggers.length; i++){
			if(VickiMain.findKeyword(userInput, triggers[i], 0) >= 0){
				VickiMain.print("So you want to learn about cuisines, huh?");
				return true;
			}
		}
		return false;
	}
	
	


	public void continueConversation(){
		VickiMain.print("Well, do you think you're interested in the cuisine?");
		response = VickiMain.getInput();
		if(response.equals("yes")){
			VickiMain.print("Great! Do you want to learn about another cuisine?");
			response = VickiMain.getInput();
			if(response.equals(("yes"))){
				VickiMain.print("Alright, you can ask me again!");
				talk();
			}
			else{
				VickiMain.print("Okay, lets talk about something else then!");
				inJasonLoop = false;
				VickiMain.talkForever();
			}
		}
		else{
			VickiMain.print("Why not?");
			response = VickiMain.getInput();
			if(response.isEmpty()){
				VickiMain.print("Hey! Why are you ignoring me?!");
			}
			else{
				VickiMain.print("Oh, well that's too bad. Would you like to learn about another cuisine?");
				response = VickiMain.getInput();
				if(response.equals("yes")){
					talk();
				}
				else{
					VickiMain.print("Okay, lets talk about something else then!");
					inJasonLoop = false;
					VickiMain.talkForever();
				}
			}
		}
	}
}
