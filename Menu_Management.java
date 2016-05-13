package oodp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;


//메뉴 관리 CLASS
class Menu_Management extends Menu{

 // function name : makeMenu()
 // function role : 메뉴생성
 // 파라미터로 넘어온 정보를 menu에 넣고 return 한다.
 // menu list가 return 값을 받는다.
 public static Menu makeMenu(String section, String list, int price){
     Menu menu = new Menu();
     menu.menuList = list;
     menu.menuPrice = price;
     menu.menuSection = section;
     return menu;
 }

 // function name : deleteMenu()
 // function role : 메뉴삭제
 // delete를 통해 삭제할 값이 넘어온다
 // 해당값이 list에 존재하면 지운다
 public static int deleteMenu(ArrayList<Menu> mMenuList, Menu delete){
     int i;
     int result = 0;
     Menu menu = new Menu();
     
     Iterator<Menu> iter = mMenuList.iterator();
	 i = 0;
	 while (iter.hasNext()) {
		 menu = (Menu)iter.next();
         if(menu.menuList.equals(delete.menuList)&&menu.menuSection.equals(delete.menuSection)&&menu.menuPrice == delete.menuPrice){
        	 mMenuList.remove(i);
    		 result = 1;
    		 break;
         }
         i++;
     }   
 
     return result;
 }
 public void modifyMenu(){

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
