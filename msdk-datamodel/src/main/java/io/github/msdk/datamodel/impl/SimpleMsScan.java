/*
 * (C) Copyright 2015-2017 by MSDK Development Team
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

package io.github.msdk.datamodel.impl;

import java.util.LinkedList;
import java.util.List;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.google.common.base.Preconditions;
import com.google.common.collect.Range;

import io.github.msdk.MSDKRuntimeException;
import io.github.msdk.datamodel.rawdata.ActivationInfo;
import io.github.msdk.datamodel.rawdata.IsolationInfo;
import io.github.msdk.datamodel.rawdata.MsScan;
import io.github.msdk.datamodel.rawdata.MsScanType;
import io.github.msdk.datamodel.rawdata.PolarityType;
import io.github.msdk.datamodel.rawdata.RawDataFile;
import io.github.msdk.util.tolerances.MzTolerance;

/**
 * Simple implementation of the Scan interface.
 *
 */
public class SimpleMsScan extends AbstractMsSpectrum implements MsScan {

  private @Nullable RawDataFile dataFile;
  private @Nonnull Integer scanNumber;
  private @Nullable String scanDefinition;
  private @Nullable String msFunction;
  private @Nonnull Integer msLevel = 1;
  private @Nonnull PolarityType polarity = PolarityType.UNKNOWN;
  private @Nonnull MsScanType msScanType = MsScanType.UNKNOWN;
  private @Nullable MzTolerance mzTolerance;
  private @Nullable Range<Double> scanningRange;
  private @Nullable Float rt;
  private @Nullable ActivationInfo sourceInducedFragInfo;

  private final @Nonnull List<IsolationInfo> isolations = new LinkedList<>();

  /**
   * <p>
   * Constructor for SimpleMsScan.
   * </p>
   *
   * @param dataPointStore a {@link io.github.msdk.datamodel.datastore.DataPointStore} object.
   * @param scanNumber a {@link java.lang.Integer} object.
   * @param msFunction a {@link io.github.msdk.datamodel.rawdata.MsFunction} object.
   */
  public SimpleMsScan(@Nonnull Integer scanNumber) {
    this(scanNumber, null);
  }

  /**
   * <p>
   * Constructor for SimpleMsScan.
   * </p>
   *
   * @param dataPointStore a {@link io.github.msdk.datamodel.datastore.DataPointStore} object.
   * @param scanNumber a {@link java.lang.Integer} object.
   * @param msFunction a {@link io.github.msdk.datamodel.rawdata.MsFunction} object.
   */
  public SimpleMsScan(@Nonnull Integer scanNumber, String msFunction) {
    Preconditions.checkNotNull(scanNumber);
    this.scanNumber = scanNumber;
    this.msFunction = msFunction;
  }

  /** {@inheritDoc} */
  @Override
  @Nullable
  public RawDataFile getRawDataFile() {
    return dataFile;
  }

  /**
   * {@inheritDoc}
   *
   * @param newRawDataFile a {@link io.github.msdk.datamodel.rawdata.RawDataFile} object.
   */
  public void setRawDataFile(@Nonnull RawDataFile newRawDataFile) {
    if ((this.dataFile != null) && (this.dataFile != newRawDataFile)) {
      throw new MSDKRuntimeException(
          "Cannot set the raw data file reference to this scan, because it has already been set");
    }
    this.dataFile = newRawDataFile;
  }

  /** {@inheritDoc} */
  @Override
  @Nonnull
  public Integer getScanNumber() {
    return scanNumber;
  }

  /**
   * {@inheritDoc}
   *
   * @param scanNumber a {@link java.lang.Integer} object.
   */
  public void setScanNumber(@Nonnull Integer scanNumber) {
    Preconditions.checkNotNull(scanNumber);
    this.scanNumber = scanNumber;
  }

  /** {@inheritDoc} */
  @Override
  @Nullable
  public String getScanDefinition() {
    return scanDefinition;
  }

  /**
   * {@inheritDoc}
   *
   * @param scanDefinition a {@link java.lang.String} object.
   */
  public void setScanDefinition(@Nullable String scanDefinition) {
    this.scanDefinition = scanDefinition;
  }

  /** {@inheritDoc} */
  @Override
  @Nullable
  public String getMsFunction() {
    return msFunction;
  }

  /**
   * {@inheritDoc}
   *
   * @param newFunction a {@link io.github.msdk.datamodel.rawdata.MsFunction} object.
   */
  public void setMsFunction(@Nullable String newFunction) {
    this.msFunction = newFunction;
  }

  /** {@inheritDoc} */
  @Override
  @Nullable
  public Integer getMsLevel() {
    return msLevel;
  }

  /** {@inheritDoc} */
  public void setMsLevel(@Nonnull Integer msLevel) {
    this.msLevel = msLevel;
  }

  /** {@inheritDoc} */
  @Override
  @Nullable
  public Range<Double> getScanningRange() {
    return scanningRange;
  }

  /**
   * {@inheritDoc}
   *
   * @param newScanRange a {@link com.google.common.collect.Range} object.
   */
  public void setScanningRange(@Nullable Range<Double> newScanRange) {
    this.scanningRange = newScanRange;
  }

  /** {@inheritDoc} */
  @Override
  @Nonnull
  public PolarityType getPolarity() {
    return polarity;
  }

  /**
   * {@inheritDoc}
   *
   * @param newPolarity a {@link io.github.msdk.datamodel.rawdata.PolarityType} object.
   */
  public void setPolarity(@Nonnull PolarityType newPolarity) {
    Preconditions.checkNotNull(newPolarity);
    this.polarity = newPolarity;
  }

  /** {@inheritDoc} */
  @Override
  @Nonnull
  public MsScanType getMsScanType() {
    return msScanType;
  }

  /**
   * {@inheritDoc}
   *
   * @param newMsScanType a {@link io.github.msdk.datamodel.rawdata.MsScanType} object.
   */
  public void setMsScanType(@Nonnull MsScanType newMsScanType) {
    Preconditions.checkNotNull(newMsScanType);
    this.msScanType = newMsScanType;
  }

  /** {@inheritDoc} */
  @Override
  public MzTolerance getMzTolerance() {
    return mzTolerance;
  }

  /**
   * <p>
   * Setter for the field <code>mzTolerance</code>.
   * </p>
   *
   * @param mzTolerance a {@link io.github.msdk.util.tolerances.MzTolerance} object.
   */
  public void setMzTolerance(MzTolerance mzTolerance) {
    this.mzTolerance = mzTolerance;
  }

  /** {@inheritDoc} */
  @Override
  @Nullable
  public Float getRetentionTime() {
    return rt;
  }

  /**
   * {@inheritDoc}
   *
   * @param rt a {@link java.lang.Float} object.
   */
  public void setRetentionTime(@Nullable Float rt) {
    this.rt = rt;
  }

  /** {@inheritDoc} */
  @Override
  @Nullable
  public ActivationInfo getSourceInducedFragmentation() {
    return sourceInducedFragInfo;
  }

  /**
   * {@inheritDoc}
   *
   * @param newFragmentationInfo a {@link io.github.msdk.datamodel.rawdata.ActivationInfo} object.
   */
  public void setSourceInducedFragmentation(@Nullable ActivationInfo newFragmentationInfo) {
    this.sourceInducedFragInfo = newFragmentationInfo;
  }

  /** {@inheritDoc} */
  @Override
  @Nonnull
  public List<IsolationInfo> getIsolations() {
    return isolations;
  }

}
