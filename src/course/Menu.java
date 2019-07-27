/**
 * 
 */
package course;
import java.util.Scanner;
import java.util.Vector;
/**
 * @author:
 * @date:
 * @class:菜单
 * 
 */
public class Menu {

	public static void main(String [] args) {
		System.out.println("请选择登陆方式：");
		System.out.println("1.管理员登陆");
		System.out.println("2.教师登陆");
		System.out.println("3.学生登陆");
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
				if(b==1) {//密码正确，登陆成功
					break;
				}
			}
			while(true) {
				int out=0;
			users.admin.show();
			System.out.println("请选择要进行的操作：");
			System.out.println("1.添加课程");
			System.out.println("2.删除课程");
			System.out.println("3.显示课程清单");
			System.out.println("4.按照上课人数降序显示课程清单");
			System.out.println("5.修改授课教师");
			System.out.println("6.显示学生列表");
			System.out.println("7.显示教师列表");
			System.out.println("8.恢复教师初始密码");
			System.out.println("9.恢复学生初始密码");
			System.out.println("10.添加学生");
			System.out.println("11.添加教师");
			System.out.println("12.删除学生");
			System.out.println("13.删除教师");
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
					System.out.println("请重新选择！");
				}
			}
			System.out.println("按1回到登陆界面");
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
				System.out.println("请输入工号：");
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
			System.out.println("请选择要进行的操作：");
			System.out.println("1.修改登录密码");
			System.out.println("2.查看自己所授课程");
			System.out.println("3.查看某门所授课程上课学生列表");
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
					System.out.println("请重新选择！");
				}
			}
			System.out.println("按1回到登陆界面");
			sc=new Scanner(System.in);
			out=sc.nextInt();
			if(out!=1)
				break;
			}
			break;
		case 3:
			Student student=null;
			while(true) {
				System.out.println("请输入学号：");
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
			System.out.println("请选择要进行的操作：");
			System.out.println("1.修改登录密码");
			System.out.println("2.查看自己所上课程");
			System.out.println("3.选修课选课");
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
					System.out.println("请重新选择！");
				}
			}
			System.out.println("按1回到登陆界面");
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
