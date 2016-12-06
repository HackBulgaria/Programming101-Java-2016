# Zombie Apocalypse

The time has come. Zombies are everywhere. It is the zombie apocalypse!

You are in a room with zombies. You grab a weapon and start to fight them.

And since you are a Java programmer, you fight them by writing a Java program to fight them.

You have an interface for a weapon:

```java
public interface Weapon {
  public int getDamage();
  public int getDurability();
  public String getType(); // can return "TO_SMASH" or "TO_SHOOT"
}
```

The possible weapons around you are:

* An `Axe` with damage of 10 and durability of 50.
* A `Shotgun` with damage of 25 and durability of 10.
* An `AncientSword` with damage of 50 and durability of 10. 
* A `Revolver` with damage of 15 and durability of 6.

## Durability, damage and types

Depending on the weapon type, you have the following fighting dynamics:

### TO_SMASH weapons

Weapons with type `TO_SMASH` lose their durability, everytime you hit a zombie.

Once the durability of the weapon goes below 50% of the original durability value, the weapon deals 1 damage less with each hit.

**For example** if you have `Axe` with damage = 10 and durability = 4 we have:

* First hit, `durability = 4`. 4 >= 4 / 2, so the weapon deals 10 damage. Durability decreases to 3.
* Second hit, `durability = 3`. 3 >= 4 / 2, so the weapon deals 10 damage. Durability decreases to 2.
* Third hit, `durability = 2`. 2 >= 4 / 2, so the weapon deals 10 damage. Durability decreases to 1.
* Fourth hit, `durability = 1`, 1 < 4 / 2, so the weapon deals 9 damage. Durability goes to 0 and stays there.

Every hit that comes after this, will decrease the damage by 1, until the damage becomes 1. This is the lowest point for damage.

### TO_SHOOT weapons

Weapons with type `TO_SHOOT` have bullets. The durability for that weapon is equal to the amount of bullets they have.

Once the durability (bullets) goes to `0`, your can start smashing your enemies with the weapon (in cold blood).

The damage of the weapon is always `1`, when you run out of bullets.

## Zombies

There is a `Zombie` interface:

```java
public interface Zombie {
  public int getTotalHealth();
  public int getCurrentHealth();
  public void hit(int damage);
  public boolean isDead();
}
```

Implement the interface with a proper class. This is your job. The name of the methods should give you a clue of their implementation.

We need to be able to kill Zombies.

## The game

Implement a Java program, that:

* Reads one integer `n` from the input - this is the number of zombies in your room
* Reads another integer `zombieHealth` from the input - this is going to be the total health of each zombie.
* Reads one string `weapon` which is either one of the values `{"axe", "shotgun", "sword", "revolver"}`  - this is the weapon you are going to have in the room.

**On one line of the standard input, print the number of hits you have to make in order to kill all zombies in the room.**

## Example

Input:

```
2 10
Axe
```

Output:

```
2
```

We kill the first zombie (`damage = 10`, `health = 10`) with the first hit. We do the same with the second hit.

---

Input:

```
3 100
sword
```

Output:

```
7
```

* We kill the fist zombie with two hits. `Durability = 8`
* We kill the second zombie with two hits. `Durability = 6`
* We hit the third zombie once, `Durability = 5`. The next hit will deal `49` damage. So we need another hit, with `48` damage to kill it.
* A total of `7` hits.
