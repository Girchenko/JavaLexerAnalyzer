package LexerAnalyzer;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum Token {
    PACKAGE_KEYWORD("package"),
    IMPORT_KEYWORD("import"),
    CLASS_KEYWORD("class"),
    PUBLIC_KEYWORD("public"),
    PRIVATE_KEYWORD("private"),
    PROTECTED_KEYWORD("protected"),
    ENUM_KEYWORD("enum"),
    STATIC_KEYWORD("static"),
    FINAL_KEYWORD("final"),
    RETURN_KEYWORD("return"),
    TYPE_INT("int"),
    TYPE_CHAR("char"),
    TYPE_VOID("void"),
    TYPE_STRING("String"),
    IF_KEYWORD("if"),
    WHILE_KEYWORD("while"),
    ELSE_KEYWORD("else"),
    NEW_KEYWORD("new"),
    EXCLAMATION("!"),
    COLON(":"),
    SEMICOLON(";"),
    COMMA(","),
    DOT("\\."),
    MULTILINE_COMMENT("/\\*([^/\\*]*)\\*/"),
    SINGLE_LINE_COMMENT("[/]+.*$"),
    OPEN_BRACKET("\\{"),
    CLOSE_BRACKET("\\}"),
    OPEN_SQUARE_BRACKET("\\["),
    CLOSE_SQUARE_BRACKET("\\]"),
    OPEN_PARENTHESIS("\\("),
    CLOSE_PARENTHESIS("\\)"),

    EQUAL("=="),
    DIFFERENT("<>"),
    GREATER_EQUAL(">="),
    LESSER_EQUAL("<="),
    ATTRIBUTION("="),
    GREATER(">"),
    LESSER("<"),
    // That's single line comment
    ADDITION("\\+"),
    SUBTRACTION("-"),
    MULTIPLICATION("\\*"),
    DIVISION("/"),
    MODULUS("%"),

    STRING("\"([^\"]*)\""),
    CHAR("'([^']*)'"),

    NUMBER("\\d+(\\.\\d+)?"),
    IDENTIFIER("\\w+");

    private final Pattern pattern;

    Token(String regex) {
        pattern = Pattern.compile("^" + regex);
    }

    int endOfMatch(String s) {
        Matcher m = pattern.matcher(s);

        if (m.find()) {
            return m.end();
        }

        return -1;
    }
}
