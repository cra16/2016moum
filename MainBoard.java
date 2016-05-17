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

      initialize();
      getContentPane().add(board);
      
      addWindowListener(new WindowAdapter(){
         public void windowClosing(WindowEvent e){
            System.exit(0);
         }
      });
   }
 
   public void initialize()
   {
      board.setBackground(Color.white);

      board.setLayout(null);

      JPanel panel=new JPanel();
      panel.setLayout(null);
      panel.setBounds(200,170,400,300);

      JLabel greet=new JLabel("Welcome to CRA Restaurant!");
      greet.setFont(new Font("Serif", Font.BOLD, 40));
      greet.setBounds(150,70,800,40);

      JLabel userid=new JLabel("User");
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

      JRadioButton stuButton=new JRadioButton("Student", true);
      stuButton.setBounds(25,60,60,13);
      stuButton.setActionCommand("student");
      panel.add(stuButton);
      
      JRadioButton profButton=new JRadioButton("Professor");
      profButton.setActionCommand("prof");
      profButton.setBounds(85,60,80,13);
      panel.add(profButton);

      JRadioButton admButton=new JRadioButton("Administrator");
      admButton.setActionCommand("admin");
      admButton.setBounds(165,60,70,13);
      panel.add(admButton);
  
      outsider=new JButton("outsider");
      outsider.addActionListener(this);
      outsider.setBounds(270,50,85,30);
      panel.add(outsider);
      
      group.add(stuButton);
      group.add(profButton);
      group.add(admButton);

      board.add(panel);
      board.add(greet);
       
   }

   public static void main(String[] args)
   {

     try
     {
        conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "bitnami");
        stmt=conn.createStatement();
     }
     catch(Exception exc){
    	 
     }
     
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
      
    if(((userText.getText().isEmpty())==true)||((pwText.getText()).isEmpty()==true))
    {
       JOptionPane.showMessageDialog(null, "잘못된 입력입니다.");
       userText.setText("");
       pwText.setText("");
       return;
    }
      
     if((group.getSelection().getActionCommand())=="student")
     {
         try{
             stmt.executeUpdate("INSERT INTO stuinfo VALUES('"+userText.getText()+"', '"+pwText.getText()+"', 50000, 1, 3);");
             JOptionPane.showMessageDialog(null, "회원가입 되었습니다.");
             userText.setText("");
             pwText.setText("");       
         }
         catch(Exception exc){}
     }
     
     else if((group.getSelection().getActionCommand())=="prof")
     {
         try{
            
             stmt.executeUpdate("INSERT INTO stuinfo VALUES('"+userText.getText()+"', '"+pwText.getText()+"', 100000, 2, 5);");
             JOptionPane.showMessageDialog(null, "회원가입 되었습니다.");
             userText.setText("");
             pwText.setText("");       
         }
         catch(Exception exc){}
     }
     
     else
         try{
            stmt.executeUpdate("INSERT INTO admin VALUES('"+userText.getText()+"', '"+pwText.getText()+"', 0);");
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
     
     ResultSet re=stmt.executeQuery("SELECT 1 FROM stuinfo WHERE EXISTS(SELECT * FROM stuinfo WHERE stuinfo.id='"+userText.getText()+"' AND stuinfo.password='"+pwText.getText()+"' AND stuinfo.identifier=1);");
     
        if(!(re.next()))
        {
        	
            
        	JOptionPane.showMessageDialog(null, "잘못된 로그인입니다.");
            userText.setText("");
            pwText.setText("");
        }
        else
        {	
        	ResultSet rs = stmt.executeQuery("SELECT * FROM stuinfo");
            
        	while(rs.next()){
        		
        		if(rs.getString("id").equals(userText.getText())){
        			single_Customer = new Student(rs.getString("id"),rs.getString("password"),rs.getInt("point"),rs.getInt("coupon"));
                     	 
        		}
        	}
        	
        
            outsider_board();
           
        }
     }
     catch(Exception exp){
     }
   
   }

   public void prof_board()
   {  
    try
    {
         ResultSet re=stmt.executeQuery("SELECT 1 FROM stuinfo WHERE EXISTS(SELECT * FROM stuinfo WHERE stuinfo.id='"+userText.getText()+"' AND stuinfo.password='"+pwText.getText()+"' AND stuinfo.identifier=2);");
      
         if(!(re.next()))
         {
             JOptionPane.showMessageDialog(null, "잘못된 로그인입니다.");
             userText.setText("");
             pwText.setText("");
         }
         
         else
         {
        	ResultSet rs = stmt.executeQuery("SELECT * FROM stuinfo");
         	while(rs.next()){
         		if(rs.getString("id").equals(userText.getText())){
         			single_Customer = new Professor(rs.getString("id"),rs.getString("password"),rs.getInt("coupon"));
         		}
         	}
            outsider_board();
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
   
    	    ResultSet rs = stmt.executeQuery("SELECT * FROM admin");

    	    while(rs.next()){
       		if(rs.getString("id").equals(userText.getText())){
       			single_Admin = new Admin(rs.getString("id"),rs.getString("password"));
       		}
      		}
         
    	    board.removeAll();
            revalidate();
            repaint();

            board.setLayout(null);

            board_panel=new JPanel();
            board_panel.setBounds(150,30,650,570);
            board_panel.setBackground(Color.white);
            board.add(board_panel);


            JPanel adm_panel=new JPanel();
            adm_panel.setLayout(null);
            adm_panel.setBounds(0,0,170,600);

            JPanel upperBar=new JPanel();
            upperBar.setBounds(170,0,630,40);

            JLabel upperLabel=new JLabel("Welcome! Administrator ID:  "+(userText.getText()));
            upperLabel.setFont(f);
            upperLabel.setBounds(150,10,520,20);
            upperBar.add(upperLabel);
            
            logout=new JButton("logout");
            logout.addActionListener(this);
            logout.setBounds(530,8,70,22);
            upperBar.add(logout);

            board.add(upperBar);

            JButton btn1=new JButton("Menu Management");
            AdminPage temp1 = new AdminPage();
            btn1.addActionListener(temp1);
            btn1.setBounds(0,0,170,140);
            adm_panel.add(btn1);

            JButton btn2=new JButton("Profit Management");
            btn2.setBounds(0,140,170,140);
            adm_panel.add(btn2);

            JButton btn3=new JButton("Customer Management");
            SuperviseCustomerPanel temp3=new SuperviseCustomerPanel();
            btn3.addActionListener(temp3);
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
   
   public void outsider_board()
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
       
       if((((userText.getText()).isEmpty())==true) ||(((pwText.getText()).isEmpty())==true))
      {
    	  JLabel upperLabel=new JLabel("Welcome! Customer: outsider");
          single_Customer= new Student("Outsider","******",-1-1,-1);
         
       
          upperLabel.setFont(f);
          upperLabel.setBounds(190,10,260,20);
          upperBar.add(upperLabel);
      }
          
       else if((group.getSelection().getActionCommand())=="student")
       {
          JLabel upperLabel=new JLabel("Welcome! Customer ID:  "+(userText.getText()));
           upperLabel.setFont(f);
           upperLabel.setBounds(170,10,480,20);
           upperBar.add(upperLabel);
       }
       
       else if((group.getSelection().getActionCommand())=="prof")
       {
          JLabel upperLabel=new JLabel("Welcome! Professor ID:  "+(userText.getText()));
          upperLabel.setFont(f);
          upperLabel.setBounds(170,10,480,20);
          upperBar.add(upperLabel);
       }
          
       logout=new JButton("logout");
       logout.addActionListener(this);
       logout.setBounds(550,8,70,22);
       upperBar.add(logout);
       
       board.add(upperBar);
       
       board_panel=new JPanel();
       board_panel.setBounds(150,30,650,570);
       board_panel.setBackground(Color.white);
       board.add(board_panel);

       JButton btn1=new JButton("Today's Menu");
       StudentPage temp1 = new StudentPage();
       btn1.addActionListener(temp1);
       btn1.setBounds(0,0,150,140);
       stu_panel.add(btn1);

       btn2=new JButton("Making Payment");
       btn2.setBounds(0,140,150,140);
       SelectMenu temp2=new SelectMenu();
       btn2.addActionListener(temp2);
       stu_panel.add(btn2);

       JButton btn3=new JButton("Available Seats");
       btn3.setBounds(0,280,150,140);
       Seat_Check temp3=new Seat_Check();
       btn3.addActionListener(temp3);
       stu_panel.add(btn3);

       JButton btn4=new JButton("My Account");
       btn4.setBounds(0,420,150,140);
       Account temp4=new Account();
       btn4.addActionListener(temp4);
       stu_panel.add(btn4);

       board.add(stu_panel); 
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
         else if((group.getSelection().getActionCommand()=="prof"))
         {
            prof_board();
         }
         else
            admin_board();
     }
     else if(event==registerButton)
     {
        register();
     }
     else if(event==outsider)
     {
        outsider_board();
     }
     else if(event==logout)
     {
        board.removeAll();
        board.revalidate();
        board.repaint();

        group.clearSelection();
        
        initialize();
     }
   }
   public static Customer getInstanceCustomer(){
	   return single_Customer;
   }
   public static Admin getInstanceAdmin(){
	   return single_Admin;
   }
   
   public static JPanel board;
   public static JPanel board_panel;
   private JTextField userText;
   private JPasswordField pwText;
   private JButton loginButton;
   private JButton registerButton;
   private JButton outsider;
   private JButton logout;
   public static JButton btn2;
   private static Connection conn;
   private static Statement stmt;
   
   private static Customer single_Customer;
   private static Admin single_Admin;
   
   private ButtonGroup group=new ButtonGroup();
   private Font f=new Font("Serif", Font.BOLD, 20);
}