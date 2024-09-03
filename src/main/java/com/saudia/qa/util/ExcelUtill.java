package com.saudia.qa.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtill {
	
	private String filepath =null;
	@SuppressWarnings("unused")
	private int sheetindex =0;
	public static Workbook testdataWorkbook; 
	public Sheet sheet;
	 public DataFormatter dataFormatter;
	 public File fileObj;
	    public FileInputStream fisObj;
	    
	public ExcelUtill(String filepath,int sheetindex) throws IOException {
	this.filepath=filepath;
	this.sheetindex=sheetindex;
	fileObj= new File(filepath);
	fisObj = new FileInputStream(fileObj);
	testdataWorkbook= new XSSFWorkbook(fisObj);
	}
	
	private static XSSFWorkbook excelWbook= null;
	private static XSSFSheet excelWSheet= null;
	@SuppressWarnings("unused")
	public static String[][] getExcelDataIn2DArray(String Path, String SheetName) {
		String[][] excelDataArray = null;
		try {
		FileInputStream excelfile = new FileInputStream(new File(Path));
		BufferedInputStream excelFilBuffer = new BufferedInputStream(excelfile);
		excelWbook = new XSSFWorkbook(excelFilBuffer);
		excelWSheet = excelWbook.getSheet (SheetName);
		int numofCols = excelWSheet.getRow(0) . getPhysicalNumberOfCells();
		int numOfRows = excelWSheet.getPhysicalNumberOfRows () ;
		excelDataArray = new String [numOfRows-1][numOfRows];
		for (int rowIndex = 0; rowIndex < excelDataArray. length; rowIndex++) {
			
		for (int colIndex=0;  colIndex<excelDataArray.length; colIndex++) {
			excelDataArray [rowIndex-1][colIndex]	=excelWSheet.getRow(rowIndex).getCell(colIndex).getStringCellValue();
			
		}
		}

	}catch (Exception e) {
		
}
		return excelDataArray;
}
	
	public int getSheetcount(String path) throws IOException {
		File file = new File(path);
		@SuppressWarnings("unused")
		FileInputStream fis =null;
		BufferedInputStream bufIn=null;
		Workbook wbook=null;
		try {
			
			
			fis = new FileInputStream(file);
			bufIn =new BufferedInputStream(bufIn);
			
			
		} catch(Exception e) {
			
		}
		String filepath = file.getAbsolutePath();
		String fileExcention = filepath.substring(filepath.indexOf("."));
		
		if (fileExcention.equals(".xlsx")) {
			try {
				wbook=new XSSFWorkbook(bufIn);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}else if (fileExcention.equals("xls")) {
			try {
				wbook=new HSSFWorkbook(bufIn);
			} catch (Exception e) {
				e.printStackTrace();
			}
			 
		}
		int countSheets = wbook.getNumberOfSheets();
		return countSheets;
	}
	
	
	public Sheet getsheet() throws IOException {
		File file = new File(filepath);
		@SuppressWarnings("unused")
		FileInputStream fis =null;
		BufferedInputStream bufIn=null;
		Workbook wbook=null;
		try {
			
			
			fis = new FileInputStream(file);
			bufIn =new BufferedInputStream(bufIn);
			
			
		} catch(Exception e) {
			
		}
		String filepath = file.getAbsolutePath();
		String fileExcention = filepath.substring(filepath.indexOf("."));
		
		if (fileExcention.equals(".xlsx")) {
			try {
				wbook=new XSSFWorkbook(bufIn);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}else if (fileExcention.equals("xls")) {
			try {
				wbook=new HSSFWorkbook(bufIn);
			} catch (Exception e) {
				e.printStackTrace();
			}
			 
		}
		 Sheet sheet= wbook.getSheetAt(0);
		return sheet;
	}
	
	/* Retrieve the column count present in the spreadsheet*/
	
	
	private short totalColcount() throws IOException {
		Sheet sheet = getsheet();
              Row row = sheet.getRow(0);
              short lastCollNum = row.getLastCellNum();
              return lastCollNum;
	}
	
	/*
	 *
	 *Retrieve the different type of cell Value................
	 *
	 *
	 */
	
	public String getcellValueAsString(Cell cell) {
		
		
String cellvalue = null;

if (cell!=null) {
	switch (cell.getCellType()) {
	case STRING:
		cellvalue =cell.getStringCellValue().trim();	
		  break;
	case NUMERIC:
		if (DateUtil.isCellDateFormatted(cell)) {
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			Date date = cell.getDateCellValue();
			String Actualdate = sdf.format(date).trim();
			cellvalue=Actualdate;
		}else {
			cellvalue=String.valueOf(cell.getNumericCellValue()).trim();
		}
		break;
	case BOOLEAN:
		cellvalue  =String.valueOf(cell.getBooleanCellValue()).trim();
		break;
	case FORMULA:
		cellvalue =cell.getCellFormula().trim();
		break;
	case BLANK:
		cellvalue ="";
		break;
		
	default:
		cellvalue="DEFAULT";
		break;
	}
}
return cellvalue;
		
		
		
	}
	
	/*
	 * Retrieve the Data From External feed and store in Map
	 */
	
	
	public Map<String, Map<String, String>> getExcelAsMap() throws IOException {
		Sheet sheet = getsheet();

	Map<String,Map<String, String>> completeSheetData=new HashedMap<String,Map<String, String>>();
			
	List<String> col_Header = new ArrayList<String>();
	 Row row = sheet.getRow(0);
	 Iterator<Cell> cell = row.cellIterator();
	 while (cell.hasNext()) {
		@SuppressWarnings("unused")
		Cell cell2 = (Cell) cell.next();
		col_Header.add(cell.next().getStringCellValue());
	}
	 int Rowcount = sheet.getLastRowNum()+1;
	 short col_count = totalColcount();
	 for (int rowIndex = 0; rowIndex <Rowcount; rowIndex++) {
		 Map<String , String> singleRowData = new HashedMap<String,String>();
		 Row newrow= sheet.getRow(rowIndex);
		 for (int collIndex = 0; collIndex <col_count ; collIndex++) {
			Cell newCell = newrow.getCell(collIndex);
			singleRowData.put(col_Header.get(collIndex), getcellValueAsString(newCell));
			
			
			
		}
		 completeSheetData.put(newrow.getCell(0).getStringCellValue(), singleRowData);
		
	}
	 return completeSheetData;
	 
	}
	
	public void writeDataFirstRow(ArrayList<String> values) {
		try {
			String ExcelPath = "PNR.xlsx";
	    	FileInputStream fis = new FileInputStream(ExcelPath);
	    	
	    	@SuppressWarnings("resource")
			XSSFWorkbook wb = new XSSFWorkbook(fis);
	    	XSSFSheet sheetAt = wb.getSheetAt(0);
	            int cellid = 0;
	           int rowID = 0;
	           for (Object obj : values) {
	        	   XSSFRow createRow = sheetAt.createRow(rowID++);
	               Cell cell = createRow.createCell(cellid);
	                 cell.setCellValue((String)obj);
	           }
	        FileOutputStream fos = new FileOutputStream(ExcelPath);
			wb.write(fos);
			fos.close();
	    	
			
		} catch (Exception e) {
			}

		

	}
	
	public String getValueFromExcel(String elementName, String columnHeader,String sheetName) throws IOException
    {
		
		//testdataWorkbook = new XSSFWorkbook(filepath);
		dataFormatter = new DataFormatter();
		Sheet sheet = testdataWorkbook.getSheet(sheetName);
        int columnIndex = -1;
        Row headerRow = sheet.getRow(0);
        for (Cell cell : headerRow) {
            String header = cell.getStringCellValue();
            if (header.equalsIgnoreCase(columnHeader)) {
                columnIndex = cell.getColumnIndex();
                break;}}
        if (columnIndex == -1) {
            throw new IllegalArgumentException("Column '" + columnHeader + "' not found in the Excel sheet.");
        }
        if(columnIndex != -1){
            for(Row row :sheet){
                Cell keyCell = row.getCell(0);
                if(keyCell.getStringCellValue().equalsIgnoreCase(elementName)) {
                    Cell valueCell = row.getCell(columnIndex);
                    
                  //  return valueCell.getStringCellValue();
                    
                   if(valueCell.getCellType() == CellType.NUMERIC)
                    {
                	   String val = dataFormatter.formatCellValue(valueCell);
                    	//return String.valueOf(valueCell.getNumericCellValue());
                	   return val;
                    }
                    else
                    {
                    	return valueCell.getStringCellValue();
                    }
                }
              }
            }
        return null;
    }
	
	

	}