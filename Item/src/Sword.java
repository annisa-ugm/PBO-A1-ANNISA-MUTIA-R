class Sword extends Item implements Attackable {
    int damage;
    public Sword(String name, int rank, double price, int damage) {
        super(name, rank, price);
        this.damage = damage;
    }

    public void attack() {
        System.out.println("Damage dealt by " + damage);
    }
}

