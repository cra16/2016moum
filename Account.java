package oodp;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Account extends JPanel implements ActionListener
{

	private Student student;
	private int status;
	
	JPanel panel = new JPanel();
	JLabel label = new JLabel();
	JButton recharge = new JButton("recharge");

	
	public Account()
	{
	
		//student = new Student(21200534,"이세계","asdf");
		
		
		
		label.setText(Integer.toString(student.getPoint()));

		// 추가
		panel.add(recharge,BorderLayout.SOUTH);
		panel.add(label,BorderLayout.SOUTH);

		
		recharge.addActionListener(this);

		
	}
	
	public void actionPerformed(ActionEvent e){
		Object event  = e.getSource();

	      MainBoard.board.remove(MainBoard.board_panel);
	      MainBoard.board.repaint();
	      MainBoard.board.revalidate();
	      
	      MainBoard.board_panel=this.panel;
	      MainBoard.board_panel.setBackground(Color.white);
	      MainBoard.board_panel.setBounds(150,40,650,560);
	      MainBoard.board.add(MainBoard.board_panel);
	      
		if(event == this.recharge){
			
		}
	}

}
