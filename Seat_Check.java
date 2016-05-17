package oodp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Seat_Check extends JPanel implements ActionListener{

   public Seat_Check()
   {
      int i,j,available=0;
      
      setLayout(null);
      
      JPanel panel_1=new JPanel();
      panel_1.setLayout(null);
      panel_1.setBounds(190, 40, 260, 200);

      JPanel panel_2=new JPanel();
      panel_2.setLayout(null);
      panel_2.setBounds(190, 280, 260, 200);
      
      try
       {
           conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "bitnami");
           stmt=conn.createStatement();
       }
      catch(Exception exc){}
      
      for(i=1;i<=4;i++)
      {
         for(j=1;j<=4;j++)
         {
            try
             {      
                ResultSet re=stmt.executeQuery("SELECT * FROM seats WHERE x="+i+" AND y="+j+";");
                
                while(re.next())
                {
                   available=re.getInt("available");
                }
             }
             catch(Exception exc){}
            
            button=new JButton();
            button.setBounds(10+62*(j-1),10+48*(i-1),52,38);
            
            if(available==0)
               button.setText("O");
            else
               button.setText("X");
            button.setActionCommand(""+i+j);
            button.addActionListener(this);
            panel_1.add(button);
         }
      }
      
      for(i=1;i<=4;i++)
      {
         for(j=1;j<=4;j++)
         {
            try
             {      
                ResultSet re=stmt.executeQuery("SELECT * FROM seats WHERE x="+(i+4)+" AND y="+j+";");
                
                while(re.next())
                {
                   available=re.getInt("available");
                }
             }
             catch(Exception exc){}
            
            button=new JButton();
            button.setBounds(10+62*(j-1),10+48*(i-1),52,38);
            
            if(available==0)
               button.setText("O");
            else
               button.setText("X");
            button.setActionCommand(""+(i+4)+j);
            button.addActionListener(this);
            panel_2.add(button);
         }
      }

      add(panel_1);
      add(panel_2);
   }
   
   public void actionPerformed(ActionEvent e)
   {
      String command = e.getActionCommand();
      JButton event=(JButton)e.getSource();
      
      if(command.length()==2)
      {
         String x=command.substring(0, 1);
         String y=command.substring(1);
         
         try
          {
              conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "bitnami");
              stmt=conn.createStatement();
      
             ResultSet re=stmt.executeQuery("SELECT * FROM seats WHERE x="+x+" AND y="+y+";");
                
             while(re.next())
             {
                if(re.getInt("available")==0)
                {
                   stmt.executeUpdate("Update seats SET x="+x+",y="+y+",available=1 WHERE x="+x+" AND y="+y+";");
                   event.setText("X");
                   JOptionPane.showMessageDialog(null, "예약 되었습니다.");
                   
                }
                else
                {
                   stmt.executeUpdate("Update seats SET x="+x+",y="+y+",available=0 WHERE x="+x+" AND y="+y+";");
                   event.setText("O");
                   JOptionPane.showMessageDialog(null, "예약이 취소 되었습니다.");
                }
             }
             
          }
          catch(Exception exc){}
      }
      
      else
      {
         MainBoard.board.remove(MainBoard.board_panel);
         MainBoard.board.repaint();
         MainBoard.board.revalidate();
         
         MainBoard.board_panel=this;
         MainBoard.board_panel.setBackground(Color.white);
         MainBoard.board_panel.setBounds(150,40,650,560);
         MainBoard.board.add(MainBoard.board_panel);
      }
   }
   
      private JButton button;
      private static Connection conn;
      private static Statement stmt;
}
