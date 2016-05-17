import processing.core.PApplet;

public class Game extends PApplet{
	PApplet p;
	
	Entity[][] grid;
	
	
	
	public Game(PApplet p){
		this.p = p;
		
		grid = new Entity[31][21];
		initGrid();
	}
	
	public void display(){
		displayGrid();
	}
	
	
	
	public void displayGrid(){
		
		for(int i = 0; i < grid.length-1; i++){
			for(int c = 0; c < grid[0].length-1; c++){
				
				grid[i][c].Display(p, 32*i, 32*c );
			}
		}
		
	}
	
	public void changeGrid(Entity e, int r, int c){
		grid[c][r] = e;
		updateMovementGrid();
	}
	
	public void updateMovementGrid(){
		
	}
	
	public void initGrid(){
		for(int i = 0; i < grid.length-1; i++){
			for(int c = 0; c < grid[0].length-1; c++){
				
				grid[i][c] = new Empty();
			}
		}
	}
	
}
