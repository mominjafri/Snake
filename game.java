import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class game
implements KeyListener {
	
	private snake player;
	private food food;
	private graphics graphics;
	
	private JFrame window;
	
	public static final int width = 30;
	public static final int height = 30;
	public static final int dimension = 20;
	
	public game() {
		window = new JFrame();
		
		player = new snake ();
		food = new food(player);
		graphics = new graphics(this);
		
		window.add(graphics);
		
		window.setTitle("Snake");
		window.setSize(width * dimension, height * dimension);
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void start() {
		graphics.state = "RUNNING";
	}
	
	public void update() {
		if(graphics.state == "RUNNING") {
			if(chec_food_collision()) {
				player.grow();
				food.random_spawn(player);
			}
			else if(check_wall_collision() || check_self_collision()) {
				graphics.state = "END";
			}
			else {
				player.move();
			}
		}
	}
	
	public boolean check_wall_collision() {
		if(player.getX() < 0 || player.getX() >= width * dimension || player.getY() < 0 || player.getY() >= height * dimension) {
			return true;
		}
		return false;
	}
	
	private boolean chec_food_collision() {
		if(player.getX() == food.getX() * dimension && player.getY() == food.getY() * dimension) {
			return true;
		}
		return false;
	}
	
	private boolean check_self_collision() {
		for(int i = 1; i < player.getBody().size(); i++) {
			if(player.getX() == player.getBody().get(i).x && 
					player.getY() == player.getBody().get(i).y) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		
		if(graphics.state != "START") {
			if(keyCode == KeyEvent.VK_UP|| keyCode == KeyEvent.VK_W) {
				player.up();
			}
			
			else if(keyCode == KeyEvent.VK_DOWN || keyCode == KeyEvent.VK_S) {
				player.down();
			
			}
			else if(keyCode == KeyEvent.VK_LEFT || keyCode == KeyEvent.VK_A) {
				player.left();
			
			}
			else if(keyCode == KeyEvent.VK_RIGHT || keyCode == KeyEvent.VK_D){
				player.right();
		}
			
		}
		else {
			this.start();
		}
		
	}
		

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	public snake getPlayer() {
		return player;
	}

	public void setPlayer(snake player) {
		this.player = player;
	}

	public food getFood() {
		return food;
	}

	public void setFood(food food) {
		this.food = food;
	}

	public JFrame getWindow() {
		return window;
	}

	public void setWindow(JFrame window) {
		this.window = window;
	}



}
