# ConcurrencyFramework
基于Volley框架思想改进的满足高并发客户端请求的自定义网络框架，满足用户的网络请求，能够兼容其它的网络请求框架，同时具有可扩展性，封装完成后，可供大型项目使用。



# 最新版本

版本号：[![](https://www.jitpack.io/v/YouAreOnlyOne/ConcurrencyFramework.svg)](https://www.jitpack.io/#YouAreOnlyOne/ConcurrencyFramework)

使用自行替换下面的版本号，以获得最新版本。
    

# 使用方法

这里分别介绍在不同项目环境中，如何引用对该库的依赖。

## Android中使用：

方法一：

1.第一步，在项目的build.gradle下配置，注意是项目的build.gradle：

     allprojects {
		repositories {
			...
			maven { url 'https://www.jitpack.io' }
		}
	}
    
    
2.第二步,在app的build.gradle下添加如下依赖：

    dependencies {
            ...
            implementation 'com.github.YouAreOnlyOne:ConcurrencyFramework:版本号'
            ...
     }
    
    
 
# 项目用到的权限

  在manifest文件中添加访问的权限：
 

    <uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE"/>
    <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE"/>
    <uses-permission android:name="android.permission.INTERNET"/>

   

 
# 使用指南
 
 更新中……
 
# 相关介绍


OkHttp 、Retrofit 、Volley 、RxJava、Novate在Android中Web网络请求一行代码解决。

https://blog.csdn.net/u014374009/article/details/82933127

一行代码实现Ftp文件上传、文件下载、文件删除和进度监听的工具类的使用。

https://blog.csdn.net/u014374009/article/details/82944107

一行代码解决AndFix热修复和热跟更新问题，集成了阿里的开源库，修复程序的缺陷bug漏洞和功能页面等.

https://blog.csdn.net/u014374009/article/details/83052178




# 其它信息

1.项目还有很多不完善的地方，欢迎大家指导。

2.项目持续更新开源，有兴趣加入项目或者跟随项目的伙伴，可以邮件联系！ 

3.关注或者喜欢或者尝试使用或者感兴趣的伙伴可以，点击 ~ follow、fork、star ~ 。

# 作者邮箱

ycj52011@outlook.com


