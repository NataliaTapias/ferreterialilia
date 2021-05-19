package objetos;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Calendar;
import javax.swing.JTable;

public class Pdf
{
  public void docu(JTable table, int tol)
    throws DocumentException, FileNotFoundException
  {
    Calendar fecha = Calendar.getInstance();
    int año = fecha.get(1);
    int mes = fecha.get(2) + 1;
    int dia = fecha.get(5);
    int hora = fecha.get(11);
    int minuto = fecha.get(12);
    int segundo = fecha.get(13);
    
    String nom = dia + "-" + mes + "-" + año + "-" + hora + "-" + minuto + "-" + segundo;
    try
    {
      Document doc = new Document();
      PdfWriter.getInstance(doc, new FileOutputStream("Pdf/" + nom + ".pdf"));
      doc.open();
      PdfPTable pdfTable = new PdfPTable(table.getColumnCount() - 1);
      for (int i = 1; i < table.getColumnCount(); i++) {
        pdfTable.addCell(table.getColumnName(i));
      }
      for (int rows = 0; rows < table.getRowCount(); rows++) {
        for (int cols = 1; cols < table.getColumnCount(); cols++) {
          pdfTable.addCell(table.getModel().getValueAt(rows, cols).toString());
        }
      }
      int toll = tol;
      int too = (int)(toll * 0.19D);
      int to = too + tol;
      PdfPCell celdaFinal = new PdfPCell(new Paragraph("SUBTOTAL: " + toll));
      celdaFinal.setColspan(5);
      pdfTable.addCell(celdaFinal);
      
      PdfPCell celdaFinal1 = new PdfPCell(new Paragraph("IVA: " + too));
      celdaFinal1.setColspan(5);
      pdfTable.addCell(celdaFinal1);
      
      PdfPCell celdaFinal2 = new PdfPCell(new Paragraph("TOTAL: " + to));
      celdaFinal2.setColspan(5);
      pdfTable.addCell(celdaFinal2);
      
      doc.add(pdfTable);
      doc.close();
      System.out.println("done");
    }
    catch (DocumentException localDocumentException) {}catch (FileNotFoundException localFileNotFoundException) {}
  }
  
  public static void main(String[] args)
    throws FileNotFoundException, DocumentException
  {}
}
