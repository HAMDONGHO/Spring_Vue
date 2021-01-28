package todo.configuration;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

//클래스를 자바 기반의 설정 파일로 인식!
@Configuration
//해당 클래스에서 참조할 properties 파일의 위치를 지정한다.
@PropertySource("classpath:/application.properties")
public class DBConfiguration {

	//빈으로 등록된 인스턴스를 클래스에 주입함
	@Autowired
	//ApplicationContext는 스프링 컨테이너 중 하나. 스프링 컨테이너는 빈의 생성과 사용, 관계, 생명 주기 등을 관리
	private ApplicationContext applicationContext;

	//Bean이 지정된 객체는 컨테이너에 의해 관리되는 빈으로 등록. prefix속성은 @propetySource에 지정된 파일에서 prefix에 해당하는 spring.datasource.hikari로 시작하는 설정을 모두 읽어 메서드에 매핑함.
	@Bean
	@ConfigurationProperties(prefix = "spring.datasource.hikari")
	// hikari는 커넥션 풀 중 하나
	public HikariConfig hikariConfig() {
		return new HikariConfig();
	}

	@Bean
	// 순수 JDBC는 SQL 실행 마다 커넥션 끊고 맺는 I/O작업 해서 리소스 잡아먹음 -> 커넥션 풀로써 커넥션 객체를 생성하고 DB에 접근하는 사용자에게 미리 생성해둔 커넥션 제공하고 다시 돌려받음
	public DataSource dataSource() {
		return new HikariDataSource(hikariConfig());
	}

	@Bean
	//mybatis와 스프링의 연동 모듈로 사용. mybatis xml mapper, 설정 파일 위ㅣ 등을 지정하고 getObject 메서드가 리턴하는 sqlSessionFactory를 생성
	public SqlSessionFactory sqlSessionFactory() throws Exception {
		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
		factoryBean.setDataSource(dataSource());
		//XML Mapper을 인식하도록 하는 역할
		factoryBean.setMapperLocations(applicationContext.getResources("classpath:/mappers/**/*Mapper.xml"));
		factoryBean.setTypeAliasesPackage("todo.domain");
		factoryBean.setConfiguration(mybatisConfig());
		return factoryBean.getObject();
	}

	@Bean
	public SqlSessionTemplate sqlSession() throws Exception {
		return new SqlSessionTemplate(sqlSessionFactory());
	}
	
	@Bean
	@ConfigurationProperties(prefix = "mybatis.configuration")
	public org.apache.ibatis.session.Configuration mybatisConfig(){
		return new org.apache.ibatis.session.Configuration();
	}

}