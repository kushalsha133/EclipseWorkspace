/**
 * 
 */
package com.springdemo.lifecycle;

/**
 * @author kusha
 *
 */
public class TrackCoach implements Coach {
	private FortuneService fortuneService;
	public TrackCoach() {}
	public TrackCoach(FortuneService fortuneService) {
		super();
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Run hard 5K";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return "Have a happy day";
	}
	// adding init method
	public void doMyStartupStuff() {
		System.out.println("Track Coach inside method doMyStartupStuff");
	}
	// adding destroy method
	public void doMyCleanupStuff() {
		System.out.println("Track Coach inside method doMyCleanupStuff");
	}
}
