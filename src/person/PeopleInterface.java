package person;

import exceptions.AgeException;

public interface PeopleInterface {
	public String getAgeValidity() throws AgeException;
	public String checkAge();
}
