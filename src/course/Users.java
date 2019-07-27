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
		public static void showStudents() {//��ʾ����ѧ��
			System.out.println("ѧ��"+" "+"����"+" "+"�༶");
			int i;
			for(i=0;i<slist.size();i++) {
				slist.get(i).show();
			}
		}
		public static void showTeachers() {//��ʾ���н�ʦ
			System.out.println("����"+" "+"����"+" "+"ְ��");
			int i;
			for(i=0;i<tlist.size();i++) {
				tlist.get(i).show();
			}
		}
		public static void reStuPass() {//�ָ�ѧ����ʼ����
			System.out.println("������ѧ�ţ�");
			Scanner sc=new Scanner(System.in);
			int id,i;
			id=sc.nextInt();
			for(i=0;i<slist.size();i++) {
				if(slist.get(i).id==id)
					break;
			}
			System.out.println("ѧ��"+" "+"����"+" "+"�༶");
			slist.get(i).show();
			slist.get(i).pass="123456";
			System.out.println("�޸ĳɹ���");
		}
		public static void reThrPass() {//�ָ���ʦ��ʼ����
			System.out.println("�����빤�ţ�");
			Scanner sc=new Scanner(System.in);
			int id,i;
			id=sc.nextInt();
			for(i=0;i<tlist.size();i++) {
				if(tlist.get(i).workId==id)
					break;
			}
			System.out.println("����"+" "+"����"+" "+"ְ��");
			tlist.get(i).show();
			tlist.get(i).pass="123456";
			System.out.println("�޸ĳɹ���");
		}
		public static void addStudent() {//���ѧ��
			int a=0;
		    do {
			slist.add(Student.add_one());
			System.out.println("��1�������...");
			Scanner sc=new Scanner(System.in);
			a=sc.nextInt();	
		}while(a==1);
		}
		public static void addTeacher() {//��ӽ�ʦ
			int a=0;
		    do {
			tlist.add(Teacher.add_one());
			System.out.println("��1�������...");
			Scanner sc=new Scanner(System.in);
			a=sc.nextInt();	
		}while(a==1);
		}
		public static void delStudent() {//ɾ��ѧ��
			if(slist.size()==0) {
				System.out.println("Ŀǰû��ѧ����Ϣ���޷�����ɾ��������");
				return;
			}
			System.out.println("������Ҫɾ����ѧ����ѧ�ţ�");
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
		public static void delTeacher() {//ɾ����ʦ
			if(tlist.size()==0) {
				System.out.println("Ŀǰû�н�ʦ��Ϣ���޷�����ɾ��������");
				return;
			}
			System.out.println("������Ҫɾ���Ľ�ʦ�Ĺ��ţ�");
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
		public static void saveTeacher() {//����ʦ��Ϣд���ļ�
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
		public static void readTeacher() {//���ļ��ж�ȡ��ʦ��Ϣ
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
		public static void saveStudent() {//��ѧ����Ϣд���ļ�
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
		public static void readStudent() {//���ļ��ж�ȡѧ����Ϣ
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
	

