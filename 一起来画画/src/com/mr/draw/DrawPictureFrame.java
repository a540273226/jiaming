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
	Graphics gs = image.getGraphics();			//���ͼ��Ļ�ͼ����	
	Graphics2D g = (Graphics2D) gs;				//����ͼ����ת����ʽ
	DrawPictureCanvas canvas = new DrawPictureCanvas();		//��������	
	Color foreColor = Color.BLACK;							//����ǰ��ɫ
	Color backgroundColor = Color.WHITE;					//���屳��ɫ
	int x = -1;									//�ϴ������Ƶ�ĺ�����
	int y = -1;									//�ϴ������Ƶ��������
	boolean rubber = false;						//��Ƥ��ʶ����
	private JToolBar toobar;       				//������
	private JButton eraserButton;				//��Ƥ��ť
	private JToggleButton strokeButton1;		//ϸ�߰�ť
	private JToggleButton strokeButton2;		//���߰�ť
	private JToggleButton strokeButton3;		//�ϴְ�ť
	private JButton backgroundButton;			//������ɫ��ť
	private JButton foregroundButton;			//ǰ����ɫ��ť
	private JButton clearButton;				//�����ť
	private JButton saveButton;					//���水ť
	private JButton shapeButton;				//ͼ�ΰ�ť
	
	
	
	public  DrawPictureFrame() {
		setResizable(false); // ���ڴ�С����
		setTitle("��ͼ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ����ر���ֹͣ����
		setBounds(500, 100, 574, 460);
		
		init();				//�����ʼ��
		addListener();
	}
	
	public void addListener(){
		//�����������ƶ��¼�����
		canvas.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(final MouseEvent e){					//�������קʱ	
				if(x>0&&y>0){												//���X��Y��������¼
					if(rubber){												//�����Ƥ��ʾΪtrue ����ʾʹ����Ƥ
						g.setColor(backgroundColor);						//��ͼ����ʹ�ñ���ɫ
						g.fillRect(x, y, 10, 10);							//����껬����λ�û�����������
					}else{													//�����Ƥ��ʶΪfalse����ʾ�û��ʻ�ͼ
						g.drawLine(x, y, e.getX(), e.getY());				//����껬����λ�û�ֱ��
					}
				}
				x = e.getX();												//�ϴ������Ƶ�ĺ�����
				y = e.getY();												//�ϴ������Ƶ��������
				canvas.repaint();											//���»���
			}
		});
		
		//�������������¼�����
		canvas.addMouseListener(new MouseAdapter() {
			public void mouseReleased(final MouseEvent agr0){
				x = -1;
				y = -1;
			}
			
		});
		
		
		
	}
	
	
	private void init(){
		 g.setColor(backgroundColor);		//�ñ���ɫ���û�ͼ�������ɫ
		 g.fillRect(0, 0, 570, 390);		//�ñ���ɫ�����������	
		 g.setColor(foreColor);				//��ǰ��ɫ���û�ͼ�������ɫ	
		 canvas.setImage(image);			//���û�����ͼ��
		 getContentPane().add(canvas);		//��������ӵ���������Ĭ�ϲ��ֵ��в�λ��
		
	}

	public static void main(String[] args) {
		DrawPictureFrame frame = new DrawPictureFrame();
		frame.setVisible(true);
	}

}
