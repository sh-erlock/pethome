package org.ethan;

import org.csource.common.MyException;
import org.csource.fastdfs.*;

import java.io.IOException;

/**
 * 测试FastDfs
 */
public class FastDfsTest {

    public static void main(String[] args) throws IOException, MyException {
        // 1、加载配置文件，配置文件中的内容就是 tracker 服务的地址。
        ClientGlobal.init("F:\\Work\\workspaces\\projecttwo\\pethome\\src\\main\\resources\\fdfs_client.conf");
        // 2、创建一个 TrackerClient 对象。直接 new 一个。
        TrackerClient trackerClient = new TrackerClient();
        // 3、使用 TrackerClient 对象创建连接，获得一个 TrackerServer 对象。
        TrackerServer trackerServer = trackerClient.getConnection();
        // 4、创建一个 StorageServer 的引用，值为 null
        StorageServer storageServer = null;
        // 5、创建一个 StorageClient 对象，需要两个参数 TrackerServer 对象、StorageServer 的引用
        StorageClient storageClient = new StorageClient(trackerServer, storageServer);
        // 6、使用 StorageClient 对象上传图片。
        //扩展名不带“.”
        String[] strings = storageClient.upload_file("F:\\downloads\\1号.jpg", "jpg",
                null);
        // 7、返回数组。包含组名和图片的路径。
        for (String string : strings) {
            System.out.println(string);
        }
        // group1
        // M00/01/87/rBE3kWF5JjqATwaJAA11cpubiqE209.jpg
    }
}
