package displayGame;

import myJStuff.*;
import playerInfo.Player;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;

/**
 * NightPanel
 * This class displays the current players name, role, goal
 * and a list of buttons of all the players that when clicked set the target to the index value
 * 
 * @author Pierce de Jong 30006609
 *
 */
public class NightPanel extends MyPanel{
	
	//Create all of the labels for the NorthPanel
	private JLabel lblName;
	private JLabel lblRole;
	private JLabel lblAction;
	private JLabel lblMafia;
	private JLabel lblDetective;
	
	//JButton when pressed goes to the next screen
	private JButton btnContinue;
	//jButton that is only visible to detective. when pressed reveals 
	private JButton btnDetective;
	//List of all of the buttons representing each of the players
	private List<JButton> playerButtonList = new ArrayList<>();
	//List of all of the Mafia Members
	
	private String lynchTarget;

	/**
	 * Create the panel and all of the sub panels
	 * Displays all of the needed buttons and labels etc...
	 * @param playerInfo
	 */
	public NightPanel(ActionListener packageListener, List<String> mafiaMember, String lynchTarget) {
		this.packageListener = packageListener;
		this.lynchTarget = lynchTarget;
		contentPane.setName("Night Panel");
		//Create all of the needed buttons and labels and adds them to the panel
		displaySouth();
		displayNorth(mafiaMember);
		displayCenter();
	}
	/**
	 * Creates the name, role, info, and mafia labels and adds them to the north Panel
	 */
	private void displayNorth(List<String> mafiaMembers){
		String text = "";
		lblName = new MyLabel(text, textColor, titleFontSize);
		north.add(lblName, "flowy,cell 0 0");
		lblRole = new MyLabel(text, textColor, roleFontSize);
		north.add(lblRole, "cell 0 1");
		lblAction = new MyLabel(text, textColor, infoFontSize);
		north.add(lblAction, "cell 0 2");
		lblMafia= new MyLabel("Mafia Members: "+mafiaMembers.toString(), textColor, infoFontSize);
		lblMafia.setFont(new MyFont(setFontSize("Mafia Members: "+mafiaMembers,20,75)));
	}
	
	/**
	 * This displays all of the possible buttons that each player can press when it is his/ her turn
	 * Each button represents a player
	 */
	private void displayCenter(){
		//Create the detective button
		btnDetective = new MyButton("Confirm Target", textFontSize);
		center.add(btnDetective, "cell 0 14,alignx center");
		btnDetective.setName("Detective");
		btnDetective.addActionListener(packageListener);
		btnDetective.setVisible(false);
		btnDetective.setBorder(new EmptyBorder(2,2,2,2));
		
		lblDetective = new MyLabel("", textColor, textFontSize);
		center.add(lblDetective, "cell 0 13,alignx center");
		
	}
	/**
	 * Displays the button needed to be pressed to go to next screen
	 */
	private void displaySouth(){
		btnContinue = new MyButton("Continue",28);
		south.add(btnContinue, "cell 1 0,alignx center");
		btnContinue.addActionListener(packageListener);
		btnContinue.setName("Continue_NightPanel");
		btnContinue.setBorder(new EmptyBorder(10,10,10,10));
	}
	/**
	 * Creates a button representing a player for the Center Panel
	 * @param name - String for the text displayed on the JButotn
	 * @param position - index value of player and location on center grid y value
	 */
	public void displayPlayerButton(String name, int position){
		//if(test) {text = text+" | "+playerInfo.get(i).getRole();}
		JButton btnPlayer = new MyButton(name);//Create a new button with passing the String text
		btnPlayer.setName("Night_"+Integer.toString(position));//Sets the name of the button to the index value of the player
		center.add(btnPlayer, "cell 0 "+position+",growx");//Add the button to the center panel
		btnPlayer.addActionListener(packageListener);//Add action listener  
		btnPlayer.setFont(new MyFont(setFontSize(name,buttonFontSize,100)));
		if(btnPlayer.getFont().getSize()<25) btnPlayer.setBorder(new EmptyBorder(12,5,12,5));
		playerButtonList.add(btnPlayer);//Add to the list of player buttons
	}
	/**
	 * Sets the message for the detective
	 * @param text - Part of the Mafia, or not part
	 */
	public void setDetectiveMessage(String text){
		btnDetective.setVisible(false);
		lblDetective.setText(text);
	}
	/**
	 * Removes the button of the the target
	 * @param target - Index value of button to be removed 
	 */
	public void removePlayerButton(int target){
		if(target!=-1){//Error handling, Must have a valid target to remove the button
			for(JButton button: playerButtonList){//Loops through the list of player buttons
				String number = button.getName().substring(6, button.getName().length());
				if(number.equals(Integer.toString(target))){//Finds the one with the same name as the target. THe buttons are named 0,1,2... etc
					center.remove(button);//Remove the button from the list of buttons 
				}
			}
		}
	}
	/**
	 * Sets the new button pressed to selectColor
	 * Returns the previously selected color to btnBackgroundColor
	 * @param previous - int value of the last button pressed
	 * @param current - text on the button that has been pressed
	 */
	public void setButtonSelected(int previous,String current){
		for(JButton button: playerButtonList){
			if(button.getName().equals(current)){
				button.setBackground(selectColor);
			}else if(button.getName().contains(Integer.toString(previous))){
				button.setBackground(btnBackgroundColor);
			}
		}
	}
	/**
	 * Sets the display for the new player at night
	 * @param player - Player, the 
	 */
	public void setDisplay(Player player){
		//Resets the player target to -1
		for(JButton button:playerButtonList){
			button.setBackground(btnBackgroundColor);
		}
		//Sets the labels to the current players information
		lblName.setText(player.getName());
		lblRole.setText(player.getRole());
		lblAction.setText(player.getAction());
		//Clears Detective Label
		lblDetective.setText("");
		//If The current player is the detective display the button to check if the target is part of the Mafia
		if(player.getRole().contains("Detective")){
			btnDetective.setVisible(true);
		}else{
			btnDetective.setVisible(false);
		}
		//if the player is part of the Mafia, display a list of all Mafia Members to the screen
		if(player.getRole().contains("Mafia")){
			north.add(lblMafia, "cell 0 4");
		}else if(player.getRole().contains("Lyncher")){
			lblAction.setText("Lynch "+lynchTarget+" during the Day to win");
		}else{
			north.remove(lblMafia);
		}
								  //method in MyPanel
		lblName.setFont(new MyFont(setFontSize(lblName.getText(),titleFontSize,50)));
		lblAction.setFont(new MyFont(setFontSize(lblAction.getText(),roleFontSize,50)));
	}
}