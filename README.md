[![Build Status](https://travis-ci.org/mmaggioni/sales-taxes.svg?branch=master)](https://travis-ci.org/mmaggioni/sales-taxes)

A java project that simulate an order for various items with different sales tax.

Request
-
When the client buy some items it should receive a receipt with all the listed items, the total and the total tax payed.


Item rules
-
10% tax on all goods except books, food, and medical.

5% on all imported goods with no exception.

the taxed items should be rounded to the nearest 0.05 (rounded up)

Code structure
-
The packages are divided by feature (ex: goods, notification, order)

The OrderPurchaser is the class to managed the use case (in this case purchase an order and send an email).

The tax rules are managed by the Item Builder.

Other
-
Project is plain java (with mockito and junit), built with gradle
