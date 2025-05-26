package org.lawforms.common;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class S3Service {

    private final AmazonS3 amazonS3;
    private final String bucketName = "lawformsbucket"; // 실제 버킷명으로 변경

    public S3Service(AmazonS3 amazonS3) {
        this.amazonS3 = amazonS3;
    }

    // 파일 경로 및 이름 설정
    public String setFileName(MultipartFile file) {
        return "uploads/" + file.getOriginalFilename();
    }

    // S3 파일 업로드
    public void uploadFile(MultipartFile file) throws IOException {
        String keyName = setFileName(file);

        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentLength(file.getSize());
        metadata.setContentType(file.getContentType());

        amazonS3.putObject(bucketName, keyName, file.getInputStream(), metadata);
    }
}
