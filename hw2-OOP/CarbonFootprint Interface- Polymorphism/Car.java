public class Car implements CarbonFootprint
{
    private double averageYearlyMiles;
    private double averageMPG;
    private final int kgCO2PerMile = 9;
    
    public Car(double averageYearlyMiles, double averageMPG)
	{
		if (averageYearlyMiles < 0.0)
			throw new IllegalArgumentException("Average yearly miles must be >= 0.0");
		if (averageMPG < 0.0)
			throw new IllegalArgumentException("Average MPG must be >= 0.0");
		
        this.averageYearlyMiles = averageYearlyMiles;
        this.averageMPG = averageMPG;
    }
	
    public void setAverageYearlyMiles(double averageYearlyMiles)
	{
		if (averageYearlyMiles < 0.0)
			throw new IllegalArgumentException("Average yearly miles must be >= 0.0");
		
        this.averageYearlyMiles = averageYearlyMiles;
    }
	
    public void setAverageMPG(double averageMPG)
	{
		if (averageMPG < 0.0)
			throw new IllegalArgumentException("Average MPG must be >= 0.0");
		
        this.averageMPG = averageMPG;
    }
	
    public double getAverageYearlyMiles()
	{
        return averageYearlyMiles;
    }
	
    public double getAverageMPG()
	{
        return averageMPG;
    }
	
    @Override
    public String toString()
	{
        return String.format("Car:%n%s: %.2f %n%s: %.2f %n", "Average yearly miles is ", getAverageYearlyMiles(), "Average MPG is ", getAverageMPG() );
    }
	
    @Override
    public double getCarbonFootprint()
	{
        return ((getAverageYearlyMiles() * getAverageMPG()) * kgCO2PerMile);
    }
}