package OCR;

import java.io.File;

import net.sourceforge.tess4j.Tesseract;

public class proc {
	
	//문자열로 변환
			public static String  process(String fileName) {
			File imageFile = new File("img/"+fileName);
			
			Tesseract instance = Tesseract.getInstance();  // JNA Interface Mapping
			instance.setDatapath("C:/tess4/Tess4J/tessdata"); 
			instance.setLanguage ( "kor+eng");    // 이미지파일의 언어 선택 현재 kor(한글)의 경우 오류가 나타 난다.
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
			System.out.println("출력된 문자 -> "+ process("TEST22.jpg")); // 이미지파일을 문자열로 변경해서 출력 되는 부분
		    }
			
}
