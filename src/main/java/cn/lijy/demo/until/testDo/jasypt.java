package cn.lijy.demo.until.testDo;

import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.StandardPBEByteEncryptor;
import org.jasypt.encryption.pbe.config.PBEConfig;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;

public class jasypt {
    /**

     * Jasypt生成加密结果

     *

     * @param password 配置文件中设定的加密密码 jasypt.encryptor.password

     * @param value    待加密值

     * @return

     */

    public static String encryptPwd(String password, String value) {

        PooledPBEStringEncryptor encryptOr = new PooledPBEStringEncryptor();

        encryptOr.setConfig(cryptOr(password));

        String result = encryptOr.encrypt(value);

        return result;

    }



    /**

     * 解密

     *

     * @param password 配置文件中设定的加密密码 jasypt.encryptor.password

     * @param value    待解密密文

     * @return

     */

    public static String decyptPwd(String password, String value) {

        PooledPBEStringEncryptor encryptOr = new PooledPBEStringEncryptor();

        encryptOr.setConfig(cryptOr(password));

        String result = encryptOr.decrypt(value);

        return result;

    }



    public static PBEConfig cryptOr(String password) {

        SimpleStringPBEConfig config = new SimpleStringPBEConfig();

        config.setPassword(password);

        config.setAlgorithm(StandardPBEByteEncryptor.DEFAULT_ALGORITHM);

        config.setKeyObtentionIterations("1000");

        config.setPoolSize("1");

        config.setProviderName("SunJCE");

        config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");

        config.setStringOutputType("base64");

        return config;

    }



    public static void main(String[] args) {

        // 加密
        System.out.println(encryptPwd("panther", "267736yu"));
        System.out.println(decyptPwd("panther", "EuMwggvuovI44kw9fhL7bw=="));
        // System.out.println(encryptPwd("panther", "123"));
        //解密
        //System.out.println(decyptPwd("panther", "BrJVazeHr7l35RAXaRF5RSla/qrAS4BuBXnOgWPRsJ4="));

    }
}
