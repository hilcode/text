package com.github.hilcode.text;

/**
 * An instance of {@code Show} can be output as a {@code String}.
 */
public interface Show
{
    /**
     * Shows the value of this instance as a {@code String}.
     *
     * @return the value of this instance as a {@code String}.
     */
    String show();

    /**
     * An instance of {@code WithIndentation} can be output as a {@code String} using a given {@code Indentation}.
     */
    public interface WithIndentation
            extends
                Show
    {
        /**
         * Shows the value of this instance as a {@code String} indented with the given {@code Indentation}.
         *
         * @param indentation
         *         the {@code Indentation} to use.
         * @return the value of this instance as a {@code String} indented with the given {@code Indentation}.
         */
        String show(Indentation indentation);
    }
}
