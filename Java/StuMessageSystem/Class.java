import java.util.Scanner;
/**
 * @author 1107--stuggleYang
 */
/*�༶��*/
public class Class {
	static Students[] stus = new Students[100]; // ����һ�����鱣��ѧ������
	
	//ϵͳ��������ʾ
	public void inSystem(){
		sop("---------------------------��ѧ������ϵͳ��----------------------------\n"
				+"��1.��¼����2.��ӡ���3.��ѯȫ������4.ѧ��&������ѯ����5.�޸ġ���6.ɾ������7.�˳���\n"
				+"---------------------------��ѧ������ϵͳ��----------------------------\n");
	}
	
	//��¼
	public void Login() {
		sop("------------����¼��-------------");
		Scanner in = new Scanner(System.in);
		for(int x = 3;x >=1;x--) { // һ����¼ʧ�ܣ�����¼����
			sop("��������ѧ�š���");
			int inXh = in.nextInt();
			sop("�����������롿��");
			String inMm = in.next();
			for(int i = 0;i < stus.length-1;i++) {
				if(stus[i]==null){ // �����һ��λ�þ�Ϊ�գ����ʾ��ϵͳ�в������κ����ݣ�ֱ�ӷ���������
					sop("����¼ʧ��,δ���κ��û����ڡ�");
					return; //ֱ�ӽ�������
				}else if(inXh == stus[i].getNum() && inMm.equals(stus[i].getPwd())) { // �ҵ�ѧ�ź����붼����ϵ����¼�ɹ�
					sop("����¼�ɹ���");
					return;
				}else{ // ��������ݵ�����������������������ϵģ����õ�һ�λ��ᣬֱ�����λ�������
					sop("����¼ʧ�ܣ����û������ڣ��㻹��"+(x-1)+"�ε�¼���᡿");
					break;
				}
			}
		}
	}
		
	//���
	public void add(){
		sop("+++++++++++++++�������Ϣ��+++++++++++++++");
		Scanner in = new Scanner(System.in);
		int numAdd=0;  // ����һ���������������õ�������Ϊ�յĽǱ�
		for (int y=0 ; y < stus.length-1;y++) {
			// �ж��Ƿ������ݣ�����У��ͽ�������ӵ�������ӵ���һ���Ǳ꣬��ӵ���ͬλ�ñ��⸲��
			// stus[y].getNum()! �����Ϊ���ʧ�ܺ󿪱���һ������λȴû��ֵ�����
	 		if (stus[y]!=null && stus[y].getNum()!=0) { 
	 			numAdd++;
	 		}
		}
		stus[numAdd] = new Students(); // �ڵõ���λ�Ǳ���ڿ�λ�Ǳ괦�����һ��ѧ������
		//�����е�������Ϣ����������ѧ�����������
		sop("ѧ�ţ�");
		int inNum = in.nextInt();
		sop("������");
		String inName = in.next();
		sop("���䣺");
		int inAge = in.nextInt();
		sop("�Ա�");
		String inSex = in.next();
		sop("���룺");
		String inPwd = in.next();
		for(int i = 0;i<stus.length;i++) {
			if(stus[i] != null && inNum ==stus[i].getNum()){
				sop("�����ʧ�ܣ�ѧ��"+inNum+"�Ѵ��ڣ���������ӡ�");
				return;
			}
		}
		stus[numAdd].setNum(inNum);
		stus[numAdd].setName(inName);
		stus[numAdd].setAge(inAge);
		stus[numAdd].setSex(inSex);
		stus[numAdd].setPwd(inPwd);
		// ��������ӵ���ϢԤ��һ��
		sop("����ӳɹ�������ӵ�����Ϊ����"+"\nѧ�ţ�"+stus[numAdd].getNum()+"\n������"+stus[numAdd].getName()+"\n���䣺"+stus[numAdd].getAge()
				+"\n�Ա�"+stus[numAdd].getSex()+"\n���룺"+stus[numAdd].getPwd());
	}
	
	//��ѯȫ��
	public void queryAll() {
		sop("+++++++++++++++����ѯ���С�+++++++++++++++");
		int flag1 =0; // ���������������õ���Ϣ��
		for(int i = 0; i < stus.length-1;i++) {
			if(stus[i]!=null) {
				sop("����"+(i+1)+"�����ݡ���"+"\nѧ�ţ�"+stus[i].getNum()+"\n������"+stus[i].getName()+"\n���䣺"+stus[i].getAge()
						+"\n�Ա�"+stus[i].getSex()+"\n���룺"+stus[i].getPwd());
				flag1++;
			}
		}
		sop("����ѯ��ϣ���"+flag1+"����Ϣ��"); // ��ʾ��ѯ����Ϣ��
	}
	
	//��ѧ�Ų�ѯ
	public int queryForNum() { //����ֵ�������ز�ѯ�Ľ�����
		System.out.println("+++++++++++++++��������Ҫ��ѯ/�޸�/ɾ����Ϣ��ѧ�ż�������+++++++++++++++");
		Scanner in = new Scanner(System.in);
		int flag2 =0;
		sop("��Ҫ��ѯ��ѧ�š���");
		int inQuNum = in.nextInt();
		sop("��Ҫ��ѯ����������");
		String inQuName = in.next();
		for(int i = 0;i <stus.length;i++) {
			if(stus[i]==null){ // �����һ��λ�þ�Ϊ�գ����ʾ��ϵͳ�в������κ����ݣ�ֱ�ӷ���������
				sop("����ѯʧ��,�޴�����Ϣ��");
				flag2 = -1; // ������
				return flag2; //ֱ�ӽ�������,���ؽ��
			}else if(inQuNum == stus[i].getNum() && inQuName.equals(stus[i].getName())) { // Ϊ�˸���ȷ�ҵ�ѧ�ź�����������ϵ����ѯ��������Ϣ
				sop("����ѯ�ɹ�����ѯ������¡���"+"\nѧ�ţ�"+stus[i].getNum()+"\n������"+stus[i].getName()+"\n���䣺"+stus[i].getAge()
						+"\n�Ա�"+stus[i].getSex()+"\n���룺"+stus[i].getPwd());
				flag2 = i; // ��ѯ�ɹ�������Ӧ����Ϣ�ĽǱ�λ��
				return flag2;
			}else{ 
				flag2 = -1; // �����ڴ�������
			}
		}
		if(flag2 == -1){// ��������ݵ�����������������������ϵ����ѯʧ��
			sop("����ѯʧ�ܣ��޴�����Ϣ��");
		}
		return flag2; // �����ڷ����ڸ���һ������ֵ�������ڲ�ѯ�󶼲��᷵�ش�ֵ����֤����������
	}
	
	//�޸�
	public void update() {
		sop("+++++++++++++++���޸ġ�+++++++++++++++");
		int queryResult = queryForNum(); // ��ȡ��ѯ�õ��Ľ��
		Scanner in = new Scanner(System.in);
		if(queryResult == -1) { // ���Ϊ-1����ʾϵͳ�����ݻ��޴�����Ϣ
			sop("��������ӻ��֤�����޸ģ�лл��");
		}else{ // ���Ϊ���������ѯ���������
			sop("���Ƿ��޸�������Ϣ��(0/��,1/��)��"); // ��ֹ�û������
			int updateElect = in.nextInt();
			switch(updateElect) {
				case 0:
					sop("��������Ϣδ���κ��޸ġ�");
					break;
				case 1:
					sop("���������޸����ݡ�");
					sop("ѧ�ţ�");
					int inNum = in.nextInt();
					sop("������");
					String inName = in.next();
					sop("���䣺");
					int inAge = in.nextInt();
					sop("�Ա�");
					String inSex = in.next();
					sop("���룺");
					String inPwd = in.next();
					for(int i = 0;i<stus.length;i++) {
						// ����޸����������ѧ�Ų�Ϊ��ѯ����Ϣ��ѧ�ţ����������д��ڴ�ѧ�ţ����޸�ʧ��
						if(stus[i] != null && inNum != stus[queryResult].getNum() && inNum ==stus[i].getNum()){
							sop("���޸�ʧ�ܣ�ѧ��"+inNum+"�Ѵ��ڣ��������޸ġ�");
							return; // �����ص�������
						}
					}
					// ����ѧ��Ψһ�����޸�
					stus[queryResult].setNum(inNum);
					stus[queryResult].setName(inName);
					stus[queryResult].setAge(inAge);
					stus[queryResult].setSex(inSex);
					stus[queryResult].setPwd(inPwd);
					// �������޸ĵ���ϢԤ��һ��
					sop("���޸���ϣ����޸ĺ������Ϊ����"+"\nѧ�ţ�"+stus[queryResult].getNum()+"\n������"+stus[queryResult].getName()+"\n���䣺"+stus[queryResult].getAge()
							+"\n�Ա�"+stus[queryResult].getSex()+"\n���룺"+stus[queryResult].getPwd());
					break;
			}
		}
	}
	
	//ɾ��
	public void delete() {
		System.out.println("+++++++++++++++��ɾ����+++++++++++++++");
		int queryResult = queryForNum(); // ��ȡ��ѯ�õ��Ľ��
		Scanner in = new Scanner(System.in);
		if(queryResult == -1) { // ���Ϊ-1����ʾϵͳ�����ݻ��޴�����Ϣ
			sop("��������ӻ��֤��Ϣ����ɾ����лл��");
		}else{ // ���Ϊ���������ѯ���������
			sop("���Ƿ�ɾ��������Ϣ��(0/��,1/��)��"); // ��ֹ�û������
			int deleteElect = in.nextInt();
			switch(deleteElect) {
			case 0:
				sop("������δ���κβ�����");
				break;
			case 1:
				// ɾ����������ѯ������Ϣ���е����
				stus[deleteElect] = null;
				sop("��������Ϣɾ���ɹ���");
				break;
			}
		}
	}
	//��ӡ���
	public void sop(Object o) { // Object�����κζ���
		System.out.println(o);
	}
}
