/**
 * 
 */
package course;
import java.util.Scanner;
import java.util.Vector;
/**
 * @author:
 * @date:
 * @class:�˵�
 * 
 */
public class Menu {

	public static void main(String [] args) {
		System.out.println("��ѡ���½��ʽ��");
		System.out.println("1.����Ա��½");
		System.out.println("2.��ʦ��½");
		System.out.println("3.ѧ����½");
		Users users=new Users();
		Courses courses=new Courses();
		courses.readCourses();
		users.readStudent();
		users.readTeacher();
		int a=0;
		Scanner sc=new Scanner(System.in);
		a=sc.nextInt();
		switch(a) {
		case 1:
		
				
			while(true) {
				int b=users.admin.login();
				if(b==1) {//������ȷ����½�ɹ�
					break;
				}
			}
			while(true) {
				int out=0;
			users.admin.show();
			System.out.println("��ѡ��Ҫ���еĲ�����");
			System.out.println("1.��ӿγ�");
			System.out.println("2.ɾ���γ�");
			System.out.println("3.��ʾ�γ��嵥");
			System.out.println("4.�����Ͽ�����������ʾ�γ��嵥");
			System.out.println("5.�޸��ڿν�ʦ");
			System.out.println("6.��ʾѧ���б�");
			System.out.println("7.��ʾ��ʦ�б�");
			System.out.println("8.�ָ���ʦ��ʼ����");
			System.out.println("9.�ָ�ѧ����ʼ����");
			System.out.println("10.���ѧ��");
			System.out.println("11.��ӽ�ʦ");
			System.out.println("12.ɾ��ѧ��");
			System.out.println("13.ɾ����ʦ");
			while(true) {
				sc=new Scanner(System.in);
				int c=sc.nextInt();
				if(c==1) {
					Courses.add_course();
					break;
				}else if(c==2) {
					Courses.del_course();
					break;
				}else if(c==3) {
					Courses.show_all();
					break;
				}else if(c==4) {
					Courses.show_seq();
					break;
				}else if(c==5) {
					Courses.setCourseTeacher();
					break;
				}else if(c==6) {
					Users.showStudents();
					break;
				}else if(c==7) {
					Users.showTeachers();
					break;
				}else if(c==8) {
					Users.reThrPass();
					break;
				}else if(c==9) {
					Users.reStuPass();
					break;
				}else if(c==10) {
					Users.addStudent();
					break;
				}else if(c==11) {
					Users.addTeacher();
					break;
				}else if(c==12) {
					Users.delStudent();
					break;
				}else if(c==13) {
					Users.delTeacher();
					break;
				}else {
					System.out.println("������ѡ��");
				}
			}
			System.out.println("��1�ص���½����");
			sc=new Scanner(System.in);
			out=sc.nextInt();
			if(out!=1) {
				break;
			}
			}
			break;
		case 2:
			Teacher teacher=null;
			while(true) {
				System.out.println("�����빤�ţ�");
				Scanner sc0=new Scanner(System.in);
				int workId=sc0.nextInt();
				int i;
				for(i=0;i<Users.tlist.size();i++) {
					if(Users.tlist.get(i).workId==workId) {
						break;
					}
				}
				 teacher=Users.tlist.get(i);
				int d=teacher.login();
				if(d==1) {
					break;
				}
			}
			while(true) {
				
			int out=0;
			teacher.show();
			System.out.println("��ѡ��Ҫ���еĲ�����");
			System.out.println("1.�޸ĵ�¼����");
			System.out.println("2.�鿴�Լ����ڿγ�");
			System.out.println("3.�鿴ĳ�����ڿγ��Ͽ�ѧ���б�");
			while(true) {
				sc=new Scanner(System.in);
				int e=sc.nextInt();
				if(e==1) {
					teacher.setPassWord();
					break;
				}else if(e==2) {
					teacher.teacher_find();
					break;
				}else if(e==3) {
					teacher.Stulist();
					break;
				}else {
					System.out.println("������ѡ��");
				}
			}
			System.out.println("��1�ص���½����");
			sc=new Scanner(System.in);
			out=sc.nextInt();
			if(out!=1)
				break;
			}
			break;
		case 3:
			Student student=null;
			while(true) {
				System.out.println("������ѧ�ţ�");
				Scanner sc1=new Scanner(System.in);
				int id=sc1.nextInt();
				int j;
				for(j=0;j<Users.slist.size();j++) {
					if(Users.slist.get(j).id==id) {
						break;
					}
				}
				 student=Users.slist.get(j);
				int f=student.login();
				if(f==1) {
					break;
				}
			}
			while(true) {
				
			int out=0;
			student.show();
			System.out.println("��ѡ��Ҫ���еĲ�����");
			System.out.println("1.�޸ĵ�¼����");
			System.out.println("2.�鿴�Լ����Ͽγ�");
			System.out.println("3.ѡ�޿�ѡ��");
			while(true) {
				sc=new Scanner(System.in);
				int f=sc.nextInt();
				if(f==1) {
					student.setPassWord();
					break;
				}else if(f==2) {
					student.StuSyllabus();
					break;
				}else if(f==3) {
					student.SleCourse();
					break;
				}else {
					System.out.println("������ѡ��");
				}
			}
			System.out.println("��1�ص���½����");
			sc=new Scanner(System.in);
			out=sc.nextInt();
			if(out!=1)
				break;
			}
			break;
		}
		courses.saveCourse();
		courses.saveCourse2();
		users.saveStudent();
		users.saveTeacher();

		
	}




}
