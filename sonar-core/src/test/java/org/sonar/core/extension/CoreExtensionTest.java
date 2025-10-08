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
package org.sonar.core.extension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Collection;
import java.util.List;

import org.junit.Test;

public class CoreExtensionTest {

  private CoreExtension underTest = new CoreExtension() {
    @Override
    public String getName() {
      return "fake";
    }

    @Override
    public void load(Context context) {
      // nothing to do here
    }
  };

  @Test
  public void getExtensionProperties_by_default_does_not_contain_any_overridden_property_defaults() {
    assertThat(underTest.getExtensionProperties()).isEmpty();
  }

  @SuppressWarnings("unchecked")
  @Test
  public void context_addExtensions_with_varargs_calls_individual_methods() {
  // Create a mock context to track method calls
  CoreExtension.Context mockContext = mock(CoreExtension.Context.class);
  
  // Make the default method call the real implementation
  when(mockContext.addExtensions(any(Object.class), any(Object[].class)))
    .thenCallRealMethod();
  when(mockContext.addExtension(any())).thenReturn(mockContext);
  when(mockContext.<Object>addExtensions(any(Collection.class))).thenReturn(mockContext);
  
  Object component1 = new Object();
  Object component2 = new Object();
  Object component3 = new Object();
  
  // Call the default method
  mockContext.addExtensions(component1, component2, component3);
  
  // Verify interactions
  verify(mockContext).addExtension(component1);
  verify(mockContext).addExtensions(List.of(component2, component3));
}
}
