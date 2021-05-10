package controller;

import java.util.Base64;
import java.io.UnsupportedEncodingException;

public class EnDeCryption {

	public static String endcode(String str) {
		String result = null;
		try {
			result = Base64.getEncoder().encodeToString(str.getBytes("utf-8"));
		} catch (UnsupportedEncodingException e) {
			System.out.println("Error :" + e.getMessage());
		}
		return result;
	}

	public static String decode(String str) {
		try {
			byte[] base64decodedBytes = Base64.getDecoder().decode(str);
			str = new String(base64decodedBytes, "utf-8");
		} catch (UnsupportedEncodingException e) {
			System.out.println("Error :" + e.getMessage());
		}
		return str;
	}
}
