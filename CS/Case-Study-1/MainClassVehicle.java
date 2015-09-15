public class MainClassVehicle {


	public static void main(String[] args) 
	{
		
		Car car = (Car) VehicleHelper.createVehicle(VehicleType.CAR, "Mahindra" , "2010");
		System.out.println(car); // display car specification
		System.out.println( "On road Price : "+car.calculateOnRoadPrice());
		
		Bike bike =(Bike) VehicleHelper.createVehicle(VehicleType.BIKE, "TVS", "2008");
		System.out.println(bike); // display bike specification
		System.out.println( "On road Price : "+bike.calculateOnRoadPrice());

	}

}


