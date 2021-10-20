import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		DAO dao = new DAO();
		String b_id;
		String b_title;
		String b_autor;
		String b_publisher;
		int b_price;
		int cnt=0;
//		int cnnnt =0;
		
		
		
		while (true) {
			System.out.println("[Java 도서관리 프로그램]");
			System.out.print("[1]도서등록 [2]도서조회 [3]정보수정 [4]삭제 [5] 종료 >>");
			int menu = sc.nextInt();
			if(menu ==1) {
				
				System.out.print("도서아이디 : ");
				b_id=sc.next();
				System.out.print("도서명 : ");
				b_title=sc.next();
				System.out.print("저자 : ");
				b_autor=sc.next();
				System.out.print("출판사 : ");
				b_publisher=sc.next();
				System.out.print("가격 : ");
				b_price=sc.nextInt();
				
//				cnt = dao.insert(b_id,b_title,b_autor,b_publisher,b_price);
				
//				if (cnt > 0) {
//					System.out.println("저장 완료");
//				} else {
//					System.out.println("저장 실패");
//				}
			}else if(menu==2) {
//				
//				dao.select();
				
			}else if(menu==3) {
				
				System.out.print("수정할 도서 아이디: ");
				b_id = sc.next();
				
//				cnt = dao.update(b_id, b_price);
//				
//				if (cnt > 0) {
//					System.out.println("수정완료!");
//				} else {
//					System.out.println("수정실패...");
//				}
				
			}else if(menu==4) {
				
				System.out.print("삭제할 도서아이디: ");
				b_id = sc.next();
				
//				cnt = dao.delete(b_id);
				
//				if (cnt > 0) {
//					System.out.println("삭제완료!");
//				} else {
//					System.out.println("삭제실패...");
//				}
				
			}else {
				System.out.println("Java 도서관리 프로그램이 종료됩니다.");
				break;
			}
		}

	}

}
