懒惰的追小说者：一个自动推送最新更新的小说内容的小应用

A crawler to crawl a network novel. It listens and dowloads the new updating section of the novel automatically.

***

# 需求：

本人在追两部小说，《大主宰》和《斗罗大陆3-龙王传说》，每过几个小时就去打开网页，点击bookmark，看看有没有更新。现在的需求是：我不需要用浏览器查看有没有更新，只要这两部小说更新了，这个应用就自动推送到我的手机上并提醒我。



# 思路：

写一个定时的应用，每15分钟访问一下相应的小说网页，如果有更新的小说章节，就下载下来，编辑好格式，发到我的qq邮箱上面。



# 实现

- 语言：java

- 服务器：腾讯云

- 工具：putty，intelij IDEA

- 发送邮件

  工具包：

```
<dependency>
  <groupId>javax.mail</groupId>
  <artifactId>mail</artifactId>
  <version>1.4.7</version>
</dependency>
```

本人使用网易的邮箱向qq邮箱发送邮件。需要注册一个网易邮箱，登录进去，开启SMTP服务，[具体可参考](http://help.163.com/10/0312/13/61J0LI3200752CLQ.html)

- 如何实现程序定时

  ```
  public static void main(String[] args) {
          Runnable runnable = new Runnable() {
              public void run() {
                  new NovelOfDomination().doBusiness();
                  new DragonNovelDriver().doBusiness();
              }
          };

          ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
          service.scheduleAtFixedRate(runnable, 1, 900, TimeUnit.SECONDS);
      }
  ```

  上面的程序是本应用的主函数。定时的代码就是通过ScheduledExecutorService这个类实现的。

- 部署：

  把程序打包成jar包，使用WinSCP.exe或者SSH客户端把jar包上传到服务器上面，使用下面命令运行：

  ```
  nohup java -cp Crawler.jar com.huai.driver.NovelMain&
  ```

  nohup命令的简单解释可以参考：http://blog.csdn.net/liangyihuai/article/details/55006719

这样子，就部署完成了。



注意：本人把源码中的网易邮箱和qq邮箱注释成XXX了，需要读者修改成自己的。




