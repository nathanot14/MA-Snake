package snake;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JPanel;

@SuppressWarnings("serial")

public class Render extends JPanel
{

	@Override
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		Snake snake = Snake.snake;

		g.setColor(Color.GRAY);
		
		g.fillRect(0, 0, 800, 700);

		g.setColor(Color.BLACK);

		for (Point point : snake.snakeParts)
		{
			g.fillRect(point.x * Snake.SCALE, point.y * Snake.SCALE, Snake.SCALE, Snake.SCALE);
		}
		
		g.fillRect(snake.head.x * Snake.SCALE, snake.head.y * Snake.SCALE, Snake.SCALE, Snake.SCALE);
		
		g.setColor(Color.RED);
		
		g.fillRect(snake.cherry.x * Snake.SCALE, snake.cherry.y * Snake.SCALE, Snake.SCALE, Snake.SCALE);
		
		String string = "Score: " + snake.score + ", Lengte: " + snake.tailLength + ", Tijd: " + snake.time / 20;
		
		String credits = "Gemaakt door Nathan Otten";
		
		String pauze = "Druk op (spatie) om te pauzeren";
		
		g.setColor(Color.white);
		
		g.drawString(credits, (int) (getWidth() / 2 - credits.length() * 2.5f), 660);
		
		g.drawString(pauze, (int) (getWidth() / 2 - pauze.length() * 2.5f), 620);
		
		g.drawString(string, (int) (getWidth() / 2 - string.length() * 2.5f), 20);

		string = "Game Over!";

		if (snake.over)
		{
			g.drawString(string, (int) (getWidth() / 2 - string.length() * 2.5f), (int) snake.dim.getHeight() / 4);
		}

		string = "Pauze!";

		if (snake.paused && !snake.over)
		{
			g.drawString(string, (int) (getWidth() / 2 - string.length() * 2.5f), (int) snake.dim.getHeight() / 4);
		}
	}
}