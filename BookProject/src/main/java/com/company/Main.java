package com.company;

import com.company.model.Book;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        System.out.println("please input Books count");
        bookToExcel();

    }

    private static void bookToExcel() throws IOException {
        Workbook workbook = new XSSFWorkbook();
        Sheet booksSheet = workbook.createSheet("Գրքեր");
        Row row = booksSheet.createRow(0);

        Cell titleCell = row.createCell(0);
        titleCell.setCellValue("Title");

        Cell descriptionCell = row.createCell(1);
        descriptionCell.setCellValue("Description");

        Cell priceCell = row.createCell(2);
        priceCell.setCellValue("Price");

        Cell countCell = row.createCell(3);
        countCell.setCellValue("Count");

        List<Book> books = getBooks();

        int rowIndex = 1;
        for (Book book : books) {
            Row bookDataRow = booksSheet.createRow(rowIndex++);

            Cell bookTitleCell = bookDataRow.createCell(0);
            bookTitleCell.setCellValue(book.getTitle());

            Cell bookDeskriptionCell = bookDataRow.createCell(1);
            bookDeskriptionCell.setCellValue(book.getDescription());

            Cell bookPriceCell = bookDataRow.createCell(2);
            bookPriceCell.setCellValue(book.getPrice());

            Cell bookCountCell = bookDataRow.createCell(3);
            bookCountCell.setCellValue(book.getCount());
        }

        FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\And\\IdeaProjects\\BookProject\\src\\main\\resources\\Books.xlsx");
        workbook.write(fileOutputStream);
        workbook.close();
    }



    private static  List<Book> getBooks() {

        Scanner scanner = new Scanner(System.in);

        List<Book> bookList = new ArrayList<>();

       // System.out.println("please input Books count");
        int count = Integer.parseInt(scanner.nextLine());
        if (count == 0){
            return null;
        }


        for (int i=0; i < count; i++) {
            System.out.println("input tittle, description, price, count");

            String bookStr = scanner.nextLine();
            String[] bookStrArr = bookStr.split(",");
            Book book = new Book();
            book.setTitle(bookStrArr[0]);
            book.setDescription(bookStrArr[1]);
            book.setPrice(Double.parseDouble(bookStrArr[2]));
            book.setCount(Integer.parseInt(bookStrArr[3]));

           bookList.add(book);

        }
        return bookList;
    }
}
