# ProducerConsumer - Thread Example w/ Java
The producer makes random production once every second, while the consumer consumes the products in the production queue every 5 seconds. The limit of Queue is set to 10. So the production line can not be longer than the Queue size.

## output goes like
```
Producer produce: 37
Producer produce: 91
Producer produce: 39
Producer produce: 58
Producer produce: 49
Consumer consumes: 37
Queue size: 4
Producer produce: 66
Producer produce: 18
Producer produce: 92
Producer produce: 89
Producer produce: 34
Consumer consumes: 91
Queue size: 8
.
.
.
.
```
