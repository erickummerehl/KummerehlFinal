import java.util.ArrayList;


import processing.core.PApplet;
import processing.core.PVector;

public class Game extends PApplet{
	PApplet p;
	
	Entity[][] grid;
	PVector[][] moveGrid;
	
	testObj test = new testObj(300, 300);
	
	
	public Game(PApplet p){
		this.p = p;
		
		grid = new Entity[31][21];
		initGrid();
		moveGrid = new PVector[31][21];
		updateMovementGrid();
		
	}
	
	public void display(){
		displayGrid();
		TESTMOVE();
	}
	
	
	public void TESTMOVE(){
		int c = test.x/32;
		int r = test.y/32;
		if(moveGrid[r][c] != null)test.addVector(moveGrid[r][c]);
		test.move();
		p.ellipse(test.x, test.y, 10, 10);
		
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
		ArrayList<Location> frontier = new ArrayList<Location>();
		frontier.add(new Location(0, 0));
		Location[][] cameFrom = new Location[31][21];
		cameFrom[0][0] = new Location(0, 0);
//		for(int r = 0; r < cameFrom.length; r++){
//			for(int c = 0; c < cameFrom[0].length; c++){
//				cameFrom[r][c] = new Location(r, c);
//			}
//		}
		
		
		Location current;
		while(frontier.size() != 0){
			current = frontier.remove(0);
			ArrayList<Location> adjLoc = current.getAdjIn(grid[0].length -1, grid.length -1);
			for(Location next : adjLoc){
				if(!(grid[next.getRow()][next.getCol() - 1].isObstructive())){
					
					//boolean inCameFrom = false;
//					for(int r = 0; r < cameFrom.length; r++){
//						for(int c = 0; c < cameFrom[0].length; c++){
//							if(cameFrom[r][c] != null){
//								inCameFrom = true;
//								System.out.println("idbh");
//							}
//						}
//					}
					
					if(cameFrom[next.getCol()][next.getRow()] == null){
						frontier.add(next);
						cameFrom[next.getCol()][next.getRow()] = current;
					}	
				}
			}
		}
		
		for(int r = 0; r < cameFrom.length; r++){
			for(int c = 0; c < cameFrom[0].length; c++){
				if(cameFrom[r][c] != null){
					moveGrid[r][c] = new PVector(cameFrom[r][c].getCol() - c, cameFrom[r][c].getRow() - r);
					System.out.print(moveGrid[r][c].x + "," + moveGrid[r][c].y + "  ");
				}
			}
			System.out.println("");
		}
		
		
	}
	
	public void initGrid(){
		for(int i = 0; i < grid.length; i++){
			for(int c = 0; c < grid[0].length; c++){
				
				grid[i][c] = new Empty();
			}
		}
	}
	
}
