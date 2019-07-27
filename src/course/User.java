package course;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author:
 * @date:
 * @class:
 * 
 */
public class User {
	String name="admin";//用户名
	 String pass="123456";//密码
	public User() {
		
	}
	public void show() {
		System.out.println("用户名："+name);
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
				System.out.println("两次输入不一致！");
				continue;
			}
		}
		this.saveAdminPass();
		
	}
	public  void saveAdminPass() {//将管理员密码写入文件
		File file=new File("C:/Users/maling/eclipse-workspace/course/admin.txt");
		try {
			if(!file.exists()) {
				file.createNewFile();
			}
			BufferedWriter out=new BufferedWriter(new FileWriter(file.getAbsoluteFile()));
				out.write(pass+" "+"\r\n");
			
			out.flush();
			out.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	public  void readAdminPass() {//读取管理员密码
		try {
			BufferedReader br=new BufferedReader(new InputStreamReader
					(new FileInputStream("C:/Users/maling/eclipse-workspace/course/admin.txt")));
			String data=null;
			while((data=br.readLine())!=null)
			{
				String[] ps=data.split(" ");
				String pass=ps[0];	
				this.pass=pass;
			}
			br.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	public int login() {//管理员登陆
		this.readAdminPass();
		System.out.println("请输入管理员密码：");
		Scanner sc=new Scanner(System.in);
		if(sc.next().equals(this.pass)) {
			System.out.println("管理员，你好！");
			if(pass.equals("123456")) {
				System.out.println("需要修改初始密码吗？需要请按1");
				int a=sc.nextInt();
				if(a==1) {
					this.setPassWord();
				}
			}
			return 1;
		}
			
		else {
			System.out.println("密码不正确！");
			return 0;
		}
			
		
		
	}
	public String toString() {
		return name+" "+pass;
	}
	
}
