package ResumeRandomizer;

import processing.data.JSONArray;
import processing.data.JSONObject;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class ResumeReader
{
	private JSONObject resume;

	public ResumeReader()
	{
		String content = "";
		try
		{
			content = new Scanner(new File("resume-diljot.json")).useDelimiter("\\Z").next();
			//content = new Scanner(new File("resume-james.json")).useDelimiter("\\Z").next();
			//content = new Scanner(new File("resume.json")).useDelimiter("\\Z").next();
		} catch(IOException e)
		{
			System.out.println(e);
		}

		resume = JSONObject.parse(content);
	}

	public String getName()
	{
		return resume.getJSONObject("basics").getString("name");
	}

	public String getLabel()
	{
		return resume.getJSONObject("basics").getString("label");
	}

	public String getSummary()
	{
		return resume.getJSONObject("basics").getString("summary");
	}

	public int getNumWorkExperience()
	{
		return resume.getJSONArray("work").size();
	}

	public String getWorkExperienceCompany(int num)
	{
		JSONArray work = resume.getJSONArray("work");
		JSONObject item = work.getJSONObject(num);
		return item.getString("company");
	}

	public String getWorkExperienceTitle(int num)
	{
		JSONArray work = resume.getJSONArray("work");
		JSONObject item = work.getJSONObject(num);
		return item.getString("summary");
	}

	public int getNumEducation()
	{
		return resume.getJSONArray("education").size();
	}

	public String getEducationInstitution(int num)
	{
		JSONArray edu = resume.getJSONArray("education");
		JSONObject item = edu.getJSONObject(num);
		return item.getString("institution");
	}

	public String getEducationStudy(int num)
	{
		JSONArray edu = resume.getJSONArray("education");
		JSONObject item = edu.getJSONObject(num);
		return item.getString("studyType");
	}

	public int getNumSkills()
	{
		return resume.getJSONArray("skills").size();
	}

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

	public int getNumProjects()
	{
		return resume.getJSONArray("projects").size();
	}

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
}