package Enum_Classes;

public enum TrailTypeE {

	loop,out_and_back,point_to_point;
	
	public TrailTypeE getType(String n) {
		n=n.trim();
		if(loop.name().equalsIgnoreCase(n)) {
			return loop;
		}else if(out_and_back.name().equalsIgnoreCase(n)) {
			return out_and_back;
		}else if(point_to_point.name().equalsIgnoreCase(n)) {
			return point_to_point;
		}else {
			return null;
		}
	}
	
}
