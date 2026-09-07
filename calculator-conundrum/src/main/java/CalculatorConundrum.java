class CalculatorConundrum {
    public String calculate(int operand1, int operand2, String operation) {
        try {
            return switch (operation) {
                case "+" -> format(operand1, operand2, "+", operand1 + operand2);
                case "*" -> format(operand1, operand2, "*", operand1 * operand2);
                case "/" -> format(operand1, operand2, "/", operand1 / operand2);
                case null -> throw new IllegalArgumentException("Operation cannot be null");
                case "" -> throw new IllegalArgumentException("Operation cannot be empty");
                default -> throw new IllegalOperationException("Operation '" + operation + "' does not exist");
            };
        } catch (ArithmeticException e) {
            throw new IllegalOperationException("Division by zero is not allowed", e);
        }
        }

        private String format(int operand1, int operand2, String operation, int result) {
            return operand1 + " " + operation + " " + operand2 + " = " + result;
        }
    }
