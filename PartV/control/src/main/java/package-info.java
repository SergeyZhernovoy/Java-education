/*«Order book» task
////
1) создаём класс Заказы .
читаем хмл файл и заполняем коллекцию заказами
2) все заказы объединенны в журнал заказов в хмл файле они объединены по имени
end) после обработки всех заказов надо распечатать результат обработки по всем журналам
Заказы бывают двух видов покупка и продажа bid / ask


Before you start

Please follow these instructions super accurately.


Develop the solution in Java (you can use Maven as a build tool if you want)
The core of the solution should be written without any add-ons to the core of the programming language.
Use only the defined language standard (e.g. you can use all features that you find in a standard JDK).
This means that you can use external libraries, but your program should still produce
the required output after removing those parts.
For example, if you would decide to use a logging library then your program would still
work correctly after removing all parts that use the logging library. You can also use JUnit.
Optimize for quality of development and execution speed.
- In general execution time on PC with HDD should be around 6 seconds.
- Be ready to explain and protect all performance optimizations (if there will be any).

Deliver your result in the best professional quality you can produce.
Polish your solution. Make a master piece out of it.
It is part of this task to compare what different people consider to be a professional quality solution.

Task Description

Program should create Order Books according to orders from XML file:

(drive.google.com/file/d/0B4FxtBlfiwJhbERraGJ2RXVtR00/).

Two actions supported: new order, delete exiting order.
And after processing the whole file, print to standard output all order books generated.


What is Order Book?

Order Book is basically a combination of bid ladder and ask ladder.
Bid ladder consists from buy orders; ask ladder consists from sell orders.
See example order book and format of output for your program:


Order book: ${order_book_name}

BID                  ASK

Volume@Price – Volume@Price

10@100.1        – 11@100.2

4@100.0         – 14@100.21

98@99.98        – 14@100.23

-----------      – 12@101.00



Bid ladder is sorted from the highest bid price at the top to lowest price at the bottom.
Ask ladder – visa versa, sorted from lowest at the top to highest price at the bottom.


Note: when printing out resulted order books -
quantity for all orders with the same price should be aggregated.
In other words – on each side (bid / ask) of order book can have only one level with particular price.

Note: You don’t need to check XML file for correctness and implement any safety checks.

Note: There are several different order books in XML file (see ‘book’ attribute)

Matching logic:

When new bid/ask order is added into order book you should check opposite book side for matching.
Checking always starts from the top of opposite side.
To get execution (matching) price of counter orders must overlap (bid>=ask). For example:

bid order at 4.4 matches ask order at 4.3
ask order at 3.7 matches bid order at 3.8
opposite side orders with same price matches as well.


Matching is a process of execution two counter orders.
When orders are matched they current volume is decreased by minimum current volumes of these orders:
volume_executed=min(ask_order,bid_order).
So when there is a match you need to adjust orders quantities.

There could be three cases:
Order existing in order book fully filled by incoming order à remove existing,
adjust quantity of incoming order and add it
Incoming order fully filled by existing order à adjust quantity of existing order
Full quantity match à Remove existing order

Also

Describe do’s and don’ts of your solution, what could be done to speed it up further, improve, simplify?

перевод

«Order book» -   Журнал заказов
условия успешности выполнения задачи:
- разработка только с использованием стандартных средств языка Java
- скорость выполнения около 6 секунд

Описание задачи:

Программа должна создать портфель заказов по заказам из файла XML:
(Drive.google.com/file/d/0B4FxtBlfiwJhbERraGJ2RXVtR00/).
поддерживаются два действия:
новый заказ (new order)
удаление закрытого заказ (delete order).
А после обработки всего файла, печать на стандартный вывод всех книг заказа

Что такое Order Book?
Журнал заказов базируется на комбинации ряда предложений и ответов .
Предложения заключаются в покупке ордеров , а ответы в продаже ордеров.
Посмотрите пример журнала заказов и выходной формат для вашей программы:

Order book: ${order_book_name}

BID                  ASK

Volume@Price – Volume@Price

10@100.1        – 11@100.2

4@100.0         – 14@100.21

98@99.98        – 14@100.23

-----------      – 12@101.00
Предложения сортируются от самой высокой цены покупки на вершины до самой низкой внизу
Ответы наоборот от самой низкой в верху до самой высокой

Замечание: когда печатаете результирующий журнал заказов - количество для всех заказов
с одинаковой ценой должно быть объединено.
Другими словами - на каждой стороне (бид / аск) журнала заказа можно иметь только один уровень с определенной ценой.
Замечание: Вам не нужно проверять XML-файл на корректность и осуществлять любые проверки безопасности.
Замечание: Есть несколько различных журналов заказов в файле XML (см 'книга' атрибут).

Соответствие логики :
Когда новый бид / аск заказа добавляется в журнал заказов вы должны проверить
противоположную сторону книги для сравнения. Проверка всегда начинается с
верхней части противоположной стороны. Для получения исполнения (согласования) цена
встречных заявок должны перекрываться (ставка> = ответ). Например:

ставка заказ на 4.4 соответствует ответу 4.3
задать порядок на 3.7 матчи ставка заказ на 3,8
противоположные заказы с той же цене, также совпадает.

Совпадение это процесс выполнения двух встречных заявок.
Когда заказы совпадают, то текущий объем уменьшается на минимальных текущих объемов
этих заказов: volume_executed = мин (ask_order, bid_order).
Так что, когда есть совпадение вам нужно настроить заказы количества. Там может быть три случая:

Заказать существующие в книге заказов полностью заполненной входящего заказа
à удалить существующие, отрегулировать количество входящего заказа и добавить его
Входящий заказ полностью заполнены существующими заказ на регулировать количество существующего порядка
Полное совпадение Величина а Удалить существующий порядок*/
