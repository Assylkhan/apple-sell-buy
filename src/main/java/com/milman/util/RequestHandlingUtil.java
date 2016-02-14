package com.milman.util;

import com.milman.entity.ItemImage;
import com.milman.entity.Media;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class RequestHandlingUtil {
    public static byte[] readContentIntoByteArray(File file) {
        FileInputStream fileInputStream = null;
        byte[] bFile = new byte[(int) file.length()];
        try {
            //convert file into array of bytes
            fileInputStream = new FileInputStream(file);
            fileInputStream.read(bFile);
            fileInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bFile;
    }

    public static Media getMediaFromRequestPart(HttpServletRequest request, String s) {
        try {
            List<Part> parts = new ArrayList<>(request.getParts());
            for (Part part : parts) {
                if (part != null) {
                    String filename = getFilename(part);
                    if (filename.equals("")) {
                        return null;
                    } else {
                        int size = (int) part.getSize();
                        InputStream inputStream = part.getInputStream();
                        byte[] bytes = new byte[size];
                        inputStream.read(bytes);
                        Media media = new ItemImage();
                        media.setMediaRef(filename);
                        media.setContent(bytes);
                        return media;
                    }
                }
            }
        } catch (IOException | ServletException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    private static String getFilename(Part part) {
        for (String cd : part.getHeader("content-disposition").split(";")) {
            if (cd.trim().startsWith("filename")) {
                return cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
    }
}
