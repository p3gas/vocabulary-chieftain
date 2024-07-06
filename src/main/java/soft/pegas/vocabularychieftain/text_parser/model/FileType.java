package soft.pegas.vocabularychieftain.text_parser.model;

public enum FileType {
    SRT, TEXT, EPUB, PDF, OTHER;

    public static FileType ofString(String type) {
        return switch (type.toLowerCase()) {
            case "srt" -> SRT;
            case "txt" -> TEXT;
            case "epub" -> EPUB;
            case "pdf" -> PDF;
            default -> OTHER;
        };
    }
}
