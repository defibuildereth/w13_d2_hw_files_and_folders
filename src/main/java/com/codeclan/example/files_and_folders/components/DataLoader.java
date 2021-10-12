package com.codeclan.example.files_and_folders.components;

import com.codeclan.example.files_and_folders.models.File;
import com.codeclan.example.files_and_folders.models.Folder;
import com.codeclan.example.files_and_folders.models.User;
import com.codeclan.example.files_and_folders.repositories.FileRepository;
import com.codeclan.example.files_and_folders.repositories.FolderRepository;
import com.codeclan.example.files_and_folders.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;
import org.springframework.boot.ApplicationRunner;


@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    FileRepository fileRepository;

    @Autowired
    FolderRepository folderRepository;

    @Autowired
    UserRepository userRepository;

    public DataLoader() {

    }

    public void run(ApplicationArguments args){

        User user1 = new User("Donald");
        userRepository.save(user1);

        User user2 = new User("Michelle");
        userRepository.save(user2);

        Folder folder1 = new Folder("CodeClan", user1);
        folderRepository.save(folder1);

        Folder folder2 = new Folder("Insta", user2);
        folderRepository.save(folder2);

        File file1 = new File("week1_homework", "txt", folder1);
        fileRepository.save(file1);

        File file2 = new File("video", "mp4", folder2);
        fileRepository.save(file2);

        File file3 = new File("intelliJ", "exe", folder1);
        fileRepository.save(file3);

        File file4 = new File("image", "jpg", folder2);
        fileRepository.save(file4);
    }
}
