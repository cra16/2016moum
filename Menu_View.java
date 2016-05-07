package oodp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

//�޴� ���� CLASS
class Menu_View{

 // function name : generalMenu()
 // function role : �Ϲݸ޴� ����
 // list�� �ִ� ��� �޴��� �����ش�
 public static void generalMenu(Menu list[], JLabel label[]){
     for(int i = 0; i < list.length; i++){
         if(list[i].menuPrice == 0)
             break;
         label[i].setText(list[i].menuSection+list[i].menuList+list[i].menuPrice+"\n");
     }
 }

 // function name : recommendMenu()
 // function role : ��õ�޴� ����
 // random���� ���� �̰� �ش� idx�� �ִ� ������ ����Ѵ�
 // import java.util.Random ���
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

