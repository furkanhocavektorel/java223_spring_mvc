package com.mft.springgiris.utilty;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

public class Multipart {

    public static String multipartToUrl(MultipartFile image){

        String url="daha ölmedik";
        Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "de7jjkp9g",
                "api_key", "941968759529494",
                "api_secret", "XECh9rYDStZTK8JI1lHZO3j9OdM"));

        try {
            Map<?,?> uploadResult = cloudinary.uploader().upload(image.getBytes(), ObjectUtils.emptyMap());
            url=(String) uploadResult.get("url");
            return url;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
