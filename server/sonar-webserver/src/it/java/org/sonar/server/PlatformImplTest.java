/*
 * SonarQube
 * Copyright (C) 2009-2025 SonarSource SA
 * mailto:info AT sonarsource DOT com
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */
package org.sonar.server;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

import java.util.Properties;

import org.junit.After;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.DisableOnDebug;
import org.junit.rules.TestRule;
import org.junit.rules.Timeout;
import org.sonar.api.config.internal.MapSettings;
import org.sonar.api.testfixtures.log.LogTester;
import org.sonar.api.utils.System2;
import org.sonar.server.platform.PlatformImpl;
import org.sonar.server.platform.db.EmbeddedDatabase;

import jakarta.servlet.ServletContext;

public class PlatformImplTest {
  @Rule
  public LogTester logTester = new LogTester();
  @Rule
  public TestRule safeguardTimeout = new DisableOnDebug(Timeout.seconds(60));

  private MapSettings settings = new MapSettings();
  private System2 system2 = mock(System2.class);
  private EmbeddedDatabase testDb = new EmbeddedDatabase(settings.asConfig(), system2);

  @After
  public void tearDown() {
    if (testDb != null) {
      testDb.stop();
    }
  }

  @Ignore("Problems: unable to mock database instance before able to access doStart")
  @Test
  public void test_doStart() {
    Properties mockProps = mock(Properties.class);
    ServletContext mockCtx = mock(ServletContext.class);
    PlatformImpl testPI = PlatformImpl.getInstance();

    testDb.start();
    testPI.init(mockProps, mockCtx);

    testPI.doStart();

    assertEquals(1, mockCtx.getServletRegistrations().size());
  }
}