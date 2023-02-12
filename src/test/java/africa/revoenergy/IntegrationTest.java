package africa.revoenergy;

import africa.revoenergy.CustomerApp;
import africa.revoenergy.config.AsyncSyncConfiguration;
import africa.revoenergy.config.EmbeddedElasticsearch;
import africa.revoenergy.config.EmbeddedKafka;
import africa.revoenergy.config.EmbeddedMongo;
import africa.revoenergy.config.TestSecurityConfiguration;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

/**
 * Base composite annotation for integration tests.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@SpringBootTest(classes = { CustomerApp.class, AsyncSyncConfiguration.class, TestSecurityConfiguration.class })
@EmbeddedMongo
@EmbeddedElasticsearch
@EmbeddedKafka
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
public @interface IntegrationTest {
}
