/*
 * (C) Copyright 2015-2016 by MSDK Development Team
 *
 * This software is dual-licensed under either
 *
 * (a) the terms of the GNU Lesser General Public License version 2.1 as published by the Free
 * Software Foundation
 *
 * or (per the licensee's choosing)
 *
 * (b) the terms of the Eclipse Public License v1.0 as published by the Eclipse Foundation.
 */

package io.github.msdk.io.mzml2.data;

import java.util.Optional;

public class MzMLProduct {
  private Optional<MzMLIsolationWindow> isolationWindow;

  public MzMLProduct() {
    this.isolationWindow = Optional.ofNullable(null);
  }

  public Optional<MzMLIsolationWindow> getIsolationWindow() {
    return isolationWindow;
  }

  public void setIsolationWindow(MzMLIsolationWindow isolationWindow) {
    this.isolationWindow = Optional.ofNullable(isolationWindow);
  }


}
