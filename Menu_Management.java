package oodp;

import java.util.ArrayList;
import java.util.Iterator;


//�޴� ���� CLASS
class Menu_Management extends Menu{

 // function name : makeMenu()
 // function role : �޴�����
 // �Ķ���ͷ� �Ѿ�� ������ menu�� �ְ� return �Ѵ�.
 // menu list�� return ���� �޴´�.
 public static Menu makeMenu(String section, String list, int price){
     Menu menu = new Menu();
     menu.menuList = list;
     menu.menuPrice = price;
     menu.menuSection = section;
     return menu;
 }

 // function name : deleteMenu()
 // function role : �޴�����
 // delete�� ���� ������ ���� �Ѿ�´�
 // �ش簪�� list�� �����ϸ� �����
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
}
