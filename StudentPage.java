package oodp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


class StudentPage extends JPanel implements ActionListener
{
    JButton generalMenu = new JButton("�Ϲݸ޴� ����");
    JButton recommendMenu = new JButton("��õ�޴� ����");

    Menu[] list = new Menu[10];
    JLabel[] label = new JLabel[10];

    StudentPage()
    {
        Menu.assignClass(list);
        Menu.initialMenu(list);

        setSize(400, 300);


        add(generalMenu);
        add(recommendMenu);
        for(int i = 0; i < list.length; i++){
            label[i] = new JLabel("");
            add(label[i]);
        }

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
            Menu_View.generalMenu(list,label);
            System.out.println("generalMenu");

        }
        // ��õ �޴����⸦ ������ ��
        else if(obj == recommendMenu){
            Menu_View.recommendMenu(list,label);
            System.out.println("recommendMenu");

        }
    }

}

