import processing.core.PApplet;
import processing.core.PVector;

public class ball extends PApplet{
	int x, y;
	int xSpeed, ySpeed;
	
	public ball(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public void move(){
		x += xSpeed;
		y += ySpeed;
	}
	
	
	public void addVector(PVector v){
		xSpeed = (int) v.x;
		ySpeed = (int) v.y;
	}
	
}
