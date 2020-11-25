package maow.hndevtools.xml.doc;

import maow.hndevtools.model.Model;
import maow.hndevtools.model.ModelAttribute;
import maow.hndevtools.model.ModelPart;
import maow.hndevtools.util.FileIO;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import java.io.FileWriter;
import java.io.IOException;

public class XMLDocument {
    protected final Document document;
    protected final Element rootElement;
    protected final Model model;

    public XMLDocument(Model model) {
        this.document = DocumentHelper.createDocument();
        this.rootElement = document.addElement(model.getName());
        this.model = model;
    }

    public void write() {
        for (String partName : model.getModelParts().keySet()) {
            ModelPart part = model.getModelParts().get(partName);
            Object partValue = part.getValue();
            Element element = addElement(partName, (String) partValue);
            if (element != null) {
                for (ModelAttribute attribute : part.getAttributes()) {
                    addAttribute(element, attribute.getName(), attribute.getValue());
                }
            }
        }

        OutputFormat format = new OutputFormat();
        format.setIndentSize(4);
        format.setNewlines(true);
        format.setTrimText(false);
        format.setPadText(true);

        try {
            XMLWriter writer = new XMLWriter(new FileWriter(FileIO.OUTPUT_PATH + "/" + model.getName() + ".xml"), format);
            writer.write(document);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected Element addElement(String name, String value) {
        if (value != null && !value.equals("")) {
            Element element = rootElement.addElement(name);
            element.setText(value);
            return element;
        }
        return null;
    }

    protected void addAttribute(Element element, String name, String value) {
        if (value != null && !value.equals("")) {
            element.addAttribute(name, value);
        }
    }
}
