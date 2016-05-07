package oodp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class MainBoard extends JFrame implements ActionListener
{
   public MainBoard()
   {
      setTitle("Main Board");

      board=new JPanel();

      board.setBackground(Color.white);

      board.setLayout(null);

      JPanel panel=new JPanel();
      panel.setLayout(null);
      panel.setBounds(200,170,400,300);

      JLabel greet=new JLabel("Welcome to HGU Restaurant!");
      greet.setFont(new Font("Serif", Font.BOLD, 40));
      greet.setBounds(150,70,800,40);



      JLabel userid=new JLabel("ID");
      userid.setFont(f);
      userid.setBounds(40,110,200,20);
      panel.add(userid);

      userText=new JTextField(250);
      userText.setBounds(140,105,200,30);
      panel.add(userText);

      JLabel pwlabel=new JLabel("Password");
      pwlabel.setFont(f);
      pwlabel.setBounds(40,170,200,20);
      panel.add(pwlabel);

      pwText=new JPasswordField(250);
      pwText.setBounds(140,165,200,30);
      panel.add(pwText);

      loginButton=new JButton("login");
      loginButton.setBounds(60,230,100,30);
      loginButton.addActionListener(this);
      panel.add(loginButton);

      registerButton=new JButton("register");
      registerButton.setBounds(240,230,100,30);
      registerButton.addActionListener(this);
      panel.add(registerButton);

      JRadioButton stuButton=new JRadioButton("Student",true);
      stuButton.setBounds(140,60,80,13);
      stuButton.setActionCommand("student");
      panel.add(stuButton);

      JRadioButton admButton=new JRadioButton("Administrator");
      admButton.setActionCommand("admin");
      admButton.setBounds(230,60,130,13);
      panel.add(admButton);
  

      
      group.add(stuButton);
      group.add(admButton);

      board.add(panel);
      board.add(greet);
      getContentPane().add(board);



      addWindowListener(new WindowAdapter(){
         public void windowClosing(WindowEvent e){
            System.exit(0);
         }
      });
   }

   public static void main(String[] args)
   {

     try
     {
        conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "bitnami");
        stmt=conn.createStatement();
     }
     catch(Exception exc){}
     
     int width=800;

      int height=600;

      JFrame frame=new MainBoard();

      frame.setSize(width, height);

      Dimension screenSize=java.awt.Toolkit.getDefaultToolkit().getScreenSize();

      frame.setLocation(screenSize.width/2 - width/2, screenSize.height/2 - height/2);

      frame.show();
   }

   public void register()
   {
     if((group.getSelection().getActionCommand())=="student")
     {
      try{
         
      //conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "298383");
      //stmt=conn.createStatement();

       stmt.executeUpdate("INSERT INTO stuinfo VALUES('"+userText.getText()+"', '"+pwText.getText()+"');");
       JOptionPane.showMessageDialog(null, "회원가입 되었습니다.");
        userText.setText("");
        pwText.setText("");       
      }
      catch(Exception exc){}
     }
     else
      try{
      stmt.executeUpdate("INSERT INTO admin VALUES('"+userText.getText()+"', '"+pwText.getText()+"');");
       JOptionPane.showMessageDialog(null, "회원가입 되었습니다.");
        userText.setText("");
        pwText.setText("");       
      }
       catch(Exception exc){}
   }
   
   public void stu_board()
   {
     try
     {
     ResultSet re=stmt.executeQuery("SELECT 1 FROM stuinfo WHERE EXISTS(SELECT * FROM stuinfo WHERE stuinfo.id='"+userText.getText()+"' AND stuinfo.password='"+pwText.getText()+"');");
     
        if(!(re.next()))
        {
            JOptionPane.showMessageDialog(null, "잘못된 로그인입니다.");
            userText.setText("");
            pwText.setText("");
        }
        
        else
        {
         board.removeAll();
         revalidate();
         repaint();

         board.setLayout(null);

         JPanel stu_panel=new JPanel();
         stu_panel.setLayout(null);
         stu_panel.setBounds(0,0,150,600);

         JPanel upperBar=new JPanel();
         upperBar.setBounds(150,0,650,40);

         
         JLabel upperLabel=new JLabel("Welcome! Customer ID:  "+(userText.getText()));
         upperLabel.setFont(f);
         upperLabel.setBounds(170,10,480,20);
         upperBar.add(upperLabel);

         board.add(upperBar);
         
         board_panel=new JPanel();
         board_panel.setBounds(150,30,650,570);
         board_panel.setBackground(Color.white);
         board.add(board_panel);

         JButton btn1=new JButton("Today's Menu");
         btn1.setBounds(0,0,150,140);
         StudentPage temp1=new StudentPage();
         btn1.addActionListener(temp1);
         stu_panel.add(btn1);

         JButton btn2=new JButton("Making Payment");
         btn2.setBounds(0,140,150,140);
         SelectMenu temp2=new SelectMenu();
         btn2.addActionListener(temp2);
         stu_panel.add(btn2);

         JButton btn3=new JButton("Available Seats");
         btn3.setBounds(0,280,150,140);
         stu_panel.add(btn3);

         JButton btn4=new JButton("My Account");
         btn4.setBounds(0,420,150,140);
         Account temp4=new Account();
         btn4.addActionListener(temp4);
         stu_panel.add(btn4);


         board.add(stu_panel);
        }
     }
     catch(Exception exp){}
   
   }

   public void admin_board()
   {
      
     try
     {
      ResultSet re=stmt.executeQuery("SELECT 1 FROM admin WHERE EXISTS(SELECT * FROM admin WHERE admin.id='"+userText.getText()+"' AND admin.password='"+pwText.getText()+"');");
        
      if(!(re.next()))
      {
         JOptionPane.showMessageDialog(null, "잘못된 로그인입니다.");
          userText.setText("");
          pwText.setText("");         
      }
      else
      {
            board.removeAll();
            revalidate();
            repaint();

            board.setLayout(null);

            JPanel adm_panel=new JPanel();
            adm_panel.setLayout(null);
            adm_panel.setBounds(0,0,170,600);

            JPanel upperBar=new JPanel();
            upperBar.setBounds(170,0,650,40);

            JLabel upperLabel=new JLabel("Welcome! Administrator ID:  "+(userText.getText()));
            upperLabel.setFont(f);
            upperLabel.setBounds(170,10,480,20);
            upperBar.add(upperLabel);

            board.add(upperBar);
            
            board_panel=new JPanel();
            board_panel.setBounds(170,30,630,570);
            board_panel.setBackground(Color.white);
            board.add(board_panel);

            JButton btn1=new JButton("Menu Management");
            btn1.setBounds(0,0,170,140);
            AdminPage temp1=new AdminPage();
            btn1.addActionListener(temp1);
            adm_panel.add(btn1);

            JButton btn2=new JButton("Profit Management");
            btn2.setBounds(0,140,170,140);
            adm_panel.add(btn2);

            JButton btn3=new JButton("Customer Management");
            SuperviseCustomer temp4=new SuperviseCustomer();
            btn3.addActionListener(temp4);
            btn3.setBounds(0,280,170,140);
            adm_panel.add(btn3);

            JButton btn4=new JButton("Inventory Management");
            btn4.setBounds(0,420,170,140);
            adm_panel.add(btn4);   
            
            board.add(adm_panel);
      }
     }
     catch(Exception exp){}
        
   }
   
   public void actionPerformed(ActionEvent e)
   {
     Object event=e.getSource();
     
     if(event==loginButton)
     {
      
         if((group.getSelection().getActionCommand())=="student")
         {
            stu_board();
         }
         else
            admin_board();
     }
     else if(event==registerButton)
     {
        register();
     }
   }

   public static JPanel board;
   public static JPanel board_panel;
   private JTextField userText;
   private JPasswordField pwText;
   private JButton loginButton;
   private JButton registerButton;
   private static Connection conn;
   private static Statement stmt;

   private ButtonGroup group=new ButtonGroup();
   private Font f=new Font("Serif", Font.BOLD, 20);
}