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
	 
		 
	 // menu �ʱ� ����
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