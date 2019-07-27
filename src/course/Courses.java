/**
 * 
 */
package course;

import java.util.Scanner;
import java.util.Vector;
import java.io.File;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
/**
 * @author:
 * @date:
 * @class:
 * 
 */
public class Courses {
	public static Vector<Course> clist=new Vector();
	
	public static void add_course() {//添加课程
		int a=0;
		int choice=2;
		    do {
		    System.out.println("添加必修课程请按0，添加选修课程请按1：");
		    Scanner sc=new Scanner(System.in);
		    choice=sc.nextInt();
		    if(choice==0) {
		    	clist.add(Compusary.add_one());
		    }
		    else if(choice==1) {
		    	clist.add(Optional.add_one());
		    }
		    else {
		    	System.out.println("请重新选择课程类型！");
		    	continue;
		    }
			System.out.println("按1继续添加...");
			 sc=new Scanner(System.in);
			a=sc.nextInt();	
		}while(a==1);
	}
	public static void del_course() {//删除课程
		if(clist.size()==0) {
			System.out.println("目前没有课程信息，无法进行删除操作！");
			return;
		}
		System.out.println("请输入要删除的课程编号：");
		int a,i;
		Scanner sc=new Scanner(System.in);
		a=sc.nextInt();
		for(i=0;i<clist.size();i++) {
			if(clist.get(i).id==a) {
				break;
			}
		}
		clist.remove(i);
	}

	
	public static void show_all() {//显示课程列表
		if(clist.size()==0) {
			System.out.println("目前没有课程信息");
		}
		System.out.println("必修课列表:");
		Courses.showCom();
		System.out.println("选修课列表:");
		Courses.showOpt();
	}
	public static void showOpt() {//显示选修课列表
		int i;
		System.out.println("编号"+" "+"名称"+" "+"类型"+" "+"教师"+" "+"上课人数"+" "+"最大选课人数");
		for(i=0;i<clist.size();i++) {
			if(clist.get(i).type==1) {
				clist.get(i).show();
			}
		}
		
	}
	public static void showCom() {//显示必修课表
		int i;
		System.out.println("编号"+" "+"名称"+" "+"类型"+" "+"教师"+" "+"上课人数"+" "+"学分");
		for(i=0;i<clist.size();i++) {
			if(clist.get(i).type==0) {
				clist.get(i).show();
			}
		}
	}
	public static void show_seq() {//按选课人数由高到低输出课程信息
		if(clist.size()==0) {
			System.out.println("目前没有课程信息");
		}
		int i=0;
		Course c,k,m;
		for(i=0;i<clist.size();i++) {
			for(int j=i+1;j<clist.size();j++) {
				k=clist.get(j);
				c=clist.get(i);
				m=c;
				if(c.num<k.num) {
					clist.set(i, k);
					clist.set(j, m);
				}
			}
		}
		for(i=0;i<clist.size();i++) {
			 c=clist.get(i);
			c.show();
		}
		
		}
	public static void setCourseTeacher() {//设置课程教师
		int id;
		System.out.println("请输入课程编号：");
		Scanner sc=new Scanner(System.in);
		id=sc.nextInt();
		int i;
		for(i=0;i<clist.size();i++) {
			if(clist.get(i).id==id) {
				break;
			}
		}
		System.out.println("编号"+" "+"名称"+" "+"类型"+" "+"教师"+" "+"选课人数");
		clist.get(i).show();
		System.out.println("请输入新的教师姓名：");
		sc=new Scanner(System.in);
		clist.get(i).teacher=sc.next();
		
		
	}
	public static void saveCourse() {//将课程信息写入文件,除了选该课的学生列表
		File file=new File("C:/Users/maling/eclipse-workspace/course/Courses.txt");
		try {
			if(!file.exists()) {
				file.createNewFile();
			}
			BufferedWriter out=new BufferedWriter(new FileWriter(file.getAbsoluteFile()));
			for(int i=0;i<Courses.clist.size();i++) {
				out.write(((Course)(Courses.clist.get(i))).toString()+"\r\n");
			}
			out.flush();
			out.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	public static void saveCourse2() {//将每门课选课学生列表写入文件
		File file=new File("C:/Users/maling/eclipse-workspace/course/Slist.txt");
		try {
			if(!file.exists()) {
				file.createNewFile();
			}
			BufferedWriter out=new BufferedWriter(new FileWriter(file.getAbsoluteFile()));
			for(int i=0;i<Courses.clist.size();i++) {
				for(int j=0;j<clist.get(i).Slist.size();j++) {
					out.write(Courses.clist.get(i).toString2(j)+" "+clist.get(i).id+"\r\n");
				}
			
			}
			out.flush();
			out.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	public static void readCourses() {//从文件中读取课程信息
		try {
			BufferedReader br=new BufferedReader(new InputStreamReader
					(new FileInputStream("C:/Users/maling/eclipse-workspace/course/Courses.txt")));
			String data=null;
			while((data=br.readLine())!=null)
			{
				String[] ps=data.split(" ");
				int id=Integer.parseInt(ps[0]);
				String name=ps[1];
				int type=Integer.parseInt(ps[2]);
				int num=Integer.parseInt(ps[3]);
				String teacher=ps[4];
				Vector<Student> Slist=new Vector();
				try {
					BufferedReader br2=new BufferedReader(new InputStreamReader
							(new FileInputStream("C:/Users/maling/eclipse-workspace/course/Slist.txt")));
					String data2=null;
					while((data2=br2.readLine())!=null)
					{
						String[] ps2=data2.split(" ");
						String name2=ps2[0];
						String pass2=ps2[1];
						int id2=Integer.parseInt(ps2[2]);
						String Class2=ps2[3];
						int flag=Integer.parseInt(ps2[4]);
						//查看这个学生是否选了这门课
						if(flag==id)
						Slist.add(new Student(name2,pass2,id2,Class2));
					}
					br2.close();
				}catch(Exception e) {
					e.printStackTrace();
				}
				
	
				if(type==0) {
					int point=Integer.parseInt(ps[5]);
					Courses.clist.add(new Compusary(id,name,type,teacher,num,point,Slist));
				}
				else {
					int maxNum=Integer.parseInt(ps[5]);
					Courses.clist.add(new Optional(id,name,type,teacher,num,maxNum,Slist));
					
				}
			}
			br.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}

