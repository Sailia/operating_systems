package hw1;
//The IncDate class
//Do not make changes to anything other than the body of increment() method
//Your name here

public class IncDate extends Date
{
 // copy constructor
 public IncDate(Date o)
 {
     super(o.m_month, o.m_day, o.m_year);
 }

 // constructor
 public IncDate(int month, int day, int year)
 {
     super(month, day, year);
 }

 public void addDays(int numDays)
 {
     // TODO: implement this method
	 int countdownDays = numDays;
	 int currentDay = m_day; 
	 boolean leapYear = false;
	 
	 while (countdownDays > 0) {
		 currentDay += 1;
		 if (m_year % 4 == 0) {
			 if (m_year % 100 == 0) {
				 if (m_year % 400 == 0) {
					 leapYear = true;
				 } else {
					 leapYear = false;
				 }
			 } else {
				 leapYear = true;
			 }
 		 }
		 
		 if (currentDay > 28 && m_month == 2 && leapYear == false) {
			 m_month++;
			 currentDay = 1;
			 countdownDays--;
		 } else if (currentDay > 29 && m_month == 2 && leapYear == true) {
			 m_month++;
			 currentDay = 1;
			 countdownDays--;
		 } else if (currentDay > 31) {
			 if (m_month == 12) {
				 m_month = 1;
				 currentDay = 1;
				 m_year++;
				 countdownDays--;
			 } else {
				 m_month++;
				 currentDay = 1;
				 countdownDays--;
			 }
		 } else if (currentDay == 30 && (m_month == 4 || m_month == 6 || m_month == 9 || m_month == 11)) {
			 m_month++;
			 currentDay = 1;
			 countdownDays--;
		 } else {
			 currentDay++;
			 countdownDays--;
		 }
	 }
	 m_day = currentDay; 
 }
}

