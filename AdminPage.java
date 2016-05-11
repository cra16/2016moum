package oodp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Iterator;

class AdminPage extends JPanel implements ActionListener
{
    JButton makeMenu = new JButton("메뉴 추가");
    JButton deleteMenu = new JButton("메뉴 삭제");
    JButton modifyMenu = new JButton("메뉴 변경");

    ArrayList<Menu> mMenuList = new ArrayList<Menu>();
    ArrayList<JLabel> mJLabelList = new ArrayList<JLabel>();
    JTextField  text1 = new JTextField(10);
    JTextField  text2 = new JTextField(10);
    JTextField  text3 = new JTextField(10);


    AdminPage()
    {
        Menu.initialMenu(mMenuList);

        setSize(400, 300);

 
        add(makeMenu);
        add(deleteMenu);
        add(modifyMenu);
        add(text1);
        add(text2);
        add(text3);
   
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
        Menu menu;
        int i;
        int result;
        // 메뉴생성을 할 시
        if(obj == makeMenu){
        	mMenuList.add(Menu_Management.makeMenu(value1,value2,Integer.parseInt(value3)));
			Iterator<Menu> iter = mMenuList.iterator();
			i = 0;
			while (iter.hasNext()) {
		        Menu string = (Menu)iter.next();
		        mJLabelList.add(new JLabel(""));
                add(mJLabelList.get(i++));
		    }

			Iterator<Menu> iter2 = mMenuList.iterator();
			i = 0;
			while (iter2.hasNext()) {
		         menu = (Menu)iter2.next();
              mJLabelList.get(i++).setText(menu.menuSection+menu.menuList+menu.menuPrice+"\n");

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
            System.out.println("Sdfsdff"+value3);
            result = Menu_Management.deleteMenu(mMenuList ,delete);

			Iterator<Menu> iter = mMenuList.iterator();
			i = 0;
			while (iter.hasNext()) {
		        Menu string = (Menu)iter.next();
		        mJLabelList.add(new JLabel(""));
                add(mJLabelList.get(i++));
		    }

			Iterator<Menu> iter2 = mMenuList.iterator();
			i = 0;
			while (iter2.hasNext()) {
		         menu = (Menu)iter2.next();
              mJLabelList.get(i++).setText(menu.menuSection+menu.menuList+menu.menuPrice+"\n");

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

