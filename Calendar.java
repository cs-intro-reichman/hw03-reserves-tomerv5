
public class Calendar {	
    // Starting the calendar on 1/1/1900
	static int dayOfMonth = 1;   
	static int month = 1;
	static int year = 1900;
	static int dayOfWeek = 2;     // 1.1.1900 was a Monday
	static int nDaysInMonth = 31; // Number of days in January

	public static void main(String args[]) {
        int userYear = Integer.parseInt(args[0]);
	 	while (year != userYear) {
	 		advance();
        }
        while (year == userYear) {
            System.out.println(dayOfMonth + "/" + month + "/" + year + (dayOfWeek % 7 == 1 ? " Sunday" : ""));
	 		advance();
        }
	 }
	
	 // Advances the date (day, month, year) and the day-of-the-week.
	 // If the month changes, sets the number of days in this month.
	 // Side effects: changes the static variables dayOfMonth, month, year, dayOfWeek, nDaysInMonth.
	 private static void advance() {
		int nDaysInMonth = nDaysInMonth(month, year);
		dayOfWeek++;
	
		// Reset dayOfWeek if it exceeds the maximum value 
		if (dayOfWeek > 7) {
			dayOfWeek = 1; 
		}
	
		if (dayOfMonth == nDaysInMonth) {
			dayOfMonth = 1;
			month++;
				
			if (month > 12) {
				month = 1;
				year++;
			}
		} else {
			dayOfMonth++;
		}
	}
		 
    // Returns true if the given year is a leap year, false otherwise.
	private static boolean isLeapYear(int year) {
		if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) return true;
		return false;
	}
	 
	// Returns the number of days in the given month and year.
	// April, June, September, and November have 30 days each.
	// February has 28 days in a common year, and 29 days in a leap year.
	// All the other months have 31 days.
	private static int nDaysInMonth(int month, int year) {
		int days;
		switch (month) {
			case 1, 3, 5, 7, 8, 10, 12: 
				days = 31;
				break;
			case 2:
				if (isLeapYear(year)) days = 29;
				else days = 28;
				break;
			case 4, 6, 9, 11:
				days = 30;
				break;
			default:
				return 0;   // wrong month check
			
		}
		return days;
	}
}