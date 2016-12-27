/**
 * Created by admin on 24.12.2016.
 */

/**
 Существуют 4 сущности:

 User; +
 Address; +
 Role; +
 MusicType. +

 Таблицы и связи между таблицами:

 Role : User(1:M); +
 User : Address(1:1); +
 User : MusicType (M:M). +

 Таблицы Role и MusicType заполнены: (USER, MANDATOR, ADMIN) и (RAP, ROCK …). +

 1. DAO – паттерн

 Реализовать DAO для каждой из сущностей, в которых должны находится CRUD операции  +
 (создать, выбрать все сущности, выбор сущности по id, редактировать сущность, удалить сущность). +



 2. Repository – паттерн

 -       Для User реализовать:

 -      операцию получения всех связанных с ним сущностей; +

 -      операцию добавления нового User и всех связанных с ним сущностей;

 -      операцию поиска User по заданному параметру (Address, Role, MusicType).

 -       Для Role реализовать:

 -      операцию получения всех связанных с ним сущностей;



 Не использовать spring и hibernate . Добавить web с возможностью входа под этими ролями.
 */