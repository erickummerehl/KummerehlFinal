import processing.core.PApplet;

public class run extends PApplet{
	
	Game g;
	
	
	
	
	
	public void setup(){
		size(1280, 720);
		
		g = new Game(this);
		
		
	}
	
	
	
	public void draw(){
		g.display();
		
	}
	
	public void mousePressed(){
		int c = mouseX/32;
		int r = mouseY/32;
		g.changeGrid(new Wall(), r, c);
	}
	
}
