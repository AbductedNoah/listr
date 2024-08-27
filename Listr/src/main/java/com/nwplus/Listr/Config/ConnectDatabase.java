package com.nwplus.Listr.Config;

import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.cql.ResultSet;
import com.datastax.oss.driver.api.core.cql.Row;
import java.nio.file.Paths;

import org.springframework.context.annotation.Configuration;

@Configuration
public class ConnectDatabase {

   public void connectDB() {
         // Create the CqlSession object:
         try (CqlSession session = CqlSession.builder()
            .withCloudSecureConnectBundle(Paths.get("F:\\Listr\\secure-connect-listr-test.zip"))
            .withAuthCredentials("uHUyIOSbINmqRkSCltucdMsR","DbOltEYkm-c0Ci0u+SuUS1r8ios7iXKOQHM2PTcvgAWBi,Rb7g4DBnZhBLHierzBsa,0N1De6w6p0zKW,Xp++qRqXKK0eBWLpxcz5tyT-K5Z3eNY-boCDhIPByu0Qw24")
            .build()) {
            // Select the release_version from the system.local table:
            ResultSet rs = session.execute("select release_version from system.local");
            Row row = rs.one();
            //Print the results of the CQL query to the console:
            if (row != null) {
               System.out.println("release-version: " + row.getString("release_version"));
            } else {
               System.out.println("An error occurred.");
            }
         }
   }
}