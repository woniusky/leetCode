package config

import com.zaxxer.hikari.HikariDataSource
import org.apache.ibatis.mapping.Environment
import org.apache.ibatis.session.Configuration
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory
import org.springframework.core.io.DefaultResourceLoader
import org.springframework.core.io.Resource
import org.springframework.jdbc.config.SortedResourcesFactoryBean
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator
import spock.lang.Specification

class BaseSpockInit extends Specification {
    static {
        HikariDataSource dataSource = new HikariDataSource(
                jdbcUrl:"jdbc:h2:mem:unit_test;MODE=MYSQL;DB_CLOSE_DELAY=-1;TRACE_LEVEL_SYSTEM_OUT=0",
                driverClassName: "org.h2.Driver"
        )

        DatabasePopulatorUtils.execute(new ResourceDatabasePopulator(getResource("classpath:ddl/*.sql")), dataSource)

        Environment environment = new Environment("SqlSessionFactoryBean", new JdbcTransactionFactory(), dataSource)

        Configuration configuration = new Configuration()
        configuration.setMapUnderscoreToCamelCase(true)
        configuration.setEnvironment(environment)


    }

    def static getResource(String path) {
        SortedResourcesFactoryBean factoryBean = new SortedResourcesFactoryBean(new DefaultResourceLoader(null), Collections.singletonList(path))
        factoryBean.afterPropertiesSet()
        Resource[] resources = factoryBean.getObject()

        return resources
    }
}
