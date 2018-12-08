/*
 * @Author: Ethan Wong
 * Untilized IBM's API
 */
import java.util.List;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import com.ibm.watson.developer_cloud.personality_insights.v3.PersonalityInsights;
import com.ibm.watson.developer_cloud.personality_insights.v3.model.Profile;
import com.ibm.watson.developer_cloud.personality_insights.v3.model.ProfileOptions;
import com.ibm.watson.developer_cloud.personality_insights.v3.model.Trait;

public class PersonalityAnalytics {
	
  //returns 2D array for personality information
  public static String[][] getPersonality(String textToAnalyze) {
	  
	  	//creates a new service using the credentials provided
	    PersonalityInsights service = new PersonalityInsights("2018-04-28");
	    service.setUsernameAndPassword("a6fa83a1-b397-4d2e-b735-67a3c075b194", "bW37e6zhuNZZ");
	      
		  Profile result = new Profile();
		  
		  ProfileOptions profileOptions = new ProfileOptions.Builder()
			        .text(textToAnalyze)
			        .build();
			    
		 result = service.profile(profileOptions).execute();
		 
		 int length = result.getPersonality().size();
		 int counter = 0;
		 
		 //Creates an array called personality of type string to return
		 //Only has 2 columns, first for name and the second for percentile
		 String [][] personality = new String[length][2];
		 
		    List<Trait> traits = result.getPersonality();
		    
		    //Used for loop to assign each row and column a name or value
		    for (Trait nextTrait : traits) {
		      personality[counter][0] = nextTrait.getName();
		      personality[counter][1] = (Integer.toString((int)(nextTrait.getPercentile() * 100)));
		      
		      counter++;
		    }
		    
		    //Returns the array to be used by GUI interface
		    return personality;
  }
  
  //returns 2D array for emotional information
  public static String[][] getEmotions(String textToAnalyze) {
	  
	  	//creates a new service using the credentials provided
	    PersonalityInsights service = new PersonalityInsights("2018-04-28");
	    service.setUsernameAndPassword("a6fa83a1-b397-4d2e-b735-67a3c075b194", "bW37e6zhuNZZ");
	    
		  Profile result = new Profile();
		  
		  ProfileOptions profileOptions = new ProfileOptions.Builder()
			        .text(textToAnalyze)
			        .build();
			    
		 result = service.profile(profileOptions).execute();
		 
		 int length = result.getPersonality().size();
		 int counter = 0;
		 
		//Creates an array called emotions of type string to return
		//Only has 2 columns, first for name and the second for percentile
		 String [][] emotions = new String[length][2];
		 
		 System.out.println("Emotional traits:");
		    List<Trait> needs = result.getNeeds();
		    
		    //Used for loop to assign each row and column a name or value
		    for (Trait nextNeed : needs) {
		    	emotions[counter][0] = nextNeed.getName();
		    	emotions[counter][1] = (Integer.toString((int)(nextNeed.getPercentile() * 100)));
		      
		      counter++;
		    }
		    
		    //Returns the array to be used by GUI interface
		    return emotions;
  }
  
  //returns 2D array for personal information
  public static String[][] getPersonal(String textToAnalyze) {
	  	
	  	//creates a new service using the credentials provided
	    PersonalityInsights service = new PersonalityInsights("2018-04-28");
	    service.setUsernameAndPassword("a6fa83a1-b397-4d2e-b735-67a3c075b194", "bW37e6zhuNZZ");
	    
		  Profile result = new Profile();
		  
		  ProfileOptions profileOptions = new ProfileOptions.Builder()
			        .text(textToAnalyze)
			        .build();
			    
		 result = service.profile(profileOptions).execute();
		 
		 int length = result.getPersonality().size();
		 int counter = 0;
		 
		//Creates an array called personality of type string to return
		//Only has 2 columns, first for name and the second for percentile
		 String [][] personality = new String[length][2];
		 
		 System.out.println("Emotional traits:");
		    List<Trait> values = result.getValues();
		    
		    //Used for loop to assign each row and column a name or value
		    for (Trait nextValue : values) {
		    	personality[counter][0] = nextValue.getName();
		    	personality[counter][1] = (Integer.toString((int)(nextValue.getPercentile() * 100)));
		      
		      counter++;
		    }
		    
		    //Returns the array to be used by GUI interface
		    return personality;
  }
}
 