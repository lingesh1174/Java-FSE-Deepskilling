interface Document{
    String type();
}
class WordDocument implements Document{
    public String type(){
        return "Word Document created";
    }
}
class PdfDocument implements Document{
    public String type(){
        return "Pdf Document created";
    }
}
class ExcelDocument implements Document{
    public String type(){
        return "Excel Document created";
    }
}
abstract class DocumentFactory{
    abstract Document createDocument();
}
class WordFactory extends DocumentFactory{
    public Document createDocument(){
        return new WordDocument();
    }
}
class PdfFactory extends DocumentFactory{
    public Document createDocument(){
        return new PdfDocument();
    }
}
class ExcelFactory extends DocumentFactory{
    public Document createDocument(){
        return new ExcelDocument();
    }
}
public class FactoryTest{
    public static void main(String[] args) {
        DocumentFactory doc1 = new PdfFactory();
        Document one = doc1.createDocument();
        System.out.println(one.type());
        DocumentFactory doc2 = new WordFactory();
        Document two = doc2.createDocument();
        System.out.println(two.type()); 
    }
}