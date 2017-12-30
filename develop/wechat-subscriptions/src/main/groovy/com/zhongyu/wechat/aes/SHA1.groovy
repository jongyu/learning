package com.zhongyu.wechat.aes

import java.security.MessageDigest

class SHA1 {

    static String getSHA1(String token, String timestamp, String nonce, String encrypt) throws AesException {
        try {
            def array = [token, timestamp, nonce, encrypt] as String[]
            StringBuffer sb = new StringBuffer()
            Arrays.sort(array)
            for (int i = 0; i < 4; i++) {
                sb.append(array[i])
            }
            String str = sb.toString()
            MessageDigest md = MessageDigest.getInstance("SHA-1")
            md.update(str.getBytes())
            byte[] digest = md.digest()
            StringBuffer hexstr = new StringBuffer()
            for (int i = 0; i < digest.length; i++) {
                String shaHex = Integer.toHexString(digest[i] & 0xFF)
                if (shaHex.length() < 2) {
                    hexstr.append(0)
                }
                hexstr.append(shaHex)
            }
            return hexstr.toString()
        } catch (Exception e) {
            e.printStackTrace()
            throw new AesException(AesException.ComputeSignatureError)
        }
    }

}
