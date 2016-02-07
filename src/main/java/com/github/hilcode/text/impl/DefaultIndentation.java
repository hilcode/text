package com.github.hilcode.text.impl;

import com.github.hilcode.text.Indentation;
import com.github.hilcode.text.IndentationType;

/**
 * The default implementation of {@code Indentation}.
 */
public final class DefaultIndentation
        implements
            Indentation
{
    private final IndentationBuilder indentationBuilder;
    private final Indentation previous;
    private final IndentationType type;
    private final int level;
    private final String indentation;

    /**
     * Creates a new {@code DefaultIndentation} at level 0.
     *
     * @param indentationBuilder
     *         the {@code IndentationBuilder} instance to use to create subsequent {@code Indentation} instances.
     * @param type
     *         the type of indentation to use.
     */
    public DefaultIndentation(final IndentationBuilder indentationBuilder, final IndentationType type)
    {
        this.indentationBuilder = indentationBuilder;
        previous = this;
        this.type = type;
        indentation = "";
        level = 0;
    }

    /**
     * Creates a new {@code DefaultIndentation} by adding 1 indentation level to the given {@code Indentation} instance.
     *
     * @param indentationBuilder
     *         the {@code IndentationBuilder} instance to use to create subsequent {@code Indentation} instances.
     * @param previous
     *         the {@code Indentation} instance to further indent.
     */
    public DefaultIndentation(final IndentationBuilder indentationBuilder, final Indentation previous)
    {
        this.indentationBuilder = indentationBuilder;
        this.previous = previous;
        type = previous.type();
        indentation = previous.show() + type.show();
        level = previous.level() + 1;
    }

    @Override
    public int level()
    {
        return level;
    }

    @Override
    public IndentationType type()
    {
        return type;
    }

    @Override
    public Indentation indent()
    {
        return indentationBuilder.newIndentation(this);
    }

    @Override
    public Indentation dedent()
    {
        return previous;
    }

    @Override
    public String show()
    {
        return indentation;
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + level;
        result = prime * result + type.hashCode();
        return result;
    }

    @Override
    public boolean equals(final Object object)
    {
        if (this == object)
        {
            return true;
        }
        if (object == null || getClass() != object.getClass())
        {
            return false;
        }
        final DefaultIndentation other = (DefaultIndentation) object;
        return level == other.level && type.equals(other.type);
    }
}
