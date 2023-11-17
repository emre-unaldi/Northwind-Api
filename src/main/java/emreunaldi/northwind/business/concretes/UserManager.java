package emreunaldi.northwind.business.concretes;

import emreunaldi.northwind.business.abstracts.UserService;
import emreunaldi.northwind.core.dataAccess.UserRepository;
import emreunaldi.northwind.core.entities.User;
import emreunaldi.northwind.core.utilities.results.DataResult;
import emreunaldi.northwind.core.utilities.results.Result;
import emreunaldi.northwind.core.utilities.results.SucceesDataResult;
import emreunaldi.northwind.core.utilities.results.SuccessResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserManager implements UserService {
    private UserRepository userRepository;

    @Autowired
    public UserManager(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Result add(User user) {
        this.userRepository.save(user);
        return new SuccessResult("Kullanıcı eklendi.");
    }

    @Override
    public DataResult<User> findByEmail(String email) {
        return new SucceesDataResult<User>(
                this.userRepository.findByEmail(email),
                "Kullanıcı bulundu."
        );
    }
}
