package cn.tedu.xianjian;

import javax.swing.JFrame;

/* *
 * 本类表示游戏项目的窗口类
 * @author lousiyi
 *
 */

public class GameFrame{

	public static void main(String[] args) {
		//创建窗口类的实例化对象
		JFrame chuangkou = new JFrame();
		//设置窗口对象属性
		chuangkou.setSize(1024,768);
		chuangkou.setTitle("仙剑游戏-Version1.0");
		//chuangkou.setLocation(x, y);
		//让窗口对象居中显示
		chuangkou.setLocationRelativeTo(null);
		//设置窗口默认关闭操作选项
		chuangkou.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//让窗口对象显示出来
		GamePanel1 huaban = new GamePanel1();
		chuangkou.add(huaban);
		
		//创建线程类的实例化对象，并且关联自定义画板对象
		Thread xiancheng = new Thread(huaban);
		//启动线程对象
		xiancheng.start();
		chuangkou.addKeyListener(huaban);
		chuangkou.addMouseListener(huaban);
		huaban.addMouseListener(huaban);
		chuangkou.setVisible(true);
		
	}

}