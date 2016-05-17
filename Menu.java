package oodp;

import java.util.Random;
import javax.xml.bind.ValidationEvent;
import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
//메뉴관리, 메뉴보기 상위 CLASS
class Menu{
	 // 메뉴의 항목 ex) 프프, 코테, 믹라
	 public String menuSection;
	 // 메뉴의 상세 내용 ex) 코테-> 쌀밥, 국, 고기
	 public String menuList;
	 // 메뉴의 가격 ex) 3000
	 public int menuPrice;
	 public int soldNum;
	 public int curNum;
	 // constructor1
	 Menu(){
	
	 }
 
	 Menu(Menu menu){
		 this.menuSection = menu.menuSection;
		 this.menuList = menu.menuList;
		 this.menuPrice = menu.menuPrice;
		 this.soldNum = menu.soldNum;
		 this.curNum = menu.curNum;
	 }
	 // constructor2
	 Menu(String menuSection, String menuList, int menuPrice){
	     this.menuSection = menuSection;
	     this.menuList = menuList;
	     this.menuPrice = menuPrice;
	 }
}