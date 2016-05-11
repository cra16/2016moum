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
	 
		 
	 // menu 초기 설정
	 public static void initialMenu(ArrayList<Menu> mMenuList){
		   Connection conn = null;
		   Menu val = new Menu();
		    try
		     {
				Class.forName("com.mysql.jdbc.Driver").newInstance();
		        conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "gksehdeo357");
				if(!conn.isClosed()){
					System.out.println("Successfully connected to MySQL server...");
					Statement s = conn.createStatement();
					s.executeQuery("SELECT *" + "FROM menu");
					ResultSet rs = s.getResultSet();
					while(rs.next()){
						val.menuSection = rs.getString("section");
						val.menuList = rs.getString("list");
						val.menuPrice = rs.getInt("price");
						val.curNum = rs.getInt("cur_num");
						val.soldNum =rs.getInt("sold_num");
						mMenuList.add(new Menu(val));
						
					}
				
					
						
				}
		     }
		     catch(Exception exc)
		    {			System.err.println("Exception: " + exc.getMessage());
		    }
	 }
}