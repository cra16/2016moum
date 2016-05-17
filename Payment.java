package oodp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JOptionPane;


public class Payment extends MainBoard{
   

        
   
   public void Pay_Point(Menu menu)
   {
        Connection conn = null;

        Customer user=MainBoard.getInstanceCustomer();        
        
        ResultSet is_login=null, inventory=null, account=null;
        
        try
           {
              Class.forName("com.mysql.jdbc.Driver").newInstance();
              conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "bitnami");
              if(!conn.isClosed()){
                 System.out.println("Successfully connected to MySQL server...");
                 
                 PreparedStatement s;
                
                 if(!user.getId().equals("Outsider"))
                 {
	                 s = conn.prepareStatement
	                       ("SELECT id FROM stuinfo WHERE id=?"); 
	                 s.setString(1, user.getId());
	                 is_login=s.executeQuery();
	                 
	                 is_login.next();
                 
                 
                    
                    s = conn.prepareStatement
                          ("SELECT cur_num FROM menu WHERE list=?"); 
                    s.setString(1, menu.menuList);
                    inventory=s.executeQuery();
                    inventory.next();
                       
                     
                    s = conn.prepareStatement
                          ("SELECT point FROM stuinfo WHERE id=?"); 
                    s.setString(1, user.getId());
                    account=s.executeQuery();
                    
                    account.next();
                    
                    
                    
                    if(inventory.getInt("cur_num")>0 && account.getInt("point") >= menu.menuPrice)
                    {
   
                       //���� ��� Ȯ��
                       s = conn.prepareStatement
                             ("UPDATE menu SET sold_num =sold_num+1,cur_num=cur_num-1 WHERE list=?"); 
                       s.setString(1, menu.menuList);
                       s.executeUpdate();
                      
   
                       //���� ���� ���� Ȯ��,
                       s = conn.prepareStatement
                             ("UPDATE stuinfo SET point=point-"+menu.menuPrice+" WHERE id=?");
                       s.setString(1, user.getId());
                       s.executeUpdate();
                       JOptionPane.showMessageDialog(null, "���� �Ϸ� �Ǿ����ϴ�.");
                       s.close();
                                 
                    }
                    else if (inventory.getInt("cur_num")>0)
                    {
                       JOptionPane.showMessageDialog(null, "����Ʈ�� �����մϴ�.");
                       
                    }
                    else if(account.getInt("point") >= menu.menuPrice)
                    {
                       JOptionPane.showMessageDialog(null, "��� �����մϴ�.");
                    }
                 }
                 else   //id�� db�� ������
                 {
                    JOptionPane.showMessageDialog(null, "����Ʈ�� �̿��� �� �����ϴ�.");
                 }
                 
             } 
          } 
          catch(Exception exc)
          {   
             System.err.println("Exception: " + exc.getMessage());
          }

   }
   
   public void Pay_Cash(Menu menu)
   {
        Connection conn = null;

        	Customer user=MainBoard.getInstanceCustomer();        
           
        	ResultSet is_login=null, inventory=null;

            String input;
            int money;
            
           try
              {
                 Class.forName("com.mysql.jdbc.Driver").newInstance();
                 conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "bitnami");
                 if(!conn.isClosed()){
                    System.out.println("Successfully connected to MySQL server...");
                    
                    PreparedStatement s;
                         
                    
                    if(!user.getId().equals("Outsider"))
                    {   
                    	
	                    s = conn.prepareStatement
	                          ("SELECT id FROM stuinfo WHERE id=?"); 
	                    s.setString(1, user.getId());
	                    is_login=s.executeQuery();
	                    
	                    is_login.next();
	                    
                    
                    	      
                       s = conn.prepareStatement
                             ("SELECT cur_num FROM menu WHERE list=?"); 
                       s.setString(1, menu.menuList);
                       inventory=s.executeQuery();
                       
                       inventory.next();
                          
                       input = JOptionPane.showInputDialog("���� ������ �ִ� ������ �׼��� �Է��Ͽ� �ּ���.");
                       money = Integer.parseInt(input);

                       if(inventory.getInt("cur_num")>0 && money >= menu.menuPrice)
                       {
      
                          //���� ��� Ȯ��
                          s = conn.prepareStatement
                                ("UPDATE menu SET sold_num =sold_num+1,cur_num=cur_num-1 WHERE list=?"); 
                          s.setString(1, menu.menuList);
                          s.executeUpdate();
                         
                          JOptionPane.showMessageDialog(null, "������ �Ϸ�Ǿ����ϴ�.\n���� �ܾ��� "+(money-menu.menuPrice)+"�Դϴ�.");
                          
      
                       }
                       else if (inventory.getInt("cur_num")>0)
                       {
                          JOptionPane.showMessageDialog(null, "������ �����մϴ�.");
                          
                       }
                       else if( money >= menu.menuPrice)
                       {
                          JOptionPane.showMessageDialog(null, "��� �����մϴ�.");
                       }
                   }
                   else
                   {
                      

                       s = conn.prepareStatement
                             ("SELECT cur_num FROM menu WHERE list=?"); 
                       s.setString(1, menu.menuList);
                       inventory=s.executeQuery();
                       
                       inventory.next();
                          
                       input = JOptionPane.showInputDialog("���� ������ �ִ� ������ �׼��� �Է��Ͽ� �ּ���.");
                       money = Integer.parseInt(input);

                       if(inventory.getInt("cur_num")>0 && money >= menu.menuPrice)
                       {
      
                          //���� ��� Ȯ��
                          s = conn.prepareStatement
                                ("UPDATE menu SET sold_num =sold_num+1,cur_num=cur_num-1 WHERE list=?"); 
                          s.setString(1, menu.menuList);
                          s.executeUpdate();
                         
                          JOptionPane.showMessageDialog(null, "������ �Ϸ�Ǿ����ϴ�.\n���� �ܾ��� "+(money-menu.menuPrice)+"�Դϴ�.");
                          
      
                       }
                       else if (inventory.getInt("cur_num")>0)
                       {
                          JOptionPane.showMessageDialog(null, "������ �����մϴ�.");
                          
                       }
                       else if( money >= menu.menuPrice)
                       {
                          JOptionPane.showMessageDialog(null, "��� �����մϴ�.");
                       }
                   }
                    
                    s.close();
                } 
             } 
             catch(Exception exc)
             {   
                System.err.println("Exception: " + exc.getMessage());
             }

         
         
   }
   
   public void Pay_Coupon(Menu menu)
   {
        Connection conn = null;

        Customer user=MainBoard.getInstanceCustomer();        
        ResultSet is_login=null, inventory=null,account=null;
        
        try
           {

        	  Class.forName("com.mysql.jdbc.Driver").newInstance();
              conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "bitnami");
              if(!conn.isClosed()){
                 System.out.println("Successfully connected to MySQL server...");
                 
                 PreparedStatement s;
                 

                 
                 
                 if(!user.getId().equalsIgnoreCase("Outsider"))
                 {
                	 s = conn.prepareStatement
                             ("SELECT id FROM stuinfo WHERE id=?"); 
                       s.setString(1, user.getId());
                       is_login=s.executeQuery();
                       
                       is_login.next();
              
                 
               

                    
                    s = conn.prepareStatement
                          ("SELECT cur_num FROM menu WHERE list=?"); 
                    s.setString(1, menu.menuList);
                    inventory=s.executeQuery();
                    inventory.next();
                    
                   
                    s = conn.prepareStatement
                          ("SELECT coupon FROM stuinfo WHERE id=?"); 
                    s.setString(1, user.getId());
                    account=s.executeQuery();
                    account.next();
                       
                    if(inventory.getInt("cur_num")>0 && account.getInt("coupon") >= 1)
                    {
   
                       //���� ��� Ȯ��
                       s = conn.prepareStatement
                             ("UPDATE menu SET sold_num =sold_num+1,cur_num=cur_num-1 WHERE list=?"); 
                       s.setString(1, menu.menuList);
                       s.executeUpdate();
                      
   
                       //���� ���� ���� Ȯ��,
                       s = conn.prepareStatement
                             ("UPDATE stuinfo SET coupon=coupon-1 WHERE id=?");
                       s.setString(1, user.getId());
                       s.executeUpdate();
                       
                       JOptionPane.showMessageDialog(null, "����  ������ �Ϸ�Ǿ����ϴ�.");
                       s.close();
                    }
                    else if (inventory.getInt("cur_num")>0)
                    {
                       JOptionPane.showMessageDialog(null, "������ �����մϴ�.");
                       
                    }
                    else if(account.getInt("coupon") >= 1)
                    {
                       JOptionPane.showMessageDialog(null, "��� �����մϴ�.");
                    }
                 }
                 else
                 {
                	   JOptionPane.showMessageDialog(null, "������ ����� �� �����ϴ�."); 
                 }
                
              }
              
          } 
          catch(Exception exc)
          {   
             System.err.println("Exception: " + exc.getMessage());
          }

      
   }
   

}
