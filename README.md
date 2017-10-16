# SpringmvcMybatis
***
## mapper文件和 po类均可使用逆向工程生成 
###直接上代码 逆向工程所需的 generatorConfig.xml已上传 执行下面的 java代码可生成 所需的 po包 和 mapper包 包名需自己指定 
  public class GeneratorSqlmap {
  public void generator() throws Exception{
	List<String> warnings = new ArrayList<String>();
	boolean overwrite = true;
	//指定 逆向工程配置文件
	File configFile = new File("generatorConfig.xml"); 
	ConfigurationParser cp = new ConfigurationParser(warnings);
	Configuration config = cp.parseConfiguration(configFile);
	DefaultShellCallback callback = new DefaultShellCallback(overwrite);
	MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config,
			callback, warnings);
	myBatisGenerator.generate(null);

	  } 

    GeneratorSqlmap generatorSqlmap = new GeneratorSqlmap();
    generatorSqlmap.generator();
---
## springmvc 的配置文件
###下面一行是 spring自带的 注解驱动 可代替 注解的映射器 和适配器 
  <mvc:annotation-driven conversion-service="conversionService"></mvc:annotation-driven>


    <!-- 视图解析器
    解析jsp解析，默认使用jstl标签，classpath下的得有jstl的包
     -->
    <bean
      class="org.springframework.web.servlet.view.InternalResourceViewResolver">
      <!-- 配置jsp路径的前缀 -->
      <property name="prefix" value="/WEB-INF/jsp/"/>
      <!-- 配置jsp路径的后缀 -->
      <property name="suffix" value=".jsp"/>
    </bean>
---
## mybatis的配置文件 
---
## controller 编写 
---
## service service.impl 编写 
---
## 初始化 web.xml 的加载


