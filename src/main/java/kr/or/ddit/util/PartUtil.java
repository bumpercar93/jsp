package kr.or.ddit.util;

public class PartUtil {
	
	/**
	 * 
	* Method : getFileName
	* 작성자 : PC06
	* 변경이력 :
	* @param contentDispositon
	* @return
	* Method 설명 : contentDispositon에서 파일명을 반환한다
	 */
	public static String getFileName(String contentDispositon) {
		//form-data; name="profile"; filename="chopa.jpg"
		String[] temps = contentDispositon.split("; ");
		String result = "";
		
		for(String temp : temps) {
			if(temp.startsWith("filename=")) {
				result = temp.substring(temp.indexOf("\"")+1, temp.lastIndexOf("\""));
			}
		}
		
		return result;
	}
	
	/**
	 * 
	* Method : getExt
	* 작성자 : PC06
	* 변경이력 :
	* @param fileName
	* @return
	* Method 설명 : 파일명으로부터 파일 확장자를 반환
	 */
	public static String getExt(String fileName) {
		if(fileName.contains(".")) {
			String[] temps = fileName.split("\\.");
			return temps[temps.length-1];
		}else {
			return "";
		}
	}

}
