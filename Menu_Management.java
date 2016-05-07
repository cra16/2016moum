package oodp;

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
 public static int deleteMenu(Menu[] list, Menu delete){
     int i;
     int result = 0;
     for(i = 0; i < list.length; i++)
     {
         if(list[i].menuPrice == 0){
         return result;
         }
         if((list[i].menuSection.equals(delete.menuSection)) && (list[i].menuList.equals(delete.menuList)) &&
                 (list[i].menuPrice == delete.menuPrice)) {
             result = 1;
             break;
         }

     }
     for(; i < list.length;i++)
     {
         if(i == list.length - 1) {
             list[i].menuSection = null;
             list[i].menuList = null;
             list[i].menuPrice =0;
         }
         else{
             list[i].menuSection = list[i+1].menuSection;
             list[i].menuList = list[i+1].menuList;
             list[i].menuPrice = list[i+1].menuPrice;
         }
     }
     return result;
 }
 public void modifyMenu(){

 }
}
