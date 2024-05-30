class Item {
    String name;
    int rank;
    double price;
    public Item(String name, int rank, double price) {
        this.name = name;
        this.rank = rank;
        this.price = price;
    }

    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Rank: " + rank);
        System.out.println("Price: $" + price);
    }
}

