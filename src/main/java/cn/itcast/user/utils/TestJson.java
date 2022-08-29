package cn.itcast.user.utils;

import org.apache.tools.tar.TarEntry;
import org.apache.tools.tar.TarInputStream;

import java.io.*;

/**
 * Author: Leigang
 * create on 2022/2/24
 **/
public class TestJson {



    public static void main(String[] args) {
        File file = new File("D:\\test\\data\\2022-02-23\\privateGroup\\compressFile\\65b85ffa-d68a-44f7-8144-f6565229bfc1\\450008_55_20220219191706_1645269426636818982.tar");
        String outputDir = file.getParent() + "/" + file.getName().replace(".tar", "");
        unTar(file,outputDir);

    }

    public static void unTar(File file , String outputDir){
        TarInputStream tarIns = null;
        InputStream ins = null;
        OutputStream out = null;
        try {
            ins = new FileInputStream(file);
            tarIns = new TarInputStream(ins);
            createDirectory(outputDir, null);//创建输出目录
            TarEntry entry = null;//每一个文件对应一个Entry
            while ((entry = tarIns.getNextEntry()) != null && !"".equals(entry.getName())){
                if(entry.isDirectory()){ //目录
                    createDirectory(outputDir, entry.getName());//创建空目录

                }else{//文件
                    File tmpFile = new File(outputDir + "/" + entry.getName());
                    createDirectory(tmpFile.getParent() + "/", null);//创建输出目录

                    out = new FileOutputStream(tmpFile);
                    int len = 0;
                    byte[] bytes = new byte[1024];
                    while((len = tarIns.read(bytes)) != -1){
                        out.write(bytes, 0, len);
                    }

                }

            }
        } catch (FileNotFoundException e) {
            //log.error("文件不存在");
            //throw new BizException("文件不存在");
            e.printStackTrace();
        } catch (IOException e) {
            //log.error("解压文件失败");
            //throw new BizException("解压文件失败");
            e.printStackTrace();
        } finally {
            try {
                out.close();
                ins.close();
                tarIns.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    public static void createDirectory(String outputDir, String subDir){
        File file = new File(outputDir);
        if(subDir != null && !subDir.trim().equals("")){//如果子目录不为空则创建子目录
            file = new File(outputDir + "/" + subDir);
        }
        if(!file.exists()){
            if(!file.getParentFile().exists()){
                file.getParentFile().mkdirs();
            }
            file.mkdirs();
        }
    }

}
