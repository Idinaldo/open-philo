package com.openphilosophy.api.models.user;

import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    // TODO: find/develop a faster and more efficient way to map it
    // suggestion: ObjectMapper
    public User map(UserRegisterDTO data) {
        User user = new User();
        user.setName(data.name());
        user.setEmail(data.email());
        user.setPassword(data.password());
        user.setBio(data.bio());
        user.setRole(data.role());
        return user;
    }

    public User map(User oldUser, UserUpdateDTO newUser) {

        // TODO: set name, email, password, bio, pfp, role
        if (newUser.name() != null) oldUser.setName(newUser.name());
        if (newUser.email() != null) oldUser.setEmail(newUser.email());
        if (newUser.bio() != null) oldUser.setBio(newUser.bio());
        if (newUser.password() != null) oldUser.setPassword(newUser.password());
        if (newUser.role() != null) oldUser.setRole(newUser.role());
        return oldUser;
    }
}
