package ua.tns.employeeproductivity.bean;

public class ProductivityBean {
    int basicStartWorkingDay = 9;
    int workingHours = 8;
    double basicProfitInUSDperHour = 10;
    double productivityHourFactor = 0.2;
    double baseProductivity = workingHours * basicProfitInUSDperHour;


    public double employeeProductivity(int preference) {
        double productivityHourProfit = Math.abs(preference) * (basicProfitInUSDperHour + (basicProfitInUSDperHour * productivityHourFactor));
        double normalHourProfit = (workingHours - Math.abs(preference)) * basicProfitInUSDperHour;
        return productivityHourProfit + normalHourProfit;
    }
}
