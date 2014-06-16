import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.util.*;

public class Gui {
      
    private JFrame frame;
    private JLabel target;
    private JButton newGameButton;
    private JButton rulesButton;
    private Set<JButton> guessButtons;
    private Gallows gallows;
    
    public Gui() {
    	this.guessButtons = new HashSet<>();
    	
        this.frame = new JFrame("Hangman");                                    
        this.frame.getContentPane().setLayout(new FlowLayout());                                          
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);           
        this.frame.setSize(300,600); 
        this.frame.setResizable(false);
        
        this.newGameButton = new JButton("New Game");
        this.newGameButton.setPreferredSize(new Dimension(130, 30));
        this.frame.getContentPane().add(newGameButton);
        this.rulesButton = new JButton("Rules");
        this.rulesButton.setPreferredSize(new Dimension(130, 30));
        this.frame.getContentPane().add(rulesButton);
        
        this.target = new JLabel();
        this.target.setPreferredSize(new Dimension(270, 30));
        this.target.setBorder(new LineBorder(Color.BLACK, 1));
        this.target.setOpaque(true);
        this.target.setBackground(Color.WHITE);
        this.target.setFont(new Font("Verdana", Font.BOLD, 30));
        this.target.setHorizontalAlignment(JLabel.CENTER);
        this.target.setVerticalAlignment(JLabel.CENTER);
        this.frame.getContentPane().add(target);
        
        this.gallows = new Gallows();
        this.gallows.setPreferredSize(new Dimension(270, 270));
        this.gallows.refresh(0);
        this.frame.getContentPane().add(gallows);
        
        for (int i = 65; i <= 90; i++) {
        	JButton letterButton = new JButton(String.valueOf((char) i));
        	letterButton.setPreferredSize(new Dimension(50, 30));
        	this.frame.getContentPane().add(letterButton);
        	this.guessButtons.add(letterButton);
        }
        
        this.frame.setVisible(true);
    }
    
    public void newGame(String text) {
    	this.setText(text);
    	for (JButton aButton : this.guessButtons) {
    	    this.setState(aButton, 0);
    	}
    }  
    
    public Set<JButton> getButtons(){
        return this.guessButtons;
    }
    
    public JButton getNewGameButton() {
    	return this.newGameButton;
    }
    
    public JButton getRulesButton() {
    	return this.rulesButton;
    }
    
    public void setState(JButton aButton, int state) {
    	if (state == 0) {
    		aButton.setEnabled(true);
    		aButton.setForeground(Color.BLACK);
    		aButton.setBackground(null);
    	} else if (state == 1) {
    		aButton.setEnabled(false);
    		aButton.setBackground(Color.GREEN);
    	} else {
    		aButton.setEnabled(false);
    		aButton.setBackground(Color.RED);
    	}
    }
    
    public void setText(String text) {
        this.target.setText(text);
    }
    
    public Gallows getGallows() {
    	return this.gallows;
    }
    
}