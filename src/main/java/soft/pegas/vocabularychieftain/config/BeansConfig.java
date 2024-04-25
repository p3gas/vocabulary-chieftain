package soft.pegas.vocabularychieftain.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import soft.pegas.vocabularychieftain.storage.service.LocalStorageService;
import soft.pegas.vocabularychieftain.storage.service.StorageService;

@Configuration
public class BeansConfig {

    @Bean
    @ConditionalOnProperty("app.storage.local")
    public StorageService createStorageService() {
        return new LocalStorageService();
    }
}
