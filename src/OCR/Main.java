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


		// 이미지자르고 저장
		public static String imgchange(String fileName) {
			try {
				//BufferedImage originalImgage = ImageIO.read(new File("C:/Test/pool.jpg"));
				BufferedImage originalImgage = ImageIO.read(new File("img/"+fileName));
				
				//System.out.println("Original Image Dimension: "+originalImgage.getWidth()+"x"+originalImgage.getHeight());
//				BufferedImage SubImgage = originalImgage.getSubimage(123, 300, 280, 45); //이미지 조정 테스트물 : test111.jpg
				
				x = originalImgage.getWidth();
				y = originalImgage.getHeight();
				
				xx = originalImgage.getWidth();
				yy = originalImgage.getHeight();
				
				
				//이미지 크기가 가로 400, 세로600 을 기준으로 작성됨 
				BufferedImage SubImgage = originalImgage.getSubimage(115, y/2-30, xx-130, yy/2-235); //이미지 조정 테스트물 : test111.jpg
				//System.out.println("Cropped Image Dimension: "+SubImgage.getWidth()+"x"+SubImgage.getHeight());

				File outputfile = new File("img2/"+fileName);
				ImageIO.write(SubImgage, "jpg", outputfile);
	
				//System.out.println("Image cropped successfully: "+outputfile.getPath());
	
			} catch (IOException e) {
				e.printStackTrace();
			}
			return fileName;
		}

	
		//문자열로 변환
		public static String process(String fileName) {
		File imageFile = new File("img2/"+fileName);
		
		
		Tesseract instance = Tesseract.getInstance();  // JNA Interface Mapping
		instance.setDatapath("C:/tess4/Tess4J/tessdata"); 
		instance.setLanguage ( "eng");    // 이미지파일의 언어 선택 현재 kor(한글)의 경우 오류가 나타 난다.
		String result = "";
		
		//System.out.println(imageFile);
		
			try {
				result = instance.doOCR(imageFile, null); // 이미지파일 을 문자열로 변경해주는 부분.
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		
			return result;
		}
		
		

public static void main(String[] args) {
	
	//System.out.println(imgchage("test2.jpg"));
	
	image = "TEST22.jpg";  //사용할 이미지파일 입력
	

	imgchange(image); // 원래 이미지에서 해당 사용할 이미지 잘라서 새폴더에 생성  이미지의 경우 가로400, 세로600 으로 사용할부분을 가운대에 정렬 시켜서 출력해야함
	System.out.println("출력된 문자 : "+ process(image)); // 이미지파일을 문자열로 변경해서 출력 되는 부분
	
	
  }
}



