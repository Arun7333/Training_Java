package org.hikariCP_practice;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = {"org.hikariCP_practice", "org.transaction_practise"})
@EnableTransactionManagement
public class HikariConfigg {

    @Bean
    public HikariConfig getConfig(){
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:mysql://localhost:3306/dao_practice");
        config.setUsername("root");
        config.setPassword("Arun@7339");
        config.setMaximumPoolSize(5);
        config.setMinimumIdle(0);

        return config;
    }

    @Bean
    public HikariDataSource getDataSource(HikariConfig config){
        return new HikariDataSource(config);
    }
}
