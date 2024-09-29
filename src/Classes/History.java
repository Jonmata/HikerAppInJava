package Classes;

import java.io.Serializable;
import java.time.LocalDate;

public class History implements Serializable{

	private Trails trailWalked;
	private double distanceWalked;
	private LocalDate date;
	private String startTime,endTime;

	public History(Trails trail,double lengthWalked, LocalDate date,String start,String end) {
		distanceWalked=lengthWalked;
		trailWalked=trail;
		this.date=date;
		startTime= start;
		endTime=end;
		
	}

	public Trails getTrailWalked() {
		return trailWalked;
	}
	public String getTrailName() {
		return trailWalked.getTrailNames();
	}

	public double getDistanceWalked() {
		return distanceWalked;
	}

	public LocalDate getDate() {
		return date;
	}

	public String getStartTime() {
		return startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setTrailWalked(Trails trailWalked) {
		this.trailWalked = trailWalked;
	}

	public void setDistanceWalked(double distanceWalked) {
		this.distanceWalked = distanceWalked;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	
	
	

}
