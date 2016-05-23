import processing.core.PApplet;

public abstract class Entity {
	
	private boolean obstructive;
	private boolean image;
	
	public Entity(boolean obstructive, boolean image){
		this.obstructive = obstructive;
		this.image = image;
		
		
	}
	
	
	
	public void Display(PApplet p, int x, int y){
		p.rect(x, y, 32, 32);
		
	}
	
	public boolean isObstructive(){
		return obstructive;
	}
	
}
