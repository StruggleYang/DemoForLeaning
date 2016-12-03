/**
 * @author 1107--stuggleYang
 */
/*学生类*/
public class Students {
	private int num; // 学号
	private String name; // 姓名
	private int age; // 年龄
	private String sex; // 性别
	private String pwd;// 密码
	// 属性的设置和获取方法
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
	// 构造方法用于添加时实例化
	public Students() {}
	// 如果添加默认信息数据则可用此构造函数实例化
	public Students(int num, String name, int age, String sex, String pwd) {
		this.num = num;
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.pwd = pwd;
	}
}
