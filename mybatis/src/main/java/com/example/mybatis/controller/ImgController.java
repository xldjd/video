package com.example.mybatis.controller;

import org.apache.commons.io.IOUtils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

@RestController
@RequestMapping("/")
public class ImgController {

    private String imgPath1 = "C:\\Users\\123\\Desktop\\安卓开发\\images\\lunbo1.jpg";
    private String imgPath2 = "D:\\bysj\\sdf.png";
    private String imgPath3 = "D:\\bysj\\tu3.jpg";
    private String imgPath4 = "D:\\bysj\\tu4.png";
    private String imgPath5 = "D:\\bysj\\tu5.png";
    private String imgPath6 = "D:\\bysj\\tu6.jpg";
    private String imgPath7 = "D:\\bysj\\tu7.jpg";
    private String imgPath8 = "D:\\bysj\\tu8.jpg";
    private String imgPath9 = "D:\\bysj\\tu9.png";
    private String imgPath10 = "D:\\bysj\\tu10.jpg";
    private String imgPath11 = "D:\\bysj\\tu11.jpg";


    private String manhuaPath1 = "D:\\bysj\\manhua1.jpg";
    private String manhuaPath2 = "D:\\bysj\\manhua2.jpg";
    private String manhuaPath3 = "D:\\bysj\\manhua3.jpg";
    private String manhuaPath4 = "D:\\bysj\\manhua4.jpg";
    private String manhuaPath5 = "D:\\bysj\\manhua5.jpg";
    private String manhuaPath6 = "D:\\bysj\\manhua6.jpg";
    private String manhuaPath7 = "D:\\bysj\\manhua7.jpg";
    private String manhuaPath8 = "D:\\bysj\\manhua8.jpg";
    private String manhuaPath9 = "D:\\bysj\\manhua9.jpg";
    private String manhuaPath10 = "D:\\bysj\\manhua10.jpg";
    private String manhuaPath11 = "D:\\bysj\\manhua11.jpg";
    private String manhuaPath12 = "D:\\bysj\\manhua12.jpg";
    private String manhuaPath13 = "D:\\bysj\\manhua13.jpg";
    private String manhuaPath14 = "D:\\bysj\\manhua14.jpg";
    private String manhuaPath15 = "D:\\bysj\\manhua15.jpg";
    private String manhuaPath16 = "D:\\bysj\\manhua16.jpg";


    private String xiaoshuoPath1 = "D:\\bysj\\xiaoshuo1.jpg";
    private String xiaoshuoPath2= "D:\\bysj\\xiaoshuo2.jpg";
    private String xiaoshuoPath3 = "D:\\bysj\\xiaoshuo3.jpg";
    private String xiaoshuoPath4 = "D:\\bysj\\xiaoshuo4.jpg";
    private String xiaoshuoPath5 = "D:\\bysj\\xiaoshuo5.jpg";
    private String xiaoshuoPath6 = "D:\\bysj\\xiaoshuo6.jpg";
    private String xiaoshuoPath7 = "D:\\bysj\\xiaoshuo7.jpg";
    private String xiaoshuoPath8 = "D:\\bysj\\xiaoshuo8.jpg";
    private String xiaoshuoPath9 = "D:\\bysj\\xiaoshuo9.jpg";
    private String xiaoshuoPath10 = "D:\\bysj\\xiaoshuo10.jpg";
    private String xiaoshuoPath11 = "D:\\bysj\\xiaoshuo11.jpg";
    private String xiaoshuoPath12= "D:\\bysj\\xiaoshuo12.jpg";
    private String xiaoshuoPath13 = "D:\\bysj\\xiaoshuo13.jpg";
    private String xiaoshuoPath14 = "D:\\bysj\\xiaoshuo14.jpg";



    private InputStream getImgInputStream( String imgPath) throws FileNotFoundException {
        return new FileInputStream(new File(imgPath));
    }


    /**
     * 使用response输出图片流
     */
    @GetMapping("/img-response1")
    public void getImage1(HttpServletResponse resp) throws IOException {
        final InputStream in = getImgInputStream(imgPath1);
        resp.setContentType(MediaType.IMAGE_PNG_VALUE);
        IOUtils.copy(in, resp.getOutputStream());
    }


    /**
     * 使用response输出图片流
     */
    @GetMapping("/img-response2")
    public void getImage2(HttpServletResponse resp) throws IOException {
        final InputStream in = getImgInputStream(imgPath2);
        resp.setContentType(MediaType.IMAGE_PNG_VALUE);
        IOUtils.copy(in, resp.getOutputStream());
    }

    /**
     * 使用response输出图片流
     */
    @GetMapping("/img-response3")
    public void getImage3(HttpServletResponse resp) throws IOException {
        final InputStream in = getImgInputStream(imgPath3);
        resp.setContentType(MediaType.IMAGE_PNG_VALUE);
        IOUtils.copy(in, resp.getOutputStream());
    }

    /**
     * 使用response输出图片流
     */
    @GetMapping("/img-response4")
    public void getImage4(HttpServletResponse resp) throws IOException {
        final InputStream in = getImgInputStream(imgPath4);
        resp.setContentType(MediaType.IMAGE_PNG_VALUE);
        IOUtils.copy(in, resp.getOutputStream());
    }

    /**
     * 使用response输出图片流
     */
    @GetMapping("/img-response5")
    public void getImage5(HttpServletResponse resp) throws IOException {
        final InputStream in = getImgInputStream(imgPath5);
        resp.setContentType(MediaType.IMAGE_PNG_VALUE);
        IOUtils.copy(in, resp.getOutputStream());
    }

    /**
     * 使用response输出图片流
     */
    @GetMapping("/img-response6")
    public void getImage6(HttpServletResponse resp) throws IOException {
        final InputStream in = getImgInputStream(imgPath6);
        resp.setContentType(MediaType.IMAGE_PNG_VALUE);
        IOUtils.copy(in, resp.getOutputStream());
    }

    /**
     * 使用response输出图片流
     */
    @GetMapping("/img-response7")
    public void getImage7(HttpServletResponse resp) throws IOException {
        final InputStream in = getImgInputStream(imgPath7);
        resp.setContentType(MediaType.IMAGE_PNG_VALUE);
        IOUtils.copy(in, resp.getOutputStream());
    }

    /**
     * 使用response输出图片流
     */
    @GetMapping("/img-response8")
    public void getImage8(HttpServletResponse resp) throws IOException {
        final InputStream in = getImgInputStream(imgPath8);
        resp.setContentType(MediaType.IMAGE_PNG_VALUE);
        IOUtils.copy(in, resp.getOutputStream());
    }

    /**
     * 使用response输出图片流
     */
    @GetMapping("/img-response9")
    public void getImage9(HttpServletResponse resp) throws IOException {
        final InputStream in = getImgInputStream(imgPath9);
        resp.setContentType(MediaType.IMAGE_PNG_VALUE);
        IOUtils.copy(in, resp.getOutputStream());
    }

    /**
     * 使用response输出图片流
     */
    @GetMapping("/img-response10")
    public void getImage10(HttpServletResponse resp) throws IOException {
        final InputStream in = getImgInputStream(imgPath10);
        resp.setContentType(MediaType.IMAGE_PNG_VALUE);
        IOUtils.copy(in, resp.getOutputStream());
    }

    /**
     * 使用response输出图片流
     */
    @GetMapping("/img-response11")
    public void getImage11(HttpServletResponse resp) throws IOException {
        final InputStream in = getImgInputStream(imgPath11);
        resp.setContentType(MediaType.IMAGE_PNG_VALUE);
        IOUtils.copy(in, resp.getOutputStream());
    }




//漫画

    /**
     * 使用response输出图片流
     */
    @GetMapping("/manhua-response1")
    public void getmanhuaImage1(HttpServletResponse resp) throws IOException {
        final InputStream in = getImgInputStream(manhuaPath1);
        resp.setContentType(MediaType.IMAGE_PNG_VALUE);
        IOUtils.copy(in, resp.getOutputStream());
    }

    /**
     * 使用response输出图片流
     */
    @GetMapping("/manhua-response2")
    public void getmanhuaImage2(HttpServletResponse resp) throws IOException {
        final InputStream in = getImgInputStream(manhuaPath2);
        resp.setContentType(MediaType.IMAGE_PNG_VALUE);
        IOUtils.copy(in, resp.getOutputStream());
    }
    /**
     * 使用response输出图片流
     */
    @GetMapping("/manhua-response3")
    public void getmanhuaImage3(HttpServletResponse resp) throws IOException {
        final InputStream in = getImgInputStream(manhuaPath3);
        resp.setContentType(MediaType.IMAGE_PNG_VALUE);
        IOUtils.copy(in, resp.getOutputStream());
    }

    /**
     * 使用response输出图片流
     */
    @GetMapping("/manhua-response4")
    public void getmanhuaImage4(HttpServletResponse resp) throws IOException {
        final InputStream in = getImgInputStream(manhuaPath4);
        resp.setContentType(MediaType.IMAGE_PNG_VALUE);
        IOUtils.copy(in, resp.getOutputStream());
    }
    /**
     * 使用response输出图片流
     */
    @GetMapping("/manhua-response5")
    public void getmanhuaImage5(HttpServletResponse resp) throws IOException {
        final InputStream in = getImgInputStream(manhuaPath5);
        resp.setContentType(MediaType.IMAGE_PNG_VALUE);
        IOUtils.copy(in, resp.getOutputStream());
    }

    /**
     * 使用response输出图片流
     */
    @GetMapping("/manhua-response6")
    public void getmanhuaImage6(HttpServletResponse resp) throws IOException {
        final InputStream in = getImgInputStream(manhuaPath6);
        resp.setContentType(MediaType.IMAGE_PNG_VALUE);
        IOUtils.copy(in, resp.getOutputStream());
    }

    /**
     * 使用response输出图片流
     */
    @GetMapping("/manhua-response7")
    public void getmanhuaImage7(HttpServletResponse resp) throws IOException {
        final InputStream in = getImgInputStream(manhuaPath7);
        resp.setContentType(MediaType.IMAGE_PNG_VALUE);
        IOUtils.copy(in, resp.getOutputStream());
    }


    /**
     * 使用response输出图片流
     */
    @GetMapping("/manhua-response8")
    public void getmanhuaImage8(HttpServletResponse resp) throws IOException {
        final InputStream in = getImgInputStream(manhuaPath8);
        resp.setContentType(MediaType.IMAGE_PNG_VALUE);
        IOUtils.copy(in, resp.getOutputStream());
    }

    /**
     * 使用response输出图片流
     */
    @GetMapping("/manhua-response9")
    public void getmanhuaImage9(HttpServletResponse resp) throws IOException {
        final InputStream in = getImgInputStream(manhuaPath9);
        resp.setContentType(MediaType.IMAGE_PNG_VALUE);
        IOUtils.copy(in, resp.getOutputStream());
    }

    /**
     * 使用response输出图片流
     */
    @GetMapping("/manhua-response10")
    public void getmanhuaImage10(HttpServletResponse resp) throws IOException {
        final InputStream in = getImgInputStream(manhuaPath10);
        resp.setContentType(MediaType.IMAGE_PNG_VALUE);
        IOUtils.copy(in, resp.getOutputStream());
    }

    /**
     * 使用response输出图片流
     */
    @GetMapping("/manhua-response11")
    public void getmanhuaImage11(HttpServletResponse resp) throws IOException {
        final InputStream in = getImgInputStream(manhuaPath11);
        resp.setContentType(MediaType.IMAGE_PNG_VALUE);
        IOUtils.copy(in, resp.getOutputStream());
    }
    /**
     * 使用response输出图片流
     */
    @GetMapping("/manhua-response12")
    public void getmanhuaImage12(HttpServletResponse resp) throws IOException {
        final InputStream in = getImgInputStream(manhuaPath12);
        resp.setContentType(MediaType.IMAGE_PNG_VALUE);
        IOUtils.copy(in, resp.getOutputStream());
    }

    /**
     * 使用response输出图片流
     */
    @GetMapping("/manhua-response13")
    public void getmanhuaImage13(HttpServletResponse resp) throws IOException {
        final InputStream in = getImgInputStream(manhuaPath13);
        resp.setContentType(MediaType.IMAGE_PNG_VALUE);
        IOUtils.copy(in, resp.getOutputStream());
    }

    /**
     * 使用response输出图片流
     */
    @GetMapping("/manhua-response14")
    public void getmanhuaImage14(HttpServletResponse resp) throws IOException {
        final InputStream in = getImgInputStream(manhuaPath14);
        resp.setContentType(MediaType.IMAGE_PNG_VALUE);
        IOUtils.copy(in, resp.getOutputStream());
    }

    /**
     * 使用response输出图片流
     */
    @GetMapping("/manhua-response15")
    public void getmanhuaImage15(HttpServletResponse resp) throws IOException {
        final InputStream in = getImgInputStream(manhuaPath15);
        resp.setContentType(MediaType.IMAGE_PNG_VALUE);
        IOUtils.copy(in, resp.getOutputStream());
    }

    /**
     * 使用response输出图片流
     */
    @GetMapping("/manhua-response16")
    public void getmanhuaImage16(HttpServletResponse resp) throws IOException {
        final InputStream in = getImgInputStream(manhuaPath16);
        resp.setContentType(MediaType.IMAGE_PNG_VALUE);
        IOUtils.copy(in, resp.getOutputStream());
    }
//小说
    /**
     * 使用response输出图片流
     */
    @GetMapping("/xiaoshuo-response1")
    public void getxiaoshuoImage1(HttpServletResponse resp) throws IOException {
        final InputStream in = getImgInputStream(xiaoshuoPath1);
        resp.setContentType(MediaType.IMAGE_PNG_VALUE);
        IOUtils.copy(in, resp.getOutputStream());
    }

    /**
     * 使用response输出图片流
     */
    @GetMapping("/xiaoshuo-response2")
    public void getxiaoshuoImage2(HttpServletResponse resp) throws IOException {
        final InputStream in = getImgInputStream(xiaoshuoPath2);
        resp.setContentType(MediaType.IMAGE_PNG_VALUE);
        IOUtils.copy(in, resp.getOutputStream());
    }

    /**
     * 使用response输出图片流
     */
    @GetMapping("/xiaoshuo-response3")
    public void getxiaoshuoImage3(HttpServletResponse resp) throws IOException {
        final InputStream in = getImgInputStream(xiaoshuoPath3);
        resp.setContentType(MediaType.IMAGE_PNG_VALUE);
        IOUtils.copy(in, resp.getOutputStream());
    }

    /**
     * 使用response输出图片流
     */
    @GetMapping("/xiaoshuo-response4")
    public void getxiaoshuoImage4(HttpServletResponse resp) throws IOException {
        final InputStream in = getImgInputStream(xiaoshuoPath4);
        resp.setContentType(MediaType.IMAGE_PNG_VALUE);
        IOUtils.copy(in, resp.getOutputStream());
    }

    /**
     * 使用response输出图片流
     */
    @GetMapping("/xiaoshuo-response5")
    public void getxiaoshuoImage5(HttpServletResponse resp) throws IOException {
        final InputStream in = getImgInputStream(xiaoshuoPath5);
        resp.setContentType(MediaType.IMAGE_PNG_VALUE);
        IOUtils.copy(in, resp.getOutputStream());
    }

    /**
     * 使用response输出图片流
     */
    @GetMapping("/xiaoshuo-response6")
    public void getxiaoshuoImage6(HttpServletResponse resp) throws IOException {
        final InputStream in = getImgInputStream(xiaoshuoPath6);
        resp.setContentType(MediaType.IMAGE_PNG_VALUE);
        IOUtils.copy(in, resp.getOutputStream());
    }

    /**
     * 使用response输出图片流
     */
    @GetMapping("/xiaoshuo-response7")
    public void getxiaoshuoImage7(HttpServletResponse resp) throws IOException {
        final InputStream in = getImgInputStream(xiaoshuoPath7);
        resp.setContentType(MediaType.IMAGE_PNG_VALUE);
        IOUtils.copy(in, resp.getOutputStream());
    }

    /**
     * 使用response输出图片流
     */
    @GetMapping("/xiaoshuo-response8")
    public void getxiaoshuoImage8(HttpServletResponse resp) throws IOException {
        final InputStream in = getImgInputStream(xiaoshuoPath8);
        resp.setContentType(MediaType.IMAGE_PNG_VALUE);
        IOUtils.copy(in, resp.getOutputStream());
    }

    /**
     * 使用response输出图片流
     */
    @GetMapping("/xiaoshuo-response9")
    public void getxiaoshuoImage9(HttpServletResponse resp) throws IOException {
        final InputStream in = getImgInputStream(xiaoshuoPath9);
        resp.setContentType(MediaType.IMAGE_PNG_VALUE);
        IOUtils.copy(in, resp.getOutputStream());
    }

    /**
     * 使用response输出图片流
     */
    @GetMapping("/xiaoshuo-response10")
    public void getxiaoshuoImage10(HttpServletResponse resp) throws IOException {
        final InputStream in = getImgInputStream(xiaoshuoPath10);
        resp.setContentType(MediaType.IMAGE_PNG_VALUE);
        IOUtils.copy(in, resp.getOutputStream());
    }

    /**
     * 使用response输出图片流
     */
    @GetMapping("/xiaoshuo-response11")
    public void getxiaoshuoImage11(HttpServletResponse resp) throws IOException {
        final InputStream in = getImgInputStream(xiaoshuoPath11);
        resp.setContentType(MediaType.IMAGE_PNG_VALUE);
        IOUtils.copy(in, resp.getOutputStream());
    }

    /**
     * 使用response输出图片流
     */
    @GetMapping("/xiaoshuo-response12")
    public void getxiaoshuoImage12(HttpServletResponse resp) throws IOException {
        final InputStream in = getImgInputStream(xiaoshuoPath12);
        resp.setContentType(MediaType.IMAGE_PNG_VALUE);
        IOUtils.copy(in, resp.getOutputStream());
    }

    /**
     * 使用response输出图片流
     */
    @GetMapping("/xiaoshuo-response13")
    public void getxiaoshuoImage13(HttpServletResponse resp) throws IOException {
        final InputStream in = getImgInputStream(xiaoshuoPath13);
        resp.setContentType(MediaType.IMAGE_PNG_VALUE);
        IOUtils.copy(in, resp.getOutputStream());
    }

    /**
     * 使用response输出图片流
     */
    @GetMapping("/xiaoshuo-response14")
    public void getxiaoshuoImage14(HttpServletResponse resp) throws IOException {
        final InputStream in = getImgInputStream(xiaoshuoPath14);
        resp.setContentType(MediaType.IMAGE_PNG_VALUE);
        IOUtils.copy(in, resp.getOutputStream());
    }
}