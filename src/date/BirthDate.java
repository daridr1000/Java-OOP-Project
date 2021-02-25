package date;

import exceptions.WrongDateException;
import java.time.*; 
public class BirthDate extends Date implements DateInterface {

	public BirthDate(int y, int m, int d) throws WrongDateException {
		super(y, m, d);
	}
	
	@Override
	public String checkDate() {
		LocalDate ld = LocalDate.now();
		int actualYear = ld.getYear();
		int year = this.getYear();
		int month = this.getMonth();
		int day = this.getDay();
		if (year < 1900 || year > actualYear - 1) {
			return("Invalid year! Year must be between 1900 and "+(actualYear-1)+"!");
		}
		if (month < 1 || month > 12) {
				return("Invalid month! Month must be between 1 and 12!");
			}
		if (day < 1 || day > 31) {
					return("Invalid day! Day must be between 1 and 31!");
		}
		return("Valid date!");
	}
	
	@Override
	public String getDateValidity() throws WrongDateException {
		String validity = checkDate();
		if(validity != "Valid date!") {
			throw new WrongDateException(validity);
		}
		return validity;
	}
	public int calculateAge() {
		LocalDate ld = LocalDate.now();
		int actualYear = ld.getYear();
		int actualMonth = ld.getMonthValue();
		int actualDay = ld.getDayOfMonth();
		if(this.getMonth() < actualMonth) {
			return actualYear - this.getYear();
		}	
		else {
			if(this.getMonth() > actualMonth) {
				return actualYear - this.getYear() - 1;
			}
			else {
				if(this.getDay() <= actualDay) {
					return actualYear - this.getYear();
				}
				else {
					return actualYear - this.getYear() - 1;
				}
			}
		}
	}
	@Override
	public String toString() {
		int year = this.getYear();
		int month = this.getMonth();
		int day = this.getDay();
		return Integer.toString(day)+ "/" + Integer.toString(month) + "/" + Integer.toString(year);
	}
}
