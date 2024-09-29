package Classes;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;


public class TrailsBag implements Serializable{

	private HashSet<Trails> trailContainer;
	private static TrailsBag tb;
	private TrailsBag() {

		trailContainer=new HashSet<>(50000);
	}
	public static TrailsBag getTB() {
		if(tb==null) {
			tb=new TrailsBag();
		}
		return tb;
	}
	public static void setTB(TrailsBag readObject) {
		tb= readObject;
		
	}
	public HashSet<Trails> getTrailContainer() {
		return trailContainer;
	}
	public Optional<Trails> search(String temptrail) {
		Stream<Trails> temp = trailContainer.stream().filter((s)->s.getTrailNames().equalsIgnoreCase(temptrail));
		
		return temp.findFirst();
	
	}
	public Stream<Trails> search(Predicate<? super Trails> p ){
		return trailContainer.stream().filter(p);
	}
	
}
