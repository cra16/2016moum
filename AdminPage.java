package oodp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class AdminPage extends JPanel implements ActionListener
{
    JButton makeMenu = new JButton("메뉴 추가");
    JButton deleteMenu = new JButton("메뉴 삭제");
    JButton modifyMenu = new JButton("메뉴 변경");

    Menu[] list = new Menu[10];
    JLabel[] label = new JLabel[10];
    JTextField  text1 = new JTextField(10);
    JTextField  text2 = new JTextField(10);
    JTextField  text3 = new JTextField(10);


    AdminPage()
    {
        Menu.assignClass(list);
        Menu.initialMenu(list);

        setSize(400, 300);

 
        add(makeMenu);
        add(deleteMenu);
        add(modifyMenu);
        add(text1);
        add(text2);
        add(text3);
        for(int i = 0; i < list.length; i++){
            label[i] = new JLabel("");
            add(label[i]);
        }

        makeMenu.addActionListener(this);
        deleteMenu.addActionListener(this);
        modifyMenu.addActionListener(this);
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
        String value1=text1.getText();
        String value2=text2.getText();
        String value3=text3.getText();
        int i;
        int result;
        // 메뉴생성을 할 시
        if(obj == makeMenu){
            for(i = 0; i < list.length; i++){
                if(list[i].menuPrice == 0) {
                    list[i] = Menu_Management.makeMenu(value1,value2,Integer.parseInt(value3));
                    break;
                }
            }
            for(i = 0; i < list.length; i++){
                if(list[i].menuPrice == 0)
                    break;
                label[i].setText(list[i].menuSection+list[i].menuList+list[i].menuPrice+"\n");
            }
            System.out.println("Menu_Manage");

        }

        // 메뉴 삭세를 할 시
        else if(obj == deleteMenu) {
            Menu delete = new Menu();
            delete.menuSection = value1;
            delete.menuList = value2;
            if(value3 != null)
            delete.menuPrice = Integer.parseInt(value3);
            System.out.println(delete.menuSection);
            System.out.println(value3);
            result = Menu_Management.deleteMenu(list,delete);
            for(i = 0; i < list.length;i++){
                label[i].setText("");
            }
            for (i = 0; i < list.length; i++) {
                if (list[i].menuPrice == 0)
                    break;
                label[i].setText(list[i].menuSection + list[i].menuList + list[i].menuPrice + "\n");
            }
            if(result == 0) {
                System.out.println("delete Menu Success");
                JOptionPane.showMessageDialog(this, "해당 내용이 없습니다",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        else if(obj == modifyMenu){
           System.out.println("Customer_Manage");
        }

//        else{
//            System.out.println("enter the valid username and password");
//            JOptionPane.showMessageDialog(this,"Incorrect login or password",
//                    "Error",JOptionPane.ERROR_MESSAGE);
//        }

    }

}

