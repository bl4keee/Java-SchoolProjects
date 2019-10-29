import java.io.*;
import java.util.ArrayList;

import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

public class Dokument {
	private String tytul;
	private String tresc;
	
	public Dokument(String tytul, String tresc)
	{
		this.tytul = tytul;
		this.tresc = tresc;
	}
	

	public void saveMeToPDF(int number) throws IOException {
		try {
		Document document = new Document();
		PdfWriter.getInstance(document, new FileOutputStream(number + 1 + "_" + tytul + ".pdf"));
		document.open();
		document.addTitle(tytul);
		document.add(new Paragraph("Dokument\n"));
		document.add(new Paragraph(getTytul() + "\n"));
		document.add(new Paragraph(getTresc() + "\n"));
		document.close();
		} catch (Exception e) {
		e.printStackTrace();
	}
	}
		
	
	public void saveMeToTXT(int number) throws IOException {
		FileWriter fwriter = new FileWriter(number + 1 + "_" + getTytul() + ".txt");
		BufferedWriter bwriter = new BufferedWriter(fwriter);
			bwriter.write("Dokument\n");
			bwriter.write(getTytul() + "\n");
			bwriter.write(getTresc() + "\n");
		bwriter.close();
		fwriter.close();
	}
	
	public void setTytul(String tytul) {
		this.tytul = tytul;
	}
	public String getTytul() {
		return tytul;
	}
	public void setTresc(String tresc) {
		this.tresc = tresc;
	}
	public String getTresc() {
		return tresc;
	} 
}
