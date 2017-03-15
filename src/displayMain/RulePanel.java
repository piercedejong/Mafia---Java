package displayMain;

import myJStuff.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;

import net.miginfocom.swing.MigLayout;

public class RulePanel{
	
	private Color textColor;
	private Color btnBackgroundColor;
	
	private Font titleFont;
	private Font buttonFont;

	private JPanel contentPane;
	private JPanel north;
	private JPanel south;
	
	private JLabel lblAbout;

	private JButton btnBack;
	private JPanel west;
	private JPanel east;
	private JPanel center;

	/**
	 * Create the frame.
	 */
	public RulePanel() {
		
		setFont();
		setColor();

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		
		north = new JPanel();
		contentPane.add(north, BorderLayout.NORTH);
		north.setLayout(new MigLayout("", "[grow,center]", "[]"));
		
		south = new JPanel();
		contentPane.add(south, BorderLayout.SOUTH);
		south.setLayout(new MigLayout("", "[]", "[]"));
		
		west = new JPanel();
		contentPane.add(west, BorderLayout.WEST);
		
		east = new JPanel();
		contentPane.add(east, BorderLayout.EAST);
		
		center = new JPanel();
		contentPane.add(center, BorderLayout.CENTER);
		
		displayNorth();
		displaySouth();
	}
	
	private void displayNorth(){
		lblAbout = new MyLabel("Rules", textColor, titleFont);
		north.add(lblAbout, "cell 0 0");
	}
	
	private void displaySouth(){
		btnBack = new MyButton("Back", textColor, btnBackgroundColor, buttonFont);
		south.add(btnBack, "cell 0 0");
		btnBack.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent e){
    			MainController.getInstance().switchMain();
    			
		}});
		
	}
	
	private void setBackground(Color c){
		north.setBackground(c);
		south.setBackground(c);
		east.setBackground(c);
		west.setBackground(c);
		center.setBackground(c);
	}
	
	private void setFont(){
		titleFont = new MyFont(50);
		buttonFont = new MyFont(30);
	}
	
	private void setColor(){
		textColor = Colors.purple;
		btnBackgroundColor = Colors.blue;
	}
	
	public JPanel getContentPane(){
		return contentPane;
	}
	
	

}
