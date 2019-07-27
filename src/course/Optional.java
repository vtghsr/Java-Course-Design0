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
public class Optional extends Course {
	int maxNum;
	public Optional(int id,String name,int type,String teacher,int num,int maxNum,Vector<Student> Slist) {
		this.id=id;
		this.maxNum=maxNum;
		this.name=name;
		this.num=num;
		this.teacher=teacher;
		this.type=type;
		for(int i=0;i<Slist.size();i++) {
			this.Slist.add(Slist.get(i));
		}
	}
	public void show() {
		System.out.print(id+" "+name+" ");
		System.out.print("ѡ��"+" ");
		System.out.print(teacher+" ");
		System.out.print(num+" ");
		System.out.println(maxNum);
	}
	public int getMaxNum() {
		return maxNum;
	}
	
	public static Course add_one() {
		int id=0;
		String name="";
		String teacher="";
		int num=0;
		int maxNum;
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
		
		Scanner sc5=new Scanner(System.in);
		while(true) {
			try {
				System.out.println("���������ѡ������");
				maxNum=sc5.nextInt();	
				break;
			}catch(Exception e) {
				sc5=new Scanner(System.in);
			}
		}
		 Vector<Student> Slist=new Vector();
		Course c=new Optional(id,name,1,teacher,num,maxNum,Slist);
		return c;
		
	}
	public String toString() {
		return super.toString()+" "+this.maxNum;
	}

}
