import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BooKDAO dao = new BooKDAO();
		String b_id;
		String b_title;
		String b_autor;
		String b_publisher;
		int b_price = 0;
		int cnt=0;
		
		
		
		while (true) {
			System.out.println("[Java �������� ���α׷�]");
			System.out.print("[1]������� [2]������ȸ [3]�������� [4]���� [5] ���� >>");
			int menu = sc.nextInt();
			if(menu ==1) {
				
				System.out.print("�������̵� : ");
				b_id=sc.next();
				System.out.print("������ : ");
				b_title=sc.next();
				System.out.print("���� : ");
				b_autor=sc.next();
				System.out.print("���ǻ� : ");
				b_publisher=sc.next();
				System.out.print("���� : ");
				b_price=sc.nextInt();
				
				cnt = dao.insert(b_id,b_title,b_autor,b_publisher,b_price);
				
				if (cnt > 0) {
					System.out.println("���� �Ϸ�");
				} else {
					System.out.println("���� ����");
				}
			}else if(menu==2) {
					System.out.print("[1]Ư��������ȸ [2]��ü��ȸ >>");
					int menu2 = sc.nextInt();
					if(menu2==1) {
						System.out.println("��ȸ�� �������̵� : ");
						
						b_id=sc.next();
						
						dao.select(b_id);
						
					}else if(menu2==2) {
						dao.selectAll();
					}else {
						System.out.println("�ٽ� �Է����ּ���");
					}
				
			}else if(menu==3) {
				
				System.out.print("������ ���� ���̵�: ");
				b_id = sc.next();
				
				System.out.print("���� : ");
				b_price = sc.nextInt();
				
				cnt = dao.update(b_id, b_price);
				
				if (cnt > 0) {
					System.out.println("�����Ϸ�!");
				} else {
					System.out.println("��������...");
				}
				
			}else if(menu==4) {
				
				System.out.print("������ �������̵�: ");
				b_id = sc.next();
				
				cnt = dao.delete(b_id);
				
				if (cnt > 0) {
					System.out.println("�����Ϸ�!");
				} else {
					System.out.println("��������...");
				}
				
			}else {
				System.out.println("Java �������� ���α׷��� ����˴ϴ�.");
				break;
			}
		}

	}

}
