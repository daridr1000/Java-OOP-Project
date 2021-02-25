package person;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import activity.Activity;
import date.BirthDate;
import exceptions.AgeException;
import feelings.NegativeFeelings;
import feelings.PositiveFeelings;

public class YoungAdult extends Person implements PeopleInterface {

	public static List<YoungAdult> youngAdultList = new ArrayList<YoungAdult>();
	private List<Activity> activities = new ArrayList<Activity>();
	private Set<String> feelings;

	public YoungAdult(String firstname, String lastname, BirthDate date, String gd) throws AgeException {
		super(firstname, lastname, date, gd);
		youngAdultList.add(this);
	}

	private void addActivity(Activity activity) {
		this.activities.add(activity);
		activity.setParticipant(this);
	}
	@Override
	public String checkAge() {
		int age = this.getAge();
		if (age < 16 || age > 24) {
			return "Invalid age for this class! Age should be between 16 and 24 inclusive.";
		}
		return "Valid age for this class!";
	}

	@Override
	public String getAgeValidity() throws AgeException {
		String validity = checkAge();
		if (validity != "Valid age for this class!") {
			throw new AgeException(validity);
		}
		return validity;
	}

	public void addActivities() {
		for (Activity activity: Activity.allActivities) {
			addActivity(activity);
		}
	}

	public List<Activity> getActivities() {
		return activities;
	}
	


	public void setActivities(List<Activity> activities) {
		this.activities = activities;
	}

	public Set<String> getFeelings() {
		feelings = new HashSet<String>();
		HashMap<String, Integer> personalityTraits = this.getPersonalityTraits();
		List<Activity> activities = this.getActivities();
		for (Activity activity : activities) {
			if (activity.getType() == "Home chores") {
				if (personalityTraits.get("Conscientiousness") < 3) {
					feelings.add(NegativeFeelings.FRUSTRATED.name());
				} else {
					feelings.add(PositiveFeelings.PROUD.name());
				}

			}
			if (activity.getType() == "Educational") {
				if (personalityTraits.get("Extraversion") < 3) {
					feelings.add(PositiveFeelings.CONFIDENT.name());
				} else {
					feelings.add(NegativeFeelings.LONELY.name());
				}
			}
			
			if (activity.getType() == "Sports") {
				if (personalityTraits.get("Agreeableness") < 3) {
					feelings.add(NegativeFeelings.DISGUSTED.name());
				} else {
					feelings.add(PositiveFeelings.ECSTATIC.name());
				}
			}
			
			if (activity.getType() == "Entertainment") {
				if (personalityTraits.get("Openness") < 3) {
					feelings.add(NegativeFeelings.SAD.name());
				} else {
					feelings.add(PositiveFeelings.HAPPY.name());
				}
			}
			if (activity.getType() == "Socialization") {
				if (personalityTraits.get("Neuroticism") >= 3) {
					feelings.add(NegativeFeelings.DEPRESSED.name());
				} else {
					feelings.add(PositiveFeelings.EXCITED.name());
				}
			}
		}
		return feelings;
	}

	public void setFeelings(Set<String> feelings) {
		this.feelings = feelings;
	}

}
