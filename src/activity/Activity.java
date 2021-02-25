package activity;
import java.util.ArrayList;
import java.util.List;

import date.Timestamp;
import person.YoungAdult;


public class Activity {
	private String name;
	private String type;
	private String location;
	private List<YoungAdult> participants = new ArrayList<YoungAdult>();
	public static List<Activity> allActivities = new ArrayList<Activity>();
	private Timestamp start;
	private Timestamp end;
	
	public Activity(String name, String type,String location, Timestamp start, Timestamp end) {
		this.name = name;
		this.type = type;
		this.location = location;
		this.start = start;
		this.end = end;
		allActivities.add(this);
	}
	
	public Activity(String name, String type, String location) {
		this.name = name;
		this.type = type;
		this.location = location;
		allActivities.add(this);
	}
	
	public static void createActivities() {
		new Activity("Washing the dishes","Home chores","Indoors");
		new Activity("Going to the gym","Sports","Outdoors");
		new Activity("Going to the cinema","Entertainment","Outdoors");
		new Activity("Going to a pub","Socialization","Outdoors");
		new Activity("Playing chess","Educational","Indoors");
		new Activity("Hoovering","Home chores","Indoors");
		new Activity("Playing basketball","Sports","Outdoors");
		new Activity("Going to a music festival","Entertainment","Outdoors");
		new Activity("Going to University Societies events","Socialization","Outdoors");
		
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public List<YoungAdult> getParticipants() {
		return participants;
	}
	public void setParticipant(YoungAdult youngAdult) {
		this.participants.add(youngAdult);
	}
	
	public Timestamp getStart() {
		return start;
	}
	public void setStart(Timestamp start) {
		this.start = start;
	}
	public Timestamp getEnd() {
		return end;
	}
	public void setEnd(Timestamp end) {
		this.end = end;
	}
	@Override
	public String toString() {
		return name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}


	
}
