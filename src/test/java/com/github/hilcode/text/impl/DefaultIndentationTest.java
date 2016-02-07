package com.github.hilcode.text.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.util.Random;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import com.github.hilcode.text.Indentation;
import com.github.hilcode.text.IndentationType;

/**
 * The unit tests for {@code DefaultIndentation}.
 */
public final class DefaultIndentationTest
{
    private final Random rnd = new Random();
    private IndentationBuilder mockIndentationBuilder;
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
        mockIndentationBuilder = Mockito.mock(IndentationBuilder.class);
        mockIndentationType = Mockito.mock(IndentationType.class);
        Mockito.when(mockIndentationType.show()).thenReturn("..");
        mockIndentation = Mockito.mock(Indentation.class);
        Mockito.when(mockIndentation.type()).thenReturn(mockIndentationType);
        Mockito.when(mockIndentation.show()).thenReturn("####");
        randomLevel = 1 + rnd.nextInt(99);
        Mockito.when(mockIndentation.level()).thenReturn(randomLevel);
    }

    /**
     * Tests that an {@code Indentation} instance based on an {@code IndentationType} instance is configured correctly.
     */
    @Test
    public final void test_that_an_Indentation_instance_based_on_an_IndentationType_instance_is_configured_correctly()
    {
        final DefaultIndentation indentation = new DefaultIndentation(mockIndentationBuilder, mockIndentationType);
        assertEquals(0, indentation.level());
        assertSame(mockIndentationType, indentation.type());
    }

    /**
     * Tests that an {@code Indentation} instance based on a previous {@code Indentation} instance is configured
     * correctly.
     */
    @Test
    public final void test_that_an_Indentation_instance_based_on_a_previous_Indentation_instance_is_configured_correctly()
    {
        final DefaultIndentation indentation = new DefaultIndentation(mockIndentationBuilder, mockIndentation);
        assertEquals(randomLevel + 1, indentation.level());
        assertSame(mockIndentationType, indentation.type());
    }

    /**
     * Tests that an {@code Indentation} instance based on an {@code IndentationType} instance has the correct
     * indentation.
     */
    @Test
    public final void test_that_an_Indentation_instance_based_on_an_IndentationType_instance_has_the_correct_indentation()
    {
        final DefaultIndentation indentation = new DefaultIndentation(mockIndentationBuilder, mockIndentationType);
        assertSame("", indentation.show());
        assertSame("", indentation.show());
    }

    /**
     * Tests that an {@code Indentation} instance based on a previous {@code Indentation} instance has the correct
     * indentation.
     */
    @Test
    public final void test_that_an_Indentation_instance_based_on_a_previous_Indentation_instance_has_the_correct_indentation()
    {
        final DefaultIndentation indentation = new DefaultIndentation(mockIndentationBuilder, mockIndentation);
        assertEquals("####..", indentation.show());
        assertSame(indentation.show(), indentation.show());
    }

    /**
     * Tests that dedenting an {@code Indentation} instance based on an {@code IndentationType} instance has the correct
     * indentation.
     */
    @Test
    public final void test_that_dedenting_an_Indentation_instance_based_on_an_IndentationType_instance_has_the_correct_indentation()
    {
        final DefaultIndentation indentation = new DefaultIndentation(mockIndentationBuilder, mockIndentationType);
        assertSame(indentation, indentation.dedent());
    }

    /**
     * Tests that dedenting an {@code Indentation} instance based on a previous {@code Indentation} instance has the
     * correct indentation.
     */
    @Test
    public final void test_that_dedenting_an_Indentation_instance_based_on_a_previous_Indentation_instance_has_the_correct_indentation()
    {
        final DefaultIndentation indentation = new DefaultIndentation(mockIndentationBuilder, mockIndentation);
        assertSame(mockIndentation, indentation.dedent());
    }

    /**
     * Tests that indenting an {@code Indentation} instance based on an {@code IndentationType} instance has the correct
     * indentation.
     */
    @Test
    public final void test_that_indenting_an_Indentation_instance_based_on_an_IndentationType_instance_has_the_correct_indentation()
    {
        final DefaultIndentation indentation = new DefaultIndentation(mockIndentationBuilder, mockIndentationType);
        indentation.indent();
        Mockito.verify(mockIndentationBuilder).newIndentation(indentation);
    }

    /**
     * Tests that indenting an {@code Indentation} instance based on a previous {@code Indentation} instance has the
     * correct indentation.
     */
    @Test
    public final void test_that_indenting_an_Indentation_instance_based_on_a_previous_Indentation_instance_has_the_correct_indentation()
    {
        final DefaultIndentation indentation = new DefaultIndentation(mockIndentationBuilder, mockIndentation);
        indentation.indent();
        Mockito.verify(mockIndentationBuilder).newIndentation(indentation);
    }

    /**
     * Tests that an {@code Indentation} instance's hash code follows the rules.
     */
    @Test
    public final void test_that_an_Indentation_instances_hash_code_follows_the_rules()
    {
        final DefaultIndentation indentation = new DefaultIndentation(mockIndentationBuilder, mockIndentation);
        assertEquals(indentation.hashCode(), indentation.hashCode());
        assertEquals(indentation.hashCode(), new DefaultIndentation(mockIndentationBuilder, mockIndentation).hashCode());
        assertFalse(indentation.hashCode() == new DefaultIndentation(mockIndentationBuilder, mockIndentationType).hashCode());
    }

    /**
     * Tests that an {@code Indentation} instance's equals follows the rules.
     */
    @Test
    @SuppressWarnings("boxing")
    public final void test_that_an_Indentation_instances_equals_follows_the_rules()
    {
        final DefaultIndentation indentation = new DefaultIndentation(mockIndentationBuilder, mockIndentation);
        assertTrue(indentation.equals(indentation));
        assertFalse(indentation.equals(null));
        assertFalse(indentation.equals(new Object()));
        final Indentation previousIndentation = Mockito.mock(Indentation.class);
        Mockito.when(previousIndentation.type()).thenReturn(mockIndentationType);
        Mockito.when(previousIndentation.level()).thenReturn(3);
        final DefaultIndentation indentationLevel4 = new DefaultIndentation(mockIndentationBuilder, previousIndentation);
        Mockito.when(previousIndentation.level()).thenReturn(4);
        final DefaultIndentation indentationLevel5 = new DefaultIndentation(mockIndentationBuilder, previousIndentation);
        assertFalse(indentationLevel4.equals(indentationLevel5));
        Mockito.when(previousIndentation.type()).thenReturn(IndentationType.USE_2_SPACES);
        final DefaultIndentation indentationTwoSpaces = new DefaultIndentation(mockIndentationBuilder, previousIndentation);
        assertFalse(indentationLevel5.equals(indentationTwoSpaces));
    }
}
