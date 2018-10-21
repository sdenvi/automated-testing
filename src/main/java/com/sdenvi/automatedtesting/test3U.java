package com.sdenvi.automatedtesting;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 *  Created by IntelliJ IDEA.
 *  User: Jenvi Sue
 *  Date:2018/10/21
 *  Time: 12:25
 *  To change this template use File | Settings | File Templates.
 */
public class test3U {
    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(3000);
        /** Coogle Chrome 浏览器驱动 **/
        //System.setProperty("webdriver.chrome.driver", "D://driver//chromedriver.exe");
        /** 浏览器没有安装到默认路径的时候，没有配置Path的时候强制指定浏览器路径 **/
        System.setProperty("webdriver.firefox.bin","D:\\Program Files\\Mozilla Firefox\\firefox.exe");
        /** Firefox 浏览器驱动 **/
        System.setProperty("webdriver.gecko.driver", "src/main/resources/drivers/geckodriver.exe");

        WebDriver webDriver = new FirefoxDriver();
        webDriver.manage().deleteAllCookies();
        // 与浏览器同步非常重要，必须等待浏览器加载完毕
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        webDriver.get("http://flights.sichuanair.com/3uair/ibe/ticket/");

        Thread.sleep(1000);

        //输入账号 密码并登陆系统
        //webDriver.findElement(By.xpath("/html/body/div/div/form/div[1]/div/div/input")).sendKeys("admin");
        //webDriver.findElement(By.xpath("/html/body/div/div/form/div[2]/div/div/input")).sendKeys("123456");
        //webDriver.findElement(By.cssSelector("html body div#app div.loginPage form.el-form.fromBox button.el-button.loginBtn.el-button--primary")).click();

        //登录
        //webDriver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/a[2]")).click();

        // 查询航班
        webDriver.findElement(By.id("Search-OriginDestinationInformation-Origin-location_input_location")).click();
        Thread.sleep(100);
        webDriver.findElement(By.xpath("/html/body/div[4]/div/div/div[1]/div[3]/div[1]/div[2]/form/div[1]/div[1]/div[2]/div/div[3]/div/div[2]/div[1]/ul/li[1]")).click();

        webDriver.findElement(By.id("Search-OriginDestinationInformation-Destination-location_input_location")).click();
        Thread.sleep(100);
        webDriver.findElement(By.xpath("/html/body/div[4]/div/div/div[1]/div[3]/div[1]/div[2]/form/div[1]/div[2]/div[2]/div/div[3]/div/div[2]/div[1]/ul/li[2]")).click();

        webDriver.findElement(By.linkText("立即查询")).click();

        // 选择航班
        Thread.sleep(5000);
        webDriver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div[1]/div[3]")).click();
        Thread.sleep(500);
        webDriver.findElement(By.linkText("预订")).click();

        // 会员登录
        webDriver.findElement(By.id("booking_reference")).sendKeys("18688705256");
        webDriver.findElement(By.id("booking_email")).sendKeys("123623");
        // 停顿一下，手动选择验证码，后面优化成自动选择验证码
        Thread.sleep(10000);
        webDriver.findElement(By.id("retrieveBookingSubmitButton-link")).click();

        // 会员享多种优惠选择
        Thread.sleep(10000);
        webDriver.findElement(By.xpath("/html/body/div[4]/div[1]/div/div[3]/div[2]/ul/li[2]/label/input")).click();
        webDriver.findElement(By.linkText("确定")).click();

        // 航班概况
        Thread.sleep(1000);
        webDriver.findElement(By.linkText("下一步")).click();

        // 填写旅客信息
        Thread.sleep(1000);
        //移动到指定的坐标(相对当前的坐标移动)
        ((JavascriptExecutor) webDriver).executeScript("window.scrollBy(0, 700)");
        Thread.sleep(1000);
        webDriver.findElement(By.xpath("/html/body/div[4]/div/div/div[2]/form/div/div[4]/p/label/input")).click();
        webDriver.findElement(By.id("domesticPaxDetailSubmitform")).click();
        //跳转到我的博客
        Thread.sleep(300);
        // webDriver.get("https://www.cnblogs.com/xiaochangwei");

        webDriver.findElements(By.className("postTitle")).forEach(x -> {
            System.out.println(x.getText());
        });

        Thread.sleep(1000);
        //打开标题为 通过Dockerfile构建镜像并发布web项目 的文章
        webDriver.findElement(By.partialLinkText("通过Dockerfile构建镜像并发布web项目")).click();

        Thread.sleep(1000);
        //移动到底部
        //((JavascriptExecutor) webDriver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
        //移动到指定的坐标(相对当前的坐标移动)
        ((JavascriptExecutor) webDriver).executeScript("window.scrollBy(0, 700)");
        Thread.sleep(1000);
        //移动到窗口绝对位置坐标，如下移动到纵坐标1600像素位置
        ((JavascriptExecutor) webDriver).executeScript("window.scrollTo(0, 1600)");
        Thread.sleep(1000);
        //移动到指定元素，且元素底部和窗口底部对齐 参考 https://www.cnblogs.com/testway/p/6693140.html
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(false);", webDriver.findElement(By.xpath("/html/body/div[2]/div[2]/div[1]/div/div[1]/div/div/div[2]/div[4]/div[3]/div[1]/a[5]/img")));
        //暂停五秒钟后关闭
        Thread.sleep(2000);
        webDriver.quit();
    }

}
