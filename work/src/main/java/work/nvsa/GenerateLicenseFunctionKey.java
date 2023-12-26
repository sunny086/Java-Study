package work.nvsa;

import org.junit.Test;

/**
 * nvsa的License要求的funtion key
 * 一种是应用级别，可以在导航栏平铺， app_key  +  res_key  + app_key +  unicode(子应用标题unicode编码)
 * 另外一种是左侧菜单栏， app_key  +  res_key  + app_key +  unicode(子应用标题unicode编码
 *
 * @author: gorilla
 * @date: 2023/12/26 11:36
 */
public class GenerateLicenseFunctionKey {

    @Test
    public void Generate1() {
        // nvsa_res_key_nvsa_unicode
        String str = "知识中心";
        String unicode = stringToUnicode(str);
        String formattedString = String.format("Output: nvsa_res_key_nvsa_%s", unicode);
        System.out.println(formattedString);

    }


    public static String stringToUnicode(String s) {
        StringBuilder unicode = new StringBuilder();
        for (char c : s.toCharArray()) {
            unicode.append("\\u").append(Integer.toHexString(c | 0x10000).substring(1));
        }
        String withoutU = unicode.toString().replaceAll("\\\\u", "");
        return withoutU.toUpperCase();
    }


}
