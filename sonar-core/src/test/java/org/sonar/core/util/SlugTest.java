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

import org.junit.Test;

public class SlugTest {

  @Test
  public void slugify() {
    assertThat(Slug.slugify("foo")).isEqualTo("foo");
    assertThat(Slug.slugify("  FOO ")).isEqualTo("foo");
    assertThat(Slug.slugify("he's here")).isEqualTo("he-s-here");
    assertThat(Slug.slugify("foo-bar")).isEqualTo("foo-bar");
    assertThat(Slug.slugify("foo_bar")).isEqualTo("foo_bar");
    assertThat(Slug.slugify("accents éà")).isEqualTo("accents-ea");
    assertThat(Slug.slugify("<foo>")).isEqualTo("foo");
    assertThat(Slug.slugify("<\"foo:\">")).isEqualTo("foo");
  }

  @Test
  public void slugify_collapses_multiple_dashes() {
    assertThat(Slug.slugify("---all-i-wanna-do---")).isEqualTo("all-i-wanna-do");
    assertThat(Slug.slugify("is----have--some-----------fun")).isEqualTo("is-have-some-fun");
  }

  @Test
  public void slugify_handles_empty_strings() {
    assertThat(Slug.slugify("")).isEqualTo("");
    assertThat(Slug.slugify("     ")).isEqualTo("");
    assertThat(Slug.slugify("----")).isEqualTo("");
  }

  @Test
  public void slugify_handles_numbers() {
    assertThat(Slug.slugify("test 123")).isEqualTo("test-123");
    assertThat(Slug.slugify("123test")).isEqualTo("123test");
    assertThat(Slug.slugify("version 2.0")).isEqualTo("version-2-0");
  }

  @Test
  public void slugify_handles_special_characters() {
    assertThat(Slug.slugify("C# Developer")).isEqualTo("c-developer");
    assertThat(Slug.slugify("C++ Developer")).isEqualTo("c-developer");
    assertThat(Slug.slugify("Node.js Developer")).isEqualTo("node-js-developer");
    assertThat(Slug.slugify("100% Effective!")).isEqualTo("100-effective");
    assertThat(Slug.slugify("$$$")).isEqualTo("");
    assertThat(Slug.slugify("$$$ --- $$$")).isEqualTo("");
  }
}
