/* 
 * (C) Copyright 2015-2016 by MSDK Development Team
 *
 * This software is dual-licensed under either
 *
 * (a) the terms of the GNU Lesser General Public License version 2.1
 * as published by the Free Software Foundation
 *
 * or (per the licensee's choosing)
 *
 * (b) the terms of the Eclipse Public License v1.0 as published by
 * the Eclipse Foundation.
 */

package io.github.msdk.rawdata.peakinvestigator.dialogs;

import static org.junit.Assert.assertThat;

import static org.hamcrest.Matchers.equalTo;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

import com.veritomyx.actions.InitAction;
import com.veritomyx.actions.PiVersionsAction;

public class PeakInvestigatorDefaultDialogFactoryTest {

	private final PeakInvestigatorDialogFactory factory = new PeakInvestigatorDefaultDialogFactory();
	private final int DATA_START = 100;
	private final int DATA_END = 2000;

	@Test
	public void testVersionNoLastUsed() {
		PiVersionsAction action = mock(PiVersionsAction.class);
		when(action.getLastUsedVersion()).thenReturn("");
		when(action.getCurrentVersion()).thenReturn("1.3");

		PeakInvestigatorOptionsDialog dialog = factory.getOptionsDialog(action, DATA_START, DATA_END);
		assertThat(dialog.show(), equalTo(PeakInvestigatorDialog.Status.ACCEPT));
		assertThat(dialog.getVersion(), equalTo("1.3"));
		assertThat(dialog.getStartMass(), equalTo(DATA_START));
		assertThat(dialog.getEndMass(), equalTo(DATA_END));
	}

	@Test
	public void testVersionWithLastUsed() {
		PiVersionsAction action = mock(PiVersionsAction.class);
		when(action.getLastUsedVersion()).thenReturn("1.3");
		when(action.getCurrentVersion()).thenReturn("2.0");

		PeakInvestigatorOptionsDialog dialog = factory.getOptionsDialog(action, DATA_START, DATA_END);
		assertThat(dialog.show(), equalTo(PeakInvestigatorDialog.Status.ACCEPT));
		assertThat(dialog.getVersion(), equalTo("1.3"));
		assertThat(dialog.getStartMass(), equalTo(DATA_START));
		assertThat(dialog.getEndMass(), equalTo(DATA_END));
	}

	@Test
	public void testInitWithSufficientFunds() {
		InitAction action = mock(InitAction.class);
		when(action.getFunds()).thenReturn(100.0);
		when(action.getMaxPotentialCost("RTO-24")).thenReturn(50.0);

		PeakInvestigatorInitDialog dialog = factory.getInitDialog(action);
		assertThat(dialog.show(), equalTo(PeakInvestigatorDialog.Status.ACCEPT));
		assertThat(dialog.getRto(), equalTo("RTO-24"));
	}

	@Test
	public void testInitWithoutSufficientFunds() {
		InitAction action = mock(InitAction.class);
		when(action.getFunds()).thenReturn(10.0);
		when(action.getMaxPotentialCost("RTO-24")).thenReturn(50.0);

		PeakInvestigatorInitDialog dialog = factory.getInitDialog(action);
		assertThat(dialog.show(), equalTo(PeakInvestigatorDialog.Status.CANCEL));
	}
}
