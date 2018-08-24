public class Bicycle implements CarbonFootprint
{
    private double yearlyMiles;
    private final int caloriesPerMile = 34;
    
    public Bicycle(double yearlyMiles)
	{
		if (yearlyMiles < 0.0)
			throw new IllegalArgumentException("Yearly miles must be >= 0.0");
		
        this.yearlyMiles = yearlyMiles;
    }
	
    public double getYearlyMiles()
	{
        return yearlyMiles;
    }
	
    public void setYearlyMiles(double yearlyMiles)
	{
        if (yearlyMiles < 0.0)
			throw new IllegalArgumentException("Yearly miles must be >= 0.0");
		
        this.yearlyMiles = yearlyMiles;
    }
	
    @Override
    public String toString()
	{
        return String.format("Bicycle:%n%s: %.2f", "Yearly miles are ", getYearlyMiles());
    }
	
    @Override
    public double getCarbonFootprint()
	{
        return yearlyMiles * caloriesPerMile;
    }
}
