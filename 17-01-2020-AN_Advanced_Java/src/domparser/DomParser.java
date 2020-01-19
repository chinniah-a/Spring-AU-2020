package domparser;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;
import java.io.*;

public class DomParser {
	
	/**
	 * @param args
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws IOException
	 */
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = builderFactory.newDocumentBuilder();
		
		Document document = documentBuilder.parse(new File("records.xml"));
		
		document.getDocumentElement().normalize(); 
		
		Element rootTag = document.getDocumentElement();
		System.out.println("Root Name : " + rootTag.getNodeName());
		
		NodeList list = document.getElementsByTagName("record");
		
		for(int i = 0; i < list.getLength(); i++) {
			Node n = list.item(i);
			if (n.getNodeType() == Node.ELEMENT_NODE) {
				Element e = (Element) n;
				System.out.println("Id: " + e.getElementsByTagName("Id").item(0).getTextContent());
				System.out.println("Name: " + e.getElementsByTagName("Name").item(0).getTextContent());
				System.out.println("E-mail: " + e.getElementsByTagName("Email").item(0).getTextContent());
				System.out.println("Country: " + e.getElementsByTagName("Country").item(0).getTextContent());
				System.out.println("Zip: " + e.getElementsByTagName("Zip").item(0).getTextContent());
				System.out.println("Credit Card: " + e.getElementsByTagName("PAN").item(0).getTextContent());
				System.out.println("Contact: " + e.getElementsByTagName("Contact").item(0).getTextContent());
				System.out.println("Contact: " + e.getElementsByTagName("Address").item(0).getTextContent());
				System.out.println("Company: " + e.getElementsByTagName("Company").item(0).getTextContent());
			}
			
			System.out.println(((rootTag.getFirstChild().getNodeValue())));
			
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		}
	}

}
