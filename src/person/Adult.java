package person;

import date.BirthDate;
import exceptions.AgeException;

public class Adult extends Person implements PeopleInterface {



	public Adult(String firstname, String lastname, BirthDate date, String gd) throws AgeException {
		super(firstname, lastname, date, gd);
	}
	@Override
	public String checkAge() {
		int age = this.getAge();
		if (age > 24) {
			return "Valid age for this class!";
		}
		return "Invalid age for Adult class! Age should be greater than 24. ";
	}
	
	@Override
	public String getAgeValidity() throws AgeException {
		String validity = checkAge();
		if (validity != "Valid age for this class!") {
			throw new AgeException(validity);
		}
		return validity;
	}

}
