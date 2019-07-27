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
public class Compusary extends Course{
	int point;//学分
	public Compusary(int id,String name,int type,String teacher,int num,int point,Vector<Student> Slist) {
		this.id=id;
		this.point=point;
		this.name=name;
		this.num=num;
		this.teacher=teacher;
		this.type=type;
		for(int i=0;i<Slist.size();i++) {
			this.Slist.add(Slist.get(i));
		}
		
	}
	public int getPoint() {
		return point;
	}
	public void show() {
		System.out.print(id+" "+name+" ");
		System.out.print("必修"+" ");
		System.out.print(teacher+" ");
		System.out.print(num+" ");
		System.out.println(point);
	}
	
	public static Course add_one() {
		int id=0;
		String name="";
		String teacher="";
		int num=0;
		int point;
		Scanner sc0=new Scanner(System.in);
		while(true) {
			try {
				System.out.println("请输入课程编号");
				id=sc0.nextInt();	
				break;
			}catch (Exception e) {
				sc0=new Scanner(System.in);
			}
		}
	
		
		Scanner sc1=new Scanner(System.in);
		while(true) {
			try {
				System.out.println("请输入课程名称");
				name=sc1.next();	
				break;
			}catch(Exception e) {
				sc1=new Scanner(System.in);
			}
		}
		
	
		Scanner sc3=new Scanner(System.in);
		while(true) {
			try {
				System.out.println("请输入课程教师");
				teacher=sc3.next();
				break;
			}catch(Exception e) {
				sc3=new Scanner(System.in);
			}
		}
		
		Scanner sc4=new Scanner(System.in);
		while(true) {
			try {
				System.out.println("请输入课程人数");
				num=sc4.nextInt();	
				break;
			}catch(Exception e) {
				sc4=new Scanner(System.in);
			}
		}
		
		Scanner sc5=new Scanner(System.in);
		while(true) {
			try {
				System.out.println("请输入学分");
				point=sc5.nextInt();	
				break;
			}catch(Exception e) {
				sc5=new Scanner(System.in);
			}
		}
		 Vector<Student> Slist=new Vector();
		Course c=new Compusary(id,name,0,teacher,num,point,Slist);
		
		return c;
		
	}
	public String toString() {
		return super.toString()+" "+this.point;
	}

}
