package Medicine;

import java.sql.ResultSet;  
import java.sql.SQLException;

import javax.swing.JOptionPane;  

public class SQL {
	static String sql = null;  
	static DataBase db1 = null;
	static ResultSet ret = null;
	  
    public ResultSet Query(String sql) {
        db1 = new DataBase(sql);//����DBHelper����  
  
        try {
            ret = db1.pst.executeQuery();//ִ����䣬�õ������
            return ret;
          /*  while (ret.next()) {  
                String name = ret.getString(1);  
                String company = ret.getString(2);
                String number = ret.getString(3);  
                String price = ret.getString(4); 
                String mainfuction = ret.getString(5);
                System.out.println(name + "\t" + company + "\t" + number + "\t" + price + "\t" + mainfuction);  
            }//��ʾ����  
            ret.close();  
            db1.close();//�ر�����  */
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return ret;
    }  
    public void Update(String sql){
    	db1 = new DataBase(sql);//����DBHelper����  
    	try {
            db1.pst.executeUpdate();//ִ����䣬�õ������
    	}catch (SQLException e) {
            e.printStackTrace();
            //JOptionPane.showMessageDialog(null, "�����쳣!");
        }
    	return;
    }
    
  /*  public static void main(String[] args) {  
        String sql = "select *from medicineinformation";//SQL���  
        ResultSet ret = new SQL().Getresult(sql);
        try {
			while (ret.next()) {  
			    String name = ret.getString(1);  
			    String company = ret.getString(2);
			    String number = ret.getString(3);  
			    String price = ret.getString(4); 
			    String mainfuction = ret.getString(5);
			    System.out.println(name + "\t" + company + "\t" + number + "\t" + price + "\t" + mainfuction);  
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }*/
}