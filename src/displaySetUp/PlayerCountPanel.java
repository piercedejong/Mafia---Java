package displaySetUp;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;

import myJStuff.*;


/**
 * This class creates the Panel for selecting how many
 * players you want in the game. This precedes the
 * PlayerNamePanel and supersedes the Main Panel
 * @author Elvin Limpin 30018832
 * 
 *
 */
public class PlayerCountPanel extends MyPanel{
	
	private ActionListener globalListener;
	
	//Labels for the north panel
	private JLabel lblText;
	private JLabel lblText2;
	
	private JButton btnContinue;
	private JButton btnHome;
	
	private List<JButton> buttonList = new ArrayList<>();

	/**
	 * Constructor initalizes the view and creates an actionListener
	 * @param actionListener
	 */
	public PlayerCountPanel(ActionListener packageListener, ActionListener globalListener) {
		this.packageListener = packageListener;
		this.globalListener = globalListener;
		contentPane.setName("PlayerCount Panel");
		displayNorth();
		displaySouth();
		displayCenter();
	}

	/** Method displays contents in the north **/
	private void displayNorth(){
		lblText = new MyLabel("How Many", textColor, titleFontSize);
		north.add(lblText, "cell 0 0,alignx center");
		
		lblText2 = new MyLabel("Players?", textColor, titleFontSize);
		north.add(lblText2, "cell 0 1,alignx center");
	}

	/** Method displays contents in the center **/
	private void displayCenter(){
		//Loops to create a button for each amount of players aloud 
		for(int i=5;i<=12;i++){
			//Create each button at location i
			displayPlayerButton(i);
		}
	}
	
	/** Method displays contents in the south**/
	private void displaySouth(){
		
		btnHome = new MyButton("Home",buttonFontSize);
		south.add(btnHome,"cell 0 0,alignx left");
		btnHome.addActionListener(globalListener);
		btnHome.setName("Home");
		
		btnContinue = new MyButton("Continue");
		btnContinue.setName("Continue_PlayerCount");
		south.add(btnContinue, "cell 1 0,growx");
		btnContinue.addActionListener(packageListener);
	}
	/**
	 * Creates a button displaying option to pick amount of players
	 * Button will be highlighted (blue) when pressed until another button is pressed
	 * Sets the playerTotal to the value of i (amount of players)
	 * @param i
	 */
	private void displayPlayerButton(int i){
		JButton btnPlayer = new MyButton(Integer.toString(i));
		center.add(btnPlayer, "cell 0 "+i+",growx");
		btnPlayer.setName("PlayerCount "+Integer.toString(i));
		btnPlayer.addActionListener(packageListener);
		buttonList.add(btnPlayer);
	}
	
	/**
	 * Changes the button selected
	 * @param position
	 */
	public void changeButtonSelected(int position){
		for(JButton btn: buttonList){
			if(btn.getName().contains(Integer.toString(position))){
				btn.setBackground(Colors.select);
			}else{
				btn.setBackground(Colors.defaultButtonBackgroundColor);
			}
		}
	}
}