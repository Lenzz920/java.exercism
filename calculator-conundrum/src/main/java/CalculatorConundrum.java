class CalculatorConundrum {
    public String calculate(int operand1, int operand2, String operation) {
        return switch (operation) {
            case "+" -> operand1 + " + " + operand2 + " = " + (operand1 + operand2);
            case "-" -> operand1 + " - " + operand2 + " = " + (operand1 - operand2);
            case "*" -> operand1 + " * " + operand2 + " = " + (operand1 * operand2);
            case "/" -> operand1 + " / " + operand2 + " = " + (operand1 / operand2);
            default -> throw new IllegalOperationException();
        };
    }
}
