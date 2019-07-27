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
	int workId;//工号
	String level;//职称
	public  Vector<Course> Clist=new Vector();//所授课程
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
	public  int login() {//教师登陆方法,修改初始密码
		System.out.println("请输入密码：");
		Scanner sc=new Scanner(System.in);
		String pass=sc.next();
		if(pass.equals(this.pass)) {
			System.out.println(workId+":"+name+" "+level+"你好!");
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
	public static Teacher add_one() {//添加一个教师
		int id=0;
		String name="";
		String pass="";
		String level;
		Scanner sc0=new Scanner(System.in);
		while(true) {
			try {
				System.out.println("请输入工号");
				id=sc0.nextInt();	
				break;
			}catch (Exception e) {
				sc0=new Scanner(System.in);
			}
		}
	
		
		Scanner sc1=new Scanner(System.in);
		while(true) {
			try {
				System.out.println("请输入教师姓名");
				name=sc1.next();	
				break;
			}catch(Exception e) {
				sc1=new Scanner(System.in);
			}
		}
		
	
		Scanner sc3=new Scanner(System.in);
		while(true) {
			try {
				System.out.println("请输入职称");
				level=sc3.next();
				break;
			}catch(Exception e) {
				sc3=new Scanner(System.in);
			}
		}
		

		 Teacher t=new Teacher(name,"123456",id,level);
		return t;
		
	}
	public  void teacher_find(){//查询教师教授课程
		String teacher;
		int i;
		System.out.println("请输入教师姓名:");
		Scanner sc=new Scanner(System.in);
		teacher=sc.next();
		System.out.println("选修课表如下：");
		System.out.println("编号"+" "+"名称"+" "+"类型"+" "+"教师"+" "+"上课人数"+" "+"最大选课人数");
		for(i=0;i<Clist.size();i++) {
			if(Clist.get(i).type==1) {
				Clist.get(i).show();
			}
		}
		System.out.println("必修课表如下：");
		System.out.println("编号"+" "+"名称"+" "+"类型"+" "+"教师"+" "+"上课人数"+" "+"学分");
		for(i=0;i<Clist.size();i++) {
			if(Clist.get(i).type==0) {
				Clist.get(i).show();
			}
		}
		
		
	}
	public void Stulist() {//查看某门所授课程上课学生列表
		System.out.println("请输入要查看的课程的编号:");
		Scanner sc=new Scanner(System.in);
		int id=sc.nextInt();
		int i,j;
		for(i=0;i<Clist.size();i++) {
			if(Clist.get(i).id==id) {
				if(Clist.get(i).type==1) {
					System.out.println("编号"+" "+"名称"+" "+"类型"+" "+"教师"+" "+"上课人数"+" "+"最大选课人数");
					Clist.get(i).show();
					for(j=0;j<Clist.get(i).Slist.size();j++) {
						System.out.println("学号"+" "+"姓名"+" "+"班级");
						Clist.get(i).Slist.get(j).show();
					}
				}
				if(Clist.get(i).type==0) {
					System.out.println("编号"+" "+"名称"+" "+"类型"+" "+"教师"+" "+"上课人数"+" "+"学分");
					Clist.get(i).show();
					for(j=0;j<Clist.get(i).Slist.size();j++) {
						System.out.println("学号"+" "+"姓名"+" "+"班级");
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

