package oodp;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SuperviseCustomer extends JPanel implements ActionListener
{

	private Customer customer;
	private int status;
	
	JPanel panel = new JPanel();
	
	List list = new List(5, false);// customer list
	List list2 = new List(5, false);//Not yet

	JButton customerList = new JButton("customerList");
	JButton button2 = new JButton("button2");

	
	public SuperviseCustomer()
	{
	
		customer = new Customer();
		
		//List에 항목 추가
		for (int i=0;i<customer.getNumberOfStudent();i++)
		list.add(Integer.toString(customer.students[i].student_id));
		
		// List2에 항목 추가
		for (int i=0;i<customer.getNumberOfStudent();i++)
			list2.add(customer.students[i].student_name);
		
		
		panel.add(customerList,BorderLayout.SOUTH);
		panel.add(button2,BorderLayout.SOUTH);

		
		customerList.addActionListener(this);
		button2.addActionListener(this);

		
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
	      
	      if(event == customerList){
	    	  panel.add(list,BorderLayout.CENTER);
	      }
	      if(event == button2){
	    	  panel.remove(list);
	    	  panel.add(list2,BorderLayout.CENTER);
	      }

	}

}
