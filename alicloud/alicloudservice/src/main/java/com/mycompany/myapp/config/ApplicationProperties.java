package com.mycompany.myapp.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Properties specific to Alicloudservice.
 * <p>
 * Properties are configured in the {@code application.yml} file.
 * See {@link io.github.jhipster.config.JHipsterProperties} for a good example.
 */
@ConfigurationProperties(prefix = "application", ignoreUnknownFields = false)
public class ApplicationProperties {

    public final ApplicationProperties.Cache  cache= new ApplicationProperties.Cache();

    public ApplicationProperties() {
    }

    public  Cache getCache() {
        return cache;
    }

    @Data
    public static class Cache {
        private int minExpiration;
        private int maxExpiration;

        public Cache(){

        }

        public int getMinExpiration() {
            return minExpiration;
        }

        public void setMinExpiration(int minExpiration) {
            this.minExpiration = minExpiration;
        }

        public int getMaxExpiration() {
            return maxExpiration;
        }

        public void setMaxExpiration(int maxExpiration) {
            this.maxExpiration = maxExpiration;
        }
    }


}
