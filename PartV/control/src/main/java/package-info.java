/*
«Order book» [10:42:12]
Дано: XML-файл, размер файла 205Mb.
Файл состоит из заявок на покупку и продажу акций. Заявки могут как выставляться, так и сниматься.
tag – AddOrder – заявка выставлена
tag – DeleteOrder – заявка снята
Пример выставления заявки:
?
1
<AddOrder book=\"stock-1\" operation=\"SELL\" price=\"100.50\" volume=\"81\" orderId=\"1\" />
tag – book – идентификатор акции
tag – operation – тип операции, покупка/продажа
tag – price – цена
tag – volume – объем заявки, сколько лотов (акций) купить/продать
tag – id – идентификатор заявки
Требуемые задачи:
1. Распарсить входной файл.
2. Разбить заявки по группам акций.
3. Сделать агрегацию заявок с одинаковой ценой.
4. Сделать сопоставление заявок купли/продажи.
Например:
Акция 1. Заявка на покупку 10 лотов по цене 32 рубля. Заявка на продажу 10 лотов по цене 30 рублей.
Такие заявки должны сопоставиться и удалиться из общей группы.
Общий принцип: цена покупки >= цена продажи. И наоборот: цена продажи <= цена покупки.
5. Вывести на экран биржевой "стакан" всех групп акций.

Необходимые условия:
Использовать только средства, входящие в пакет Java SE
Скорость обработки ~ 6 сек.
Качество кода
Первое, с чего я начал решать задачу, – это определение частей кода, которые можно выполнить параллельно.
За счет этого должна увеличиться скорость выполнения программы. Из задания понятно, что вся программа состоит из двух основных блоков:
1. Парсинг входного файла.
2. Обработка полученных данных.


Бид (bid) – цена покупки, по которой вы можете продать имеющуюся у вас валюту, или если дело происходит на форекс,
просто заключить сделку на продажу. Значение данного показателя регулируется предложениям базовой валюты в котировке,
чем больше желающих продать валюту, тем ниже цена бид.

Если вы заключили сделку на продажу по данной цене вам нужно купить валюту еще дешевле,
только в этом случае вы получите прибыль в результате этой операции.
Операции на продажу еще называют короткими позициями.

Аск (ask) – цена продажи, по которой вы покупаете валюту,
всегда выше показателя бид на разницу между покупкой и продажей именуемую спред (комиссионные брокера).
По этой цене открываются все длинные позиции, которые принесут прибыль, если курс валютной пары будет расти.

англ.

Task Description

Program should create Order Books according to orders from XML file:

(drive.google.com/file/d/0B4FxtBlfiwJhbERraGJ2RXVtR00/).

Two actions supported: new order, delete exiting order.
And after processing the whole file, print to standard output all order books generated.

What is Order Book?

Order Book is basically a combination of bid ladder and ask ladder.
Bid ladder consists from buy orders;
ask ladder consists from sell orders.
See example order book and format of output for your program:

Order book: ${order_book_name}

BID                  ASK

Volume@Price – Volume@Price

10@100.1  – 11@100.2

4@100.0    – 14@100.21

98@99.98  – 14@100.23

-----------      – 12@101.00

Bid ladder is sorted from the highest bid price at the top to lowest price at the bottom.

Ask ladder – visa versa, sorted from lowest at the top to highest price at the bottom.



Note: when printing out resulted order books - quantity for all orders with the same price should be aggregated.
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
volume_executed=min(ask_order,bid_order).  So when there is a match you need to adjust orders quantities.
There could be three cases:

    Order existing in order book fully filled by incoming order à remove existing, adjust quantity of incoming order and add it
    Incoming order fully filled by existing order à adjust quantity of existing order
    Full quantity match à Remove existing order


*/