package exe.badge.backend.service;

import java.util.List;

import exe.badge.backend.model.User;
import exe.badge.backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class UserService {

    private final UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findById(Long id){
        var user = userRepository.findById(id);
        return user.orElse(null);
    }

}
