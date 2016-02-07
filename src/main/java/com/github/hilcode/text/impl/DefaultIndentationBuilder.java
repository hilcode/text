package com.github.hilcode.text.impl;

import com.github.hilcode.text.Indentation;
import com.github.hilcode.text.IndentationType;
import com.google.common.collect.Interner;
import com.google.common.collect.Interners;

/**
 * The default implementation of {@code IndentationBuilder}.
 */
public final class DefaultIndentationBuilder
        implements
            IndentationBuilder
{
    private final Interner<Indentation> interner;

    /**
     * Creates a new {@code DefaultIndentationBuilder}.
     */
    public DefaultIndentationBuilder()
    {
        interner = Interners.newWeakInterner();
    }

    @Override
    public Indentation newIndentation(final IndentationType indentationType)
    {
        final Indentation indentation = new DefaultIndentation(this, indentationType);
        return interner.intern(indentation);
    }

    @Override
    public Indentation newIndentation(final Indentation previousIndentation)
    {
        final Indentation indentation = new DefaultIndentation(this, previousIndentation);
        return interner.intern(indentation);
    }
}
