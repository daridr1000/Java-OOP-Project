package lockdown;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import activity.Activity;
import person.YoungAdult;

public class Lockdown {

	private List<Activity> prohibitedActivities = new ArrayList<Activity>();

	public Lockdown() {
		setProhibitedActivities(prohibitedActivities);
	}

	public List<Activity> getProhibitedActivities() {
		return prohibitedActivities;
	}

	public void setProhibitedActivities(List<Activity> prohibitedActivities) {
		prohibitedActivities.add(new Activity("Going to the gym", "Sports","Outdoors"));
		prohibitedActivities.add(new Activity("Going to the cinema", "Entertainment","Outdoors"));
		prohibitedActivities.add(new Activity("Going to a pub or restaurant", "Socialization","Outdoors"));
		prohibitedActivities.add(new Activity("Playing any sport outside", "Sports","Outdoors"));
		prohibitedActivities.add(new Activity("Going to a music festival", "Entertainment","Outdoors"));
		prohibitedActivities.add(new Activity("Going to any public social events", "Socialization","Outdoors"));
	}

	public void apply(YoungAdult youngAdult) {
		List<Activity> youngAdultActivities = youngAdult.getActivities();
		for (Iterator<Activity> iterator= youngAdultActivities.iterator();iterator.hasNext(); ) {
			Activity activity = iterator.next();
			if (activity.getLocation()=="Outdoors") {
				iterator.remove();
			}
		}
	}

}
