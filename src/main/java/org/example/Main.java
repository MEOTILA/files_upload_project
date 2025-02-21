package org.example;

import org.example.entity.User;
import org.example.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {

    public static UserService userService = new UserService();
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws IOException {
        User user1 = new User();
        user1.setUsername("David");
        user1.setPassword("123");
        Path inputImage = Path.of("D:\\E-Book & Education\\Maktab Sharif\\Week_22\\CW22\\files_upload_project\\files_upload_project\\files_upload_project\\src\\main\\java\\org\\example\\profilePic\\david.jpg");
        byte[] profilePic = Files.readAllBytes(inputImage);
        user1.setProfilePic(profilePic);
        //userService.save(user1);

        var foundedUser = userService.findById(1L);
        String outAddress = "D:\\\\E-Book & Education\\\\Maktab Sharif\\\\Week_22\\\\CW22\\\\files_upload_project\\\\files_upload_project\\\\files_upload_project\\\\src\\\\main\\\\java\\\\org\\\\example\\\\profilePic\\\\writedProfileImage\\\\finalImage.jpg";
        byte[] profilePic1 = foundedUser.get().getProfilePic();
        try (FileOutputStream finalImage = new FileOutputStream(outAddress)) {
            //todo: way 1: (needs try catch)
            //finalImage.write(profilePic1);
        } catch (IOException e) {
            logger.error(e.getMessage());
        }

        //todo: way 2: (No need try catch)
        Files.write(Path.of(outAddress), profilePic1);
    }
}