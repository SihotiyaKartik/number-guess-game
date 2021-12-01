package com.code;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class screen implements ActionListener{

	JLabel label1;
	JLabel label2;
	JLabel label3;
	JLabel label4;
	JButton button;
	JTextField textField;
	ImageIcon image;
	int guesses = 0;
	int randomNum;
	
	
	screen(){
		
		JFrame frame = new JFrame();
		frame.setSize(500,500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		
		//frame.pack();
		
		frame.setLocationRelativeTo(null);
		
		randomNum = (int)(Math.random()*100 + 1);
		//System.out.println(randomNum);
		
		label1 = new JLabel("Number guessing game");
		label1.setBounds(50,10,400,50);
		label1.setFont(new Font("MV Boli",Font.BOLD,35));
		label1.setHorizontalAlignment(JLabel.CENTER);
		
		label2 = new JLabel("Make a guess from 0-100");
		label2.setBounds(50,60,400,50);
		label2.setFont(new Font("MV Boli",Font.PLAIN,20));
		label2.setHorizontalAlignment(JLabel.CENTER);
		
		label4 = new JLabel();
		label4.setBounds(50,110,400,40);
		label4.setFont(new Font("Cosmos",Font.PLAIN,15));
		label4.setForeground(Color.red);
		label4.setHorizontalAlignment(JLabel.CENTER);
		
		
		textField  = new JTextField();
		textField.setBounds(50,160,400,50);
		textField.setFont(new Font("Cosmos",Font.PLAIN,30));
		textField.addActionListener(this);
		//textField.getDocument().addDocumentListener(this);
		//System.out.println(textField);
		
		
		label3 = new JLabel();
		label3.setText("Guesses: " + guesses);
		label3.setBounds(50,400,400,50);
		label3.setFont(new Font("MV Boli",Font.PLAIN,25));
		
		button  = new JButton("Reset");
		button.setBounds(250,400,150,50);
		button.addActionListener(this);
		button.setFont(new Font("Cosmos",Font.PLAIN,20));
		button.setFocusable(false);
		
		
		frame.add(label1);
		frame.add(label2);
		frame.add(label4);
		frame.add(textField);
		frame.add(label3);
		frame.add(button);
		frame.setVisible(true);
		
		
		
	}
	
	public void resetGame() {
		textField.setEditable(true);
		guesses = 0;
		label3.setText("Guesses: " + guesses);
		randomNum = (int)(Math.random()*100 + 1);
		label4.setForeground(Color.red);
		label4.setText("");
		//System.out.println(randomNum);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == textField) {
			try {
				int num = Integer.parseInt(textField.getText());
				//System.out.println(Integer.parseInt(textField.getText()));
				
					if(num < randomNum) {
						label4.setText("Try some bigger number");
						guesses++;
						label3.setText("Guesses: " + guesses);
					}
					else if(num > randomNum) {
						label4.setText("Try some smaller number");
						guesses++;
						label3.setText("Guesses: " + guesses);
					}
					else {
						label4.setForeground(new Color(0,200,0));
						label4.setText("Bravo! You guessed correct number, Please hit reset");
						guesses++;
						label3.setText("Guesses: " + guesses);
						textField.setEditable(false);
						
					}
				
				textField.setText("");
				
			}
			catch(Exception err) {
				label4.setText("Please enter number only");
				textField.setText("");
			}
			
			
		}
		
		if(e.getSource() == button) {
			resetGame();
		}
		
	}
	

	
	
	
}
