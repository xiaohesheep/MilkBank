package bafy.pharmacy.milkbank.common;

import android.content.Context;
import android.os.Environment;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
public class FileUtils {


    private Context context;

    public FileUtils(){}
    public FileUtils(Context context) {
        this.context = context;
    }


    /**
     * 在SD卡上创建文件
     *
     * @param fileName
     * @return
     * @throws IOException
     */
    public File createSDFile(String fileName) throws IOException{
        File file = new File(fileName);
        file.createNewFile();
        return file;
    }

    /**
     * 在SD卡上创建目录
     *
     * @param dirName
     * @return
     */
    public File createSDDir(String dirName){
        File dir = new File(dirName);
        dir.mkdirs();
        return dir;
    }

    /**
     * 判断SD卡上的文件夹是否存在
     *
     * @param fileName
     * @return
     */
    public boolean isFileExist(String fileName){
        File file = new File(fileName);
        return file.exists();
    }

    /**
     * 将一个InputStream里面的数据写入到SD卡中
     *
     * path
     * fileName
     * input
     * @return
     */
    public File writeToSDFromInput(String fileName,InputStream input){
        File file = null;
        OutputStream output = null;
        try {
            //createSDDir(path);
            file = createSDFile(fileName);
            output = new FileOutputStream(file);
            byte buffer[] = new byte[10 * 1024];
            while((input.read(buffer)) != -1){
                output.write(buffer);
            }
            //清缓存，将流中的数据保存到文件中
            output.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally{
            try {
                output.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return file;
    }


    ///下载
    public void DownFileFrmUrl(final String url) {

        try {
            InputStream is=null;
            HttpURLConnection conn=NetworkTool.getUrl(url);
            if (conn!=null)
            {
                int length = conn.getContentLength();
                is = conn.getInputStream();
            }

            if (is != null) {
                File file=writeToSDFromInput(Environment.getExternalStorageDirectory()+"/" + Config.UPDATE_SAVENAME,is);
                conn.disconnect();
            }


        } catch (IOException e) {
            e.printStackTrace();
        }



    }

    /**
     * 保存文件到sdcard中
     *  filename文件名
     *  content文件内容
     * @throws Exception
     */

    public void saveToSDCard(String filename, String filecontent) throws Exception{
        File file=new File(new File("/mnt/sdcard"),filename);
        FileOutputStream outstream=new FileOutputStream(file);
        outstream.write(filecontent.getBytes());
        outstream.close();
    }


    /**
     * 保存文件
     * @param filename 文件名
     * @param filecontent 文件内容
     * @throws Exception
     */

    public void SaveFlieToPhone(String filename, String filecontent) throws Exception{
        // TODO Auto-generated method stub
        FileOutputStream outstream=context.openFileOutput(filename, Context.MODE_PRIVATE);
        outstream.write(filecontent.getBytes());
        outstream.close();
    }


    /**
     * 读取文件内容
     * @param filename
     * @return
     * @throws Exception
     */
    public String read(String filename) throws Exception{
        FileInputStream in=new  FileInputStream(filename);
        ByteArrayOutputStream outStream=new ByteArrayOutputStream();
        byte []buffer=new byte[1024];
        int len=0;
        while((len=in.read(buffer)) !=-1){
            outStream.write(buffer, 0, len);
        }
        byte[]data=outStream.toByteArray();
        return new String(data);
    }



}
