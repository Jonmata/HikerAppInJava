package Classes;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import Enum_Classes.Difficultylevel;
import Enum_Classes.TrailTypeE;
import javafx.util.Callback;

public class Trails implements Serializable{
	
	private Difficultylevel level; 
	private TrailTypeE trailType; 
	private double length,elev; 
	private String address,trailNames; 
	private LinkedList<Reviews> reviews=new LinkedList<>() ; 
	
	public Trails(String name,String add,Difficultylevel le , double x,double y, TrailTypeE typ ) {
		level=le;
		trailType= typ;
		address=add;
		length= x;
		elev= y; 
		trailNames=name;
	}

	public void addReview(Reviews review) {
		reviews.addFirst(review);
	}
	public Difficultylevel getLevel() {
		return level;
	}

	public TrailTypeE getTrailType() {
		return trailType;
	}

	public double getLength() {
		return length;
	}

	public double getElev() {
		return elev;
	}

	public String getAddress() {
		return address;
	}

	public String getTrailNames() {
		return trailNames;
	}

	public void setLevel(Difficultylevel level) {
		this.level = level;
	}

	public void setTrailType(TrailTypeE trailType) {
		this.trailType = trailType;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public void setElev(double elev) {
		this.elev = elev;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setTrialName(String trialName) {
		this.trailNames = trialName;
	}

	@Override
	public int hashCode() {
		return Objects.hash(address, elev, length, level, trailType, trailNames);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Trails other = (Trails) obj;
		return Objects.equals(address, other.address)
				&& Double.doubleToLongBits(elev) == Double.doubleToLongBits(other.elev)
				&& Double.doubleToLongBits(length) == Double.doubleToLongBits(other.length) && level == other.level
				&& trailType == other.trailType && Objects.equals(trailNames, other.trailNames);
	}

	@Override
	public String toString() {
		return "Trails [level=" + level + ", trailType=" + trailType + ", length=" + length + ", elev=" + elev
				+ ", address=" + address + ", trialName=" + trailNames + "]";
	}

	public LinkedList<Reviews> getReviews() {
		
		return reviews;
	}

	
	
	

	
	
}
