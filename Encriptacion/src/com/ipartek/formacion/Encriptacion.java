package com.ipartek.formacion;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

public class Encriptacion {

	public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
		String Key = "1234567890123456";
		byte[] KeyData = Key.getBytes();
		
		for(int i = 0; i < KeyData.length; i++)
			System.out.println(KeyData[i]);
		
		SecretKeySpec KS = new SecretKeySpec(KeyData, "Blowfish");
		Cipher cipher = Cipher.getInstance("Blowfish");
		cipher.init(Cipher.ENCRYPT_MODE, KS);
		
		//Falta Salt
		String inputText = "Contraseña";
		byte[] encrypted = cipher.doFinal(inputText.getBytes());
		System.out.println(encrypted.length);
		System.out.println(
				Base64.getMimeEncoder().encodeToString(encrypted));
	}
}
