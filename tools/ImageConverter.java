import java.awt.image.*;
import java.io.*;
import javax.imageio.*;

public class ImageConverter
{
    public static void main(String[] args) throws Exception
    {
        //ファイル名を↓にかく
        //おんなじフォルダに画像を置く。
        final String fileName = "test.png";
        final String outputHead = "test";

        final int xSplit = 3*4;
        final int ySplit = 4*2;

        BufferedImage img = ImageIO.read(new File(fileName));

        for(int i = 0; i < xSplit * ySplit; i++)
        {
            BufferedImage dest = new BufferedImage(img.getWidth() / xSplit, img.getHeight() / ySplit, BufferedImage.TYPE_4BYTE_ABGR);
            int posX = (i % xSplit);
            int posY = (i / xSplit);
            int offsetX = posX * dest.getWidth();
            int offsetY = posY * dest.getHeight();
            System.out.println(posX + "," + posY);
            for(int y = 0; y < dest.getHeight(); y++)
            {
                for(int x = 0; x < dest.getWidth(); x++)
                {
                    int argb = img.getRGB(offsetX + x, offsetY + y);
                    dest.setRGB(x, y, argb);
                }
            }
            ImageIO.write(dest, "png", new File("outputHead" + posX + "_" + posY + ".png"));
        }
    }
}
