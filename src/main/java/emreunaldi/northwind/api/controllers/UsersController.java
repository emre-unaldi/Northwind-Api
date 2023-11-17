package emreunaldi.northwind.api.controllers;

import emreunaldi.northwind.business.abstracts.UserService;
import emreunaldi.northwind.core.entities.User;
import emreunaldi.northwind.core.utilities.results.DataResult;
import emreunaldi.northwind.core.utilities.results.ErrorDataResult;
import emreunaldi.northwind.core.utilities.results.Result;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UsersController {
    private UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@Valid @RequestBody User user) {
        return ResponseEntity.ok(this.userService.add(user));
    }

    @GetMapping("/getFindByEmail")
    public DataResult<User> getFindByEmail(@RequestBody String email) {
        return this.userService.findByEmail(email);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions) {
        Map<String, String> validationErrors = new HashMap<>();

        for (FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {
            validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }

        ErrorDataResult<Object> errors = new ErrorDataResult<Object>(validationErrors, "Doğrulama Hataları");

        return errors;
    }
    /*
        Sistemde bir error oluşursa bu metodu çağır.
        Hataları parametre olarak geç.
        Hataları foreach ile dön.
        Hataların her birini map'e ekle ve hataları dön
    */

    // Object en genel veri tipidir. Herşeyin base'i objecttir.
    // Sistemde bu tür bir hata olursa bu metodu devreye sok.
}
/*
    ? - annow -> Ne döneceğini bilmiyorum. İşlem sonucuna göre ekle.
    200
    300
    400
    500

    İşlemler sonucunda hata alabiliriz. Bu hataları try-catch ile de yakalayabiliriz
    Fakat birden çok operasyon için bu maliyetli olabilir.
    Burada biz Global Bir hata yakalama işlemi gerçeklşetireceğiz.
    İşte burada AOP denilen olay devreye giriyor. Biz bütün operasyonlarımızın geçeceği
    Global Exception Handler yazacağız.

    AOP : Bütün operasyonlarımızın önüne global exception handler yazılır ve bütün operasayonlarımız
    buradan geçer. Bütün operasyonlarımızda try catch yazmak yerine bir tane try-catch yapısı kurarız.
    Bütün operasyonlarımızı oraya yollarız.
*/