import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class selectAll_ArrayList {
	
	
	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;
	int result = 0;
	String sql;
	BookVO bv = new BookVO();

	ArrayList<BookVO> book_list = new ArrayList<>();

	public void getConn() {

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");

			String url = "jdbc:oracle:thin:@192.168.1.240:1521:xe";
			String user = "hr";
			String password = "hr";
			conn = DriverManager.getConnection(url, user, password);

		} catch (Exception e) {

			System.out.println("연결 오류 발생");
			e.printStackTrace();
		}

	}

	public void close() {
		try {

			if (rs != null) {
				rs.close();
			}
			if (psmt != null) {
				psmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public int insert(String b_id, String b_title, String b_author, String b_publisher, int b_price) {

		getConn();

		try {

			sql = "insert into book values(?,?,?,?,?)";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, b_id);
			psmt.setString(2, b_title);
			psmt.setString(3, b_author);
			psmt.setString(4, b_publisher);
			psmt.setInt(5, b_price);

			result = psmt.executeUpdate();

//			book_list.add(new BookVO(b_id, b_title, b_author, b_publisher, b_price));

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return result;
	}

	public void select(String b_id) {

		getConn();

		try {
			sql = "Select * from book where b_id = ?";

			psmt = conn.prepareStatement(sql);
			psmt.setString(1, b_id);

			rs = psmt.executeQuery();

			while (rs.next()) {
				String getB_id = rs.getString(1);
				String getB_title = rs.getString(2);
				String getB_author = rs.getString(3);
				String getB_publisher = rs.getString(4);
				int getB_price = rs.getInt(5);

				System.out.println(
						getB_id + "\t" + getB_title + "\t" + getB_author + "\t" + getB_publisher + "\t" + getB_price);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 3.데이터베이스 닫아주기
			close();
		}
	}


	public void selectAll() {
		
		
		getConn();
		
			
		try {
			sql = "select * from book";
			
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			while (rs.next()) {
				
				
				String getB_id = rs.getString(1);
				String getB_title = rs.getString(2);
				String getB_author = rs.getString(3);
				String getB_publisher = rs.getString(4);
				int getB_price = rs.getInt(5);

				
				book_list.add(new BookVO(getB_id, getB_title, getB_author, getB_publisher, getB_price));
				
			}
			for(int i=0 ; i<book_list.size(); i++) {
				System.out.println( book_list.get(i).b_id + book_list.get(i).b_title + book_list.get(i).getB_autor() + book_list.get(i).b_publisher
						+ book_list.get(i).b_price);
			}
			}catch(Exception e) {
				
				e.printStackTrace();
				
		}finally{
			close();
		}
			
	}
	

	public int update(String b_id, int b_price) {

		getConn();

		try {
			sql = "update book set b_price=? where b_id=?";

			psmt = conn.prepareStatement(sql);

			psmt.setInt(1, b_price);
			psmt.setString(2, b_id);

			result = psmt.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();

		} finally {
			close();
		}

		return result;
	}

	// 회원정보 delete 메소드
	public int delete(String b_id) {

		try {
			getConn();

			// 3.실행할 SQL문 작성
			sql = "delete from book where b_id = ?";

			psmt = conn.prepareStatement(sql);
			psmt.setString(1, b_id);

			// 4.SQL실행!
			result = psmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			close();
		}

		return result;
	}

}


