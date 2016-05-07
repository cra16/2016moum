package oodp;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SelectMenu extends JPanel implements ActionListener
{
    //
    Menu[] list = new Menu[10];

    JButton[] btn = new JButton[10];


    public SelectMenu()
    {
        Menu.assignClass(this.list);
        Menu.initialMenu(this.list);

        this.setSize(400, 300);

        for(int i = 0; i < this.list.length; ++i) {

            btn[i]=new JButton(this.list[i].menuList);
            add(btn[i]);

        }


        for(int i = 0; i < this.list.length; ++i) {
            btn[i].addActionListener(this);
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
      
        for(int i=0 ; i<this.list.length ; ++i)
        {
            if(e.getSource().equals(btn[i]))
            {
                name.PaymentPoint(this.list[i]);
            }
        }
        
    }



    Student name = new Student(1,"bbb","aa");

    Menu menu1 = new Menu("k","a",10);

    Menu menu2 = new Menu("m","b",20);


}