# Dungeons and Zombies

We are going to make a simple, 2D turn-based console game filled with dungeons and zombies!

We are going to have hero, enemies, weapons, treasures and magic!

So lets start with the basic stuff:

## Our Hero

Make a `Hero(name, title, health, mana, manaRegenRate)` class which can be initialized by that (all constructor arguments are shown in the example):

```java
Hero hero = new Hero("Bron", "Dragonslayer", 100, 100, 2);
```

Our hero should have the following methods:

### `knownAs()` method

Add a `knownAs()` method to our Hero, which returns a string, formatted in the following way:
`"{hero_name} the {hero_title}"`

__For example:__

```java
>>> h.knownAs()
Bron the DragonSlayer
```

### `getHealth()` and `getMana()` and `isAlive()` and `canCast()`

Every hero starts with the given `health` and `mana` points.

__Those `health` and `mana` points are the maximum health and mana for the hero!__

* When a hero reaches 0 `health` he is considered death.
* When a hero reaches `mana` lower than the mana needed for the spell he knows, he cannot cast any spells

Implement the following methods:

* `isAlive()` which returns `true`, if our hero is still alive. Otherwise - `false`.
* `getHealth()` which returns the current `health`
* `getMana()` which returns the current `mana`
* `canCast()` which returns `true`, if our hero can cast the magic he has been given. Otherwise - `false`

### `takeDamage(damagePoints)`

So, our hero can take damage which reduces his health.

Implement a method, called `takeDamage(damage_points)`.

This method should reduce the hero's health by `damage`

__If we inflict more damage than we have health, health will always be equal to zero and we cannot get below that!__

### `takeHealing(healingPoints)`

Our hero can also be healed!

Implement a method, called `takeHealing(healingPoints)` which heals our hero.

Note that:

* We cannot heal our hero above the maximum health, which is given by `health`

### `takeMana(manaPoints)`

Our hero can also increase his mana in two ways:

* Each time he makes a move, his `mana` is increased by `manaRegenerationRate` amount.
* He can drink a mana potion, which will increse his mana by the amount of mana points the potion have.

**Hero's mana cannot go above the start `mana` given to him, neither he can go down below 0 mana.**

### `equip(weapon)` method

Our hero can equip one weapon and one spell in order to have damage.

Check the weapon example for more information.

### `learn(spell)` method

The same as `equip`, but takes a `Spell` class.

Our hero can learn only 1 spell at a time.

If you learn a given spell, and after this learn another one, the hero can use only the latest.

### `attack()` method

The method should return the demage done either from the weapon or from the spell (more on that, later)

If the hero has not been equiped with weapon or he has no spells, his attack points are 0. (or maybe something low like 2. It's your choice)

The method can be called in two ways:

* `attack("weapon")` - returns the damage of the weapon if equiped or 0 otherwise (same as above)
* `attack("magic")` - returns the damage of the spell, if equiped or 0 otherwise (same as above)

## The Enemies

Implement a class `Enemy(health, mana, damage)` which is initialized like that:

```java
Enemy enemy = new Enemy(100, 100, 20);
```

The `Enemy` should have the following methods, just like our hero:

* `isAlive()`
* `canCast()`
* `getHealth()`
* `getMana()`
* `takeHealing()`
* `takeMana()`
* `attack()`
* `takeDamage(damage)`

* **Enemies cannot regenerate mana!**
* **Enemies have starting damage, which is different from a weapon or a spell. They can equip weapons or learn spells but it is not required for them to have any damage, as it is for our hero.**

## The weapons and spells

In order for our hero to have proper damage, he must be equiped with either a weapon or a spell.

One hero can carry at max 1 weapon and 1 spell.

### Weapon class

Implement a simple class `Weapon(name, damage)` which behaves like that:

```java
Hero h = new Hero("Bron", "Dragonslayer", 100, 100, 2);
Weapon w = new Weapon("The Axe of Destiny", 20);

h.equip(w);

h.attack("weapon"); // == 20
```

### Spell class

This should be more complex. Implement a spell class `Spell(name, damage, manaCost, castRange)`, which behaves like this:

```java
Spell s = new Spell("Fireball", 30, 50, 2);
```

`name` and `damage` are self explanatory.

* `manaCost` means that the spell needs at least that much amount of mana in order to be casted.
* `castRange` is a bit more special and related to the Dungeon. You can cast that spell on an enemy, which is within the `castRange`. If `castRange` is 1, you can attack enemies, that are next to you. If cast range is greater than 1, you can attack enemies from distance, that is `castRange` squares away. **Casting range is only calculated in a straight line. You cannot curve spells**

## The Dungeons and treasures

We are going to need a dungeon, where our hero can fight his enemies and find powerful weapons and spells!

Our dungeon is going to be a 2D map that looks like that:

```
S.##.....T
#T##..###.
#.###E###E
#.E...###.
###T#####G
```

Where:

* `S` means a starting point for our hero.
* `G` means gateway - the end of the dungeon (and most propably the enter to another)
* `#` is an obstacle
* `.` is a walkable path.
* `T` is a treasure that can be either mana, health, weapon or spell
* `E` is an enemy that our hero can fight

We are going to load the layout of the map from a `String[][]` at the start. And when the task is almost ready - we will load it from a file so we can have multiple levels

We create new dungeon like this:

```
S.##.....T
#T##..###.
#.###E###E
#.E...###.
###T#####G
```

Our `Dungeon` should have the following methods:

### `printMap()`

This should print the map to the console. Check the example above.

### `spawn`

We want to spawn our hero in the `S` location of the map.

Implement a method, called `spawn(hero)` where:

* `hero` is a `Hero` instance

This one takes the first free spawning point in the map and populates it with `H`.

The first free spawning point is the one, that we get if we start from top-left and walk right.

If the spawning is successful - return True. Otherwise (If there are no more spawning points, return False)

**If our hero dies, he can respawn at the next spawning point. If there are no free spawning points, game is over**


So, if we have the map above, let's take the following example:

```java
Hero h = new Hero("Bron", "Dragonslayer", 100, 100, 2);
dungeon.spawn(hero);
dungeon.printMap();
```

```
H.##.....T
#T##..###.
#.###E###E
#.E...###.
###T#####G
```

### `moveHero()`

Now, implemented a method `moveHero(direction)` where:

* `direction` is either `"up"`, `"down"`, `"left"` and `"right"`

This should move our hero in the desired direction.

__For example:__
```java
dungeon.moveHero("right");
```


```
.H##.....T
#T##..###.
#.###E###E
#.E...###.
###T#####G
```

```java
dungeon.moveHero("up");
dungeon.moveHero("down");
dungeon.printMap();
```

```
Found treasure!
..##.....T
#H##..###.
#.###E###E
#.E...###.
###T#####G
```

Here are the cases:

* If you move into an obstacle, don't make the move.
* If you move outside the map - don't make the move.
* If you move into an enemy, a `Fight` is automatically started. Otherwise, you have options, which we will describe in the `Fight` class
* If you move into `Treasure`, roll a dice to decide what it can be - a mana or health potion, a weapon or a spell

### Treasures

It is a good idea to have a finite list of treasures that can be found in a given dungeon.

One idea is to keep a list of treasure in the **txt** file, where the map is. Other idea is to have a separate file that keeps the loot for each map. But that can be done last.

Our suggestion for you is to keep a track of all treasures in the `Dungeon` class and have a method `pickTreasure()` that returns an instance of randomly picked treasure.

## Fights

The interesting part is here.

Our hero must fight his enemies in order to reach the exit of the dungeon.

Our `Dungeon` should have a `heroAttack(by)` method, which checks if our hero can attack either by weapon or by spell, again having a `by` argument, like the `weapon`


A fight happens when:

* Our hero walks into the same position as the enemy - then the fights start automatically
* Our hero is within some range of the enemy and triggers `heroAttack` method call. Then we can attack our enemy, but our enemy must walk to our place in order to start attacking us. This is really helpful with spells!

Implement a `Fight` class that takes a hero and an emeny and simulates a fight between them.

The `Fight` is over when either our hero or the enemy is dead.

Here is a full example:

```java
Hero h = Hero("Bron", "Dragonslayer", 100, 100, 2);
Weapon w = Weapon("The Axe of Destiny", 20);
h.equip(w);
Spell s = Spell("Fireball", 30, 50, 2);
h.learn(s);
Dungeon map = new Dungeon("level1.txt");
map.spawn(h);
map.printMap();
```

```
H.##.....T
#T##..###.
#.###E###E
#.E...###.
###T#####G
```

```
map.moveHero("right");
map.moveHero("down");
map.printMap();
```

```java
Found health potion. Hero health is max.
..##.....T
#H##..###.
#.###E###E
#.E...###.
###T#####G
```

```java
map.heroAttack("spell");
```

```
Nothing in casting range 2
```

```java 
map.moveHero("down");
map.moveHero("down");
map.printMap();
```

```
..##.....T
#.##..###.
#.###E###E
#HE...###.
###T#####G
```

```
map.heroAttack("spell");
```
A fight is started between our Hero(health=100, mana=100) and Enemey(health=100, mana=100, damage=20)
Hero casts a Fireball, hits enemy for 20 dmg. Enemy health is 80
Enemy moves one square to the left in order to get to the hero. This is his move.
Hero casts a Fireball, hits enemy for 20 dmg. Enemy health is 60
Enemy hits hero for 20 dmg. Hero health is 80
Hero does not have mana for another Fireball.
Hero hits with Axe for 20 dmg. Enemy health is 40
Enemy hits hero for 20 dmg. Hero health is 60.
Hero hits with Axe for 20 dmg. Enemy health is 20
Enemy hits hero for 20 dmg. Hero health is 40.
Hero hits with Axe for 20 dmg. Emely health is 0
Enemy is dead!
```

### Fight steps

The fight follows this algorithm:

* Our hero always attacks first
* We always use the attack that deals more damage
* If our weapon and our spell deals the same amount of damage, use the spell first.
* When you run out of mana, use the weapon (if any)
* Think of how you can make the enemies cast spells?

## Creativity and Improvisation

As you can see, this is a big and a fat problem. There are things that are not well defined.

**This is up to you. Make an interesting game!**
