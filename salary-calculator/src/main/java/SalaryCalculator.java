public class SalaryCalculator {
    public double salaryMultiplier(int daysSkipped) {
        return daysSkipped < 5 ? 1 : 0.85;
    }

    public int bonusMultiplier(int productsSold) {
        throw new UnsupportedOperationException("Please implement the SalaryCalculator.bonusMultiplier() method");
    }

    public double bonusForProductsSold(int productsSold) {
        throw new UnsupportedOperationException("Please implement the SalaryCalculator.bonusForProductsSold() method");
    }

    public double finalSalary(int daysSkipped, int productsSold) {
        throw new UnsupportedOperationException("Please implement the SalaryCalculator.finalSalary() method");
    } 
}
