public class Main {
    public static void main(String[] args) {

        Potion potion1 = new Potion("Elixir of Vitality", 1, 50.0, 30, 20, "Heal");
        potion1.displayInfo();
        potion1.use("Heal");

        System.out.println("----------------------------");
        Potion potion2 = new Potion("Mana Brew", 2, 75.0, 25, 15, "Attack");
        potion2.displayInfo();
        potion2.use("Attack");

        System.out.println("----------------------------");
        Sword sword1 = new Sword("Dragon Slayer", 5, 150.0, 35);
        sword1.displayInfo();
        sword1.attack();

        System.out.println("----------------------------");
        Sword sword2 = new Sword("Stormbringer", 4, 120.0, 30);
        sword2.displayInfo();
        sword2.attack();

        System.out.println("----------------------------");
        Shield shield1 = new Shield("Guardian's Bulwark", 3, 75.0, 40);
        shield1.displayInfo();
        shield1.defense();

        System.out.println("----------------------------");
        Shield shield2 = new Shield("Aegis of the Titans", 4, 100.0, 50);
        shield2.displayInfo();
        shield2.defense();
    }
}

