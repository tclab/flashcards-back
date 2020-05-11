package com.tclab.flashcardsback.configuration;


import io.r2dbc.postgresql.PostgresqlConnectionConfiguration;
import io.r2dbc.postgresql.PostgresqlConnectionFactory;
import io.r2dbc.postgresql.client.SSLMode;
import io.r2dbc.spi.ConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

@Configuration
@EnableR2dbcRepositories
public class DataBaseConfiguration extends AbstractR2dbcConfiguration {

    @Value("${connection.host}")
    private String host;

    @Value("${connection.port}")
    private Integer port;

    @Value("${connection.username}")
    private String username;

    @Value("${connection.password}")
    private String password;

    @Value("${connection.database}")
    private String database;

    @Value("${connection.sslMode}")
    private String sslMode;

    @Override
    @Bean
    public ConnectionFactory connectionFactory() {
        return new PostgresqlConnectionFactory(
                PostgresqlConnectionConfiguration.builder()
                        .host(host)
                        .port(port)
                        .username(username)
                        .password(password)
                        .database(database)
                        .sslMode(SSLMode.fromValue(sslMode))
                        .build());
    }


}
