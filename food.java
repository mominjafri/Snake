import java.awt.Rectangle;

public class food {
	private int x;
	private int y;
	
	public food(snake player) {
		this.random_spawn(player);
		
	}

	public void random_spawn(snake player) {
		boolean onsnake = true;
		while(!onsnake) {
			onsnake = false;
			
			x = (int)(Math.random() * game.width - 1);
			y = (int)(Math.random() * game.height - 1);
			
			for(Rectangle r : player.getBody()){
				if(r.x == x && r.y == y) {
					onsnake = true;
					
				}
			}
			
		}
				
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

}
