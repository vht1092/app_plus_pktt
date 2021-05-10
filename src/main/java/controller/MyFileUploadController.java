package controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.support.ByteArrayMultipartFileEditor;

import dao.GttnDAO;
import dao.InfoAtmDAO;

@Controller
public class MyFileUploadController {

	@Autowired
	private GttnDAO GttnDAO;

	// Phương thức này được gọi mỗi lần có Submit.
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		Object target = dataBinder.getTarget();
		if (target == null) {
			return;
		}
		System.out.println("Target=" + target);

		if (target.getClass() == MyUploadForm.class) {

			// Đăng ký để chuyển đổi giữa các đối tượng multipart thành byte[]
			dataBinder.registerCustomEditor(byte[].class, new ByteArrayMultipartFileEditor());
		}
	}

	// GET: Hiển thị trang form upload
	@RequestMapping(value = "/uploadOneFile", method = RequestMethod.GET)
	public String uploadOneFileHandler(Model model) {

		MyUploadForm myUploadForm = new MyUploadForm();
		model.addAttribute("myUploadForm", myUploadForm);

		// Forward to "/WEB-INF/pages/uploadOneFile.jsp".
		return "uploadOneFile";
	}

	// POST: Sử lý Upload
	@RequestMapping(value = "/uploadOneFile", method = RequestMethod.POST)
	public String uploadOneFileHandlerPOST(HttpServletRequest request, //
			Model model, //
			@ModelAttribute("myUploadForm") MyUploadForm myUploadForm) throws IOException {

		return this.doUpload(request, model, myUploadForm);

	}

	// GET: Hiển thị trang form upload
	@RequestMapping(value = "/uploadMultiFile", method = RequestMethod.GET)
	public String uploadMultiFileHandler(Model model) {

		MyUploadForm myUploadForm = new MyUploadForm();
		model.addAttribute("myUploadForm", myUploadForm);

		// Forward to "/WEB-INF/pages/uploadMultiFile.jsp".
		return "uploadMultiFile";
	}

	// POST: Sử lý Upload
	@RequestMapping(value = "/uploadMultiFile", method = RequestMethod.POST)
	public String uploadMultiFileHandlerPOST(HttpServletRequest request, //
			Model model, //
			@ModelAttribute("myUploadForm") MyUploadForm myUploadForm) throws IOException {

		return this.doUpload(request, model, myUploadForm);

	}

	private String doUpload(HttpServletRequest request, Model model, //
			MyUploadForm myUploadForm) throws IOException {

		String description = myUploadForm.getDescription();
		System.out.println("Description: " + description);
		String fileName = null;

		// Thư mục gốc upload file.
		// String uploadRootPath =
		// request.getServletContext().getRealPath("upload");
		String uploadRootPath = "E:/giao_the_tan_noi/";
		System.out.println("uploadRootPath=" + uploadRootPath);

		File uploadRootDir = new File(uploadRootPath);
		//
		// Tạo thư mục gốc upload nếu nó không tồn tại.
		if (!uploadRootDir.exists()) {
			uploadRootDir.mkdirs();
		}
		CommonsMultipartFile[] fileDatas = myUploadForm.getFileDatas();
		//
		List<File> uploadedFiles = new ArrayList<File>();
		for (CommonsMultipartFile fileData : fileDatas) {

			// Tên file gốc tại Client.
			String name = fileData.getOriginalFilename();
			System.out.println("Client File Name = " + name);
			Common common = new Common();
			fileName = String.valueOf(common.get_SystemTime()) + "_" + name;

			if (name != null && name.length() > 0) {
				try {
					// Tạo file tại Server.
					File serverFile = new File(uploadRootDir.getAbsolutePath() + File.separator + fileName);

					// Luồng ghi dữ liệu vào file trên Server.
					BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
					stream.write(fileData.getBytes());
					stream.close();
					//
					uploadedFiles.add(serverFile);
					System.out.println("Write file: " + serverFile);
				} catch (Exception e) {
					System.out.println("Error Write file: " + name + ": " + e.toString());
				}
			}
		}
		int count = read_File_andUpdate_DB(uploadRootPath + fileName);
		String result = "Đã cập nhật trạng thái Giao thẻ tận nơi. Số lượng: " + String.valueOf(count);
		model.addAttribute("result", result);
		return "uploadOneFile";
	}

	public int read_File_andUpdate_DB(String fileName) throws IOException {
		// Đọc một file XSL.
		FileInputStream inputStream = new FileInputStream(new File(fileName));

		// Đối tượng workbook cho file XSL.
		HSSFWorkbook workbook = new HSSFWorkbook(inputStream);

		// Lấy ra sheet đầu tiên từ workbook
		HSSFSheet sheet = workbook.getSheetAt(0);

		// Lấy ra Iterator cho tất cả các dòng của sheet hiện tại.
		Iterator<Row> rowIterator = sheet.iterator();

		String result = "", soThe = null, soLoc = null, tinhTrang = null;
		int count = 0;
		while (rowIterator.hasNext()) {
			Row row = rowIterator.next();

			// Lấy Iterator cho tất cả các cell của dòng hiện tại.
			Iterator<Cell> cellIterator = row.cellIterator();

			while (cellIterator.hasNext()) {
				Cell cell = cellIterator.next();

				// Đổi thành getCellType() nếu sử dụng POI 4.x
				CellType cellType = cell.getCellTypeEnum();

				switch (cellType) {
				case _NONE:
					System.out.print("");
					System.out.print("\t");
					break;
				case BOOLEAN:
					System.out.print(cell.getBooleanCellValue());
					System.out.print("\t");
					break;
				case BLANK:
					System.out.print("");
					System.out.print("\t");
					break;
				case FORMULA:
					// Công thức
					System.out.print(cell.getCellFormula());
					System.out.print("\t");
					FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
					// In ra giá trị từ công thức
					System.out.print(evaluator.evaluate(cell).getNumberValue());
					break;
				case NUMERIC:
					System.out.print(cell.getNumericCellValue());
					System.out.print("\t");
					break;
				case STRING:
					String content = cell.getStringCellValue();
					if (!content.equals("LOC") && !content.equals("PANMASK") && !content.equals("RESULT")) {
						result += cell.getStringCellValue();
						if (result.length() == 17) {
							soLoc = result.substring(0, 12);
							soThe = result.substring(12, 16);
							tinhTrang = result.substring(16, 17);
							GttnDAO.update_DB_GTTN(soThe, soLoc, tinhTrang);
							count++;
							result = "";
						}
					}

					System.out.print(cell.getStringCellValue());
					System.out.print("\t");
					break;
				case ERROR:
					System.out.print("!");
					System.out.print("\t");
					break;
				}
			}
			System.out.println("");
		}
		return count;
	}

}
