package pl.sqer.angular.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.sqer.angular.dto.User;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {

  @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<User> find(
    @PathVariable("id") String id
  ) {
    return new ResponseEntity<>(new User("Tomasz", "Sapota"), HttpStatus.OK);
  }

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<User>> find() {
    List<User> users = Arrays.asList(
      new User("Tomasz", "Sapota"),
      new User("Arkadiusz", "Sakiewicz"),
      new User("Bartosz", "Bartoszak")
    );
    return new ResponseEntity<>(users, HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity insert(@RequestBody User user) {
    return new ResponseEntity(1, HttpStatus.CREATED);
  }

  @PutMapping(path = "{id}")
  public ResponseEntity update(@PathVariable("id") String id, @RequestBody User user) {
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @DeleteMapping(path = "{id}")
  public ResponseEntity delete(@PathVariable("id") String id) {
    return new ResponseEntity<>(HttpStatus.OK);
  }
}
