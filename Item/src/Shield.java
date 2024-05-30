class Shield extends Item implements Defensible {
    int damage_block;
    public Shield(String name, int rank, double price, int damage_block) {
        super(name, rank, price);
        this.damage_block = damage_block;
    }

    public void defense() {
        System.out.println("Damage Mitigated by " + damage_block);
    }
}


