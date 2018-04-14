package cn.tedu.xianjian;

import java.awt.Graphics;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class GamePanel extends JPanel{
	public void paint(Graphics g){
		g.drawImage(Toolkit.getDefaultToolkit().getImage(GamePanel.class.getResource("LiJiaCun/0.png"))
				,-200,-200,this);
		g.drawImage(Toolkit.getDefaultToolkit().getImage(GamePanel.class.getResource("AWangShen/0.png"))
				,470,360,this);
		g.drawImage(Toolkit.getDefaultToolkit().getImage(GamePanel.class.getResource("AZhu/0.png"))
				,400,300,this);
		g.drawImage(Toolkit.getDefaultToolkit().getImage(GamePanel.class.getResource("Muji/0.png"))
				,350,350,this);
		g.drawImage(Toolkit.getDefaultToolkit().getImage(GamePanel.class.getResource("WangCaiSao/0.png"))
				,600,350,this);
		g.drawImage(Toolkit.getDefaultToolkit().getImage(GamePanel.class.getResource("XiaoHai/0.png"))
				,700,500,this);
		g.drawImage(Toolkit.getDefaultToolkit().getImage(GamePanel.class.getResource("XiaoJi/0.png"))
				,330,370,this);
		g.drawImage(Toolkit.getDefaultToolkit().getImage(GamePanel.class.getResource("XiaoXiaoji/0.png"))
				,300,350,this);
		g.drawImage(Toolkit.getDefaultToolkit().getImage(GamePanel.class.getResource("LiXiaoYao_Down/0.png"))
				,550,270,this);
		
	}
}
