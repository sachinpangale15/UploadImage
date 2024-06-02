package Upload.ImageDB.Controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import Upload.ImageDB.Service.FileService;

@RestController
@RequestMapping("api/v1")
public class FileController {
	
	@Autowired
	private FileService fileService;
	
	@PostMapping("uploadFileIntoDB")
	public ResponseEntity<String> storeFileIntoDB(@RequestParam("file") MultipartFile file) throws IOException{
		String response = fileService.storeFile1(file);
		
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	@GetMapping("/getImage/{fileName}")
	public ResponseEntity<byte[]> getImage(@PathVariable String fileName) {
		byte[] imageData = fileService.getFiles(fileName);
		
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf("image/png")).body(imageData);
		
	}

}
