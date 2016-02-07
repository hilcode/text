package com.github.hilcode.text;

/**
 * The {@code IndentationType} represents the type of indentation used. E.g., 2 spaces or 1 tab.
 */
public interface IndentationType
        extends
            Show
{
    /**
     * Use 2 spaces per indentation level.
     */
    IndentationType USE_2_SPACES = new IndentationType()
    {
        @Override
        public String show()
        {
            return "  ";
        }
    };
    /**
     * Use 4 spaces per indentation level.
     */
    IndentationType USE_4_SPACES = new IndentationType()
    {
        @Override
        public String show()
        {
            return "    ";
        }
    };
    /**
     * Use 8 spaces per indentation level.
     */
    IndentationType USE_8_SPACES = new IndentationType()
    {
        @Override
        public String show()
        {
            return "        ";
        }
    };
    /**
     * Use 1 tab per indentation level.
     */
    IndentationType USE_TABS = new IndentationType()
    {
        @Override
        public String show()
        {
            return "\t";
        }
    };
}
