# Alibaba Druid DoS 复现

拒绝服务漏洞的测试环境
- JDK 8
- MySQL 5.X
- SpringBoot 2.6.2
- Alibaba Druid 1.2.8

开始
1. 使用前执行`user.sql`语句初始化
2. 在`application.properties`中配置`MySQL`密码
3. 访问：`localhost:8080/add`添加用户
4. 访问：`localhost:8080/select?key=?&value=?`根据条件查找用户

具体的`payload`就不在`readme`里写了
