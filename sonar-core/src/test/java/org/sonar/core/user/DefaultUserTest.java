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
package org.sonar.core.user;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.junit.Test;

public class DefaultUserTest {
  @Test
  public void testSettersAndGetters() {
    DefaultUser user1 = new DefaultUser()
        .setLogin("jdoe")
        .setName("John Doe")
        .setEmail("john.doe@example.com")
        .setActive(true);

    DefaultUser user2 = new DefaultUser()
        .setLogin("janed")
        .setName("Jane Doe")
        .setEmail(null)
        .setActive(false);

    assertEquals("jdoe", user1.login());
    assertEquals("John Doe", user1.name());
    assertEquals("john.doe@example.com", user1.email());
    assertEquals(true, user1.active());

    assertEquals("janed", user2.login());
    assertEquals("Jane Doe", user2.name());
    assertEquals(null, user2.email());
    assertEquals(false, user2.active());
  }

  @Test
  public void testToString() {
    DefaultUser user = new DefaultUser()
        .setLogin("jdoe")
        .setName("John Doe")
        .setEmail("john.doe@example.com")
        .setActive(true);

    String expected = ToStringBuilder.reflectionToString(user, ToStringStyle.SHORT_PREFIX_STYLE);

    assertEquals(expected, user.toString());
  }

  @Test
  public void testEquals() {
    DefaultUser user1 = new DefaultUser()
        .setLogin("jdoe")
        .setName("John Doe")
        .setEmail("john.doe@example.com")
        .setActive(true);

    DefaultUser user2 = new DefaultUser()
        .setLogin("jdoe")
        .setName("Optimus Prime")
        .setEmail("notjohn.doe@example.com")
        .setActive(false);

    DefaultUser user3 = user1;

    DefaultUser user4 = new DefaultUser()
        .setLogin("johnnyDoe")
        .setName("John Doe")
        .setEmail("john.doe@example.com")
        .setActive(true);

    DefaultUser nullUser = null;

    String notAUser = "not a user";

    assertEquals(user1, user2);
    assertEquals(user1, user3);
    assertNotEquals(user1, user4);
    assertNotEquals(user1, nullUser);
    assertNotEquals(user1, notAUser);
  }

  @Test
  public void testHashCode() {
    DefaultUser user1 = new DefaultUser()
        .setLogin("jdoe")
        .setName("John Doe")
        .setEmail("john.doe@example.com")
        .setActive(true);

    DefaultUser user2 = new DefaultUser()
        .setLogin("jdoe")
        .setName("Optimus Prime")
        .setEmail("optimus.prime@example.com")
        .setActive(false);

    DefaultUser user3 = new DefaultUser()
        .setLogin("johnnyDoe")
        .setName("John Doe")
        .setEmail("john.doe@example.com")
        .setActive(true);

    assertEquals(user1.hashCode(), user2.hashCode());
    assertNotEquals(user1.hashCode(), user3.hashCode());
  }
}
