package cn.lijy.demo.until.testDo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;

/**
 * @program: cn.lijy.demo.until.testDo
 * @description: MD5加密工具类
 * @author: JF1sh
 * @create: 2019-11-25 10:24
 **/
public class MD5Utils {

    protected static char hexDigits[] = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};

    protected static MessageDigest messageDigest = null;

    private static final Integer SALT_LENGTH = 12;

    /**
     * 16进制数字
     */
    private static final String HEX_NUMS_STR="0123456789abcdef";

    /**
     * 获取加密
     */
    static{
        try{
            messageDigest = MessageDigest.getInstance("MD5");
        }catch (NoSuchAlgorithmException e) {
            System.err.println(MD5Utils.class.getName()+"初始化失败，MessageDigest不支持MD5Util.");
            e.printStackTrace();
        }
    }

    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>文件加密开始
    /**
     * 计算文件的MD5
     * @param fileName 文件的绝对路径
     * @return
     * @throws IOException
     */
    public static String getFileMD5String(String fileName) throws IOException {
        File f = new File(fileName);
        return getFileMD5String(f);
    }

    /**
     * 计算文件的MD5，重载方法
     * @param file 文件对象
     * @return
     * @throws IOException
     */
    public static String getFileMD5String(File file) throws IOException{
        FileInputStream in = new FileInputStream(file);
        FileChannel ch = in.getChannel();
        MappedByteBuffer byteBuffer = ch.map(FileChannel.MapMode.READ_ONLY, 0, file.length());
        messageDigest.update(byteBuffer);
        return bufferToHex(messageDigest.digest());
    }

    private static String bufferToHex(byte bytes[]) {
        return bufferToHex(bytes, 0, bytes.length);
    }

    private static String bufferToHex(byte bytes[], int m, int n) {
        StringBuffer stringbuffer = new StringBuffer(2 * n);
        int k = m + n;
        for (int l = m; l < k; l++) {
            appendHexPair(bytes[l], stringbuffer);
        }
        return stringbuffer.toString();
    }

    private static void appendHexPair(byte bt, StringBuffer stringbuffer) {
        char c0 = hexDigits[(bt & 0xf0) >> 4];
        char c1 = hexDigits[bt & 0xf];
        stringbuffer.append(c0);
        stringbuffer.append(c1);
    }
//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>文件加密结束


//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>字符串加密开始

    /*----------------md5普通加密*/

    /**
     * MD5加密 生成32位md5码
     * @param   'inStr -> 待加密字符串'
     * @return 返回32位md5码
     */
    public static String md5Encode(String inStr) throws Exception {
        MessageDigest md5 = messageDigest;
        byte[] byteArray = inStr.getBytes("UTF-8");
        byte[] md5Bytes = md5.digest(byteArray);
        StringBuffer hexValue = new StringBuffer();
        for (int i = 0; i < md5Bytes.length; i++) {
            int val = ((int) md5Bytes[i]) & 0xff;
            if (val < 16) {
                hexValue.append("0");
            }
            hexValue.append(Integer.toHexString(val));
        }
        return hexValue.toString();
    }

    /*----------------md5加盐加密和解密*/

    /**
     * 获得加密后的16进制形式口令
     * @param password
     * @return
     * @throws Exception
     * @throws NoSuchAlgorithmException
     * @throws UnsupportedEncodingException
     */
    public static String getEncryptedPwd(String password) throws Exception{
        try{
            //声明加密后的口令数组变量
            byte[] pwd = null;
            //随机数生成器
            SecureRandom random = new SecureRandom();
            //声明盐数组变量 12
            byte[] salt = new byte[SALT_LENGTH];
            //将随机数放入盐变量中
            random.nextBytes(salt);

            //获得加密的数据
            byte[] digest = encrypte(salt,password);

            //因为要在口令的字节数组中存放盐，所以加上盐的字节长度
            pwd = new byte[digest.length + SALT_LENGTH];
            //将盐的字节拷贝到生成的加密口令字节数组的前12个字节，以便在验证口令时取出盐
            System.arraycopy(salt, 0, pwd, 0, SALT_LENGTH);
            //将消息摘要拷贝到加密口令字节数组从第13个字节开始的字节
            System.arraycopy(digest, 0, pwd, SALT_LENGTH, digest.length);
            //将字节数组格式加密后的口令转化为16进制字符串格式的口令
            return byteToHexString(pwd);
        }catch(Exception e){
            throw new Exception("获取加密密码失败",e);
        }

    }

    /**
     *
     * 根据盐生成密码
     * @param salt
     * @param passwrod
     * @return
     * @throws Exception
     * @throws UnsupportedEncodingException
     * @throws NoSuchAlgorithmException
     */
    public static byte[] encrypte(byte[] salt,String passwrod) throws Exception{
        try{
            //声明消息摘要对象
            MessageDigest md = null;
            //创建消息摘要
            md = MessageDigest.getInstance("MD5");
            //将盐数据传入消息摘要对象
            md.update(salt);
            //将口令的数据传给消息摘要对象
            md.update(passwrod.getBytes("UTF-8"));
            //获得消息摘要的字节数组
            return md.digest();
        }catch(Exception e){
            throw new Exception("Md5解密失败",e);
        }
    }

    /**
     * 将指定byte数组转换成16进制字符串（大写）
     * @param 'b'
     * @return
     */
    public static String byteToHexString(byte[] bytes) {
        StringBuffer md5str = new StringBuffer();
        //把数组每一字节换成16进制连成md5字符串
        int digital;
        for (int i = 0; i < bytes.length; i++) {
            digital = bytes[i];
            if(digital < 0) {
                digital += 256;
            }
            if(digital < 16){
                md5str.append("0");
            }
            md5str.append(Integer.toHexString(digital));
        }
        return md5str.toString();
    }

    /**
     * 验证口令是否合法
     * @param password  --当前验证值
     * @param passwordInDb  -- 之前存入值
     * @return 是否一致
     * @throws Exception
     * @throws NoSuchAlgorithmException
     * @throws UnsupportedEncodingException
     */
    public static boolean validPassword(String password, String passwordInDb) throws Exception {
        try{
            //将16进制字符串格式口令转换成字节数组
            byte[] pwdInDb = hexStringToByte(passwordInDb);
            //声明盐变量
            byte[] salt = new byte[SALT_LENGTH];
            //将盐从数据库中保存的口令字节数组中提取出来
            System.arraycopy(pwdInDb, 0, salt, 0, SALT_LENGTH);

            //获得加密的数据
            byte[] digest = encrypte(salt,password);

            //声明一个保存数据库中口令消息摘要的变量
            byte[] digestInDb = new byte[pwdInDb.length - SALT_LENGTH];
            //取得数据库中口令的消息摘要
            System.arraycopy(pwdInDb, SALT_LENGTH, digestInDb, 0, digestInDb.length);
            //比较根据输入口令生成的消息摘要和数据库中消息摘要是否相同
            if (Arrays.equals(digest, digestInDb)) {
                //口令正确返回口令匹配消息
                return true;
            } else {
                //口令不正确返回口令不匹配消息
                return false;
            }
        }catch(Exception e){
            throw new Exception("密码验证失败",e);
        }
    }
    /**
     * 将16进制字符串转换成字节数组(大写)
     * @param hex
     * @return
     */
    public static byte[] hexStringToByte(String hex) {
        int len = (hex.length() / 2);
        byte[] result = new byte[len];
        char[] hexChars = hex.toCharArray();
        for (int i = 0; i < len; i++) {
            int pos = i * 2;
            result[i] = (byte) (HEX_NUMS_STR.indexOf(hexChars[pos]) << 4
                    | HEX_NUMS_STR.indexOf(hexChars[pos + 1]));
        }
        return result;
    }
//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>字符串加密结束


    public static void main(String[] args) throws Exception {
        String fileName = "E:\\test01\\1.txt";
        String str = "d0970714757783e6cf17b26fb8e2298f";
        String str2 = "ea3ed20b6b101a09085ef09c97da1597";
        System.out.println(str.equals(str2));
        System.out.println(getFileMD5String(fileName));

        //经过md5加盐加密的123字符串为str123
       // System.out.println(getEncryptedPwd("123"));
        String str123_1 = "3fc7ed92dfb924f56ece855e74bf9c5c0c1f6f72a4dcc4a7db943bf0";//123加盐加密
        String str123_2 = "7dd3e5af8b373221a9864df5c2b46208fb819a256398a59deec5cb09";//123加盐加密
        String str123_3 = "53d21536fdc5f5e9a9198dd276c25055e2abb54c6dd561a7c90f974a";//123加盐加密
        //比对  输入登录秘密   和  数据库加盐加密密码
        boolean isTrue1 = validPassword("123",str123_1);
        boolean isTrue2 = validPassword("123",str123_2);
        boolean isTrue3 = validPassword("1231",str123_2);
        System.out.println("验证密码结果："+isTrue1);//true
        System.out.println("验证密码结果："+isTrue2);//true
        System.out.println("验证密码结果："+isTrue3);//fase
    }



}
