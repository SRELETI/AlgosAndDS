import java.awt.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
 
class BasicBitmapStorage
{
 private BufferedImage image;
 
 public BasicBitmapStorage(final int width, final int height)
 {
  image = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);
 }
 
 public void fill(final Color c)
 {
  Graphics g = image.getGraphics();
  g.setColor(c);
  g.fillRect(0, 0, image.getWidth(), image.getHeight());
 }
 
 public void setPixel(final int x, final int y, final Color c)
 {
  image.setRGB(x, y, c.getRGB());
 }
 
 public Color getPixel(final int x, final int y)
 {
  return new Color(image.getRGB(x, y));
 }
 
 public Image getImage()
 {
  return image;
 }
}
public class Circle {
	BasicBitmapStorage image = new BasicBitmapStorage(100,100);
	public void draw( int n)
	{
		int x;
		int y;
		int len = 2*n+1;
		for(int i=0;i<len;i++)
		{
			for(int j=0;j<len;j++)
			{
				x = i-n;
				y = j-n;
				if(x*x+y*y<=n*n+1)
				{
					System.out.print('*');
				}
				else
					System.out.print(" ");
				System.out.print(" ");
			}
			System.out.println();
		}
	}
	
	public static void main(String args[])
	{
		Circle c = new Circle();
	//	c.draw(3);
		c.drawCircle(2);
	}
	
	public void drawCircle(int rad)
	{
		int centerX=0;
		int centerY=0;
		int x = 0;
		int y = rad;
		int rad_err = 1-rad;
		while(y>=x)
		{
			image.setPixel(centerX+x, centerY+y, Color.WHITE);
			image.setPixel(centerX+x, centerY-y, Color.WHITE);
			image.setPixel(centerX-x, centerY+y, Color.WHITE);
			image.setPixel(centerX-x, centerY-y, Color.WHITE);
			image.setPixel(centerX+y, centerY+x, Color.WHITE);
			image.setPixel(centerX+y, centerY-x, Color.WHITE);
			image.setPixel(centerX-y, centerY+x, Color.WHITE);
			image.setPixel(centerX-y, centerY+x, Color.WHITE);
			x++;
			if(rad_err<0)
			{
				rad_err = rad_err + 2*x +1;
				y--;
			}
			else 
			{
				rad_err = rad_err+ 2*(x-y)+1;
			}
		}
	}
}
