package com.github.hilcode.text.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import java.util.Random;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import com.github.hilcode.text.Indentation;
import com.github.hilcode.text.IndentationType;

/**
 * The unit tests for {@code DefaultIndentationBuilder}.
 */
public final class DefaultIndentationBuilderTest
{
    private final Random rnd = new Random();
    private DefaultIndentationBuilder builder;
    private IndentationType mockIndentationType;
    private Indentation mockIndentation;
    private int randomLevel;

    /**
     * Sets up each unit test.
     */
    @Before
    @SuppressWarnings("boxing")
    public void setUp()
    {
        builder = new DefaultIndentationBuilder();
        mockIndentationType = Mockito.mock(IndentationType.class);
        mockIndentation = Mockito.mock(Indentation.class);
        Mockito.when(mockIndentation.type()).thenReturn(mockIndentationType);
        randomLevel = 1 + rnd.nextInt(99);
        Mockito.when(mockIndentation.level()).thenReturn(randomLevel);
    }

    /**
     * Tests that the requested {@code Indentation} instance is correctly configured given the {@code IndentationType}.
     */
    @Test
    public final void test_that_the_requested_Indentation_instance_is_correctly_configured_given_the_IndentationType()
    {
        final Indentation indentation = builder.newIndentation(mockIndentationType);
        assertSame(mockIndentationType, indentation.type());
        assertEquals(0, indentation.level());
    }

    /**
     * Tests that the requested {@code Indentation} instance is correctly configured given the previous {@code Indentation}.
     */
    @Test
    public final void test_that_the_requested_Indentation_instance_is_correctly_configured_given_the_previous_Indentation()
    {
        final Indentation indentation = builder.newIndentation(mockIndentation);
        assertSame(mockIndentationType, indentation.type());
        assertEquals(randomLevel + 1, indentation.level());
    }

    /**
     * Tests that the same {@code Indentation} instance is returned for the same {@code IndentationType}.
     */
    @Test
    public final void test_that_the_same_Indentation_instance_is_returned_for_the_same_IndentationType()
    {
        final Indentation indentation = builder.newIndentation(mockIndentationType);
        assertSame(indentation, builder.newIndentation(mockIndentationType));
    }

    /**
     * Tests that the same {@code Indentation} instance is returned for the same previous {@code Indentation}.
     */
    @Test
    public final void test_that_the_same_Indentation_instance_is_returned_for_the_same_previous_Indentation()
    {
        final Indentation indentation = builder.newIndentation(mockIndentation);
        assertSame(indentation, builder.newIndentation(mockIndentation));
    }
}
