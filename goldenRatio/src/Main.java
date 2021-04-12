import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        double goldenRatio = 1.6180339887498948482045868343656381177203091798057628621354486227052604628189024497072072041893911374;
	    double a = 8192;
        double lastB = 0;
	    double b = a / goldenRatio;
	    double nextB = 0;

	    int width = (int)(a+b);
	    int height = (int)a;

        BufferedImage bufferedImage = new BufferedImage(width, height,  BufferedImage.TYPE_INT_BGR);
        Graphics2D graphics2D = bufferedImage.createGraphics();
        graphics2D.setColor(Color.black);
        graphics2D.fillRect(0,0, width, height);
        graphics2D.setColor(Color.green);

        int color = 245;
        int way = 0;
        int x = 0;
        int y = 0;
        int size = (int)a;

        int nextX = 0;
        int nextY = 0;

        while (b > 0.1){
            color -= 10;

            lastB = b * goldenRatio;
            nextB = b / goldenRatio;

            switch (way){
                case 0:
                    graphics2D.setColor(new Color(0,color,color));
                    graphics2D.fillRect(nextX,nextY,size,size);
                    nextX = nextX+size;
                    break;
                case 1:
                    graphics2D.setColor(new Color(color,0,0));
                    size = (int)lastB;
                    graphics2D.fillRect(nextX,nextY,size,size);
                    nextX = nextX + size - (int)b;
                    nextY = nextY + size;
                    break;
                case 2:
                    graphics2D.setColor(new Color(0,color,0));
                    size = (int)lastB;
                    graphics2D.fillRect(nextX,nextY,size,size);
                    nextX = nextX - (int)b;
                    nextY = nextY + (int)nextB;
                    break;
                case 3:
                    graphics2D.setColor(new Color(0,0,color));
                    size = (int)lastB;
                    graphics2D.fillRect(nextX,nextY,size,size);
                    nextY = nextY - (int)b;
                    break;
            }

            way++;
            if(way > 3){
                way = 0;
                size = (int)b;
            }

            b = b / goldenRatio;

        }

        graphics2D.dispose();

        File file = new File("goldenRatio.png");
        ImageIO.write(bufferedImage, "jpg", file);

    }
}
