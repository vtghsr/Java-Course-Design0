/**
 * 
 */
package course;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

/**
 * @author:
 * @date:
 * @class:
 * 
 */
public class Student extends User {
	int id;//ѧ��
	String Class;//�༶
	public  Vector<Course> Clist=new Vector();//��ѧ���α�
	public Student(String name,String pass,int id,String Class) {
		this.name=name;
		this.pass=pass;
		this.id=id;
		this.Class=Class;
		for(int i=0;i<Courses.clist.size();i++) {//����ѧ���Ŀμ�����α���
			if(Courses.clist.get(i).type==0) {
				Clist.add(Courses.clist.get(i));
			}
			else {
				for(int j=0;j<Courses.clist.get(i).Slist.size();j++) {
					if(Courses.clist.get(i).Slist.get(j).id==id) {
						Clist.add(Courses.clist.get(i));
					}
				}
			}
		}
		
	}
	public void setPassWord() {//�޸�����
		Scanner sc=new Scanner(System.in);
		while(true) {
			System.out.println("������������(6λ)");
			String xpass1=sc.next();
			System.out.println("���ٴ�����������(6λ)");
			String xpass2=sc.next();
			if(xpass1.equals(xpass2)&&xpass1.length()==6) {
				this.pass=xpass1;
				break;
			}else {
				if(xpass1.equals(xpass2)) {
					System.out.println("�����6λ�����������룡");
				}
				else
				System.out.println("�������벻һ�£�");
				continue;
			}
		}
		
	}
	public static Student add_one() {//���һ��ѧ��
		int id=0;
		String name="";
		String pass="";
		String Class="";
		Scanner sc0=new Scanner(System.in);
		while(true) {
			try {
				System.out.println("������ѧ��");
				id=sc0.nextInt();	
				break;
			}catch (Exception e) {
				sc0=new Scanner(System.in);
			}
		}
	
		
		Scanner sc1=new Scanner(System.in);
		while(true) {
			try {
				System.out.println("������ѧ������");
				name=sc1.next();	
				break;
			}catch(Exception e) {
				sc1=new Scanner(System.in);
			}
		}
		
	
		Scanner sc3=new Scanner(System.in);
		while(true) {
			try {
				System.out.println("������ѧ�����ڰ༶");
				Class=sc3.next();
				break;
			}catch(Exception e) {
				sc3=new Scanner(System.in);
			}
		}
		

		Student s=new Student(name,"123456",id,Class);
		return s;
		
	}
	public void show() {
		System.out.println(id+" "+name+" "+Class);
	}
	public int login() {	//ѧ����½����
		Scanner sc=new Scanner(System.in);
		System.out.println("���������룺");
		String pass=sc.next();
		if(pass.equals(this.pass)) {
			System.out.println(Class+" "+name+" "+"���!");
			if(pass.equals("123456")) {
				System.out.println("��Ҫ�޸ĳ�ʼ��������Ҫ�밴1");
				int a=sc.nextInt();
				if(a==1) {
					this.setPassWord();
				}
			}
	
			return 1;
		}
		else
		{
			System.out.println("���벻��ȷ��");
			return 0;
		}
	}
	public void SleCourse() {//ѡ��
		System.out.println("ѡ�޿��б�����:");
		Courses.showOpt();
		System.out.println("������Ҫѡ�γ̵ı�ţ�");
		Scanner sc=new Scanner(System.in);
		int id=sc.nextInt();
		for(int i=0;i<Courses.clist.size();i++) {
			if(Courses.clist.get(i).id==id)
			{//�ҵ�Ҫѡ�Ŀ���
				if(Courses.clist.get(i).num<Courses.clist.get(i).getMaxNum()) {
					//��δѡ��
					Courses.clist.get(i).Slist.add(this);
					Clist.add(Courses.clist.get(i));
					System.out.println("ѡ�γɹ���");
				}
				else
				{
					System.out.println("�ÿγ���ѡ����ѡ��ʧ�ܣ�");
				}
					
			}
			
		}
		
	}
	public void StuSyllabus() {//�鿴�Լ����Ͽγ�
		int i;
		System.out.println("ѡ�޿α�����:");
		System.out.println("���"+" "+"����"+" "+"����"+" "+"��ʦ"+" "+"�Ͽ�����"+" "+"���ѡ������");
		for(i=0;i<Clist.size();i++) {
			if(Clist.get(i).type==1)
			Clist.get(i).show();
		}
		System.out.println("���޿α�����:");
		System.out.println("���"+" "+"����"+" "+"����"+" "+"��ʦ"+" "+"�Ͽ�����"+" "+"ѧ��");
		for(i=0;i<Clist.size();i++) {
			if(Clist.get(i).type==0)
			Clist.get(i).show();
		}
	}
	public String toString() {
		return super.toString()+" "+this.id+" "+this.Class;
	}
	
}
