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
//			BufferedImage SubImgage = originalImgage.getSubimage(123, 300, 280, 45); //이미지 조정 테스트물 : test111.jpg
			
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

	
	public static void main(String[] args) {
		System.out.println(imgchange("test22.jpg")); // 이미지파일을 문자열로 변경해서 출력 되는 부분
		
		
	  }


}
