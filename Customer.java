package oodp;

public class Customer {

	public Student[] students;
	private int number_of_student;
	private int max_number;
	
	public Customer(){
		students = new Student[10];
		number_of_student = 0;
		max_number = 10;
		this.dummyInfo();
	}
	public Customer(int size){
		this.students = new Student[size];
		number_of_student = 0;
		max_number = size;
	}
	
	
	public int getNumberOfStudent(){ //���� �л��� ��ȯ
		return this.number_of_student;
	}
	// �̸��� ��й�ȣ�� �й��� ��Ϲ޾� ���ο� �л��� ���
	public int registCustomer(int student_id, String password, String student_name){
		if(number_of_student == max_number)
			return -1;
		students[number_of_student] = new Student(student_id,password,student_name);
		number_of_student++;
		
		return 1;
	}
	//�̸��� ��й�ȣ�� �л� ���� ����
	public int deleteCustomer(int student_id, String password){
		int i;
		for(i=0;i<number_of_student;i++){
			if(students[i].student_id == student_id){
				if(students[i].password.equals(password)){
					if(i==number_of_student-1){
						number_of_student--;
						return 1;
					}
					for(;i<number_of_student-1;i++){
						students[i] = students[i+1];
					}
					number_of_student--;
					return 1;
				}
				else
					return -1; //wrong password
					
			}
		}
		return -1; // No result
	}
	public int checkPoint(int student_id){//�й����� ���� ����Ʈ ��ȯ
		int i;
		for(i=0;i<number_of_student;i++){
			if(students[i].student_id == student_id){
				if(students[i].use_point==false)
					return -1; // not using point
				
				return students[i].point;
			}
		}
		
		return -1; // no student
	}
	public int rechargePoint(int student_id,int point){ //����Ʈ ����
		int i;
		for(i=0;i<number_of_student;i++){
			if(students[i].student_id == student_id){
				if(students[i].use_point==false)
					students[i].use_point=true;
				
				students[i].point += point;
				
				return students[i].point;
			}
		}
		
		return -1; // No result
	}
	private void dummyInfo(){
		int i;
		String[] name = {"kyunwon", "sekye","dongyoung","sinhae", "hyunwo","enbi","minsu","Hyein","dasol","yongjun"};
		
		for(i=0;i<10;i++){
			this.registCustomer(20000+i, "password",name[i] );
		}
		
		return;
	}


}
