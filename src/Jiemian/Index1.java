package Jiemian;

import org.eclipse.swt.events.*;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.ui.forms.widgets.FormToolkit;

public class Index1 extends Shell {
	private Text locousTag;
	private Text sequence;
	private Text position;
	protected final FormToolkit formToolkit = new FormToolkit(Display.getDefault());

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			Index1 shell = new Index1(display);
			shell.open();
			shell.layout();
			while (!shell.isDisposed()) {
				if (!display.readAndDispatch()) {
					display.sleep();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the shell.
	 * @param display
	 */
	public Index1(final Display display) {
		super(display, SWT.CLOSE | SWT.MIN | SWT.RESIZE | SWT.TITLE);
		setMinimumSize(new Point(840, 550));
		setToolTipText("index");
		Image iconImage = new Image(null,"image/about1.png");
		setImage(iconImage);
		setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_HIGHLIGHT_SHADOW));
		setLayout(null);
		
		Composite IndexBackImage = new Composite(this, SWT.NONE);
		IndexBackImage.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
//		Image backeImage = new Image(Display.getCurrent(), getClass().getResourceAsStream("/image/backImage.png"));
		Image backImage = new Image(null,"image/backImage.png");
		IndexBackImage.setBackgroundImage(backImage);
		IndexBackImage.setBounds(0, 0, 824, 512);
		
		locousTag = new Text(IndexBackImage, SWT.NONE);
		locousTag.setToolTipText("");
		locousTag.setFont(SWTResourceManager.getFont("Microsoft JhengHei", 10, SWT.NORMAL));
		locousTag.setTabs(3);
		locousTag.setBounds(146, 119, 248, 24);
		
		CCombo targetGenme = new CCombo(IndexBackImage, SWT.BORDER);
		targetGenme.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		targetGenme.setFont(SWTResourceManager.getFont("Vani", 9, SWT.BOLD));
		String[] list1={"Saccharomyces","E.coil"};
		targetGenme.setItems(list1);
		targetGenme.setBounds(146, 44, 104, 24);
		
		CCombo PAM = new CCombo(IndexBackImage, SWT.BORDER);
		PAM.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		PAM.setFont(SWTResourceManager.getFont("Vani", 9, SWT.BOLD));
		PAM.setItems(new String[] {"NGG", "NNNNGATT", "NNAGAA", "NAAAAC"});
		PAM.setBounds(146, 154, 104, 24);
		
		
		
		sequence = new Text(IndexBackImage, SWT.V_SCROLL | SWT.MULTI);
		sequence.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		sequence.setCapture(true);
		sequence.setToolTipText("Input Sequece");
		sequence.setBounds(146, 196, 298, 248);
		
		position = new Text(IndexBackImage, SWT.BORDER);
		position.setBounds(146, 79,248, 24);
		
		final Canvas Import = new Canvas(IndexBackImage, SWT.NONE);
		Image importshang = new Image(null,"image/importshang.png");
		final Image importxia = new Image(null,"image/importxia.png");
		Import.addMouseListener(new MouseAdapter() {
			public void mouseDown(MouseEvent e) {
				Image importshang = new Image(null,"image/importshang.png");
				Import.setBackgroundImage(importshang);
			}
			@Override
			public void mouseUp(MouseEvent e) {
				Image importxia = new Image(null,"image/importxia.png");
				Import.setBackgroundImage(importxia);
			}
		});
		Import.setBounds(146, 465, 80, 30);
		formToolkit.adapt(Import);
		formToolkit.paintBordersFor(Import);
		Import.setBackgroundImage(importshang);
		
		final Canvas submit = new Canvas(IndexBackImage, SWT.NONE);
		submit.addMouseListener(new MouseAdapter() {
			public void mouseUp(MouseEvent e) {
				Image submitshang = new Image(null,"image/submitshang.png");
				submit.setBackgroundImage(submitshang);
			}
			@Override
			public void mouseDown(MouseEvent e) {
				Image submitxia = new Image(null,"image/submitxia.png");
				submit.setBackgroundImage(submitxia);
			}
		});
		Image submitshang = new Image(null,"image/submitshang.png");
		submit.setBackgroundImage(submitshang);
		submit.setBounds(460, 465, 80, 30);
		formToolkit.adapt(submit);
		formToolkit.paintBordersFor(submit);
		
		final Canvas advance = new Canvas(IndexBackImage, SWT.NONE);
		Image advanced= new Image(null,"image/advanced .png");
		advance.setBackgroundImage(advanced);
		advance.setBounds(717, 161, 123, 309);
		formToolkit.adapt(advance);
		formToolkit.paintBordersFor(advance);
		
		Button btnCheckButton = new Button(advance, SWT.CHECK);
		btnCheckButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnCheckButton.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		btnCheckButton.setBounds(10, 10, 98, 17);
		formToolkit.adapt(btnCheckButton, true, true);
		btnCheckButton.setText("Check Button");
		

		class kk implements Runnable{
			public void run(){
				for(int i=0;i<125;i++){
					if(advance.isDisposed()) return;
					final int[] index=new int[]{i};
					display.syncExec(new Runnable(){
						public void run() {
							advance.setBounds(840-index[0],161, 123, 309);
							try {
								Thread.sleep(4);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
						
					}
							);
				}
			}
			
		}	
		Canvas advanceButton = new Canvas(IndexBackImage, SWT.NONE);
		advanceButton.addMouseListener(new MouseAdapter() {
			public void mouseDown(MouseEvent e) {
				kk ws=new kk();
				 Thread thread=new Thread(ws);
				 thread.start();
			}
		});
		Image advancedbutton= new Image(null,"image/advancedbutton.png");
		advanceButton.setBackgroundImage(advancedbutton);
		advanceButton.setBounds(715, 124, 125, 39);
		formToolkit.adapt(advanceButton);
		formToolkit.paintBordersFor(advanceButton);
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("Index");
		setSize(517, 334);

	}

	@Override
	protected void checkSubclass() {
	}
}
