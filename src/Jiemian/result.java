package Jiemian;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumn;

import java.awt.event.MouseEvent;

public class result extends JFrame {
	JTable tableKey;
	JTable tableOfftarget;
	JPanel mb1,mb2;
	static String[][] datakey;
	static String[][][] dataofftarget;
	static String[][] dataofftargetx;
	final Object[] columnNames = {"key", "sequence","position","total_score"};
	final Object[] coloumnSonNames={"sequence","score","mms","strand","position","region"};
	public result(String[][] datakey,String[][][] dataofftarget){
		this.datakey=datakey;
		this.dataofftarget=dataofftarget;
	}
	public result() {
		this.setLayout(null);
		mb1=new JPanel(null);

		tableKey=new JTable(datakey,columnNames);
		//tableKey
		TableColumn firsetColumn = tableKey.getColumnModel().getColumn(0);
		firsetColumn.setPreferredWidth(20);//设置第一行宽度
		TableColumn secondColumn = tableKey.getColumnModel().getColumn(1);
		secondColumn.setPreferredWidth(110);
		//tableKey.setAutoResizeMode(JTable.AUTO_RESIZE_OFF); 
		JScrollPane pane1 = new JScrollPane (tableKey);
		mb1.add(pane1);
		pane1.setBounds(20,50,310, 400);
		
//		tableKey.setPreferredScrollableViewportSize(new Dimension(550, 30));
		this.getContentPane().add(mb1);
		mb1.setBounds(0,0,840,550);

		tableKey.addMouseListener(new java.awt.event.MouseAdapter(){
             public void mouseClicked(MouseEvent e) {//仅当鼠标单击时响应
                //得到选中的行列的索引值
               int r= tableKey.getSelectedRow();
               int c= tableKey.getSelectedColumn();
               //得到选中的单元格的值，表格中都是字符串
               Object value= tableKey.getValueAt(r, c);
               int length=dataofftarget[r].length;
              dataofftargetx=new String[length][6];
               for(int i=0;i<5;i++){
            	   for(int j=0;j<6;j++){
            		   dataofftargetx[i][j]=dataofftarget[r][i][j];
            	   }
               }
              tableOfftarget=new JTable(dataofftargetx,coloumnSonNames);
               JScrollPane pane2 = new JScrollPane (tableOfftarget);
               
               tableOfftarget.setShowGrid(true);
               tableOfftarget.setShowHorizontalLines(false);
               mb1.add(pane2);
               pane2.setBounds(330, 50, 505, 400);
            String info=r+"行"+c+"列值 : "+value.toString();
            //javax.swing.JOptionPane.showMessageDialog(null,info);
             }
         });
		this.setTitle("结果窗口");
		this.setSize(840,550);
		 //this.setIconImage((new ImageIcon("image/qq.jpg")).getImage());
		 this.setLocation(300,155);
		 this.setResizable(false);
		 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 this.setVisible(true);
	}

}
