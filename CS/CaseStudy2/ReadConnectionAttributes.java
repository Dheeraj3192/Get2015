import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ReadConnectionAttributes {

	
	private Document dom; 
	private ConnectionAttributes connectionAttributes;
	
	public Document getDom() {
		return dom;
	}

	public void setDom(Document dom) {
		this.dom = dom;
	}

	public ConnectionAttributes getConnectionAttributes() {
		return connectionAttributes;
	}

	public void setConnectionAttributes(ConnectionAttributes connectionAttributes) {
		this.connectionAttributes = connectionAttributes;
	}

	public ReadConnectionAttributes() {
		connectionAttributes = new ConnectionAttributes();
	}
	
	public void parseXmlFile() {
		//get the factory
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		
		try {
			//Using factory get an instance of document builder
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			//parse using builder to get DOM representation of the XML file
			dom = documentBuilder.parse("dbConnection.xml");
		}catch(ParserConfigurationException pce) {
			pce.printStackTrace();
		}catch(SAXException se) {
			se.printStackTrace();
		}catch(IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
	public void parseDocument() {
		//get the root elememt
		Element documentElement = dom.getDocumentElement();
		
		//get a nodelist of jdbc elements
		NodeList nodeList = documentElement.getElementsByTagName("jdbc");
		if(nodeList != null && nodeList.getLength() > 0) {
			for(int index = 0 ; index < nodeList.getLength();index++) {
				//get the employee element
				Element element = (Element)nodeList.item(index);
				//get the Employee object
				connectionAttributes = getConnectionAttributes(element);
			}
		}
	}
	
	private ConnectionAttributes getConnectionAttributes(Element connectionAttributesElement) {

		// for each <employee> element get text or int values of
		// name ,id, age and name
		String driver= getTextValue(connectionAttributesElement, "driver");
		String url = getTextValue(connectionAttributesElement, "url");
		String username = getTextValue(connectionAttributesElement, "username");
		String password = getTextValue(connectionAttributesElement, "password");

		
		//String type = connectionAttributesElement.getAttribute("type");
		// Create a new Employee with the value read from the xml nodes
		ConnectionAttributes connectionAttributes = new ConnectionAttributes();
		connectionAttributes.setDriver(driver);
		connectionAttributes.setUrl(url);
		connectionAttributes.setUsername(username);
		connectionAttributes.setPassword(password);
		
		return connectionAttributes;
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
	
}
