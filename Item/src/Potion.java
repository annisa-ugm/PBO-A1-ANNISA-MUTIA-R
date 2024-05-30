class Potion extends Item implements Usable {
    int duration;
    int effect_point;
    String type;

    public Potion(String name, int rank, double price, int duration, int effect_point, String type) {
        super(name, rank, price);
        this.duration = duration;
        this.effect_point = effect_point;
        this.type = type;
    }


    public void use(String inputType) {
        if (inputType.equalsIgnoreCase("Attack")) {
            System.out.println("Damage dealt by " + effect_point);
        } else if (inputType.equalsIgnoreCase("Heal")) {
            System.out.println("Healed by " + effect_point);
        } else {
            System.out.println("Unknown potion type!");
        }
    }
}
