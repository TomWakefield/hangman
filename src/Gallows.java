import java.awt.*;
import javax.swing.*;

public class Gallows extends JPanel {
	
	int wrongGuesses;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    
	/**
	 * Constructor
	 */
	public Gallows()
	{
		super();
		wrongGuesses = 0;
	}
	
	/**
	 * Draws the hangman image
	 */
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		this.setBackground(Color.WHITE);
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		g2.setStroke(new BasicStroke(3));
		int midPos = (this.getWidth() / 2) + 20;
		switch (wrongGuesses)
		{
		    case 10: g2.drawLine(midPos, 200, midPos + 30, 230);
		    case 9: g2.drawLine(midPos, 200, midPos - 30, 230);
		    case 8: g2.drawLine(midPos, 135, midPos + 30, 165);
		    case 7: g2.drawLine(midPos, 135, midPos - 30, 165);
		    case 6: g2.drawLine(midPos, 130, midPos, 200);
			case 5: g2.drawOval(midPos - 25, 80, 50, 50);
			case 4: g2.drawLine(midPos, 20, midPos, 80);
			case 3: g2.drawLine(20, 50, 50, 20);
			case 2: g2.drawLine(20, 20, midPos, 20);
			case 1: g2.drawLine(20, 20, 20, this.getHeight() - 20);
		}
	}
	
	/**
	 * Forces a repaint of the hangman image
	 * @param guesses the number of incorrect guesses made
	 */
	public void refresh(int guesses)
	{
		this.wrongGuesses = guesses;
		this.repaint();
	}
}