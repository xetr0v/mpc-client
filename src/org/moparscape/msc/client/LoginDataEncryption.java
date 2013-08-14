package org.moparscape.msc.client;

import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.Cipher;

public class LoginDataEncryption {

	public void addByte(int i) {
		packet[offset++] = (byte) i;
	}

	public void addInt(int i) {
		packet[offset++] = (byte) (i >> 24);
		packet[offset++] = (byte) (i >> 16);
		packet[offset++] = (byte) (i >> 8);
		packet[offset++] = (byte) i;
	}

	@SuppressWarnings("deprecation")
	public void addString(String s) {
		s.getBytes(0, s.length(), packet, offset);
		offset += s.length();
		packet[offset++] = 10;
	}

	public void addBytes(byte bytes[], int offset, int length) {
		for (int i = offset; i < offset + length; i++)
			packet[this.offset++] = bytes[i];

	}

	public int getByte() {
		return packet[offset++] & 0xff;
	}

	public int getShort() {
		offset += 2;
		return ((packet[offset - 2] & 0xff) << 8) + (packet[offset - 1] & 0xff);
	}

	public int getInt() {
		offset += 4;
		return ((packet[offset - 4] & 0xff) << 24)
				+ ((packet[offset - 3] & 0xff) << 16)
				+ ((packet[offset - 2] & 0xff) << 8)
				+ (packet[offset - 1] & 0xff);
	}

	public void getBytes(byte arg0[], int arg1, int arg2) {
		for (int i = arg1; i < arg1 + arg2; i++)
			arg0[i] = packet[offset++];

	}

	public byte[] encrypt(byte text[]) throws Exception {
		byte cipherText[] = null;
		Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
		cipher.init(Cipher.ENCRYPT_MODE, pubKey);
		cipherText = cipher.doFinal(text);
		return cipherText;
	}

	public LoginDataEncryption(byte abyte0[]) {
		packet = abyte0;
		offset = 0;
		try {
			keyFactory = KeyFactory.getInstance("RSA");
			pubKey = keyFactory
					.generatePublic(new X509EncodedKeySpec(
							new BigInteger(
									"30820122300d06092a864886f70d01010105000382010f003082010a02820101009bc61e7f0b33c443ede4cc5abc340890cf32395f54e54116ad18b81fd8f88d0e380cf36bcd410d582cd0c9bdceeb0534a9905dcddf77a9999c53de89a968f91b7bfb8ad43604dcf070bb506db168d935df1619ca839368923bfe5a2c131e40e963e1787247c3e5e72676d422821eddc2ef65fba1485fb36720834bd4121042afbea57a1721a98d42cdecb67c03136f11cc86d4e87cb6fa6f2d7cde41a6d721a10e457bb7338e8ccd85eb2a4f727131dc411c23acf57810108c9edfe1b12e9c7b67d1313ae6ba7d05a21b13dc655bda8a38116274aeeae702870d0130f34788d9486ec2e9f591cb229235dcac99066d4112373caefb7d73abb69cc190e8a86a4d0203010001",
									16).toByteArray()));
		} catch (Exception e) {
		}
	}

	public byte packet[];
	public int offset;
	private KeyFactory keyFactory;
	private PublicKey pubKey;
}
