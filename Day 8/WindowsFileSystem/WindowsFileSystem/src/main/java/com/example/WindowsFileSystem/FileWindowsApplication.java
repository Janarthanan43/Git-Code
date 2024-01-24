package com.example.WindowsFileSystem;

import java.util.ArrayList;
import java.util.List;

public class FileWindowsApplication {
    interface FileSystemComponent {
        void showDetails();
    }


    static class File implements FileSystemComponent {
        private String name;

        public File(String name) {
            this.name = name;
        }

        @Override
        public void showDetails() {
            System.out.println("File: " + name);
        }
    }


    static class Directory implements FileSystemComponent {
        private String name;
        private List<FileSystemComponent> components = new ArrayList<>();

        public Directory(String name) {
            this.name = name;
        }

        public void addComponent(FileSystemComponent component) {
            components.add(component);
        }

        @Override
        public void showDetails() {
            System.out.println("Directory: " + name);
            for (FileSystemComponent component : components) {
                component.showDetails();
            }
        }
    }
}
