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
	int id;//学号
	String Class;//班级
	public  Vector<Course> Clist=new Vector();//该学生课表
	public Student(String name,String pass,int id,String Class) {
		this.name=name;
		this.pass=pass;
		this.id=id;
		this.Class=Class;
		for(int i=0;i<Courses.clist.size();i++) {//将该学生的课加入其课表中
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
	public void setPassWord() {//修改密码
		Scanner sc=new Scanner(System.in);
		while(true) {
			System.out.println("请输入新密码(6位)");
			String xpass1=sc.next();
			System.out.println("请再次输入新密码(6位)");
			String xpass2=sc.next();
			if(xpass1.equals(xpass2)&&xpass1.length()==6) {
				this.pass=xpass1;
				break;
			}else {
				if(xpass1.equals(xpass2)) {
					System.out.println("密码非6位，请重新输入！");
				}
				else
				System.out.println("两次输入不一致！");
				continue;
			}
		}
		
	}
	public static Student add_one() {//添加一个学生
		int id=0;
		String name="";
		String pass="";
		String Class="";
		Scanner sc0=new Scanner(System.in);
		while(true) {
			try {
				System.out.println("请输入学号");
				id=sc0.nextInt();	
				break;
			}catch (Exception e) {
				sc0=new Scanner(System.in);
			}
		}
	
		
		Scanner sc1=new Scanner(System.in);
		while(true) {
			try {
				System.out.println("请输入学生姓名");
				name=sc1.next();	
				break;
			}catch(Exception e) {
				sc1=new Scanner(System.in);
			}
		}
		
	
		Scanner sc3=new Scanner(System.in);
		while(true) {
			try {
				System.out.println("请输入学生所在班级");
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
	public int login() {	//学生登陆方法
		Scanner sc=new Scanner(System.in);
		System.out.println("请输入密码：");
		String pass=sc.next();
		if(pass.equals(this.pass)) {
			System.out.println(Class+" "+name+" "+"你好!");
			if(pass.equals("123456")) {
				System.out.println("需要修改初始密码吗？需要请按1");
				int a=sc.nextInt();
				if(a==1) {
					this.setPassWord();
				}
			}
	
			return 1;
		}
		else
		{
			System.out.println("密码不正确！");
			return 0;
		}
	}
	public void SleCourse() {//选课
		System.out.println("选修课列表如下:");
		Courses.showOpt();
		System.out.println("请输入要选课程的编号：");
		Scanner sc=new Scanner(System.in);
		int id=sc.nextInt();
		for(int i=0;i<Courses.clist.size();i++) {
			if(Courses.clist.get(i).id==id)
			{//找到要选的课了
				if(Courses.clist.get(i).num<Courses.clist.get(i).getMaxNum()) {
					//课未选满
					Courses.clist.get(i).Slist.add(this);
					Clist.add(Courses.clist.get(i));
					System.out.println("选课成功！");
				}
				else
				{
					System.out.println("该课程已选满，选课失败！");
				}
					
			}
			
		}
		
	}
	public void StuSyllabus() {//查看自己所上课程
		int i;
		System.out.println("选修课表如下:");
		System.out.println("编号"+" "+"名称"+" "+"类型"+" "+"教师"+" "+"上课人数"+" "+"最大选课人数");
		for(i=0;i<Clist.size();i++) {
			if(Clist.get(i).type==1)
			Clist.get(i).show();
		}
		System.out.println("必修课表如下:");
		System.out.println("编号"+" "+"名称"+" "+"类型"+" "+"教师"+" "+"上课人数"+" "+"学分");
		for(i=0;i<Clist.size();i++) {
			if(Clist.get(i).type==0)
			Clist.get(i).show();
		}
	}
	public String toString() {
		return super.toString()+" "+this.id+" "+this.Class;
	}
	
}
