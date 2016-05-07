package oodp;

import javax.swing.*;

public class Student{

    public Student(int student_id, String password, String student_name){
        this.student_id=student_id;
        this.password=password;
        this.student_name=student_name;
        point=10000;
        use_point=false;
    }


    public int student_id;
    public String password;
    public String student_name;
    public boolean use_point;
    public int point;
    public char sex;
    public String phone_number;



    public void PaymentPoint(Menu selected){
        //결제 회원(Student)의 정보와, 결제하고자 하는 물품의 정보를 받아옴

        if(use_point==true) {//포인트 이용

            if (point >= selected.menuPrice)
            {
                point-=selected.menuPrice;

                Sales_Management(selected);

            }else{

                //포인트 부족
                JOptionPane.showMessageDialog(null, "포인트가 부족합니다.");

            }

        }else{      //포인트 이용 X

            //포인트를 이용할 수 없습니다.
            JOptionPane.showMessageDialog(null, "포인트를 이용하고 있지 않습니다.");

        }

    }
    public int getPoint(){
    	return this.point;
    }
    public void setPoint(int point){
    	this.point = point;
    	this.use_point = true;
    }
    public boolean pointStatus(){
    	return this.use_point;
    }


    public void Sales_Management(Menu selected){
        //매출 관리
        salesAmount+=selected.menuPrice;


    }

    int salesAmount=0;


}