package com.xsw.mall.product;


import com.xsw.mall.product.entity.BrandEntity;
import com.xsw.mall.product.service.BrandService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;



@RunWith(SpringRunner.class)
@SpringBootTest
public class MallProductApplicationTests {

    @Autowired
    BrandService brandService;

//    @Autowired
//    OSSClient ossClient;
//
//    @Test
//    public void testUpload() throws Exception{
//        // Endpoint以华东1（杭州）为例，其它Region请按实际情况填写。
//        String endpoint = "oss-cn-beijing.aliyuncs.com";
//        // 阿里云账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM用户进行API访问或日常运维，请登录RAM控制台创建RAM用户。
//        String accessKeyId = "LTAI5tKRAcfHMeiW9JVgKEmo";
//        String accessKeySecret = "Vc6E7HHc7B5xPxZHBbUD0CSx3yObC8";
//        // 填写Bucket名称，例如examplebucket。
//        String bucketName = "xsw0923-mall";
//        // 填写Object完整路径，完整路径中不能包含Bucket名称，例如exampledir/exampleobject.txt。
//        String objectName = "xsw.jpg";
//        // 填写本地文件的完整路径，例如D:\\localpath\\examplefile.txt。
//        // 如果未指定本地路径，则默认从示例程序所属项目对应本地路径中上传文件流。
//        String filePath= "C:\\Users\\Administrator.DESKTOP-J7GDS97\\Desktop\\xsw.jpg";
//
//        // 创建OSSClient实例。
//        //ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
//
//        try {
//            InputStream inputStream = new FileInputStream(filePath);
//            // 创建PutObject请求。
//            ossClient.putObject(bucketName, objectName, inputStream);
//        } catch (OSSException oe) {
//            System.out.println("Caught an OSSException, which means your request made it to OSS, "
//                    + "but was rejected with an error response for some reason.");
//            System.out.println("Error Message:" + oe.getErrorMessage());
//            System.out.println("Error Code:" + oe.getErrorCode());
//            System.out.println("Request ID:" + oe.getRequestId());
//            System.out.println("Host ID:" + oe.getHostId());
//        } catch (ClientException ce) {
//            System.out.println("Caught an ClientException, which means the client encountered "
//                    + "a serious internal problem while trying to communicate with OSS, "
//                    + "such as not being able to access the network.");
//            System.out.println("Error Message:" + ce.getMessage());
//        } finally {
//            if (ossClient != null) {
//                ossClient.shutdown();
//            }
//        }
//    }




    @Test
    void contextLoads() {

        BrandEntity brandEntity = new BrandEntity();
        brandEntity.setBrandId(1L);
        brandEntity.setDescript("华为");
//
//        brandEntity.setName("华为");
//
//        brandService.save(brandEntity);
//
//        System.out.println("保存成功");

        brandService.updateById(brandEntity);
    }

}
