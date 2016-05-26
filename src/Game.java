import java.util.ArrayList;


import processing.core.PApplet;
import processing.core.PVector;

public class Game extends PApplet{
	PApplet p;
	
	Entity[][] grid;
	PVector[][] moveGrid;
	
	ball b = new ball(32 * 29, 32 * 19);
	
	public Game(PApplet p){
		this.p = p;
		
		grid = new Entity[31][21];
		initGrid();
		moveGrid = new PVector[31][21];
		updateMovementGrid();
	}
	
	public void display(){
		displayGrid();
		moveBall();
	}
	
	
	public void moveBall(){
		int x = (b.x + 16)/32;
		int y = (b.y + 16)/32;
		if(moveGrid[x][y] != null)b.addVector(moveGrid[x][y]);
		b.move();
		p.fill(200, 20, 20);
		p.ellipse(b.x, b.y, 10, 10);
		
		//resets balls position after reaching end
		if(b.x < 30 && b.y <30){
			b.x = 32 * 29;
			b.y = 32 * 19;
		}
	}
	
	
	
	public void displayGrid(){
		for(int r = 0; r < grid.length-1; r++){
			for(int c = 0; c < grid[0].length-1; c++){
				
				grid[r][c].Display(p, 32*r, 32*c );
			}
		}
	}
	
	//used when user clicks grid space
	public void toggleWall(int x, int y){
		if(grid[x][y] instanceof Empty){
			changeGrid(new Wall(), x, y);
		} else changeGrid(new Empty(), x, y);
	}
	
	public void changeGrid(Entity e, int x, int y){
		grid[x][y] = e;
		//after new item is added to grid, run pathfinding
		updateMovementGrid();
		
	}
	
	//pathfinding A*
	public void updateMovementGrid(){
		ArrayList<Location> frontier = new ArrayList<Location>();
		frontier.add(new Location(0, 0));
		Location[][] cameFrom = new Location[31][21];
		cameFrom[0][0] = new Location(0, 0);
		
		Location current;
		while(frontier.size() != 0){
			current = frontier.remove(0);
			ArrayList<Location> adjLoc = current.getAdjIn(grid.length -1, grid[0].length -1);
			for(Location next : adjLoc){
				if(!(grid[next.getX()][next.getY()].isObstructive())){
					if(cameFrom[next.getX()][next.getY()] == null){
						frontier.add(next);
						cameFrom[next.getX()][next.getY()] = current;
					}
				}
			}
		}
		
		for(int y = 0; y < cameFrom[0].length; y++){
			for(int x = 0; x < cameFrom.length; x++){
				if(cameFrom[x][y] != null){
					moveGrid[x][y] = new PVector(cameFrom[x][y].getX() - x, cameFrom[x][y].getY() - y);
				}
			}
		}	
	}
	
	
	
	public void initGrid(){
		for(int i = 0; i < grid.length; i++){
			for(int c = 0; c < grid[0].length; c++){
				
				grid[i][c] = new Empty();
			}
		}
		
		//add random walls for testing
		for(int i = 0; i < 150; i++){
			int randX = (int)(Math.random()*31);
			int randY = (int)(Math.random()*21);
			if(!(randX == 0 && randY == 0) && !(randX == 30 && randY == 20)){
				grid[(int)(Math.random()*31)][(int)(Math.random()*21)] = new Wall();
			}
		}
	}
	
}
