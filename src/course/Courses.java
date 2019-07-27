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
	
	public static void add_course() {//��ӿγ�
		int a=0;
		int choice=2;
		    do {
		    System.out.println("��ӱ��޿γ��밴0�����ѡ�޿γ��밴1��");
		    Scanner sc=new Scanner(System.in);
		    choice=sc.nextInt();
		    if(choice==0) {
		    	clist.add(Compusary.add_one());
		    }
		    else if(choice==1) {
		    	clist.add(Optional.add_one());
		    }
		    else {
		    	System.out.println("������ѡ��γ����ͣ�");
		    	continue;
		    }
			System.out.println("��1�������...");
			 sc=new Scanner(System.in);
			a=sc.nextInt();	
		}while(a==1);
	}
	public static void del_course() {//ɾ���γ�
		if(clist.size()==0) {
			System.out.println("Ŀǰû�пγ���Ϣ���޷�����ɾ��������");
			return;
		}
		System.out.println("������Ҫɾ���Ŀγ̱�ţ�");
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

	
	public static void show_all() {//��ʾ�γ��б�
		if(clist.size()==0) {
			System.out.println("Ŀǰû�пγ���Ϣ");
		}
		System.out.println("���޿��б�:");
		Courses.showCom();
		System.out.println("ѡ�޿��б�:");
		Courses.showOpt();
	}
	public static void showOpt() {//��ʾѡ�޿��б�
		int i;
		System.out.println("���"+" "+"����"+" "+"����"+" "+"��ʦ"+" "+"�Ͽ�����"+" "+"���ѡ������");
		for(i=0;i<clist.size();i++) {
			if(clist.get(i).type==1) {
				clist.get(i).show();
			}
		}
		
	}
	public static void showCom() {//��ʾ���޿α�
		int i;
		System.out.println("���"+" "+"����"+" "+"����"+" "+"��ʦ"+" "+"�Ͽ�����"+" "+"ѧ��");
		for(i=0;i<clist.size();i++) {
			if(clist.get(i).type==0) {
				clist.get(i).show();
			}
		}
	}
	public static void show_seq() {//��ѡ�������ɸߵ�������γ���Ϣ
		if(clist.size()==0) {
			System.out.println("Ŀǰû�пγ���Ϣ");
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
	public static void setCourseTeacher() {//���ÿγ̽�ʦ
		int id;
		System.out.println("������γ̱�ţ�");
		Scanner sc=new Scanner(System.in);
		id=sc.nextInt();
		int i;
		for(i=0;i<clist.size();i++) {
			if(clist.get(i).id==id) {
				break;
			}
		}
		System.out.println("���"+" "+"����"+" "+"����"+" "+"��ʦ"+" "+"ѡ������");
		clist.get(i).show();
		System.out.println("�������µĽ�ʦ������");
		sc=new Scanner(System.in);
		clist.get(i).teacher=sc.next();
		
		
	}
	public static void saveCourse() {//���γ���Ϣд���ļ�,����ѡ�ÿε�ѧ���б�
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
	public static void saveCourse2() {//��ÿ�ſ�ѡ��ѧ���б�д���ļ�
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
	public static void readCourses() {//���ļ��ж�ȡ�γ���Ϣ
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
						//�鿴���ѧ���Ƿ�ѡ�����ſ�
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

