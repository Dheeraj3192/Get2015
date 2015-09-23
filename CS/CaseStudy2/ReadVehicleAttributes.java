
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ReadVehicleAttributes {
	
	private Document dom;
	private List<Vehicle> vehicleList;

	public Document getDom() {
		return dom;
	}

	public void setDom(Document dom) {
		this.dom = dom;
	}

	public List<Vehicle> getVehicleList() {
		return vehicleList;
	}

	public void setVehicleList(List<Vehicle> vehicleList) {
		this.vehicleList = vehicleList;
	}

	public ReadVehicleAttributes() {
		vehicleList = new ArrayList<Vehicle>();
	}
	
	public void parseXmlFile() {
		//get the factory
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		
		try {
			//Using factory get an instance of document builder
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			//parse using builder to get DOM representation of the XML file
			dom = documentBuilder.parse("vehicle.xml");
		}catch(ParserConfigurationException pce) {
			System.out.println("Parsing error occured");
			System.exit(1);
		}catch(SAXException se) {
			System.out.println("Error occured");
			System.exit(1);
		}catch(IOException ioe) {
			System.out.println("Input is invalid ");
			System.exit(1);
		}
	}
	
	public void parseDocument() {
		//get the root elememt
		Element documentElement = dom.getDocumentElement();
		Vehicle vehicle=null;
		Element  element= null;
		//get a nodelist of <vehicle> elements
		if(!documentElement.getNodeName().equalsIgnoreCase("vehicle")) {
			System.out.println("vehilce  doesn't  match");
			System.exit(1);
		}
		NodeList nodeList = documentElement.getChildNodes();
		if(nodeList != null && nodeList.getLength() > 0) {
			for(int index = 0 ; index < nodeList.getLength();index++) {
				String nodeName =nodeList.item(index).getNodeName();
				if(nodeName.equalsIgnoreCase("#text"))
					continue;
				element = (Element)nodeList.item(index);
				vehicle = getVehicle(element);
				//add it to list
				if(vehicle!=null)
					vehicleList.add(vehicle);
			}
		}
	}
	
	private Vehicle getVehicle(Element vehicleElement) {
		
		Vehicle vehicle=null;
		String vehileType = vehicleElement.getNodeName().toUpperCase();
		if(vehileType.equalsIgnoreCase("car"))
			vehicle = new Car();
		else if(vehileType.equalsIgnoreCase("bike"))
			vehicle = new Bike();
		if(vehicle==null)
			return null;
		vehicle.setMakeYear(getTextValue(vehicleElement, "makeYear"));
		vehicle.setModel(getTextValue(vehicleElement, "model"));
		vehicle.setEngineInCC(getIntValue(vehicleElement, "engineInCC"));
		vehicle.setFuelCapacity(getIntValue(vehicleElement, "fuelCapacity"));
		vehicle.setMilage(getDoubleValue(vehicleElement, "milage"));
		vehicle.setPrice(getDoubleValue(vehicleElement, "price"));
		vehicle.setRoadTax(getDoubleValue(vehicleElement, "roadTax"));
		vehicle.setVehicleType(getVehicleTypeValue(vehileType));
		vehicle.setCreatedBy(getTextValue(vehicleElement, "createdBy"));
		
		DateFormat shortDateFormat = DateFormat.getDateInstance(DateFormat.SHORT);
		Date date = null;
		try {
			date = shortDateFormat.parse(getTextValue(vehicleElement, "createdTime"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if(date == null)
		{
			System.out.println("Date is null");
			System.exit(1);
		}
		vehicle.setCreatedTime(date);
		if(vehicle instanceof Car) {
			((Car) vehicle).setHasAC(getIsAvailableValue(vehicleElement,"hasAC"));
			((Car) vehicle).setHaspowerSteering(getIsAvailableValue(vehicleElement,"hasPowerSteering"));
			((Car) vehicle).setHasaccessoryKit(getIsAvailableValue(vehicleElement, "hasAccessoryKit"));
		}
		else if (vehicle instanceof Bike) {
			 ((Bike) vehicle).setIsSelfStart(getIsAvailableValue(vehicleElement, "isSelfStart"));
			 ((Bike) vehicle).setHelmetPrice(getIntValue(vehicleElement, "helmetPrice"));
		}
		return vehicle;
	}
	
	private String getTextValue(Element element, String tagName) {
		
		String textValue = null;
		NodeList nodeList = element.getElementsByTagName(tagName);
		if (nodeList != null && nodeList.getLength() > 0) {
			Element elementl = (Element) nodeList.item(0);
			textValue = elementl.getFirstChild().getNodeValue().trim();
		}

		return textValue;
	}

	private double getDoubleValue(Element element, String tagName) {
		
		double data = 0;
		try {
			data =Double.parseDouble(getTextValue(element, tagName).trim());
		}
		catch(NumberFormatException nf)
		{
			System.out.println("Invaild number found");
			System.exit(1);
		}
		return data;
	}

	private int getIntValue(Element element, String tagName) {
		
		int data =0;
		try {
			data =Integer.parseInt(getTextValue(element, tagName).trim());
		}
		catch(NumberFormatException nf)
		{
			System.out.println("Invalid no found");
			System.exit(1);
		}
		return data;
	}
	
	private VehicleType getVehicleTypeValue(String input)
	{
		VehicleType vehicleType=null;
		try {
		vehicleType= VehicleType.valueOf(input);
		}
		catch (IllegalArgumentException iae) {
			System.out.println("Invalid type found");
			System.exit(1);
		}
		return vehicleType;
	}
	
	private IsAvailable getIsAvailableValue(Element element ,String tagName)
	{
	
		String  input=  getTextValue(element, tagName).toUpperCase();
		IsAvailable isAvailable= null;
		
		try {
			isAvailable=IsAvailable.valueOf(input);
		} catch (IllegalArgumentException e) {
			System.out.println("Invalid type found");
			System.exit(1);
		}
		return isAvailable;
	}	
}
