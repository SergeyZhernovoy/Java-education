/**
 * Created by admin on 27.10.2016.
 */
package ru.szhernovoy.bomberman;

/*Реализовать игру бомбермен. Без графики.
Без меню и без пользовательского ввода. Интересует только логика и дизайн.

1. Есть игровое поле - двухмерный массив. Есть герои - Бомбермен и чудовища.
2. Приложение не должно блокировать все игровое поле.
3. В поле должны существовать блоки. поля куда нельзя ходить.
4. Бомбермен должен управляться через пользователя.
(Пользовательский ввод реализовывать не надо) только апи, для движения.
5. Чудовища должны двигаться автоматически.
6. Предусмотреть, что если чудовище не может двинуться на клетку.
например, там стоит другое чудовище, проверять в течении .5 секунд и двигаться в другую строну.
7. Сложность поля и количество чудовищ должно варьироваться.
*/


/*
1. Назовите различия между Collections.synchronizedMap(new HashMap()) и ConcurrentHashMap.
2. Что такое кооперативная многозадачность и она ли ли в Java.
Если да, то какие преимущества. Если нет, то какая тогда в Java?
3. Что такое "зеленый потоки" и они ли ли в Java (в HotSpot JVM.6)?
4. Различия в интерфейсах Runnable и Callable.
5. Напишите минимальный неблокирующий стек (всего два метода — push() и pop()).
6. Напишите минимальный copy-on-write ArrayList (всего четыре метода —
void add(int indx, int item), int get(int indx), void remove(int indx), int size()).
7. Различя между Thread.isInterrupded() и Thread.interrupded().
8. Что происходит при вызове Thread.interrupt()?
9. Некоторые из следующих методов deprecated а некоторые и не были никогда реализованы.
Какие? Thread.interrupt(), Thread.stop(), Thread.yield(), Thread.suspend(), Thread.resume(), Thread.join(),
Thread.start(), Thread.run(), Thread.sleep().
10. Что Вы знаете о асинхронных вызовов методов? Есть ли это в самом языке Java?
Если есть, то как реализовано? Если нет, то как бы Вы реализовали?
11. Перечислите ВСЕ причины по которым может выскочить InterruptedException.
12. Что изменилось между JMM до Java 5 и NewJMM после Java 5?
13. В классе String все поля финальные. Можно ли убрать ключевое слово финал?
Ведь сеттеров все равно нет — следовательно поля нельзя переустановить.
14. Что такое ordering, visibility, atomicity, happend-before, mutual exclusion.
И показать на примерах volatile, AtomicInteger, synchronize{} —
что из вышеперечисленного списка присутствует и при каких вариантах использования.
15. Назовите отличия synchronize{} и ReentrantLock.
16. Что из данных вызовов создает happend-before: Thread.sleep(), Thread.join(), Thread.yield(),
Thread.start(), Thread.run(), Thread.isAlive(), Thread.getState()?
17. Перечислите известные Вам способы борьбы с priority inversion,
 назовите классы систем где они особенно опасны.
18. Перечислите известные Вам способы 1)избежать 2)побороть возникшие deadlock-и
(представьте, что вы пишете ядро RDBMS).
19. Расскажите о паттернах Reactor/Proactor?
20. Что такое "monitor"?
21. Что такое "private mutex"?
22. Что такое "priority inheritance"?
23. Что такое "backoff protocol (expotential backoff)"?
24. Что такое "task stealing"?
25. Что такое "ABA problem"?
26. Что такое "test-end-set"?
27. Что такое "test-and-test-end-set"?
28. Что такое "spin lock"?
29. Что такое "sequential consistency"?
30. Что такое "sense-reversing barrier"?
31. Что такое "safe publication"?
32. Что это за свойство — "reentrancy"?
33. Что такое "recursive parallelism"?
34. Что такое "iterative parallelism"?
35. Что это за вариант архитектуры "pipeline"?
36. Что такое "poison message"?
37. Что такое "mutual exclusion"? Примеры как добиться в Java.
38. Что такое "condition waiting"? Примеры как добиться в Java.
39. Преимущества SheduledThreadPool перед java.util.Timer.
40. Различия между java.util.concurrent.Atomic*.compareAndSwap()
и java.util.concurrent.Atomic*.weakCompareAndSwap().
41. Что в SynchronousQueue уникально для BlockingQueue.
42. Что такое "рандеву"? При помощи каких классов в Java его можно организовать?
43. Что такое "false sharing". Может ли происходит в Java.
Если есть, то приведите примеры и как бороться. Если нет, то как побороли разработчики JVM.
44. Thread.getState() возвращает экземпляр Thread.State.
 Какие возможны значения?
45. Напишите простейший ограниченный буфер для многих производителей/многих потребителей
с использованием synchronize{}. С использованием ReentrantLock.
46. У ReentrantLock созданного с аргументом true
все же один из методов захвата блоктровки — не fair. Какой? Как это обойти?
47. Приведите наиболее существенное отличие между CountDownLatch и Barrier.
48. Что Вы знаете о Erlang? Что в нем есть существенного связанного с многопоточностью такого, чего нет в Java?
49. Что Вы знаете о CSP? Что в нем есть существенного связанного с многопоточностью такого, чего нет в Java?
50. Отличие Thread.start() и Thread.run()?
 */