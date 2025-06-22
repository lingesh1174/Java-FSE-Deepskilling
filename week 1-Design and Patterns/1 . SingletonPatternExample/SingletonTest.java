class Logger{
    private static volatile Logger instance;
    private Logger(){
        System.out.println("Logger initialized");
    }
    public static Logger getInstance(){
        if(instance == null){
            synchronized(Logger.class){
                if(instance == null)
                    instance = new Logger();
            }
        }
        return instance;
    }
    public void log(String message){
        System.out.println("[LOG]"+ message);
    }
}
public class SingletonTest{
    public static void main(String[] args) {
        Logger log1 = Logger.getInstance();
        log1.log("First Message");
        Logger log2 = Logger.getInstance();
        log2.log("Second Message");
        System.out.println("Single object created : "+(log1==log2));
    }
}