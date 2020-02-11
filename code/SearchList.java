package Medicine;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.channels.SelectableChannel;
import java.util.Vector;

import javax.swing.DefaultCellEditor;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableColumnModel;

import java.sql.ResultSet;  
import java.sql.SQLException; 
public class SearchList extends JFrame {
    private static final long serialVersionUID = 2294503152841317673L;
    //�������
    private JPanel contentPane;
    //�ı���
    private JTextField textField;
    //���
    private JTable table = null;
    
    private Table_Model model = null;
 
    private JScrollPane s_pan = null;
    
    private JButton button_1 = null, button_2 = null, button_3 = null;
    
    private JPanel pane = null;
    
    /*public static void main(String[] args) {
        try {
        	//Ƥ��
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Throwable e) {
            e.printStackTrace();
        }
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    SearchList frame = new SearchList();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }*/
    public SearchList() {
    	//����
        setTitle("ҩƷ����ϵͳ");
        //�ر�
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //��С��λ��
        setBounds(100, 100, 450, 300);
        //�������ʵ����
        contentPane = new JPanel();
        //��������߿�
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        //�����������
        contentPane.setLayout(new BorderLayout(0, 0));
        //�����������ӵ�������
        setContentPane(contentPane);
        //���
        JPanel panel = new JPanel();
        //�������뵽���������
        contentPane.add(panel, BorderLayout.NORTH);
        //��ǩ
        JLabel label = new JLabel("������ҩƷ����:");
        //��ǩ����
        label.setFont(new Font("΢���ź�", Font.PLAIN, 16));
        //�������ǩ
        panel.add(label);
        //�ı���
        textField = new JTextField();
        //�ı�������
        textField.setFont(new Font("΢���ź�", Font.PLAIN, 16));
        //���ı�����뵽�����
        panel.add(textField);
        //�ı���Ŀ��
        textField.setColumns(10);
        //��ť
        JButton button = new JButton("����");
        //��ť�¼�
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button_actionPerformed(e);
            }
        });
        //��ť����
        button.setFont(new Font("΢���ź�", Font.PLAIN, 16));
        //���Ӱ�ť
        panel.add(button);
        //��������ť
        pane = new JPanel();
        button_1 = new JButton("�޸�");
        button_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateData(e);
            }
        });
        button_2 = new JButton("���");
        button_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addData(e);
            }
        });
        button_3 = new JButton("ɾ��");
        button_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	//System.out.println(1);
                deleteData(e);
            }
        });
        pane.setLayout(new GridLayout(3,1,50,50));
        pane.add(button_1);
        pane.add(button_2);
        pane.add(button_3);
 
        
        //���
        model = new Table_Model(20);
        table = new JTable(model);
        table.setBackground(Color.white);
        contentPane.add(pane, BorderLayout.EAST);
        TableColumnModel tcm = table.getColumnModel();
        tcm.getColumn(3).setPreferredWidth(50);
        tcm.getColumn(4).setPreferredWidth(100);
        tcm.getColumn(0).setPreferredWidth(50);
        tcm.getColumn(1).setPreferredWidth(50);
        tcm.getColumn(2).setPreferredWidth(50);
 
        s_pan = new JScrollPane(table);
 
        contentPane.add(s_pan, BorderLayout.CENTER);
    }
    
    protected void do_button_actionPerformed(ActionEvent e) {
    	int row = table.getRowCount();
    	for(int i = 0 ; i < row ; i ++)
    		 model.removeRow(i);
    	table.updateUI();
    	//�õ��Ŀ����������
        String key = textField.getText();
        //�ж��Ƿ�Ϊ��
        if ((key == null) || (key.trim().isEmpty())) {
            JOptionPane.showMessageDialog(this, "������ؼ���", "", JOptionPane.WARNING_MESSAGE);
            return;
        }
        String sql = "select *from medicineinformation where name=\'"+key+"\'";
      //  String sql = "select *from medicineinformation";
        ResultSet ret = new SQL().Query(sql);
        try {
			while (ret.next()) {
			    String name = ret.getString(1);  
			    String company = ret.getString(2);
			    String number = ret.getString(3);  
			    String price = ret.getString(4); 
			    String mainfuction = ret.getString(5);
			//    String[] ss = new String[] {name,company,number,price,mainfuction};
			    model.addRow(name,company,number,price,mainfuction);
			 //   System.out.println(name + "\t" + company + "\t" + number + "\t" + price + "\t" + mainfuction);  
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        table.updateUI();
    }


	protected void deleteData(ActionEvent e){
		 int index = table.getSelectedRow();
	     int col = table.getColumnCount();
	  // System.out.println(col);
	     Object[] object = new Object[10];
	     for (int i = 0; i < col; i++)
	    	 object[i]=table.getValueAt(index, i);
	    // System.out.println(index);
	     String name = String.valueOf(object[0]);
	     String company = String.valueOf(object[1]);
	  // String name = object[0].toString();
	  // String company = object[1].toString();
	  // System.out.println(name);
	  // System.out.println(company);
	     String sql = "delete from medicineinformation where name=\'"+name+"\' and company=\'"+company+"\'";
	  // System.out.println(sql);
	     new SQL().Update(sql);
	     model.removeRow(index);
	     table.updateUI();
	     JOptionPane.showMessageDialog(null, "ɾ���ɹ�!");
	}
	
	
	protected void addData(ActionEvent e){
		new add();
	}
	
	protected void updateData(ActionEvent e){
		int index = table.getSelectedRow();
	    int col = table.getColumnCount();
	    Object[] object = new Object[10];
	    for (int i = 0; i < col; i++)
	    	 object[i]=table.getValueAt(index, i);
	    String name = String.valueOf(object[0]);
	    String company = String.valueOf(object[1]);
	    String num = String.valueOf(object[2]);
	    String price = String.valueOf(object[3]);
	    String function = String.valueOf(object[4]);
		new upDate(name,company,num,price,function);
	}
}

/**
* TableModel�࣬�̳���AbstractTableModel
*/
class Table_Model extends AbstractTableModel {
 
    private static final long serialVersionUID = -7495940408592595397L;
 
    private Vector content = null;
 
    private String[] title_name = {"ҩ��","����","����","�۸�","��Ч"};
 
    public Table_Model() {
        content = new Vector();
    }
 
    public Table_Model(int count) {
        content = new Vector(count);
    }
 
    public void addRow(String name,String company,String number,String price,String mainfunction) {
        Vector v = new Vector(5);
        v.add(0,name);
        v.add(1, company);
        v.add(2, number);
        v.add(3, price);
        v.add(4, mainfunction);
        content.add(v);
    }
 
    public void removeRow(int row) {
        content.remove(row);
    }
 
    public void removeRows(int row, int count) {
        for (int i = 0; i < count; i++) {
            if (content.size() > row) {
                content.remove(row);
            }
        }
    }
 
    /**
    * �ñ����ĳЩֵ���޸ģ�����ҪsetValueAt(Object value, int row, int col)������ϲ���ʹ�޸���Ч
    */
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if (columnIndex == 0) {
            return false;
        }
        return true;
    }
 
    /**
    * ʹ�޸ĵ�������Ч
    */
    public void setValueAt(Object value, int row, int col) {
        ((Vector) content.get(row)).remove(col);
        ((Vector) content.get(row)).add(col, value);
        this.fireTableCellUpdated(row, col);
    }
 
    public String getColumnName(int col) {
        return title_name[col];
    }
 
    public int getColumnCount() {
        return title_name.length;
    }
 
    public int getRowCount() {
        return content.size();
    }
 
    public Object getValueAt(int row, int col) {
        return ((Vector) content.get(row)).get(col);
    }
 
    /**
    * ������������
    */
    public Class getColumnClass(int col) {
        return getValueAt(0, col).getClass();
    }
}
