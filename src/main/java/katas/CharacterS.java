package katas;

public class CharacterS {

    private int maxHealth = 1000;
    private int health = 1000;
    private int level = 1;
    private boolean alive = true;
//    private int attackMaxRange = 1;
//    private String typeOfFighter = "";


    public int getHealth(){
        return this.health;
    }

    public int getLevel() {
        return level;
    }

    public boolean isAlive() {
        return alive;
    }
//    public int getAttackMaxRange() {
//        return attackMaxRange;
//    }

    public void setLevel(int level) {
        this.level = level;
    }

//    public void setTypeOfFighter(String typeOfFighter) {
//        if (typeOfFighter == "Melee"){this.attackMaxRange = 2;}
//        if (typeOfFighter == "Ranged"){this.attackMaxRange = 20;};
//        this.typeOfFighter = typeOfFighter;
//    }

    public void attacksOther(CharacterS victim, int damage){
        if ( victim == this) return;
        if (victim.level - this.level >= 5) { damage = damage / 2;}
        if (this.level - victim.level >= 5) { damage = damage * 2;}
        victim.damage(damage);
    }

    private void damage(int damage) {
        if (this.health - damage <= 0){
            this.alive = false;
            this.health = 0;
            return;
        }
        this.health -= damage;
    }

    public void healOther(CharacterS character, int heal){
        if (character != this) return;
        character.heal(heal);
    }

    private void heal(int heal){
        if (!this.alive) return; // CLÀUSULA SALVAGUARDA
        this.health += heal;
        if (this.health > maxHealth) this.health = maxHealth;
    }


}
