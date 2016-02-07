package com.github.hilcode.text.impl;

import com.github.hilcode.text.Indentation;

/**
 * An {@code IndentationBuilder} adds an internally used method to {@code Indentation.Builder}.
 */
public interface IndentationBuilder
        extends
            Indentation.Builder
{
    /**
     * Creates a new {@code Indentation} instance. Calling this method twice (with the same previous
     * {@code Indentation}) will yield the same {@code Indentation} instance.
     *
     * @param previousIndentation
     *         the current indentation that should be further indented.
     * @return a further indented {@code Indentation} instance.
     */
    Indentation newIndentation(Indentation previousIndentation);
}
