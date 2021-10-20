
public class BookVO {

		   String b_id;
		   String b_title;
		   String b_autor;
		   String b_publisher;
		   int b_price;
		   
		   public BookVO() {}
		   
		   public BookVO(String b_id, String b_title, String b_autor, String b_publisher, int b_price) {
		      this.b_id = b_id;
		      this.b_title = b_title;
		      this.b_autor = b_autor;
		      this.b_publisher = b_publisher;
		      this.b_price = b_price;
		   }

		   public String getB_id() {
		      return b_id;
		   }

		   public String getB_title() {
		      return b_title;
		   }

		   public String getB_autor() {
		      return b_autor;
		   }

		   public String getB_publisher() {
		      return b_publisher;
		   }

		   public int getB_price() {
		      return b_price;
		   }

		   @Override
		   public String toString() {
		      return "";
		   }
		   
		   
		   
		   
		   
		

}
