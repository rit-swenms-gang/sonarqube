package org.sonar.server.ws.systemTest;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.sonarqube.ws.Projects.CreateWsResponse;
import org.sonarqube.ws.System.Health;
import org.sonarqube.ws.client.HttpConnector;
import org.sonarqube.ws.client.WsClient;
import org.sonarqube.ws.client.WsClientFactories;
import org.sonarqube.ws.client.projects.CreateRequest;

public class SystemTest {
  WsClient client;

  @BeforeAll
  public static void init() {
    ProcessBuilder pb = new ProcessBuilder("bash", "start.sh");
    pb.directory(new File("../../../../../../../../../"));
    try {
      Process p = pb.start();
      assertNotNull(p);
    } catch (IOException ioe) {
      System.err.println("Unable to start server\n" + ioe);
      fail();
    }
  }


  @Before
  public void setUp() {
    HttpConnector httpConnector = HttpConnector.newBuilder()
     .url("http://localhost:9000")
     .credentials("admin", "ZN7,P}M#;zD''Xb")
     .build();
    client = null;
    while (client == null) {
      client = WsClientFactories.getDefault().newClient(httpConnector);
    }
    assertNotNull(client);
    while (client != null) {
      if (client.system().health().getHealth() == Health.GREEN) {
        break;
      }
    }
  }

  @After
  public void tearDown() {
    
  }

  @Test
  public void test() {
    assertTrue(true);
  }

  @Test
  public void testServer() {
    
   CreateRequest req = new CreateRequest();
   req.setName("dummy_project");
   req.setProject("dummy_project");
   CreateWsResponse res = client.projects().create(req);
   System.out.println("Hello world");
   assertTrue(res != null);
  }
}