package pl.sqer.angular.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sqer.angular.dto.LoginParams;
import pl.sqer.angular.dto.User;

@RestController
@RequestMapping("/login")
public class LoginController {

  @PostMapping
  public ResponseEntity<User> login(@RequestBody LoginParams loginParams) {
    if (loginParams.getLogin().equals("admin") && loginParams.getPassword().equals("admin")) {
      return new ResponseEntity<>(new User("Tomasz", "Sapota"), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }
  }

}
