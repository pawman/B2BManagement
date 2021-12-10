package com.pawman.b2bmanagement.controller;

import com.pawman.b2bmanagement.helper.ExcelHelper;
import com.pawman.b2bmanagement.model.Address;
import com.pawman.b2bmanagement.model.User;
import com.pawman.b2bmanagement.model.UserMaster;
import com.pawman.b2bmanagement.service.GetDataService;
import com.pawman.b2bmanagement.service.SaveDataService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller()
@RequestMapping("b2")
public class UserController extends DefaultController {

    private static final String ADD_USER = "/addUser";
    public static final String USERS = "users";
    public static final String EDIT_USER = "/editUser";

    public UserController(GetDataService getDataService, SaveDataService saveDataService) {
        super(getDataService, saveDataService);
    }

    @GetMapping("/users")
    public String showUsers(Model model) throws Exception {
        ExcelHelper.saveXls();
        model.addAttribute("users", getDataService.getActiveUsers());
        model.addAttribute("userModel", new User());
        return USERS;
    }

    private User getLatestIteration(UserMaster userMaster) {
        List<User> usersByUserMaster = getDataService.getUsersByUserMaster(userMaster);
        return usersByUserMaster.stream().max(Comparator.comparingLong(User::getVersion)).get();
    }

    private List<User> getAllIteration(UserMaster userMaster) {
        List<User> usersByUserMaster = getDataService.getUsersByUserMaster(userMaster);
        return usersByUserMaster.stream().sorted(Comparator.comparingLong(User::getVersion)).collect(Collectors.toList());
    }

    @GetMapping("/addUser")
    public String showAddUser(Model model) {
        model.addAttribute("user", new User());
        return ADD_USER;
    }

    @PostMapping("/addUser")
    public String addUser(@ModelAttribute("user") User user){
        UserMaster userMaster = saveDataService.saveUserMaster(new UserMaster());
        Address address = saveDataService.saveAddress(user.getAddress());
        user.setAddress(address);
        user.setUserMaster(userMaster);
        saveDataService.saveUser(user);
        return redirect(USERS);
    }

    @GetMapping("/editUser")
    public String showeditUser(Model model, @ModelAttribute("userModel") User user) {
        Optional<User> userById = getDataService.getUserById(user.getId());

        model.addAttribute("user", userById.get());
        return EDIT_USER;
    }

    @PostMapping("/editUser")
    public String editUser(@ModelAttribute("user") User user){
        saveDataService.disableUser(user.getId());

        UserMaster master = getDataService.getUserMasterById(user.getUserMaster().getId());

        Address address = saveDataService.saveAddress(new Address(user.getAddress()));
        user.setAddress(address);
        User newUser = new User(user);
        newUser.setUserMaster(master);
        newUser.increaseVersion();
        saveDataService.saveUser(newUser);
        return redirect(USERS);
    }

    @PostMapping("/deleteUser")
    public String deleteUser(@ModelAttribute("userModel") User user){
        saveDataService.deleteUser(user.getId());
        return redirect(USERS);
    }

    @PostMapping("/disableUser")
    public String disableUser(@ModelAttribute("userModel") User user){
        saveDataService.disableUser(user.getId());
        return redirect(USERS);
    }
}
