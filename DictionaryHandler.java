import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.*;
import java.util.Dictionary;

public class DictionaryHandler  extends DefaultHandler {
    private Dictionary dictionary ;
    private String word;
    private String element;
    private String translation;
    private String example;
    private String grammar;
    private String idiom;
    private String paradigm;

    private String inflection;
    private String explanation;

    private StringBuilder elementValue;
    private Map<String, Map<String, List<String>>> wordMap;
    private Map<String , Set<String>> langClassMap;
    private List<String> translationValues = new ArrayList<>();
    private List<String> grammarsValues = new ArrayList<>();
    private List<String> idiomValues = new ArrayList<>();

    public DictionaryHandler(){

        wordMap = new HashMap<>();
    }
    public void parseXML(String filePath) {
        try{
            SAXParserFactory factory = SAXParserFactory.newDefaultInstance();
            SAXParser saxParser = factory.newSAXParser();
            saxParser.parse(filePath , this);
        }catch (ParserConfigurationException | SAXException | IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void characters(char[] ch, int start ,int length) throws SAXException{
        if (elementValue == null){
            elementValue = new StringBuilder();
        }else {
            elementValue.append(ch,start,length);
        }
    }


    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws  SAXException {
        element = qName;
        switch (qName) {
            case "word":
                word = attributes.getValue("value");
                String value = word;
                langClassMap = new HashMap<>();
                if ("translation".equals(qName)) {
                    String lang = attributes.getValue("lang");
                    String classAttr = attributes.getValue("class");
                    if (lang != null && classAttr != null) {
                        langClassMap.computeIfAbsent(lang + "-" + classAttr, k -> new HashSet<>())
                                .add(attributes.getValue("value"));
                    }
                }
                if (!wordMap.containsKey(value)) {
                    wordMap.put(value, new HashMap<>());
                }
                break;
            case "translation":
                    if (element.equals("word")){
                        translation = attributes.getValue("value");
                        if (translation != null) {
                            translationValues.add(translation);
                            Map<String, List<String>> translations = wordMap.computeIfAbsent(word, k -> new HashMap<>());
                            List<String> translationList = translations.computeIfAbsent(translation, k -> new ArrayList<>());
                            translationList.add(translation);
                        }else if(element.equals("example") || element.equals("idiom")){
                            translation = attributes.getValue("value");
                            Map<String, List<String>> translations = wordMap.get(word);
                            String parentElement = element.equals("example") ? "Example" : "Idiom";
                            List<String> exampleOrIdiomTranslations = translations.computeIfAbsent(parentElement, k -> new ArrayList<>());
                            exampleOrIdiomTranslations.add(translation);
                        }

                    }



                break;
            case "example":
                if ("translation".equals(qName)) {
                    example = attributes.getValue("value");
                    List<String> examples = wordMap.getOrDefault(word, new HashMap<>()).getOrDefault(translation, new ArrayList<>());
                    examples.add(elementValue != null ? elementValue.toString().toString() : "");
                    wordMap.computeIfAbsent(translation, k -> new HashMap<>())
                            .computeIfAbsent(word, k -> new ArrayList<>())
                            .addAll(examples);
                }
                break;
            case "grammar":
                if ("word".equals(element)) {
                    grammar = attributes.getValue("value");
                    if (grammar != null) {
                        grammarsValues.add(grammar);
                    }
                    Map<String, List<String>> grammars = wordMap.computeIfAbsent(word, k -> new HashMap<>());
                    grammars.put("grammar", new ArrayList<>(idiomValues));
                }
                break;
            case "idiom":
                if ("word".equals(element)) {
                    idiom = attributes.getValue("value");
                    if (idiom != null) {
                        idiomValues.add(idiom);
                    }
                    Map<String, List<String>> idioms = wordMap.computeIfAbsent(word, k -> new HashMap<>());
                    idioms.put("idiom", new ArrayList<>(idiomValues));

                }
                break;
        }
    }
    public void endElement(String uri , String langName, String qName ,Attributes attributes)throws SAXException{
        element = qName;
        switch (qName) {
            case "word":

                break;
            case "translation":

                break;
            case "example":

                break;
            case "grammar":

                break;
            case "idiom":

                break;
        }
        elementValue = null;
    }
    public Map<String, Map<String, List<String>>> getWordMap() {
        return wordMap;
    }
    public static void main(String[] args) {
        String filePath = "/Users/susiyuan/IdeaProjects/Disctionary/xml/xxx.xml";
        DictionaryHandler handler = new DictionaryHandler();
        handler.parseXML(filePath);

        Scanner scanner = new Scanner(System.in);
        Map<String, Map<String, List<String>>> wordTranslations = handler.getWordMap();

        while (true) {
            System.out.println("Enter one word : ");
            String userInput = scanner.nextLine();

            Map<String, List<String>> translations = wordTranslations.get(userInput);
            if (translations != null) {
                for (Map.Entry<String, List<String>> entry : translations.entrySet()) {
                    String langClass = entry.getKey();
                    List<String> translationList = entry.getValue();
                    System.out.println("Language and Class: " + langClass);
                    System.out.println("Translations:" );
                    for (String translation : translationList) {
                        System.out.println("- " + translation);
                    } 
                }
            } else {
                System.out.println("No translation found for the word: " + userInput);
            }
        }
    }
}


