package OCR;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class change {
	
	private static int x;
	private static int y;
	private static int xx;
	private static int yy;

	public static String imgchange(String fileName) {
		try {
			//BufferedImage originalImgage = ImageIO.read(new File("C:/Test/pool.jpg"));
			BufferedImage originalImgage = ImageIO.read(new File("img/"+fileName));
			
			//System.out.println("Original Image Dimension: "+originalImgage.getWidth()+"x"+originalImgage.getHeight());
//			BufferedImage SubImgage = originalImgage.getSubimage(123, 300, 280, 45); //�̹��� ���� �׽�Ʈ�� : test111.jpg
			
			x = originalImgage.getWidth();
			y = originalImgage.getHeight();
			
			xx = originalImgage.getWidth();
			yy = originalImgage.getHeight();
			
			
			//�̹��� ũ�Ⱑ ���� 400, ����600 �� �������� �ۼ��� 
			BufferedImage SubImgage = originalImgage.getSubimage(115, y/2-30, xx-130, yy/2-235); //�̹��� ���� �׽�Ʈ�� : test111.jpg
			//System.out.println("Cropped Image Dimension: "+SubImgage.getWidth()+"x"+SubImgage.getHeight());

			File outputfile = new File("img2/"+fileName);
			ImageIO.write(SubImgage, "jpg", outputfile);

			//System.out.println("Image cropped successfully: "+outputfile.getPath());

		} catch (IOException e) {
			e.printStackTrace();
		}
		return fileName;
	}

	
	public static void main(String[] args) {
		System.out.println(imgchange("test22.jpg")); // �̹��������� ���ڿ��� �����ؼ� ��� �Ǵ� �κ�
		
		
	  }


}
