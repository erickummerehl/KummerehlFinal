import java.util.ArrayList;

public class Location {

	private int r;
	private int c;
	
	
	public Location(int r, int c){
		this.r = r;
		this.c = c;
	}
	
	public int getRow(){
		return r;
	}
	
	public int getCol(){
		return c;
	}
	
	
	public ArrayList<Location> getAdjIn(int rMax, int cMax){
		ArrayList<Location> adj =  new ArrayList<Location>();
		
		if (!(c-1 < 0)){
			adj.add(new Location(r, c-1));
		}
		if (!(r-1 < 0)){
			adj.add(new Location(r-1, c));
		}
		if (!(c+1 > cMax)){
			adj.add(new Location(r, c+1));
		}
		if (!(r+1 > rMax)){
			adj.add(new Location(r+1, c));
		}
		
		return adj;
	}
	
}
