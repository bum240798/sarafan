package com.study.sarafan.service;

import com.study.sarafan.domain.User;
import com.study.sarafan.repo.UserDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ProfileService {
    private final UserDetailsRepo userDetailsRepo;

    @Autowired
    public ProfileService(UserDetailsRepo userDetailsRepo) {
        this.userDetailsRepo = userDetailsRepo;
    }

    public User changeSubscription(User channel, User subscriber) {
        Set<User> subscribers = channel.getSubscribers();

        if (subscribers.contains(subscriber)) {
            subscribers.remove(subscriber);
        } else {
            subscribers.add(subscriber);
        }

        return userDetailsRepo.save(channel);
    }
}
