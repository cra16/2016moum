package oodp;

import javax.swing.*;

import oodp.copy2.Menu;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;


class StudentPage extends JPanel implements ActionListener
{
    JButton generalMenu = new JButton("�Ϲݸ޴� ����");
    JButton recommendMenu = new JButton("��õ�޴� ����");

    ArrayList<Menu> mMenuList = new ArrayList<Menu>();
    ArrayList<JLabel> mJLabelList = new ArrayList<JLabel>();

    StudentPage()
    {
        Menu_Management.initialMenu(mMenuList);

        setSize(400, 300);


        add(generalMenu);
        add(recommendMenu);
      

        generalMenu.addActionListener(this);
        recommendMenu.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e)
    {
    	  MainBoard.board.remove(MainBoard.board_panel);
	      MainBoard.board.repaint();
	      MainBoard.board.revalidate();
	      
	      MainBoard.board_panel=this;
	      MainBoard.board_panel.setBackground(Color.white);
	      MainBoard.board_panel.setBounds(150,40,650,560);
	      MainBoard.board.add(MainBoard.board_panel);
    	
        Object obj = e.getSource();
        // �Ϲ� �޴����⸦ ������ ��
        if(obj == generalMenu){
            Menu_View.generalMenu(mMenuList,mJLabelList);
            System.out.println("generalMenu");

        }
        // ��õ �޴����⸦ ������ ��
        else if(obj == recommendMenu){
            Menu_View.recommendMenu(mMenuList,mJLabelList);
            System.out.println("recommendMenu");

        }
    }

}

