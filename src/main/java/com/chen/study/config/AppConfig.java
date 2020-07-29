package com.chen.study.config;

import com.netflix.config.DynamicConfiguration;
import com.netflix.config.FixedDelayPollingScheduler;
import com.netflix.config.PolledConfigurationSource;
import com.netflix.config.sources.JDBCConfigurationSource;
import org.apache.commons.configuration.AbstractConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class AppConfig {

    @Autowired
    private DataSource dataSource;

    private String sql = "select * from testprop";

    @Bean
   public AbstractConfiguration addApplicationPropertiesSource(){
       PolledConfigurationSource source = new JDBCConfigurationSource(dataSource,
               sql, "key", "value");
       return new DynamicConfiguration(source, new FixedDelayPollingScheduler());
   }


}
