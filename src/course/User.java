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
	String name="admin";//�û���
	 String pass="123456";//����
	public User() {
		
	}
	public void show() {
		System.out.println("�û�����"+name);
	}
	public void setPassWord() {//�޸�����
		Scanner sc=new Scanner(System.in);
		while(true) {
			System.out.println("������������(6λ)");
			String xpass1=sc.next();
			System.out.println("���ٴ�����������(6λ)");
			String xpass2=sc.next();
			if(xpass1.equals(xpass2)&&xpass1.length()==6) {
				this.pass=xpass1;
				break;
			}else {
				System.out.println("�������벻һ�£�");
				continue;
			}
		}
		this.saveAdminPass();
		
	}
	public  void saveAdminPass() {//������Ա����д���ļ�
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
	public  void readAdminPass() {//��ȡ����Ա����
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
	public int login() {//����Ա��½
		this.readAdminPass();
		System.out.println("���������Ա���룺");
		Scanner sc=new Scanner(System.in);
		if(sc.next().equals(this.pass)) {
			System.out.println("����Ա����ã�");
			if(pass.equals("123456")) {
				System.out.println("��Ҫ�޸ĳ�ʼ��������Ҫ�밴1");
				int a=sc.nextInt();
				if(a==1) {
					this.setPassWord();
				}
			}
			return 1;
		}
			
		else {
			System.out.println("���벻��ȷ��");
			return 0;
		}
			
		
		
	}
	public String toString() {
		return name+" "+pass;
	}
	
}
