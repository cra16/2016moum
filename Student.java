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
        //���� ȸ��(Student)�� ������, �����ϰ��� �ϴ� ��ǰ�� ������ �޾ƿ�

        if(use_point==true) {//����Ʈ �̿�

            if (point >= selected.menuPrice)
            {
                point-=selected.menuPrice;

                Sales_Management(selected);

            }else{

                //����Ʈ ����
                JOptionPane.showMessageDialog(null, "����Ʈ�� �����մϴ�.");

            }

        }else{      //����Ʈ �̿� X

            //����Ʈ�� �̿��� �� �����ϴ�.
            JOptionPane.showMessageDialog(null, "����Ʈ�� �̿��ϰ� ���� �ʽ��ϴ�.");

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
        //���� ����
        salesAmount+=selected.menuPrice;


    }

    int salesAmount=0;


}