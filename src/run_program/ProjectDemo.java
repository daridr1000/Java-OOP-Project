package run_program;
import activity.Activity;
import date.BirthDate;
import exceptions.AgeException;
import exceptions.WrongDateException;
import lockdown.Lockdown;
import person.Adult;
import person.Person;
import person.YoungAdult;
import youngsupport.YoungSupport;

public class ProjectDemo {

	public static void main(String[] args) throws WrongDateException, AgeException {
		BirthDate birthDate1 = new BirthDate(2000,11,12);
		Person darius = new YoungAdult("Darius","Dragnea",birthDate1,"M");
		darius.setPersonalityTraits(2, 4, 2, 5, 3);
		
		
		BirthDate birthDate2 = new BirthDate(2000,6,5);
		Person dariusFriend = new YoungAdult("Olly","Man",birthDate2,"M");
		dariusFriend.setPersonalityTraits(2, 3, 3, 3, 3);
		
		BirthDate birthDate3 = new BirthDate(2004,9,20);
		Person dariusSister = new YoungAdult("Diana","Dragnea",birthDate3,"F");
		dariusSister.setPersonalityTraits(2, 3, 3, 3, 3);
		
		BirthDate birthDate4 = new BirthDate(1974,6,24);
		Person dariusMother = new Adult("Delia","Dragnea",birthDate4,"F");
		dariusMother.setPersonalityTraits(2, 3, 3, 3, 3);
		
		BirthDate birthDate5 = new BirthDate(1970,7,11);
		Person dariusFather = new Adult("Dumitru","Dragnea",birthDate5,"M");
		dariusFather.setPersonalityTraits(2, 3, 3, 3, 3);
		
		
		BirthDate birthDate6 = new BirthDate(1985,1,10);
		Person dariusTutor = new Adult("David","Miller",birthDate6,"M");
		dariusTutor.setPersonalityTraits(2, 3, 3, 2, 5);
		
		
		darius.setFriend((YoungAdult) dariusFriend);
		darius.setSibling((YoungAdult) dariusSister);
		darius.setMother((Adult) dariusMother);
		darius.setFather((Adult) dariusFather);
		darius.setTutor((Adult) dariusTutor);
		
		
		Activity.createActivities();
		
		System.out.println(darius);
		
		((YoungAdult) darius).addActivities();
		
		System.out.println("Pre-lockdown activities: "+ ((YoungAdult) darius).getActivities());
		System.out.println("Pre-lockdown feelings: "+ ((YoungAdult) darius).getFeelings());
		
		Lockdown ld = new Lockdown();
		ld.apply((YoungAdult) darius);
		System.out.println("Lockdown activities without Young Support: "+ ((YoungAdult) darius).getActivities());
		System.out.println("Lockdown feelings without Young Support: "+((YoungAdult) darius).getFeelings());
		
		YoungSupport ys = new YoungSupport();
		ys.recommendActivities((YoungAdult) darius);
		System.out.println("Lockdown activities with Young Support: "+ ((YoungAdult) darius).getActivities());
		System.out.println("Lockdown feelings with Young Support: "+((YoungAdult) darius).getFeelings());
	}

}
