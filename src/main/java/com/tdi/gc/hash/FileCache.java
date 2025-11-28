package com.tdi.gc.hash;

public class FileCache extends AbstractCacheMap<String, String> {

    private final FileReaderService fileReaderService;

    public FileCache(FileReaderService fileReaderService) {
        this.fileReaderService = fileReaderService;
    }

    @Override
    protected String load(String key) {
        return fileReaderService.readFile(key);
    }
}
