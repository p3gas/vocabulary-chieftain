package soft.pegas.vocabularychieftain.storage.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;

public class LocalStorageService implements StorageService {

    @Value("${app.storage.files-path}")
    private String filesPath;

    @Override
    public String saveFile(byte[] fileBytes) throws IOException {
        String fileName = "F_" + UUID.randomUUID();
        File savedFile = new File(filesPath + "/" + fileName);
        try (var outputStream = new FileOutputStream(savedFile)) {
            outputStream.write(fileBytes);
        }

        return fileName;
    }

    @Override
    public byte[] getFile(String fileName) throws IOException {
        File file = new File(filesPath + "/" + fileName);
        byte[] byteArray = new byte[(int) file.length()];
        try (FileInputStream inputStream = new FileInputStream(file)) {
            inputStream.read(byteArray);
        }

        return byteArray;
    }

    @Override
    public void deleteFile(String fileName) throws IOException {
        File file = new File(filesPath + "/" + fileName);
        file.delete();
    }
}
