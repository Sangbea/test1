package OCR;

import java.io.File;

import net.sourceforge.tess4j.Tesseract;

public class proc {
	
	//���ڿ��� ��ȯ
			public static String  process(String fileName) {
			File imageFile = new File("img/"+fileName);
			
			Tesseract instance = Tesseract.getInstance();  // JNA Interface Mapping
			instance.setDatapath("C:/tess4/Tess4J/tessdata"); 
			instance.setLanguage ( "kor+eng");    // �̹��������� ��� ���� ���� kor(�ѱ�)�� ��� ������ ��Ÿ ����.
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
			System.out.println("��µ� ���� -> "+ process("TEST22.jpg")); // �̹��������� ���ڿ��� �����ؼ� ��� �Ǵ� �κ�
		    }
			
}
