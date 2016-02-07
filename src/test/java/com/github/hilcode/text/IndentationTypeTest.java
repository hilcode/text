package com.github.hilcode.text;

import static org.junit.Assert.assertSame;
import org.junit.Test;

/**
 * The unit tests for {@code IndentationType}.
 */
public final class IndentationTypeTest
{
    /**
     * Tests that {@code IndentationType.USE_2_SPACES} actually uses 2 spaces.
     */
    @Test
    public final void test_that_IndentationType_USE_2_SPACES_actually_uses_2_spaces()
    {
        assertSame("  ", IndentationType.USE_2_SPACES.show());
    }

    /**
     * Tests that {@code IndentationType.USE_4_SPACES} actually uses 4 spaces.
     */
    @Test
    public final void test_that_IndentationType_USE_4_SPACES_actually_uses_4_spaces()
    {
        assertSame("    ", IndentationType.USE_4_SPACES.show());
    }

    /**
     * Tests that {@code IndentationType.USE_8_SPACES} actually uses 8 spaces.
     */
    @Test
    public final void test_that_IndentationType_USE_8_SPACES_actually_uses_8_spaces()
    {
        assertSame("        ", IndentationType.USE_8_SPACES.show());
    }

    /**
     * Tests that {@code IndentationType.USE_TABS} actually uses 1 tab.
     */
    @Test
    public final void test_that_IndentationType_USE_TABS_actually_uses_1_tab()
    {
        assertSame("\t", IndentationType.USE_TABS.show());
    }
}
