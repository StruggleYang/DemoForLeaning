/**
 * @author 1107--stuggleYang
 */
/*ѧ����*/
public class Students {
	private int num; // ѧ��
	private String name; // ����
	private int age; // ����
	private String sex; // �Ա�
	private String pwd;// ����
	// ���Ե����úͻ�ȡ����
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	// ���췽���������ʱʵ����
	public Students() {}
	// ������Ĭ����Ϣ��������ô˹��캯��ʵ����
	public Students(int num, String name, int age, String sex, String pwd) {
		this.num = num;
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.pwd = pwd;
	}
}
