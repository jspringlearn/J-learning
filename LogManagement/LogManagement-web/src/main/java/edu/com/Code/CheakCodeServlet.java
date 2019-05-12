package edu.com.Code;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/CheakCodeServlet")
public class CheakCodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    //保存集合中的所有成语
	private List<String> words=new ArrayList<String>();
	
	@Override
	public void init() throws ServletException {
		//初始化阶段 读取new_word.txt
		//web工程中读取文件必须使用绝对路径
		String path=getServletContext().getRealPath("/WEB-INF/words.txt");
        //System.out.println(path);
		try {
			BufferedReader reader=new BufferedReader(new FileReader(path));
			String line;
			//把读到的成语全部添加到集合当中
			while ((line=reader.readLine())!=null) {
				words.add(line);
			}
			reader.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int width=120;
		int height=30;
		//绘制一张图片
		BufferedImage buffereImage=new BufferedImage(width,height,
				BufferedImage.TYPE_INT_BGR);
		//图片绘制背景颜色
		Graphics graphics=buffereImage.getGraphics();
		//绘制任何图形之前必须指定一个颜色
		graphics.setColor(getRandColor(200,250));
		graphics.fillRect(0,0,width,height);
		//绘制边框
		graphics.setColor(Color.WHITE);
		graphics.drawRect(0, 0, width-1, height-1);
		//四个随机数字
		Graphics2D graphics2d=(Graphics2D)graphics;
		//设置输出字体
		graphics2d.setFont(new Font("宋体",Font.BOLD,18));
		Random random=new Random();//创建随机数
		int index=random.nextInt(words.size());
		String word=words.get(index);//获得成语
		System.out.println(word);
		//定义坐标
		int x=10;
		for(int i=0;i<word.length();i++) {
			//随机颜色
			graphics2d.setColor(new Color(20+random.nextInt(110),20+random.nextInt(110),20+random.nextInt(110)));
		    //旋转-30----30度
			int jiaodu=random.nextInt(60)-30;
			//换算弧度
		    double theta=jiaodu*Math.PI/180;
		    //获得字母数字
		    char c=word.charAt(i);
		    //将C输出到图片
		    graphics2d.rotate(theta,x,20);
		    graphics2d.drawString(String.valueOf(c),x,20);
		    graphics2d.rotate(-theta,x,20);
		    x+=30;
		}
		//request.getSession().setAttribute("checkcode_session", word);
		this.getServletContext().setAttribute("checkCode", word);
		graphics.setColor(getRandColor(160,200));
		int x1,x2,y1,y2;
		for(int i=0;i<30;i++) {
			x1=random.nextInt(width);
			x2=random.nextInt(12);
			y1=random.nextInt(height);
			y2=random.nextInt(12);
			graphics.drawLine(x1, y1, x1+x2, x2+y2);
		}
		graphics.dispose();
		ImageIO.write(buffereImage, "jpg", response.getOutputStream());
		}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
    
    private Color getRandColor(int fc,int bc) {
    	Random random=new Random();
    	if(fc>255)
    		fc=255;
    	if(bc>255)
    		bc=255;
    	int r=fc+random.nextInt(bc-fc);
    	int g=fc+random.nextInt(bc-fc);
    	int b=fc+random.nextInt(bc-fc);
		return new Color(r,g,b);
    	
    }
}
