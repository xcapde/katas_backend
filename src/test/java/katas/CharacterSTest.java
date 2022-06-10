package katas;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CharacterSTest {

    @Test
    void characterStartsWithCorrectAtributes(){
        var fighter = new CharacterS();

        assertEquals(1000, fighter.getHealth());
        assertEquals(1, fighter.getLevel());
        assertEquals(true, fighter.isAlive());
    }

    @Test
    void characterAttackAnotherCharacterAndRestFromHealth(){
        var attacker = new CharacterS();
        var victim = new CharacterS();

        attacker.attacksOther(victim,50);

        assertEquals(950, victim.getHealth());
    }

    @Test
    void whenHealthBelowTo0CharacterDiesAndHealthTurns0(){
        var attacker = new CharacterS();
        var victim = new CharacterS();

        attacker.attacksOther(victim,1500); //VALOR LIMIT ÉS 1000

        assertEquals(false, victim.isAlive());
        assertEquals(0, victim.getHealth());
    }

    // TEST MODIFICAT MÉS TARD SEGONS LA NOVA LÒGICA DE LA KATA 2.2 (victim heal itself)
    @Test
    void characterCanHealItself(){
        var attacker = new CharacterS();
        var victim = new CharacterS();

        attacker.attacksOther(victim,50);
        victim.healOther(victim, 20);

        assertEquals(970, victim.getHealth());
    }

    @Test
    void deadCharacterCannotBeHealed(){
        var attacker = new CharacterS();
        var victim = new CharacterS();
        attacker.attacksOther(victim,1500);

        attacker.healOther(victim, 600);

        assertEquals(0, victim.getHealth());
        assertEquals(false, victim.isAlive());
    }

    // TEST MODIFICAT MÉS TARD SEGONS LA NOVA LÒGICA DE LA KATA 2.2 (victim heal itself)
    @Test
    void characterCannotRise1000Health(){
        var attacker = new CharacterS();
        var victim = new CharacterS();
        attacker.attacksOther(victim,500);

        victim.healOther(victim, 600);

        assertEquals(1000, victim.getHealth());
    }

    @Test
    void characterCannotDamageItself(){
        var attacker = new CharacterS();

        attacker.attacksOther(attacker,500);

        assertEquals(1000, attacker.getHealth());
    }

    @Test
    void characterCanOnlyHealItself(){
        var attacker = new CharacterS();
        var victim = new CharacterS();

        attacker.attacksOther(victim, 500);
        attacker.healOther(victim,50);

        assertEquals(500, victim.getHealth());
    }

}