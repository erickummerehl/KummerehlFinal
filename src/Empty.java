import processing.core.PApplet;

public class Empty extends Entity{
	
	
	
	
	public Empty(){
		super(false, false);
		
		
	}
	
	
	public void Display(PApplet p, int x, int y){
		p.fill(70, 200, 70);
		p.rect(x, y, 32, 32);
		
	}
	
}
