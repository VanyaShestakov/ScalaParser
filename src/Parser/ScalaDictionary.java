package Parser;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class ScalaDictionary {
    //regex for functions ^[A-Za-z]+\({1}[A-Za-z1-9,\s""]*\){1};{1}$
    private Set<String> operators = Set.of(
    "\\(", "\\)", "\\[", "\\]", "\\{", "\\}",
    "`", "'", "\"", "\\.", ";", ",", ":",
    "abstract", "case", "catch", "class", "def", "do", "else", "extends",
    "finally", "for", "forSome", "if",  "implicit", "import", "lazy", "macro", "match", "new",
    "null", "object", "override", "package", "private", "protected", "return", "sealed",
    "super", "this", "throw", "trait", "try", "type", "val", "while", "with", "yield",
    "<", ">", "=", "==", "\\+", "-", "\\*", "!=", "<=", ">=", "-=", "\\+=", "\\*=", "/=", "\\^=", "\\+\\+",
    "--", ">:", "<:", "!", "[A-Za-z]+\\(+");
    private Set<String> dataTypes = Set.of(
    "int\s", "long\s", "short\s", "double\s", "String\s", "boolean\s", "float\s");

    public Set<String> getOperators() {
        return operators;
    }
    public Set<String> getDataTypes() {
        return dataTypes;
    }
}
