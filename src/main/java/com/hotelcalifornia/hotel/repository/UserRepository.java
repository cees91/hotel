package com.hotelcalifornia.hotel.repository;

import com.hotelcalifornia.hotel.Interfaces.Repository;
import com.hotelcalifornia.hotel.models.Employee;
import com.hotelcalifornia.hotel.models.Guest;
import com.hotelcalifornia.hotel.models.User;
import com.hotelcalifornia.hotel.utils.EnvironmentSingleton;

import java.util.ArrayList;
import java.util.Random;
import java.util.stream.Collectors;

public class UserRepository implements Repository<User> {

    private static UserRepository instance = null;
    private static ArrayList<User> users = new ArrayList<>();
    EnvironmentSingleton singleton = EnvironmentSingleton.getInstance();

    private UserRepository() {
        //Read the CSV and bind data to users

    }

    public static UserRepository getInstance() {
        if (instance == null) {
            instance = new UserRepository();
        }
        return instance;
    }

    /**
     * Finds a single user
     *
     * @param userId
     * @return found user
     */
    public static User findUser(String userId) {
        User foundUser = null;
        for (User currentUser : users) {
            if (currentUser.getUserId().equals(userId)) {
                foundUser = currentUser;
                break;
            }
        }
        return foundUser;
    }

    @Override
    public void remove(String userId) {
        this.users.remove(findUser(userId));
    }

    @Override
    public void create(User user) {
        if (user.getType().equals("guest")) {
            GuestRepository.getInstance().create(new Guest());
        }
        if (user.getType().equals("employee")) {
            EmployeeRepository.getInstance().create(new Employee());
        }
        this.users.add(user);
    }

    @Override
    public void update(User user){
        String id = user.getUserId();
        findAndUpdate(id, user);
    }

    public static void findAndUpdate(String userId, User user) {
        for (User currentUser : users) {
            if (currentUser.getUserId().equals(userId)) {
                currentUser = user;
            }
        }
    }

    /**
     * Resets user password
     *
     * @param userId
     * @return generated password
     */

    public String resetPassword (String userId){
        User userForReset = findUser(userId);
        userForReset.setPassword(generateRandomPassword());

        return "Your new password is: " + userForReset.getPassword();
    }

    private String generateRandomPassword() {
        final int LENGTH = 8;
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "abcdefghijklmnopqrstuvwxyz"
                + "0123456789";
        String password = new Random().ints(LENGTH, 0, chars.length())
                .mapToObj(i -> "" + chars.charAt(i))
                .collect(Collectors.joining());

        return password;
    }
}
