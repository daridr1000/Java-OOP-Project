package date;

import exceptions.WrongDateException;

public interface DateInterface {

	String checkDate();

	String getDateValidity() throws WrongDateException;

}
