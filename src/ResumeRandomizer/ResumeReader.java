//Package and import statements
package ResumeRandomizer;

import processing.data.JSONArray;
import processing.data.JSONObject;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * CLASS: ResumeReader
 * REMARKS: This classes' main job is to read the given JSON file, and offer output.
 *
 * @author Diljot Garcha
 * @author Mackenzie Plowman
 * @author Mario Mendez
 * @author Nicolas Connor
 */
public class ResumeReader
{
	//Instance variables
	private JSONObject resume;

	/**
	 * The constructor for the ResumeReader object
	 */
	public ResumeReader()
	{
		String content = "";
		try
		{
			content = new Scanner(new File("resume.json")).useDelimiter("\\Z").next();
		} catch(IOException e)
		{
			System.out.println(e);
		}

		resume = JSONObject.parse(content);
	}

	/**
	 * @return The name of the person.
	 */
	public String getName()
	{
		return resume.getJSONObject("basics").getString("name");
	}

	/**
	 * @return The label of the person.
	 */
	public String getLabel()
	{
		return resume.getJSONObject("basics").getString("label");
	}

	/**
	 * @return The summary of the person.
	 */
	public String getSummary()
	{
		return resume.getJSONObject("basics").getString("summary");
	}

	/**
	 * @return The number of work experiences of this person.
	 */
	public int getNumWorkExperience()
	{
		return resume.getJSONArray("work").size();
	}

	/**
	 * @return The work experience details for a specific company.
	 */
	public String getWorkExperienceCompany(int num)
	{
		JSONArray work = resume.getJSONArray("work");
		JSONObject item = work.getJSONObject(num);
		return item.getString("company");
	}

	/**
	 * @return The job title for this work experience.
	 */
	public String getWorkExperienceTitle(int num)
	{
		JSONArray work = resume.getJSONArray("work");
		JSONObject item = work.getJSONObject(num);
		return item.getString("summary");
	}

	/**
	 * @return The number of educations for this person.
	 */
	public int getNumEducation()
	{
		return resume.getJSONArray("education").size();
	}

	/**
	 * @return The name of this education.
	 */
	public String getEducationInstitution(int num)
	{
		JSONArray edu = resume.getJSONArray("education");
		JSONObject item = edu.getJSONObject(num);
		return item.getString("institution");
	}

	/**
	 * @return The details of this education.
	 */
	public String getEducationStudy(int num)
	{
		JSONArray edu = resume.getJSONArray("education");
		JSONObject item = edu.getJSONObject(num);
		return item.getString("studyType");
	}

	/**
	 * @return The number of skills for this person.
	 */
	public int getNumSkills()
	{
		return resume.getJSONArray("skills").size();
	}

	/**
	 * @return A string array of their skills.
	 */
	public String[] getSkills()
	{
		int size = getNumSkills();
		String[] result = new String[size];

		JSONArray skills = resume.getJSONArray("skills");

		for(int i = 0; i < size; i++)
		{
			result[i] = skills.getJSONObject(i).getString("name");
		}

		return result;
	}

	/**
	 * @return The number of projects for this person.
	 */
	public int getNumProjects()
	{
		return resume.getJSONArray("projects").size();
	}

	// Abandoned methods due to lack of time
	/*public String getProjectTitle(int num)
	{
		JSONArray projects = resume.getJSONArray("projects");
		JSONObject item = projects.getJSONObject(num);
		return item.getString("name");
	}

	public String getProjectTitle(int num)
	{
		JSONArray projects = resume.getJSONArray("projects");
		JSONObject item = projects.getJSONObject(num);
		return item.getString("name");
	}

	public String getProjectTitle(int num)
	{
		JSONArray projects = resume.getJSONArray("projects");
		JSONObject item = projects.getJSONObject(num);
		return item.getString("name");
	}*/

	/**
	 * A simple method to test the ResumeReader Class
	 */
	public static void main(String[] args)
	{
		ResumeReader test = new ResumeReader();
		System.out.println(test.getName());
		System.out.println(test.getLabel());
		System.out.println(test.getSummary());
		System.out.println(test.getNumWorkExperience());
		System.out.println("Title: " + test.getWorkExperienceTitle(0));
		System.out.println("Company: " + test.getWorkExperienceCompany(0));
		System.out.println(test.getNumEducation());
		System.out.println(test.getEducationInstitution(0));
		System.out.println(test.getEducationStudy(0));
		System.out.println(test.getNumSkills());
		System.out.println(Arrays.toString(test.getSkills()));
	}
}//Resume Reader Class