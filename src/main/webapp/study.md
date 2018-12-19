#mybatis和hibernate的对比
+ mybatis是一个不完全的orm框架,需要程序员自己写sql语句,
无法与数据库完全脱离,可以通过xml文件或者注解方式配置运行sql
+ mybatis学习门槛低,需要对接多套数据库时工作量大.
但可严格控制sql性能.
+ hibernate对象关系映射强,多类型数据库切换简单
##mybatis开发流程
+ 写mybatis-config.xml配置文件,配置文件内容为数据源、事务管理。
+ 创建pojo对象,pojo类通常与数据库表对应(Admin)
+ 创建sql映射文件(AdminMapper.xml)并在其中写sql查询语句.
+ 加载映射文件(mybatis框架需要加载AdminMapper.xml映射文件
添加在mybatis-config.xml)
+ 创建dao层编写接口.调用xml中的sql语句,来操作数据库