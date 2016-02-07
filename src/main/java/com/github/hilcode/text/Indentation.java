package com.github.hilcode.text;

/**
 * An {@code Indentation} instance represents a certain level of indentation.
 */
public interface Indentation
        extends
            Show
{
    /**
     * An {@code Indentation.Builder} facilitates building of new {@code Indentation} instances.
     */
    public interface Builder
    {
        /**
         * Creates a new {@code Indentation} instance. Calling this method twice (with the same {@code IndentationType})
         * will yield the same {@code Indentation} instance.
         *
         * @param indentationType
         *         the indentation type (e.g. 2 spaces or 1 tab) to use.
         * @return a new {@code Indentation} instance with the given {@code IndentationType}.
         */
        Indentation newIndentation(IndentationType indentationType);
    }

    /**
     * Gets the indentation level of this {@code Indentation}. This is at least {@code 0} (no indentation).
     *
     * @return the indentation level of this {@code Indentation}.
     */
    int level();

    /**
     * Gets the type of indentation used. E.g., 2 spaces or 1 tab.
     *
     * @return the type of indentation used.
     */
    IndentationType type();

    /**
     * Returns an {@code Indentation} instance indented one level more than this {@code Indentation}.
     *
     * @return an {@code Indentation} instance indented one level more than this {@code Indentation}.
     */
    Indentation indent();

    /**
     * Returns an {@code Indentation} instance indented one level less than this {@code Indentation}.
     *
     * @return an {@code Indentation} instance indented one level less than this {@code Indentation}.
     */
    Indentation dedent();
}
