package date;
import java.time.*; 
import exceptions.WrongDateException;

public class Timestamp extends Date implements DateInterface {
	private int hour;
	private int minutes;

	public Timestamp(int y, int m, int d, int h, int min) throws WrongDateException {
		super(y, m, d);
		this.hour = h;
		this.minutes = min;
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public int getMinutes() {
		return minutes;
	}

	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}

	@Override
	public String getDateValidity() throws WrongDateException {
		String validity = checkDate();
		if (validity != "Valid timestamp!") {
			throw new WrongDateException(validity);
		}
		return validity;
	}

	@Override
	public String checkDate() {
		LocalDate ld = LocalDate.now();
		int actualYear = ld.getYear();
		int actualMonth = ld.getMonthValue();
		int actualDay = ld.getDayOfMonth();
		int hour = this.getHour();
		int minutes = this.getMinutes();
		int year = this.getYear();
		int month = this.getMonth();
		int day = this.getDay();
		if (year < actualYear) {
			return ("Invalid year! Year must be bigger than "+actualYear+"!");
		}
		else {
			if (year == actualYear) {
				if (month < actualMonth) {
					return ("Invalid month! Month must be bigger than " + actualMonth+"!");
				}
				else {
					if (month == actualMonth) {
						if (day < actualDay) {
							return ("Invalid day! Day must be bigger than " + actualDay+"!");
						}
					}
				}
			}
		}
		if (month < 1 || month > 12) {
			return ("Invalid month! Month must be between 1 and 12!");
		}
		if (day < 1 || day > 31) {
			return ("Invalid day! Day must be between 1 and 31!");
		}
		if (hour < 0 || hour > 23) {
			return "Invalid hour! Hour must be between 0 and 23!";
		}
		if (minutes < 0 || minutes > 59) {
			return "Invalid minutes! Minutes must be between 0 and 59!";
		}
		return "Valid timestamp!";
	}

	@Override
	public String toString() {
		int year = this.getYear();
		int month = this.getMonth();
		int day = this.getDay();
		int hour = this.getHour();
		int minutes = this.getMinutes();
		String realMinutes = Integer.toString(minutes);
		if (minutes < 10) {
			realMinutes = "0" + realMinutes;
		}
		return Integer.toString(day) + "/" + Integer.toString(month) + "/" + Integer.toString(year) + " "
				+ Integer.toString(hour) + ":" + realMinutes;
	}

}
