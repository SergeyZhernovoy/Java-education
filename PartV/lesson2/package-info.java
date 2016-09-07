Сделал интерфейс Store<T extends Base>,
где Base Это абстрактный класс для моделей c методами:
        String getId();
        void setId(String id).
Сделать два класс User, и Role которые наследуют данных класс.
Сделал два хранилища UserStore и RoleStore.
Внутри для хранения данных использовать SimpleArray.