package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {

      AnnotationConfigApplicationContext context =
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
      userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
      userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
      userService.add(new User("User4", "Lastname4", "user4@mail.ru"));

      // создание нескольких пользователей с машинами
      userService.add(new User("User5", "Lastname5", "user5@mail.ru",
              new Car("BMV", 5555)));
      userService.add(new User("User6", "Lastname6", "user6@mail.ru",
              new Car("Honda", 6666)));
      userService.add(new User("User7", "Lastname7", "user7@mail.ru",
              new Car("Kia", 7777)));
      userService.add(new User("User8", "Lastname8", "user8@mail.ru",
              new Car("Mazda", 8888)));

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println("Car = " + user.getCar());
         System.out.println();
      }

      // пример использования метода, достающего из БД юзера по модели и серии его машины
      System.out.println(userService.getUserHisCar("BMV", 5555));

      context.close();
   }
}
