package oodp;

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
