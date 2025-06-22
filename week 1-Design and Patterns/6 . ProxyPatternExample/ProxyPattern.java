interface Image {
    void display();
}

class RealImage implements Image{
    private String fileName;
    public RealImage(String fileName){
        this.fileName = fileName;
        loadFromRemoteServer();
    }
    private void loadFromRemoteServer(){
        System.out.println("Loading image from remote server: " + fileName);
    }
    public void display(){
        System.out.println("Displaying image: " + fileName);
    }
}

class ProxyImage implements Image{
    private String fileName;
    private RealImage realImage;
    public ProxyImage(String fileName){
        this.fileName = fileName;
    }
    public void display(){
        if (realImage == null){
            realImage = new RealImage(fileName);
        } else {
            System.out.println("Image retrieved from cache: " + fileName);
        }
        realImage.display();
    }
}

public class ProxyPattern{
    public static void main(String[] args) {
        Image image1 = new ProxyImage("nature1.jpg");
        Image image2 = new ProxyImage("nature2.jpg");
        image1.display(); 
        image1.display();
        image2.display();
        image2.display();
    }
}