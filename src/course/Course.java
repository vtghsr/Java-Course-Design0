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
public class Course {
	int id;//�γ̱��
	String name;//�γ�����
	int type;//0Ϊ���ޣ�1Ϊѡ��
	String teacher;//��ʦ
	int num;//ѡ������
	public Vector<Student> Slist=new Vector();//���ſε�ѧ���б�
	
	public Course() {//û�в����Ĺ��캯��
	
	}
	public Course(int id,String name,int type,String teacher,int num) {
		this.id=id;
		this.name=name;
		this.type=type;
		this.num=num;
		this.teacher=teacher;
	}
	public int getMaxNum() {
		return 0;
	}
	public int getPoint() {
		return 0;
	}
	public static Course add_one() {
		int id=0;
		String name="";
		int type=2;
		String teacher="";
		int num=0;
		Scanner sc0=new Scanner(System.in);
		while(true) {
			try {
				System.out.println("������γ̱��");
				id=sc0.nextInt();	
				break;
			}catch (Exception e) {
				sc0=new Scanner(System.in);
			}
		}
	
		
		Scanner sc1=new Scanner(System.in);
		while(true) {
			try {
				System.out.println("������γ�����");
				name=sc1.next();	
				break;
			}catch(Exception e) {
				sc1=new Scanner(System.in);
			}
		}
		
		
		Scanner sc2=new Scanner(System.in);
		while(true) {
			try {
				System.out.println("������γ�����");
				type=sc2.nextInt();
				break;
			}catch(Exception e) {
				sc2=new Scanner(System.in);
			}
		}
	
		Scanner sc3=new Scanner(System.in);
		while(true) {
			try {
				System.out.println("������γ̽�ʦ");
				teacher=sc3.next();
				break;
			}catch(Exception e) {
				sc3=new Scanner(System.in);
			}
		}
		
		Scanner sc4=new Scanner(System.in);
		while(true) {
			try {
				System.out.println("������γ�����");
				num=sc4.nextInt();	
				break;
			}catch(Exception e) {
				sc4=new Scanner(System.in);
			}
		}
		Course c=new Course(id,name,type,teacher,num);
		return c;
		
	}
	public int getNum() {
		return num;
	}
	public void show() {//��ʾ�γ���Ϣ
		System.out.print(id+" "+name+" ");
		if(type==0)
			System.out.print("����"+" ");
		else
			System.out.print("ѡ��"+" ");
		System.out.print("��ʦ��"+teacher+" ");
		System.out.println("ѡ������:"+num);
	}
	public String toString() {
		return id+" "+name+" "+type+" "+num+" "+teacher;
	}
	public String toString2(int j) {//��Slistת�����ַ���
		return Slist.get(j).name+" "+Slist.get(j).pass+" "+Slist.get(j).id+" "+Slist.get(j).Class;
		
	}
}
