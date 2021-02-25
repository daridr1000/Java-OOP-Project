package youngsupport;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import activity.Activity;
import person.YoungAdult;

public class YoungSupport {
	private List<Activity> recommendedActivities = new ArrayList<Activity>();
	public YoungSupport() {
		setRecommendedActivities(recommendedActivities);
	}
	public List<Activity> getRecommendedActivities() {
		return recommendedActivities;
	}
	public void setRecommendedActivities(List<Activity> recommendedActivities) {
		recommendedActivities.add(new Activity("Practicing Yoga", "Sports","Indoors"));
		recommendedActivities.add(new Activity("Watching movies/series", "Entertainment","Indoors"));
		recommendedActivities.add(new Activity("Partaking in online social events", "Socialization","Indoors"));
		recommendedActivities.add(new Activity("Keeping a journal", "Educational","Indoors"));
		recommendedActivities.add(new Activity("Playing video games", "Entertainment","Indoors"));
		recommendedActivities.add(new Activity("Playing board games with your family/flatmates", "Socialization","Indoors"));
		recommendedActivities.add(new Activity("Listening to music", "Educational","Indoors"));
		recommendedActivities.add(new Activity("Exercising", "Sports","Indoors"));
		recommendedActivities.add(new Activity("Cooking", "Home chores","Indoors"));
		recommendedActivities.add(new Activity("Baking", "Home chores","Indoors"));
	}
	
	public void recommendActivities(YoungAdult youngAdult) {
		List<Activity> youngAdultRecommendedActivities = new ArrayList<Activity>();
		HashMap<String, Integer> personalityTraits = youngAdult.getPersonalityTraits();
		List<Activity> activities = this.getRecommendedActivities();
		for (Activity activity : activities) {
			if (activity.getType()=="Home chores"){
					if(personalityTraits.get("Conscientiousness") >= 3) {
						youngAdultRecommendedActivities.add(activity);
					}
			}
			if (activity.getType()=="Educational"){
				if(personalityTraits.get("Extraversion") < 3) {
					youngAdultRecommendedActivities.add(activity);
				}
		}
			if (activity.getType()=="Sports"){
				if(personalityTraits.get("Agreeableness") >= 3) {
					youngAdultRecommendedActivities.add(activity);
				}
		}
			if (activity.getType()=="Entertainment"){
				if(personalityTraits.get("Openness") >= 3) {
					youngAdultRecommendedActivities.add(activity);
				}
		}
			if (activity.getType()=="Socialization"){
				if( personalityTraits.get("Neuroticism") < 3) {
					youngAdultRecommendedActivities.add(activity);
				}
		}
				
		}
		youngAdult.setActivities(youngAdultRecommendedActivities);
	}
}
