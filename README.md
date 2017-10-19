# SpringmvcMybatis:blush::blush::blush::blush:
***
## mapper文件和 po类均可使用逆向工程生成 
###直接上代码 逆向工程所需的 generatorConfig.xml已上传,执行下面的java代码可生成所需的 po包 和 mapper包,包名需自己指定  

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
		public static void main(String[] args) throws Exception {
			try {
				GeneratorSqlmap generatorSqlmap = new GeneratorSqlmap();
				generatorSqlmap.generator();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}
---
## springmvc 的配置文件
##下面一行是 spring自带的 注解驱动 可代替 注解的映射器 和适配器 

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
    
对于 业务层，dao层，事务控制层， 使用spring DI 注入 

---
## mybatis的配置文件  
	<typeAliases>
		<!-- 批量扫描别名 -->
		<package name="com.coderlong.po"/>
	</typeAliases>
---
## controller 编写 
<<<<<<< HEAD
:blush: 这个表情用起来会上瘾啊 

### 我写了三个controller 依次是 ItemsController,JsonController(这个测试json字符串用的)，LoginController 
login 采用Spring的拦截器 自己写的拦截器需要实现 HandlerInterceptor借口 ，再在springmvc.xml里面注册
	<mvc:interceptors>
		<!--多个拦截器,顺序执行 -->
		<!--  设置拦截器的设置-->
		<!-- 登陆认证拦截器 -->

		<mvc:interceptor>
			<!-- /**表示所有url包括子url路径 -->
			<mvc:mapping path="/**"/>
			<bean class="com.coderlong.Interceptor.HandleInterceptor1"></bean>
		</mvc:interceptor>
		<mvc:interceptor>
			<mvc:mapping path="/**"/>
			<bean class="com.coderlong.Interceptor.HandleInterceptor2"></bean>
		</mvc:interceptor>
			<mvc:interceptor>
			<mvc:mapping path="/**"/>
			<bean class="com.coderlong.Interceptor.LoginInterception"></bean>
		</mvc:interceptor>
	</mvc:interceptors>
=======
	
>>>>>>> 386bbba0078e166b6c2cb1c2300d40494af846f8

---
## service service.impl 编写 
	Service.impl功能 按所需书写就可以了。
---
## 初始化 web.xml 的加载
###post 乱码过滤器 比起在Servelet 自己配置的乱码过滤器 spring 已经帮我们写好了字符乱码的过滤器 
	<!-- post乱码过虑器 -->
		<filter>
			<filter-name>CharacterEncodingFilter</filter-name>
			<filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
			<init-param>
				<param-name>encoding</param-name>
				<param-value>utf-8</param-value>
			</init-param>
		</filter>
		<filter-mapping>
			<filter-name>CharacterEncodingFilter</filter-name>
			<url-pattern>/*</url-pattern>
		</filter-mapping>
		
---
###再以此配置前端控制器 Spring监听器 就可以了 
		<!-- 使用 spring的监听器  加载spring容器 -->
		<context-param>
			<param-name>contextConfigLocation</param-name>
			<param-value>/WEB-INF/classes/spring/applicationContext-*.xml</param-value>
		</context-param>
		<listener>
			<listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
		</listener>
			<!-- springmvc前端控制器 -->
		<servlet>
			<servlet-name>springmvc</servlet-name>
			<servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
			<!-- contextConfigLocation配置springmvc加载的配置文件（配置处理器映射器、适配器等等） 如果不配置contextConfigLocation，默认加载的是/WEB-INF/servlet名称-serlvet.xml（springmvc-servlet.xml） -->
			<init-param>
				<param-name>contextConfigLocation</param-name>
				<param-value>classpath:spring/springmvc.xml</param-value>
			</init-param>
		</servlet>
			




