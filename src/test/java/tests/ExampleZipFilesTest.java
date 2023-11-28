package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ExampleZipFilesTest {
    private final ClassLoader cl = ExampleZipFilesTest.class.getClassLoader();
    @Test
    void readXlsxFromZipFileParsingTest() throws IOException {
        try (InputStream is = cl.getResourceAsStream("zipFiles/exampleForTest.zip")) {
            assert is != null;
            try (ZipInputStream zin = new ZipInputStream(is)) {
                ZipEntry entry;
                while ((entry = zin.getNextEntry()) != null) {
                    if (entry.getName().equals("xlsx_example.xlsx")) {
                        Assertions.assertEquals("xlsx_example.xlsx", entry.getName());
                        Assertions.assertEquals(10474, entry.getSize());
                    }
                }
            }
        }
    }
    @Test
    void readCsvFromZipFileParsingTest() throws IOException {
        try (InputStream is = cl.getResourceAsStream("zipFiles/exampleForTest.zip")) {
            assert is != null;
            try (ZipInputStream zin = new ZipInputStream(is)) {
                ZipEntry entry;
                while ((entry = zin.getNextEntry()) != null) {
                    if (entry.getName().equals("csv_example.xlsx")) {
                        Assertions.assertEquals("csv_example.xlsx", entry.getName());
                        Assertions.assertEquals(594, entry.getSize());
                    }
                }
            }
        }
    }
    @Test
    void readPdfFromZipFileParsingTest() throws IOException {
        try (InputStream is = cl.getResourceAsStream("zipFiles/exampleForTest.zip")) {
            assert is != null;
            try (ZipInputStream zin = new ZipInputStream(is)) {
                ZipEntry entry;
                while ((entry = zin.getNextEntry()) != null) {
                    if (entry.getName().equals("pdf_example.xlsx")) {
                        Assertions.assertEquals("pdf_example.xlsx", entry.getName());
                        Assertions.assertEquals(3028, entry.getSize());
                    }
                }
            }
        }
    }
    }


