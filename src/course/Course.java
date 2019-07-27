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
	int id;//课程编号
	String name;//课程名称
	int type;//0为必修，1为选修
	String teacher;//教师
	int num;//选课人数
	public Vector<Student> Slist=new Vector();//这门课的学生列表
	
	public Course() {//没有参数的构造函数
	
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
		
		
		Scanner sc2=new Scanner(System.in);
		while(true) {
			try {
				System.out.println("请输入课程类型");
				type=sc2.nextInt();
				break;
			}catch(Exception e) {
				sc2=new Scanner(System.in);
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
		Course c=new Course(id,name,type,teacher,num);
		return c;
		
	}
	public int getNum() {
		return num;
	}
	public void show() {//显示课程信息
		System.out.print(id+" "+name+" ");
		if(type==0)
			System.out.print("必修"+" ");
		else
			System.out.print("选修"+" ");
		System.out.print("教师："+teacher+" ");
		System.out.println("选课人数:"+num);
	}
	public String toString() {
		return id+" "+name+" "+type+" "+num+" "+teacher;
	}
	public String toString2(int j) {//将Slist转换成字符串
		return Slist.get(j).name+" "+Slist.get(j).pass+" "+Slist.get(j).id+" "+Slist.get(j).Class;
		
	}
}
