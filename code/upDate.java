package Medicine;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

public class upDate extends JFrame{
	  private static final long serialVersionUID = 2294503152841317673L;
	    //�������
	    private JPanel contentPane;
	    //�ı���
	    private JTextField textField=null,textField1=null,textField2=null,textField3=null,textField4=null;
	    

	    
	    public upDate(String name,String adr,String num,String price,String function){
	    	setTitle("�޸�ҩƷ");
	        //�ر�
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        //��С��λ��
	        setBounds(10, 100, 300, 300);
	        //�������ʵ����
	        contentPane = new JPanel();
	        setLayout(new GridLayout(6,1,5,5));
	       
	        JPanel panel = new JPanel();
	         //JTextField textField=null;

	        //��ǩ
	        JLabel label = new JLabel("ҩƷ����:");
	        //��ǩ����
	        label.setFont(new Font("΢���ź�", Font.PLAIN, 16));
	        //�������ǩ
	        panel.add(label);
	        //�ı���
	        textField = new JTextField(name);
	        //�ı�������
	        textField.setFont(new Font("΢���ź�", Font.PLAIN, 16));
	        //���ı�����뵽�����
	        panel.add(textField);
	        //�ı���Ŀ��
	        textField.setColumns(10);
	        add(panel);
	        
	        JPanel panel1 = new JPanel();
	        //JTextField textField1=null;
	     
	        //��ǩ
	        JLabel label1 = new JLabel("ҩƷ����:");
	        //��ǩ����
	        label1.setFont(new Font("΢���ź�", Font.PLAIN, 16));
	        //�������ǩ
	        panel1.add(label1);
	        //�ı���
	        textField1 = new JTextField(adr);
	        //�ı�������
	        textField1.setFont(new Font("΢���ź�", Font.PLAIN, 16));
	        //���ı�����뵽�����
	        panel1.add(textField1);
	        //�ı���Ŀ��
	        textField1.setColumns(10);
	        add(panel1);
	        
	        JPanel panel2 = new JPanel();
	        //JTextField textField2=null;
	
	        //��ǩ
	        JLabel label2 = new JLabel("ҩƷ����:");
	        //��ǩ����
	        label2.setFont(new Font("΢���ź�", Font.PLAIN, 16));
	        //�������ǩ
	        panel2.add(label2);
	        //�ı���
	        textField2 = new JTextField(num);
	        //�ı�������
	        textField2.setFont(new Font("΢���ź�", Font.PLAIN, 16));
	        //���ı�����뵽�����
	        panel2.add(textField2);
	        //�ı���Ŀ��
	        textField2.setColumns(10);
	        add(panel2);
	        
	        JPanel panel3 = new JPanel();
	        //JTextField textField3=null;
	
	        //��ǩ
	        JLabel label3 = new JLabel("ҩƷ�۸�:");
	        //��ǩ����
	        label3.setFont(new Font("΢���ź�", Font.PLAIN, 16));
	        //�������ǩ
	        panel3.add(label3);
	        //�ı���
	        textField3 = new JTextField(price);
	        //�ı�������
	        textField3.setFont(new Font("΢���ź�", Font.PLAIN, 16));
	        //���ı�����뵽�����
	        panel3.add(textField3);
	        //�ı���Ŀ��
	        textField3.setColumns(10);
	        add(panel3);
	        
	        JPanel panel4 = new JPanel();
	        //JTextField textField4=null;
	
	        //��ǩ
	        JLabel label4 = new JLabel("ҩƷ��Ч:");
	        //��ǩ����
	        label4.setFont(new Font("΢���ź�", Font.PLAIN, 16));
	        //�������ǩ
	        panel4.add(label4);
	        //�ı���
	        textField4 = new JTextField(function);
	        //�ı�������
	        textField4.setFont(new Font("΢���ź�", Font.PLAIN, 16));
	        //���ı�����뵽�����
	        panel4.add(textField4);
	        //�ı���Ŀ��
	        textField4.setColumns(10);
	        add(panel4);
	        
	        JButton button_1 = null;
	        button_1 = new JButton("ȷ��");
	        button_1.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                //removeData();
	            	//String str1=textField.getText();
	            	String sql="update medicineinformation set name=\'"+textField.getText()
	           				+"\' ,company=\'"+textField1.getText()+"\' ,number="+textField2.getText()
	            				+" ,price="+textField3.getText()+",mainfunction=\'"+textField4.getText()
	            				+"\' where name=\'"+name+"\' and company=\'"+adr+"\'";
	            	if(textField.getText().equals("")||textField1.getText().equals("")||textField2.equals("")||textField3.getText().equals("")||textField4.getText().equals(""))	
	            		JOptionPane.showMessageDialog(null, "�޸�ʧ��!");
	            	else{
	            		new SQL().Update(sql);
	            		JOptionPane.showMessageDialog(null, "�޸ĳɹ�!");
	            	}
	            	setVisible(false);
	            }
	        });
	        add(button_1);
	        setVisible(true);
	    }

}
