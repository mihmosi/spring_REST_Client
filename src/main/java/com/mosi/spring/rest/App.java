package com.mosi.spring.rest;

import com.mosi.spring.rest.configuration.MyConfig;
import com.mosi.spring.rest.entity.User;
import com.mosi.spring.rest.service.Communication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

/*
 * Для работы предоставляется API по URL - http://91.241.64.178:7081/api/users
 * <p>
 * Ваша задача: Последовательно выполнить следующие операции и получить код для проверки на платформе:
 * <p>
 * Получить список всех пользователей
 * Когда вы получите ответ на свой первый запрос, вы должны сохранить свой session id,
 * который получен через cookie. Вы получите его в заголовке ответа set-cookie.
 * По скольку все действия происходят в рамках одной сессии, все дальнейшие запросы
 * должны использовать полученный session id ( необходимо использовать заголовок в последующих запросах )
 * Сохранить пользователя с id = 3, name = James, lastName = Brown, age = на ваш выбор.
 * В случае успеха вы получите первую часть кода.
 * Изменить пользователя с id = 3. Необходимо поменять name на Thomas, а lastName на
 * Shelby. В случае успеха вы получите еще одну часть кода.
 * Удалить пользователя с id = 3. В случае успеха вы получите последнюю часть кода.
 * В результате выполненных операций вы должны получить итоговый код, сконкатенировав
 * все его части. Количество символов в коде = 18.
 * <p>
 * Получение всех пользователей - …/api/users ( GET )
 * Добавление пользователя - …/api/users ( POST )
 * Изменение пользователя - …/api/users ( PUT )
 * Удаление пользователя - …/api/users /{id} ( DELETE )
 * <p>
 * Требования:
 * Все операции должны проводится в рамках одной сессии ( не пытайтесь выполнить
 * операции в ручную, например через POSTMAN, сессия имеет ограниченное время   жизни )
 * Все операции должны быть выполнены последовательно по условию
 * Для того, чтобы получить необходимый заголовок из запроса, необходимо использовать
 * тип данных ResponseEntity в качестве ответа на ваш запрос.
 */
public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfig.class);
        Communication communication = context.getBean("communication"
                , Communication.class);

//        List<User> allUsers = communication.getAllUsers();
//        System.out.println(allUsers);

        User user = new User(3L, "James", "Brown", (byte) 33);
        communication.getHeaders();
        communication.saveUser(user);
        user.setName("Thomas");
        user.setLastName("Shelby");
        communication.upateUser(user);
        communication.deleteUser(user, user.getId());


//        communication.saveUser(user);


//        User userById = communication.getUser(2L);
//        System.out.println(userById);
    }


}
