package oodp;

import java.util.Random;

//�޴�����, �޴����� ���� CLASS
class Menu{
  // �޴��� �׸� ex) ����, ����, �Ͷ�
 public String menuSection;
 // �޴��� �� ���� ex) ����-> �ҹ�, ��, ���
 public String menuList;
 // �޴��� ���� ex) 3000
 public int menuPrice;

 Menu(){

 }
 
 // constructor
 Menu(String menuSection, String menuList, int menuPrice){
     this.menuSection = menuSection;
     this.menuList = menuList;
     this.menuPrice = menuPrice;
 }
 
 //menu list assign
 public static void assignClass(Menu[] list){
     for(int i = 0; i < list.length;i++){
         list[i] = new Menu(null,null,0);
     }
 }
 
 // menu �ʱ� ����
 public static void initialMenu(Menu[] list){
     list[0].menuSection = "Korean Table";
     list[0].menuList = "�ҹ�, ��, ������";
     list[0].menuPrice = 2800;
     list[1].menuSection = "Fry Fry";
     list[1].menuList = "ġ�����";
     list[1].menuPrice = 3500;
     list[2].menuSection = "Grace Garden";
     list[2].menuList = "ġ�����";
     list[2].menuPrice = 18000;
     list[3].menuSection = "Mix Rice";
     list[3].menuList = "�δ��";
     list[3].menuPrice = 3000;
     list[4].menuSection = "Hao";
     list[4].menuList = "�쵿";
     list[4].menuPrice = 2000;
 }
}
