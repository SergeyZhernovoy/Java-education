/**
 * Created by admin on 04.01.2017.
 */

/**
 * 2 PART Реализовать модели и связи для задание SQL хранилище машин.
 *
 * 1 PART Это должно быть web приложение со следующими страницами.
 1. основная страница. таблица со всеми объявлениям машин на продажу.
 2. на странице должна быть кнопка. добавить новое объявление.
 3. переходить на страницу добавления.
 4. должны быть категории машины. марка. тип кузова и тд.
 посмотри как на авито сделано.
 5. важно!. можно добавлять фото. использовать библиотеку apache fileuppload
 6. объявление имеет статус продано. или нет.
 7. должны существовать пользователи.
 кто подал заявление. только он может менять статус.
 *
 *
 *

 4. ты используешь json. для чтения. а для создания используешь param

 String name = req.getParameter("name");
 int modelId = Integer.valueOf(req.getParameter("model"));
 int bodyId = Integer.valueOf(req.getParameter("body"));
 int transsmId = Integer.valueOf(req.getParameter("transsmission"));
 int driveId = Integer.valueOf(req.getParameter("drivetype"));
 int engineId = Integer.valueOf(req.getParameter("engine"));
 int price = Integer.valueOf(req.getParameter("price"));
 int mileage = Integer.valueOf(req.getParameter("mile"));
 int carId = Integer.valueOf(req.getParameter("carId"));
 boolean sold = Boolean.valueOf(req.getParameter("sold"));

 можно для создания тоже использовать json и в разы сократить код.

 *
 */