# We are going to make a social network for Pandas

This is the next big thing. We promise!

## Panda

For our social network, we are going to need a `Panda` class which should behave like this:

```java
Panda ivo = new Panda("Ivo", "ivo@pandamail.com", "male");

ivo.getName() == "Ivo" # true
ivo.getEmail() == "ivo@pandamail.com"  # true
ivo.getGender() == "male" # true
ivo.isMale() == true # true
ivo.isFemale() == false # true
```

The `Panda` class should also:

* Be turned into a string
* **Make sure that the `email` is a valid email!**

Two `Panda` instances are equal if they have matching `name`, `email` and `gender` attributes.

## SocialNetwork

Now it is time for our social network!

Implement a class, called `PandaSocialNetwork`, which has the following public methods:

* `addPanda(panda)` - this method adds a `panda` to the social network. The panda has no friends for now. If the panda is already in the network don't add it again.
* `hasPanda(panda)` - returns `true` or `false` if the `panda` is in the network or not.
* `makeFriends(panda1, panda2)` - makes the two pandas friends. **The friendship is two-ways** - `panda1` is a friend with `panda2` and `panda2` is a friend with `panda1`. **If `panda1` or `panda2` are not members of the network, add them!**
* `areFriends(panda1, panda2)` - returns `true` if the pandas are friends. Otherwise, `false`
* `friendsOf(panda)` - returns a list of `Panda` with the friends of the given `panda`. Raises an error if the `panda` is not a member of the network.
* `connectionLevel(panda1, panda2)` - returns the connection level between `panda1` and `panda2`. If they are friends, the level is 1. Otherwise, count the number of friends you need to go through from `panda` in order to get to `panda2`. If they are not connected at all, return `-1`! Raise an error if one of the pandas are not member of the network.
* `areConnected(panda1, panda2)` - return `true` if the pandas are connected somehow, between friends, or `false` otherwise.
* `howManyGenderInNetwork(level, panda, gender)` - returns the number of pandas with gender `gender` (male of female) that are in the `panda` network in `level` levels deep. If `level == 2`, we will have to look in all friends of `panda` and all of their friends too.

## An example

```python
PandaSocialNetwork network = new PandaSocialNetwork();
Panda ivo = new Panda("Ivo", "ivo@pandamail.com", "male");
Panda rado = new Panda("Rado", "rado@pandamail.com", "male");
Panda tony = new Panda("Tony", "tony@pandamail.com", "female");

network.addPanda(ivo);
network.addPanda(rado);
network.addPanda(tony);

network.makeFriends(ivo, rado);
network.makeFriends(rado, tony);

network.connectionLevel(ivo, rado) == 1 # true
network.connectionLevel(ivo, tony) == 2 # true

network.howManyGenderInNetwork(1, rado, "female") == 1 # true
```

## Save and load from file

The next thing our social network is going to do is ``saving to your hard drive``.

### socialNetwork.save(file_name)

Write a function that saves the whole social network to a file. The format of that file is not important but you have to be able to load it in the program. So all the data in the network must be written down to that file.

### socialNetwork.load(file_name)

Write a function that loads the whole social network from a file. All the pandas and all the relations.

*Note* you can use the JAR we introduced in the first week.