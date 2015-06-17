package com.imagine.world;

import org.apache.commons.codec.binary.Base64;

import java.nio.charset.Charset;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * Utility for decrypting OpenSSL code in Java
 */
public class OpensslUtil {
    private static final int KEY_SIZE_BITS = 128;
    private static final Charset ASCII = Charset.forName("ASCII");

    private static final int INDEX_KEY = 0;
    private static final int INDEX_IV = 1;
    private static final int ITERATIONS = 1;

    private static final int SALT_OFFSET = 8;
    private static final int SALT_SIZE = 8;
    private static final int CIPHERTEXT_OFFSET = SALT_OFFSET + SALT_SIZE;



    /**
     * Decrypt a base64 string which is encrypted by openssl.
     * The encryption process in openssl as follow:
     * <ul>
     *      <li>>echo abcde | openssl enc -aes-128-cbc -e -base64</li>
     *      <li>>mypass</li>
     *      result: U2FsdGVkX1888g20wtQoP2FouuoYuzI4IiuRaZCa+B8=
     * </ul>
     *
     * @param password The password used in openssl to encrypt string
     * @param base64EcryptedString The base64 encryptedBytes string
     * @return The original string
     */
    public static String decryptOpenSSLBase64Code(String password, String base64EcryptedString)
            throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException,
            InvalidKeyException, BadPaddingException, IllegalBlockSizeException {

        byte[] headerSaltAndCipherText = Base64.decodeBase64(base64EcryptedString);
        byte[] salt = Arrays.copyOfRange(headerSaltAndCipherText, SALT_OFFSET, SALT_OFFSET + SALT_SIZE);
        byte[] encryptedBytes = Arrays.copyOfRange(headerSaltAndCipherText, CIPHERTEXT_OFFSET, headerSaltAndCipherText.length);

        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        MessageDigest md5 = MessageDigest.getInstance("MD5");

        final byte[][] keyAndIV =  EVP_BytesToKey(
                KEY_SIZE_BITS / Byte.SIZE,
                cipher.getBlockSize(),
                md5,
                salt,
                password.getBytes(ASCII),
                ITERATIONS);

        SecretKeySpec key = new SecretKeySpec(keyAndIV[INDEX_KEY], "AES");
        IvParameterSpec iv = new IvParameterSpec(keyAndIV[INDEX_IV]);

        cipher.init(Cipher.DECRYPT_MODE, key, iv);
        byte[] decryptedBytes = cipher.doFinal(encryptedBytes);

        if (decryptedBytes == null) {
            return null;
        }

        // remove new line character (ASCII value is 10), it is insert by base64 encoder
        if (decryptedBytes != null && decryptedBytes.length > 0) {
            if (decryptedBytes[decryptedBytes.length - 1] == 10) {
                return new String(decryptedBytes, 0, decryptedBytes.length-1, ASCII);
            }
        }

        return new String(decryptedBytes, ASCII);

    }

    /**
     * transform openssl password to java and get iv
     */
    public static byte[][] EVP_BytesToKey(int key_len, int iv_len, MessageDigest md, byte[] salt, byte[] data, int count) {
        byte[][] both = new byte[2][];
        byte[] key = new byte[key_len];
        int key_ix = 0;
        byte[] iv = new byte[iv_len];
        int iv_ix = 0;
        both[0] = key;
        both[1] = iv;
        byte[] md_buf = null;
        int nkey = key_len;
        int niv = iv_len;
        int i = 0;
        if (data == null) {
            return both;
        }
        int addmd = 0;
        for (;;) {
            md.reset();
            if (addmd++ > 0) {
                md.update(md_buf);
            }
            md.update(data);
            if (null != salt) {
                md.update(salt, 0, 8);
            }
            md_buf = md.digest();
            for (i = 1; i < count; i++) {
                md.reset();
                md.update(md_buf);
                md_buf = md.digest();
            }
            i = 0;
            if (nkey > 0) {
                for (;;) {
                    if (nkey == 0)
                        break;
                    if (i == md_buf.length)
                        break;
                    key[key_ix++] = md_buf[i];
                    nkey--;
                    i++;
                }
            }
            if (niv > 0 && i != md_buf.length) {
                for (;;) {
                    if (niv == 0)
                        break;
                    if (i == md_buf.length)
                        break;
                    iv[iv_ix++] = md_buf[i];
                    niv--;
                    i++;
                }
            }
            if (nkey == 0 && niv == 0) {
                break;
            }
        }
        for (i = 0; i < md_buf.length; i++) {
            md_buf[i] = 0;
        }
        return both;
    }

}