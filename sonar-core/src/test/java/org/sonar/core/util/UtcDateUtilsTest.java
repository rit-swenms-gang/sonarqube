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
package org.sonar.core.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.fail;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

public class UtcDateUtilsTest {

  @Test
  public void parse_then_format() {
    Date date = UtcDateUtils.parseDateTime("2014-01-14T14:00:00+0200");
    assertThat(UtcDateUtils.formatDateTime(date)).isEqualTo("2014-01-14T12:00:00+0000");
  }

  @Test
  public void fail_if_bad_format() {
    try {
      UtcDateUtils.parseDateTime("2014-01-14");
      fail();
    } catch (IllegalArgumentException e) {
      assertThat(e).hasMessage("Fail to parse date: 2014-01-14");
    }
  }

  @Test
  public void parseDateTime_handles_various_invalid_formats() {
    String[] invalidFormats = {
      "2014/01/14T12:00:00+0000",   // Wrong date separator
      "2014-01-14 12:00:00+0000",   // Missing T separator
      "2014-01-14T12:00:00",        // Missing timezone
      "14-01-2014T12:00:00+0000",   // Wrong date order
      "2014-13-14T12:00:00+0000",   // Invalid month
      "2014-01-32T12:00:00+0000",   // Invalid day
      "2014-01-14T25:00:00+0000",   // Invalid hour
      "2014-01-14T12:60:00+0000",   // Invalid minute
      "2014-01-14T12:00:60+0000"    // Invalid second
    };

    for (String invalidFormat : invalidFormats) {
      Assert.assertThrows(
        IllegalArgumentException.class, 
        () -> UtcDateUtils.parseDateTime(invalidFormat)
      );
    }
  }

  @Test
  public void parseDateTime_handles_empty_input() {
    String[] emptyInputs = { "", "   ", null };

    for (String emptyInput : emptyInputs) {
      Assert.assertThrows(
        IllegalArgumentException.class, 
        () -> UtcDateUtils.parseDateTime(emptyInput)
      );
    }
  }
}
