/**
 * 
 */
package course;

import java.util.Scanner;
import java.util.Vector;

/**
 * @author:
 * @date:
 * @class:
 * 
 */
public class Teacher extends User{
	int workId;//����
	String level;//ְ��
	public  Vector<Course> Clist=new Vector();//���ڿγ�
	public Teacher(String name,String pass,int id,String level) {
		this.name=name;
		this.pass=pass;
		this.workId=id;
		this.level=level;
		for(int i=0;i<Courses.clist.size();i++) {
			if(Courses.clist.get(i).teacher.equals(name)) {
				Clist.add(Courses.clist.get(i));
			}
		}
	}
	public void show() {
		System.out.println(workId+" "+name+" "+level);
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
	public  int login() {//��ʦ��½����,�޸ĳ�ʼ����
		System.out.println("���������룺");
		Scanner sc=new Scanner(System.in);
		String pass=sc.next();
		if(pass.equals(this.pass)) {
			System.out.println(workId+":"+name+" "+level+"���!");
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
	public static Teacher add_one() {//���һ����ʦ
		int id=0;
		String name="";
		String pass="";
		String level;
		Scanner sc0=new Scanner(System.in);
		while(true) {
			try {
				System.out.println("�����빤��");
				id=sc0.nextInt();	
				break;
			}catch (Exception e) {
				sc0=new Scanner(System.in);
			}
		}
	
		
		Scanner sc1=new Scanner(System.in);
		while(true) {
			try {
				System.out.println("�������ʦ����");
				name=sc1.next();	
				break;
			}catch(Exception e) {
				sc1=new Scanner(System.in);
			}
		}
		
	
		Scanner sc3=new Scanner(System.in);
		while(true) {
			try {
				System.out.println("������ְ��");
				level=sc3.next();
				break;
			}catch(Exception e) {
				sc3=new Scanner(System.in);
			}
		}
		

		 Teacher t=new Teacher(name,"123456",id,level);
		return t;
		
	}
	public  void teacher_find(){//��ѯ��ʦ���ڿγ�
		String teacher;
		int i;
		System.out.println("�������ʦ����:");
		Scanner sc=new Scanner(System.in);
		teacher=sc.next();
		System.out.println("ѡ�޿α����£�");
		System.out.println("���"+" "+"����"+" "+"����"+" "+"��ʦ"+" "+"�Ͽ�����"+" "+"���ѡ������");
		for(i=0;i<Clist.size();i++) {
			if(Clist.get(i).type==1) {
				Clist.get(i).show();
			}
		}
		System.out.println("���޿α����£�");
		System.out.println("���"+" "+"����"+" "+"����"+" "+"��ʦ"+" "+"�Ͽ�����"+" "+"ѧ��");
		for(i=0;i<Clist.size();i++) {
			if(Clist.get(i).type==0) {
				Clist.get(i).show();
			}
		}
		
		
	}
	public void Stulist() {//�鿴ĳ�����ڿγ��Ͽ�ѧ���б�
		System.out.println("������Ҫ�鿴�Ŀγ̵ı��:");
		Scanner sc=new Scanner(System.in);
		int id=sc.nextInt();
		int i,j;
		for(i=0;i<Clist.size();i++) {
			if(Clist.get(i).id==id) {
				if(Clist.get(i).type==1) {
					System.out.println("���"+" "+"����"+" "+"����"+" "+"��ʦ"+" "+"�Ͽ�����"+" "+"���ѡ������");
					Clist.get(i).show();
					for(j=0;j<Clist.get(i).Slist.size();j++) {
						System.out.println("ѧ��"+" "+"����"+" "+"�༶");
						Clist.get(i).Slist.get(j).show();
					}
				}
				if(Clist.get(i).type==0) {
					System.out.println("���"+" "+"����"+" "+"����"+" "+"��ʦ"+" "+"�Ͽ�����"+" "+"ѧ��");
					Clist.get(i).show();
					for(j=0;j<Clist.get(i).Slist.size();j++) {
						System.out.println("ѧ��"+" "+"����"+" "+"�༶");
						Clist.get(i).Slist.get(j).show();
					}
				}
				
				
			}
		}
		
	}
	public String toString() {
		return super.toString()+" "+this.workId+" "+this.level;
	}
		
		
		
	}

