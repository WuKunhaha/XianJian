package cn.tedu.xianjian;

import javax.swing.JFrame;

/* *
 * �����ʾ��Ϸ��Ŀ�Ĵ�����
 * @author lousiyi
 *
 */

public class GameFrame{

	public static void main(String[] args) {
		//�����������ʵ��������
		JFrame chuangkou = new JFrame();
		//���ô��ڶ�������
		chuangkou.setSize(1024,768);
		chuangkou.setTitle("�ɽ���Ϸ-Version1.0");
		//chuangkou.setLocation(x, y);
		//�ô��ڶ��������ʾ
		chuangkou.setLocationRelativeTo(null);
		//���ô���Ĭ�Ϲرղ���ѡ��
		chuangkou.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//�ô��ڶ�����ʾ����
		GamePanel1 huaban = new GamePanel1();
		chuangkou.add(huaban);
		
		//�����߳����ʵ�������󣬲��ҹ����Զ��廭�����
		Thread xiancheng = new Thread(huaban);
		//�����̶߳���
		xiancheng.start();
		chuangkou.addKeyListener(huaban);
		chuangkou.addMouseListener(huaban);
		huaban.addMouseListener(huaban);
		chuangkou.setVisible(true);
		
	}

}