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
    "--", ">:", "<:", "!", "<<", ">>>", "[A-Za-z]+\\(+");
    private Set<String> dataTypes = Set.of(
    "\sInt\s", "\sLong\s", "\sShort\s", "\sDouble\s", "\sString\s", "\sBoolean\s", "\sfloat\s");
    private Set<String> dynamicTypes = Set.of("\sval\s", "\svar\s");

    public Set<String> getOperators() {
        return operators;
    }
    public Set<String> getDataTypes() {
        return dataTypes;
    }

    public Set<String> getDynamicTypes() {
        return dynamicTypes;
    }
}
