package datetime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class NanoSecondDifference {

	static void birthDayDifference(String self, String sibling){
		
		long nanoseconds,days;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
		
		LocalDate selfDate = LocalDate.parse(self,formatter);
		LocalDate siblingDate = LocalDate.parse(sibling,formatter);
		
		LocalDateTime selfDateTime = selfDate.atStartOfDay();
		LocalDateTime siblingDateTime = siblingDate.atStartOfDay();
		
		nanoseconds = nanosecondDifference(selfDateTime, siblingDateTime);
		System.out.println("The difference between the birth time in Nanoseconds is: "+nanoseconds);
		
		days = dayDifference(selfDateTime, siblingDateTime);
		System.out.println("The difference between the birth time in Days is: "+days);
		
		
	}
	
	static void timeZoneDifference(String self, String sibling) {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
		
		LocalDate selfDate = LocalDate.parse(self,formatter);
		LocalDate siblingDate = LocalDate.parse(sibling,formatter);
		
		LocalDateTime selfDateTime = selfDate.atStartOfDay();
		LocalDateTime siblingDateTime = siblingDate.atStartOfDay();
		ZonedDateTime time = siblingDateTime.atZone(ZoneId.of("America/Montreal"));


		//days = dayDifference(selfDateTime, time);
		System.out.println("The difference between the birth time in Days is: "+Math.abs(ChronoUnit.DAYS.between(selfDateTime, time)));
		
	}
	
	
	public static long nanosecondDifference(LocalDateTime date1, LocalDateTime date2) {
		return Math.abs(ChronoUnit.NANOS.between(date1, date2));	
	}
	
	public static long dayDifference(LocalDateTime date1, LocalDateTime date2) {
		return Math.abs(ChronoUnit.DAYS.between(date1, date2));	
	}
	
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		System.out.print("Enter date in dd/mm/yyyy format: \n");
		String self = s.next();
		String sibling = s.next();
		birthDayDifference(self,sibling);
		
		System.out.print("*****************************\nTimeZone:\n");
		timeZoneDifference(self, sibling);
		s.close();
	}
}
