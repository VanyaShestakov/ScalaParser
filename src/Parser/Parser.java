package Parser;
import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    private static final List<String> sourceLines = SourceReader.readSource();

    /*public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        ScalaDictionary dictionary = new ScalaDictionary();

        for (String line: sourceLines) {
            String[] words = line.split(" ");
            for (String word: words) {
                if (!dictionary.getDelimiterCharacters().contains(word) &&
                        !dictionary.getDigits().contains(word) &&
                        !dictionary.getKeywords().contains(word) &&
                        !dictionary.getParentheses().contains(word) &&
                        !dictionary.getMathOperators().contains(word) && !set.contains(word))
                set.add(word);
            }
        }

        try (var writer = new BufferedWriter(new FileWriter("NewSet.txt"))) {
            for (String operand: set) {
                writer.write(operand + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/

    public void parseSourceCode() {
        SourceInfo info = new SourceInfo();
        ScalaDictionary dictionary = new ScalaDictionary();
        Set<String> operators = dictionary.getOperators();
        Set<String> dataTypes = dictionary.getDataTypes();
        Set<String> operands;
        for (String line: sourceLines) {
            line = setSubstitute(line);
            StringTokenizer tokenizer = new StringTokenizer(line, " \t\n\r");
            for (String dataType : dataTypes) {
                fillOperands(line, dataType, info);
            }
            operands = Set.copyOf(info.getAllOperands());
            while (tokenizer.hasMoreTokens()) {
                String currToken = tokenizer.nextToken();
                for (String operator: operators) {
                    findOperator(currToken, operator, info);
                }
                for (String operand: operands) {
                    findOperand(currToken, operand, info);
                }
            }
        }
        System.out.println(info.getAllOperators());
        System.out.println(info.getUniqueOperators());
        System.out.println(info.getAllOperands());
        System.out.println(info.getUniqueOperands());
    }

    private void fillOperands(String line, String dataType, SourceInfo info) {
        ScalaDictionary dictionary = new ScalaDictionary();
        StringTokenizer tokenizer;
        Pattern pattern = Pattern.compile(dataType);
        Matcher matcher = pattern.matcher(line);
        boolean isNotOperand;

        if (matcher.find()) {
            line = line.replaceAll(matcher.group(), "");
            tokenizer = new StringTokenizer(line, " \n;,");
            while (tokenizer.hasMoreTokens()) {
                String currToken = tokenizer.nextToken();
                isNotOperand = false;
                for (String operator : dictionary.getOperators()) {
                    if (currToken.matches(operator)) {
                        isNotOperand = true;
                    }
                }
                if (currToken.matches("\\d+")) {
                    isNotOperand = true;
                }
                if (!isNotOperand) {
                    info.addOperand(currToken);
                }
            }
        }
    }

    private void findOperand(String line, String operand, SourceInfo info) {
        Pattern pattern = Pattern.compile(operand);
        Matcher matcher = pattern.matcher(line);

        while (matcher.find()) {
            info.addOperand(matcher.group());
        }
    }

    private void findOperator(String token, String operator, SourceInfo info) {
        Pattern pattern = Pattern.compile(operator);
        Matcher matcher = pattern.matcher(token);

        while (matcher.find()) {
            info.addOperator(matcher.group());
        }
}

    private String setSubstitute(final String text) {
        StringBuilder stringBuilder = new StringBuilder(text);
        String temp = stringBuilder.toString();
        int startQuote = temp.indexOf('"', 0);
        int endQuote = -1;
        if (startQuote >= 0 ) {
            endQuote = temp.indexOf('"', startQuote + 1);
        }
        int i = 0;
        while (((startQuote >= 0) && (endQuote > startQuote))) {
            i++;
            //String txt;
            //txt = temp.substring(startQuote + 1, endQuote);
            //temp = temp.replaceFirst(txt, "");
            stringBuilder.delete(startQuote + 1, endQuote);
            temp = stringBuilder.toString();
            startQuote = temp.indexOf('"', 2 * i);
            if (startQuote >= 0)
                endQuote = temp.indexOf('"',startQuote+1);
        }
        return stringBuilder.toString();
    }
}
