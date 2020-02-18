public class CharacterClass {
    private int weaponDamageModifier;
    private int spellDamageMod;
    private int spellDamageDie;

    private String className;

    public CharacterClass(String className, int wdm, int spellDamageDie, int spellDamageModifier) {
       this.className = className;
       this.weaponDamageModifier = wdm;
       this.spellDamageDie = spellDamageDie;
       this.spellDamageMod = spellDamageModifier;
    }

    public int getWDM() {
        return weaponDamageModifier;
    }

    public int getSpellDamageModifier() {
        return spellDamageMod + 5;
    }

    public int getSpellDamageDie() {
        return spellDamageDie;
    }

    public String getCN() {
        return className;
    }
}
