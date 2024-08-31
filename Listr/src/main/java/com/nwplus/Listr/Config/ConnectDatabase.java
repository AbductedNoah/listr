package com.nwplus.Listr.Config;

import com.datastax.oss.driver.api.core.CqlSession;
import java.nio.file.Paths;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConnectDatabase {

    @Bean
    CqlSession cqlSession() {
       return CqlSession.builder()
           .withCloudSecureConnectBundle(Paths.get("F:\\Listr\\secure-connect-listr-test.zip"))
           .withAuthCredentials("uHUyIOSbINmqRkSCltucdMsR", "DbOltEYkm-c0Ci0u+SuUS1r8ios7iXKOQHM2PTcvgAWBi,Rb7g4DBnZhBLHierzBsa,0N1De6w6p0zKW,Xp++qRqXKK0eBWLpxcz5tyT-K5Z3eNY-boCDhIPByu0Qw24")
           .withKeyspace("users")
           .build();
   }
}