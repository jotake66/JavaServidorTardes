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
		String Key = "Encriptacion";
		byte[] KeyData = Key.getBytes();
		SecretKeySpec KS = new SecretKeySpec(KeyData, "Blowfish");
		Cipher cipher = Cipher.getInstance("Blowfish");
		cipher.init(Cipher.ENCRYPT_MODE, KS);
		String inputText = "Contraseña";
		byte[] encrypted = cipher.doFinal(inputText.getBytes());
		System.out.println(Base64.getMimeEncoder().encodeToString(encrypted));
	}

}
