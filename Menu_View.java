package oodp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

//메뉴 보기 CLASS
class Menu_View{

 // function name : generalMenu()
 // function role : 일반메뉴 보기
 // list에 있는 모든 메뉴를 보여준다
 public static void generalMenu(ArrayList<Menu> mMenuList, ArrayList<JLabel> mJLabelList){
		Iterator<Menu> iter = mMenuList.iterator();
		Menu menu = new Menu();
		int i = 0;
		while (iter.hasNext()) {
	         menu = (Menu)iter.next();
	         mJLabelList.get(i++).setText(menu.menuSection+menu.menuList+menu.menuPrice+"\n");
	    }		
 }

 // function name : recommendMenu()
 // function role : 추천메뉴 보기
 // random으로 값을 뽑고 해당 idx에 있는 정보를 출력한다
 // import java.util.Random 사용
 public static void recommendMenu(ArrayList<Menu> mMenuList, ArrayList<JLabel> mJLabelList){
     int i;
     int randomNum;
     Random random = new Random();
		Iterator<Menu> iter = mMenuList.iterator();
		i = 0;
		while (iter.hasNext()) {
	        Menu string = (Menu)iter.next();
	        mJLabelList.add(new JLabel(""));
	    }

         randomNum = random.nextInt(mMenuList.size()-1);
         Menu menu = new Menu();
         menu = mMenuList.get(randomNum);
         mJLabelList.get(randomNum).setText(menu.menuSection+menu.menuList+menu.menuPrice+"\n");   

 }
}

