package com.raingxm.finances.util;

import static org.junit.Assert.*;

import org.junit.Test;

public class _RequireTest {

	@Test
	public void that() {
		try {
			Require.that(false, "some message");
			fail("excepted exception");
		} catch (RequireException e) {
			assertEquals("some message", e.getMessage());
		}
	}
}

