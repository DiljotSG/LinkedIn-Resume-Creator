//Package and import statements
package ResumeRandomizer;

import com.itextpdf.kernel.color.DeviceRgb;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.layout.border.Border;
import com.itextpdf.layout.element.*;

import java.util.Arrays;

/**
 * CLASS: ComponentCreator
 * REMARKS: This class is used to assist in creating the PDF.
 * -It makes interacting with the PDF creator library easier,
 * by defining commonly used methods (making lists and paragraphs).
 *
 * @author Diljot Garcha
 * @author Mackenzie Plowman
 * @author Mario Mendez
 * @author Nicolas Connor
 */
public class ComponentCreator
{
	//Instance variables
	private PdfFont defaultFont;
	private int defaultFontSize;

	/**
	 * Constructor for this ComponentCreator
	 */
	public ComponentCreator(PdfFont defaultFont, int defaultFontSize)
	{
		this.defaultFont = defaultFont;
		this.defaultFontSize = defaultFontSize;
	}

	/**
	 * Makes a Borderless table
	 */
	public Table createBorderlessTable(int spacing, int columns, String[] elementList)
	{
		float[] columnWidths = new float[columns];
		Arrays.fill(columnWidths, spacing);
		Table table = new Table(columnWidths);

		//cell array
		Cell[] tableCells = new Cell[elementList.length];

		//turn the string array into text array for adding fonts and font sizes
		Text[] textList = new Text[elementList.length];

		for(int j = 0; j < textList.length; j++)
		{
			textList[j] = new Text(elementList[j]);
			textList[j].setFont(defaultFont);
			textList[j].setFontSize(defaultFontSize);
		}

		for(int i = 0; i < elementList.length; i++)
		{  //initialize all cells, add
			tableCells[i] = new Cell();
			tableCells[i].add(elementList[i]);
			tableCells[i].setBorder(Border.NO_BORDER);
			table.addCell(tableCells[i]);
		}

		table.setFont(defaultFont);
		table.setFontSize(defaultFontSize);
		return table;
	}//add borderless table

	/**
	 * Creates a Paragraph
	 */
	public Paragraph createParagraph(String text)
	{
		Paragraph result;

		Text paragraphText = new Text(text);
		paragraphText.setFont(defaultFont);
		paragraphText.setFontSize(defaultFontSize);
		result = new Paragraph(paragraphText);

		return result;
	}

	/**
	 * Creates a List of items
	 */
	public List createList(String[] elementList)
	{
		List list = new List();

		list.setFont(defaultFont);
		list.setFontSize(defaultFontSize);

		for(int i = 0; i < elementList.length; i++)
		{
			list.add(elementList[i]);
		}

		return list;
	}//create List

	/**
	 * Creates a Borderless table list
	 */
	public Table createBorderlessTableList(int spacing, int columns, String[] elementList)
	{
		float[] columnWidths = new float[columns];
		Arrays.fill(columnWidths, spacing);
		Table table = new Table(columnWidths);


		List[] list = new List[elementList.length];


		//cell array
		Cell[] tableCells = new Cell[elementList.length];

		//turn the string array into text array for adding fonts and font sizes
		Text[] textList = new Text[elementList.length];


		for(int x = 0; x < elementList.length; x++)
		{

			list[x] = new List();
			list[x].setListSymbol("•  ");
			list[x].setFont(defaultFont);
			list[x].setFontSize(defaultFontSize);

			list[x].add(elementList[x]);

		}


		for(int j = 0; j < textList.length; j++)
		{
			textList[j] = new Text(elementList[j]);
			textList[j].setFont(defaultFont);
			textList[j].setFontSize(defaultFontSize);
		}

		for(int i = 0; i < elementList.length; i++)
		{  //initialize all cells, add elements into the table
			tableCells[i] = new Cell();
			tableCells[i].add(list[i]);
			tableCells[i].setBorder(Border.NO_BORDER);
			table.addCell(tableCells[i]);
		}

		table.setFont(defaultFont);
		table.setFontSize(defaultFontSize);
		return table;
	}

	/**
	 * Used for creating bullet points
	 */
	public Paragraph createDashSeparation(int size)
	{
		Paragraph separator;
		String dash = "";

		String[] characters = new String[size];
		Arrays.fill(characters, "_");

		//mix all dashes in one string
		for(int i = 0; i < characters.length; i++)
		{
			dash += characters[i];
		}

		//make text index
		Text text = new Text(dash);

		text.setFont(defaultFont);
		text.setFontSize(defaultFontSize);
		separator = new Paragraph(text);
		return separator;
	}

	/**
	 * Creates a title object with a background
	 */
	public Table createTitleWithBackground(String title)
	{
		float[] columnWidths = {20};

		Table Finaltitle = new Table(columnWidths);

		Cell titleCell = new Cell();
		titleCell.add(title);

		com.itextpdf.kernel.color.Color randColor = new DeviceRgb(235, 235, 235);
		titleCell.setBackgroundColor(randColor);
		titleCell.setBorder(Border.NO_BORDER);

		Finaltitle.addCell(titleCell);

		return Finaltitle;
	}

}//Component Creator Class