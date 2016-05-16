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

        String user_id =  userText.getText();        
        ResultSet is_login=null, inventory=null, account=null;
        
        try
           {
              Class.forName("com.mysql.jdbc.Driver").newInstance();
              conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "298383");
              if(!conn.isClosed()){
                 System.out.println("Successfully connected to MySQL server...");
                 
                 PreparedStatement s;
                
                 JOptionPane.showMessageDialog(null, user_id);
                  
                 s = conn.prepareStatement
                       ("SELECT id FROM stuinfo WHERE id=?"); 
                 s.setString(1, user_id);
                 is_login=s.executeQuery();
                
                 
                 if(is_login.getString("id")!=null)
                 {
                    JOptionPane.showMessageDialog(null, inventory.getInt("cur_num"));
                        
                    s = conn.prepareStatement
                          ("SELECT cur_num FROM menu WHERE list=?"); 
                    s.setString(1, menu.menuList);
                    inventory=s.executeQuery();
                    
                    JOptionPane.showMessageDialog(null, account.getInt("point"));
                     
                    s = conn.prepareStatement
                          ("SELECT point FROM stuinfo WHERE id=?"); 
                    s.setString(1, user_id);
                    account=s.executeQuery();
                       
                    if(inventory.getInt("cur_num")>0 && account.getInt("point") >= menu.menuPrice)
                    {
   
                       //남은 재고 확인
                       s = conn.prepareStatement
                             ("UPDATE menu SET sold_num =sold_num+1,cur_num=cur_num-1 WHERE list=?"); 
                       s.setString(1, menu.menuList);
                       s.executeUpdate();
                      
   
                       //현재 계좌 정보 확인,
                       s = conn.prepareStatement
                             ("UPDATE stuinfo SET point=point-"+menu.menuPrice+" WHERE id=?");
                       s.setString(1, user_id);
                       s.executeUpdate();
                       
                    }
                    else if (inventory.getInt("cur_num")>0)
                    {
                       JOptionPane.showMessageDialog(null, "포인트가 부족합니다.");
                       
                    }
                    else if(account.getInt("point") >= menu.menuPrice)
                    {
                       JOptionPane.showMessageDialog(null, "재고가 부족합니다.");
                    }
                 }
                 else   //id가 db에 없으면
                 {
                    JOptionPane.showMessageDialog(null, "포인트를 이용할 수 없습니다.");
                 }
                 
                 s.close();
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

           String user_id =  userText.getText();        
           ResultSet is_login=null, inventory=null,account=null;
           
           try
              {
                 Class.forName("com.mysql.jdbc.Driver").newInstance();
                 conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "298383");
                 if(!conn.isClosed()){
                    System.out.println("Successfully connected to MySQL server...");
                    
                    PreparedStatement s;
                                       
                       
                    s = conn.prepareStatement
                          ("SELECT id FROM stuinfo WHERE id=?"); 
                    s.setString(1, user_id);
                    is_login=s.executeQuery();
                   
                    if(is_login.getString("id")!=null)
                    {
                          
                       s = conn.prepareStatement
                             ("SELECT cur_num FROM menu WHERE list=?"); 
                       s.setString(1, menu.menuList);
                       inventory=s.executeQuery();
                       
                      
                       s = conn.prepareStatement
                             ("SELECT cash FROM stuinfo WHERE id=?"); 
                       s.setString(1, user_id);
                       account=s.executeQuery();
                          
                       if(inventory.getInt("cur_num")>0 && account.getInt("cash") >= menu.menuPrice)
                       {
      
                          //남은 재고 확인
                          s = conn.prepareStatement
                                ("UPDATE menu SET sold_num =sold_num+1,cur_num=cur_num-1 WHERE list=?"); 
                          s.setString(1, menu.menuList);
                          s.executeUpdate();
                         
      
                          //현재 계좌 정보 확인,
                          s = conn.prepareStatement
                                ("UPDATE stuinfo SET cash=cash-? WHERE id=?");
                          s.setInt(1, menu.menuPrice);
                          s.setString(2, user_id);
                          
                          s.executeUpdate();
                          
                       }
                       else if (inventory.getInt("cur_num")>0)
                       {
                          JOptionPane.showMessageDialog(null, "현금이 부족합니다.");
                          
                       }
                       else if( account.getInt("cash") >= menu.menuPrice)
                       {
                          JOptionPane.showMessageDialog(null, "재고가 부족합니다.");
                       }
                   }
                   else
                   {
                      
                       s = conn.prepareStatement
                             ("SELECT cur_num FROM menu WHERE list=?"); 
                       s.setString(1, menu.menuList);
                       inventory=s.executeQuery();
                       

                       if(inventory.getInt("cur_num")>0 )
                       {
      
                          //남은 재고 확인
                          s = conn.prepareStatement
                                ("UPDATE menu SET sold_num =sold_num+1,cur_num=cur_num-1 WHERE list=?"); 
                          s.setString(1, menu.menuList);
                          s.executeUpdate();
                          
                          JOptionPane.showMessageDialog(null, "결제 되었습니다.");
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

        String user_id =  userText.getText();        
        ResultSet is_login=null, inventory=null,account=null;
        
        try
           {
              Class.forName("com.mysql.jdbc.Driver").newInstance();
              conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "298383");
              if(!conn.isClosed()){
                 System.out.println("Successfully connected to MySQL server...");
                 
                 PreparedStatement s;
                
                 s = conn.prepareStatement
                       ("SELECT id FROM stuinfo WHERE id=?"); 
                 s.setString(1, user_id);
                 is_login=s.executeQuery();
                
                 if(is_login.getString("id")!=null)
                 {
                    
                    
                    s = conn.prepareStatement
                          ("SELECT cur_num FROM menu WHERE list=?"); 
                    s.setString(1, menu.menuList);
                    inventory=s.executeQuery();
                    
                   
                    s = conn.prepareStatement
                          ("SELECT coupon FROM stuinfo WHERE id=?"); 
                    s.setString(1, user_id);
                    account=s.executeQuery();
                       
                    if(inventory.getInt("cur_num")>0 && account.getInt("coupon") >= 1)
                    {
   
                       //남은 재고 확인
                       s = conn.prepareStatement
                             ("UPDATE menu SET sold_num =sold_num+1,cur_num=cur_num-1 WHERE list=?"); 
                       s.setString(1, menu.menuList);
                       s.executeUpdate();
                      
   
                       //현재 계좌 정보 확인,
                       s = conn.prepareStatement
                             ("UPDATE stuinfo SET coupon=coupon-1 WHERE id=?");
                       s.setString(1, user_id);
                       s.executeUpdate();
                       
                    }
                    else if (inventory.getInt("cur_num")>0)
                    {
                       JOptionPane.showMessageDialog(null, "쿠폰이 부족합니다.");
                       
                    }
                    else if(account.getInt("coupon") >= 1)
                    {
                       JOptionPane.showMessageDialog(null, "재고가 부족합니다.");
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
   

}
