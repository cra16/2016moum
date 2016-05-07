package oodp;

import java.util.Random;

//메뉴관리, 메뉴보기 상위 CLASS
class Menu{
  // 메뉴의 항목 ex) 프프, 코테, 믹라
 public String menuSection;
 // 메뉴의 상세 내용 ex) 코테-> 쌀밥, 국, 고기
 public String menuList;
 // 메뉴의 가격 ex) 3000
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
 
 // menu 초기 설정
 public static void initialMenu(Menu[] list){
     list[0].menuSection = "Korean Table";
     list[0].menuList = "쌀밥, 국, 탕수육";
     list[0].menuPrice = 2800;
     list[1].menuSection = "Fry Fry";
     list[1].menuList = "치즈돈가스";
     list[1].menuPrice = 3500;
     list[2].menuSection = "Grace Garden";
     list[2].menuList = "치즈찜닭";
     list[2].menuPrice = 18000;
     list[3].menuSection = "Mix Rice";
     list[3].menuList = "부대찌개";
     list[3].menuPrice = 3000;
     list[4].menuSection = "Hao";
     list[4].menuList = "우동";
     list[4].menuPrice = 2000;
 }
}
