package resumeRandomizer;

import com.itextpdf.io.font.FontConstants;
import com.itextpdf.kernel.color.DeviceRgb;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.List;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.Text;
import java.util.Random;
import java.awt.*;


import java.util.Arrays;

public class resumeMasters {
	
	public static void main(String args[]) throws Exception {		
		
		// Creating a PdfWriter
		ResumeReader bob = new ResumeReader();
		String dest = "/Users/KenzieVictoria/Documents/iTextExamples/sample.pdf";
		PdfWriter writer = new PdfWriter(dest);
		
		Random rand = new Random();
		
		// Will produce only bright / light colours:
		float r = (float) (rand.nextFloat() / 2 + 0.5);
		float g = (float) (rand.nextFloat() / 2 + 0.5);
		float b = (float) (rand.nextFloat() / 2 + 0.5);
		
		
		// Font Sizes & Styling
		int mainFontSize = 11;
		float headerSize = (float) (mainFontSize*1.28);
		float nameSize = (float) (mainFontSize*1.88);
		
		PdfFont boldHeader = PdfFontFactory.createFont(FontConstants.HELVETICA_BOLD);
		
		PdfFont font = PdfFontFactory.createFont(FontConstants.HELVETICA); 
		ComponentCreator creator = new ComponentCreator(font,mainFontSize);

		// Creating a PdfDocument
		PdfDocument pdfDoc = new PdfDocument(writer);
		
		// Get Work & Edu Experience Number
		int workExpNum = bob.getNumWorkExperience();
		int eduNum = bob.getNumEducation();

		// Adding a new page
		pdfDoc.addNewPage();

		// Creating a Document
		Document document = new Document(pdfDoc);

		String name = bob.getName();

	// --- Experience -----------------------------------

		String exp = "Experience";
		
		String expContent = "";
		
		for(int i=0; i<workExpNum;i++){
			 expContent += bob.getWorkExperienceCompany(i) + "\n";
			 expContent += " • "+ bob.getWorkExperienceTitle(i) + "\n \n";
		}
	
		
	// --- Education -----------------------------------

		String edu = "Education";
		
		String eduContent = "";
		
		for(int i=0; i<eduNum;i++){
			eduContent += bob.getEducationInstitution(i) + "\n";
			eduContent += " • "+ bob.getEducationStudy(i) + " \n \n";
		} 
		
	// --- Skills -----------------------------------
		
		String skills = "Skills"; // header
		Text skillsTitle = new Text(skills); // adds skills
		skillsTitle.setFont(boldHeader);

		// gets skills from resume file
		String[] theList = bob.getSkills();

	// --- Skills -----------------------------------

		Table mySkills = creator.createBorderlessTableList(300, 3, theList);
		
		Paragraph separator = creator.createDashSeparation(75);

	// --- End Skills -----------------------------------
		
		com.itextpdf.kernel.color.Color randColor = new DeviceRgb(r, g, b);
		float properLeading = (float) (mainFontSize*1.5);
		float smallerLeading = (float) (mainFontSize*1.2);

	
		// Creating Paragraphs
		
	// --- Header -----------------------------------
		Paragraph paragraph1 = new Paragraph(name).setFontSize(nameSize).setBold().setFontColor(randColor, 100);
		Paragraph paragraph2 = new Paragraph(exp).setFontSize(headerSize).setFontColor(randColor, (float).85);
		

		Paragraph paragraph3 = new Paragraph(edu).setFontSize(headerSize).setFontColor(randColor, (float).85);
		Paragraph paragraph4 = new Paragraph(skills).setFontSize(headerSize).setFontColor(randColor, (float).85);
		Paragraph paragraph5 = new Paragraph(expContent).setFontSize(mainFontSize);
		Paragraph paragraph6 = new Paragraph(bob.getWorkExperienceTitle(0)).setFontSize(headerSize).setFontColor(randColor, (float).85).setFixedLeading((float) .05);
		Paragraph paragraph7 = new Paragraph(eduContent).setFontSize(mainFontSize).setFixedLeading(properLeading).setFixedLeading((float) smallerLeading);

		// Adding paragraphs to document
		document.add(paragraph1); // name
		document.add(paragraph6); // label
		document.add(separator);  // border
		document.add(paragraph2); // exp
		document.add(paragraph5).setFontSize(mainFontSize); // expContent

		//education
		document.add(paragraph3); // edu
		document.add(paragraph7); // education content

		//skills
		document.add(paragraph4); // skills title
		document.add(mySkills);

		// Closing the document
		document.close();
		System.out.println("PDF Edited");
	}

}
