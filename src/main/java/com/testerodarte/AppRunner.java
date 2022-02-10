package com.testerodarte;

import java.io.File;
import java.io.FileInputStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import com.testerodarte.Models.Alunos;
import com.testerodarte.Repository.AlunosRepository;

@Component
public class AppRunner implements CommandLineRunner {
	final Logger LOGGER = LoggerFactory.getLogger(getClass());
	
	@Autowired
	AlunosRepository alunosRepository;

	@Override
	public void run(String... args) throws Exception {
		try {
			Resource resource = new ClassPathResource("Base Importação Teste RN.xlsx");
			FileInputStream file = new FileInputStream(resource.getFile());
			
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheetAt(0);
			Iterator<Row> rowIterator = sheet.iterator();
			
            if (rowIterator.hasNext())
            	rowIterator.next();
			
			while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();
                
                Alunos aluno = new Alunos();
                int index = 0;
                
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    switch (index) {
	                    case 0:
	                    	aluno.setIdentificacao(BigInteger.valueOf((long) cell.getNumericCellValue()));
	                      break;
	                    case 1:
	                    	aluno.setNome(cell.getStringCellValue());
	                      break;
	                    case 2:
	                    	aluno.setSexo(cell.getStringCellValue().charAt(0));
	                      break;
	                    case 3:
	                    	aluno.setData_nascimento(cell.getLocalDateTimeCellValue().toLocalDate());
	                      break;
	                    case 4:
	                    	aluno.setIdade(BigInteger.valueOf((long) cell.getNumericCellValue()));
	                      break;
	                    case 5:
	                    	aluno.setNota_1(BigDecimal.valueOf((long) cell.getNumericCellValue()));
	                      break;
	                    case 6:
	                    	aluno.setNota_2(BigDecimal.valueOf((long) cell.getNumericCellValue()));
	                      break;
	                    case 7:
	                    	aluno.setNota_3(BigDecimal.valueOf((long) cell.getNumericCellValue()));
	                      break;
	                    default:
	                      break;
                    }
                    index++;
                }
                alunosRepository.save(aluno);
            }
			
            file.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
