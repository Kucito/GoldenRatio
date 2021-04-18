import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

public class Graph {
    public static void drawGraph() throws IOException {
        int width = 1920;
        int height = 1080;
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);
        Graphics2D graphics2D = bufferedImage.createGraphics();
        graphics2D.setColor(new Color(0,0,0));
        graphics2D.fillRect(0,0,width,height);
        graphics2D.setColor(new Color(255,0,0));
        graphics2D.drawLine(0,height/2,width,height/2);
        graphics2D.setColor(new Color(0,255,0));
        graphics2D.drawLine(width/2,0,width/2,height);

        double y = 0;
        double step = 0.01;
        int counter = 0;
        graphics2D.setColor(new Color(255, 255, 255));
        for(double x = -200; x <= 200; x+=step){
            y = Math.pow(x*x,x);
            double x1 = x+step;
            double y1 = Math.pow(x1*x1,x1);
            double X1cords = x*100 + width/2;
            double X2cords = x1*100 + width/2;
            double Y1cords = height/2 - y*100;
            double Y2cords = height/2 - y1*100;
            if((X1cords + Y1cords) - (X2cords + Y2cords) < 1000){
                graphics2D.drawLine((int)X1cords,(int)Y1cords,(int)X2cords,(int)Y2cords);
            }

            counter++;
        }

        /*
        for(double x = -20; x < 20; x+=0.01){
            graphics2D.setColor(new Color(255, 255, 255));
            y = Math.pow(Math.sin(x),x);
            y1 = Math.pow(Math.sin(x+0.01),x+0.01);
            double X1cords = x*100 + width/2;
            double X2cords = (x+0.01)*100 + width/2;
            double Y1cords = height/2 - y*100;
            double Y2cords = height/2 - y1*100;
            if((X1cords + Y1cords) - (X2cords + Y2cords) < 10000){
                graphics2D.drawLine((int)X1cords,(int)Y1cords,(int)X2cords,(int)Y2cords);
            }
            //graphics2D.setColor(new Color(108, 103, 0));
            //graphics2D.fillOval((int)X1cords,(int)Y1cords,5,5);
            counter++;
        }
        graphics2D.setColor(new Color(255, 0, 242));
        for(double x = -50; x < 50; x+=0.01){
            z = x*x;
            z1 = (x+0.01)*(x+0.01);
            double X1cords = x*100 + width/2;
            double X2cords = (x+0.01)*100 + width/2;
            double Y1cords = height/2 - z*200;
            double Y2cords = height/2 - z1*200;
            if((X1cords + Y1cords) - (X2cords + Y2cords) < 1000){
                graphics2D.drawLine((int)X1cords,(int)Y1cords,(int)X2cords,(int)Y2cords);
            }
            counter++;
        }*/
        System.out.println("Iterated " + counter + " times");
        graphics2D.dispose();
        File file = new File("graph.png");
        ImageIO.write(bufferedImage, "png", file);
    }
}
