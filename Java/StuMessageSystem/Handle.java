import java.util.Scanner;
/**
 * @author 1107--stuggleYang
 */
/*������*/
public class Handle {
	public static void main(String[] args) {
		Class h = new Class(); //�༶����
		h.inSystem(); // ϵͳ������
		Scanner input = new Scanner(System.in);
		boolean flag = true;
		while(flag) {
			System.out.println("-------------����ѡ��ҵ�񡿣�");
			int inNum = input.nextInt();
			switch(inNum){
				case 1:
					h.Login(); // ��¼
					break;
				case 2:
					h.add(); // ���
					break;
				case 3:
					h.queryAll(); // ��ѯȫ��
					break;
				case 4:
					h.queryForNum(); // ��ѧ��������ѯ
					break;
				case 5:
					h.update(); // �޸�
					break;
				case 6:
					h.delete(); // ɾ��
					break;
				case 7: 
					flag =false; // �˳�
					System.out.println("------------���˳��ɹ���-------------");
					break;
				default:
					System.out.println("------------����������-------------");
			}	
		}
	}
}
