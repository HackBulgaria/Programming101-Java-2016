# Drone Delivery System

Last year the geeks at Amazon turn up with the cool idea to use drones to deliver goods right in front of your front door. Nice idea! However it may be not so simple to implement.

We are going to design and implement a system controlling and scheduling deliveries with drones.

## Our city

For the sake of simplicity our city will be a 1000x1000 square matrix. Our drones will fly around it and deliver the goods.

## Drones

* Each drone has a:
  * unique id - we should have a way to distinguish them
  * battery - unfortunately they cannot run forever but will usually last a flight to the end of the city and back, then they must recharge. We will measure them with BU (battery units).
  * capacity - they cannot take infinitely many products as well. We will measure their capacity with WU (weight units)
  * charging rate - measured in BU per minutes

## Products

* Each product has a:
  * unique id
  * name (e.g. keyboard)
  * weight (e.g. 0.5 kg for 1 keyboard)

## Warehouse

At the warehouse we will store the goods that should be delivered.

* Each warehouse has a:
	* coordinates - the place in our city
	* information about the available products - we should keep track of the quantities we have of a given product.

## Requests

Lets suppose that we will receive the requests from console as a simple text.

We will support the following requests:

### Delivery request

It will look like this:

delivery &lt;id&gt; &lt;timestamp&gt; &lt;target coordinates&gt; &lt;product id 1&gt; &lt;quantity&gt; &lt;product id 2&gt; &lt;quantity&gt; ...

e.g. "delivery 4 2016-10-25 12:31 420,369 23 5 54 20"

## How deliveries are made

* When we receive a supply request we will simply update our information at the warehouse and log a message about the supply.

* When we receive a delivery request we will try to execute it. If we can execute the delivery request we should log a message. If we cannot process the current request now we should log a message with the reason why we cannot process the task.


### Executing

If we have the needed amount of each product for a given delivery task we should be able to process it. If the WU (weight capacity) of one drone is not enough for processing the delivery we should use as much drones as we need.

If we do not have the needed amount of at least one product we should log an error message.

## Drone Delivery System v1

For our first version of the delivery system:

* Our 50 drones will have:
  * 2 000 BU
  * 5 BU/min charging rate
  * 500 WU capacity

* The warehouse is at coordinates [42, 42]
