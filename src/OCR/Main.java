package OCR;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

import javax.imageio.ImageIO;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;


public class Main{

	
		private static int x;
		private static int y;
		private static int xx;
		private static int yy;
		private static String image;


		// �̹����ڸ��� ����
		public static String imgchange(String fileName) {
			try {
				//BufferedImage originalImgage = ImageIO.read(new File("C:/Test/pool.jpg"));
				BufferedImage originalImgage = ImageIO.read(new File("img/"+fileName));
				
				//System.out.println("Original Image Dimension: "+originalImgage.getWidth()+"x"+originalImgage.getHeight());
//				BufferedImage SubImgage = originalImgage.getSubimage(123, 300, 280, 45); //�̹��� ���� �׽�Ʈ�� : test111.jpg
				
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

	
		//���ڿ��� ��ȯ
		public static String process(String fileName) {
		File imageFile = new File("img2/"+fileName);
		
		
		Tesseract instance = Tesseract.getInstance();  // JNA Interface Mapping
		instance.setDatapath("C:/tess4/Tess4J/tessdata"); 
		instance.setLanguage ( "eng");    // �̹��������� ��� ���� ���� kor(�ѱ�)�� ��� ������ ��Ÿ ����.
		String result = "";
		
		//System.out.println(imageFile);
		
			try {
				result = instance.doOCR(imageFile, null); // �̹������� �� ���ڿ��� �������ִ� �κ�.
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		
			return result;
		}
		
		

public static void main(String[] args) {
	
	//System.out.println(imgchage("test2.jpg"));
	
	image = "TEST22.jpg";  //����� �̹������� �Է�
	

	imgchange(image); // ���� �̹������� �ش� ����� �̹��� �߶� �������� ����  �̹����� ��� ����400, ����600 ���� ����Һκ��� ����뿡 ���� ���Ѽ� ����ؾ���
	System.out.println("��µ� ���� : "+ process(image)); // �̹��������� ���ڿ��� �����ؼ� ��� �Ǵ� �κ�
	
	
  }
}



