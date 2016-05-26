import processing.core.PApplet;

public class run extends PApplet{
	
	Game g;
	
	
	
	
	
	public void setup(){
		size(1000, 720);
		
		g = new Game(this);
		
		
	}
	
	
	
	public void draw(){
		g.display();
		
	}
	
	public void mousePressed(){
		int x = mouseX/32;
		int y = mouseY/32;
		if(x < 31 && y < 21){
			g.toggleWall(x, y);
		}
	}
	
}
