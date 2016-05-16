package oodp;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class SuperviseCustomerPanel extends JPanel implements ActionListener
{

	private SuperviseCustomer list;

	JPanel panel;
	
	private JList studentList;// customer list
	private JList professorList;// professor list
	int status;
	JButton student;
	JButton professor;
	
	JTextField id = new JTextField(10);
	JTextField name = new JTextField(10);
	JTextField coupon = new JTextField(10);
	JTextField point = new JTextField(10);
	
	public SuperviseCustomerPanel()
	{
		panel = new JPanel();
		
		list = new SuperviseCustomer();
		
		student = new JButton("student");
		professor = new JButton("professor");
		
		studentList =  new JList(list.getStudentList());
		professorList = new JList(list.getProfessorList());
		
		studentList.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		studentList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		studentList.addListSelectionListener(new ListListener());
		
		professorList.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		professorList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		professorList.addListSelectionListener(new ListListener());
		
		
			
		
		panel.add(student,BorderLayout.NORTH);
		panel.add(professor,BorderLayout.NORTH);
		
		
		id.setEditable(false);
		panel.add(id,BorderLayout.SOUTH);
		name.setEditable(false);
		panel.add(name,BorderLayout.SOUTH);
		coupon.setEditable(false);
		panel.add(coupon,BorderLayout.SOUTH);
		point.setEditable(false);
		panel.add(point,BorderLayout.SOUTH);
		
		student.addActionListener(this);
		professor.addActionListener(this);

		
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
	      
	      if(event == student){
	    	  panel.add(studentList,BorderLayout.CENTER);
	    	  status = 1;
	      }
	      if(event == professor){
	    	  panel.remove(this);
	    	  panel.add(professorList,BorderLayout.CENTER);
	    	  panel.repaint();
	    	  status = 2;
	    	  
	      }

	}
	 private class ListListener implements ListSelectionListener
	    {
	        public void valueChanged(ListSelectionEvent e)
	        {
	           if(status == 1){	
	        	   studentChanged();
	           }
	           else{System.out.println(status);
	        	   professorChanged();
	           }
	            
		    }
	        
	        private void studentChanged(){
	        	 String idValue = (String) studentList.getSelectedValue();
	        	 Student value = (Student)list.findById(idValue);
	        	 try
	        	 {
	        	      id.setText(idValue);
			          name.setText(value.getName());
			          coupon.setText(String.valueOf(value.getCoupon()));
			          point.setText(String.valueOf(value.getPoint()));
		        
	        	 }
	        	 catch( Exception e ){}
		    }
	        private void professorChanged(){
	        	String idValue = (String) professorList.getSelectedValue();
	        	Professor value = (Professor)list.findById(idValue);

	        	try
	        	 {
	        	      id.setText(idValue);
			          name.setText(value.getName());
			          coupon.setText(String.valueOf(value.getCoupon()));
			          point.setText("Not used");
		        
	        	 }
	        	 catch( Exception e ){}   
		            
	        }
	    }

}
