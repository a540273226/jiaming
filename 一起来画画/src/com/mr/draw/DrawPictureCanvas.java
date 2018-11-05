package com.mr.draw;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;

public class DrawPictureCanvas extends Canvas {

	private Image image = null; // 创建画板中展示的图片对象

	public void setImage(Image image) {
		this.image = image;

	}

	public void paint(Graphics g) {
		g.drawImage(image, 0, 0, null); // 在画布上绘制图像

	}

	public void update(Graphics g) {
		paint(g);
	}
}
