package com.lc.demo.multidata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 此处需要在启动时剔除掉DataSourceAutoConfiguration
 * 避免启动时会自动加载DataSource参数下的配置，采用自定义形式完成配置
 */
@SpringBootApplication(exclude = {
	DataSourceAutoConfiguration.class
})
@ComponentScan
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class MultidataApplication {

	public static void main(String[] args) {
		SpringApplication.run(MultidataApplication.class, args);
	}
}
