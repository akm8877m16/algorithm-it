package File;


import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * 从url 下载图片到byte[]
 */
public class FileDownloadToByteArray {

    public static void main(String[] args){
        try {
            /**
             * just for test
             */
            URL urlTest = new URL("https://melody-activity.faas.alta.elenet.me/assets/no-activity.03ed10c.png");
            DataInputStream dataInputStream = new DataInputStream(urlTest.openStream());
            ByteArrayOutputStream output = new ByteArrayOutputStream();
            byte[] buf = new byte[1024];
            int numBytesRead = 0;
            while ((numBytesRead = dataInputStream.read(buf)) != -1) {
                output.write(buf, 0, numBytesRead);
            }
            byte[] byteArray = output.toByteArray();
            output.close();
            dataInputStream.close();
            System.out.println(byteArray.length);
        } catch (MalformedURLException exp){
            System.out.println(exp.getMessage());
        } catch (IOException exp){
            System.out.println(exp.getMessage());
        }
    }


}
