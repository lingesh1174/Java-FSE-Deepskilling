class Computer{
    private String CPU , RAM , storage , graphicsCard , OS;

    private Computer(Builder builder){
        this.CPU = builder.CPU;
        this.RAM = builder.RAM;
        this.storage = builder.storage;
        this.graphicsCard = builder.graphicsCard;
        this.OS = builder.operatingSystem;
    }

    public static class Builder{
        private String CPU , RAM , storage = " 256GB " , graphicsCard , operatingSystem;

        public Builder(String CPU, String RAM){
            this.CPU = CPU;
            this.RAM = RAM;
        }

        public Builder setStorage(String storage){
            this.storage = storage;
            return this;
        }

        public Builder setGraphicsCard(String graphicsCard){
            this.graphicsCard = graphicsCard;
            return this;
        }

        public Builder setOperatingSystem(String operatingSystem){
            this.operatingSystem = operatingSystem;
            return this;
        }

        public Computer build(){
            return new Computer(this);
        }
    }

    public String display(){
        return "Computer [CPU=" + CPU +", RAM=" + RAM +", Storage=" + storage +", GraphicsCard=" + graphicsCard +", OperatingSystem=" +OS +"]";
    }
}

public class BuilderTest{
    public static void main(String[] args) {
        Computer basic = new Computer.Builder("Intel i5", "8GB").build();
        Computer gaming = new Computer.Builder("Intel i9", "32GB").setStorage("1TB SSD").setGraphicsCard("NVIDIA RTX 4080").setOperatingSystem("Windows 11").build();
        Computer office = new Computer.Builder("AMD Ryzen 5", "16GB").setStorage("512GB SSD").setOperatingSystem("Windows 10").build();
        System.out.println("Basic Computer: " + basic.display());
        System.out.println("Gaming Computer: " + gaming.display());
        System.out.println("Office Computer: " + office.display());
    }
}