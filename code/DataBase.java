package Medicine;


import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.PreparedStatement;  
import java.sql.SQLException;  

public class DataBase {
	public static final String url = "jdbc:mysql://localhost/medicine";  
	public static final String name = "com.mysql.jdbc.Driver";  
	public static final String user = "user";  
	public static final String password = "12345";  
  
	public Connection conn = null;  
	public PreparedStatement pst = null;  

  public DataBase(String sql) {  
      try {  
          Class.forName(name);//ָ����������  
          conn = DriverManager.getConnection(url, user, password);//��ȡ����  
          pst = conn.prepareStatement(sql);//׼��ִ�����  
      } catch (Exception e) {  
          e.printStackTrace();  
      }  
  }  

  public void close() {  
      try {  
          this.conn.close();  
          this.pst.close();  
      } catch (SQLException e) {  
          e.printStackTrace();  
      }  
  }  
}
