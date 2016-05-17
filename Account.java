package oodp;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.*;

public class Account extends JPanel implements ActionListener
{

	
	JPanel panel = new JPanel();
	JButton recharge;
	JTextField id;
	JTextField coupon;
	JTextField point;
	
	int current_point;
	
	public Account()
	{
	
		if(MainBoard.getInstanceCustomer() instanceof Student){
			id = new JTextField(10);
			coupon = new JTextField(10);
			point = new JTextField(10);
			
			id.setEditable(false);
			panel.add(id,BorderLayout.SOUTH);
			coupon.setEditable(false);
			panel.add(coupon,BorderLayout.SOUTH);
			point.setEditable(false);
			panel.add(point,BorderLayout.SOUTH);
			
  	          id.setText(MainBoard.getInstanceCustomer().getId());
	          coupon.setText(String.valueOf(MainBoard.getInstanceCustomer().getCoupon()));
	        try{
	    	Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "bitnami");
	    	Statement  stmt=conn.createStatement();
	    	ResultSet qry = stmt.executeQuery("SELECT * FROM stuinfo");	    
	    	while(qry.next()){
         		if(qry.getString("id").equals(MainBoard.getInstanceCustomer().getId())){
         			point.setText(String.valueOf(qry.getInt("point")));
         			current_point = qry.getInt("point");
         		}
         	}
	          }
	          catch(Exception exp){}
			
	        recharge = new JButton("recharge");
	  		// 추가
	  		panel.add(recharge,BorderLayout.SOUTH);
	  		recharge.addActionListener(this);
	          
		}
		else{
			id = new JTextField(10);
			coupon = new JTextField(10);
			
			id.setEditable(false);
			panel.add(id,BorderLayout.SOUTH);
			coupon.setEditable(false);
			panel.add(coupon,BorderLayout.SOUTH);
			
  	          id.setText(MainBoard.getInstanceCustomer().getId());
	          coupon.setText(String.valueOf(MainBoard.getInstanceCustomer().getCoupon()));
		}
		

	
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
			
			String input;
            int money;
            
			 input = JOptionPane.showInputDialog("충전할 포인트를 입력하여 주세요.");
             money = Integer.parseInt(input);
             try{
     	    	Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "bitnami");
     	    	PreparedStatement s;
     	    	
     	    	  s = conn.prepareStatement("UPDATE stuinfo SET point = point + '"+money+"' WHERE id=?"); 
                  s.setString(1, MainBoard.getInstanceCustomer().getId());
                  s.executeUpdate();
                 
                  JOptionPane.showMessageDialog(null, "충전이 완료되었습니다..");
                  
                  point.setText(String.valueOf(current_point+money));
     	    	
     	          }
     	          catch(Exception exp){}
             
		}
	}

}
