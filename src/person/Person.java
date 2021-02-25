package person;

import java.util.HashMap;
//import java.util.Random;

import date.BirthDate;
import date.Date;
import exceptions.AgeException;

public class Person {
	private String firstName;
	private String lastName;
	private BirthDate dateOfBirth;
	private String gender;
	private String phoneNumber;
	private HashMap<String, Integer> personalityTraits = new HashMap<String, Integer>();
	private YoungAdult sibling;
	private YoungAdult friend;
	private Adult mother;
	private Adult father;
	private Adult tutor;

	@Override
	public String toString() {
		return this.getFirstName() + " " + this.getLastName() + ", " + getAge();
	}

	public Person(String firstname, String lastname, BirthDate date, String gd) throws AgeException {
		firstName = firstname;
		lastName = lastname;
		dateOfBirth = date;
		gender = gd;
		getAgeValidity();
		// setPersonalityTraits();
	}

	/*
	 * private static int getRandomScale() { Random r = new Random(); return
	 * r.nextInt(5) + 1; }
	 */

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastname) {
		this.lastName = lastname;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(BirthDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return dateOfBirth.calculateAge();
	}

	public HashMap<String, Integer> getPersonalityTraits() {
		return personalityTraits;
	}

	public void setPersonalityTraits(int scale1, int scale2, int scale3, int scale4, int scale5) {
		// this.personalityTraits.put("Conscientiousness", getRandomScale());
		// this.personalityTraits.put("Agreeableness", getRandomScale());
		// this.personalityTraits.put("Neuroticism", getRandomScale());
		// this.personalityTraits.put("Openness", getRandomScale());
		// this.personalityTraits.put("Extraversion", getRandomScale());
		this.personalityTraits.put("Conscientiousness", scale1);
		this.personalityTraits.put("Agreeableness", scale2);
		this.personalityTraits.put("Neuroticism", scale3);
		this.personalityTraits.put("Openness", scale4);
		this.personalityTraits.put("Extraversion", scale5);
	}

	public YoungAdult getSibling() {
		return sibling;
	}

	public void setSibling(YoungAdult sibling) {
		this.sibling = sibling;
	}

	public YoungAdult getFriend() {
		return friend;
	}

	public void setFriend(YoungAdult friend) {
		this.friend = friend;
	}

	public Adult getMother() {
		return mother;
	}

	public void setMother(Adult mother) {
		this.mother = mother;
	}

	public Adult getFather() {
		return father;
	}

	public void setFather(Adult father) {
		this.father = father;
	}

	public Adult getTutor() {
		return tutor;
	}

	public void setTutor(Adult tutor) {
		this.tutor = tutor;
	}

	public String checkAge() {

		return "Valid age for this class!";
	}

	public String getAgeValidity() throws AgeException {
		String validity = checkAge();
		return validity;
	}

}
