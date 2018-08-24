public class CarbonFootprintTest
{
	public static void main(String[] args)
	{
		CarbonFootprint[] carbonFootprintObjects = new CarbonFootprint[3];
		carbonFootprintObjects[0] = new Building(4000.52);
		carbonFootprintObjects[1] = new Car(5845.25, 20.5);
		carbonFootprintObjects[2] = new Bicycle(200.00);
		
		System.out.println("Carbon Footprint calculate:");
		
		for (CarbonFootprint currentCarbonFootprint : carbonFootprintObjects)
		{
			System.out.printf("%n%s %n%s: %,.2f%n", currentCarbonFootprint.toString(), "total carbon footprint: ", currentCarbonFootprint.getCarbonFootprint());
		}
	}
}