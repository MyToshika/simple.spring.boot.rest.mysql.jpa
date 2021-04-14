package com.mytoshika.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Service;

import com.mytoshika.entity.TestDto;

@Service
public class XLSXFileHandler {

	@SuppressWarnings("null")
	public List<TestDto> readFile() {

		List<TestDto> repoList = new ArrayList<>();
		File file = new File("E:\\testFiles.xls");
		try (Workbook workbook = new HSSFWorkbook(new FileInputStream(file))) {
			Sheet sheet = workbook.getSheetAt(0);

			int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();
			for (int i = 0; i < rowCount+1; i++) { 
				Row row = sheet.getRow(i);

				Iterator<Cell> cellIterator = row.cellIterator();
				TestDto repoDto = new TestDto();

				while (cellIterator.hasNext()) {
					Cell nextCell = cellIterator.next();
					int columnIndex = nextCell.getColumnIndex();

					switch (columnIndex) {
					case 0:
						repoDto.setFirstColumn(nextCell.getStringCellValue());
						break;
					case 1:
						repoDto.setSecondColumn(nextCell.getStringCellValue());
						break;
					case 2:
						repoDto.setThirdColumn(nextCell.getStringCellValue());
						break;
					case 3:
						repoDto.setFourthColumn(nextCell.getStringCellValue());
						break;
					case 4:
						repoDto.setFifthColumn(nextCell.getStringCellValue());
						break;
					case 5:
						repoDto.setFourthColumn(nextCell.getStringCellValue());
						break;
					}
				}
				repoList.add(repoDto);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return repoList;
	}
}
