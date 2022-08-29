package cn.itcast.user.utils;


import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ImportExcel {
	

    /** 
     * @Title: createWorkbook 
     * @Description: 判断excel文件后缀名，生成不同的workbook      * @param @param is
     * @param @param excelFileName
     * @param @return
     * @param @throws IOException
     * @return Workbook
     * @throws 
     */
    public Workbook createWorkbook(InputStream is,String excelFileName) throws IOException{
        if (excelFileName.endsWith(".xls")) {
            return new HSSFWorkbook(is);
        }else if (excelFileName.endsWith(".xlsx")) {
            return new XSSFWorkbook(is);
        }
        return null;
    }

    /** 
     * @Title: getSheet 
     * @Description: 根据sheet索引号获取对应的sheet
     * @param @param workbook
     * @param @param sheetIndex
     * @param @return
     * @return Sheet
     * @throws 
     */
    public Sheet getSheet(Workbook workbook,int sheetIndex){
        return workbook.getSheetAt(0);        
    }


    public List<List<String>> importDataFromExcel(InputStream is,String excelFileName,int j) throws Exception{
        List<List<String>> list = new ArrayList<List<String>>();
        try {
            //创建工作簿
            Workbook workbook = this.createWorkbook(is, excelFileName);
            //创建工作表sheet
            Sheet sheet = this.getSheet(workbook, 0);
            //获取sheet中数据的行数
            int rows = sheet.getPhysicalNumberOfRows();
            if(rows <= 1) {//似乎是一个空的excel文件
            	return list;
            }
            //获取表头单元格个数
            int cells = sheet.getRow(0).getPhysicalNumberOfCells();
            
            
            for (int i = j; i < rows; i++) {//数据从j开始
                List<String> l = new ArrayList<>();
                
                Row row = sheet.getRow(i);
                int index = 0;
                while (index < cells) {
                    Cell cell = row.getCell(index);
                    if (null == cell) {
                        cell = row.createCell(index);
                    }
                    cell.setCellType(Cell.CELL_TYPE_STRING);
                    String value = null == cell.getStringCellValue()?"":cell.getStringCellValue();
                    l.add(value);
                    index++;
                }
                list.add(l);

            }
        } catch (Exception e) {
        	e.printStackTrace();
        	throw e;
        }finally{
            try {
                is.close();//关闭流
            } catch (Exception e2) {
                e2.printStackTrace();
                throw e2;
            }
        }
        return list;

    }

    /** 
     * @Title: isHasValues 
     * @Description: 判断一个对象所有属性是否有值，如果一个属性有值(分空)，则返回true
     * @param @param object
     * @param @return
     * @return boolean
     * @throws 
     */
    public boolean isHasValues(Object object){
        Field[] fields = object.getClass().getDeclaredFields();
        boolean flag = false;
        for (int i = 0; i < fields.length; i++) {
            String fieldName = fields[i].getName();
            String methodName = "get"+fieldName.substring(0, 1).toUpperCase()+fieldName.substring(1);
            Method getMethod;
            try {
                getMethod = object.getClass().getMethod(methodName);
                Object obj = getMethod.invoke(object);
                if (null != obj && !"".equals(obj)) {
                    flag = true;
                    break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }                 
        }
        return flag;

    }

}
