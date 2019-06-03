package kr.or.ddit.encrypt.kisa.sha256;

import static org.junit.Assert.*;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KISA_SHA256_Test {
	private static final Logger logger = LoggerFactory
			.getLogger(KISA_SHA256_Test.class);

	/**
	 * 
	* Method : sha256Test
	* 작성자 : PC06
	* 변경이력 :
	* Method 설명 : 복호화가 불가능한 hash 알고리즘
	 */
	@Test
	public void sha256Test() {
		/***Given***/
		String plainText = "admin123";

		/***When***/
		String encryptText = KISA_SHA256.encrypt(plainText);
		logger.debug("encryptText : {}", encryptText);
		
		/***Then***/
		//brown1234 => c6347b73d5b1f7c77f8be828ee3e871c819578f23779c7d5e082ae2b36a44
		//admin123 => 24be518fabd2724ddb6f04eeb1da5967448d7e831c08c8fa822809f74c720a9
	}

}
