package emreunaldi.northwind.business.abstracts;

import emreunaldi.northwind.core.entities.User;
import emreunaldi.northwind.core.utilities.results.DataResult;
import emreunaldi.northwind.core.utilities.results.Result;

public interface UserService {
    Result add(User user);
    DataResult<User> findByEmail(String email);
}
