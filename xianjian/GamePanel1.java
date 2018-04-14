package cn.tedu.xianjian;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JPanel;


/*
 * 本类表示游戏项目的自定义画板类，也就是界面
 * @author lousiyi
 * */

//遵循单继承（类）多实现（接口）
public class GamePanel1 extends JPanel implements Runnable,KeyListener,MouseListener{
	
	//------定义图片--------
	int MapID;
	Image endImage;
	Image ljcImages;
	int ljcX,ljcY;
	Image[] ljcscImages;
	int ljcscX,ljcscY,ljcscIndex;
	Image[] awsImages;
	int awsX,awsY,awsIndex;
	Image[] azImages;
	int azX,azY,azIndex;
	Image[] mjImages;
	int mjX,mjY,mjIndex;
	Image[] wcsImages;
	int wcsX,wcsY,wcsIndex;
	Image[] xhImages;
	int xhX,xhY,xhIndex;
	Image[] xjImages;
	int xjX,xjY,xjIndex;
	Image[] xxjImages;
	int xxjX,xxjY,xxjIndex;
	Image[] lxyLImages;
	Image[] lxyRImages;
	Image[] lxyDImages;
	Image[] lxyUImages;
	int lxyX,lxyY,lxyIndex,lxyTurn,FlagSongkai,lxySpeed;
	Image lxyImage;
	int IndexNum;
	//头标
	String[] lxyname;
	int endendpro=0;
	//聊天
	Image ltImage,ltlxyImage,ltawsImage,ltazImage,ltzlrImage,lthsImage,ltlrImage,ltygImage;
	int ltX,ltY,ltwho;//0不聊，1阿旺婶，2阿朱，3赵灵儿，4河神,6boss
	String[] ltMsg,ltawsMsg,ltazMsg,ltzlrMsg,lthsMsg,ltlrMsg,ltygMsg,ltzlrMsg1,ltzlrMsg2;//聊天内容
	int ltawsIndex,ltazIndex,ltzlrIndex,lthsIndex,ltlrIndex,ltygIndex;
	boolean isLtShow;
	//障碍物
	BufferedImage ljcDataMap, ljcscDataMap;
	//野怪boss
	Image[] ygImages;
	int ygX,ygY,ygIndex;
	boolean isygShow;
	Image[] ygImages1;
	int ygX1,ygY1,ygIndex1;
	boolean isygShow1;
	//赵灵儿
	Image zlrRenImage,zlrSheImage;
	int zlrX,zlrY;
	//河神
	Image hsImage;
	int hsX,hsY;
	boolean ishsShow;
	//路人
	Image[] lrImages;
	int lrX,lrY,lrIndex;
	boolean islrShow;
	int endindex=0;
	////
	Image startgameImage;
	int startgx,startgy;
	boolean klis=false;
	int probarx,probary;
	int probarlxyindex;
	//bgm
	private URL url;
	private AudioClip acbcground,acgame;
	boolean isacgame;
	//game
	Image sword;
	Image enemy;
	Image Benemy;
	Image Senemy;
//	int score;
	int swordX, swordY;
	int enemyX, enemyY;
	int moveSpeed;
	int swordSpeed;
	boolean move;
	String[] startMessages = {"愚蠢呢， 就凭你还想打败我？ 我会让你见识到我们之间实力的差距", "按空格键进行攻击"};
	int startIndex;
	String[] successMessages = {"现在要加快了", "我可以再快点！", "还是不行吗，看我变小！", "啊你太强了, 我先闪了 按空格键退出！"};
	String[] failMessages = {"唉，打不到", "唉，还是打不到！", "还是省省吧, 挑战我还早着呢, 按空格键返回"};
	int sucIndex, failIndex;
	boolean gameTip = false; //游戏中的提示框
	boolean tipStart = false;
	boolean gamestart = false;
	boolean gameover = false;
	boolean success;
	Image background;
	boolean isWin=false;
	boolean isygagain=false;
	
	//生命值经验值
	int life,experience;
	///背包
	boolean Isacbcground;
	boolean istqdb;
	boolean isfgsl;
	boolean isdsx;
	boolean isbag;
	int bagx,bagy;
	int kbag=0;
	int rwIndex;
	
	Image bagImage;
	Image tqdbImage;
	Image fgslbImage;
	Image dsxbImage;
	Image fgslljcImage;
	Image dsxljcImage;
	
	boolean ishuoqu1;
	
	boolean renwu1,renwu2;
	
	
	//------初始化-------
	public GamePanel1() {
	
		MapID = 3;
		
		renwu1 = renwu2 = false;
		
//		istqdb = true;
		life =  200;
		experience = 10;
		
		isbag = false;
		rwIndex=1;
		bagx=300;
		bagy=300;
		
		ishuoqu1=false;
		try {
			endImage=ImageIO.read(new File("Legend_of_Sword_and_Fairy/endBgc.png"));
		} catch (IOException e5) {
			e5.printStackTrace();
		}
		try {
			bagImage=ImageIO.read(new File("Legend_of_Sword_and_Fairy/pake/1.png"));
		} catch (IOException e4) {
			e4.printStackTrace();
		}
		try {
			tqdbImage=ImageIO.read(new File("Legend_of_Sword_and_Fairy/pake/TianQingDiBai.png"));
		} catch (IOException e3) {
			e3.printStackTrace();
		}
		try {
			dsxbImage=ImageIO.read(new File("Legend_of_Sword_and_Fairy/pake/DingShenXiang.png"));
		} catch (IOException e3) {
			e3.printStackTrace();
		}
		try {
			fgslbImage=ImageIO.read(new File("Legend_of_Sword_and_Fairy/pake/FuGuangSheLiZi.png"));
		} catch (IOException e3) {
			e3.printStackTrace();
		}
		try {
			dsxljcImage=ImageIO.read(new File("Legend_of_Sword_and_Fairy/pake/2s.png"));
		} catch (IOException e3) {
			e3.printStackTrace();
		}
		try {
			fgslljcImage=ImageIO.read(new File("Legend_of_Sword_and_Fairy/pake/4s.png"));
		} catch (IOException e3) {
			e3.printStackTrace();
		}
		
		//开始页面
		probarlxyindex=0;
		probarx=0;
		probary=35;
		
		try {
			startgameImage=ImageIO.read(new File("Legend_of_Sword_and_Fairy/back/BJ.png"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		startgx=0;startgy=0;
		
		//bgm
		File f1=new File("Legend_of_Sword_and_Fairy/Music/game_music.wav");
		try {
			url=f1.toURL();
		} catch (MalformedURLException e2) {
			e2.printStackTrace();
		}
		acbcground=Applet.newAudioClip(url);
		//acbcground.play();
		acbcground.loop();
		
		File f2=new File("Legend_of_Sword_and_Fairy/Music/music2.wav");
		try {
			url=f2.toURL();
		} catch (MalformedURLException e2) {
			e2.printStackTrace();
		}
		acgame=Applet.newAudioClip(url);
		isacgame = false;
		
		//李家村
		try {
			ljcImages = ImageIO.read(
					new File("Legend_of_Sword_and_Fairy/LiJiaCun/0.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		ljcX = ljcY = -200;
		
		//李家村市场
		ljcscImages = new Image[2];
		for(int i = 0;i < ljcscImages.length;i++){
			try {
				ljcscImages[i] = ImageIO.read(
						new File("Legend_of_Sword_and_Fairy/LiJiaCunShiChang/" + i + ".png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		ljcscX = ljcscY = -200;
		ljcscIndex = 0;

		//阿旺婶
		awsImages = new Image[17];
		for(int i = 0;i < awsImages.length;i++){
			try {
				awsImages[i] = ImageIO.read(
						new File("Legend_of_Sword_and_Fairy/AWangShen/" + i + ".png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		awsX = 860; awsY = 600;
		awsIndex = 0;
		
		//阿朱
		azImages = new Image[6];
		for(int i = 0;i < azImages.length;i++){
			try {
				azImages[i] = ImageIO.read(
						new File("Legend_of_Sword_and_Fairy/AZhu/" + i + ".png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		azX  = 300+200; azY = 330+200;
		azIndex = 0;
		
		//母鸡
		mjImages = new Image[6];
		for(int i = 0;i < mjImages.length;i++){
			try {
				mjImages[i] = ImageIO.read(
						new File("Legend_of_Sword_and_Fairy/MuJi/" + i + ".png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		mjX = 250+200;mjY = 350+200;
		mjIndex = 0;
		
		//旺财嫂
		wcsImages = new Image[14];
		for(int i = 0;i < wcsImages.length;i++){
			try {
				wcsImages[i] = ImageIO.read(
						new File("Legend_of_Sword_and_Fairy/WangCaiSao/" + i + ".png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		wcsX = 800+200; wcsY = 320+200;
		wcsIndex = 0;
		
		//小孩
		xhImages = new Image[4];
		for(int i = 0;i < xhImages.length;i++){
			try {
				xhImages[i] = ImageIO.read(
						new File("Legend_of_Sword_and_Fairy/XiaoHai/" + i + ".png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		xhX = 930+200;xhY = 620+200;
		xhIndex = 0;
		
		//小鸡
		xjImages = new Image[2];
		for(int i = 0;i < xjImages.length;i++){
			try {
				xjImages[i] = ImageIO.read(
						new File("Legend_of_Sword_and_Fairy/XiaoJi/" + i + ".png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		xjX = 300+200;xjY = 440+200;
		xjIndex = 0;
		
		//小小鸡
		xxjImages = new Image[2];
		for(int i = 0;i < xxjImages.length;i++){
			try {
				xxjImages[i] = ImageIO.read(
						new File("Legend_of_Sword_and_Fairy/XiaoXiaoJi/" + i + ".png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		xxjX = 280+200;xxjY = 330+200;
		xxjIndex = 0;
		
		
		//李逍遥
		lxyname = new String[]{"李逍遥"};
		//down
		lxyDImages = new Image[8];
		for(int i = 0;i < lxyDImages.length;i++){
			try {
				lxyDImages[i] = ImageIO.read(
						new File("Legend_of_Sword_and_Fairy/LiXiaoYao_Down/" + i + ".png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		//left
		lxyLImages = new Image[8];
		for(int i = 0;i < lxyLImages.length;i++){
			try {
				lxyLImages[i] = ImageIO.read(
						new File("Legend_of_Sword_and_Fairy/LiXiaoYao_Left/" + i + ".png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		//right
		lxyRImages = new Image[8];
		for(int i = 0;i < lxyRImages.length;i++){
			try {
				lxyRImages[i] = ImageIO.read(
						new File("Legend_of_Sword_and_Fairy/LiXiaoYao_Right/" + i + ".png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		//up
		lxyUImages = new Image[8];
		for(int i = 0;i < lxyUImages.length;i++){
			try {
				lxyUImages[i] = ImageIO.read(
						new File("Legend_of_Sword_and_Fairy/LiXiaoYao_Up/" + i + ".png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		lxyX = 790+200;lxyY = 200+200;
		lxyIndex = 0;
		lxySpeed = 10;
		IndexNum = 0;lxyTurn = 0;FlagSongkai = 0;
		//lxyImage = lxyDImages[lxyDIndex];
		
		//聊天
		try {
			//map1
			ltImage = ImageIO.read(
							new File("Legend_of_Sword_and_Fairy/LiaoTian/0.png"));
			ltlxyImage = ImageIO.read(
					new File("Legend_of_Sword_and_Fairy/Chat/LiXiaoYao.png"));
			ltawsImage = ImageIO.read(
					new File("Legend_of_Sword_and_Fairy/Chat/AWangShen.png"));
			ltazImage = ImageIO.read(
					new File("Legend_of_Sword_and_Fairy/Chat/AZhu.png"));
			//map2
			ltzlrImage =  ImageIO.read(
					new File("Legend_of_Sword_and_Fairy/Chat/ZhaoLingEr.png"));
			lthsImage = ImageIO.read(
					new File("Legend_of_Sword_and_Fairy/Chat/HeShen.png"));
//			ltlrImage = ImageIO.read(
//					new File("Legend_of_Sword_and_Fairy/Chat/AZhu.png"));//////////////
		} catch (IOException e) {
			e.printStackTrace();
		}
		ltawsIndex = ltazIndex = ltzlrIndex = lthsIndex =ltlrIndex = ltygIndex = ltwho = 0;
		ltawsMsg = new String[]{"阿旺婶","逍遥啊","您看到赵灵儿了吗？","赵什么？","赵灵儿",
				"什么灵儿？","赵灵儿","赵什么儿？","阿旺婶,我先走了"};
		
		ltazMsg =new String[]{"阿朱，你看到灵儿了吗？","你找她有事吗？","恩恩",
				"她好像去市场了","好的，阿朱再见！"};
		
		ltzlrMsg = new String[]{"灵儿，你怎么会变成这样？！","我被怪物附体了！","我会救你的！"};
		
		ltzlrMsg1 = new  String[]{"灵儿你怎么样？","我没事了","好的，我们回家吧"};
	
		ltygMsg = new String[]{"RUA！！！！！",
				"啊，完全打不过。",//1
				"逍遥哥哥不要死啊！",//2
				"此时，河边突然出现万丈光芒。",
				"李逍遥，我可以帮助你，但是你要答应我去仙灵岛帮我做一件事。",//4
				"好的，我答应你.",//5
				"李家村的一棵树下有一个天青地白，你找来可以帮你提升法力."};//6
		
		isLtShow = false;
		
		//障碍物
		try {
			ljcDataMap = ImageIO.read(
							new File("Legend_of_Sword_and_Fairy/LiJiaCun/RedMap.png"));
			ljcscDataMap = ImageIO.read(
							new File("Legend_of_Sword_and_Fairy/LiJiaCunShiChang/RedMap.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//boss
		ygImages = new Image[12];
		ygImages1 = new Image[8];
		for(int i = 0;i < ygImages.length;i++){
			try {
				ygImages[i] = ImageIO.read(
									new File("Legend_of_Sword_and_Fairy/YeGuai/"+i+".png"));
			} catch (IOException e) {
					e.printStackTrace();
			}
		}
		for(int i = 0;i < ygImages1.length;i++){
			try {
				ygImages1[i] = ImageIO.read(
									new File("Legend_of_Sword_and_Fairy/Guai/"+i+".png"));
			} catch (IOException e) {
					e.printStackTrace();
			}
		}
		ygX = 1200; ygY = 220;
		ygIndex = 0;
		isygShow = true;
		ygX1 = 1000; ygY1 = 200;
		ygIndex1 = 0;
		
		
		//赵灵儿
		try {
			 zlrRenImage = ImageIO.read(
								new File("Legend_of_Sword_and_Fairy/ZhaoLingEr/ren.png"));
			 zlrSheImage = ImageIO.read(
						new File("Legend_of_Sword_and_Fairy/ZhaoLingEr/she.png"));
		} catch (IOException e) {
				e.printStackTrace();
		}
		zlrX = 780; zlrY = 320;
		
		//河神
		try {
			 hsImage = ImageIO.read(
					 		new File("Legend_of_Sword_and_Fairy/HeShen/0.png"));
		} catch (IOException e) {
				e.printStackTrace();
		}
		hsX = 1200; hsY = 30;
		ishsShow = false;
		
		//路人
		lrImages = new Image[4];
		for(int i = 0;i < lrImages.length;i++){
			try {
				lrImages[i] = ImageIO.read(
									new File("Legend_of_Sword_and_Fairy/LuRen/"+i+".png"));
			} catch (IOException e) {
					e.printStackTrace();
			}
		}
		lrX = 300; lrY = 220;
		lrIndex = 0;
		islrShow = false;
		
		//game
		try {
			sword = ImageIO.read(new File("Legend_of_Sword_and_Fairy/game/sword.png"));
			Senemy = ImageIO.read(new File("Legend_of_Sword_and_Fairy/game/small.png"));
			Benemy = ImageIO.read(new File("Legend_of_Sword_and_Fairy/game/big.png"));
			enemy = Benemy;
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		enemy = Benemy;
		swordX = (1024 - sword.getWidth(null))/2;
		swordY = 720 - sword.getHeight(null);
		swordSpeed = 30;
		enemyX = (1024 - sword.getWidth(null))/2;
		enemyY = 0;
//		score = 0;
		moveSpeed = 20;
		move = true;
		sucIndex = -1;
		failIndex = -1;
		success = false;
		startIndex = 0;
		try {
			background = ImageIO.read(new File("Legend_of_Sword_and_Fairy/game/bgc.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//------绘画方法-------
	public void paint(Graphics g){

		Graphics2D g2d = (Graphics2D)g.create();
		
		ltX = (this.getWidth()-ltImage.getWidth(null))/2; //this的使用要在窗口出现之后才可以
		ltY = (this.getHeight()-ltImage.getHeight(null));
		
		g.setColor(Color.GREEN);
		g.setFont(new Font("微软雅黑",Font.BOLD,16));
		
		
		System.out.println(lxyX+" "+lxyY);
		
		if(MapID == 1){
			//绘画李家村
			if(lxyTurn == 0)
				lxyImage = lxyDImages[lxyIndex];
			else if(lxyTurn == 1)
				lxyImage = lxyLImages[lxyIndex];
			else if(lxyTurn == 2)
				lxyImage = lxyRImages[lxyIndex];
			else if(lxyTurn == 3)
				lxyImage = lxyUImages[lxyIndex];
			
			//补充：更新李家村图片坐标

			ljcX = (this.getWidth() - lxyImage.getWidth(null))/2 - lxyX;
			ljcY = (this.getHeight() - lxyImage.getHeight(null))/2 - lxyY;
			
			//边界判断
			if(ljcX>2){
				ljcX=2;
			}
			if(ljcY>0){
				ljcY=0;
			}
			if(ljcX<-898){
				ljcX=-898;
			}
			if(ljcY<-670){
				ljcY=-670;
			}
			
			if(lxyX<0){
				lxyX=0;
			}
			if(lxyY<0){
				lxyY=0;
			}
			if(lxyX>1860){
				lxyX=1860;
			}
			if(lxyY>1320){
				lxyY=1320;
			}
			
			//画李家村
			g.drawImage(ljcImages, ljcX, ljcY, this);
			//isWin=true;
			if(lxyY>=500&&lxyY<=700&&lxyX>=1650&&lxyX<=1800 && !istqdb && isWin){
				g.drawImage(ltImage, ltX, ltY, this);
			}
			
			if(!istqdb){
				g.drawImage(tqdbImage,1750+ljcX,620+ljcY,this);
			}
			
			
			//画配角
			g.drawImage(awsImages[awsIndex], awsX + ljcX, awsY + ljcY, this);
			g.drawImage(azImages[azIndex], azX + ljcX, azY + ljcY, this);
			g.drawImage(mjImages[mjIndex], mjX + ljcX, mjY + ljcY, this);
			g.drawImage(wcsImages[wcsIndex], wcsX + ljcX, wcsY + ljcY, this);
			g.drawImage(xhImages[xhIndex], xhX + ljcX, xhY + ljcY, this);
			g.drawImage(xjImages[xjIndex], xjX + ljcX, xjY + ljcY, this);
			g.drawImage(xxjImages[xxjIndex], xxjX + ljcX, xxjY + ljcY, this);
			g.drawImage(lxyImage, lxyX + ljcX, lxyY + ljcY, this);
			g.drawString(lxyname[0], lxyX+lxyImage.getWidth(null)/2-20+ ljcX, lxyY + ljcY);
			
			
			g.drawString(lxyname[0], lxyX+lxyImage.getWidth(null)/2-20+ ljcX, lxyY + ljcY);
			
			
			
			
			//聊天,空格按键控制聊天出现和消失
			if(isLtShow){  //&&Math.abs(lxyX-awsX)<50&&Math.abs(lxyY-awsY)<30
				
				g.drawImage(ltImage, ltX, ltY, this);
				g.setColor(Color.ORANGE);
				g.setFont(new Font("微软雅黑",Font.BOLD,30));
				
				if(ltwho == 1){  //aws
					g.drawImage(ltImage, ltX, ltY, this);
					g.drawString(ltawsMsg[ltawsIndex],ltX+100, ltY+50);
					if(ltawsIndex%2 != 0){
						g.drawImage(ltawsImage, ltX-130, ltY-50, this);
					}else{
						g.drawImage(ltlxyImage, ltX+ltImage.getWidth(null)-170, ltY-50, this);
					}
				}else if(ltwho == 2){
					g.drawImage(ltImage, ltX, ltY, this);
					g.drawString(ltazMsg[ltazIndex],ltX+100, ltY+50);
					if(ltazIndex%2!=0){
						g.drawImage(ltazImage, ltX-130, ltY-50, this);
					}else{
						g.drawImage(ltlxyImage, ltX+ltImage.getWidth(null)-170, ltY-50, this);
					}
				}

			}
			
			
		}
		else if(MapID == 2){
			
			//绘画李家村市场
			if(lxyTurn == 0)
				lxyImage = lxyDImages[lxyIndex];
			else if(lxyTurn == 1)
				lxyImage = lxyLImages[lxyIndex];
			else if(lxyTurn == 2)
				lxyImage = lxyRImages[lxyIndex];
			else if(lxyTurn == 3)
				lxyImage = lxyUImages[lxyIndex];
			
			
			
			ljcscX = (this.getWidth() - lxyImage.getWidth(null))/2 - lxyX;
			ljcscY = (this.getHeight() - lxyImage.getHeight(null))/2 - lxyY;
			
			
			//边界判断
			if(ljcscX>2){
				ljcscX=2;
			}
			if(ljcscY>0){
				ljcscY=0;
			}
			if(ljcscX<-898){
				ljcscX=-898;
			}
			if(ljcscY<-450){
				ljcscY=-450;
			}
			
			if(lxyX<0){
				lxyX=0;
			}
			if(lxyY<0){
				lxyY=0;
			}
			if(lxyX>1860){
				lxyX=1860;
			}
			if(lxyY>1070){
				lxyY=1070;
			}
			
			g.drawImage(ljcscImages[ljcscIndex], ljcscX, ljcscY, this);
			
			
			if(!isdsx){
				g.drawImage(dsxljcImage, ygX + ygImages[ygIndex].getWidth(null)/2 + ljcscX, ygY + ygImages[ygIndex].getHeight(null)/2 + ljcscY, this);
				
			}
			
			if(!isfgsl)
			g.drawImage(fgslljcImage, ygX + ygImages[ygIndex].getWidth(null)/2 + ljcscX - 20, ygY + ygImages[ygIndex].getHeight(null)/2 + ljcscY , this);
			
			
			
			if(isygShow&&!isWin){
				g.drawImage(ygImages[ygIndex], ygX + ljcscX, ygY + ljcscY, this);
				
				g.drawImage(zlrSheImage, zlrX + ljcscX, zlrY + ljcscY, this);
			}else {
				if(!ishuoqu1){
					g.setColor(Color.ORANGE);
					g.setFont(new Font("微软雅黑",Font.BOLD,30));
					g.drawImage(ltImage, ltX, ltY, this);
					//g.drawString("发现怪物掉落的佛光舍利子和定神香，点击1拾取",ltX+100, ltY+50);
					String[] slMsg = new String[]{"发现怪物掉落的佛光舍利子和定神香，点击1拾取"};
					int h = slMsg[0].length();
					int j,d,l;
					int k=0;
					d = h%16;
					l = h/16;
					if(d==0){
						for(j=0;j<l;j++)
						{
							g.drawString(slMsg[0].substring(k,k+16),ltX+100, ltY+50+(40*j));
							k+=16;
						}
					}
					else{
						for(j=0;j<l;j++)
						{
							g.drawString(slMsg[0].substring(k,k+16),ltX+100, ltY+50+(40*j));
							k+=16;
							}
							g.drawString(slMsg[0].substring(k,h),ltX+100, ltY+50+(40*j));
					}
				}
				
				g.drawImage(zlrRenImage, zlrX + ljcscX, zlrY + ljcscY, this);
			}
			g.drawString(lxyname[0], lxyX+lxyImage.getWidth(null)/2-20 + ljcscX, lxyY + ljcscY);
			
			
			g.drawImage(lxyImage, lxyX + ljcscX, lxyY + ljcscY, this);
			
			
			
			//聊天
			if(isLtShow){
				
				g.setColor(Color.ORANGE);
				g.setFont(new Font("微软雅黑",Font.BOLD,30));
				if(ltwho == 3){//zlr
					if(isygShow){
						g.drawImage(ltImage, ltX, ltY, this);
						g.drawImage(ltImage, ltX, ltY, this);
						g.drawString(ltzlrMsg[ltzlrIndex],ltX+100, ltY+50);
						if(ltzlrIndex%2!=0){
							g.drawImage(ltzlrImage, ltX-130, ltY-50, this);
						}else{
							g.drawImage(ltlxyImage, ltX+ltImage.getWidth(null)-170, ltY-50, this);
						}
					}else {
						g.drawImage(ltImage, ltX, ltY, this);
						g.drawImage(ltImage, ltX, ltY, this);
						g.drawString(ltzlrMsg1[ltzlrIndex],ltX+100, ltY+50);
						if(ltzlrIndex%2!=0){
							g.drawImage(ltzlrImage, ltX-130, ltY-50, this);
						}else{
							g.drawImage(ltlxyImage, ltX+ltImage.getWidth(null)-170, ltY-50, this);
						}
					}
						
				}else if(ltwho == 4){//heshen
					g.drawImage(ltImage, ltX, ltY, this);
					g.drawImage(ltImage, ltX, ltY, this);
					g.drawString(lthsMsg[lthsIndex],ltX+100, ltY+50);
					if(lthsIndex%2!=0){
						g.drawImage(lthsImage, ltX-130, ltY-50, this);
					}else{
						g.drawImage(ltlxyImage, ltX+ltImage.getWidth(null)-170, ltY-50, this);
					}
				}else if(ltwho == 5){//luren
					g.drawImage(ltImage, ltX, ltY, this);
					g.drawImage(ltImage, ltX, ltY, this);
					g.drawString(ltlrMsg[ltlrIndex],ltX+100, ltY+50);
					if(ltlrIndex%2!=0){
						g.drawImage(ltlrImage, ltX-130, ltY-50, this);
					}else{
						g.drawImage(ltlxyImage, ltX+ltImage.getWidth(null)-170, ltY-50, this);
					}
				}else if(ltwho == 6 && isygShow && !isygagain){//yeguai
					g.drawImage(ltImage, ltX, ltY, this);
					g.drawImage(ltImage, ltX, ltY, this);
					int h =ltygMsg[ltygIndex].length();
					int j,d,l;
					int k=0;
					d = h%16;
					l = h/16;
					if(d==0){
						for(j=0;j<l;j++)
						{
							g.drawString(ltygMsg[ltygIndex].substring(k,k+16),ltX+100, ltY+50+(40*j));
							k+=16;
						}
					}
					else{
						for(j=0;j<l;j++)
						{
							g.drawString(ltygMsg[ltygIndex].substring(k,k+16),ltX+100, ltY+50+(40*j));
							k+=16;
						}
						g.drawString(ltygMsg[ltygIndex].substring(k,h),ltX+100, ltY+50+(40*j));
					}
					
					if(ltygIndex == 1 || ltygIndex == 5){
						g.drawImage(ltlxyImage, ltX+ltImage.getWidth(null)-170, ltY-50, this);					
					}else if(ltygIndex == 2){
						g.drawImage(ltzlrImage, ltX-130, ltY-50, this);
					}else if(ltygIndex == 4|| ltygIndex == 6){
						g.drawImage(lthsImage, ltX-160, ltY-50, this);
					}
					
				}
				
				if(ishsShow && !isygagain)
				g.drawImage(hsImage, hsX + ljcscX, hsY + ljcscY, this);
				
			}
				
		}else if(MapID==3){
			g.drawImage(startgameImage, startgx, startgy, this);
			Color color=new Color(255,240,245);
			g2d.setColor(color);
			if(klis==false)
			{
				g2d.fillRoundRect(400, 500, 220, 70, 20, 20);
				g2d.setColor(Color.black);
				g2d.setFont(new Font("楷体",Font.BOLD,40));
				g2d.drawString("开始游戏", 420, 550);
			}
			if(klis)
			{
				g.drawImage(lxyRImages[probarlxyindex],probarx+120,
						669-lxyRImages[probarlxyindex].getHeight(null)-14, this);
				g2d.drawRoundRect(150, 650, 700, 20, 20, 20);
				g2d.fillRoundRect(150, 651, probarx, 19, 20, 20);
				
			}
			
		}else if(MapID==4){
			g.drawImage(startgameImage, startgx, startgy, this);
			
		}else if(MapID==5){
			if(!isacgame){
				acbcground.stop();
				acgame.loop();
				isacgame = true;
			}
			ltX = (this.getWidth() - ltImage.getWidth(null))/2;
			ltY =  this.getHeight() - ltImage.getHeight(null);
			g.setColor(Color.ORANGE);
			g.setFont(new Font("微软雅黑", Font.BOLD, 20));
			g.drawImage(background, 0, 0, this);
			g.drawImage(sword, swordX, swordY, this);
			g.drawImage(enemy, enemyX, enemyY, this);
			g.drawImage(lxyDImages[lxyIndex], 400, 620, this);
			if (!gamestart) {
				g.drawImage(ltImage, ltX, ltY, this);
				g.drawString(startMessages[startIndex], ltX + 40, ltY + 40);
			} else {

				if (gameTip) {
					g.drawImage(ltImage, ltX, ltY, this);
					if (success) {
						g.drawString(successMessages[sucIndex], ltX + 40, ltY + 40);
					} else {
						g.drawString(failMessages[failIndex], ltX + 40, ltY + 40);
					}
				}
			
			}
			
		}else if(MapID == 6){
			g.drawImage(startgameImage, startgx, startgy, this);
		}else if(MapID==7){
			g.drawImage(endImage, startgx, startgy, this);
			g.drawImage(lxyRImages[endindex],endendpro+120,
			669-lxyRImages[endindex].getHeight(null)-14, this);
		}
		if(isbag)
		{
			int a=20,b=40;
			g.drawImage(bagImage, bagx, bagy, this);
			
			g2d.setFont(new Font("楷体",Font.BOLD,16));
			if(isfgsl)
			{
				g.drawImage(fgslbImage,bagx-100,bagy+40,this);
				g2d.drawString("佛光舍利",bagx+20,bagy+210);
				if(kbag++<3)
				{
					if(a>160)
					{
						a=20;
						b+=100;
					}
					else {
						a+=90;
					}
				}
				
			}
			if(istqdb)
			{
				g.drawImage(tqdbImage,bagx+30,bagy+60,this);
				g2d.drawString("天青地白",bagx+20,bagy+120);
				if(kbag++<3)
				{
					if(a>160)
					{
						a=20;
						b+=100;
					}
					else {
						a+=90;
					}
				}
			}
			if(isdsx){
				g.drawImage(dsxbImage,bagx+50,bagy-40,this);
				g2d.drawString("定神香",bagx+180,bagy+40+80);
				if(kbag++<3)
				{
					if(a>160)
					{
						a=20;
						b+=100;
					}
					else {
						a+=90;
					}
				}
			}
		}
		if(MapID ==  1|| MapID == 2|| MapID ==5){
			g2d.setFont(new Font("楷体",Font.BOLD,14));
			g2d.setColor(Color.green);
			g2d.drawString("生命值", 20, 20);
			g2d.drawString("经验值", 20, 70);
			g2d.setColor(Color.white);
			g2d.fillRect(20,30 , 200, 12);
			g2d.fillRect(20,80 , 200, 12);
			g2d.setColor(Color.blue);
			g2d.fillRect(20,30 , life, 12);
			g2d.fillRect(20,80 , experience, 12);
		}
	}
	
	//--------运动方法，循环修改图片-------
	public void run() {
		while(true){
			IndexNum++;
			
			if(endindex<8)
				endindex++;
			else {
				endindex=0;
			}
			if(klis){
				probarx+=5;
			}
			
			if(endendpro<1000&&MapID ==7)
				endendpro+=5;
			
			if(probarx==700){
				MapID=1;
			}
			if(IndexNum % 2 == 0){
				awsIndex++;
			}
			probarlxyindex++;
			if(probarlxyindex>lxyRImages.length)
				probarlxyindex=0;
			
			if(IndexNum % 2 == 0){
				awsIndex++;
			}
			
			if(IndexNum % 3==0){
				ljcscIndex++;
			}
			if(ljcscIndex == 2){
				ljcscIndex = 0;
			}
			
			if(awsIndex >= awsImages.length){
				awsIndex = 0;
			}
			
			azIndex++;
			if(azIndex >= azImages.length){
				azIndex = 0;
			}
			
			mjIndex++;
			if(mjIndex >= mjImages.length){
				mjIndex = 0;
			}
			
			if(IndexNum % 2 == 0){
				wcsIndex++;
			}
			if(wcsIndex >= wcsImages.length){
				wcsIndex = 0;
			}
			
			xhIndex++;
			if(xhIndex >= xhImages.length){
				xhIndex = 0;
			}
			
			xjIndex++;
			if(xjIndex >= xjImages.length){
				xjIndex = 0;
			}
			
			xxjIndex++;
			if(xxjIndex >= xxjImages.length){
				xxjIndex = 0;
			}
			
			if(FlagSongkai == 1)
			lxyIndex++;
			if(lxyIndex >= lxyDImages.length){
				lxyIndex = 0;
			}
			
			if(isygShow){
				ygIndex++;
				if(ygIndex >= ygImages.length){
					ygIndex = 0;
				}
			}
			
			
			

			lrIndex++;
			if(lrIndex >= lrImages.length){
				lrIndex=0;
			}
			
			
			
			
			//game
			
				if (sucIndex >= -1) {
					// 在加入个开场对白
					if (move) {
						enemyX += moveSpeed;
						if (enemyX + sword.getWidth(null) >= 930
							|| enemyX <= 0	) {
							moveSpeed *= -1;
						} 
					} else {
						swordY -= swordSpeed;
					}
					if ((swordY >= enemy.getHeight(null) && swordY <= 0) || (swordY < 0 && swordY + sword.getHeight(null) >= 0)) {
						move = !move;
						swordY = 720 - sword.getHeight(null);
						int x = swordX + sword.getWidth(null)/2;
						if (x >= (enemyX) && x <= (enemyX + enemy.getWidth(null))) {
	//						System.out.println(true);
							success = true;
							tipStart = true;
//							score++;
							gameTip = true;
							sucIndex++;
							if (sucIndex == 2) {
								enemy = Senemy;//isWin = true;//f = false;gameover = true;///////////////////////////////
							} else if (sucIndex == 3) {
								gameover = true;
								isWin = true;
								System.out.println("win");
							}
//							else if (sucIndex > 3) {
//								sucIndex = -1;
//								gamestart = false;
//								gameTip = false;
//							}
 							if (moveSpeed > 0) {
								moveSpeed += 10;
							} else {
								moveSpeed -= 10;
							}
	//						swordY = 720 - sword.getHeight(null);;
							
						} else {
							life -= 1;
							success = false;
							gameTip = true;
							failIndex++;
							if (failIndex == 2) {
								gameover = true;
								//isWin = false;
							}
							System.out.println(false);
						}
					}
				}
			//}
			
			//停顿操作
			try {
				Thread.sleep(130);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			//重绘
			repaint();
		}
		
	}

	
	//---------键盘动作-------
	public void keyPressed(KeyEvent e) {
		//if(MapID == 1){
			//上下左右：38,40,37,39；WSAD：87,83,65,68
			if(isLtShow){
				if(ltwho == 1){
					if(e.getKeyCode()==KeyEvent.VK_SPACE){
						ltawsIndex++;
						if(ltawsIndex >= ltawsMsg.length){
							ltawsIndex = 0;
							ltwho = 0;
							isLtShow = false;
						}
					}
				}else if(ltwho == 2){
					if(e.getKeyCode()==KeyEvent.VK_SPACE){
						ltazIndex++;
						if(ltazIndex >= ltazMsg.length){
							ltazIndex = 0;
							ltwho = 0;
							isLtShow = false;
						}
					}
				}else if(ltwho == 3){
					if(e.getKeyCode()==KeyEvent.VK_SPACE){
						ltzlrIndex++;
						if(ltzlrIndex >= ltzlrMsg.length){
							ltzlrIndex = 0;
							ltwho = 0;
							isLtShow = false;
							if(!isygShow&&!isWin){
								MapID = 4;
							}
						}
					}
				}else if(ltwho == 4){
					
				}else if(ltwho == 5){
					
				}else if(ltwho == 6){
					if(e.getKeyCode()==KeyEvent.VK_SPACE){
						if(isLtShow){
							ltygIndex++;
						}
						if(ltygIndex == 4){
							ishsShow = true;
						}
						
						if(isWin){
							experience+=20;
							isygShow = false;
							gameover = true;
							gamestart = false;
						}
						
						if(ltygIndex >= ltygMsg.length){
							ltygIndex = 1;//ltygMsg.length;
							ltygMsg = new String[]{};
							ltwho = 0;
							isygagain = true;
							isLtShow = false;
							ishsShow = false;
							
							//acbcground.stop();
							if(istqdb)
							MapID = 5;
						}
						
					}
				}
				
			}else{
				
				int x,y,x1,x2,y1,y2;
				//李逍遥的移动+聊天开始的判断+切换场景的判断
				
				//game
				if (!gamestart && MapID == 5) {
					if (e.getKeyCode() == 32) {
						startIndex++;
						if (startIndex >= 2) {
							gamestart = true;
						}
					}
				} else {			
					if (!gameover) {
						if (move && e.getKeyCode() == 32) {
							if (tipStart) {
								gameTip = false;
							}
							move = !move;
						}
					} else {
						if (e.getKeyCode() == 32) {
							sucIndex = -1;
							moveSpeed = 20;
							failIndex = -1;
							gamestart = false;
							gameTip = false;
							gameover = false;
							gameTip = false;
							startIndex = 0;
							success = false;
							move = true;
							enemy = Benemy;
							MapID = 2;
							if(isacgame){
								acgame.stop();
								isacgame = false;
								acbcground.loop();
							}
						}
					}
				}
				
				if(e.getKeyCode() == KeyEvent.VK_UP){
					lxyY -= lxySpeed;
					//ljcY +=lxySpeed;
					
					lxyTurn = 3;
					FlagSongkai = 1;
					
					//判断李逍遥是否进入障碍物区域-----if李逍遥脚上的颜色 ==红色
					x = lxyX + lxyImage.getWidth(null)/2;
					y = lxyY + lxyImage.getHeight(null);
					
					
					if(MapID == 1 && ljcDataMap.getRGB(x, y) == -521461){
						lxyY += lxySpeed;
						//李逍遥回退操作
						/*lxyIndex--;
						if(lxyIndex <= -1){
							lxyIndex = 7;
						}
						lxyImage = lxyUImages[lxyIndex];*/
					}else if(MapID == 2 && ljcscDataMap.getRGB(x, y) == -65536){
						lxyY += lxySpeed;
					}
					
					//判断李逍遥是否进入配角附近
					if(MapID == 1){
						//wcs
						y1 = y + lxyImage.getHeight(null);
						y2 = wcsY + wcsImages[wcsIndex].getHeight(null);
						x1 = wcsX;
						x2 = wcsX + wcsImages[wcsIndex].getWidth(null);
						if(y-20<=y2 && y1-20>=y2 && x>=x1 &&x<=x2){
							lxyY += lxySpeed;
						}
						//aws
						y1 = y + lxyImage.getHeight(null);
						y2 = awsY + awsImages[awsIndex].getHeight(null);
						x1 = awsX;
						x2 = awsX + awsImages[awsIndex].getWidth(null);
						if(y-20<=y2 && y1-40>=y2 && x>=x1 &&x<=x2){
							lxyY += lxySpeed;
						}
						//az
						y1 = y + lxyImage.getHeight(null);
						y2 = azY + azImages[azIndex].getHeight(null);
						x1 = azX;
						x2 = azX + azImages[azIndex].getWidth(null);
						if(y-20<=y2 && y1-40>=y2 && x>=x1 &&x<=x2){
							lxyY += lxySpeed;
						}
						//mj
						y1 = y + lxyImage.getHeight(null);
						y2 = mjY + mjImages[mjIndex].getHeight(null);
						x1 = mjX;
						x2 = mjX + mjImages[mjIndex].getWidth(null);
						if(y-20<=y2 && y1-40>=y2 && x>=x1 &&x<=x2){
							lxyY += lxySpeed;
						}
						//xh
						y1 = y + lxyImage.getHeight(null);
						y2 = xhY + xhImages[xhIndex].getHeight(null);
						x1 = xhX;
						x2 = xhX + xhImages[xhIndex].getWidth(null);
						if(y-20<=y2 && y1-40>=y2 && x>=x1 &&x<=x2){
							lxyY += lxySpeed;
						}
						//xj
						y1 = y + lxyImage.getHeight(null);
						y2 = xjY + xjImages[xjIndex].getHeight(null);
						x1 = xjX;
						x2 = xjX + xjImages[xjIndex].getWidth(null);
						if(y-20<=y2 && y1-40>=y2 && x>=x1 &&x<=x2){
							lxyY += lxySpeed;
						}
						//xxj
						y1 = y + lxyImage.getHeight(null);
						y2 = xxjY + xxjImages[xxjIndex].getHeight(null);
						x1 = xxjX;
						x2 = xxjX + xxjImages[xxjIndex].getWidth(null);
						if(y-20<=y2 && y1-40>=y2 && x>=x1 &&x<=x2){
							lxyY += lxySpeed;
						}
					}else if(MapID == 2){
						//boss
						if(isygShow && !isWin){
							y1 = y + lxyImage.getHeight(null);
							y2 = ygY + ygImages[ygIndex].getHeight(null);
							x1 = ygX;
							x1=ygX1;
							x2 = ygX + ygImages[ygIndex].getWidth(null);
							if(y-20<=y2 && y1-20>=y2 && x>=x1 &&x<=x2){
								lxyY += lxySpeed;
							}
						}
							
						//zlr
						y1 = y + lxyImage.getHeight(null);
						y2 = zlrY + zlrSheImage.getHeight(null);
						x1 = zlrX;
						x2 = zlrX + zlrSheImage.getWidth(null);
						if(y-20<=y2 && y1-20>=y2 && x>=x1 &&x<=x2){
							lxyY += lxySpeed;
						}
					}
					
				}
				else if(e.getKeyCode() == KeyEvent.VK_LEFT){
					lxyX -= lxySpeed;
					
					lxyTurn = 1;
					FlagSongkai = 1;
					
					x = lxyX + lxyImage.getWidth(null)/2;
					y = lxyY + lxyImage.getHeight(null);
					if(MapID == 1 && ljcDataMap.getRGB(x, y) == -521461){
						lxyX += lxySpeed;
					}else if(MapID == 2 && ljcscDataMap.getRGB(x, y) == -65536){
						lxyX += lxySpeed;
					}
					
					if(MapID == 1){
						//wcs
						x1 = lxyX + lxyImage.getWidth(null);
						x2 = wcsX + wcsImages[wcsIndex].getWidth(null);
						y1 = wcsY + wcsImages[wcsIndex].getHeight(null)/2;
						y2 = wcsY + wcsImages[wcsIndex].getHeight(null);
						if(x-20<=x2 && x2-40<x1 && y>=y1 &&y<=y2){
							lxyX += lxySpeed;
						}
						//aws
						x2 = awsX + awsImages[awsIndex].getWidth(null);
						y1 = awsY + awsImages[awsIndex].getHeight(null)/2;
						y2 = awsY + awsImages[awsIndex].getHeight(null);
						if(x-20<=x2 && x2-40<x1 && y>=y1 &&y<=y2){
							lxyX += lxySpeed;
						}
						//az
						x2 = azX + azImages[azIndex].getWidth(null);
						y1 = azY + azImages[azIndex].getHeight(null)/2;
						y2 = azY + azImages[azIndex].getHeight(null);
						if(x-20<=x2 && x2-40<x1 && y>=y1 &&y<=y2){
							lxyX += lxySpeed;
						}
						//mj
						x2 = mjX + mjImages[mjIndex].getWidth(null);
						y1 = mjY + mjImages[mjIndex].getHeight(null)/2;
						y2 = mjY + mjImages[mjIndex].getHeight(null);
						if(x-20<=x2 && x2-40<x1 && y>=y1 &&y<=y2){
							lxyX += lxySpeed; 
						}
						//xh
						x2 = xhX + xhImages[xhIndex].getWidth(null);
						y1 = xhY + xhImages[xhIndex].getHeight(null)/2;
						y2 = xhY + xhImages[xhIndex].getHeight(null);
						if(x-20<=x2 && x2-40<x1 && y>=y1 &&y<=y2){
							lxyX += lxySpeed;
						}
						//xj
						x2 = xjX + xjImages[xjIndex].getWidth(null);
						y1 = xjY + xjImages[xjIndex].getHeight(null)/2;
						y2 = xjY + xjImages[xjIndex].getHeight(null);
						if(x-20<=x2 && x2-40<x1 && y>=y1 &&y<=y2){
							lxyX += lxySpeed;
						}
						//xxj
						x2 = xxjX + xxjImages[xxjIndex].getWidth(null);
						y1 = xxjY + xxjImages[xxjIndex].getHeight(null)/2;
						y2 = xxjY + xxjImages[xxjIndex].getHeight(null);
						if(x-20<=x2 && x2-40<x1 && y>=y1 &&y<=y2){
							lxyX += lxySpeed;
						}
					}else if(MapID == 2){
						//zlr
						x1 = lxyX + lxyImage.getWidth(null);
						x2 = zlrX + zlrSheImage.getWidth(null);
						y1 = zlrY + zlrSheImage.getHeight(null)/2;
						y2 = zlrY + zlrSheImage.getHeight(null);
						if(x-20<=x2 && x2-40<x1 && y>=y1 &&y<=y2){
							lxyX += lxySpeed;
							if(isWin){
								MapID = 7;
							}
						}
						//boos
						//System.out.println("hello  "+isWin);
						if(isygShow && !isWin){
							x2 = ygX + ygImages[ygIndex].getWidth(null);
							y1 = ygY + ygImages[ygIndex].getHeight(null)/2;
							y2 = ygY + ygImages[ygIndex].getHeight(null);
							if(x-20<=x2 && x2-40<x1 && y>=y1 &&y<=y2){
								lxyX += lxySpeed;
							}
						}
					}
					
				}
				else if(e.getKeyCode() == KeyEvent.VK_RIGHT){
					lxyX += lxySpeed;
					
					lxyTurn = 2;
					FlagSongkai = 1;
					
					x = lxyX + lxyImage.getWidth(null)/2;
					y = lxyY + lxyImage.getHeight(null);
					if(ljcDataMap.getRGB(x, y) == -521461&&MapID == 1){
						lxyX -= lxySpeed;
					}else if(MapID == 2 && ljcscDataMap.getRGB(x, y) == -65536){
						lxyX -= lxySpeed;
					}
					
					if(MapID == 1){
						//wcs
						x1 = lxyX;
						x2 = wcsX;
						y1 = wcsY + wcsImages[wcsIndex].getHeight(null)/3;
						y2 = wcsY + wcsImages[wcsIndex].getHeight(null);
						if(x>=x2 && x1<x2 && y>=y1 &&y<=y2){
							lxyX -= lxySpeed;
						}
						//aws
						x2 = awsX;
						y1 = awsY + awsImages[awsIndex].getHeight(null)/3;
						y2 = awsY + awsImages[awsIndex].getHeight(null);
						if(x>=x2 && x1<x2 && y>=y1 &&y<=y2){
							lxyX -= lxySpeed;
						}
						//az
						x2 = azX;
						y1 = azY + azImages[azIndex].getHeight(null)/3;
						y2 = azY + azImages[azIndex].getHeight(null);
						if(x>=x2 && x1<x2 && y>=y1 &&y<=y2){
							lxyX -= lxySpeed;
						}
						//mj
						x2 = mjX;
						y1 = mjY + mjImages[mjIndex].getHeight(null)/3;
						y2 = mjY + mjImages[mjIndex].getHeight(null);
						if(x>=x2 && x1<x2 && y>=y1 &&y<=y2){
							lxyX -= lxySpeed;
						}
						//xh
						x2 = xhX;
						y1 = xhY + xhImages[xhIndex].getHeight(null)/3;
						y2 = xhY + xhImages[xhIndex].getHeight(null);
						if(x>=x2 && x1<x2 && y>=y1 &&y<=y2){
							lxyX -= lxySpeed;
						}
						//xj
						x2 = xjX;
						y1 = xjY + xjImages[xjIndex].getHeight(null)/3;
						y2 = xjY + xjImages[xjIndex].getHeight(null);
						if(x>=x2 && x1<x2 && y>=y1 &&y<=y2){
							lxyX -= lxySpeed;
						}
						//xxj
						x2 = xxjX;
						y1 = xxjY + xxjImages[xxjIndex].getHeight(null)/3;
						y2 = xxjY + xxjImages[xxjIndex].getHeight(null);
						if(x>=x2 && x1<x2 && y>=y1 &&y<=y2){
							lxyX -= lxySpeed;
						}
					}else if(MapID == 2){
						//boss
						x1 = lxyX;
						if(isygShow && !isWin){
							
							x2 = ygX;
							y1 = ygY + ygImages[ygIndex].getHeight(null)/3;
							y2 = ygY + ygImages[ygIndex].getHeight(null);
							if(x>=x2 && x1<x2 && y>=y1 &&y<=y2){
								lxyX -= lxySpeed;
							}
						}
						//zlr
						x2 = lxyX;
						y1 = zlrY + zlrRenImage.getHeight(null)/3;
						y2 = zlrY + zlrRenImage.getHeight(null);
						if(x>=x2 && x1<x2 && y-20>=y1 &&y-20<=y2){
							lxyX -= lxySpeed;
						}
						
					}
					
				}
				else if(e.getKeyCode() == KeyEvent.VK_DOWN){
					lxyY += lxySpeed;
					
					lxyTurn = 0;
					FlagSongkai = 1;
					
					x = lxyX + lxyImage.getWidth(null)/2;
					y = lxyY + lxyImage.getHeight(null);
					if(ljcDataMap.getRGB(x, y) == -521461&&MapID == 1){
						lxyY -= lxySpeed;
					}else if(MapID == 2 && ljcscDataMap.getRGB(x, y) == -65536){
						lxyY -= lxySpeed;
					}
					
					if(MapID == 1){
						//wcs
						y1 = lxyY;
						y2 = wcsY + wcsImages[wcsIndex].getHeight(null)/3;
						x1 = wcsX;
						x2 = wcsX + wcsImages[wcsIndex].getWidth(null);
						if(y>=y2 && y1<wcsY && x>=x1 && x<=x2){
							lxyY -= lxySpeed;
						}
						//aws
						y2 = awsY + awsImages[awsIndex].getHeight(null)/3;
						x1 = awsX;
						x2 = awsX + awsImages[awsIndex].getWidth(null);
						if(y>=y2 && y1<awsY && x>=x1 && x<=x2){
							lxyY -= lxySpeed;
						}
						//az
						y2 = azY + azImages[azIndex].getHeight(null)/3;
						x1 = azX;
						x2 = azX + azImages[azIndex].getWidth(null);
						if(y>=y2 && y1<azY && x>=x1 && x<=x2){
							lxyY -= lxySpeed;
						}
						//mj
						y2 = mjY + mjImages[mjIndex].getHeight(null)/3;
						x1 = mjX;
						x2 = mjX + mjImages[mjIndex].getWidth(null);
						if(y>=y2 && y1<mjY && x>=x1 && x<=x2){
							lxyY -= lxySpeed;
						}
						//xh
						y2 = xhY + xhImages[xhIndex].getHeight(null)/3;
						x1 = xhX;
						x2 = xhX + xhImages[xhIndex].getWidth(null);
						if(y>=y2 && y1<xhY && x>=x1 && x<=x2){
							lxyY -= lxySpeed;
						}
						//xj
						y2 = xjY + xjImages[xjIndex].getHeight(null)/3;
						x1 = xjX;
						x2 = xjX + xjImages[xjIndex].getWidth(null);
						if(y>=y2 && y1<xjY && x>=x1 && x<=x2){
							lxyY -= lxySpeed;
						}
						//xxj
						y2 = xxjY + xxjImages[xxjIndex].getHeight(null)/3;
						x1 = xxjX;
						x2 = xxjX + xxjImages[xxjIndex].getWidth(null);
						if(y>=y2 && y1<xxjY && x>=x1 && x<=x2){
							lxyY -= lxySpeed;
						}
					}
					
					
				}
				else if(e.getKeyCode() == KeyEvent.VK_SPACE){
					x = lxyX + lxyImage.getWidth(null)/2;
					y = lxyY + lxyImage.getHeight(null);
					if(MapID == 1){
						//阿旺婶聊天
						x2 = awsX + awsImages[awsIndex].getWidth(null)+40;
						y2 = awsY + awsImages[awsIndex].getHeight(null)+40;
						x1 = x2-60;
						y1 = y2-60;
						if(lxyTurn==1 && x>=x1 && x<=x2 && y>=y1 &&y<=y2){
							isLtShow=!isLtShow;
							ltwho = 1;
						}
						//阿朱聊天
						x2 = azX + azImages[azIndex].getWidth(null)+40;
						y2 = azY + azImages[azIndex].getHeight(null)+40;
						x1 = x2-60;
						y1 = y2-60;
						if(lxyTurn==1 && x>=x1 && x<=x2 && y>=y1 &&y<=y2){
							isLtShow=!isLtShow;
							ltwho = 2;
						}
					}else if(MapID == 2){
						//赵灵儿聊天
						x2 = zlrX + zlrSheImage.getWidth(null) +40;
						y2 = zlrY + zlrSheImage.getHeight(null)+40;
						x1 = x2-60;
						y1 = y2-60;
						if(lxyTurn==1 && x>=x1 && x<=x2 && y>=y1 &&y<=y2){
							isLtShow=!isLtShow;
							ltwho = 3;
						}
						//李逍遥被boss打，boss部分的说话
						x2 = ygX + ygImages[ygIndex].getWidth(null);
						y2 = y1 + 100;
						x1 = ygX;
						y1 = ygY + ygImages[ygIndex].getHeight(null);
						if(lxyTurn==3 && x>=x1 && x<=x2 && y>=y1 &&y<=y2 && isygShow && !isWin){
							isLtShow=!isLtShow;
							ltwho = 6;
						}
					}
					
				}
				else if(e.getKeyCode() == KeyEvent.VK_ENTER){
					//if在哪个场景  && 李逍遥方向 && 李逍遥某一点是否进入切换场景的区域
					x = lxyX;
					y = lxyY + lxyImage.getHeight(null);
					x2 = 30; 
					y2 = 800;
					x1 = x2 - 30; 
					y1 = y2 - 80;
					if(MapID == 1 && lxyTurn == 1 && x>=x1 && x<=x2 && y>=y1 &&y<=y2){
						//接下来的场景是哪个
						MapID = 2;
						////lxyX=;lxyY=;
						//切换写一个场景
						lxyTurn = 2;
					}
					else if(MapID == 2 && lxyTurn == 1 && x>=x1 && x<=x2 && y>=y1 &&y<=y2){
						MapID = 1;
						lxyTurn = 2;
					}
				}else if(e.getKeyCode()==KeyEvent.VK_0){
					if(isbag)
						isbag=false;
					else {
						isbag=true;
					}
				}else if(e.getKeyCode()==KeyEvent.VK_1){
					if(isWin && MapID == 2){
						
						if(lxyY>=200&&lxyY<=300&&lxyX>=1160&&lxyX<=1750){
							isfgsl = true;
							isdsx = true;
							ishuoqu1 = true;
						}
					}else if(MapID == 1){
						if(lxyY>=500&&lxyY<=700&&lxyX>=1650&&lxyX<=1800){
							istqdb = true;
							experience+=10;
						}
					}
				}
			}
	}
	

	public void keyReleased(KeyEvent arg0) {
		FlagSongkai = 0;
	}

	public void keyTyped(KeyEvent arg0) {
		
	}

	public void mouseClicked(MouseEvent e) {
		int x=e.getX();
		int y=e.getY();System.out.println(x+" "+y);
		if(x>400&&x<620&&y>500&&y<570)
		{
			klis=true;
		}
	}

	public void mouseEntered(MouseEvent arg0) {
		
	}

	public void mouseExited(MouseEvent arg0) {
		
	}

	public void mousePressed(MouseEvent arg0) {
		
	}

	public void mouseReleased(MouseEvent arg0) {
		
	}
	
}