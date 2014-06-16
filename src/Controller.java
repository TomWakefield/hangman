import java.awt.event.*;
import javax.swing.*;

public class Controller {

    private GameLogic game;
    private Gui gui;
    private ActionListener actionListener;
    
    public Controller(GameLogic game, Gui gui){
        this.game = game;
        this.gui = gui;
        this.control();
        this.newGame();                 
    }
    
    public void control() {
    	
    	actionListener = new ActionListener() {
    		public void actionPerformed(ActionEvent actionEvent) {
    			newGame();
    		}
    	};
    	this.gui.getNewGameButton().addActionListener(actionListener);
    	
    	actionListener = new ActionListener() {
    		public void actionPerformed(ActionEvent actionEvent) {  
    			guessLetter(actionEvent.getSource());
    		}

    	};                
    	for (JButton aButton : gui.getButtons()) {
    		aButton.addActionListener(actionListener);   
    	}
	}
    
    public void newGame() {
    	this.gui.newGame(this.game.newGame());
    }
    
    private void guessLetter(Object aButton) {
    	char guessedLetter = ((JButton) aButton).getText().charAt(0);
    	boolean isCorrect = this.game.guessLetter(guessedLetter);
    	if (isCorrect) {
    		this.gui.setState((JButton) aButton, 1);
    		this.gui.setText(this.game.getWord(false));
    	} else {
    		this.gui.setState((JButton) aButton, -1);
    		this.gui.getGallows().refresh(this.game.getWrongGuesses());
    	}
    	int gameState = this.game.getGameState();
    	if (gameState == 1) {
    		JOptionPane.showMessageDialog(null, "Congratulations! You win!");
    	} else if (gameState == -1) {
    		this.gui.setText(this.game.getWord(true));
    		JOptionPane.showMessageDialog(null, "Sorry! You lose! The target word was: " + this.game.getWord(true));
    	}
    	
    }

}