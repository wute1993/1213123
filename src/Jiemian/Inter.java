package Jiemian;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import Model.*;

public class Inter extends JFrame implements ActionListener
{
	JTextField inputId;
	JTextField inputPosition;
	JComboBox germ,PAMbox;
	JButton submit=null,upLoad;
	JLabel TargetGenome,ID,PAM;
	JLabel Position,Sequence;
	JTextArea inputSequence; 
	JScrollPane gd;
	public static void main(String[] args) 
	{
		Inter lx=new Inter();
	}
	Inter()
	{
		TargetGenome=new JLabel("Target Genome");
		inputSequence=new JTextArea();
		ID=new JLabel("Locus Tag");
		Position=new JLabel("Position");
		PAM=new JLabel("PAM");
		inputPosition=new JTextField(100);
		Sequence=new JLabel("Sequence");
		inputId=new JTextField(20);
		gd=new JScrollPane(inputSequence);
		String[] list1={"Saccharomyces","E.coil"};
		String[] list2={"NGG","NNNNGATT","NNAGAA","NAAAAC"};
		germ=new JComboBox(list1);
		PAMbox=new JComboBox(list2);
		
		submit=new JButton("ȷ��");
		upLoad=new JButton("�ϴ�");
		
		this.setBounds(300,155,840,550);
		this.setLayout(null);//���ò���
		this.getContentPane().add(ID);
		this.getContentPane().add(inputId);
		this.getContentPane().add(Position);
		this.getContentPane().add(inputPosition);
		this.getContentPane().add(TargetGenome);
		this.getContentPane().add(germ);
		this.getContentPane().add(PAM);
		this.getContentPane().add(PAMbox);
		this.getContentPane().add(Sequence);
		this.getContentPane().add(gd);
		this.getContentPane().add(submit);
		this.getContentPane().add(upLoad);
		TargetGenome.setBounds(45, 30,87, 23);
		germ.setBounds(145, 30,120, 25);//germ��λ��
		inputId.setBounds(145, 105, 250, 25);//����ID��λ��
		ID.setBounds(45,105,60,23);//ID��λ��
		Position.setBounds(45, 65,50, 23);//positionλ��
		inputPosition.setBounds(145, 65, 250, 25);//inputPositionλ��
		PAM.setBounds(45, 140, 30, 23);
		PAMbox.setBounds(145, 140,90,25);
		Sequence.setBounds(45, 175, 60, 23);
		gd.setBounds(145, 175, 400,250);
		submit.setBounds(720, 460, 70, 30);
		upLoad.setBounds(145, 460, 70, 30);
		this.setTitle("���봰��");
		 this.setSize(840,550);
		 //this.setIconImage((new ImageIcon("image/qq.jpg")).getImage());
		 this.setLocation(300,155);
		 this.setResizable(false);
		 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 this.setVisible(true);
		 submit.addActionListener(this);
		 
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==submit){
			String TargetGenomeValue=(String)germ.getSelectedItem();
			String PAMValue=(String)PAMbox.getSelectedItem();
			String IDValue=(String)inputId.getText();
			String PositionValue=(String)inputPosition.getText();
			Send send=new Send(TargetGenomeValue, PAMValue, IDValue, PositionValue);
		}
		
	}
}