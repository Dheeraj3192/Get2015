enum VehicleType {BIKE , CAR};  //It define type of vehicle is bike or car

public class VehicleHelper 
{
	
	public static Vehicle createVehicle(VehicleType vehicleType, String model , String makeYear) 
	{
		if (vehicleType.equals(VehicleType.CAR)) 
			return createCar(model, makeYear);
		 
		else 
			return createBike(model, makeYear);
	}

	public static Car createCar(String model, String  makeYear )
	{
		Car car = new Car();
		car.setModel(model);
		car.setMakeYear(makeYear);
		car.setEngineInCC(1500);
		car.setFuelCapacity(500);
		car.setRoadTax(5400);
		car.setMilage(21.5);
		car.setPrice(8_00_000);
		car.setHasAC(IsAvailable.YES);
		car.setHaspowerSteering(IsAvailable.YES);
		car.setHasaccessoryKit(IsAvailable.YES);
		
		return car;
	}
	
	public static Bike createBike( String model , String makeYear)
	{
		Bike bike = new Bike();
		bike.setModel(model);
		bike.setMakeYear(makeYear);
		bike.setEngineInCC(150);
		bike.setFuelCapacity(40);
		bike.setRoadTax(2400);
		bike.setMilage(35.0);
		bike.setPrice(90_000);
		bike.setHelmetPrice(1101);
		bike.setIsSelfStart(IsAvailable.YES);
		
		return bike;
	}

}
