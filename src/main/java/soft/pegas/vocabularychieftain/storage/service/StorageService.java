package soft.pegas.vocabularychieftain.storage.service;

import java.io.IOException;

public interface StorageService {
    
    String saveFile(byte[] file) throws IOException;
    byte[] getFile(String fileName) throws IOException;
    void deleteFile(String fileName) throws IOException;
}
