package com.mr.draw;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.*;

import com.sun.org.apache.xml.internal.security.Init;

public class DrawPictureFrame extends JFrame {
	
	BufferedImage image = new BufferedImage(570, 390, BufferedImage.TYPE_INT_BGR);
	Graphics gs = image.getGraphics();			//获得图像的绘图对象	
	Graphics2D g = (Graphics2D) gs;				//将会图对象转换格式
	DrawPictureCanvas canvas = new DrawPictureCanvas();		//创建画布	
	Color foreColor = Color.BLACK;							//定义前景色
	Color backgroundColor = Color.WHITE;					//定义背景色
	int x = -1;									//上次鼠标绘制点的横坐标
	int y = -1;									//上次鼠标绘制点的纵坐标
	boolean rubber = false;						//橡皮标识变量
	private JToolBar toobar;       				//工具栏
	private JButton eraserButton;				//橡皮按钮
	private JToggleButton strokeButton1;		//细线按钮
	private JToggleButton strokeButton2;		//粗线按钮
	private JToggleButton strokeButton3;		//较粗按钮
	private JButton backgroundButton;			//背景颜色按钮
	private JButton foregroundButton;			//前景颜色按钮
	private JButton clearButton;				//清除按钮
	private JButton saveButton;					//保存按钮
	private JButton shapeButton;				//图形按钮
	
	
	
	public  DrawPictureFrame() {
		setResizable(false); // 窗口大小不变
		setTitle("画图程序");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 窗体关闭则停止程序
		setBounds(500, 100, 574, 460);
		
		init();				//组件初始化
		addListener();
	}
	
	public void addListener(){
		//画板添加鼠标移动事件监听
		canvas.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(final MouseEvent e){					//当鼠标拖拽时	
				if(x>0&&y>0){												//如果X和Y存在鼠标记录
					if(rubber){												//如果橡皮表示为true ，表示使用橡皮
						g.setColor(backgroundColor);						//绘图工具使用背景色
						g.fillRect(x, y, 10, 10);							//在鼠标滑过的位置画填充的正方形
					}else{													//如果橡皮标识为false，表示用画笔画图
						g.drawLine(x, y, e.getX(), e.getY());				//在鼠标滑过的位置画直线
					}
				}
				x = e.getX();												//上次鼠标绘制点的横坐标
				y = e.getY();												//上次鼠标绘制点的纵坐标
				canvas.repaint();											//更新画布
			}
		});
		
		//画板添加鼠标点击事件监听
		canvas.addMouseListener(new MouseAdapter() {
			public void mouseReleased(final MouseEvent agr0){
				x = -1;
				y = -1;
			}
			
		});
		
		
		
	}
	
	
	private void init(){
		 g.setColor(backgroundColor);		//用背景色设置绘图对象的颜色
		 g.fillRect(0, 0, 570, 390);		//用背景色填充整个画布	
		 g.setColor(foreColor);				//用前景色设置绘图对象的颜色	
		 canvas.setImage(image);			//设置画布的图像
		 getContentPane().add(canvas);		//将画布添加到窗体容器默认布局的中部位置
		
	}

	public static void main(String[] args) {
		DrawPictureFrame frame = new DrawPictureFrame();
		frame.setVisible(true);
	}

}
