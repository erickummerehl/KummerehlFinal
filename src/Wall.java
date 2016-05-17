import processing.core.PApplet;

public class Wall extends Entity{
	
	
	
	
	
	public Wall(){
		 super(true, false);
	}
	
	public void Display(PApplet p, int x, int y){
		p.fill(70, 70, 70);
		p.rect(x, y, 32, 32);
		
	}
	
	
}
