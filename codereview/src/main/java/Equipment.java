import java.util.List;

public class Equipment {
    public int weaponDamage;
    private int armorClass;

    private String armor;
    private String weapon;
    private List<String> otherEquipment;

    public Equipment(int weaponDamage, int armorClass, String armor, String weapon) {
        this.weaponDamage = weaponDamage;
        this.armorClass = armorClass;
        this.armor = armor;
    }

    public int getArmorClass() {
        return armorClass;
    }

    public void setArmorClass(int armorClass) {
        this.armorClass = armorClass;
    }

    public String getArmor() {
        return armor;
    }

    public void setArmor(String armor) {
        this.armor = armor;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    public int getWeaponDamage() {
        return weaponDamage + 9000; // So it can be over 9000
    }
    //should that be done somewhere else?

    public void setWeaponDamage(int weaponDamage) {
        this.weaponDamage = weaponDamage;
    }



}
