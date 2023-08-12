package work.https;

import javax.net.ssl.HttpsURLConnection;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 简化代码 直接url 也可以代理访问403的资源
 * 跳转ss2
 * <a href="https://geekerline.com/10538/.html">...</a>
 *
 * @author: gorilla
 * @date: 2023/8/12 10:45
 */
public class ssl3 {

    public static void main(String[] args) {
        String imageUrl = "https://file03.16sucai.com/2016/10/1100/16sucai_p20161021027_08b.JPG";

        try {
            URL url = new URL("https://images.weserv.nl?url=" + imageUrl);
            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
            connection.connect();
            InputStream inputStream = connection.getInputStream();

            // You can now use the imageStream as needed (e.g., save to a file, process the image, etc.)

            //写图片
            FileOutputStream fileOutputStream = new FileOutputStream("D:\\test.jpg");
            byte[] bytes = new byte[1024];
            int len = 0;
            while ((len = inputStream.read(bytes)) != -1) {
                fileOutputStream.write(bytes, 0, len);
            }
            fileOutputStream.close();
            inputStream.close();


            System.out.println("Image downloaded successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
