package Parser;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class ScalaDictionary {
    //regex for functions ^[A-Za-z]+\({1}[A-Za-z1-9,\s""]*\){1};{1}$
    private Set<String> operators = Set.of(
    "\\(", "\\)", "\\[", "\\]", "\\{", "\\}",
    "`", "'", "\"", "\\.", ";", ",", ":",
    "abstract", "case", "catch", "class", "def",    "do", "else", "extends", "false", "final",
    "finally", "for", "forSome", "if",  "implicit", "import", "lazy", "macro", "match", "new",
    "null", "object", "override", "package", "private", "protected", "return", "sealed",
    "super", "this", "throw", "trait", "try", "true", "type", "val", "while", "with", "yield",
    "<", ">", "=", "==", "\\+", "-", "\\*", "!=", "<=", ">=", "-=", "\\+=", "\\*=", "/=", "\\^=", "\\+\\+",
    "--", ">:", "<:", "!",
    "Boolean", "Integer", "Long", "Double", "String", "[A-Za-z]+\\(+");

    public Set<String> getOperators() {
        return operators;
    }
}
