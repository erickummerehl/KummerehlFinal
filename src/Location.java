import java.util.ArrayList;

public class Location {

	private int y;
	private int x;
	
	
	public Location(int x, int y){
		this.y = y;
		this.x = x;
	}
	
	public int getY(){
		return y;
	}
	
	public int getX(){
		return x;
	}
	
	
	public ArrayList<Location> getAdjIn(int xMax, int yMax){
		ArrayList<Location> adj =  new ArrayList<Location>();
		
		if (!(x-1 < 0)){
			adj.add(new Location(x-1, y));
		}
		if (!(y-1 < 0)){
			adj.add(new Location(x, y-1));
		}
		if (!(x+1 > xMax)){
			adj.add(new Location(x+1, y));
		}
		if (!(y+1 > yMax)){
			adj.add(new Location(x, y+1));
		}
		
		return adj;
	}
	
}
