package oodp;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.applet.*;
import javax.swing.*;


public class SelectMenu extends JPanel implements ActionListener
{

   JButton[] sectionbtn = new JButton[10];

   JButton[] btn = new JButton[50];
   
   
    ArrayList<Menu> list = new ArrayList<Menu>();
    Menu menu = new Menu();
    int item_num=0;
    
    private JFrame frm = new JFrame();

    public SelectMenu()
    {

        this.setSize(400, 300);
        
        int i = 0;
            
       sectionbtn[0]=new JButton("Mix Rice");
        sectionbtn[1]=new JButton("Korean Table");
        sectionbtn[2]=new JButton("Fry Fry");
        sectionbtn[3]=new JButton("Grace Garden");
        sectionbtn[4]=new JButton("Hao");
        sectionbtn[5]=new JButton("Noodle road");

        
        Menu_Management.initialMenu(list);
        Iterator<Menu> iter = list.iterator();
               
        //menuSection별 출력
        add(new JLabel("Mix Rice\n"));
        
        while (iter.hasNext()) {
             menu = (Menu)iter.next();
             
            
             if(menu.menuSection.equalsIgnoreCase("Mix Rice"))
             {            
                btn[i]=new JButton(menu.menuList);
                add(btn[i]);
                i++;
             }
             
        }
        add(new JLabel("\n\n"));
        iter = list.iterator();
        

        add(new JLabel("Korean Table\n"));
        while (iter.hasNext()) {
             menu = (Menu)iter.next();
            
             if(menu.menuSection.equalsIgnoreCase("Korean Table"))
             {
                btn[i]=new JButton(menu.menuList);
                add(btn[i]);
                i++;
             }
        }
        add(new JLabel("\n\n"));
        
        iter = list.iterator();
        
        add(new JLabel("Fry Fry\n"));
        while (iter.hasNext()) {
             menu = (Menu)iter.next();
            
             if(menu.menuSection.equalsIgnoreCase("Fry Fry"))
             {
               btn[i]=new JButton(menu.menuList);
                add(btn[i]);
                i++;
             }
        }
        add(new JLabel("\n\n"));
        iter = list.iterator();
        
        add(new JLabel("Grace Garden\n"));
        while (iter.hasNext()) {
             menu = (Menu)iter.next();
             if(menu.menuSection.equalsIgnoreCase("Grace Garden"))
             {
                btn[i]=new JButton(menu.menuList);
                add(btn[i]);
                i++;
             }
        }
        add(new JLabel("\n\n"));
        iter = list.iterator();
        
        add(new JLabel("Hao\n"));
        while (iter.hasNext()) {
             menu = (Menu)iter.next();
             if(menu.menuSection.equalsIgnoreCase("Hao"))
             {
               btn[i]=new JButton(menu.menuList);
                add(btn[i]);
                i++;

             }
        }
        add(new JLabel("\n\n"));
        iter = list.iterator();
        
        add(new JLabel("Noodle road\n"));
        while (iter.hasNext()) {
             menu = (Menu)iter.next();
             if(menu.menuSection.equalsIgnoreCase("Noodle road"))
             {
               btn[i]=new JButton(menu.menuList);
                add(btn[i]);
                i++;
             }
            
        }

         
         //button 누르면 cash, coupon, point 선택 창 띄우기
         
        
        item_num= i--;
        
        while (i>=0) {
                btn[i].addActionListener(this); 
                
             i--;
       
         }
       

         
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
      
      MainBoard.board.remove(MainBoard.board_panel);
      MainBoard.board.repaint();
      MainBoard.board.revalidate();
      
      MainBoard.board_panel=this;
      MainBoard.board_panel.setBackground(Color.white);
      MainBoard.board_panel.setBounds(150,40,650,560);
      MainBoard.board.add(MainBoard.board_panel);

      Iterator<Menu> check = null;
      check=list.iterator();
      
      int i=0;
    
      Payment pay_with = new Payment();
       
      while (check.hasNext())
      {
       
            if(e.getSource().equals(btn[i]))
            {
               
               Object[] options = {"포인트 결제", "현장 결제", "쿠폰 결제"};
                int selectedNum = JOptionPane.showOptionDialog(frm, "결제 수단을 선택하여 주세요.", "결제 수단", 
                        JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                
                Iterator<Menu> iter = list.iterator();
            
                
                while (iter.hasNext()) {
                   menu = (Menu)iter.next();
                    
                   if(menu.menuList==btn[i].getText())
                  {
                      if(selectedNum==0)//포인트
                      {
                          pay_with.Pay_Point(menu);
                      }
                      else if(selectedNum==1)//현장
                      {
                         //Payment.Pay_Cash();
                          JOptionPane.showMessageDialog(null, "cash");
                      }
                      else if(selectedNum==2)//쿠폰
                      {
                         //Payment.Pay_Coupon();
                          JOptionPane.showMessageDialog(null, "coupon");
                      }
                   
                    }
                    
                   
               }; 
           
            }
            i++;
            
        }
        
        
       
    }

}