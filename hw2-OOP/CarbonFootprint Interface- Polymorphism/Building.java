public class Building implements CarbonFootprint
{
    private double averageMonthlyKwh;
    private final int months = 12;
    
    public Building(double averageMonthlyKwh)
	{
		if (averageMonthlyKwh < 0.0)
			throw new IllegalArgumentException("Average monthly Kwh must be >= 0.0");
        
		this.averageMonthlyKwh = averageMonthlyKwh;
    }
    
	public void setAverageMonthlyKwh(double averageMonthlyKwh)
	{
        if (averageMonthlyKwh < 0.0)
			throw new IllegalArgumentException("Average monthly Kwh must be >= 0.0");
        
		this.averageMonthlyKwh = averageMonthlyKwh;
    }
    
	public double getAverageMonthlyKwh()
	{
        return averageMonthlyKwh;
    }
    
	@Override 
    public String toString()
	{
        return String.format("Building:%n%s: %.2f\n", "the monthly consumption is ", getAverageMonthlyKwh());
    }
    
	@Override
    public double getCarbonFootprint()
	{
        return getAverageMonthlyKwh() * months;
    }
}