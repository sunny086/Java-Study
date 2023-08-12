package work.https;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.security.cert.X509Certificate;

/**
 * 防盗链图片 访问403
 *
 * @author: gorilla
 * @date: 2023/8/11 18:20
 */
public class ssl1 {
    public static void main(String[] args) {
        try {
            // Create a trust manager that trusts all certificates
            TrustManager[] trustAllCertificates = new TrustManager[]{new X509TrustManager() {
                public X509Certificate[] getAcceptedIssuers() {
                    return null;
                }

                public void checkClientTrusted(X509Certificate[] certs, String authType) {
                }

                public void checkServerTrusted(X509Certificate[] certs, String authType) {
                }
            }};

            // Install the trust manager
            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, trustAllCertificates, new java.security.SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sslContext.getSocketFactory());

            // Disable hostname verification
            HttpsURLConnection.setDefaultHostnameVerifier((hostname, sslSession) -> true);

            URL url = new URL("https://file03.16sucai.com/2016/10/1100/16sucai_p20161021027_08b.JPG");
            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
            connection.connect();
            InputStream inputStream = connection.getInputStream();
            //写图片
            FileOutputStream fileOutputStream = new FileOutputStream("D:\\test.jpg");
            byte[] bytes = new byte[1024];
            int len = 0;
            while ((len = inputStream.read(bytes)) != -1) {
                fileOutputStream.write(bytes, 0, len);
            }
            fileOutputStream.close();
            inputStream.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}
