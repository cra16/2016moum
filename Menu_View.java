package oodp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

//메뉴 보기 CLASS
class Menu_View{

 // function name : generalMenu()
 // function role : 일반메뉴 보기
 // list에 있는 모든 메뉴를 보여준다
 public static void generalMenu(Menu list[], JLabel label[]){
     for(int i = 0; i < list.length; i++){
         if(list[i].menuPrice == 0)
             break;
         label[i].setText(list[i].menuSection+list[i].menuList+list[i].menuPrice+"\n");
     }
 }

 // function name : recommendMenu()
 // function role : 추천메뉴 보기
 // random으로 값을 뽑고 해당 idx에 있는 정보를 출력한다
 // import java.util.Random 사용
 public static void recommendMenu(Menu list[], JLabel label[]){
     int i;
     int randomNum;
     Random random = new Random();
     for(i = 0; i < list.length;i++){
         label[i].setText("");
     }

     while(true){
         randomNum = random.nextInt(9);
         if(list[randomNum].menuPrice != 0){
             label[randomNum].setText(list[randomNum].menuSection+list[randomNum].menuList+list[randomNum].menuPrice+"\n");
             break;
         }

     }

 }
}

