package practice2023_2;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Point;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;

import java.awt.HeadlessException;

public class pictureGame extends JFrame 
implements MouseListener,MouseMotionListener{
    private JLabel img[]=new JLabel[3];//要顯示圖案的標籤
    private JLabel targets[]=new JLabel[3];//視窗底下顯示文字的標籤
    private Point pressPoint;//滑鼠按下的座標
	
    public pictureGame() throws HeadlessException{
    	super();
    	getContentPane().setLayout(new BorderLayout());
    	setBounds(100,100,600,600);
    	setTitle("圖片比對");
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	final JPanel imagePanel=new JPanel();
    	imagePanel.setLayout(null);
    	imagePanel.setOpaque(false);
    	setGlassPane(imagePanel);
    	getGlassPane().setVisible(true);
    	
    	ImageIcon icon[]=new ImageIcon[3];
    	icon[0]=new ImageIcon(getClass().getResource("A.jpg"));
    	icon[1]=new ImageIcon(getClass().getResource("B.jpg"));
    	icon[2]=new ImageIcon(getClass().getResource("C.jpg"));
    	
    	final JPanel bottomPanel=new JPanel();
    	bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER,20,5));
    	getContentPane().add(bottomPanel,BorderLayout.SOUTH);
    	
    	for(int i=0;i<3;i++) 
    	{
    		img[i]=new JLabel(icon[i]);//建立放圖的標誌
    		img[i].setSize(100,100);//設定標籤大小
    		img[i].setBorder(new LineBorder(Color.GRAY));//設定線性邊框
    		
    		int x=(int)(Math.random()*(getWidth()-50));//隨機產生X座標
    		int y=(int)(Math.random()*(getHeight()-150));//隨機產生Y座標
    		
    		img[i].setLocation(x,y);//設定隨機產生的座標
    		img[i].addMouseListener(this);//替每個圖形標籤加入滑鼠事件監聽器
    		img[i].addMouseMotionListener(this);
    		
    		imagePanel.add(img[i]);//將圖形標籤控制項加入到圖形面板上
    		
    		targets[i]=new JLabel();//建立比對的位置標籤
    		targets[i].setOpaque(true);//將標籤設定成不透明,以設定背景色
    		targets[i].setBackground(Color.ORANGE);//設定標籤背景色
    		targets[i].setHorizontalTextPosition(SwingConstants.CENTER);//設定文字與圖形水平置中
    		targets[i].setVerticalTextPosition(SwingConstants.BOTTOM);//設定文字顯示在圖形下方
    		targets[i].setPreferredSize(new Dimension(150,150));//設定標籤大小
    		targets[i].setHorizontalAlignment(SwingConstants.CENTER);//文字置中對齊
    		bottomPanel.add(targets[i]);//將標籤加到底部面板
    		
    	}
    	
    	targets[0].setText("照片A");//設定比對位置的文字
    	targets[1].setText("照片B");
    	targets[2].setText("照片C");
    	
    	
    	   	
    }
    
	public static void main(String[] args) {
		pictureGame frame=new pictureGame();//建立實體化視窗物件
		frame.setVisible(true);//將此視窗物件設定成顯示狀態
				

	}
	@Override
	public void mouseDragged(MouseEvent e) {
		JLabel source=(JLabel)e.getSource();
		Point imgPoint=source.getLocation();
		Point point=e.getPoint();
		source.setLocation(imgPoint.x+point.x-pressPoint.x,
				imgPoint.y+point.y-pressPoint.y);
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		pressPoint=e.getPoint();
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		if(checkPosition()) 
		{
			getGlassPane().setVisible(false);
			for(int i=0;i<3;i++) 
			{
				targets[i].setText("比對成功");
				targets[i].setIcon(img[i].getIcon());
			}
		}
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		
	}
	private boolean checkPosition() 
	{
		boolean result=true;
		for(int i=0;i<3;i++) 
		{
			Point location=img[i].getLocationOnScreen();
			Point seat=targets[i].getLocationOnScreen();
			targets[i].setBackground(Color.GREEN);
			
			if(location.x<seat.x || location.y<seat.y 
					|| location.x>seat.x+80 || location.y>seat.y+80)
			{
				targets[i].setBackground(Color.ORANGE);
				result=false;
			}	
		}
		return result;
	}

}
