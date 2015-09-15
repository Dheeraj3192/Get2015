public  class Vehicle 
{
	
	protected String makeYear;
	protected String  model;
	protected int  engineInCC;
	protected int fuelCapacity;
	protected double milage;
	protected double price;
	protected double roadTax;
	
	public String getMakeYear() {
		return makeYear;
	}
	public void setMakeYear(String makeYear) {
		this.makeYear = makeYear;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String modelNumber) {
		this.model = modelNumber;
	}
	public int getEngineInCC() {
		return engineInCC;
	}
	public void setEngineInCC(int engineInCC) {
		this.engineInCC = engineInCC;
	}
	public int getFuelCapacity() {
		return fuelCapacity;
	}
	public void setFuelCapacity(int fuelCapacity) {
		this.fuelCapacity = fuelCapacity;
	}

	public double getMilage() {
		return milage;
	}
	public void setMilage(double milage) {
		this.milage = milage;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getRoadTax() {
		return roadTax;
	}
	public void setRoadTax(double roadTax) {
		this.roadTax = roadTax;
	}

	@Override
	public String toString() {
		return "Vehicle [makeYear=" + makeYear + ", model=" + model
				+ ", engineInCC=" + engineInCC + ", fuelCapacity="
				+ fuelCapacity + ", milage=" + milage + ", price=" + price
				+ ", roadTax=" + roadTax + "]";
	}
	public double calculateOnRoadPrice()
	{
		return price + roadTax;
	}
	

}
