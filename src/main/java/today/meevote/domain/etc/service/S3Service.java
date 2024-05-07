package today.meevote.domain.etc.service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.DeleteObjectRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.util.IOUtils;
import com.amazonaws.util.StringUtils;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import today.meevote.contextholder.MemberContextHolder;
import today.meevote.exception.rest.RestException;
import today.meevote.response.FailureInfo;

@Service
@RequiredArgsConstructor
@Slf4j
public class S3Service {

	private final AmazonS3 amazonS3;
	
	@Value("${cloud.aws.s3.bucket}")
	private String bucketName;
	
	public String uploadProfileImage(MultipartFile image) {
		
	    if(image == null || image.isEmpty() || Objects.isNull(image.getOriginalFilename())){
	      throw new RestException(FailureInfo.EMPTY_FILE);
	    }	  
	    
	    return this.uploadImage(image);
	}
	
	private String uploadImage(MultipartFile image) {
	    this.validateImageFileExtention(image.getOriginalFilename());
	    try {
	        return this.uploadImageToS3(image);
	    } catch (IOException e) {
		    log.error("IOException", e);
	        throw new RestException(FailureInfo.IMAGE_UPLOAD_FAIL);
	    }
	}
	
	private void validateImageFileExtention(String filename) {
	    int lastDotIndex = filename.lastIndexOf(".");
	    if (lastDotIndex == -1) {
	        throw new RestException(FailureInfo.INVALID_FILE_EXENTION);
	    }

	    String extention = filename.substring(lastDotIndex + 1).toLowerCase();
	    List<String> allowedExtentionList = Arrays.asList("jpg", "jpeg", "png", "gif");

	    if (!allowedExtentionList.contains(extention)) {
	        throw new RestException(FailureInfo.INVALID_FILE_EXENTION);
        }
    }
	
	private String uploadImageToS3(MultipartFile image) throws IOException {
		
		String extention = image.getContentType()
								.substring(image.getContentType().lastIndexOf("/") + 1);
		
	    String s3FileName = "profile/" + MemberContextHolder.getEmail() + "." + extention;

	    InputStream is = image.getInputStream();
	    byte[] bytes = IOUtils.toByteArray(is); 

	    ObjectMetadata metadata = new ObjectMetadata(); 
	    metadata.setContentType(image.getContentType());
	    metadata.setContentLength(bytes.length);
	  
	    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes); 

	    try{
	        PutObjectRequest putObjectRequest =
	            new PutObjectRequest(bucketName, s3FileName, byteArrayInputStream, metadata)
	                .withCannedAcl(CannedAccessControlList.PublicRead);
	        
	        amazonS3.putObject(putObjectRequest); 
	    }catch (Exception e){
	    	log.error("Exception", e);
	        throw new RestException(FailureInfo.IMAGE_UPLOAD_FAIL);
	    }finally {
	        byteArrayInputStream.close();
	        is.close();
	    }

	  return amazonS3.getUrl(bucketName, s3FileName).toString();
	}
	
	
}
