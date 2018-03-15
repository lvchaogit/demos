 

## 一些日常自己鼓捣的demo集合，欢迎交流！
* [spring-security-demo](https://github.com/lvchaogit/demos/tree/master/spring-security-demo)
    * 采用springboot+security，包含功能有：<br/>
      正常表单登录、ajax登录、自定义验证、方法安全等功能；<br/>
      遇到了一些坑或者可扩展在代码里有详细注释。。<br/>
      注：因仅用于后台功能demo的实现，所以前台页面跳转没有实现，需手动输入接口地址进行权限测试。<br/>
      
    * 配置步骤请参考：<br/>
        http://blog.didispace.com/springbootsecurity/<br/>
        https://springcloud.cc/spring-security-zhcn.html#jc-method<br/>
        http://www.jianshu.com/p/eb071c8f56e0<br/>
* [springboot-multidata-demo](https://github.com/lvchaogit/demos/tree/master/springboot-multidata-demo)
    * 采用Springboot+mybatis部署的静态多数据源切换，使用的是阿里的DruidDataSource数据源；<br/>
      采用静态方式，在编码过程中还是有些繁琐，需要做多套mapper，影响代码结构<br/>
      准备再试试动态数据源，尽量减少对代码的侵入性，通过spring的AOP动态进行切换数据源，尽量做到编码过程中感知度为0
    
