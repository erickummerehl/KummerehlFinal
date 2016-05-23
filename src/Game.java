import java.util.ArrayList;


import processing.core.PApplet;
import processing.core.PVector;

public class Game extends PApplet{
	PApplet p;
	
	Entity[][] grid;
	PVector[][] moveGrid;
	
	
	public Game(PApplet p){
		this.p = p;
		
		grid = new Entity[31][21];
		initGrid();
		moveGrid = new PVector[31][21];
		updateMovementGrid();
		
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
		ArrayList<Location> frontier = new ArrayList<Location>();
		frontier.add(new Location(0, 0));
		Location[][] cameFrom = new Location[31][21];
		cameFrom[0][0] = new Location(0, 0);
		for(int r = 0; r < cameFrom.length; r++){
			for(int c = 0; c < cameFrom[0].length; c++){
				cameFrom[r][c] = new Location(0, 0);
			}
		}
		
		
		Location current;
		while(frontier.size() != 0){
			current = frontier.remove(0);
			ArrayList<Location> adjLoc = current.getAdjIn(grid[0].length, grid.length);
			for(Location next : adjLoc){
				if(!(grid[next.getCol()][next.getRow()].isObstructive())){
					
					boolean inCameFrom = false;
					for(int r = 0; r < cameFrom.length; r++){
						for(int c = 0; c < cameFrom[0].length; c++){
							if(next.getRow() == cameFrom[r][c].getRow() && next.getCol() == cameFrom[r][c].getCol()){
								inCameFrom = true;
							}
						}
					}
					
					if(inCameFrom == false){
						frontier.add(next);
						cameFrom[next.getCol()][next.getRow()] = frontier.remove(0);
					}	
				}
			}
		}
		
		for(int r = 0; r < cameFrom.length; r++){
			for(int c = 0; c < cameFrom[0].length; c++){
				moveGrid[r][c] = new PVector(cameFrom[r][c].getCol() - c, cameFrom[r][c].getRow() - r);
			}
		}
		
		
	}
	
	public void initGrid(){
		for(int i = 0; i < grid.length-1; i++){
			for(int c = 0; c < grid[0].length-1; c++){
				
				grid[i][c] = new Empty();
			}
		}
	}
	
}
