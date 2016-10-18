# Gas Stations

We are implementing a smart GPS software.

- We are taking a long trip from Sofia to Vratsa and we know the distance between the two cities.It is a positive integer and we mark it as ``tripDistance``.

- We know how much our car can ride with a full tank of gas. It is a positive integer in kilometers. We mark it as ``tankSize``.

- We know how much gas stations are there on our roude. It is a positive intager and we mark it as ``gasStationsCount``

- We have a list of gas stations. We know the distance between Sofia and the current gas station. ``gasStations = [50, 80, 110, 180, 220, 290]`` The list is sorted!

By using this information we will implement a function that returns the shortest list of gas stations that we have to visit in order to travel from Sofia to Vratsa. Know that are allways starting with a full tank.

##Here is a boilerplate class ready to take console input:

```java
public class GPS {

  public static Vector<Integer> getGasStations(int tripDistance, int tankSize, Vector<Integer> gasStations) {
    return new Vector<Integer>();
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int tripDistance = scanner.nextInt();
    int tankSize = scanner.nextInt();

	int gasStationsCount = scanner.nextInt();
    Vector<Integer> gasStations = new Vector<Integer>();

    for (int i = 0; i < gasStationsCount; i++) {
      gasStations.add(scanner.nextInt());
    }

    Vector<Integer> result = getGasStations(tripDistance, tankSize, gasStations);

	for (int i = 0; i < result.size(); i++) {
   		System.out.println(result.get(i));
    }

  }
}
```

## Example
For input
```
320
90
6
50
80
140
180
220
290
```

Give the following output:

```
80
140
220
290
```
