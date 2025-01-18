package Day14;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class XMLParser extends DefaultHandler {
    public static void main(String[] args) {
        try{
            File xmlFile = new File("C:\\Users\\Arun P\\IdeaProjects\\Training\\src\\Day14\\test.xml");
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();

            parser.parse(xmlFile, new XMLParser());
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Document started!");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("End started!");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println("Start element : " + qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("End element : " + qName);
        System.out.println();
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String value = new String(ch, start, length);
        if(!value.trim().isEmpty()) {
            System.out.println("Value : " + value);
        }
    }
}
