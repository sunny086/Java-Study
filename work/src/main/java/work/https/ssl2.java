package work.https;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 使用图片镜像服务器访问 验证可行
 * <a href="https://geekerline.com/10538/.html">...</a>
 *
 * @author: gorilla
 * @date: 2023/8/12 10:09
 */
public class ssl2 {

    public static InputStream downloadImage(String imageUrl) throws IOException {
        URL url = new URL(imageUrl);

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();


        // Set up the connection properties
        connection.setRequestMethod("GET");
        connection.setDoInput(true);

        // Connect to the URL
        connection.connect();

        // Get the input stream of the connection
        return connection.getInputStream();
    }

    public static void main(String[] args) {
        String imageUrl = "https://images.weserv.nl/?url=https://file03.16sucai.com/2016/10/1100/16sucai_p20161021027_08b.JPG";

        try {
            InputStream inputStream = downloadImage(imageUrl);

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
