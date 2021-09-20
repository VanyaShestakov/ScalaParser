package Parser;

import java.util.*;

public class SourceInfo {

    private List<String> operators;
    private List<String> operands;
    private Set<String> uniqueOperators;
    private Set<String> uniqueOperands;

    public SourceInfo() {
        this.operators = new ArrayList<>();
        this.operands = new ArrayList<>();
        this.uniqueOperators = new HashSet<>();
        this.uniqueOperands = new HashSet<>();
    }

    public void addOperator(String operator) {
        operators.add(operator);
    }

    public void addOperand(String operand) {
        operands.add(operand);
    }

    public List<String> getAllOperators() {
        return operators;
    }

    public List<String> getAllOperands() {
        return operands;
    }

    public Set<String> getUniqueOperators() {
        uniqueOperators.addAll(operators);
        return uniqueOperators;
    }

    public Set<String> getUniqueOperands() {
        uniqueOperands.addAll(operands);
        return uniqueOperands;
    }

    public Map<String, Integer> getOperatorsInfo() {
        if (operators.size() == 0) {
            throw new UnsupportedOperationException();
        }
        Map<String, Integer> operatorsInfo = new HashMap<>();
        for (String operator: operators) {
            if (!operatorsInfo.containsKey(operator)) {
                operatorsInfo.put(operator, 1);
            } else {
                operatorsInfo.put(operator, operatorsInfo.get(operator) + 1);
            }
        }
        return operatorsInfo;
    }

    public int getAmountOfUniqueOperators() {
        return operators.size();
    }

    public int getAmountOfOperators() {
        return uniqueOperators.size();
    }

    public Map<String, Integer> getOperandsInfo() {
        if (operands.size() == 0) {
            throw new UnsupportedOperationException();
        }
        Map<String, Integer> operandsInfo = new HashMap<>();
        for (String operand: operands) {
            if (!operandsInfo.containsKey(operand)) {
                operandsInfo.put(operand, 1);
            } else {
                operandsInfo.put(operand, operandsInfo.get(operand) + 1);
            }
        }
        return operandsInfo;
    }

    public int getAmountOfUniqueOperands() {
        return operands.size();
    }

    public int getAmountOfOperands() {
        return uniqueOperands.size();
    }


    public void clearOperands() {
        operands.clear();
    }
}
