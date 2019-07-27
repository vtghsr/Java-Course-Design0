/**
 * 
 */
package course;

import java.util.Vector;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
/**
 * @author:
 * @date:
 * @class:
 * 
 */
public class Users {
		User admin=new User();
		public static Vector<Student> slist=new Vector();
		public static Vector<Teacher> tlist=new Vector();
		public static void showStudents() {//显示所有学生
			System.out.println("学号"+" "+"姓名"+" "+"班级");
			int i;
			for(i=0;i<slist.size();i++) {
				slist.get(i).show();
			}
		}
		public static void showTeachers() {//显示所有教师
			System.out.println("工号"+" "+"姓名"+" "+"职称");
			int i;
			for(i=0;i<tlist.size();i++) {
				tlist.get(i).show();
			}
		}
		public static void reStuPass() {//恢复学生初始密码
			System.out.println("请输入学号：");
			Scanner sc=new Scanner(System.in);
			int id,i;
			id=sc.nextInt();
			for(i=0;i<slist.size();i++) {
				if(slist.get(i).id==id)
					break;
			}
			System.out.println("学号"+" "+"姓名"+" "+"班级");
			slist.get(i).show();
			slist.get(i).pass="123456";
			System.out.println("修改成功！");
		}
		public static void reThrPass() {//恢复教师初始密码
			System.out.println("请输入工号：");
			Scanner sc=new Scanner(System.in);
			int id,i;
			id=sc.nextInt();
			for(i=0;i<tlist.size();i++) {
				if(tlist.get(i).workId==id)
					break;
			}
			System.out.println("工号"+" "+"姓名"+" "+"职称");
			tlist.get(i).show();
			tlist.get(i).pass="123456";
			System.out.println("修改成功！");
		}
		public static void addStudent() {//添加学生
			int a=0;
		    do {
			slist.add(Student.add_one());
			System.out.println("按1继续添加...");
			Scanner sc=new Scanner(System.in);
			a=sc.nextInt();	
		}while(a==1);
		}
		public static void addTeacher() {//添加教师
			int a=0;
		    do {
			tlist.add(Teacher.add_one());
			System.out.println("按1继续添加...");
			Scanner sc=new Scanner(System.in);
			a=sc.nextInt();	
		}while(a==1);
		}
		public static void delStudent() {//删除学生
			if(slist.size()==0) {
				System.out.println("目前没有学生信息，无法进行删除操作！");
				return;
			}
			System.out.println("请输入要删除的学生的学号：");
			int a,i;
			Scanner sc=new Scanner(System.in);
			a=sc.nextInt();
			for(i=0;i<slist.size();i++) {
				if(slist.get(i).id==a) {
					break;
				}
			}
			slist.remove(i);
		}
		public static void delTeacher() {//删除教师
			if(tlist.size()==0) {
				System.out.println("目前没有教师信息，无法进行删除操作！");
				return;
			}
			System.out.println("请输入要删除的教师的工号：");
			int a,i;
			Scanner sc=new Scanner(System.in);
			a=sc.nextInt();
			for(i=0;i<tlist.size();i++) {
				if(tlist.get(i).workId==a) {
					break;
				}
			}
			tlist.remove(i);
		}
		public static void saveTeacher() {//将教师信息写入文件
			File file=new File("C:/Users/maling/eclipse-workspace/course/Teacher.txt");
			try {
				if(!file.exists()) {
					file.createNewFile();
				}
				BufferedWriter out=new BufferedWriter(new FileWriter(file.getAbsoluteFile()));
				for(int i=0;i<Users.tlist.size();i++) {
					out.write(((Teacher)(Users.tlist.get(i))).toString()+"\r\n");
				}
				out.flush();
				out.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
			
		}
		public static void readTeacher() {//从文件中读取教师信息
			try {
				BufferedReader br=new BufferedReader(new InputStreamReader
						(new FileInputStream("C:/Users/maling/eclipse-workspace/course/Teacher.txt")));
				String data=null;
				while((data=br.readLine())!=null)
				{
					String[] ps=data.split(" ");
					String name=ps[0];
					String pass=ps[1];
					int id=Integer.parseInt(ps[2]);
					String level=ps[3];
				tlist.add(new Teacher(name,pass,id,level));
				}
				br.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}
		public static void saveStudent() {//将学生信息写入文件
			File file=new File("C:/Users/maling/eclipse-workspace/course/Student.txt");
			try {
				if(!file.exists()) {
					file.createNewFile();
				}
				BufferedWriter out=new BufferedWriter(new FileWriter(file.getAbsoluteFile()));
				for(int i=0;i<Users.slist.size();i++) {
					out.write(((Student)(Users.slist.get(i))).toString()+"\r\n");
				}
				out.flush();
				out.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
			
		}
		public static void readStudent() {//从文件中读取学生信息
			try {
				BufferedReader br=new BufferedReader(new InputStreamReader
						(new FileInputStream("C:/Users/maling/eclipse-workspace/course/Student.txt")));
				String data=null;
				while((data=br.readLine())!=null)
				{
					String[] ps=data.split(" ");
					String name=ps[0];
					String pass=ps[1];
					int id=Integer.parseInt(ps[2]);
					String Class=ps[3];
				slist.add(new Student(name,pass,id,Class));
				}
				br.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}
}
	

