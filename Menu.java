package oodp;

import java.util.Random;
import javax.xml.bind.ValidationEvent;
import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
//�޴�����, �޴����� ���� CLASS
class Menu{
	 // �޴��� �׸� ex) ����, ����, �Ͷ�
	 public String menuSection;
	 // �޴��� �� ���� ex) ����-> �ҹ�, ��, ���
	 public String menuList;
	 // �޴��� ���� ex) 3000
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